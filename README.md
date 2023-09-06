# Backend-Assignment_Bitespeed

### Follow the steps to run the application (Install Docker first):

Run: 
```sh
docker compose up --build
```

Use the CURL for LocalHost:
```sh
curl --location 'localhost:8080/identify' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "lorraine@hillvalley.edu",
    "phoneNumber": "123456"
}'
```

Use the CURL for Prod (This GET request gets all the contacts as a List):
```sh
curl --location 'https://backend-assignment-34db.onrender.com/contacts' \
```

Use the CURL for Prod (This POST request gets Create the Contact as a List):
```sh
curl --location 'https://backend-assignment-34db.onrender.com/identify' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "lorraine@hillvalley.edu",
    "phoneNumber": "123456"
}'
```
