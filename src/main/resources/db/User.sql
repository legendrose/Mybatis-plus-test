-- auto Generated on 2021-04-07
-- DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user(
	id BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`name` VARCHAR (50) UNIQUE NOT NULL COMMENT '名称',
	age INT (11) NOT NULL COMMENT '年龄',
	email VARCHAR (50) NOT NULL COMMENT '电子邮箱',
UNIQUE `ux_name`(name),
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 't_user';
