# bmall

## 1.如何运行
## 1.1.初始化数据库
数据库初始化脚本在 src/main/resources/init-database.sql. 脚本在MySQL8.0 测试过。
```aidl
mysql> source /path/to/init-database.sql
```
## 1.2 打包
修改数据库连接配置信息
```aidl
mvn package -DskipTests=true
```
## 1.3 运行
```aidl
java -jar target/bmall-0.0.1-SNAPSHOT.jar
或者
mvn spring-boot:run -DskipTests=true
```
在浏览器中输入地址：http://localhost:8900/goods/1
如果能正常看到如下响应，则说明程序运行正常
```json
{"id":1,"name":"iphone 13","price":650000}
```