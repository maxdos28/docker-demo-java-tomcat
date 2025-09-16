# Docker Demo Spring Boot Application

一个基于Spring Boot 3.5.5的现代化Java Web应用，支持JAR包运行和Docker容器化部署。

## 项目特性

- **Spring Boot 3.5.5**: 使用最新的Spring Boot框架
- **JAR包运行**: 可执行JAR包，无需外部应用服务器
- **Docker支持**: 多阶段构建，优化镜像大小
- **健康检查**: 内置Actuator健康检查端点
- **安全性**: 使用非root用户运行容器

## 快速开始

### 本地运行

```bash
# 构建并运行应用
./build-and-run.sh

# 或者手动执行
mvn clean package -DskipTests
java -jar target/docker-demo-spring-boot-1.0.0.jar
```

### Docker运行

```bash
# 构建Docker镜像
docker build -t daocloud.io/docker-demo-spring-boot .

# 运行容器
docker run -p 8080:8080 daocloud.io/docker-demo-spring-boot
```

## API端点

- `GET /` - 主页面，返回JSON格式的应用信息
- `GET /health` - 健康检查端点
- `GET /actuator/health` - Spring Boot Actuator健康检查

## 技术栈

- Java 17
- Spring Boot 3.5.5
- Maven 3.x
- Docker
- Alpine Linux (运行时镜像)
