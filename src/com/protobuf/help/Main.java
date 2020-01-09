package com.protobuf.help;

import com.protobuf.help.constrat.Config;
import com.protobuf.help.enums.GenerateTypeEnum;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * CreateUser: canyuda
 * CreateTime: 2020/1/8 16:45
 * Description:
 */
public class Main {

    private static final String SOURCE_SUFFIX = ".proto";
    private static final String PATTERN = "import \"(.*)\";";
    private static final List<String> IGNORE_FILE = Arrays.asList(".git", ".gitkeep", "test.txt");

    public static void main(String[] args) {
        Options opts = new Options();
        Option help = Option.builder(Config.HELP).desc("帮助文档").optionalArg(false).build();
        Option iop = Option.builder(Config.INPUT_FILE_PATH).hasArg().argName("文件路径").desc("输入文件").optionalArg(true).build();
        Option oop = Option.builder(Config.OUT_PUT_DIR_PATH).hasArg().argName("文件夹路径").desc("输出文件夹").optionalArg(true).build();
        Option gyop = Option.builder(Config.GENERATE_TYPE).hasArg().argName("(java|javanano|cpp|csharp|python|ruby|objc|js)").desc("生成文件类型").optionalArg(true).build();
        Option protoOp = Option.builder(Config.PROTOBUF_DIR_PATH).hasArg().argName("protobuf文件目录").desc("protobuf文件目录").optionalArg(true).build();
        Option impLimit = Option.builder(Config.IMPORT_LIMIT).hasArg().argName("数字").desc("检索proto文件中import的限制, 避免全文扫描, 默认50, import请写在50行以内").optionalArg(true).build();
        Option ProtocPathOp = Option.builder(Config.PROTOC_PATH).hasArg().argName("protoc程序路径").desc("protoc程序路径, 默认为:{protobuf文件目录}/protoc").optionalArg(true).build();
        Option dbgOP = Option.builder(Config.DEBUG).hasArg(false).desc("debug开关").build();
        opts.addOption(iop);
        opts.addOption(oop);
        opts.addOption(gyop);
        opts.addOption(help);
        opts.addOption(protoOp);
        opts.addOption(dbgOP);
        opts.addOption(impLimit);
        opts.addOption(ProtocPathOp);
        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine commandLine = parser.parse(opts, args);
            if (commandLine.getOptions().length > 0) {
                if (commandLine.hasOption(Config.HELP)) {
                    HelpFormatter hf = new HelpFormatter();
                    hf.printHelp("java -jar protobuf-help-v2.jar", opts);
                } else if (commandLine.hasOption(Config.INPUT_FILE_PATH) &&
                        commandLine.hasOption(Config.OUT_PUT_DIR_PATH) &&
                        commandLine.hasOption(Config.GENERATE_TYPE) &&
                        commandLine.hasOption(Config.PROTOBUF_DIR_PATH)) {
                    String inputFilePath = commandLine.getOptionValue(Config.INPUT_FILE_PATH);
                    String outputDirPath = commandLine.getOptionValue(Config.OUT_PUT_DIR_PATH);
                    String generateType = commandLine.getOptionValue(Config.GENERATE_TYPE);
                    String protoDirPath = commandLine.getOptionValue(Config.PROTOBUF_DIR_PATH);
                    String protocPath = commandLine.getOptionValue(Config.PROTOC_PATH, protoDirPath + File.separator + "protoc");
                    boolean isDebug = commandLine.hasOption(Config.DEBUG);
                    Integer importFindLimit = Integer.valueOf(commandLine.getOptionValue(Config.IMPORT_LIMIT, "50"));
                    GenerateTypeEnum generateTypeEnum = GenerateTypeEnum.parser(generateType);
                    File inputFile = new File(inputFilePath);
                    if (!inputFile.exists() || !inputFile.isFile()) {
                        System.err.println("没有找到输入文件, in " + inputFile.getAbsolutePath());
                        return;
                    }
                    File outPutDirFile = new File(outputDirPath);
                    if (!outPutDirFile.exists() || !outPutDirFile.isDirectory()) {
                        System.err.println("没有找到出文件夹, in " + outPutDirFile.getAbsolutePath());
                        return;
                    }
                    File protoDirFile = new File(protoDirPath);
                    if (!protoDirFile.exists() || !protoDirFile.isDirectory()) {
                        System.err.println("没有找到proto文件夹, in " + protoDirFile.getAbsolutePath());
                        return;
                    }
                    if (generateTypeEnum == null) {
                        System.err.println("生成文件类型输入错误, 请输入(java|javanano|cpp|csharp|python|ruby|objc|js)");
                        return;
                    }
                    // 1. 读取 inputFilePath
                    System.out.println("开始读取input文件");
                    Set<String> inputData = getInputData(inputFile);
                    System.out.println("文件读取完毕, 输入任务数:" + inputData.size() + ", 开始计算依赖关系");
                    Stack<String> stack = new Stack<>();
                    stack.addAll(inputData);
                    Set<String> protoFileSet = new HashSet<>();
                    long startTime0 = System.currentTimeMillis();
                    while (!stack.empty()) {
                        String path = stack.pop();
                        String absoluteFilePath = protoDirPath + File.separator + path;
                        File file = new File(absoluteFilePath);
                        if (!file.exists()) {
                            System.err.println("未找到文件或目录: " + absoluteFilePath);
                            continue;
                        }
                        if (file.isFile()) {
                            if (file.getName().endsWith(SOURCE_SUFFIX)) {
                                List<String> list = getImportProto(file, importFindLimit);
                                list.forEach(stack::push);
                                if (!protoFileSet.contains(path)) {
                                    protoFileSet.add(path);
                                    if (isDebug) {
                                        System.out.println("文件: " + path + ", 处理完成, 文件依赖数:" + list.size());
                                    }
                                }
                            } else if (IGNORE_FILE.stream().anyMatch(path::contains)) {
                                continue;
                            } else {
                                System.err.println("不合法的文件格式: " + absoluteFilePath);
                                continue;
                            }
                        } else if (file.isDirectory()) {
                            String[] list = file.list();
                            if (list != null) {
                                Arrays.stream(list).filter(i -> !IGNORE_FILE.contains(i)).map(s -> path + File.separator + s).forEach(stack::push);
                            }
                            System.out.println("目录: " + path + ", 处理完成, 目录下文件数: " + (list != null ? list.length : 0));
                        } else {
                            System.err.println("未知的文件类型: " + absoluteFilePath);
                            continue;
                        }
                    }
                    long endTime0 = System.currentTimeMillis();
                    double timeLength0 = (double) (endTime0 - startTime0) / 1000;
                    System.out.println("分析依赖关系完成, 开始编译proto, 文件数:" + protoFileSet.size() + ", 分析用时:" + timeLength0 + "s");
                    long startTime = System.currentTimeMillis();
                    generateProtoToOutPutDir(protoFileSet, outputDirPath, protoDirPath, generateTypeEnum, protocPath);
                    long endTime = System.currentTimeMillis();
                    double timeLength = (double) (endTime - startTime) / 1000;
                    System.out.println("编译完成, 编译用时:" + timeLength + "s");
                }
            } else {
                System.err.println("请输入参数");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("处理失败");
        }
    }

