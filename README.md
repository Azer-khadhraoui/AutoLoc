# AutoLoc

API REST de gestion d'une agence de location de véhicules. Projet Java 17 avec Spring Boot, Spring Data JPA et MySQL.

## Lancer le projet

Prérequis : Java 17 et MySQL.

Configurer la connexion dans `src/main/resources/application.properties`, puis lancer :

```bash
./mvnw spring-boot:run
```

Sous Windows :

```powershell
.\mvnw.cmd spring-boot:run
```

L'API démarre sur `http://localhost:8081`. La base `autoloc_db_dev` est créée automatiquement si nécessaire.

## Routes

Les ressources suivantes disposent des opérations CRUD :

`/api/agences`, `/api/assurances`, `/api/clients`, `/api/contrats`, `/api/employes`, `/api/equipements`, `/api/maintenances`, `/api/paiements`, `/api/reservations`, `/api/vehicules`.

Routes spécifiques :

- `PATCH /api/reservations/{id}/statut?statut=...`
- `PATCH /api/employes/{idEmploye}/desaffecter`
- `PATCH /api/employes/{idEmploye}/agence/{idAgence}`
- `PATCH /api/vehicules/{idVehicule}/agence/{idAgence}`
- `PATCH /api/vehicules/{idVehicule}/equipements/{idEquipement}`

Documentation interactive : `http://localhost:8081/swagger-ui/index.html`.
