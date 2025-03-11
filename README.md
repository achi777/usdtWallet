USDT wallet

Register to https://www.trongrid.io/

create API

config /src/main/resources/application.yml

create wallet
GET http://localhost:8080/api/wallet/generate

send USDT
POST http://localhost:8080/api/transaction/transfer
{
"senderAddress": "41e438caa7567424460fb35a103f4853e4c5f903de",
"receiverAddress": "416f1a1b8a6f47c1b3a2e5b3f5f99d451dbe07e1ad",
"privateKey": "MEECAQAwEwYHKoZIzj0CAQYIKoZIzj0DAQcEJzAlAgEBBCAu4ujvZPyDZOKgMNf2eYIyXbcyDWZj9PIkhZEXuZydMA==",
"amount": "10"
}
