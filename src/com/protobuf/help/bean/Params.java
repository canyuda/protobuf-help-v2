package com.protobuf.help.bean;

/**
 * CreateUser: canyuda
 * CreateTime: 2020/1/8 16:53
 * Description:
 */
public class Params {

    private String inputFilePath; // 输入文件路径
    private String generateType; // java, c++ , python, ruby, objc, js, c#, c++, javanano
    private String outPutDirPath;  // 输出文件夹路径

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String getGenerateType() {
        return generateType;
    }

    public void setGenerateType(String generateType) {
        this.generateType = generateType;
    }

    public String getOutPutDirPath() {
        return outPutDirPath;
    }

    public void setOutPutDirPath(String outPutDirPath) {
        this.outPutDirPath = outPutDirPath;
    }
}
