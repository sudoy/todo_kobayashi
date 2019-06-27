
create table todo(
 number int,
 title varchar(50),
 priority varchar(3),
 deadline date 
);

insert into todo(number, title, priority, deadline)
values(1,'テストテスト','★★★','2015-06-20');

insert into todo(number, title, priority, deadline)
values(2,'テストテスト','★','2015-06-20');

insert into todo(number, title, priority, deadline)
values(3,'テストテスト','★★★','2015-06-20');

insert into todo(number, title, priority, deadline)
values(4,'テストテスト','★★★',null);

