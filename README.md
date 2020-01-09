# protobuf-help-v2

用来分析protobuf依赖关系, 并生成指定文件

## 背景

使用protobuf编写服务的request和response, 每个服务对应一个目录来保存对外接口的请求和响应, 当其他服务需要调用该服务接口时, 引用这个服务对应目录下面的proto编译即可. 如果一个服务特别庞大, 对接很多其他的服务, 会导致它要引用很多服务的proto文件

本工具用来生成某个特定的proto文件以及他的依赖的代码.

## 启动

```bash
java -jar ./protobuf-help-v2.jar -i ./input.txt -o ./dest -t java -p ./protobuf
```

## 其他可选参数

`-h` 查看帮助
`-d` 多打日志
`-l 50` proto文件内前n行找import, 默认:50
`-c <路径>` protoc可执行文件的路径, 默认为:{-p参数指定的路径}/protoc

