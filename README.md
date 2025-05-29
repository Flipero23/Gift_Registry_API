Running on localmachine:

Registry Endpoints:

GET http://localhost:8080/registries  //GET all registries

GET http://localhost:8080/registries/1  / GET http://localhost:8080/registries/3 (ERROR 404)    //GET registry by ID

POST http://localhost:8080/registries   //POST, creates a new registry
BODY:
{
  "eventName": "Graduation Party",
  "ownerName": "Gorazd",
  "date": "2025-06-15",
  "description": "Graduation celebration gifts registry"
}

PUT http://localhost:8080/registries/3    //PUT, updates a registry with entered ID
BODY:
{
  "eventName": "Updated Event Name",
  "ownerName": "Updated Owner",
  "date": "2025-06-01",
  "description": "Updated description",
  "items": [],
  "guests": []
}

DELETE http://localhost:8080/registries/3   //DELETE, removes registry with entered ID




Item Endpoints:

GET http://localhost:8080/items   //GET all items

GET http://localhost:8080/items/1    //GET items with entered ID

POST http://localhost:8080/items/registry/2   //POST, creates item in the registry with the entered ID
BODY:
{
  "name": "Smart Watch",
  "price": 150.00,
  "quantity": 1,
  "purchased": false
}

GET http://localhost:8080/items/registry/2   //GET all items in the registry with the entered ID

PUT http://localhost:8080/items/2    //PUT, updates item with the entered ID
BODY:
{
  "name": "Updated Item",
  "price": 50.0,
  "quantity": 2,
  "purchased": false
}

PATCH http://localhost:8080/items/2/purchase  //PATCH, updates the purchase field to true

DELETE http://localhost:8080/items/2   //DELETE, removes the item with the entered ID






Guest Endpoints:

GET http://localhost:8080/guests    //GET all guests

GET http://localhost:8080/guests/2    //GET guest by entered ID

POST http://localhost:8080/guests/registry/2   //POST, enters new guest to registry with entered registry ID
BODY:
{
  "name": "Petar",
  "email": "petar@gmail.com",
  "hasRSVP": false
}

GET http://localhost:8080/guests/registry/2   //GET guests in the registry with the entered registry ID

PUT http://localhost:8080/guests/2     //PUT, updates guest information for guest with entered guest ID
BODY:
{
  "name": "Updated Name",
  "email": "updated@gmail.com",
  "hasRSVP": false
}


PATCH http://localhost:8080/guests/2/rsvp   //PATCH, updates rsvp field to true for guest with entered guest ID

DELETE http://localhost:8080/guests/2    //DELETE, removes guest with entered guest ID







When running on Heroku (Now it is not running because i have to pay, I will run it during the presentation):

Registry Endpoints:

GET https://gift-registry-api-0cb9e5b67e33.herokuapp.com/registries  //GET all registries

GET https://gift-registry-api-0cb9e5b67e33.herokuapp.com/registries/1  / GET http://localhost:8080/registries/3 (ERROR 404)    //GET registry by ID

POST https://gift-registry-api-0cb9e5b67e33.herokuapp.com/registries   //POST, creates a new registry
BODY: 
{
  "eventName": "Graduation Party",
  "ownerName": "Gorazd",
  "date": "2025-06-15",
  "description": "Graduation celebration gifts registry"
}

PUT https://gift-registry-api-0cb9e5b67e33.herokuapp.com/registries/3    //PUT, updates a registry with entered ID
BODY:
{
  "eventName": "Updated Event Name",
  "ownerName": "Updated Owner",
  "date": "2025-06-01",
  "description": "Updated description",
  "items": [],
  "guests": []
}

DELETE https://gift-registry-api-0cb9e5b67e33.herokuapp.com/registries/3   //DELETE, removes registry with entered ID




Item Endpoints:

GET https://gift-registry-api-0cb9e5b67e33.herokuapp.com/items   //GET all items

GET https://gift-registry-api-0cb9e5b67e33.herokuapp.com/1    //GET items with entered ID

POST https://gift-registry-api-0cb9e5b67e33.herokuapp.com/items/registry/2   //POST, creates item in the registry with the entered ID
BODY:
{
  "name": "Smart Watch",
  "price": 150.00,
  "quantity": 1,
  "purchased": false
}

GET https://gift-registry-api-0cb9e5b67e33.herokuapp.com/items/registry/2   //GET all items in the registry with the entered ID

PUT https://gift-registry-api-0cb9e5b67e33.herokuapp.com/items/2    //PUT, updates item with the entered ID
BODY:
{
  "name": "Updated Item",
  "price": 50.0,
  "quantity": 2,
  "purchased": false
}

PATCH https://gift-registry-api-0cb9e5b67e33.herokuapp.com/items/2/purchase  //PATCH, updates the purchase field to true

DELETE https://gift-registry-api-0cb9e5b67e33.herokuapp.com/items/2   //DELETE, removes the item with the entered ID






Guest Endpoints:

GET https://gift-registry-api-0cb9e5b67e33.herokuapp.com/guests    //GET all guests

GET https://gift-registry-api-0cb9e5b67e33.herokuapp.com/guests/2    //GET guest by entered ID

POST https://gift-registry-api-0cb9e5b67e33.herokuapp.com/guests/registry/2   //POST, enters new guest to registry with entered registry ID
BODY:
{
  "name": "Petar",
  "email": "petar@gmail.com",
  "hasRSVP": false
}

GET https://gift-registry-api-0cb9e5b67e33.herokuapp.com/guests/registry/2   //GET guests in the registry with the entered registry ID

PUT https://gift-registry-api-0cb9e5b67e33.herokuapp.com/guests/2     //PUT, updates guest information for guest with entered guest ID
BODY:
{
  "name": "Updated Name",
  "email": "updated@gmail.com",
  "hasRSVP": false
}


PATCH https://gift-registry-api-0cb9e5b67e33.herokuapp.com/guests/2/rsvp   //PATCH, updates rsvp field to true for guest with entered guest ID

DELETE https://gift-registry-api-0cb9e5b67e33.herokuapp.com/guests/2    //DELETE, removes guest with entered guest ID




