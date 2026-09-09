# Guide de Démarrage - Calculator Service

## Démarrage rapide

### 1. Compiler le projet

```bash
cd calculator-service
./mvnw clean compile
```

### 2. Exécuter les tests

```bash
./mvnw clean test
```

### 3. Créer le JAR exécutable

```bash
./mvnw clean package
```

### 4. Lancer l'application

#### Option 1 : Via Maven
```bash
./mvnw spring-boot:run
```

#### Option 2 : Via le JAR
```bash
java -jar target/calculator-service-1.0.0.jar
```

### 5. Accéder à l'application

Une fois démarrée, accédez à :
- **Swagger UI** : http://localhost:8080/swagger-ui.html
- **API Docs (OpenAPI)** : http://localhost:8080/v3/api-docs

## Utilisation de l'API

### Exemples de requêtes

#### Multiplication
```bash
curl "http://localhost:8080/api/calculator/multiply?a=10&b=5"
```

#### Division
```bash
curl "http://localhost:8080/api/calculator/divide?a=20&b=4"
```

#### Addition
```bash
curl "http://localhost:8080/api/calculator/add?a=10&b=5"
```

#### Soustraction
```bash
curl "http://localhost:8080/api/calculator/subtract?a=10&b=3"
```

## Réponses

### Succès (200 OK)
```json
{
  "a": 10.0,
  "b": 5.0,
  "result": 50.0,
  "operation": "multiply"
}
```

### Erreur (400 Bad Request)
```json
{
  "message": "Division by zero is not allowed"
}
```

## Tests

### Exécuter tous les tests
```bash
./mvnw test
```

### Résultats attendus
- **Total**: 34 tests
- **Succès**: 34 ✅
- **Échecs**: 0
- **Durée**: ~25 secondes

### Détail des tests

| Classe | Tests | Description |
|--------|-------|-------------|
| CalculatorServiceTest | 25 | Tests unitaires des 4 opérations |
| CalculatorControllerTest | 9 | Tests d'intégration des endpoints |

## Architecture du Projet

```
calculator-service/
├── src/main/java/com/example/calculator/
│   ├── CalculatorApplication.java       # Application principale Spring Boot
│   ├── CalculatorService.java           # Service métier
│   ├── CalculatorController.java        # Contrôleur REST
│   ├── CalculationResult.java           # DTO réponse
│   └── ErrorResponse.java               # DTO erreur
├── src/main/resources/
│   └── application.properties           # Configuration Spring
├── src/test/java/com/example/calculator/
│   ├── CalculatorServiceTest.java       # Tests unitaires
│   └── CalculatorControllerTest.java    # Tests intégration
├── pom.xml                              # Configuration Maven
├── mvnw.bat                             # Maven Wrapper Windows
└── README.md                            # Documentation complète
```

## Dépendances Principales

- **Spring Boot 2.7.15** : Framework web
- **Springdoc OpenAPI 1.6.15** : Documentation Swagger/OpenAPI 3.0
- **JUnit 5** : Framework de test
- **Lombok** : Réduction du code boilerplate

## Propriétés de Configuration

| Propriété | Valeur | Description |
|-----------|--------|-------------|
| `server.port` | 8080 | Port d'écoute |
| `spring.application.name` | calculator-service | Nom de l'application |
| `springdoc.swagger-ui.path` | /swagger-ui.html | URL de Swagger UI |

## Résolution des Problèmes

### Le port 8080 est déjà utilisé
```bash
# Changer le port
java -Dserver.port=8081 -jar target/calculator-service-1.0.0.jar
```

### Tests non exécutés
```bash
# Vérifier que Java est installé
java -version

# Vérifier la configuration Maven
./mvnw --version

# Nettoyer et relancer
./mvnw clean test -X
```

### Erreur de compilation Java
Assurez-vous que Java 11+ est installé :
```bash
java -version
# Doit afficher Java 11 ou supérieur
```

## Commandes Utiles

```bash
# Nettoyer les fichiers compilés
./mvnw clean

# Compiler sans tests
./mvnw clean compile

# Tester sans compilation
./mvnw test -DskipCompile

# Générer les rapports de test
./mvnw test jacoco:report

# Afficher l'aide Maven
./mvnw help:describe -Dplugin=org.apache.maven.plugins:maven-compiler-plugin

# Vérifier les dépendances
./mvnw dependency:tree

# Mettre à jour les dépendances
./mvnw versions:update-properties
```

## Support Swagger/OpenAPI

L'interface Swagger est disponible à : **http://localhost:8080/swagger-ui.html**

Vous pouvez y :
- ✅ Visualiser tous les endpoints disponibles
- ✅ Consulter les schémas de requête/réponse
- ✅ Tester les endpoints directement depuis l'interface
- ✅ Consulter les codes d'erreur possibles
- ✅ Voir les exemples de requêtes

## Notes Importantes

- Les paramètres sont de type `double` pour supporter les décimales
- La division par zéro retourne un code 400
- Tous les résultats incluent les opérandes (a, b) et le type d'opération
- Les tests s'exécutent automatiquement lors du `package`

## Licence

ISC - Libre d'utilisation

---

Pour plus d'informations, consultez le fichier `README.md` à la racine du projet.

