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
--header 'cookie: tunnel_phishing_protection=1wnvw8pq.asse; .Tunnels.Relay.WebForwarding.Cookies=CfDJ8PPN7pkBqn9PhQKqQ8YNxVx_DSdV9vm5hb9g9oJSJFghqYqW-k3trrwRSs_mg6-r-aHYj_xZ-fvIHxYYvNuFoqQYqUcQWpeLVteQl4KyOu5Are0AQPbC7fI9blxwoNBsnhhcT3NwW13-tevqVi3_iqpil-8rzPRbEqKcCRj0toAlfpQCf-kY0ITCetAb2wGNtnQ55g1NT4L7aFdhMElEPxLZp2Jgyon831lv2QVt7kmOhbbMyhCWDwQsbIpM5RJojhaOkzCGRmnaKWsEWE0TDqU5TXPwDzOGd4FptgAARhlFex-7YJCwA01Q9kL0ydM_ShrPYSEYAxlVlKVsFmG55M_Rbt90stYsExYwpBLZQNt0L3_1_n_vmdbnHyNZu3GGzDpOpCMVewA_cXmw1y0D0mx7s7L5JRX6yVCT10SBkRJ6BmrKMCqm5Bqtw73e2VACrtJ-ZCJEdQjLN1TX1ETquRpLuwbXFFi2uSzq7O93HxKQn6XritwSlZZwnJI6YlddLURTCxwwaxzqllhRt5UmCblph3o1HLTELBVL-w_E-BD54nMxoJ4b_IO6jV4V6KT_a2T-DCL3p2Je7LtzRDDNrLQHm-rxUmFKH1JxToR0R3qjaiwC6RRrWaTluE9_loAEayaa_4PbYQwDoDWFKUWkqHXag2oFiwiqtIKHSskbzRsCkntFCBmomi0qmgeDjEuODUZBOMeG66iNC8GcAs9bORbT2-LZ7iHRC_CMpB1k2VaQOk7wZwPVg9nAwaaRE7N_UtYIA-6y28kYmxq4DjRYocUjxKlZBXXLLkP4Q44D9mvs8IIunEhJusVVVpST9cLObV5yxw4HAUd0MSMsK1U2abbBEbxoiioaa_ZZkbVfs2FzfWrs-tTc1EWSxEXcP028YCWJDiSWSqrLpJQ0xRqJ6f30Et6g93efqSCPPZ-5WRaBdrRd90Uq7KJuRz-sh0ykT5a8L3OO0syK-f1S-Yz171ZYKYQSDuvwjfhKRaYMMDUsqn7QJmoX8L5aVceFJqU3gTr2je-lzYq42cLJ66bFpZfFZB5k1SuVDcoVKV3v0Mejukm5TUWmKenvILex7LHn_WKn0ns-q8pbXap9cVXKGoDSwFccqZTyx4fU_2gIpCtxdn2eb-egeLkEN9_e7E7CO8SAYSj57ImYkrd5A7KezEHMrAWccLMDm5UleWy4Iys1JychNh44Fo6uYkJEl2GiiXqeqNMObjBHjkOdHD_mzscUv6UNi2fbfAuuIU_6yoSTOCvdD2516e91kZr-GjUPvxJqGKLX_2NQvvfeVSC24WUN8KSmYKcZ9jJtFAbvoPni0r3fCJWkjPCjLPeeTw9TppW-EOxEx7ozh2SYrNfGiLxVm11qG_uzjNyEMjUTap4VElu_E1QaI9CZBDlq7V3qDWTkP4KjbhtcaixkVErjMQRO_z3YWRIn0n-A09ElRK68_uBPvm5-DQS0NkAMZZkp4xOLAhAlUJUiyJ-0IoHhDLMSKaHaSSRRkQfKqjhkXBRH2vIl1AZlXHazIa5Y1t2yIw; .Tunnels.Relay.WebForwarding.Cookies=CfDJ8PPN7pkBqn9PhQKqQ8YNxVxsSI6kPNWF3nG8vktsbD5uRSpXeM_kFBJpisiykCe7ArIsGVp_Kg-WdPMMmsXmXAdFOkOjUPxKx2k0n9bVhfjvn2btxwn96NtPMJys-AgxR6A-ccvbPwCF6EaHGaBk0tz6wONyZZrseyYxHrdau6WoGzTsSQb8RFlpiRrBWsDu7l8-ILsx8CTgta21YicULQPeNQDHkv7iG3UNxUgTk7rJSKZk1WsNJCxQ9wvwKEpurBbBFGZLhcEqOc7DhMxy6DgeJzdDISHQs8cfMz6f7O3oq9EKzVr_11FjPkhOm2COGp6LvyVqeteuNGTs16yX8vH_vvnajFzMNTK9ufapRXOSE5yUvfgsalCTPbb9VwlCpxJ3NGiQRBF3ytXAvtoQmlSE4EvkpwoCfX3LL4XjCSkuWyVd03JoYDqAUuXN2fU4wE3GzJ0bRTgdF7SNSO_2K9ZkKvuHe0kkQTOBTWAgUo8kSW2LXCTid-5u5aB5Sywx1JXh2JZIdDVf6Uc3pFRMAcBHErDQVvGPe2X9IqKjBccl27QOnQRCqAfj0Us8DVj5DxJqBFqhtzFPId1EzQfT5SNSo2uXrVnP5LzbyxOxbb6gKGghmRzaXtuZ8kUJ2Cg9pvpHIrDkyvpD8AI98FPDxY0DrbtgSy-mOGqqIvCDmgu2JXitQ2ELG9HGnfv9MxsRUUDo35ew1yhqcd-PLlHjSpzUayV3KGhsbO7k3f1kCzO5pLTYYa25iWn5f98hInDWkeqGZQ3ZwD7ecS0WSQc-8X_JR52vDMer1VyP5QibE6_tDPcEx1NxTbClaN9Xgsi9zXbghxgrKNoVIvJbOlykCTya1avpYLbMlDPOykqAO8zmxoaNqzhhwdrtl0xig1gv-Kfomr57ZGPZnjw74hbzoUqK1W42M8ew9A3NQAQi3CqqUnlrrlDUI6VZC3MiV0XXh4CI88wIa0KtYrUB0W0V4FKz7Bn2RZiosM-kgaKA582o097Xt3mKkcTVNaCmOMTh0aZ9l9s31OpPFTvoLe0jvSSBzzt8rR5Ksp3ATA3GSo8IPmyPMeO8u0Nq5lDz6NNhu_B7crHRi5AxlNIJWYgtn_-YjPHtXBf6Nv2Pc-Txv8Ij09rxuFn4i3NAERKQlTw6ZH9q1IcNWWSnyt83Xatwrfebabd3MpzaZ_XuZHUx4Wom_kNXpIlbaLi_mRpXu3G4z1dFjAEfskycvEm9EKp7oyb9hA9PVW0oS_jYCP3L49up9VmRN3rKY-HeJHcbsTp4srZlsBpOmFbqhqClm97SveG00GoXaXN_IJZv-85hEeA9cG11ywkPmWRsMyVxQX1lTt8DSpA-NW9XRryrghstbDa3MVgf7yM8LYcV35l5IgVFc1Xmh2n4OYXQT-9dhiX7MUTvupDPGNKghgQs7Ps3TiOU8qbTtNTR6yM5rGPKK8q8PhiLuZ3SSrUp9N55rxN7wFTmHABEW1diMyQOQ60KeorZZBGJsEvzInFkCxkGe5d7bdEasaMEaj2GWYHBzsGPrw; tunnel_phishing_protection=1wnvw8pq.asse' \
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