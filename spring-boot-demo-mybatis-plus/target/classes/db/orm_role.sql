/*
Navicat MySQL Data Transfer

Source Server         : 本机数据库
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : spring_boot_test

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2020-07-17 16:16:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orm_role
-- ----------------------------
DROP TABLE IF EXISTS `orm_role`;
CREATE TABLE `orm_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Spring Boot Demo Orm 系列示例表';

-- ----------------------------
-- Records of orm_role
-- ----------------------------
INSERT INTO `orm_role` VALUES ('2', '普通用户');
INSERT INTO `orm_role` VALUES ('1', '管理员');
