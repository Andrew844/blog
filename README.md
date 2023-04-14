# Блог

### Перед запуском проекта
- Скачать Mysql
- Скачать Java
- Скачать ide
- Установить maven

### Для первого запуска проекта
- Подтянуть зависимости мавена (из файла pom.xml)
- Запустить Main файл из src/main/java/main/Main.java

### После первого запуска
- Зайти в application.properties
- Поменять строку `spring.jpa.hibernate.ddl-auto=create` на `spring.jpa.hibernate.ddl-auto=none`

#### Это необходимо, чтобы бд не создавалась каждый раз при запуске приложения
