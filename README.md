# Token - PROJECT

#### I. Project description
* We are building a backend project that also create a ERC-20 token. This uses for giving token for user by actions they do in our services. It also user can transfer token to others. 


#### II. Technology Stack
* *Programming Language*: Java 8
* *Framework*: Spring Boot
* *Database Server*: MySQL
* *API Docs*: Swagger 2
* SmartContract: Solidity

#### III. Project struture
##### 1. Java parts
* `config`:  Configuration files
* `controller`: API expose classes
* `dto`: Data transfer 
* `model`: Entities that is mapped with database tables
* `repository`: Repository 
* `service`: Service layer - classes
* `smartcontract`: Java files that is generated by Web3JS from solidity files
    * Action Service
    * ITLeadProToken
    * TokenSales
* `Application`: starting system files


##### 2. Resources parts
* `solidity`: Smart contract files that wrote by solidity
* `log4j.xml`: Logging file 