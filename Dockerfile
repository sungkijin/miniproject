# 1. Java 21이 포함된 최신 OpenJDK 이미지를 기반으로 사용
FROM eclipse-temurin:21-jdk

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. Gradle로 빌드된 JAR 파일을 컨테이너 내부로 복사
COPY build/libs/*.jar app.jar

# 4. 컨테이너에서 실행될 명령어 지정
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
