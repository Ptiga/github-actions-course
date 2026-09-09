# Calculator Service

Une application Java Spring Boot simple fournissant une API REST pour les opérations arithmétiques de base avec documentation Swagger/OpenAPI.

## Fonctionnalités

- ✅ Multiplication de deux nombres
- ✅ Division de deux nombres (avec gestion de la division par zéro)
- ✅ Addition de deux nombres
- ✅ Soustraction de deux nombres
- ✅ API REST complète avec Swagger/OpenAPI
- ✅ Tests unitaires complets pour chaque fonction
- ✅ Tests d'intégration du contrôleur

## Prérequis

- Java 11 ou supérieur
- Maven 3.6 ou supérieur

## Installation et Compilation

```bash
# Compiler le projet
mvn clean compile

# Compiler et lancer les tests
mvn clean test

# Compiler et créer le JAR
mvn clean package

# Installer les dépendances
mvn clean install
```

## Démarrage de l'application

```bash
# Via Maven
mvn spring-boot:run

# Via le JAR créé
java -jar target/calculator-service-1.0.0.jar
```

L'application s'exécutera par défaut sur `http://localhost:8080`

## API Endpoints

### Multiplication
```
GET /api/calculator/multiply?a=10&b=5
```
**Réponse (200):**
```json
{
  "a": 10.0,
  "b": 5.0,
  "result": 50.0,
  "operation": "multiply"
}
```

### Division
```
GET /api/calculator/divide?a=20&b=4
```
**Réponse (200):**
```json
{
  "a": 20.0,
  "b": 4.0,
  "result": 5.0,
  "operation": "divide"
}
```

**Réponse en cas de division par zéro (400):**
```json
{
  "message": "Division by zero is not allowed"
}
```

### Addition
```
GET /api/calculator/add?a=10&b=5
```
**Réponse (200):**
```json
{
  "a": 10.0,
  "b": 5.0,
  "result": 15.0,
  "operation": "add"
}
```

### Soustraction
```
GET /api/calculator/subtract?a=10&b=3
```
**Réponse (200):**
```json
{
  "a": 10.0,
  "b": 3.0,
  "result": 7.0,
  "operation": "subtract"
}
```

## Documentation Swagger

Une fois l'application lancée, accédez à la documentation interactive Swagger à l'adresse:

```
http://localhost:8080/swagger-ui.html
```

Vous pouvez y voir :
- Tous les endpoints disponibles
- Les paramètres requis
- Les formats de réponse
- Les codes d'erreur possibles
- Tester les endpoints directement depuis l'interface

## Tests Unitaires

Le projet contient des tests unitaires complets:

- **CalculatorServiceTest.java** : Tests des 4 opérations mathématiques
  - Multiplicaton : 5 tests
  - Division : 6 tests
  - Addition : 6 tests
  - Soustraction : 8 tests
  - Total : 25 tests

- **CalculatorControllerTest.java** : Tests d'intégration des endpoints
  - Tests des endpoints avec paramètres valides
  - Tests des cas d'erreur (division par zéro, paramètres manquants)
  - Total : 8 tests

### Exécuter les tests

```bash
# Exécuter tous les tests
mvn test

# Exécuter un fichier de test spécifique
mvn test -Dtest=CalculatorServiceTest

# Exécuter avec rapport de couverture
mvn test jacoco:report
```

## Structure du Projet

```
calculator-service/
├── src/
│   ├── main/
│   │   ├── java/com/example/calculator/
│   │   │   ├── CalculatorApplication.java       # Application principale
│   │   │   ├── CalculatorService.java           # Service métier
│   │   │   ├── CalculatorController.java        # Contrôleur REST
│   │   │   ├── CalculationResult.java           # DTO pour les résultats
│   │   │   └── ErrorResponse.java               # DTO pour les erreurs
│   │   └── resources/
│   │       └── application.properties           # Configuration Spring
│   └── test/
│       └── java/com/example/calculator/
│           ├── CalculatorServiceTest.java       # Tests unitaires du service
│           └── CalculatorControllerTest.java    # Tests du contrôleur
├── pom.xml                                       # Configuration Maven
└── README.md                                     # Cette documentation
```

## Dépendances principales

- **spring-boot-starter-web** : Support REST API
- **springdoc-openapi-ui** : Swagger/OpenAPI 3.0
- **spring-boot-starter-test** : Tests avec JUnit 5
- **junit** : Framework de test

## Notes

- Tous les paramètres sont de type `double` pour supporter les nombres décimaux
- La division par zéro lève une exception `ArithmeticException`
- Les endpoints retournent des codes HTTP appropriés :
  - 200 OK pour les opérations réussies
  - 400 Bad Request pour les erreurs (ex: division par zéro)
- Les résultats incluent les opérandes (a, b), le résultat et le type d'opération

## Auteur

Créé avec ❤️ pour le cours GitHub Actions

