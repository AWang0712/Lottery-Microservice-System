

create database lottery_02;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_strategy_export_001
-- ----------------------------
DROP TABLE IF EXISTS `user_strategy_export_001`;
CREATE TABLE `user_strategy_export_001` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
  `u_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'user id',
  `activity_id` bigint(20) DEFAULT NULL COMMENT 'activity id',
  `order_id` bigint(32) DEFAULT NULL COMMENT 'order id',
  `strategy_id` bigint(20) DEFAULT NULL COMMENT 'strategy id',
  `strategy_mode` tinyint(2) DEFAULT NULL COMMENT 'strategy mode (1: single probability, 2: overall probability)',
  `grant_type` tinyint(2) DEFAULT NULL COMMENT 'award grant type (1: immediate, 2: timed [including activity end], 3: manual)',
  `grant_date` datetime DEFAULT NULL COMMENT 'award grant date',
  `grant_state` int(11) DEFAULT NULL COMMENT 'award grant state',
  `award_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award id',
  `award_type` tinyint(2) DEFAULT NULL COMMENT 'award type (1: text description, 2: redemption code, 3: coupon, 4: physical prize)',
  `award_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award name',
  `award_content` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award content "text description, key, code"',
  `uuid` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'anti-repetition id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='user strategy calculation result table';

-- ----------------------------
-- Records of user_strategy_export_001
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user_strategy_export_002
-- ----------------------------
DROP TABLE IF EXISTS `user_strategy_export_002`;
CREATE TABLE `user_strategy_export_002` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
  `u_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'user id',
  `activity_id` bigint(20) DEFAULT NULL COMMENT 'activity id',
  `order_id` bigint(32) DEFAULT NULL COMMENT 'order id',
  `strategy_id` bigint(20) DEFAULT NULL COMMENT 'strategy id',
  `strategy_mode` tinyint(2) DEFAULT NULL COMMENT 'strategy mode (1: single probability, 2: overall probability)',
  `grant_type` tinyint(2) DEFAULT NULL COMMENT 'award grant type (1: immediate, 2: timed [including activity end], 3: manual)',
  `grant_date` datetime DEFAULT NULL COMMENT 'award grant date',
  `grant_state` int(11) DEFAULT NULL COMMENT 'award grant state',
  `award_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award id',
  `award_type` tinyint(2) DEFAULT NULL COMMENT 'award type (1: text description, 2: redemption code, 3: coupon, 4: physical prize)',
  `award_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award name',
  `award_content` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award content "text description, key, code"',
  `uuid` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'anti-repetition id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='user strategy calculation result table';

-- ----------------------------
-- Records of user_strategy_export_002
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user_strategy_export_003
-- ----------------------------
DROP TABLE IF EXISTS `user_strategy_export_003`;
CREATE TABLE `user_strategy_export_003` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
  `u_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'user id',
  `activity_id` bigint(20) DEFAULT NULL COMMENT 'activity id',
  `order_id` bigint(32) DEFAULT NULL COMMENT 'order id',
  `strategy_id` bigint(20) DEFAULT NULL COMMENT 'strategy id',
  `strategy_mode` tinyint(2) DEFAULT NULL COMMENT 'strategy mode (1: single probability, 2: overall probability)',
  `grant_type` tinyint(2) DEFAULT NULL COMMENT 'award grant type (1: immediate, 2: timed [including activity end], 3: manual)',
  `grant_date` datetime DEFAULT NULL COMMENT 'award grant date',
  `grant_state` int(11) DEFAULT NULL COMMENT 'award grant state',
  `award_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award id',
  `award_type` tinyint(2) DEFAULT NULL COMMENT 'award type (1: text description, 2: redemption code, 3: coupon, 4: physical prize)',
  `award_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award name',
  `award_content` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award content "text description, key, code"',
  `uuid` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'anti-repetition id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='user strategy calculation result table';

-- ----------------------------
-- Records of user_strategy_export_003
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user_strategy_export_004
-- ----------------------------
DROP TABLE IF EXISTS `user_strategy_export_004`;
CREATE TABLE `user_strategy_export_004` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
  `u_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'user id',
  `activity_id` bigint(20) DEFAULT NULL COMMENT 'activity id',
  `order_id` bigint(32) DEFAULT NULL COMMENT 'order id',
  `strategy_id` bigint(20) DEFAULT NULL COMMENT 'strategy id',
  `strategy_mode` tinyint(2) DEFAULT NULL COMMENT 'strategy mode (1: single probability, 2: overall probability)',
  `grant_type` tinyint(2) DEFAULT NULL COMMENT 'award grant type (1: immediate, 2: timed [including activity end], 3: manual)',
  `grant_date` datetime DEFAULT NULL COMMENT 'award grant date',
  `grant_state` int(11) DEFAULT NULL COMMENT 'award grant state',
  `award_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award id',
  `award_type` tinyint(2) DEFAULT NULL COMMENT 'award type (1: text description, 2: redemption code, 3: coupon, 4: physical prize)',
  `award_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award name',
  `award_content` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award content "text description, key, code"',
  `uuid` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'anti-repetition id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='user strategy calculation result table';

-- ----------------------------
-- Records of user_strategy_export_004
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user_take_activity
-- ----------------------------
DROP TABLE IF EXISTS `user_take_activity`;
CREATE TABLE `user_take_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
  `u_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'user id',
  `take_id` bigint(20) DEFAULT NULL COMMENT 'take id',
  `activity_id` bigint(20) DEFAULT NULL COMMENT 'activity id',
  `activity_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'activity name',
  `take_date` datetime DEFAULT NULL COMMENT 'take date',
  `take_count` int(11) DEFAULT NULL COMMENT 'take count',
  `uuid` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'anti-repetition id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'anti-repetition id index'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='user take activity table';

-- ----------------------------
-- Records of user_take_activity
-- ----------------------------
BEGIN;
INSERT INTO `user_take_activity` VALUES (1, 'EDrfwe0193131', 121019889410, 100001, '????', '2021-09-22 20:46:03', 10, 'lfjdlsoi230ii01', '2021-09-22 20:46:03', '2021-09-22 20:46:03');
INSERT INTO `user_take_activity` VALUES (2, 'Ukdli109op811d', 121019889410, 100001, '????', '2021-09-22 20:47:41', 10, 'Ukdli109op811d', '2021-09-22 20:47:41', '2021-09-22 20:47:41');
INSERT INTO `user_take_activity` VALUES (3, 'Uhdgkw766120d', 1443842109978345472, 100001, '???', '2021-10-01 15:35:16', 1, '100001_Uhdgkw766120d_1', '2021-10-01 15:38:01', '2021-10-01 15:38:01');
COMMIT;

-- ----------------------------
-- Table structure for user_take_activity_count
-- ----------------------------
DROP TABLE IF EXISTS `user_take_activity_count`;
CREATE TABLE `user_take_activity_count` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
  `u_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'user id',
  `activity_id` bigint(20) DEFAULT NULL COMMENT 'activity id',
  `total_count` int(11) DEFAULT NULL COMMENT 'total count',
  `left_count` int(11) DEFAULT NULL COMMENT 'left count',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uId_activityId` (`u_id`,`activity_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='user take activity count table';

-- ----------------------------
-- Records of user_take_activity_count
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;


