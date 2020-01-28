# graphql_springboot
A simple web-api with Spring Boot and GraphQL in domain of flight service. Based on LinkedinLearning 
GraphQL: Web-APIs mit Spring Boot


# domain model
Employee
 - Pilot
 - Attendant
Flight
Route

Employee * <- 1 Flight * <- 1 Route
                       1 -> 1 Route
                              Route 1 -> 1 Route




# tools
query graphql
https://github.com/prisma-labs/graphql-playground/releases

query to fetch all routes

`query{
  routes {
    id
  }
}`

# dependencies

GraphQL Java  https://github.com/graphql-java/graphql-java
GraphQL Tools contract first GraphQL schema language https://github.com/graphql-java-kickstart/graphql-java-tools
GraphQL Servlet: Java EE + HTTP (standalone servlet for java EE) https://github.com/graphql-java-kickstart/graphql-java-servlet
GraphQL Spring Boot: https://github.com/graphql-java-kickstart/graphql-spring-boot (more active than GraphQL Java Spring)

# environment
Spring Boot Web servlet container with embedded tomcat