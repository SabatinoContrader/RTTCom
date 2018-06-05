drop table product;
create table product (bar_code int,category varchar(50), subcategory varchar(50), model varchar(50), manufacturer varchar(50), price float,primary key (bar_code));
insert into  product (bar_code,category, subcategory, model, manufacturer, price) values (111,'Veicoli','Gomma','Trelleborg-B50', 'Trelleborg', 321.13);
insert into  product (bar_code,category, subcategory, model, manufacturer, price) values (1112,'Arredamento', 'Tavolo', 'Legno metalizzato', 'Scavolini', 213.176);
insert into  product (bar_code,category, subcategory, model, manufacturer, price) values (11332,'Arredamento', 'Divano', 'Divano Letto', 'Divani&Divani', 215.176);

drop table profit;
create table profit (id_product int,ecommerce_name varchar(100),profit_margin int,primary key(id_product,ecommerce_name),foreign key (id_product) references product(bar_code));
insert into profit (id_product,ecommerce_name,profit_margin) values(111,"amazon",200);
insert into profit (id_product,ecommerce_name,profit_margin) values(111,"ebay",300);

drop table users;
create table users (id_user int auto_increment,username varchar(100),passw varchar(100),primary key(id_user));
insert into users (username,passw) values('ciccio','bello');
