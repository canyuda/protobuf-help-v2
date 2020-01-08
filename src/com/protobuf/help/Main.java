package com.protobuf.help;

import com.protobuf.help.constrat.Config;
import com.protobuf.help.enums.GenerateTypeEnum;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.io.File;

/**
 * CreateUser: canyuda
 * CreateTime: 2020/1/8 16:45
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        Options opts = new Options();
        Option help = Option.builder(Config.HELP).desc("帮助文档").optionalArg(false).build();
        Option iop = Option.builder(Config.INPUT_FILE_PATH).hasArg().argName("文件路径").desc("输入文件").longOpt("input").optionalArg(true).build();
        Option oop = Option.builder(Config.OUT_PUT_DIR_PATH).hasArg().argName("文件夹路径").desc("输出文件夹").longOpt("output").optionalArg(true).build();
        Option gy = Option.builder(Config.GENERATE_TYPE).hasArg().argName("(java|javanano|cpp|csharp|python|ruby|objc|js)").longOpt("generate").desc("生成文件类型").optionalArg(true).build();
        opts.addOption(iop);
        opts.addOption(oop);
        opts.addOption(gy);
        opts.addOption(help);
        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine commandLine = parser.parse(opts, args);
            if (commandLine.getOptions().length > 0) {
                if (commandLine.hasOption(Config.HELP)) {
                    HelpFormatter hf = new HelpFormatter();
                    hf.printHelp("java -jar protobuf-help-v2.jar", opts);
                } else if (commandLine.hasOption(Config.INPUT_FILE_PATH) &&
                        commandLine.hasOption(Config.OUT_PUT_DIR_PATH) &&
                        commandLine.hasOption(Config.GENERATE_TYPE)) {
                    String inputFilePath = commandLine.getOptionValue(Config.INPUT_FILE_PATH);
                    String outputDirPath = commandLine.getOptionValue(Config.OUT_PUT_DIR_PATH);
                    String generateType = commandLine.getOptionValue(Config.GENERATE_TYPE);
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
                    if (generateTypeEnum == null) {
                        System.err.println("生成文件类型输入错误, 请输入(java|javanano|cpp|csharp|python|ruby|objc|js)");
                        return;
                    }

                }
            } else {
                System.err.println("请输入参数");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
