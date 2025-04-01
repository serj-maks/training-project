# Базовый образ с JDK 17
FROM eclipse-temurin:17-jdk

# Указываем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем скомпилированный JAR в контейнер
COPY target/training-project.jar app.jar

# Запускаем приложение
CMD ["java", "-jar", "app.jar"]