    /**
     * 执行命令生成
     *
     * @param protoFileSet
     * @param outputDirPath
     * @param generateTypeEnum
     */
    private static void generateProtoToOutPutDir(Set<String> protoFileSet, String outputDirPath, String protoDir, GenerateTypeEnum generateTypeEnum, String protocPath) {
        protoFileSet.parallelStream().forEach(shortName -> {
            try {
                Process ps = Runtime.getRuntime().exec(protocPath + " " + protoDir + File.separator + shortName + " " + generateTypeEnum.getProtocOutDir() + outputDirPath + " --proto_path=" + protoDir);
                InputStream in = ps.getErrorStream();
                BufferedReader tBufferedReader = new BufferedReader(new InputStreamReader(in));
                String sTempOneLine;
                while ((sTempOneLine = tBufferedReader.readLine()) != null) {
                    System.err.println(sTempOneLine + "\r\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 通过proto文件获取依赖的proto
     *
     * @param file
     * @param importFindLimit
     * @return
     */
    private static List<String> getImportProto(File file, Integer importFindLimit) throws FileNotFoundException {
        BufferedReader reader = null;
        Pattern pattern = Pattern.compile(PATTERN);
        try {
            reader = new BufferedReader(new FileReader(file));
            return reader.lines()
                    .map(String::trim)
                    .filter(s -> s.length() > 0)
                    .limit(importFindLimit)
                    .filter(input -> pattern.matcher(input).find())
                    .map(input -> {
                        Matcher matcher = pattern.matcher(input);
                        if (matcher.find()) {
                            return matcher.group(1);
                        } else {
                            return "";
                        }
                    })
                    .filter(s -> s.length() > 0)
                    .collect(Collectors.toList());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    /**
     * 按行读取input文件内容
     * # 注释
     *
     * @param inputFile
     * @return
     * @throws FileNotFoundException
     */
    private static Set<String> getInputData(File inputFile) throws FileNotFoundException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            return bufferedReader.lines()
                    .map(String::trim)
                    .filter(s -> s.length() > 0)
                    .filter(s -> !s.trim().startsWith("#"))
                    .collect(Collectors.toSet());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ignore) {
            }
        }
    }
}
