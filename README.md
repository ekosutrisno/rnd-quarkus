# Api-v1 Project

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `api-v1-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/api-v1-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/api-v1-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

### Interview Test Erajaya Group

- Create endpint GetOrder from order microservice with response below
   * Get All Order
   * Get Order By Id 

```json
[
  {
    "apiVersion" : "1.0.0",
    "organization" : "Erajaya",
    "statusCode" : 0,
    "data" : [
      {
        "orderId" : "d52a0843-2b2e-4ba8-8f59-ce97739eedd4",
        "invoceNumber" : "INV/001",
        "orderName" : "Order 001",
        "orderDetail" : [
          {
            "orderDetailId" : "d52a0843-2b2e-4ba8-8f59-ce97739eedd4",
            "orderDetailItem" : "iPhone",
            "orderDetailItemQuantity" : 1,
            "orderDetailItemPrice" : 14000000,
            "orderDetailMerchant" : "iBox"
          },
          {
            "orderDetailId" : "d52a0843-2b2e-4ba8-8f59-ce97739eedd4",
            "orderDetailItem" : "Charger WiFi Universel",
            "orderDetailItemQuantity" : 1,
            "orderDetailItemPrice" : 1500000,
            "orderDetailMerchant" : "Erafone"
          }
        ],
        "orderDescription" : "Order 001",
        "createdBy" : "sherlock",
        "CreatedDate" : "2020-06-26T06:56:43.714Z",
        "ModifiedBy" : "sherlock",
        "ModifiedDate" : "2020-06-26T06:56:43.714Z"
      }
    ],
    "itemPerPage" : 2,
    "totalItems" : 1,
    "pageIndex" : 1,
    "totalPages" : 1
  }
]
```

- Create endpoint CreateOrder from order microservice with same response 
- Create endpoint UpdateOrder from order microservice with same response 
- Create endpoint UpdateOrderItem from order microservice with same response 
- Create Database ERD 

notes:
* Plus if use API Documentation (Swagger)
* Demo when interview
* Language: Can be anything
* Database: Use RDBMS and don’t use No SQL
