
create database lottery_01;

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
  `strategy_mode` tinyint(2) DEFAULT NULL COMMENT 'strategy mode（1: single probability 2: total probability）',
  `grant_type` tinyint(2) DEFAULT NULL COMMENT 'grant type（1: immediate 2: timing[include activity end] 3: artificial）',
  `grant_date` datetime DEFAULT NULL COMMENT 'grant date',
  `grant_state` int(11) DEFAULT NULL COMMENT 'grant state',
  `award_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award id',
  `award_type` tinyint(2) DEFAULT NULL COMMENT 'award type（1: text description 2: exchange code 3: coupon 4: physical prize）',
  `award_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award name',
  `award_content` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award content「text description Key、code」',
  `uuid` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'anti-repetition id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='user strategy export table';

-- ----------------------------
-- Records of user_strategy_export_000
-- ----------------------------
BEGIN;
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
  `strategy_mode` tinyint(2) DEFAULT NULL COMMENT 'strategy mode（1: single probability、2: total probability）',
  `grant_type` tinyint(2) DEFAULT NULL COMMENT 'grant type（1: immediate、2: timing[include activity end]、3: artificial）',
  `grant_date` datetime DEFAULT NULL COMMENT 'grant date',
  `grant_state` int(11) DEFAULT NULL COMMENT 'grant state',
  `award_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award id',
  `award_type` tinyint(2) DEFAULT NULL COMMENT 'award type（1: text description、2: exchange code、3: coupon、4: physical prize）',
  `award_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award name',
  `award_content` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award content「text description、Key、code」',
  `uuid` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'anti-repetition id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='user strategy export table';

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
  `strategy_mode` tinyint(2) DEFAULT NULL COMMENT 'strategy mode（1: single probability、2: total probability）',
  `grant_type` tinyint(2) DEFAULT NULL COMMENT 'grant type（1: immediate、2: timing[include activity end]、3: artificial）',
  `grant_date` datetime DEFAULT NULL COMMENT 'grant date',
  `grant_state` int(11) DEFAULT NULL COMMENT 'grant state',
  `award_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award id',
  `award_type` tinyint(2) DEFAULT NULL COMMENT 'award type（1: text description、2: exchange code、3: coupon、4: physical prize）',
  `award_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award name',
  `award_content` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award content「text description、Key、code」',
  `uuid` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'anti-repetition id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='user strategy export table';

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
  `strategy_mode` tinyint(2) DEFAULT NULL COMMENT 'strategy mode（1: single probability、2: total probability）',
  `grant_type` tinyint(2) DEFAULT NULL COMMENT 'grant type（1: immediate、2: timing[include activity end]、3: artificial）',
  `grant_date` datetime DEFAULT NULL COMMENT 'grant date',
  `grant_state` int(11) DEFAULT NULL COMMENT 'grant state',
  `award_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award id',
  `award_type` tinyint(2) DEFAULT NULL COMMENT 'award type（1: text description、2: exchange code、3: coupon、4: physical prize）',
  `award_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award name',
  `award_content` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'award content「text description、Key、code」',
  `uuid` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'anti-repetition id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='user strategy export table';

-- ----------------------------
-- Records of user_strategy_export_003
-- ----------------------------
BEGIN;
INSERT INTO `user_strategy_export_003` VALUES (1, 'Uhdgkw766120d', 120405215, 1443558966104850432, 42480428672, 1, 1, '2023-09-30 20:50:52', 1, '1', 1, 'IMac', '????', '1443558966104850432', '2023-09-30 20:50:52', '2023-09-30 20:50:52');
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
  `strategy_id` int(11) DEFAULT NULL COMMENT 'lottery strategy id',
  `state` tinyint(2) DEFAULT NULL COMMENT 'activity bill state (0: not used 1: used)',
  `uuid` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'anti-repetition id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'anti-repetition id'
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='user take activity table';

-- ----------------------------
-- Records of user_take_activity
-- ----------------------------
BEGIN;
INSERT INTO `user_take_activity` VALUES (16, 'Uhdgkw766120d', 1443899607431151616, 100001, 'test', '2023-10-01 19:24:27', 2, NULL, NULL, 'Uhdgkw766120d_100001_2', '2023-10-01 19:24:27', '2023-10-01 19:24:27');
INSERT INTO `user_take_activity` VALUES (17, 'Uhdgkw766120d', 1443900230654394368, 100001, 'test', '2023-10-01 19:26:56', 3, NULL, NULL, 'Uhdgkw766120d_100001_3', '2023-10-01 19:26:56', '2023-10-01 19:26:56');
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
INSERT INTO `user_take_activity_count` VALUES (1, 'Uhdgkw766120d', 100001, 10, 6, '2023-10-01 15:29:27', '2023-10-01 15:29:27');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
