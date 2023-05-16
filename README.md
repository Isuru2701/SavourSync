# SavourSync
# A system for placing reservations at a restaurant

![](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=oracle&logoColor=white&labelColor=007396) 
<br>
[![](https://img.shields.io/badge/Github-black?style=flat-square&logo=github&logoColor=white&labelColor=black)](https://github.com/Isuru2701/SavourSync)

**Version 1.0.0-dev** 
<hr>

# Functionality
- place a reservation
- manage tables
- check availability of tables
- view reservations
- view capacity occupied
- generate reports on 
  - daily reservations
  - daily canceled reservations
- 

<hr>

## Key Views

- [x] placing reservations (form)
  - [x] check availability 
  - [x] select date and time
  - [x] select table, check if this timeslot is available
   
<hr>

- [x] Dashboard:
    - [x] list of reservations for the day
    - [x] list of upcoming reservations
    - [x] Capacity as a percentage
    - [x] add/delete tables

<hr>

- [x] Report:
  - [x] Daily report
  - [x] Cancellations report

<hr>

## DB structure

```mermaid
erDiagram
    
    Client ||--o{ Reservation : places

    Reservation o|--|{ Table : for

```