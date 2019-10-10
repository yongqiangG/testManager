/*
Navicat MySQL Data Transfer

Source Server         : txy
Source Server Version : 50643
Source Host           : localhost:3306
Source Database       : johnnyblog

Target Server Type    : MYSQL
Target Server Version : 50643
File Encoding         : 65001

Date: 2019-10-10 11:30:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bug`
-- ----------------------------
DROP TABLE IF EXISTS `bug`;
CREATE TABLE `bug` (
  `bug_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'bugID',
  `product_id` int(11) NOT NULL COMMENT '外键产品ID',
  `module_id` int(11) NOT NULL COMMENT '外键模块ID',
  `project_id` int(11) NOT NULL COMMENT '外键项目ID',
  `version` varchar(100) DEFAULT NULL COMMENT '版本号',
  `person_id` int(11) NOT NULL COMMENT '外键指派人员ID',
  `deadline` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '截止日期',
  `bugtype_id` int(11) NOT NULL COMMENT '外键bug类型id',
  `bug_title` varchar(100) DEFAULT NULL COMMENT 'bug标题',
  `bug_content` varchar(20000) DEFAULT NULL,
  `bug_content_withoutHtml` text,
  PRIMARY KEY (`bug_id`),
  KEY `product_id` (`product_id`),
  KEY `module_id` (`module_id`),
  KEY `project_id` (`project_id`),
  KEY `person_id` (`person_id`),
  KEY `bugtype_id` (`bugtype_id`),
  CONSTRAINT `bug_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `bug_ibfk_2` FOREIGN KEY (`module_id`) REFERENCES `module` (`module_id`),
  CONSTRAINT `bug_ibfk_3` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`),
  CONSTRAINT `bug_ibfk_4` FOREIGN KEY (`person_id`) REFERENCES `fixup_person` (`person_id`),
  CONSTRAINT `bug_ibfk_5` FOREIGN KEY (`bugtype_id`) REFERENCES `bugtype` (`bugtype_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bug
-- ----------------------------

-- ----------------------------
-- Table structure for `bugtype`
-- ----------------------------
DROP TABLE IF EXISTS `bugtype`;
CREATE TABLE `bugtype` (
  `bugtype_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'bug类型id',
  `bugtype_name` varchar(100) DEFAULT NULL COMMENT 'bug类型名称',
  PRIMARY KEY (`bugtype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bugtype
-- ----------------------------
INSERT INTO `bugtype` VALUES ('1', '代码错误');
INSERT INTO `bugtype` VALUES ('2', '安全相关');
INSERT INTO `bugtype` VALUES ('3', '性能问题');
INSERT INTO `bugtype` VALUES ('4', '规范问题');
INSERT INTO `bugtype` VALUES ('5', '设计缺陷');
INSERT INTO `bugtype` VALUES ('6', '其他');

-- ----------------------------
-- Table structure for `fixup_person`
-- ----------------------------
DROP TABLE IF EXISTS `fixup_person`;
CREATE TABLE `fixup_person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'bug指派人员id',
  `person_name` varchar(100) DEFAULT NULL COMMENT 'bug指派人员名称',
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fixup_person
-- ----------------------------
INSERT INTO `fixup_person` VALUES ('1', 'MARK');
INSERT INTO `fixup_person` VALUES ('2', 'JOHNNY');
INSERT INTO `fixup_person` VALUES ('3', 'MESSI');
INSERT INTO `fixup_person` VALUES ('4', 'KRYSTRAL');
INSERT INTO `fixup_person` VALUES ('5', '陈一一');
INSERT INTO `fixup_person` VALUES ('6', '刘星');
INSERT INTO `fixup_person` VALUES ('7', '陈二二');

-- ----------------------------
-- Table structure for `module`
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模块id',
  `module_name` varchar(100) DEFAULT NULL COMMENT '模块名称',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('1', '模块1');
INSERT INTO `module` VALUES ('2', '模块2');
INSERT INTO `module` VALUES ('3', '模块3');
INSERT INTO `module` VALUES ('4', '模块4');
INSERT INTO `module` VALUES ('5', '温控器');
INSERT INTO `module` VALUES ('6', '其他');
INSERT INTO `module` VALUES ('7', '模块5');
INSERT INTO `module` VALUES ('8', '模块6');
INSERT INTO `module` VALUES ('9', '模块7');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `product_name` varchar(100) DEFAULT NULL COMMENT '产品名称',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '产品1');
INSERT INTO `product` VALUES ('2', '产品2');
INSERT INTO `product` VALUES ('3', '产品3');
INSERT INTO `product` VALUES ('4', '其他');

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '项目id',
  `project_name` varchar(100) DEFAULT NULL COMMENT '项目名称',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '项目1.0');
INSERT INTO `project` VALUES ('2', '项目2.0');
INSERT INTO `project` VALUES ('3', '项目3.0');
INSERT INTO `project` VALUES ('4', '其他');
