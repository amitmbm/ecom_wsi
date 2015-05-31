drop DATABASE IF EXISTS `order_product`;
CREATE DATABASE IF NOT EXISTS `order_product`;
use `order_product`;

CREATE table product (
product_id varchar(6)  ,
product_name varchar(128) , 
product_desc varchar(512) 
);

CREATE table order_table (
order_id varchar(6) , 
order_name varchar(128) ,
product_id varchar(6)
);

insert into product values (1,"tv","electronics");
insert into product values (2,"mobile","electronics");
insert into product values(3,"fridge","electronics");
insert into product values(4,"AC","electronics");
insert into product values(null,"AC_hitachi","electronics");

insert into order_table values (1,"tv_order",1);
insert into order_table values (2,"samsung_tv_order",1);
insert into order_table values(3,"fridge_order",3);
insert into order_table values(4,"AC_order",4);
insert into order_table values(5,"AC_ord",null);
insert into order_table values(null,"tablet_order",null);

select order_name , product_name from order_table o , product p where o.product_id=p.product_id; -- example of inner_join

select order_name , product_name from product p left join order_table o on o.product_id=p.product_id; -- example of left_join

select order_name , product_name from product p right join order_table o on o.product_id=p.product_id; -- example of right_join

 -- select order_name , product_name from product p outer join order_table o on p.product_id=o.product_id;  -- mysql doesn’t support full join but we can emulate using union of left and right join.


