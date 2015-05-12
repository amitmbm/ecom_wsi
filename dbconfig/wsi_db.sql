drop DATABASE IF EXISTS `wsi_db`;
CREATE DATABASE IF NOT EXISTS `wsi_db`;
use `wsi_db`;

CREATE table product_category (
cat_guid varchar(36) primary key not null,
cat_name varchar(128) unique key not null, 
cat_desc varchar(512) not null,
created_by varchar(128),
updated_by varchar(128),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE table product_sub_category (
sub_cat_guid varchar(36) primary key not null, 
sub_cat_name varchar(128) unique key not null, 
sub_cat_desc varchar(512) not null, 
cat_guid varchar(36),
created_by varchar(128),
updated_by varchar(128),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
CONSTRAINT `product_sub_category_fk1` FOREIGN KEY (`cat_guid`) REFERENCES `product_category` (`cat_guid`) ON DELETE CASCADE
);

CREATE table product_sub_category_type(
type_guid varchar(36) primary key not null,
sub_cat_guid varchar(36) not null,
type_name varchar(128) not null,
created_by varchar(128),
updated_by varchar(128),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
CONSTRAINT `product_sub_category_type_fk1` FOREIGN KEY (`sub_cat_guid`) REFERENCES `product_sub_category` (`sub_cat_guid`) ON DELETE CASCADE
);

CREATE TABLE users(
user_email varchar(128) primary key not null,
user_passwd varchar(128) not null,
is_registerd tinyint(1) default 0,
user_key varchar(36),
created_by varchar(128),
updated_by varchar(128),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE user_profile(
first_name varchar(128) not null,
last_name varchar(128) not null,
phone_num bigint,
user_email varchar(128) primary key not null,
created_by varchar(128),
updated_by varchar(128),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
CONSTRAINT `user_profile_fk1` FOREIGN KEY (`user_email`) REFERENCES `users` (`user_email`) ON DELETE CASCADE
);

CREATE table post_add(
add_guid varchar(36) primary key not null,
sub_cat_guid varchar(36) not null,
type_guid varchar(36) not null,
add_desc varchar(2048) not null, 
price int not null,
negotiable tinyint(1) default 0,
user_email varchar(128) not null,
image_1 MEDIUMTEXT,
image_2 MEDIUMTEXT,
image_3 MEDIUMTEXT,
image_4 MEDIUMTEXT,
created_by varchar(128),
updated_by varchar(128),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
CONSTRAINT `post_add_fk1` FOREIGN KEY (`sub_cat_guid`) REFERENCES `product_sub_category` (`sub_cat_guid`) ON DELETE CASCADE,
CONSTRAINT `post_add_fk2` FOREIGN KEY (`type_guid`) REFERENCES `product_sub_category_type` (`type_guid`) ON DELETE CASCADE,
CONSTRAINT `post_add_fk3` FOREIGN KEY (`user_email`) REFERENCES `users` (`user_email`) ON DELETE CASCADE
);

CREATE index post_add_price_index on post_add (`price`);

alter table wsi_db.product_sub_category_type add unique key sub_cat_type_unique (`sub_cat_guid`, `type_name`);