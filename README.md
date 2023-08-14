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
--header 'Cookie: .Tunnels.Relay.WebForwarding.Cookies=CfDJ8PPN7pkBqn9PhQKqQ8YNxVzfzesxSlx7kYN6_6hTuE8aknO0nVDL9aNvwMzCMjzQzH8FxznoFAMdeil3Uc2Tg4SE6Xn8vNy0XYv4X3EO4FCxQmj9sKuWgk6YL02P2zE5UK4OddF-bfGazIWJY77yr_ezOHSmLvm3Kinw-YzdaK7uhdPjE4PGohLpgyKiSfZleYzvicjMQp6KXIT-g4U_ZwtG1Lb7suBhTKMeGV6ibfkTh0egbLf1Y10ScaM97CotC2MUeA3aSl0bQlCIm1-9stjBjOHSQqsTUYZNcO5BwborxfKXHmlfX2zfcEsohorpTO0OOIOnXAUSETDGCveFGEI4nJ0-V4oM6Jh03nB26ajGfrj92p0z4z7lOUpf_r9_O2SnlgRRXOHcHIHgTYPW3E7wMM9FrJMhX2Az2yU2JErYcZ7mvFf-F63FcqkOZ3-WhTHj6bVZb_WVCZfI5kfdczbHmooH9gjcb3w2u43XYiIQQNAkZ2L2g7_ppJdJ4xtwYZV9uMIwQat20SORAFQZLT8M-jCeUgd3v-9TvsLaxQ6qWOpEH3EZX1_uZFCc9FhsToeCrbCYSOv4sDcxIBLu3Yjj0dfh0q-k_Dpkf3fEfUJ60EN8chZTS4TwjZkvRRZtCxhlAvjdmXanLU5xo4D7d9o303BmnacwanAi4mSfPISUIWQA6aVoVBiBsRrUg85wMFW3SxkcBEhP0TppEQuK9MlQ8NL81X_LKZEO3WIQrOK6_J8-2x1xv9UmqTXuDDlWb0F4JdiZ8GSusXXxl6k-kXGuutEBIuMof9bHr4iLOaqt6bgJXe9J3Evj1bSHCivD7xbG82ZG01q3ez8ZR3qApgMSd52qZNCa1z45VCLeoDDkSEuf5V4hfo_bBsI-4xq8KrRFi26GbWevXRjdJnSabruO50TUg0MMUNqxX7Fv0uDZguDPXFJkQQzi0OrMU5L8Vw'
```

Use the CURL for Prod (This POST request gets Create the Contact as a List):
```sh
curl --location 'https://orange-space-happiness-4wjvwrrpvpg2q446-8080.app.github.dev/identify' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "mcfly@hillvalley.edu",
    "phoneNumber": "123456"
}'
```