# Getting Started

* Java Version 17
* DATABASE in memory H2

# Requisites
* API REST Client example (https://www.postman.com/, https://insomnia.rest/)

# Docker
* Generate Jar file in project with Maven Install
* docker build -t fmsp/tikets .
* docker run -d -p 8080:8090 fmsp/tikets

# EndPoints

### create-ticket
* [request POST] (http://localhost:8090/tikets/v1/create-ticket)
 -- header 'Content-Type: application/json' \
 -- data '{
      "user": "Tiket 1",
      "status": "abierto"
      }'

### list-ticket
* [request POST] (http://localhost:8090/tikets/v1/list-ticket)
  --header 'Content-Type: application/json' \
  --data '{
        "filters": [
           {
           "key": "status",
           "operator": "EQUAL",
           "field_type": "STRING",
           "value": "cerrado"
          }
        ],
        "sorts": [],
        "page": 0,
        "size": 10
        }'
* Example filters:
  "key": "user",
  "operator": "EQUAL",
  "field_type": "STRING",
  "value": "Tiket 1"

* [more about criteria] (https://reflectoring.io/spring-data-specifications/)

### edit-ticket
* [request PUT] (http://localhost:8090/tikets/v1/edit-ticket)
  --header 'Content-Type: application/json' \
  --data '	{
    "id": 2,
    "user": "Tiket Importante hoy",
    "status": "cerrado"
  }'


### edit-ticket
* [request DELETE] (http://localhost:8090/tikets/v1/delete-ticket/{ticketId})
