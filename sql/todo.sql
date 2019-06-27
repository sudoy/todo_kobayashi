
create table todo(
 number int,
 title varchar(50),
 detail varchar(100),
 priority varchar(3),
 deadline date 
);

insert into todo(number, title, detail, priority, deadline)
values(1,'テストテスト','SQLの確認テストの採点と報告書を作成する。','★★★','2015-06-20');

insert into todo(number, title, detail, priority, deadline)
values(2,'テストテスト','SQLの確認テストの採点と報告書を作成する。','★','2015-06-20');

insert into todo(number, title, detail, priority, deadline)
values(3,'テストテスト','SQLの確認テストの採点と報告書を作成する。','★★★','2015-06-20');

insert into todo(number, title, detail, priority, deadline)
values(4,'テストテスト','SQLの確認テストの採点と報告書を作成する。', '★★★',null);

