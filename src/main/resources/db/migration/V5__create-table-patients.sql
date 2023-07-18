create table patients(

    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    document varchar(14) not null unique,
    street varchar(100) not null,
    district  varchar(100) not null,
    postalCode varchar(9) not null,
    city varchar(100) not null,
    state varchar(2) not null,
    number varchar(20) not null,
    complement varchar(100),
    phoneNumber varchar(20) not null,
    active tinyint not null,

    primary key(id)
);