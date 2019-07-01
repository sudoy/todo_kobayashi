
create table todo(
 number int primary key auto_increment,
 title varchar(100),
 detail varchar(100),
 priority varchar(3),
 deadline date
);

insert into todo(number, title, detail, priority, deadline)
values(1,'テスト1','SQLの確認テストの採点と報告書を作成する。','★★★','2015-06-20');

insert into todo(number, title, detail, priority, deadline)
values(2,'テスト2','SQLの確認テストの採点と報告書を作成する。','★','2015-06-22');

insert into todo(number, title, detail, priority, deadline)
values(3,'テスト3','SQLの確認テストの採点と報告書を作成する。','★★★','2015-06-20');

insert into todo(number, title, detail, priority, deadline)
values(4,'テスト4','SQLの確認テストの採点と報告書を作成する。', '★★',null);

