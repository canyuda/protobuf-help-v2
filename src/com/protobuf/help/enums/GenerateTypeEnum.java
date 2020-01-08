package com.protobuf.help.enums;

/**
 * CreateUser: canyuda
 * CreateTime: 2020/1/8 16:59
 * Description:
 */
public enum GenerateTypeEnum {
    JAVA("java", "--java_out="),
    JAVA_NANO("javanano", "--javanano_out="),
    C_PLUS("cpp", "--cpp_out="),
    C_SHARP("csharp", "--csharp_out="),
    PYTHON("python", "--python_out="),
    RUBY("ruby", "--ruby_out="),
    OBJC("objc", "--objc_out="),
    JS("js", "--js_out="),
    ;

    private String protocOutDir;

    private String paramName;

    GenerateTypeEnum(String paramName, String protocOutDir) {
        this.protocOutDir = protocOutDir;
        this.paramName = paramName;
    }

    public String getProtocOutDir() {
        return protocOutDir;
    }

    public String getParamName() {
        return paramName;
    }

    public static GenerateTypeEnum parser(String paramName) {
        for (GenerateTypeEnum value : GenerateTypeEnum.values()) {
            if (value.getParamName().equals(paramName)) {
                return value;
            }
        }
        return null;
    }

}
