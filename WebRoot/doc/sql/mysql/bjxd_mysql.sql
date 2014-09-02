/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : bjxd_mysql

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2014-09-02 22:53:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_ur_faq
-- ----------------------------
DROP TABLE IF EXISTS `t_ur_faq`;
CREATE TABLE `t_ur_faq` (
  `id` varchar(32) NOT NULL,
  `faq_code` varchar(32) NOT NULL DEFAULT '-1',
  `question` varchar(256) DEFAULT NULL,
  `answer` varchar(4000) DEFAULT NULL,
  `answer_type` int(6) NOT NULL DEFAULT '0',
  `picture_path_last` varchar(256) DEFAULT NULL,
  `picture_path_any` varchar(1024) DEFAULT NULL,
  `faq_file_url_any` varchar(1024) DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_user_name` varchar(32) DEFAULT NULL,
  `faq_type_id` varchar(32) NOT NULL DEFAULT '-1',
  `click_num` int(11) NOT NULL DEFAULT '0',
  `praise_num` int(11) NOT NULL DEFAULT '0',
  `debase_num` int(11) NOT NULL DEFAULT '0',
  `fav_num` int(11) NOT NULL DEFAULT '0',
  `add_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_datetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `effect_datetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `invalid_datetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `last_update_datetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_user_name` varchar(64) DEFAULT NULL,
  `enable` int(6) NOT NULL DEFAULT '1',
  `sort` int(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ur_faq
-- ----------------------------

-- ----------------------------
-- Table structure for t_ur_faq_file
-- ----------------------------
DROP TABLE IF EXISTS `t_ur_faq_file`;
CREATE TABLE `t_ur_faq_file` (
  `id` varchar(32) NOT NULL,
  `file_name` varchar(32) NOT NULL,
  `file_suffix` varchar(32) NOT NULL DEFAULT 'rar',
  `file_remark` varchar(128) NOT NULL DEFAULT '',
  `file_size` int(6) NOT NULL DEFAULT '0',
  `file_unit` varchar(6) NOT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_user_name` varchar(32) DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_user_name` varchar(32) DEFAULT NULL,
  `add_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_datetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `enable` int(6) NOT NULL DEFAULT '1',
  `sort` int(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ur_faq_file
-- ----------------------------

-- ----------------------------
-- Table structure for t_ur_faq_file_rel
-- ----------------------------
DROP TABLE IF EXISTS `t_ur_faq_file_rel`;
CREATE TABLE `t_ur_faq_file_rel` (
  `faq_id` varchar(32) NOT NULL,
  `file_id` varchar(32) NOT NULL,
  `file_name` varchar(32) NOT NULL,
  `file_suffix` varchar(32) NOT NULL DEFAULT 'rar',
  `file_remark` varchar(128) NOT NULL DEFAULT '',
  `file_size` int(6) NOT NULL DEFAULT '0',
  `file_unit` varchar(6) NOT NULL DEFAULT 'MB',
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_user_name` varchar(32) DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_user_name` varchar(32) DEFAULT NULL,
  `add_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_datetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `enable` int(6) NOT NULL DEFAULT '1',
  `sort` int(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ur_faq_file_rel
-- ----------------------------

-- ----------------------------
-- Table structure for t_ur_faq_img
-- ----------------------------
DROP TABLE IF EXISTS `t_ur_faq_img`;
CREATE TABLE `t_ur_faq_img` (
  `id` varchar(32) NOT NULL,
  `img_name` varchar(32) NOT NULL,
  `img_suffix` varchar(32) NOT NULL DEFAULT 'jpg',
  `img_remark` varchar(128) NOT NULL DEFAULT '',
  `img_size` int(6) NOT NULL,
  `img_unit` varchar(6) NOT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_user_name` varchar(32) DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_user_name` varchar(32) DEFAULT NULL,
  `add_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_datetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `enable` int(6) NOT NULL DEFAULT '1',
  `sort` int(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ur_faq_img
-- ----------------------------

-- ----------------------------
-- Table structure for t_ur_faq_img_rel
-- ----------------------------
DROP TABLE IF EXISTS `t_ur_faq_img_rel`;
CREATE TABLE `t_ur_faq_img_rel` (
  `faq_id` varchar(32) NOT NULL,
  `img_id` varchar(32) NOT NULL,
  `img_name` varchar(32) NOT NULL,
  `img_suffix` varchar(32) NOT NULL DEFAULT 'jpg',
  `img_remark` varchar(128) NOT NULL DEFAULT '',
  `img_size` int(6) NOT NULL,
  `img_unit` varchar(6) NOT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_user_name` varchar(32) DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_user_name` varchar(32) DEFAULT NULL,
  `add_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_datetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `enable` int(6) NOT NULL DEFAULT '1',
  `sort` int(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ur_faq_img_rel
-- ----------------------------

-- ----------------------------
-- Table structure for t_ur_faq_type
-- ----------------------------
DROP TABLE IF EXISTS `t_ur_faq_type`;
CREATE TABLE `t_ur_faq_type` (
  `id` varchar(32) NOT NULL,
  `faq_type_code` varchar(32) NOT NULL DEFAULT '-1',
  `faq_type_name` varchar(32) NOT NULL,
  `faq_type_desc` varchar(60) DEFAULT NULL,
  `parent_id` varchar(32) NOT NULL DEFAULT '-1',
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_user_name` varchar(32) DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_user_name` varchar(32) DEFAULT NULL,
  `add_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_datetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `enable` int(6) NOT NULL DEFAULT '1',
  `sort` int(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ur_faq_type
-- ----------------------------
