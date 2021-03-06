/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.7.28-log : Database - store_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`store_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `store_db`;

/*Table structure for table `region` */

DROP TABLE IF EXISTS `region`;

CREATE TABLE `region` (
  `id` bigint(20) NOT NULL,
  `region_code` varchar(50) DEFAULT NULL COMMENT '地理区域编码',
  `region_name` varchar(100) DEFAULT NULL COMMENT '地理区域名称',
  `level` tinyint(1) DEFAULT NULL COMMENT '地理区域级别(省、市、县)',
  `parent_region_code` varchar(50) DEFAULT NULL COMMENT '上级地理区域编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `region` */

insert  into `region`(`id`,`region_code`,`region_name`,`level`,`parent_region_code`) values (1,'110000','北京',0,NULL),(2,'410000','河南省',0,NULL),(3,'110100','北京市',1,'110000'),(4,'410100','郑州市',1,'410000');

/*Table structure for table `store_info` */

DROP TABLE IF EXISTS `store_info`;

CREATE TABLE `store_info` (
  `id` bigint(20) NOT NULL,
  `store_name` varchar(100) DEFAULT NULL COMMENT '店铺名称',
  `reputation` int(11) DEFAULT NULL COMMENT '信誉等级',
  `region_code` varchar(50) DEFAULT NULL COMMENT '店铺所在地',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `store_info` */

insert  into `store_info`(`id`,`store_name`,`reputation`,`region_code`) values (1,'阿帕茶饮料店',4,'110100'),(2,'典明粥早餐车',3,'410100');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
