Технологии: Spring Boot, Thymeleaf, JQuery, PostgreSQL  
Можно хранить и добавлять данные о клиентах и их счетах. 
  
# Доступны три страницы:  
- / - список клиентов, при клике по имени показываются балансы имеющихся счетов. Ниже форма для добавления нового клиента;  
- /client - список клиентов и форма для добавления нового счета. При клике по клиенту переводит на следующую страницу:  
- /client/{id} - список счетов заданного клиента.

# Серверная часть состоит из REST-сервисов, доступных по адресу /bank-api  
## **Клиенты**  
*Получение всех клиентов*  
GET: `/bank-api/client`  

*Получение клиента по айди*  
GET: `/bank-api/client/{id}`  

*Получение клиента по имени*  
GET: `/bank-api/client/?name=NAME`  

*Создание клиента*  
POST: `/bank-api/client`  
Пример JSON: `{"name": "me", "phone": "89999999999"}`  

*Удаление клиента*  
DELETE: `/bank-api/client/{id}`  

## **Счета**  
У клиента может быть несколько счетов.  
*Получение всех счетов*  
GET: `/bank-api/account`  

*Получение счета по айди*  
GET: `/bank-api/account/{id}`  

*Получение счета по имени*  
GET: `/bank-api/account/?name=NAME` 

*Создание счета*  
POST: `/bank-api/account`  
Пример JSON:  `{
    "name": "ACCOUNT",
    "balance": "100",
    "client": {
        "id": 1,
        "name": "NAME",
    }
}`  

*Удаление счета*  
DELETE: `bank-api/account/{account_id}`
