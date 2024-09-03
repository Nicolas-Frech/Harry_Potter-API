create table books(

    id bigint not null auto_increment,
    title varchar(100) not null,
    synopsis varchar(2500) not null,
    release_date varchar(100) not null,

    primary key(id)

);