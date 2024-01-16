

create database lottery_02;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_strategy_export_000
-- ----------------------------
DROP TABLE IF EXISTS `user_strategy_export_000`;
CREATE TABLE `user_strategy_export_000` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
  `u_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'user id',
  `activity_id` bigint(20) DEFAULT NULL COMMENT 'activity id',
  `order_id` bigint(32) DEFAULT NULL COMMENT 'order id',
  `strategy_id` bigint(20) DEFAULT NULL COMMENT 'strategy id',
  `strategy_mode` tinyint(2) DEFAULT NULL COMMENT 'strategy mode (1: single probability, 2: overall probability)',
  `grant_type` tinyint(2) DEFAULT NULL COMMENT 'award grant type (1: immediate, 2: timed [including activity end], 3: manual)',
  `grant_date` datetime DEFAULT NULL COMMENT 'award grant date',
  `grant_state` tinyint(4) DEFAULT NULL COMMENT 'award grant state',
  `award_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award id',
  `award_type` tinyint(2) DEFAULT NULL COMMENT 'award type (1: text description, 2: redemption code, 3: coupon, 4: physical prize)',
  `award_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award name',
  `award_content` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award content "text description, key, code"',
  `uuid` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'anti-repetition id',
  `mq_state` tinyint(4) DEFAULT NULL COMMENT 'message queue state (0: not sent, 1: sent, 2: failed)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='user strategy calculation result table';

-- ----------------------------
-- Records of user_strategy_export_000
-- ----------------------------
BEGIN;
INSERT INTO `user_strategy_export_000` VALUES (1, 'allan', 100001, 1444540456057864192, 10001, 2, 1, NULL, 1, '3', 1, 'ipad', 'Code', '1444540456057864192', 0, '2023-10-03 13:50:57', '2023-10-30 12:59:44');
INSERT INTO `user_strategy_export_000` VALUES (2, 'allan', 100001, 1444541565086367744, 10001, 2, 1, NULL, 0, '5', 1, 'Book', 'Code', '1444541565086367744', 0, '2023-10-03 13:55:22', '2023-10-03 13:55:22');
INSERT INTO `user_strategy_export_000` VALUES (3, 'allan', 100001, 1444810184030633984, 10001, 2, 1, NULL, 0, '4', 1, 'AirPods', 'Code', '1444810184030633984', 0, '2023-10-04 07:42:45', '2023-10-04 07:42:45');
INSERT INTO `user_strategy_export_000` VALUES (4, 'allan', 100001, 1444820311156670464, 10001, 2, 1, NULL, 0, '2', 1, 'iphone', 'Code', '1444820311156670464', 0, '2023-10-04 08:23:00', '2023-10-04 08:23:00');
INSERT INTO `user_strategy_export_000` VALUES (5, 'allan', 100001, 1454313513303539712, 10001, 2, 1, NULL, 0, '4', 1, 'AirPods', 'Code', '1454313490931122176', 1, '2023-10-30 13:05:36', '2023-10-30 13:05:45');
INSERT INTO `user_strategy_export_000` VALUES (6, 'allan', 100001, 1454313878879076352, 10001, 2, 1, '2023-10-30 13:07:52', 1, '3', 1, 'ipad', 'Code', '1454313878132490240', 1, '2023-10-30 13:07:03', '2023-10-30 13:07:52');
INSERT INTO `user_strategy_export_000` VALUES (7, 'allan', 100001, 1454314085880561664, 10001, 2, 1, '2023-10-30 13:07:57', 1, '4', 1, 'AirPods', 'Code', '1454314085456936960', 1, '2023-10-30 13:07:52', '2023-10-30 13:07:57');
INSERT INTO `user_strategy_export_000` VALUES (8, 'allan', 100001, 1454314251442323456, 10001, 2, 1, '2023-10-30 13:08:35', 1, '4', 1, 'AirPods', 'Code', '1454314250930618368', 1, '2023-10-30 13:08:32', '2023-10-30 13:08:35');
INSERT INTO `user_strategy_export_000` VALUES (9, 'allan', 100001, 1454314395218870272, 10001, 2, 1, '2023-10-30 13:09:11', 1, '3', 1, 'ipad', 'Code', '1454314394698776576', 1, '2023-10-30 13:09:06', '2023-10-30 13:09:11');
COMMIT;

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
  `grant_state` tinyint(4) DEFAULT NULL COMMENT 'award grant state',
  `award_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award id',
  `award_type` tinyint(2) DEFAULT NULL COMMENT 'award type (1: text description, 2: redemption code, 3: coupon, 4: physical prize)',
  `award_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award name',
  `award_content` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award content "text description, key, code"',
  `uuid` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'anti-repetition id',
  `mq_state` tinyint(4) DEFAULT NULL COMMENT 'message queue state (0: not sent, 1: sent, 2: failed)',
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
  `grant_state` tinyint(4) DEFAULT NULL COMMENT 'award grant state',
  `award_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award id',
  `award_type` tinyint(2) DEFAULT NULL COMMENT 'award type (1: text description, 2: redemption code, 3: coupon, 4: physical prize)',
  `award_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award name',
  `award_content` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award content "text description, key, code"',
  `uuid` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'anti-repetition id',
  `mq_state` tinyint(4) DEFAULT NULL COMMENT 'message queue state (0: not sent, 1: sent, 2: failed)',
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
  `grant_state` tinyint(4) DEFAULT NULL COMMENT 'award grant state',
  `award_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award id',
  `award_type` tinyint(2) DEFAULT NULL COMMENT 'award type (1: text description, 2: redemption code, 3: coupon, 4: physical prize)',
  `award_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award name',
  `award_content` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award content "text description, key, code"',
  `uuid` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'anti-repetition id',
  `mq_state` tinyint(4) DEFAULT NULL COMMENT 'message queue state (0: not sent, 1: sent, 2: failed)',
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
  `strategy_id` int(11) DEFAULT NULL COMMENT 'strategy id',
  `state` tinyint(2) DEFAULT NULL COMMENT 'activity state (0: not used, 1: used)',
  `uuid` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'anti-repetition id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'anti-repetition id index'
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='user take activity table';

-- ----------------------------
-- Records of user_take_activity
-- ----------------------------
BEGIN;
INSERT INTO `user_take_activity` VALUES (4, 'allan', 1444537120189480960, 100001, '???', '2023-10-03 13:37:33', 1, 10001, 1, 'allan_100001_1', '2023-10-03 13:37:42', '2023-10-03 13:37:42');
INSERT INTO `user_take_activity` VALUES (6, 'allan', 1444539043961536512, 100001, '???', '2023-10-03 13:45:18', 2, 10001, 1, 'allan_100001_2', '2023-10-03 13:45:37', '2023-10-03 13:45:37');
INSERT INTO `user_take_activity` VALUES (7, 'allan', 1444540455500021760, 100001, '???', '2023-10-03 13:50:57', 3, 10001, 1, 'allan_100001_3', '2023-10-03 13:50:57', '2023-10-03 13:50:57');
INSERT INTO `user_take_activity` VALUES (8, 'allan', 1444541564645965824, 100001, '???', '2023-10-03 13:55:22', 4, 10001, 1, 'allan_100001_4', '2023-10-03 13:55:21', '2023-10-03 13:55:21');
INSERT INTO `user_take_activity` VALUES (9, 'allan', 1444820310565273600, 100001, '???', '2023-10-04 08:23:00', 5, 10001, 1, 'allan_100001_5', '2023-10-04 08:23:00', '2023-10-04 08:23:00');
INSERT INTO `user_take_activity` VALUES (11, 'allan', 1454313490931122176, 100001, 'activity name', '2023-10-30 13:05:29', 6, 10001, 1, 'allan_100001_6', '2023-10-30 13:05:30', '2023-10-30 13:05:30');
INSERT INTO `user_take_activity` VALUES (12, 'allan', 1454313878132490240, 100001, 'activity name', '2023-10-30 13:06:59', 7, 10001, 1, 'allan_100001_7', '2023-10-30 13:07:03', '2023-10-30 13:07:03');
INSERT INTO `user_take_activity` VALUES (13, 'allan', 1454314085456936960, 100001, 'activity name', '2023-10-30 13:07:51', 8, 10001, 1, 'allan_100001_8', '2023-10-30 13:07:52', '2023-10-30 13:07:52');
INSERT INTO `user_take_activity` VALUES (14, 'allan', 1454314250930618368, 100001, 'activity name', '2023-10-30 13:08:31', 9, 10001, 1, 'allan_100001_9', '2023-10-30 13:08:31', '2023-10-30 13:08:31');
INSERT INTO `user_take_activity` VALUES (15, 'allan', 1454314394698776576, 100001, 'activity name', '2023-10-30 13:09:06', 10, 10001, 1, 'allan_100001_10', '2023-10-30 13:09:06', '2023-10-30 13:09:06');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='user take activity count table';

-- ----------------------------
-- Records of user_take_activity_count
-- ----------------------------
BEGIN;
INSERT INTO `user_take_activity_count` VALUES (1, 'allan', 100001, 10, 0, '2023-10-03 13:37:42', '2023-10-03 13:37:42');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;


