create table person
(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);

insert into person
(ID, NAME,LOCATION,BIRTH_DATE)
VALUES(100,'SAAD','LUCKNOW',SYSDATE());
insert into person
(ID, NAME,LOCATION,BIRTH_DATE)
VALUES(101,'DAAS','KANPUR',SYSDATE());
insert into person
(ID, NAME,LOCATION,BIRTH_DATE)
VALUES(102,'SDAA','NOWLUCK',SYSDATE());