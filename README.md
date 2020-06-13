# Sia Teck Task

<img src="https://media.giphy.com/media/jpKKVXRxkYC2j8RZFe/giphy.gif" width="300">

## What am gonna to be use to achomplish that task
### To avoid 64k functions problem and get smaller apk
- Enables code shrinking, obfuscation, and optimization for only
- Enables resource shrinking, which is performed by the

### To save base url and important constants

 - put all of them inside app.gradle file so prevent our api from reverse engineering

### To make project scalable 

 - struct project with mvvm pattern (recommended pattern by google team)

### using jetpack component such as

 - Viewmodel  to support life cycler aware 
 - navigation component so we can implement single activity structure thar recomended by google
 - data binding to bind model with views easly smothly 
 
 ### unfortunatly api need to pay to subscripe it 
 

> <-- 403 Forbidden https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/api/v1/cars?q=Hi (2323ms)
Content-Type: application/json
Date: Sat, 13 Jun 2020 02:07:59 GMT
Server: RapidAPI-1.1.13
X-RapidAPI-Proxy-Response: true
X-RapidAPI-Region: AWS - eu-central-1
X-RapidAPI-Version: 1.1.13
Content-Length: 49
Connection: keep-alive
{"message":"You are not subscribed to this API."}
<-- END HTTP (49-byte body)

## But i enhanced app to work with dummy data 
it now work with dummy data but if you want to connect it with real data 
just replace my api_key inside app.gradle with yours ;) it simple


