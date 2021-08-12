DROP database IF EXISTS `userdb`;

create database `userdb` CHARACTER set utf8mb4;

use `userdb`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'bit',
  `password` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '123456',
  `sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(90) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `isadmin` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, '超级管理员', 'Aran', '123456', '男', 21, '西安', '690339590', 'admin@qq.com', 1);
INSERT INTO `userinfo` VALUES (2, '关羽', 'guanyu', '1234', '男', 18, '西安', '690339590', '690339590@qq.com', 0);
INSERT INTO `userinfo` VALUES (3, '王五', 'wangwu', '1237', '女', 21, '成都', '690339590', '690339590@qq.com', 0);
INSERT INTO `userinfo` VALUES (4, '猪八戒', 'zhubajie', '1239', '男', 23, '上海', '690339590', '690339590@qq.com', 0);

SET FOREIGN_KEY_CHECKS = 1;
