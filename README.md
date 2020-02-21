# java-cart-v2

## version number: 04fa1404c2b3b7be0e5909d4ba93d1332bc76e98

## Shopping cart demo
- Java 8
- TDD (Test Driven Development)
- OOD
- Maven

## Prerequisite:
- Java jdk 8 
- Maven
- Java and Maven runnable environment
- Preferrably using IntelliJ :)
- IDE to import project as mvn project

## To run tests:

    mvn clean test

## To run coverage (using jacoco)
    
    mvn clean package
    
    coverage report is in java-cart-master\target\site\jacoco
    
## OOD

    Cart 
        -----------------------------------
        - has a list of product order items
        -----------------------------------
        - add product order item
        - get product quantity
        - remove product item
        - empty cart
        - get order item list
    
    Product
        -----------------------------------
        - key - sku
        - name
        - price 
        -----------------------------------
        - get sku
        - get name
        - get price
        - equals/hash for storing in map or hashtable
    
    Payment calculator
        -----------------------------------
        - tax, service tax
        -----------------------------------
        - get total amount exclude tax
        - get tax amount
        - get total amount include tax
        - get tax rate
        
## Assumption and consideration
1. BigDecimal for all decimal values. taking advantage of scale and precision.
2. Product price are excluded-tax and all products are applicable to service tax. 
3. Hashtable for Product Items. Hashtable can not insert null key or null value which maintain integrity better. Product object is key and Quantity is value
5. JUNIT is mainly focus on functional unit test. some edge conditions like null, Integer ranger and BigDecimal ranger may not implement due to time limitations
6. some operations may be added due to coverage reason.

Appreciate your review and feedback.

