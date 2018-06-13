drop table product;
create table product (id_product int, ean int, category varchar(100), model varchar(100), manufacturer varchar(50), primary key (id_product));
insert into  product (id_product, ean, category, model, manufacturer) values (1045,4000123,'categ1','model2','Brico');
insert into  product (id_product, ean, category, model, manufacturer) values (1079,4266511,'categ2','model3','Brico');
insert into  product (id_product, ean, category, model, manufacturer) values (1115,2260555,'categ2','model6','Brico');
insert into  product (id_product, ean, category, model, manufacturer) values (1155,2260545,'categ4','model1','Brico');
insert into  product (id_product, ean, category, model, manufacturer) values (1937,2260545,'categ3','model5','Brico');
insert into  product (id_product, ean, category, model, manufacturer) values (2045,4000123,'categ1','model3','inditex');
insert into  product (id_product, ean, category, model, manufacturer) values (2079,4266511,'categ2','model3','inditex');
insert into  product (id_product, ean, category, model, manufacturer) values (2115,2260555,'categ2','model6','inditex');
insert into  product (id_product, ean, category, model, manufacturer) values (2155,2260545,'categ4','model1','inditex');
insert into  product (id_product, ean, category, model, manufacturer) values (2937,2260545,'categ3','model2','inditex');
insert into  product (id_product, ean, category, model, manufacturer) values (3045,4000123,'categ1','model2','leroyMerlyn');
insert into  product (id_product, ean, category, model, manufacturer) values (3079,4266511,'categ2','model3','leroyMerlyn');
insert into  product (id_product, ean, category, model, manufacturer) values (3115,2260555,'categ2','model6','leroyMerlyn');
insert into  product (id_product, ean, category, model, manufacturer) values (3155,226545,'categ4','model1','leroyMerlyn');
insert into  product (id_product, ean, category, model, manufacturer) values (3937,2260545,'categ3','model5','leroyMerlyn');

drop table profit;
create table profit (id_product int,ecommerce_name varchar(100),profit_margin int,primary key(id_product,ecommerce_name),foreign key (id_product) references product(id_product));
insert into profit (id_product,ecommerce_name,profit_margin) values(111,"amazon",200);
insert into profit (id_product,ecommerce_name,profit_margin) values(111,"ebay",300);


drop table fornitore;
create table fornitore (id_product int, id_fornitore int, data_inizio date, data_fine date, prezzo_acquisto double, primary key(id_fornitore), foreign key (id_product) references product(id_product)on delete cascade);
insert into fornitore (id_product,id_fornitore,data_inizio,data_fine,prezzo_acquisto) values(1045,110928,20180606,20180706,324.18);
insert into fornitore (id_product,id_fornitore,data_inizio,data_fine,prezzo_acquisto) values(1079,110945,20180606,null,174.18);
insert into fornitore (id_product,id_fornitore,data_inizio,data_fine,prezzo_acquisto) values(2115,113328,20180106,20180306,224.18);
insert into fornitore (id_product,id_fornitore,data_inizio,data_fine,prezzo_acquisto) values(3155,226545,20180101,null,188.11);
insert into fornitore (id_product,id_fornitore,data_inizio,data_fine,prezzo_acquisto) values(1937,409012,20180423,null,111.99);

drop table users;
create table users (username varchar(100),pswd varchar(100),primary key(username));
insert into users (username,pswd) values('ciccio','bello');
insert into users (username,pswd) values('pippo','paperino');

drop table canale;
create table canale (id_product int, id_canale int,data_inizio date, data_fine date,profit_margin int, price double, primary key(id_product,id_canale));
insert into canale (id_product,id_canale,data_inizio,data_fine,profit_margin,price) values(1112,1,20130606,null,10,35.4);