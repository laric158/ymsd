/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-07-31 15:30:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `weight` double(5,2) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '小明', '65.50', '21');
INSERT INTO `student` VALUES ('2', '小红', '45.20', '20');

-- ----------------------------
-- Table structure for typing_score
-- ----------------------------
DROP TABLE IF EXISTS `typing_score`;
CREATE TABLE `typing_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `score` int(11) NOT NULL COMMENT '分数',
  `time` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='打字游戏得分';

-- ----------------------------
-- Records of typing_score
-- ----------------------------
INSERT INTO `typing_score` VALUES ('1', '3500', '30');
INSERT INTO `typing_score` VALUES ('2', '3500', '30');
INSERT INTO `typing_score` VALUES ('3', '3700', '30');
INSERT INTO `typing_score` VALUES ('4', '3600', '30');
INSERT INTO `typing_score` VALUES ('5', '4100', '30');
INSERT INTO `typing_score` VALUES ('6', '3800', '30');
INSERT INTO `typing_score` VALUES ('7', '3900', '30');
INSERT INTO `typing_score` VALUES ('8', '0', '30');
INSERT INTO `typing_score` VALUES ('9', '3600', '30');
INSERT INTO `typing_score` VALUES ('10', '0', '30');

-- ----------------------------
-- Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `context` longtext COMMENT '内容',
  `imgUrl` varchar(200) DEFAULT NULL COMMENT '图片地址',
  `viewCount` int(11) DEFAULT NULL COMMENT '观看次数',
  `isRecommend` bit(1) DEFAULT NULL COMMENT '是否推荐',
  `inputDate` datetime DEFAULT NULL COMMENT '录入日期',
  `type_id` bigint(20) DEFAULT NULL COMMENT '新闻类型ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '录入人ID',
  `imgSmallUrl` varchar(255) DEFAULT NULL COMMENT '小图地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_news
-- ----------------------------
INSERT INTO `t_news` VALUES ('1', '测试一下', '<p>33333333</p>', null, '0', '\0', '2019-06-15 18:48:26', '1', '1', null);
INSERT INTO `t_news` VALUES ('2', '写一个2333', '<p>很好的一个图片</p><p><img src=\"/plugin/ueditor/utf8-jsp/jsp/upload/image/20190620/1529482250712058757.jpg\" title=\"1560997842003087843.jpg\" alt=\"程序猿标配.jpg\"/></p>', null, '0', '', '2019-06-20 10:30:58', '1', '1', null);
INSERT INTO `t_news` VALUES ('3', '看一下测试', '<p>一张很好看的图片</p><p><img src=\"/ymkx-ssm/ymkx-ssm/plugin/ueditor/utf8-jsp/jsp/upload/image/20190620/1561009263111005794.jpg\" title=\"1561009263111005794.jpg\" alt=\"程序猿标配.jpg\"/></p>', null, '0', '', '2019-06-20 13:41:49', '1', '1', null);
INSERT INTO `t_news` VALUES ('4', '你猜', '9985441524513', null, '0', '', '2019-07-30 15:15:32', '2', '1', null);
INSERT INTO `t_news` VALUES ('5', '试一试图片', '<p>来，看一看图片会不会成功<img src=\"/ymkx-cms/ymkx-cms/plugin/ueditor/jsp/upload/image/20190730/1564471566497010734.png\" title=\"1564471566497010734.png\" alt=\"ymsd.png\"/></p>', null, '0', '', '2019-07-30 15:26:11', '1', '1', null);

-- ----------------------------
-- Table structure for t_newstype
-- ----------------------------
DROP TABLE IF EXISTS `t_newstype`;
CREATE TABLE `t_newstype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_newstype
-- ----------------------------
INSERT INTO `t_newstype` VALUES ('1', '实时新闻');
INSERT INTO `t_newstype` VALUES ('2', '热点新闻');
INSERT INTO `t_newstype` VALUES ('3', '舆论新闻');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` int(20) NOT NULL,
  `isLogin` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '1', null);
INSERT INTO `t_user` VALUES ('2', 'admin1', 'e10adc3949ba59abbe56e057f20f883e', '1', null);
INSERT INTO `t_user` VALUES ('3', '1', 'c81e728d9d4c2f636f067f89cc14862c', '1', '0');
