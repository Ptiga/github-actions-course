# Exemples de Requêtes - Calculator Service API

## Base URL
```
http://localhost:8080/api/calculator
```

## Multiplication

### Requête
```bash
curl -X GET "http://localhost:8080/api/calculator/multiply?a=10&b=5" \
  -H "accept: application/json"
```

### Réponse (200 OK)
```json
{
  "a": 10.0,
  "b": 5.0,
  "result": 50.0,
  "operation": "multiply"
}
```

---

## Division

### Requête
```bash
curl -X GET "http://localhost:8080/api/calculator/divide?a=20&b=4" \
  -H "accept: application/json"
```

### Réponse (200 OK)
```json
{
  "a": 20.0,
  "b": 4.0,
  "result": 5.0,
  "operation": "divide"
}
```

### Requête avec erreur (Division par zéro)
```bash
curl -X GET "http://localhost:8080/api/calculator/divide?a=10&b=0" \
  -H "accept: application/json"
```

### Réponse (400 Bad Request)
```json
{
  "message": "Division by zero is not allowed"
}
```

---

## Addition

### Requête
```bash
curl -X GET "http://localhost:8080/api/calculator/add?a=10&b=5" \
  -H "accept: application/json"
```

### Réponse (200 OK)
```json
{
  "a": 10.0,
  "b": 5.0,
  "result": 15.0,
  "operation": "add"
}
```

### Avec nombres négatifs
```bash
curl -X GET "http://localhost:8080/api/calculator/add?a=-10&b=5" \
  -H "accept: application/json"
```

### Réponse
```json
{
  "a": -10.0,
  "b": 5.0,
  "result": -5.0,
  "operation": "add"
}
```

---

## Soustraction

### Requête
```bash
curl -X GET "http://localhost:8080/api/calculator/subtract?a=10&b=3" \
  -H "accept: application/json"
```

### Réponse (200 OK)
```json
{
  "a": 10.0,
  "b": 3.0,
  "result": 7.0,
  "operation": "subtract"
}
```

### Avec résultat négatif
```bash
curl -X GET "http://localhost:8080/api/calculator/subtract?a=5&b=10" \
  -H "accept: application/json"
```

### Réponse
```json
{
  "a": 5.0,
  "b": 10.0,
  "result": -5.0,
  "operation": "subtract"
}
```

---

## Requêtes avec nombres décimaux

### Multiplication avec décimales
```bash
curl -X GET "http://localhost:8080/api/calculator/multiply?a=2.5&b=4" \
  -H "accept: application/json"
```

### Réponse
```json
{
  "a": 2.5,
  "b": 4.0,
  "result": 10.0,
  "operation": "multiply"
}
```

### Division avec décimales
```bash
curl -X GET "http://localhost:8080/api/calculator/divide?a=10&b=2.5" \
  -H "accept: application/json"
```

### Réponse
```json
{
  "a": 10.0,
  "b": 2.5,
  "result": 4.0,
  "operation": "divide"
}
```

---

## Tests avec PowerShell (Windows)

```powershell
# Multiplication
Invoke-RestMethod -Uri "http://localhost:8080/api/calculator/multiply?a=10&b=5" -Method Get

# Division
Invoke-RestMethod -Uri "http://localhost:8080/api/calculator/divide?a=20&b=4" -Method Get

# Addition
Invoke-RestMethod -Uri "http://localhost:8080/api/calculator/add?a=10&b=5" -Method Get

# Soustraction
Invoke-RestMethod -Uri "http://localhost:8080/api/calculator/subtract?a=10&b=3" -Method Get
```

---

## Tests avec Python

```python
import requests

# URL de base
BASE_URL = "http://localhost:8080/api/calculator"

# Multiplication
response = requests.get(f"{BASE_URL}/multiply", params={"a": 10, "b": 5})
print(response.json())

# Division
response = requests.get(f"{BASE_URL}/divide", params={"a": 20, "b": 4})
print(response.json())

# Addition
response = requests.get(f"{BASE_URL}/add", params={"a": 10, "b": 5})
print(response.json())

# Soustraction
response = requests.get(f"{BASE_URL}/subtract", params={"a": 10, "b": 3})
print(response.json())

# Erreur (division par zéro)
response = requests.get(f"{BASE_URL}/divide", params={"a": 10, "b": 0})
print(response.status_code)  # 400
print(response.json())
```

---

## Tests avec JavaScript/Node.js

```javascript
const BASE_URL = "http://localhost:8080/api/calculator";

// Multiplication
fetch(`${BASE_URL}/multiply?a=10&b=5`)
  .then(res => res.json())
  .then(data => console.log(data));

// Division
fetch(`${BASE_URL}/divide?a=20&b=4`)
  .then(res => res.json())
  .then(data => console.log(data));

// Addition
fetch(`${BASE_URL}/add?a=10&b=5`)
  .then(res => res.json())
  .then(data => console.log(data));

// Soustraction
fetch(`${BASE_URL}/subtract?a=10&b=3`)
  .then(res => res.json())
  .then(data => console.log(data));
```

---

## Tests avec Postman

1. **Importer la collection** dans Postman
2. **Base URL** : http://localhost:8080/api/calculator
3. Chaque endpoint peut être testé directement avec les paramètres `a` et `b`

### Endpoints Postman

| Méthode | Endpoint | Description |
|---------|----------|-------------|
| GET | /multiply?a={{a}}&b={{b}} | Multiplication |
| GET | /divide?a={{a}}&b={{b}} | Division |
| GET | /add?a={{a}}&b={{b}} | Addition |
| GET | /subtract?a={{a}}&b={{b}} | Soustraction |

---

## Notes

- Tous les paramètres doivent être passés en query string
- Les paramètres acceptent les nombres entiers et décimaux
- Les réponses sont en JSON
- La division par zéro retourne un code 400 avec un message d'erreur
- Les requêtes sans paramètres requis retournent un code 400

