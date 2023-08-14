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

Use the CURL for Prod:
```sh
curl --location 'https://orange-space-happiness-4wjvwrrpvpg2q446-8080.app.github.dev/identify' \
--header 'authority: orange-space-happiness-4wjvwrrpvpg2q446-8080.app.github.dev' \
--header 'accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8' \
--header 'accept-language: en-GB,en;q=0.6' \
--header 'cache-control: max-age=0' \
--header 'sec-ch-ua: "Not/A)Brand";v="99", "Brave";v="115", "Chromium";v="115"' \
--header 'sec-ch-ua-mobile: ?0' \
--header 'sec-ch-ua-platform: "Windows"' \
--header 'sec-fetch-dest: document' \
--header 'sec-fetch-mode: navigate' \
--header 'sec-fetch-site: none' \
--header 'sec-fetch-user: ?1' \
--header 'sec-gpc: 1' \
--header 'upgrade-insecure-requests: 1' \
--header 'user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "lorrainee@hillvalley.edu",
    "phoneNumber": "123456"
}'
```