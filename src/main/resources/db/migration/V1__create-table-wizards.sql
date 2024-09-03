create table wizards(

    id bigint not null auto_increment,
    name varchar(100) not null,
    hogwartsHouse varchar(100) not null,
    patronum varchar(100) not null,
    birthdate varchar(100) not null,

    primary key(id)

);