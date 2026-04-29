# 第1ステージ: ビルド用（JDK 17 を使用）
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# プロジェクトファイルをすべてコピー
COPY . .

# gradlew に実行権限を与えて、JARファイルを作成
RUN chmod +x gradlew
RUN ./gradlew build -x test

# 第2ステージ: 実行用（より軽量な JRE 17 を使用）
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# 第1ステージで作られた JAR ファイルだけをコピー
# ファイル名が違う場合でも対応できるようにワイルドカード（*）を使っています
COPY --from=build /app/build/libs/*.jar app.jar

# 実行
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]