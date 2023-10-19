# Backend pour Application Style-UberEat

## Description

Ce backend est conçu pour une application de livraison similaire à UberEat. Il est construit avec Spring Boot et utilise JPA/Hibernate pour la persistance de données, H2 comme base de données dans un fichier.

## Prérequis

- Java 17
- Maven

## Dépendances principales

- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- H2 Database
- Springdoc OpenAPI (pour la documentation API)
- Lombok (pour réduire le boilerplate code)
- JetBrains Annotations

## Installation

1. Clonez le dépôt dans votre environnement local avec `git clone <url_du_dépôt>`.
2. Accédez au dossier du projet avec `cd chemin_vers_le_projet`.
3. Exécutez `mvn install` pour installer les dépendances du projet.

## Démarrage de l'application

Exécutez la commande `mvn spring-boot:run` dans le répertoire racine du projet pour démarrer l'application. Par défaut, elle sera lancée sur `http://localhost:8080`.

## Documentation API

Une fois l'application lancée, vous pouvez accéder à la documentation et à l'interface utilisateur de Swagger en visitant `http://localhost:8080/swagger-ui.html`.

## Console H2
http://localhost:8080/h2  
username=uber  
password=password!

## Tests

Pour exécuter les tests, utilisez la commande `mvn test`. Cela lancera les tests unitaires et d'intégration configurés dans le projet.


