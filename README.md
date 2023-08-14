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
curl --location 'https://orange-space-happiness-4wjvwrrpvpg2q446-8080.app.github.dev/contacts' \
```

Use the CURL for Prod (This POST request gets Create the Contact as a List):
```sh
curl --location 'https://orange-space-happiness-4wjvwrrpvpg2q446-8080.app.github.dev/identify' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "lorraine@hillvalley.edu",
    "phoneNumber": "123456"
}'
```