# Sakila ORM CRUD - Java

Proyecto Final de INF514 Programación II Java basado en la base de datos Sakila de MySQL.

## Tecnologías Utilizadas

- Java 17
- MySQL
- JDBC
- Maven
- Gson
- Git
- GitHub

## Funcionalidades

- CRUD de Actor
- CRUD de Film
- CRUD de Customer
- CRUD de Rental
- Exportación CSV
- Exportación JSON
- Estadísticas y reportes
- ORM manual utilizando JDBC

## Estructura del Repositorio
```text
SakilaORM
│
├── src
│   └── main
│       └── java
│           └── com
│               └── sakila
│
├── actors.csv
├── actors.json
├── README.md
├── pom.xml
└── .gitignore
```

## Arquitectura del Proyecto

- Arquitectura MVC
- Generic CRUD
- Clase abstracta DataContext
- JDBC Connection
- Aggregation y Composition para Foreign Keys

## Estructura del Proyecto

```text
com.sakila
│
├── app
├── controllers
├── data
├── models
├── reports
└── utils
```

## Base de Datos

El proyecto utiliza la base de datos Sakila incluida en MySQL.

## Ejecución

Ejecutar la clase:

```text
com.sakila.app.Main
```

## Autor

Lisbeth Sosa