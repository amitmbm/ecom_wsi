-- Dumping database structure for olx_db  
CREATE DATABASE IF NOT EXISTS `olx_db` ;

USE `olx_db`;

CREATE TABLE  "user" (
  "id" bigint(20) NOT NULL AUTO_INCREMENT,
  "first_name" varchar(45) DEFAULT NULL,
  "last_name" varchar(45) DEFAULT NULL,
  "email" varchar(45) DEFAULT NULL,
  "phone" varchar(45) DEFAULT NULL,
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table olx_db.user: ~1 rows (approximately)  
 
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `phone`) VALUES  
 (2, 'Hoston', 'lindey', 'hl@gmail.com', '90908989899');

 
-- Dumping structure for table olx_db.user
CREATE TABLE IF NOT EXISTS `category` (
  `cat_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(120) DEFAULT NULL,
  `desc` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table olx_db.category: ~1 rows (approximately)

INSERT INTO `category` (`cat_id`, `category_name`, `desc` ) VALUES
 (1, 'mobile And Tablets', 'mobile tabletes and accessories');
