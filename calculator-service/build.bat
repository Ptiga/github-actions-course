@echo off
REM Script pour compiler le projet

echo.
echo ============================================
echo   Calculator Service - Compilation
echo ============================================
echo.

REM Vérifier si Maven Wrapper existe
if not exist "mvnw.bat" (
    echo [ERREUR] mvnw.bat non trouvé
    pause
    exit /b 1
)

echo [INFO] Compilation du projet...
echo.

call mvnw clean compile

if errorlevel 1 (
    echo.
    echo [ERREUR] La compilation a échoué
    pause
    exit /b 1
) else (
    echo.
    echo [SUCCÈS] Compilation réussie !
    echo [INFO] Vous pouvez maintenant :
    echo   - Exécuter les tests avec : run-tests.bat
    echo   - Créer le JAR avec : mvnw package
    echo   - Lancer l'app avec : start.bat
    pause
)

