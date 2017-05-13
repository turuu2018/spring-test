/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : spring-test

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-05-13 13:34:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(64) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `registered_date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_logged_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `active` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'turuu@gmail.com', '$2a$10$/HeuvVbmm7i34GHkfpSb.uujsSLoRq9KTk891c5h2oS/J8t7/Odi.', 'T', 'Turuu', '2017-05-13 13:27:45', '2017-05-13 13:27:45', '');
INSERT INTO `user` VALUES ('2', 'bataa@gmail.com', '$2a$10$/HeuvVbmm7i34GHkfpSb.uujsSLoRq9KTk891c5h2oS/J8t7/Odi.', 'B', 'Bataa', '2017-05-13 13:27:46', '2017-05-13 13:27:46', '');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`,`role`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `user_role` VALUES ('2', 'ROLE_USER');
SET FOREIGN_KEY_CHECKS=1;
