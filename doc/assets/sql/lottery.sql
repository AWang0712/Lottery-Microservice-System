

create database lottery;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'auto_increment',
  `activity_id` bigint(20) NOT NULL COMMENT 'activity_id',
  `activity_name` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'activity_name',
  `activity_desc` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'activity_desc',
  `begin_date_time` datetime DEFAULT NULL COMMENT 'begin_date_time',
  `end_date_time` datetime DEFAULT NULL COMMENT 'end_date_time',
  `stock_count` int(11) DEFAULT NULL COMMENT 'stock_count',
  `stock_surplus_count` int(11) DEFAULT NULL COMMENT 'stock_surplus_count',
  `take_count` int(11) DEFAULT NULL COMMENT 'take_count per person',
  `strategy_id` bigint(11) DEFAULT NULL COMMENT 'lottery strategy ID',
  `state` tinyint(2) DEFAULT NULL COMMENT 'activity state：1 Edit, 2 Submit for review, 3 Withdraw for review, 4 Pass, 5 Run (status of worker scan after review passes), 6 Reject, 7 Close, 8 Open',
  `creator` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'creator',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create_time',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_activity_id` (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='activity config';

-- ----------------------------
-- Records of activity
-- ----------------------------
BEGIN;
INSERT INTO `activity` VALUES (1, 100001, 'activity name', 'test activity', '2020-11-01 00:00:00', '2023-12-31 23:59:59', 100, 98, 10, 10001, 5, 'allan', '2023-08-08 08:14:50', '2023-08-08 08:14:50');
COMMIT;

-- ----------------------------
-- Table structure for award
-- ----------------------------
DROP TABLE IF EXISTS `award`;
CREATE TABLE `award` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'auto_increment',
  `award_id` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'award_id',
  `award_type` tinyint(4) DEFAULT NULL COMMENT 'award_type(1. description, 2:redeem code, 3:coupon, 4:physical award)',
  `award_name` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'award_name',
  `award_content` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'award_content (text, key, code)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create_time',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_award_id` (`award_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='award config';

-- ----------------------------
-- Records of award
-- ----------------------------
BEGIN;
INSERT INTO `award` VALUES (1, '1', 1, 'iMac', 'Code', '2023-08-15 15:38:05', '2023-08-15 15:38:05');
INSERT INTO `award` VALUES (2, '2', 1, 'iPhone', 'Code', '2023-08-15 15:38:05', '2023-08-15 15:38:05');
INSERT INTO `award` VALUES (3, '3', 1, 'iPad', 'Code', '2023-08-15 15:38:05', '2023-08-15 15:38:05');
INSERT INTO `award` VALUES (4, '4', 1, 'AirPods', 'Code', '2023-08-15 15:38:05', '2023-08-15 15:38:05');
INSERT INTO `award` VALUES (5, '5', 1, 'Book', 'Code', '2023-08-15 15:38:05', '2023-08-15 15:38:05');
COMMIT;

-- ----------------------------
-- Table structure for strategy
-- ----------------------------
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'auto_increment',
  `strategy_id` bigint(11) NOT NULL COMMENT 'strategy_id',
  `strategy_desc` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'strategy_desc',
  `strategy_mode` tinyint(2) DEFAULT NULL COMMENT 'lottery mode(1:single, 2:entirety)',
  `grant_type` tinyint(2) DEFAULT NULL COMMENT 'grant_type(1:immediately, 2:delay, 3...)',
  `grant_date` datetime DEFAULT NULL COMMENT 'grant_date',
  `ext_info` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'ext_info',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'create_time',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `strategy_strategyId_uindex` (`strategy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='strategy config';

-- ----------------------------
-- Records of strategy
-- ----------------------------
BEGIN;
INSERT INTO `strategy` VALUES (1, 10001, 'test', 2, 1, NULL, '', '2023-09-04 15:34:52', '2023-09-04 15:34:52');
COMMIT;

-- ----------------------------
-- Table structure for strategy_detail
-- ----------------------------
DROP TABLE IF EXISTS `strategy_detail`;
CREATE TABLE `strategy_detail` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'auto_increment',
  `strategy_id` bigint(11) NOT NULL COMMENT 'strategy_id',
  `award_id` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'award_id',
  `award_name` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'award_name',
  `award_count` int(11) DEFAULT NULL COMMENT 'award_count',
  `award_surplus_count` int(11) DEFAULT '0' COMMENT 'award_surplus_count',
  `award_rate` decimal(5,2) DEFAULT NULL COMMENT 'probability',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create_time',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='strategy_detail';

-- ----------------------------
-- Records of strategy_detail
-- ----------------------------
BEGIN;
INSERT INTO `strategy_detail` VALUES (1, 10001, '1', 'iMac', 10, 0, 0.05, '2023-08-15 15:38:05', '2023-08-15 15:38:05');
INSERT INTO `strategy_detail` VALUES (2, 10001, '2', 'iPhone', 20, 20, 0.15, '2023-08-15 15:38:05', '2023-08-15 15:38:05');
INSERT INTO `strategy_detail` VALUES (3, 10001, '3', 'ipad', 50, 50, 0.20, '2023-08-15 15:38:05', '2023-08-15 15:38:05');
INSERT INTO `strategy_detail` VALUES (4, 10001, '4', 'AirPods', 100, 79, 0.25, '2023-08-15 15:38:05', '2023-08-15 15:38:05');
INSERT INTO `strategy_detail` VALUES (5, 10001, '5', 'Book', 500, 390, 0.35, '2023-08-15 15:38:05', '2023-08-15 15:38:05');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
