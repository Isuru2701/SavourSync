create database SavourSync;

use SavourSync;

create table Client (
                        id int not null auto_increment,
                        name varchar(255) not null,
                        email varchar(255) not null,
                        primary key (id)
);

create table `Table` (
                         id int not null auto_increment,
                         seats int not null,
                         available boolean not null default false,
                         primary key (id)
);

create table Reservation (
                             id int not null auto_increment,
                             client_id int not null,
                             table_id int not null,
                             start_datetime datetime not null,
                             primary key (id),
                             foreign key (client_id) references Client(id),
                             foreign key (table_id) references `Table`(id)
);