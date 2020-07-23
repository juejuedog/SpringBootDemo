/*
Navicat MySQL Data Transfer

Source Server         : 本机数据库
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : spring_boot_test

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2020-07-17 16:17:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orm_user
-- ----------------------------
DROP TABLE IF EXISTS `orm_user`;
CREATE TABLE `orm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '加密后的密码',
  `salt` varchar(32) NOT NULL COMMENT '加密使用的盐',
  `email` varchar(32) NOT NULL COMMENT '邮箱',
  `phone_number` varchar(15) NOT NULL COMMENT '手机号码',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '状态，-1：逻辑删除，0：禁用，1：启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '上次更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='Spring Boot Demo Orm 系列示例表';

-- ----------------------------
-- Records of orm_user
-- ----------------------------
INSERT INTO `orm_user` VALUES ('2', 'user_2', '6c6bf02c8d5d3d128f34b1700cb1e32c', 'fcbdd0e8a9404a5585ea4e01d0e4d7a0', 'user2@xkcoding.com', '17300000002', '1', null, null, null);
INSERT INTO `orm_user` VALUES ('3', 'MybatisPlus修改名字', '123456456', '456', 'testSave3@xkcoding.com', '17300000003', '1', '2020-07-17 14:52:15', '2020-07-17 14:52:15', '2020-07-17 15:05:46');
INSERT INTO `orm_user` VALUES ('4', 'testSave4', '123456456', '456', 'testSave4@xkcoding.com', '17300000004', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('5', 'testSave5', '123456456', '456', 'testSave5@xkcoding.com', '17300000005', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('6', 'testSave6', '123456456', '456', 'testSave6@xkcoding.com', '17300000006', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('7', 'testSave7', '123456456', '456', 'testSave7@xkcoding.com', '17300000007', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('8', 'testSave8', '123456456', '456', 'testSave8@xkcoding.com', '17300000008', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('9', 'testSave9', '123456456', '456', 'testSave9@xkcoding.com', '17300000009', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('10', 'testSave10', '123456456', '456', 'testSave10@xkcoding.com', '173000000010', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('11', 'testSave11', '123456456', '456', 'testSave11@xkcoding.com', '173000000011', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('12', 'testSave12', '123456456', '456', 'testSave12@xkcoding.com', '173000000012', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('13', 'testSave13', '123456456', '456', 'testSave13@xkcoding.com', '173000000013', '1', '2020-07-17 14:52:51', '2020-07-17 14:52:51', '2020-07-17 14:52:51');
INSERT INTO `orm_user` VALUES ('24', 'testSave14', '123456456', '456', 'testSave14@xkcoding.com', '173000000014', '1', '2020-07-17 15:16:00', '2020-07-17 15:16:00', '2020-07-17 15:16:00');
INSERT INTO `orm_user` VALUES ('25', 'testSave15', '123456456', '456', 'testSave15@xkcoding.com', '173000000015', '1', '2020-07-17 15:16:00', '2020-07-17 15:16:00', '2020-07-17 15:16:00');
INSERT INTO `orm_user` VALUES ('26', 'testSave16', '123456456', '456', 'testSave16@xkcoding.com', '173000000016', '1', '2020-07-17 15:16:00', '2020-07-17 15:16:00', '2020-07-17 15:16:00');
INSERT INTO `orm_user` VALUES ('27', 'testSave17', '123456456', '456', 'testSave17@xkcoding.com', '173000000017', '1', '2020-07-17 15:16:00', '2020-07-17 15:16:00', '2020-07-17 15:16:00');
INSERT INTO `orm_user` VALUES ('28', 'testSave18', '123456456', '456', 'testSave18@xkcoding.com', '173000000018', '1', '2020-07-17 15:16:00', '2020-07-17 15:16:00', '2020-07-17 15:16:00');
INSERT INTO `orm_user` VALUES ('29', 'testSave19', '123456456', '456', 'testSave19@xkcoding.com', '173000000019', '1', '2020-07-17 15:16:00', '2020-07-17 15:16:00', '2020-07-17 15:16:00');
