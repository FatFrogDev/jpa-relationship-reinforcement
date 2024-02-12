# Spring relationships reinforce

This application contains a simple spring proyect, using `jpa` and `hibernate` relationships through models, created to experiment with `CascadeType` class, .

## Description

The idea of the proyect was to make some experiments using hibernate, so, in the first commit, we are using a "common" relationship among `clients` & `addresses`, by saying that, I mean that addresses contains a foreign key that references his owner as a client. Also, trying some query methods.

The latest commit uses the hibernate's recomendation to handle relathionsips wiht intermedium tables, so, here we have no longer a foreign key in `addresses` that belongs to an user, instead, hibernate creates a `clients_addresses` table, which <strong>contains both of its keys</strong> as foreign keys, thus, it makes a more 'clear' design, but this doesn't mean that the first version is a bad practice.

## How to use

The database script is locate in `src\main\resources\import.sql`, this contains the database basic creation and some imports. First two lines are commented, you can cut them and execute it in a db manager and then run the aplication.

Now, it is similar to a console program, so all the methods definition are in the main class, there are some written methds, so you can try adding new ones, executing existing methods or modyfing them. 

> **Note:**
Remember tha he run method must call the desired method to execute.

## Technologies

- Spring framework
- MySQL
- Hibernate
- JPA

Made with ♥  by [Deyby](https://www.linkedin.com/in/deyby-ariza-4667731aa/)