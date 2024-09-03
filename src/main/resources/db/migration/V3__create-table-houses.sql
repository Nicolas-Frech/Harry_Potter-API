create table houses(

    id bigint not null auto_increment,
    name varchar(100) not null,
    founder varchar(100) not null,
    traits varchar(100) not null,
    animal varchar(100) not null,
    colors varchar(100) not null,

    primary key(id)

);