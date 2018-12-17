/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : wedding

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-12-14 17:42:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for barrage
-- ----------------------------
DROP TABLE IF EXISTS `barrage`;
CREATE TABLE `barrage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  `position` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of barrage
-- ----------------------------
INSERT INTO `barrage` VALUES ('2', 'red', 'asdafa', '0', '10', '0');
INSERT INTO `barrage` VALUES ('3', 'green', '啊哈', '1', '30', '0');
INSERT INTO `barrage` VALUES ('18', 'purple', '1', '1', '1', '0');
INSERT INTO `barrage` VALUES ('19', 'grenn', '哈哈', '1', '1', '0');
INSERT INTO `barrage` VALUES ('20', 'purple', '1111', '1', '1', '0');
INSERT INTO `barrage` VALUES ('21', 'purple', '1', '1', '30', '0');
INSERT INTO `barrage` VALUES ('22', 'brown', '再见', '1', '114', '0');
INSERT INTO `barrage` VALUES ('23', 'purple', '哈哈', '1', '238', '0');
INSERT INTO `barrage` VALUES ('24', 'white', '阿斯大苏打', '1', '46', '0');
INSERT INTO `barrage` VALUES ('25', 'white', '我的', '1', '42', '0');
INSERT INTO `barrage` VALUES ('26', 'grenn', '阿斯玛', '1', '151', '0');
INSERT INTO `barrage` VALUES ('27', 'purple', '1', '1', '179', '0');
INSERT INTO `barrage` VALUES ('28', 'syan', '2', '1', '194', '0');
INSERT INTO `barrage` VALUES ('29', 'syan', '3', '1', '204', '0');
INSERT INTO `barrage` VALUES ('30', 'brown', '4', '1', '214', '0');
INSERT INTO `barrage` VALUES ('31', 'syan', '5', '1', '223', '0');
INSERT INTO `barrage` VALUES ('32', 'blue', 'ad奥迪', '1', '243', '0');
INSERT INTO `barrage` VALUES ('33', 'brown', '234 ', '1', '270', '0');
INSERT INTO `barrage` VALUES ('34', 'red', '123', '1', '284', '0');
INSERT INTO `barrage` VALUES ('35', 'blue', 'ad', '1', '302', '0');
INSERT INTO `barrage` VALUES ('36', 'purple', 'ad才执行', '1', '320', '0');
INSERT INTO `barrage` VALUES ('37', 'grenn', '大幅度发', '1', '338', '0');
INSERT INTO `barrage` VALUES ('38', 'brown', '请问权威', '1', '358', '0');
INSERT INTO `barrage` VALUES ('39', 'purple', '挨打的', '1', '377', '0');
INSERT INTO `barrage` VALUES ('40', 'purple', '撒旦', '1', '31', '0');
INSERT INTO `barrage` VALUES ('41', 'purple', '奥迪', '1', '54', '0');
INSERT INTO `barrage` VALUES ('42', 'grenn', '请问', '1', '65', '0');
INSERT INTO `barrage` VALUES ('43', 'brown', '线程在', '1', '79', '0');
INSERT INTO `barrage` VALUES ('44', 'brown', '的冯绍峰', '1', '91', '0');
INSERT INTO `barrage` VALUES ('45', 'blue', '驱蚊器', '1', '103', '0');
INSERT INTO `barrage` VALUES ('46', 'yellow', '的方式f ', '1', '120', '0');
INSERT INTO `barrage` VALUES ('47', 'grenn', '情而起 ', '1', '137', '0');
INSERT INTO `barrage` VALUES ('48', 'yellow', '1231 ', '1', '150', '0');
INSERT INTO `barrage` VALUES ('49', 'brown', '小城镇创造性', '1', '167', '0');
INSERT INTO `barrage` VALUES ('50', 'grenn', '范德萨斯蒂芬', '1', '181', '0');
INSERT INTO `barrage` VALUES ('51', 'grenn', '情而起无', '1', '194', '0');
INSERT INTO `barrage` VALUES ('52', 'blue', '阿达', '1', '209', '0');
INSERT INTO `barrage` VALUES ('53', 'gray', '防守对方', '1', '222', '0');
INSERT INTO `barrage` VALUES ('54', 'white', 'zxczxczxczcxzcxxczxczxsssfffscfxxz', '1', '235', '0');
INSERT INTO `barrage` VALUES ('55', 'gray', '啊苏打水', '1', '248', '0');
INSERT INTO `barrage` VALUES ('56', 'brown', '俄武器二', '1', '261', '0');
INSERT INTO `barrage` VALUES ('57', 'gray', '啊四大', '1', '44', '0');
INSERT INTO `barrage` VALUES ('58', 'yellow', '我', '1', '147', '0');
INSERT INTO `barrage` VALUES ('59', 'yellow', '速度', '1', '87', '0');
INSERT INTO `barrage` VALUES ('60', 'blue', '11111111', '1', '148', '0');
INSERT INTO `barrage` VALUES ('61', 'purple', '指指阿', '1', '187', '0');
INSERT INTO `barrage` VALUES ('62', 'red', '卡路里', '1', '243', '0');
