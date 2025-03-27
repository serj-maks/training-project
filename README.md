# training-project
project for training, which use
- java
- spring
- spring boot
- spring data jpa
- hibernate
- mupstruct
- jakarta-validation 
- lombok


## небольшая подсказка по архитектуре
db -> repository -> service -> controller (для сущности dog в контроллере используем dao + mapper)


## как запустить
- запустить бд mysql в докере с настройками, указанными в application.yml
т.е. создать бд с именем testdb, логином (root) и паролем (password). Создавать таблицы в бд не нужно,
hibernate сделает это сам
- если все ок, приложение стартует без ошибок
- теперь можно подергать рестики, например в postman
здесь указаны URL'лы для сущности dog, для cat см. в классе CatController.java
 
GET 
- `http://localhost:8080/dog/1`

GET (get all) 
- `http://localhost:8080/dog`
 
POST 
- http://localhost:8080/dog
```json
{
    "name": "Fluffy",
    "age": 4
}
```

PUT 
- http://localhost:8080/dog/1
```json
{
    "name": "YoungFluffy",
    "age": 2
}
```

DELETE 
- http://localhost:8080/dog/1


## 01
работа с сущностью cat максимально примитивная


## 01
работа с сущностью dog уже по-сложнее - используется dto+маппинг при помощи mapstruct


## actuator
- настраивается в application.yml
- чтобы попасть в актуатор, после запуска приложения перейди по ссылке `http://localhost:8080/actuator`
- документация по настройкам [тут](https://docs.spring.io/spring-boot/reference/actuator/endpoints.html)
