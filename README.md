# Zoo

RESTified version of the zoo.

## About

The codebase offers Zoo related functionality via REST endpoints.

 * Getting the Zoo's opening hours: ```GET zoo/openinghours```
 * Listing all animal names: ```GET zoo/animals```
 * Listing details for a specific animal (identified by name): ```GET zoo/animals/animal```
 * Adding an animal: ```PUT zoo/animals/animal```

All this functionality is [offered by a Spring REST controller class Zoo](src/main/java/eu/kartoffelquadrat/zoo/Zoo.java).

## Usage

To compile / run the Zoo, execute these commands:

 * Compile: ```mvn clean package```
 * Run: ```java -jar target/zoo.jar```

Then test access, e.g. with your browser: [```http://127.0.0.1:8080/zoo/openinghours```](http://127.0.0.1:8080/zoo/openinghours)

