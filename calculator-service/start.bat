@echo off
REM Script de démarrage de Calculator Service

echo.
echo ============================================
echo   Calculator Service - Spring Boot
echo ============================================
echo.

REM Vérifier si Java est installé
java -version >nul 2>&1
if errorlevel 1 (
    echo [ERREUR] Java n'est pas installé ou non accessible
    echo Veuillez installer Java 11+ et configurez le PATH
    pause
    exit /b 1
)

REM Chercher le JAR
if not exist "target\calculator-service-1.0.0.jar" (
    echo [INFO] JAR non trouvé. Compilation en cours...
    call mvnw clean package -DskipTests
    if errorlevel 1 (
        echo [ERREUR] Compilation échouée
        pause
        exit /b 1
    )
)

echo [INFO] Démarrage de Calculator Service...
echo [INFO] L'application sera accessible à : http://localhost:8080
echo [INFO] Interface Swagger : http://localhost:8080/swagger-ui.html
echo.
echo Appuyez sur Ctrl+C pour arrêter l'application
echo.

REM Démarrer l'application
java -jar target\calculator-service-1.0.0.jar

pause

