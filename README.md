# appdirect
Running the application locally

Gradle need to be installed on the system

First build with:gradle clean build

Then run it with:gradle bootrun

CRUD APIs:

CREATE operation: http://localhost:8080/api/resource/create
it's a POST Request and the request json format is like below: { "name": "abc"}

READ operation: http://localhost:8080/api/resource/read/{id}
it's a GET Request

UPDATE Operation: http://localhost:8080/api/resource/update
it's a PUT Request and the request json format is like below: { id:"d78090","name": "abc"}

DELETE operation: http://localhost:8080/api/resource/delete/{id}
it's a DELETE Request

Subscription APIs:

For create subscription:

 http://localhost:8080//api/subscription/create?url={eventUrl}

For cancel subscription:

 http://localhost:8080/api/subscription/cancel?url={eventUrl}
