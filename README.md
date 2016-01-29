Stormpath Password Validation Service
==

How to build:
==
gradle build

How to run:
==
gradle bootRun

POST http://localhost:8080/validate/password
password=<testpassword>

How to test:
==
gradle test