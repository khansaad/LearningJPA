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

insert into review(id,rating, description,course_id)
values(501,'5','great',100);
insert into review(id,rating, description,course_id)
values(502,'4','good',101);
insert into review(id,rating, description,course_id)
values(503,'3','Average',102);

insert into student_course( student_id,course_id)
values(201,100);
insert into student_course( student_id,course_id)
values(202,101);
insert into student_course( student_id,course_id)
values(203,102);
insert into student_course( student_id,course_id)
values(201,101);
