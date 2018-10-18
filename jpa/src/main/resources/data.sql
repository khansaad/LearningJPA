insert into course(id,name, created_date, last_updated_date)
values(100,'first course',sysdate(),sysdate());
insert into course(id,name, created_date, last_updated_date)
values(101,'second course',sysdate(),sysdate());
insert into course(id,name, created_date, last_updated_date)
values(102,'third course',sysdate(),sysdate());

insert into passport(id,number)
values(401,'E1234');
insert into passport(id,number)
values(402,'E1324');
insert into passport(id,number)
values(403,'E1342');

insert into student(id,name,passport_id)
values(201,'saad',401);
insert into student(id,name,passport_id)
values(202,'daas',402);
insert into student(id,name,passport_id)
values(203,'dasa',403);

insert into review(id,rating, description)
values(501,'5','great');
insert into review(id,rating, description)
values(502,'4','good');
insert into review(id,rating, description)
values(503,'3','Average');






--(ID, NAME,LOCATION,BIRTH_DATE)
--VALUES(100,'SAAD'

--insert into person
--(ID, NAME,LOCATION,BIRTH_DATE)
--VALUES(100,'SAAD','LUCKNOW',SYSDATE());
--insert into person
--(ID, NAME,LOCATION,BIRTH_DATE)
--VALUES(101,'DAAS','KANPUR',SYSDATE());
--insert into person
--(ID, NAME,LOCATION,BIRTH_DATE)
--VALUES(102,'SDAA','NOWLUCK',SYSDATE());