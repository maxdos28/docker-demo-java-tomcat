#!/bin/bash

# Spring Boot 应用启动脚本

echo "🚀 Spring Boot Web Application 启动脚本"
echo "======================================"

# 检查Java版本
if ! command -v java &> /dev/null; then
    echo "❌ Java 未安装，请先安装 Java 11+"
    exit 1
fi

JAVA_VERSION=$(java -version 2>&1 | head -1 | cut -d'"' -f2 | sed '/^1\./s///' | cut -d'.' -f1)
if [ "$JAVA_VERSION" -lt 11 ]; then
    echo "❌ Java 版本过低，需要 Java 11+，当前版本: $JAVA_VERSION"
    exit 1
fi

# 检查Maven
if ! command -v mvn &> /dev/null; then
    echo "❌ Maven 未安装，请先安装 Maven 3.6+"
    exit 1
fi

echo "✅ Java 版本: $(java -version 2>&1 | head -1)"
echo "✅ Maven 版本: $(mvn -version | head -1)"
echo ""

# 选择运行模式
echo "请选择运行模式:"
echo "1) 开发模式 (支持热重载)"
echo "2) 生产模式 (打包后运行)"
echo "3) 仅编译"
echo "4) 运行测试"

read -p "请输入选择 (1-4): " choice

case $choice in
    1)
        echo "🔧 启动开发模式..."
        mvn spring-boot:run
        ;;
    2)
        echo "📦 编译打包..."
        mvn clean package -Dmaven.test.skip=true
        if [ $? -eq 0 ]; then
            echo "🚀 启动应用..."
            java -jar target/spring-boot-webapp.jar
        else
            echo "❌ 编译失败"
            exit 1
        fi
        ;;
    3)
        echo "🔨 编译项目..."
        mvn clean compile
        ;;
    4)
        echo "🧪 运行测试..."
        mvn test
        ;;
    *)
        echo "❌ 无效选择"
        exit 1
        ;;
esac