# SavourSync
# A system for placing reservations at a restaurant

![](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=oracle&logoColor=white&labelColor=007396) 
<br>
[![](https://img.shields.io/badge/Github-black?style=flat-square&logo=github&logoColor=white&labelColor=black)](https://github.com/Isuru2701/SavourSync)

**HEAVY STC** 
<hr>

## Key Views

- [ ] placing reservations (form)
  - [ ] check availability 
  - [ ] select date and time
  - [ ] select number of guests
   
<hr>

- [ ] Dashboard:
    - [ ] list of reservations for the day
    - [ ] list of upcoming reservations
    - [ ]  Capacity as a percentage

<hr>

- [ ] Report:
  - [ ] reservation % for each weekday
  - [ ] most booked dates & times
  - [ ] reservation summary for the week

<hr>

## DB structure

```mermaid
erDiagram
    Client ||--o{ Reservation
    Reservation }o--|| Table

    Client {
        int id
        varchar(255) name
        varchar(255) email
    }
    Reservation {
        int id
        int client_id
        int table_id
        datetime start_datetime
    }
    `Table` {
        int id
        int seats
        boolean available
    }
```