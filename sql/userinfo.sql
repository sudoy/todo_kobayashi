create table userinfo(
number int primary key auto_increment,
email varchar(100),
pass varchar(20),
name varchar(30)
);

insert into userinfo(email, pass, name)values('guest@mail.com', '1111', 'guest1');

insert into userinfo(email, pass, name)values('yuichi.sudo@ssie.jp', '0000', '須藤雄一');