# Используйте официальный образ Java
FROM openjdk:21

# Установите рабочий каталог внутри контейнера
WORKDIR /app

# Скопируйте JAR-файл приложения в контейнер
COPY ./build/libs/heavymetal-0.0.1-SNAPSHOT.jar /app

# Укажите порт, который ваше приложение будет слушать
EXPOSE 7777

# Команда для запуска приложения при старте контейнера
CMD ["java", "-jar", "heavymetal-0.0.1-SNAPSHOT.jar"]
