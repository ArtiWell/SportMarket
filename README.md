# SportMarket
Проект на свободную тему для компании Digital Chief.

CRM для магазина спортивных товаров.
## Запуск программы:
В папке с проектом выполить в консоле команду ```docker-compose up -d```
### Swagger 
```http://localhost:8080/api/v1/swagger-ui/index.html```
### BD 
URL - ```jdbc:postgresql://localhost:5432/postgres```

user - ```postgres```

## Схема BD: 

 ![alt text](https://cdn.discordapp.com/attachments/1062136517654499379/1121168873132146688/2023-06-21_23_03_32-Window.png)
 
## Описание

CRM магазина спортивных товаров может получить список всех продуктов и список всех клиентов,

<details><summary>/products/all</summary>
  {
  "page": 1,
  "size": 5 
} 
  </details>
  
  
  <details><summary>//client/all</summary>
  {
  "page": 1,
  "size": 5 
} 
  </details>
  
  lifeSearch продукт по наименованию и клиента по firstame,
  
  <details><summary>/products/search</summary>
  name:Протеин
  {
  "page": 1,
  "size": 5 
  }
   </details>
   
  <details><summary>/client/search</summary>
  firstName:Виктор
  {
  "page": 1,
  "size": 5 
  }
  </details>
  
  добавить нового клиента и добавить новый заказ,
  
  <details><summary>/client/add</summary>
  {
  "firstName": "Артем",
  "secondName": "Столяров",
  "status": true
}
   </details>
   
   <details><summary>/orders/add</summary>
  {
  "vendorCode": 2,
  "clientUuid": "423725b8-66bc-4151-bd99-ab5664ef073b",
  "count": 10
}
   </details>
  
 изменить статус заказа при выполнении заказа,
 
 <details><summary>/orders/changeStatus</summary>
  {
  "code": тот, что сгенерировался при добавлении заказа,
  "status": "DONE"
}
   </details>
 
  удалить заказ 
  
   <details><summary>/orders</summary>
  {
  "code": тот, что сгенерировался при добавлении заказа
}
   </details>
   
   и посмотреть все заказы по UUID клиента
   
   <details><summary>/orders/client</summary>
  {
  "uuid": "423725b8-66bc-4151-bd99-ab5664ef073b"
}
   </details>
  
  
  
  
