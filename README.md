# Docker Demo Spring Boot Application

一个基于**Spring Boot 3.5.5**和**context7最佳实践**重构的现代化Java Web应用，支持JAR包运行和Docker容器化部署。

## 🚀 项目特性

- **Spring Boot 3.5.5**: 使用最新的Spring Boot框架
- **Context7架构**: 遵循context7 MCP文档的最佳实践
- **现代化API**: RESTful API设计，统一响应格式
- **完整监控**: Micrometer + Prometheus metrics集成
- **分层架构**: Controller -> Service -> DTO分层设计
- **全面测试**: 单元测试和集成测试覆盖
- **Docker优化**: 多阶段构建，安全容器运行
- **配置管理**: 环境特定的配置文件

## 📋 API端点

### 应用端点
- `GET /api/v1/` - 应用信息（包含运行时数据）
- `GET /api/v1/health` - 健康检查端点
- `GET /api/v1/metrics` - 指标信息

### 监控端点
- `GET /actuator/health` - Spring Boot健康检查
- `GET /actuator/info` - 应用详细信息
- `GET /actuator/metrics` - 应用指标
- `GET /actuator/prometheus` - Prometheus格式指标

## 🛠️ 技术栈

### 核心技术
- **Java 17** - LTS版本，现代化Java特性
- **Spring Boot 3.5.5** - 最新Spring Boot框架
- **Maven 3.x** - 项目构建管理
- **Jakarta EE** - 企业级Java标准

### 监控与指标
- **Micrometer** - 应用指标收集
- **Prometheus** - 指标存储和监控
- **Spring Boot Actuator** - 生产就绪特性

### 测试框架
- **JUnit 5** - 单元测试框架
- **Spring Boot Test** - 集成测试支持
- **Testcontainers** - 容器化测试

### 容器化
- **Docker** - 容器化部署
- **Multi-stage Build** - 优化镜像构建
- **Alpine Linux** - 轻量级运行时镜像

## 🚀 快速开始

### 本地运行

```bash
# 方式1: 使用构建脚本
./build-and-run.sh

# 方式2: Maven命令
mvn clean package -DskipTests
java -jar target/docker-demo-spring-boot-1.0.0.jar

# 方式3: Maven Spring Boot插件
mvn spring-boot:run
```

### Docker运行

```bash
# 构建Docker镜像
docker build -t daocloud.io/docker-demo-spring-boot .

# 运行容器
docker run -p 8080:8080 daocloud.io/docker-demo-spring-boot

# 运行并查看日志
docker run -p 8080:8080 --name spring-demo daocloud.io/docker-demo-spring-boot
```

### 测试运行

```bash
# 运行所有测试
mvn test

# 运行特定测试类
mvn test -Dtest=HomeControllerTest
```

## 📊 监控和指标

应用启动后，可以访问以下监控端点：

```bash
# 健康检查
curl http://localhost:8080/actuator/health

# 应用信息（包含JVM、内存、运行时间等）
curl http://localhost:8080/api/v1/

# Prometheus指标
curl http://localhost:8080/actuator/prometheus
```

## 🏗️ 项目结构

```
src/
├── main/java/io/daocloud/demo/
│   ├── DemoApplication.java          # 主启动类
│   ├── controller/
│   │   └── HomeController.java       # REST控制器
│   ├── service/
│   │   └── ApplicationInfoService.java # 业务服务层
│   ├── dto/
│   │   ├── ApiResponse.java          # API响应DTO
│   │   └── HealthResponse.java       # 健康检查DTO
│   └── config/
│       ├── ApplicationConfig.java    # 应用配置
│       └── MetricsConfig.java        # 指标配置
├── main/resources/
│   └── application.properties        # 应用配置文件
└── test/java/io/daocloud/demo/
    ├── DemoApplicationTests.java     # 集成测试
    └── controller/
        └── HomeControllerTest.java   # 控制器单元测试
```

## 🔧 配置说明

### 环境配置
- `application.properties` - 默认配置
- `application-test.properties` - 测试环境配置

### 关键配置项
- **服务器端口**: `server.port=8080`
- **应用名称**: `spring.application.name=docker-demo-spring-boot`
- **指标导出**: `management.endpoints.web.exposure.include=health,info,metrics,prometheus`
- **日志级别**: `logging.level.io.daocloud.demo=INFO`

## 📈 基于Context7的改进

本项目完全基于context7 MCP文档进行重构，包含以下改进：

1. **分层架构**: 严格的Controller-Service-DTO分层
2. **统一响应**: 标准化的API响应格式
3. **完整监控**: 集成Micrometer和Prometheus
4. **配置优化**: 生产就绪的配置管理
5. **测试覆盖**: 全面的单元测试和集成测试
6. **容器安全**: 非root用户运行，多阶段构建
7. **文档完善**: 详细的API文档和使用说明

这个重构版本展现了现代Spring Boot 3.5.5应用的最佳实践！
