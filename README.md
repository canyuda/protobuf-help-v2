# protobuf-help-v2

用来分析protobuf依赖关系, 并生成指定文件


```bash
java -jar protobuf-help-v2 -i ./input.txt -o ./src -t java -p ./protobuf
```

可选参数

`-h` 查看帮助
`-d` 多打日志
`-l 50` proto文件内前n行找import, 默认:50
`-c <路径>` protoc可执行文件的路径, 默认为:{-p参数指定的路径}/protoc

