# 🖥️ Prérequis Système

## Avant de Commencer

### ✅ Requis

**Système d'Exploitation**
- Windows 10+ (testé)
- Linux (compatible)
- macOS (compatible)

**Java**
- ✅ Java 11 ou supérieur
- ✅ Java 17 LTS (recommandé) - c'est ce qui est utilisé pour le test
- Vérifier : `java -version`

**Navigateur Web**
- Chrome, Firefox, Edge, Safari (pour accéder à Swagger UI)

### ⚠️ Non Requis (Mais Utile)

- Maven (Maven Wrapper `mvnw.bat` est inclus)
- IDE (mais recommandé : IntelliJ IDEA, VS Code, Eclipse)
- Postman (optionnel, pour tester l'API)

---

## 📋 Vérification Rapide

Ouvrir le terminal/PowerShell et exécuter :

```bash
# Vérifier Java
java -version
# Résultat attendu : Java 11.0.x ou supérieur

# Tester Maven Wrapper
.\mvnw --version
# Résultat attendu : Apache Maven X.X.X
```

---

## 🚀 Installation de Java (si nécessaire)

### Windows

1. Télécharger Java 17 LTS : https://www.oracle.com/java/technologies/downloads/
2. Exécuter l'installeur
3. Vérifier l'installation : `java -version`

### Linux (Ubuntu/Debian)

```bash
sudo apt update
sudo apt install openjdk-17-jdk
java -version
```

### macOS

```bash
brew install java17
java -version
```

---

## 🎯 Configuration Après Installation

### Variable d'Environnement JAVA_HOME (Optionnel)

**Windows**
1. Rechercher "Variables d'environnement"
2. Créer une nouvelle variable : `JAVA_HOME`
3. Valeur : `C:\Program Files\Java\jdk-17` (adapter selon votre installation)

**Linux/macOS**
```bash
export JAVA_HOME=/usr/libexec/java_home
```

---

## 🧪 Test du Projet

Exécuter dans le répertoire du projet :

```bash
# Compiler
.\mvnw clean compile

# Tests
.\mvnw clean test

# Package
.\mvnw clean package

# Lancer
java -jar target\calculator-service-1.0.0.jar
```

---

## 💻 Recommandations

### IDE Recommandés

1. **IntelliJ IDEA Community** (Gratuit)
   - Meilleur support Spring Boot
   - Intégration Maven native
   - Débogage facile

2. **VS Code** (Gratuit)
   - Extension : Spring Boot Extension Pack
   - Léger et rapide

3. **Eclipse** (Gratuit)
   - Spring Tools 4
   - Complètement intégré

### Outils Utiles

- **Postman** : Tester l'API
- **cURL** : Requêtes en ligne de commande
- **Git** : Versioning du code

---

## 🔍 Dépannage

### "Java not found"
```bash
# Ajouter à PATH (Windows)
set PATH=%PATH%;"C:\Program Files\Java\jdk-17\bin"

# Vérifier
java -version
```

### "Port 8080 déjà utilisé"
```bash
# Utiliser un autre port
java -Dserver.port=8081 -jar target\calculator-service-1.0.0.jar
```

### "Maven command not found"
```bash
# Utiliser le Maven Wrapper
.\mvnw.bat clean compile  # Windows
./mvnw clean compile      # Linux/macOS
```

---

## ✅ Checklist de Préparation

- [ ] Java 11+ installé
- [ ] `java -version` retourne une version
- [ ] Git installé (optionnel)
- [ ] Navigateur web disponible
- [ ] Terminal/PowerShell disponible
- [ ] Port 8080 disponible

---

## 🎓 Ressources

- **Java Documentation** : https://docs.oracle.com/en/java/
- **Spring Boot** : https://spring.io/projects/spring-boot
- **Maven** : https://maven.apache.org/
- **Swagger/OpenAPI** : https://swagger.io/

---

**Vous êtes prêt ? Lancez `start.bat` pour démarrer ! 🚀**

