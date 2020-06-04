
DROP TABLE IF EXISTS `product_descript_1`;

CREATE TABLE `product_descript_1` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `product_info_id` bigint(20) DEFAULT NULL COMMENT '所属商品id',
  `descript` longtext COMMENT '商品描述',
  `store_info_id` bigint(20) DEFAULT NULL COMMENT '所属店铺id',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_Reference_2` (`product_info_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `product_descript_1` */

insert  into `product_descript_1`(`id`,`product_info_id`,`descript`,`store_info_id`) values (1268443572253753347,1268443572253753346,'经典阿帕茶,经典的味道, 阿帕奇强烈推荐, 喝了这杯茶就是兄弟了!',2),(1268443572308279298,1268443572299890690,'经典阿帕茶,经典的味道, 阿帕奇强烈推荐, 喝了这杯茶就是兄弟了!',2),(1268443572396359683,1268443572396359682,'经典阿帕茶,经典的味道, 阿帕奇强烈推荐, 喝了这杯茶就是兄弟了!',2),(1268443572488634370,1268443572480245762,'经典阿帕茶,经典的味道, 阿帕奇强烈推荐, 喝了这杯茶就是兄弟了!',2),(1268453418478956545,1268453418457985026,'经典典明粥,给你爱的味道',2),(1268453418537676801,1268453418520899586,'经典典明粥,给你爱的味道',2),(1268453418718031873,1268453418709643266,'经典典明粥,给你爱的味道',2),(1268453418776752130,1268453418768363522,'经典典明粥,给你爱的味道',2),(1268453418843860995,1268453418843860994,'经典典明粥,给你爱的味道',2),(1268453418906775555,1268453418906775554,'经典典明粥,给你爱的味道',2),(1268453418982273026,1268453418969690114,'经典典明粥,给你爱的味道',2),(1268453419015827459,1268453419015827458,'经典典明粥,给你爱的味道',2),(1268453419108102145,1268453419095519234,'经典典明粥,给你爱的味道',2);

/*Table structure for table `product_descript_2` */

DROP TABLE IF EXISTS `product_descript_2`;

CREATE TABLE `product_descript_2` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `product_info_id` bigint(20) DEFAULT NULL COMMENT '所属商品id',
  `descript` longtext COMMENT '商品描述',
  `store_info_id` bigint(20) DEFAULT NULL COMMENT '所属店铺id',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_Reference_2` (`product_info_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `product_descript_2` */

insert  into `product_descript_2`(`id`,`product_info_id`,`descript`,`store_info_id`) values (1268443572157284353,1268443569393238017,'经典阿帕茶,经典的味道, 阿帕奇强烈推荐, 喝了这杯茶就是兄弟了!',2),(1268443572220198914,1268443572211810305,'经典阿帕茶,经典的味道, 阿帕奇强烈推荐, 喝了这杯茶就是兄弟了!',2),(1268443572354416641,1268443572333445121,'经典阿帕茶,经典的味道, 阿帕奇强烈推荐, 喝了这杯茶就是兄弟了!',2),(1268443572442497025,1268443572434108417,'经典阿帕茶,经典的味道, 阿帕奇强烈推荐, 喝了这杯茶就是兄弟了!',2),(1268443572513800194,1268443572513800193,'经典阿帕茶,经典的味道, 阿帕奇强烈推荐, 喝了这杯茶就是兄弟了!',2),(1268443572589297666,1268443572589297665,'经典阿帕茶,经典的味道, 阿帕奇强烈推荐, 喝了这杯茶就是兄弟了!',2),(1268453418315378689,1268453415236759553,'经典典明粥,给你爱的味道',2),(1268453418382487553,1268453418365710337,'经典典明粥,给你爱的味道',2),(1268453418432819202,1268453418420236289,'经典典明粥,给你爱的味道',2),(1268453418583814145,1268453418575425537,'经典典明粥,给你爱的味道',2),(1268453418638340097,1268453418617368577,'经典典明粥,给你爱的味道',2),(1268453418684477441,1268453418671894529,'经典典明粥,给你爱的味道',2),(1268453418793529346,1268453418793529345,'经典典明粥,给你爱的味道',2),(1268453419049381890,1268453419049381889,'经典典明粥,给你爱的味道',2);

