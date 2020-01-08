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
import java.util.Set;
import java.util.stream.Collectors;

/**
 * CreateUser: canyuda
 * CreateTime: 2020/1/8 16:45
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        Options opts = new Options();
        Option help = Option.builder(Config.HELP).desc("帮助文档").optionalArg(false).build();
        Option iop = Option.builder(Config.INPUT_FILE_PATH).hasArg().argName("文件路径").desc("输入文件").optionalArg(true).build();
        Option oop = Option.builder(Config.OUT_PUT_DIR_PATH).hasArg().argName("文件夹路径").desc("输出文件夹").optionalArg(true).build();
        Option gyop = Option.builder(Config.GENERATE_TYPE).hasArg().argName("(java|javanano|cpp|csharp|python|ruby|objc|js)").desc("生成文件类型").optionalArg(true).build();
        Option protoOp = Option.builder(Config.PROTOBUF_DIR_PATH).hasArg().argName("protobuf文件目录").desc("protobuf文件目录").optionalArg(true).build();
        opts.addOption(iop);
        opts.addOption(oop);
        opts.addOption(gyop);
        opts.addOption(help);
        opts.addOption(protoOp);
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
                    Set<String> inputData = getInputData(inputFile);


                    System.out.println("input " + inputFilePath);
                    System.out.println("output " + outputDirPath);
                    System.out.println("proto " + protoDirPath);
                    System.out.println("type " + generateTypeEnum);
                }
            } else {
                System.err.println("请输入参数");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("处理失败");
        }

    }

    private static Set<String> getInputData(File inputFile) throws FileNotFoundException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            return bufferedReader.lines()
                    .filter(s -> s.length() > 0)
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
