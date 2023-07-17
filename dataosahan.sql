create database osahaneat;
use osahaneat;
create table roles(
id int primary key auto_increment,
role_name varchar(30),
create_date timestamp
);
create table users(
id int primary key auto_increment,
user_name varchar(50),
password varchar(50),
fullname varchar(50),
create_date timestamp,
role_id int,
constraint fk_users_role_id foreign key(role_id) references roles(id)
);

create table rating_food(
id int primary key auto_increment,
user_id int,
food_id int,
content text,
rate_point int(5)
);
create table category(
id int primary key auto_increment,
name_cate varchar(50),
create_date timestamp
);

create table food(
id int primary key auto_increment,
title varchar(255),
image text,
time_ship varchar(20),
price decimal,
cate_id int
);

create table rating_restaurant(
id int primary key auto_increment,
user_id int,
res_id int,
content text,
rate_point int(5)
);
create table orders(
id int primary key auto_increment,
user_id int,
res_id int,
create_date timestamp
);
create table order_item(
order_id int ,
food_id int,
create_date timestamp,
primary key (order_id,food_id )
);
create table menu_restaurant(
cate_id int,
res_id int,
create_date timestamp,
primary key(cate_id, res_id)
);
create table restaurant(
id int primary key auto_increment,
title varchar(255),
subtitle varchar(255),
description text,
image text,
is_freeship boolean,
address varchar(255),
open_time timestamp
);
create table promo(
id int primary key auto_increment,
res_id int,
percent int,
start_date timestamp,
end_date timestamp
);
alter table rating_food add constraint fk_ratingfood_user_id foreign key(user_id) references users(id);
alter table rating_food add constraint fk_ratingfood_food_id foreign key(food_id) references food(id);
alter table food add constraint fk_ratingfood_cate_id foreign key(cate_id) references category(id);
alter table rating_restaurant add constraint fk_ratingrestaurant_user_id foreign key(user_id) references users(id);
alter table rating_restaurant add constraint fk_ratingrestaurant_res_id foreign key (res_id) references restaurant(id);
alter table orders add constraint fk_orders_user_id foreign key(user_id) references users(id);
alter table orders add constraint fk_orders_res_id foreign key(res_id) references restaurant(id);
alter table order_item add constraint fk_orderitem_food_id foreign key(food_id) references food(id);
alter table order_item add constraint fk_order_order_id foreign key(order_id) references orders(id);
alter table menu_restaurant add constraint fk_menurestaurant_cate_id foreign key(cate_id) references category(id);
alter table menu_restaurant add constraint fk_menurestaurant_res_id foreign key(res_id) references restaurant(id);
alter table promo add constraint fk_promo_res_id foreign key(res_id) references restaurant(id);


insert into roles(role_name) values("ROLE_ADMIN");
insert into roles(role_name) values("ROLE_USER");
insert into users(user_name,password,fullname,role_id) values("nguyentuanbap@gmail.com","123","nguyen tuan bap",2);
select * from users;
