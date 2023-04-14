# Блог

### Перед запуском проекта
- Скачать MySQL (MySQL Workbench 8.0 CE)
- Скачать Java (openjdk 17.0.2)
- Скачать IDE
- Установить Maven (Apache Maven 3.9.0)

### Для первого запуска проекта
- Подтянуть зависимости мавена (из файла pom.xml)
- Запустить Main файл из src/main/java/main/Main.java

### После первого запуска
- Зайти в application.properties
- Поменять строку `spring.jpa.hibernate.ddl-auto=create` на `spring.jpa.hibernate.ddl-auto=none`

#### Это необходимо, чтобы бд не создавалась каждый раз при запуске приложения
