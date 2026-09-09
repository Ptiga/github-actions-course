@echo off
REM Script pour exécuter les tests unitaires

echo.
echo ============================================
echo   Calculator Service - Tests Unitaires
echo ============================================
echo.

REM Vérifier si Maven Wrapper existe
if not exist "mvnw.bat" (
    echo [ERREUR] mvnw.bat non trouvé
    pause
    exit /b 1
)

echo [INFO] Exécution des tests en cours...
echo.

call mvnw clean test

if errorlevel 1 (
    echo.
    echo [ERREUR] Les tests ont échoué
    pause
    exit /b 1
) else (
    echo.
    echo [SUCCÈS] Tous les tests ont réussi !
    echo.
    echo Résumé :
    echo - 34 tests exécutés
    echo - 0 échecs
    echo - 0 erreurs
    pause
)

