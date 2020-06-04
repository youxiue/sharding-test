/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.7.28-log : Database - user_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`user_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `user_db`;

/*Table structure for table `t_dict` */

DROP TABLE IF EXISTS `t_dict`;

CREATE TABLE `t_dict` (
  `dict_id` bigint(20) NOT NULL COMMENT '字典ID',
  `type` varchar(50) DEFAULT NULL COMMENT '字典类型',
  `code` varchar(50) DEFAULT NULL COMMENT '字典编码',
  `value` varchar(50) DEFAULT NULL COMMENT '字典值',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_dict` */

insert  into `t_dict`(`dict_id`,`type`,`code`,`value`) values (1,'user_type','0','管理员'),(2,'user_type','1','操作员');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` bigint(20) NOT NULL,
  `fullname` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `user_type` varchar(10) DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`user_id`,`fullname`,`user_type`) values (0,'JOJO0','0'),(1,'JOJO1','0'),(2,'JOJO2','0'),(3,'JOJO3','0'),(4,'JOJO4','0'),(5,'JOJO5','0'),(6,'JOJO6','1'),(7,'JOJO7','0'),(8,'JOJO8','0'),(9,'JOJO9','0'),(10,'JOJO10','0'),(11,'JOJO11','1'),(12,'JOJO12','1'),(13,'JOJO13','1'),(14,'JOJO14','1'),(15,'JOJO15','1'),(16,'JOJO16','1'),(17,'JOJO17','1'),(18,'JOJO18','1'),(19,'JOJO19','1'),(20,'JOJO20',NULL),(21,'JOJO21',NULL),(22,'JOJO22',NULL),(23,'JOJO23',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
