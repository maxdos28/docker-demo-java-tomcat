# Spring Boot Web Application

一个现代化的Spring Boot Web应用，使用JAR包启动方式，内嵌Tomcat服务器。

## 项目特性

- 🚀 Spring Boot 2.7.12
- 📦 JAR包启动，无需外部Tomcat
- 🎨 Thymeleaf模板引擎
- 🔧 Spring Boot DevTools热重载
- ✅ 完整的单元测试
- 🌐 RESTful API支持

## 项目结构

```
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── Application.java              # 主启动类
│   │   │   └── controller/
│   │   │       └── HomeController.java       # 控制器
│   │   └── resources/
│   │       ├── templates/
│   │       │   └── index.html               # Thymeleaf模板
│   │       └── application.properties       # 配置文件
│   └── test/
│       └── java/com/example/demo/
│           ├── ApplicationTests.java        # 应用测试
│           └── controller/
│               └── HomeControllerTest.java  # 控制器测试
├── pom.xml                                  # Maven配置
└── README.md                               # 项目说明
```

## 快速开始

### 环境要求

- Java 11+
- Maven 3.6+

### 运行应用

1. **克隆项目**
   ```bash
   git clone <repository-url>
   cd spring-boot-webapp
   ```

2. **编译项目**
   ```bash
   mvn clean compile
   ```

3. **运行测试**
   ```bash
   mvn test
   ```

4. **启动应用**
   ```bash
   mvn spring-boot:run
   ```
   
   或者打包后运行：
   ```bash
   mvn clean package
   java -jar target/spring-boot-webapp.jar
   ```

### 访问应用

- 主页: http://localhost:8080
- 健康检查: http://localhost:8080/api/health

## 开发指南

### 开发模式

使用Spring Boot DevTools，代码修改后会自动重启应用：

```bash
mvn spring-boot:run
```

### 添加新功能

1. 在 `src/main/java/com/example/demo/controller/` 下添加新的控制器
2. 在 `src/main/resources/templates/` 下添加对应的HTML模板
3. 在 `src/test/java/com/example/demo/` 下添加相应的测试类

### 配置修改

修改 `src/main/resources/application.properties` 文件来调整应用配置。

## 部署

### 生产环境部署

1. **打包应用**
   ```bash
   mvn clean package -Dmaven.test.skip=true
   ```

2. **运行JAR包**
   ```bash
   java -jar target/spring-boot-webapp.jar
   ```

3. **指定配置文件**
   ```bash
   java -jar target/spring-boot-webapp.jar --spring.config.location=application-prod.properties
   ```

### 系统服务

创建systemd服务文件 `/etc/systemd/system/spring-boot-webapp.service`:

```ini
[Unit]
Description=Spring Boot Web Application
After=network.target

[Service]
Type=simple
User=app
ExecStart=/usr/bin/java -jar /opt/app/spring-boot-webapp.jar
Restart=always
RestartSec=10

[Install]
WantedBy=multi-user.target
```

## 技术栈

- **框架**: Spring Boot 2.7.12
- **Web**: Spring Web MVC
- **模板引擎**: Thymeleaf
- **内嵌服务器**: Tomcat
- **构建工具**: Maven
- **测试框架**: JUnit 5 + Spring Boot Test

## 重构说明

本项目从传统的WAR包部署重构为现代化的Spring Boot JAR包应用：

- ✅ 移除了Docker配置，简化部署
- ✅ 从WAR包改为JAR包，内嵌Tomcat
- ✅ 使用Thymeleaf替代JSP
- ✅ 添加了完整的测试覆盖
- ✅ 现代化的Maven配置
- ✅ 支持热重载开发

## 许可证

MIT License