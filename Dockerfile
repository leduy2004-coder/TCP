# Bước 1: Sử dụng một image Maven có sẵn để xây dựng ứng dụng
FROM maven:3.8.4-jdk-11 AS build

# Bước 2: Sao chép mã nguồn vào container
WORKDIR /app
COPY . /app

# Bước 3: Chạy lệnh Maven để build dự án
RUN mvn clean install -DskipTests

# Bước 4: Sử dụng image Java để chạy ứng dụng
FROM openjdk:11-jre-slim

# Bước 5: Sao chép file JAR đã build vào container
COPY --from=build /app/target/your-app-name.jar /app/your-app-name.jar

# Bước 6: Expose cổng mà ứng dụng sẽ chạy
EXPOSE 8080

# Bước 7: Chạy ứng dụng khi container khởi động
CMD ["java", "-jar", "/app/your-app-name.jar"]
