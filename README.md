Password Validation Service
==

Write a password validation service in Java, meant to be configurable via IoC using the Spring Framework. The service is meant to check a text string for compliance to any number of password validation rules.
The rules currently known are:

-Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
-Must be between 5 and 12 characters in length.
-Must not contain any sequence of characters immediately followed by the same sequence.

Include all artifacts in a zip file. The project should build without any errors using either Maven or Gradle. The service should be ready for insertion into an existing production code base. Show tests for the validator service and any constituent classes involved in fulfillment of the service.

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
