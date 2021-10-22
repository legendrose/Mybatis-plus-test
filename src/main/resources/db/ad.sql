/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.0.90-community-nt-log : Database - ad
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ad` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ad`;

/*Table structure for table `t_app` */

DROP TABLE IF EXISTS `t_app`;

CREATE TABLE `t_app` (
  `APPID` varchar(50) NOT NULL,
  `APPNAME` varchar(50) default NULL,
  `APPDESC` text,
  `USERNAME` varchar(20) NOT NULL,
  `CREATEDATE` date default NULL,
  PRIMARY KEY  (`APPID`),
  KEY `FK_USERNAME` (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_app` */

insert  into `t_app`(`APPID`,`APPNAME`,`APPDESC`,`USERNAME`,`CREATEDATE`) values ('sdfsdfsdf',NULL,NULL,'12321','2021-04-08');

/*Table structure for table `t_device` */

DROP TABLE IF EXISTS `t_device`;

CREATE TABLE `t_device` (
  `DEVICEID` bigint(20) NOT NULL auto_increment,
  `DEVICECODE` varchar(50) default NULL,
  `DEVICENAME` varchar(20) NOT NULL,
  `DEVICEGROUP` varchar(50) default NULL COMMENT '设备分组字段',
  `DEVICEDESC` text,
  `LNG` varchar(50) default '0',
  `LAT` varchar(50) default '0',
  `ADDRESS` varchar(100) default NULL,
  `DEVICETYPECODE` varchar(50) default NULL,
  `DEVICETYPENAME` varchar(50) default NULL,
  `COMPCODE` varchar(50) default NULL COMMENT '公司编号',
  `COMPNAME` varchar(50) default NULL,
  `ADUPGRADETYPE` tinyint(4) NOT NULL COMMENT '广告升级类型（1-平台升级，2-非平台升级）',
  `CREATETIME` datetime default NULL,
  `EDITTIME` datetime default NULL,
  `CREATOR` varchar(50) default NULL,
  PRIMARY KEY  (`DEVICEID`),
  UNIQUE KEY `UNIQUE_CODE_NAME_TYPECODE` (`DEVICECODE`,`DEVICENAME`,`DEVICETYPECODE`),
  KEY `FK_DEVICE_COMP` (`COMPCODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_device` */

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `role_id` bigint(15) NOT NULL auto_increment COMMENT 'roleId',
  `name` varchar(50) NOT NULL COMMENT 'name',
  `desc` varchar(50) NOT NULL COMMENT 'desc',
  `user_name` varchar(50) NOT NULL COMMENT 'userName',
  PRIMARY KEY  (`role_id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='t_role';

/*Data for the table `t_role` */

insert  into `t_role`(`role_id`,`name`,`desc`,`user_name`) values (1,'管理员','管理员','2134456'),(2,'其他','其他','2134456');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(15) NOT NULL auto_increment COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `age` int(11) NOT NULL COMMENT '年龄',
  `email` varchar(50) NOT NULL COMMENT '电子邮箱',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `ux_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1380089163439345671 DEFAULT CHARSET=utf8 COMMENT='t_user';

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`name`,`age`,`email`) values (1380089163439345667,'2134456',11,'wer'),(1380089163439345668,'123123',11,'wer'),(1380089163439345669,'213445发彻底删除6',11,'w谁主浮沉er'),(1380089163439345670,'123123sad',11,'we需r');

/*Table structure for table `x_test` */

DROP TABLE IF EXISTS `x_test`;

CREATE TABLE `x_test` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `x_name` varchar(255) NOT NULL,
  `x_time` int(10) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `x_test` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
