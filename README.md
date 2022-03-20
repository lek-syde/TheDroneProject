# TheDroneProject
Useful drone functions include delivery of small items that are (urgently) needed in locations with difficult access.

Running the API

Download and unzip

`mvn clean install`

`mvn spring-boot:run`



**API ENDPOINTS**



**CREATING/ADDING DRONE**

`PUT  /create-drone`

request body

-serialNumber -string

-model (Lightweight, Middleweight, Cruiserweight, Heavyweight)

-weight -double


-batteryCapacity - double

-state (IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING)


**GET ALL DRONE**

`GET  /drones`


**SPECIFIC DRONE**

`GET  /drone?id`

param variable id - drone id

**GET DRONE BY STATE**

`GET  /search-drone?state`

param variable  - state (IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING)


**LOADING DRONE WITH MEDICATION**

PUT `/drone?id`

param variable id - drone id

request body

-name

-weight -double

-code

-image -string byte


**CHECKING AVAILABLE DRONE FOR LOADING**

`GET  /search-drone?state=IDLE`