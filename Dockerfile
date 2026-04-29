# Java 17 が入った軽量な環境を準備
FROM eclipse-temurin:17-jre-alpine

# 作業フォルダを作成
WORKDIR /app

# ビルド済みのJARファイルをコピー
# ※もしファイル名が違う場合は、ここの名前を書き換えてください
COPY build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

# ポート番号をRenderの指定（PORT）に合わせて実行
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]