/*Table structure for table `product_info_1` */

DROP TABLE IF EXISTS `product_info_1`;

CREATE TABLE `product_info_1` (
  `product_info_id` bigint(20) NOT NULL COMMENT 'id',
  `store_info_id` bigint(20) DEFAULT NULL COMMENT '所属店铺id',
  `product_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `spec` varchar(50) DEFAULT NULL COMMENT '规格',
  `region_code` varchar(50) DEFAULT NULL COMMENT '产地',
  `price` decimal(10,0) DEFAULT NULL COMMENT '商品价格',
  `image_url` varchar(100) DEFAULT NULL COMMENT '商品图片',
  PRIMARY KEY (`product_info_id`) USING BTREE,
  KEY `FK_Reference_1` (`store_info_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `product_info_1` */

insert  into `product_info_1`(`product_info_id`,`store_info_id`,`product_name`,`spec`,`region_code`,`price`,`image_url`) values (1268443572253753346,2,'阿帕茶','大杯','110100','60',NULL),(1268443572299890690,2,'阿帕茶','大杯','110100','60',NULL),(1268443572396359682,2,'阿帕茶','大杯','110100','60',NULL),(1268443572480245762,2,'阿帕茶','大杯','110100','60',NULL),(1268453418457985026,2,'经典典明粥','小碗','410000','120',NULL),(1268453418520899586,2,'经典典明粥','小碗','410000','120',NULL),(1268453418709643266,2,'经典典明粥','小碗','410000','120',NULL),(1268453418768363522,2,'经典典明粥','小碗','410000','120',NULL),(1268453418843860994,2,'经典典明粥','小碗','410000','120',NULL),(1268453418906775554,2,'经典典明粥','小碗','410000','120',NULL),(1268453418969690114,2,'经典典明粥','小碗','410000','120',NULL),(1268453419015827458,2,'经典典明粥','小碗','410000','120',NULL),(1268453419095519234,2,'经典典明粥','小碗','410000','120',NULL);

/*Table structure for table `product_info_2` */

DROP TABLE IF EXISTS `product_info_2`;

CREATE TABLE `product_info_2` (
  `product_info_id` bigint(20) NOT NULL COMMENT 'id',
  `store_info_id` bigint(20) DEFAULT NULL COMMENT '所属店铺id',
  `product_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `spec` varchar(50) DEFAULT NULL COMMENT '规格',
  `region_code` varchar(50) DEFAULT NULL COMMENT '产地',
  `price` decimal(10,0) DEFAULT NULL COMMENT '商品价格',
  `image_url` varchar(100) DEFAULT NULL COMMENT '商品图片',
  PRIMARY KEY (`product_info_id`) USING BTREE,
  KEY `FK_Reference_1` (`store_info_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `product_info_2` */

insert  into `product_info_2`(`product_info_id`,`store_info_id`,`product_name`,`spec`,`region_code`,`price`,`image_url`) values (1268443569393238017,2,'阿帕茶','大杯','110100','60',NULL),(1268443572211810305,2,'阿帕茶','大杯','110100','60',NULL),(1268443572333445121,2,'阿帕茶','大杯','110100','60',NULL),(1268443572434108417,2,'阿帕茶','大杯','110100','60',NULL),(1268443572513800193,2,'阿帕茶','大杯','110100','60',NULL),(1268443572589297665,2,'阿帕茶','大杯','110100','60',NULL),(1268453415236759553,2,'经典典明粥','小碗','410000','120',NULL),(1268453418365710337,2,'经典典明粥','小碗','410000','120',NULL),(1268453418420236289,2,'经典典明粥','小碗','410000','120',NULL),(1268453418575425537,2,'经典典明粥','小碗','410000','120',NULL),(1268453418617368577,2,'经典典明粥','小碗','410000','120',NULL),(1268453418671894529,2,'经典典明粥','小碗','410000','120',NULL),(1268453418793529345,2,'经典典明粥','小碗','410000','120',NULL),(1268453419049381889,2,'经典典明粥','小碗','410000','120',NULL);

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

