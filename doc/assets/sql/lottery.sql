/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50639
 Source Host           : localhost:3306
 Source Schema         : lottery_subtractionStock

 Target Server Type    : MySQL
 Target Server Version : 50639
 File Encoding         : 65001

 Date: 25/09/2022 08:15:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
  `activityId` bigint(20) DEFAULT NULL COMMENT 'activity id',
  `activityName` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT 'activity name',
  `activityDesc` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'activity desc',
  `beginDateTime` datetime NOT NULL COMMENT 'start time',
  `endDateTime` datetime NOT NULL COMMENT 'end time
  `stockCount` int(11) NOT NULL COMMENT 'stock count',
  `takeCount` int(11) DEFAULT NULL COMMENT 'take count',
  `state` int(11) DEFAULT NULL COMMENT 'Activity status: edited, tabled, withdrawn, passed, running, rejected, closed, open',
  `creator` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT 'creator',
  `createTime` datetime NOT NULL COMMENT 'create time',
  `updateTime` datetime NOT NULL COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `activity_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='activity table';

-- ----------------------------
-- Records of activity
-- ----------------------------
BEGIN;
INSERT INTO `activity` VALUES (1, 100001, 'activity name 1', 'test activity', '2022-12-26 00:00:00', '2023-12-26 23:59:59', 100, 10, 5, 'allan', '2022-08-08 20:14:50', '2022-09-09 20:14:50');
INSERT INTO `activity` VALUES (2, 100002, 'activity name 2', 'test activity', '2022-12-26 00:00:00', '2023-12-26 23:59:59', 100, 10, 5, 'allan', '2022-10-10 15:49:21', '2022-11-11 15:49:21');
COMMIT;

-- ----------------------------
-- Table structure for award
-- ----------------------------
DROP TABLE IF EXISTS `award`;
CREATE TABLE `award` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
  `awardId` bigint(20) DEFAULT NULL COMMENT 'award id',
  `awardType` int(4) DEFAULT NULL COMMENT 'Types of prizes (text descriptions, redemption codes, coupons, physical prizes not available at this time)',
  `awardCount` int(11) DEFAULT NULL COMMENT 'award count',
  `awardName` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award name',
  `awardContent` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award content',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'updateTime',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='award config';

-- ----------------------------
-- Records of award
-- ----------------------------
BEGIN;
INSERT INTO `award` VALUES (1, 1, 1, 100, 'IMac', 'Code', '2022-08-15 15:38:05', '2022-08-15 15:38:05');
INSERT INTO `award` VALUES (2, 2, 1, 100, 'iphone', 'Code', '2022-08-15 15:38:05', '2022-08-15 15:38:05');
INSERT INTO `award` VALUES (3, 3, 1, 100, 'ipad', 'Code', '2022-08-15 15:38:05', '2022-08-15 15:38:05');
INSERT INTO `award` VALUES (4, 4, 1, 100, 'AirPods', 'Code', '2022-08-15 15:38:05', '2022-08-15 15:38:05');
INSERT INTO `award` VALUES (5, 5, 1, 100, 'Book', 'Code', '2022-08-15 15:38:05', '2022-08-15 15:38:05');
COMMIT;

-- ----------------------------
-- Table structure for strategy
-- ----------------------------
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
  `strategyId` bigint(11) NOT NULL COMMENT 'strategy id',
  `strategyDesc` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'strategy desc',
  `strategyMode` int(4) DEFAULT NULL COMMENT 'strategy mode: 1:single, 2:entire',
  `grantType` int(4) DEFAULT NULL COMMENT 'grant type',
  `grantDate` datetime DEFAULT NULL COMMENT 'grant date',
  `extInfo` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'ext info',
  `createTime` datetime DEFAULT NULL COMMENT 'create time',
  `updateTime` datetime DEFAULT NULL COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `strategy_strategyId_uindex` (`strategyId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='strategy config';

-- ----------------------------
-- Records of strategy
-- ----------------------------
BEGIN;
INSERT INTO `strategy` VALUES (1, 10001, 'test', 2, 1, NULL, '', '2022-09-25 08:15:52', '2022-09-25 08:15:52');
COMMIT;

-- ----------------------------
-- Table structure for strategy_detail
-- ----------------------------
DROP TABLE IF EXISTS `strategy_detail`;
CREATE TABLE `strategy_detail` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
  `strategyId` bigint(11) NOT NULL COMMENT 'strategy id',
  `awardId` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award id',
  `awardDesc` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award desc',
  `awardCount` int(11) DEFAULT NULL COMMENT 'award count',
  `awardSurplusCount` int(11) DEFAULT '0' COMMENT 'award surplus count',
  `awardRate` decimal(5,2) DEFAULT NULL COMMENT 'award rate',
  `createTime` datetime DEFAULT NULL COMMENT 'create time',
  `updateTime` datetime DEFAULT NULL COMMENT 'update time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='策略明细';

-- ----------------------------
-- Records of strategy_detail
-- ----------------------------
BEGIN;
INSERT INTO `strategy_detail` VALUES (1, 10001, '1', NULL, 10, 0, 0.05, '2022-08-15 15:38:05', '2022-08-15 15:38:05');
INSERT INTO `strategy_detail` VALUES (2, 10001, '2', NULL, 20, 19, 0.15, '2022-08-15 15:38:05', '2022-08-15 15:38:05');
INSERT INTO `strategy_detail` VALUES (3, 10001, '3', NULL, 50, 43, 0.20, '2022-08-15 15:38:05', '2022-08-15 15:38:05');
INSERT INTO `strategy_detail` VALUES (4, 10001, '4', NULL, 100, 70, 0.25, '2022-08-15 15:38:05', '2022-08-15 15:38:05');
INSERT INTO `strategy_detail` VALUES (5, 10001, '5', NULL, 500, 388, 0.35, '2022-08-15 15:38:05', '2022-08-15 15:38:05');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
