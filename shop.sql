/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2017-06-23 20:14:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adminuser
-- ----------------------------
DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminuser
-- ----------------------------
INSERT INTO `adminuser` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '家用电器');
INSERT INTO `category` VALUES ('2', '手机');
INSERT INTO `category` VALUES ('3', '电脑');
INSERT INTO `category` VALUES ('4', '办公');
INSERT INTO `category` VALUES ('5', '数码');

-- ----------------------------
-- Table structure for categorysecond
-- ----------------------------
DROP TABLE IF EXISTS `categorysecond`;
CREATE TABLE `categorysecond` (
  `csid` int(11) NOT NULL AUTO_INCREMENT,
  `csname` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`csid`),
  KEY `FK936FCAF21DB1FD15` (`cid`),
  CONSTRAINT `FK936FCAF21DB1FD15` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categorysecond
-- ----------------------------
INSERT INTO `categorysecond` VALUES ('1', '电视', '1');
INSERT INTO `categorysecond` VALUES ('2', '空调', '1');
INSERT INTO `categorysecond` VALUES ('3', '洗衣机', '1');
INSERT INTO `categorysecond` VALUES ('4', '冰箱', '1');
INSERT INTO `categorysecond` VALUES ('5', '电风扇', '1');
INSERT INTO `categorysecond` VALUES ('6', '电饭煲', '1');
INSERT INTO `categorysecond` VALUES ('7', '手机', '2');
INSERT INTO `categorysecond` VALUES ('8', '对讲机', '2');
INSERT INTO `categorysecond` VALUES ('9', '手机壳', '2');
INSERT INTO `categorysecond` VALUES ('10', '移动电源', '2');
INSERT INTO `categorysecond` VALUES ('11', '手机耳机', '2');
INSERT INTO `categorysecond` VALUES ('12', '笔记本', '3');
INSERT INTO `categorysecond` VALUES ('13', '台式机', '3');
INSERT INTO `categorysecond` VALUES ('14', '一体机', '3');
INSERT INTO `categorysecond` VALUES ('15', '平板电脑', '3');
INSERT INTO `categorysecond` VALUES ('16', '投影仪', '4');
INSERT INTO `categorysecond` VALUES ('17', '打印机', '4');
INSERT INTO `categorysecond` VALUES ('18', '传真设备', '4');
INSERT INTO `categorysecond` VALUES ('19', '收银机', '4');
INSERT INTO `categorysecond` VALUES ('20', '保险柜', '4');
INSERT INTO `categorysecond` VALUES ('21', '碎纸机', '4');
INSERT INTO `categorysecond` VALUES ('22', '数码相机', '5');
INSERT INTO `categorysecond` VALUES ('23', '单反相机', '5');
INSERT INTO `categorysecond` VALUES ('24', '摄像机', '5');
INSERT INTO `categorysecond` VALUES ('25', '运动相机', '5');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `itemid` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `oid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `FKE8B2AB6166C01961` (`oid`),
  KEY `FKE8B2AB6171DB7AE4` (`pid`),
  KEY `FKE8B2AB6140ACF87A` (`oid`),
  KEY `FKE8B2AB61CEB75E4B` (`uid`),
  CONSTRAINT `FKE8B2AB6140ACF87A` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`),
  CONSTRAINT `FKE8B2AB6171DB7AE4` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`),
  CONSTRAINT `FKE8B2AB61CEB75E4B` FOREIGN KEY (`uid`) REFERENCES `orders` (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('18', '13', '97487', '1', '22', '22');
INSERT INTO `orderitem` VALUES ('19', '13', '97487', '1', '23', '23');
INSERT INTO `orderitem` VALUES ('20', '1', '3049', '4', '23', '23');
INSERT INTO `orderitem` VALUES ('21', '13', '97487', '1', '24', '24');
INSERT INTO `orderitem` VALUES ('22', '1', '3049', '4', '24', '24');
INSERT INTO `orderitem` VALUES ('23', '22', '98978', '6', '25', '25');
INSERT INTO `orderitem` VALUES ('24', '22', '98978', '6', '26', '26');
INSERT INTO `orderitem` VALUES ('25', '1', '6000', '16', '26', '26');
INSERT INTO `orderitem` VALUES ('26', '1', '2899', '14', '27', '27');
INSERT INTO `orderitem` VALUES ('27', '1', '4788', '17', '28', '28');
INSERT INTO `orderitem` VALUES ('28', '11', '39589', '3', '29', '29');
INSERT INTO `orderitem` VALUES ('29', '1', '2899', '14', '30', '30');
INSERT INTO `orderitem` VALUES ('30', '1', '6000', '16', '31', '31');
INSERT INTO `orderitem` VALUES ('31', '0', '0', '7', '32', '32');
INSERT INTO `orderitem` VALUES ('32', '2', '7198', '2', '33', '33');
INSERT INTO `orderitem` VALUES ('33', '1', '5588', '15', '34', '34');
INSERT INTO `orderitem` VALUES ('34', '100', '558800', '15', '35', '35');
INSERT INTO `orderitem` VALUES ('35', '11', '39589', '2', '36', '36');
INSERT INTO `orderitem` VALUES ('36', '1', '4499', '6', '37', '37');
INSERT INTO `orderitem` VALUES ('37', '1', '5588', '15', '38', null);
INSERT INTO `orderitem` VALUES ('38', '1', '5588', '15', '39', null);
INSERT INTO `orderitem` VALUES ('39', '1', '5588', '15', '40', null);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `total` double DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `addr` varchar(50) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `FKC3DF62E5AA3D9C7` (`uid`),
  CONSTRAINT `FKC3DF62E5AA3D9C7` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('22', '97487', '2017-06-09 21:21:31', '1', null, null, null, '2');
INSERT INTO `orders` VALUES ('23', '100536', '2017-06-09 21:24:22', '1', null, null, null, '2');
INSERT INTO `orders` VALUES ('24', '100536', '2017-06-09 21:24:52', '1', null, null, null, '2');
INSERT INTO `orders` VALUES ('25', '98978', '2017-06-09 21:54:55', '1', null, null, null, '2');
INSERT INTO `orders` VALUES ('26', '104978', '2017-06-09 21:55:10', '1', null, null, null, '2');
INSERT INTO `orders` VALUES ('27', '2899', '2017-06-09 21:55:24', '1', null, null, null, '2');
INSERT INTO `orders` VALUES ('28', '4788', '2017-06-09 21:55:46', '1', null, null, null, '2');
INSERT INTO `orders` VALUES ('29', '39589', '2017-06-09 21:56:12', '1', null, null, null, '2');
INSERT INTO `orders` VALUES ('30', '2899', '2017-06-10 14:13:21', '1', null, null, null, '2');
INSERT INTO `orders` VALUES ('31', '6000', '2017-06-10 15:52:46', '1', null, null, null, '2');
INSERT INTO `orders` VALUES ('32', '0', '2017-06-10 21:05:17', '1', null, null, null, '2');
INSERT INTO `orders` VALUES ('33', '7198', '2017-06-10 21:10:16', '1', '速度', '12345678923', '撒旦飒飒的', '2');
INSERT INTO `orders` VALUES ('34', '5588', '2017-06-10 21:39:37', '1', null, null, null, '2');
INSERT INTO `orders` VALUES ('35', '558800', '2017-06-10 21:40:11', '1', null, null, null, '2');
INSERT INTO `orders` VALUES ('36', '39589', '2017-06-10 21:55:19', '1', null, null, null, '2');
INSERT INTO `orders` VALUES ('37', '4499', '2017-06-10 22:01:17', '3', '速度', '12345678923', '撒旦飒飒的', '2');
INSERT INTO `orders` VALUES ('38', '5588', '2017-06-18 15:59:15', '1', null, null, null, '2');
INSERT INTO `orders` VALUES ('39', '5588', '2017-06-18 15:59:23', '1', null, null, null, '2');
INSERT INTO `orders` VALUES ('40', '5588', '2017-06-18 19:28:50', '4', '速度', '12345678923', '撒旦飒飒的', '2');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) DEFAULT NULL,
  `ppname` varchar(225) DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `shop_price` double DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `pdesc` varchar(255) DEFAULT NULL,
  `is_hot` int(11) DEFAULT NULL,
  `pdate` datetime DEFAULT NULL,
  `csid` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FKED8DCCEFB9B74E02` (`csid`),
  CONSTRAINT `FKED8DCCEFB9B74E02` FOREIGN KEY (`csid`) REFERENCES `categorysecond` (`csid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '三星（SAMSUNG）UA65KUC30SJXXZ 65英寸 曲面 HDR 4K超高清 智能电视 黑色\r\n  三星（SAMSUNG）UA65KUC30SJXXZ 65英寸 曲面 HDR 4', '三星 UA65KUC30SJXXZ', '7999', '7499', 'picture/1.jpg', '商品名称：三星UA65KUC30SJXXZ\r\n商品编号：3227578\r\n商品毛重：36.8kg\r\n商品产地：中国大陆\r\n观看距离：3.5米以上\r\n分辨率：超高清\r\n电视类型：曲面电视，4K超清电视，HDR，智能电视\r\n能效等级：三级能效\r\n屏幕尺寸：65英寸', '1', '2017-06-02 08:19:13', '1');
INSERT INTO `product` VALUES ('2', '三星（SAMSUNG）UA55KC20SAJXXZ 55英寸 曲面 全高清 智能电视 古铜色边框 黑色', '三星 UA55KC20SAJXXZ ', '4000', '3599', 'picture/2.jpg', '商品名称：三星UA55KC20SAJXXZ\r\n商品编号：3052652\r\n商品毛重：23.1kg\r\n商品产地：中国大陆\r\n观看距离：3-3.5米\r\n分辨率：全高清\r\n电视类型：曲面电视，智能电视\r\n能效等级：一级能效\r\n屏幕尺寸：55英寸', '0', '2017-06-02 11:37:39', '1');
INSERT INTO `product` VALUES ('3', '三星（SAMSUNG）UA55KUF30ZJXXZ 55英寸 HDR 4K超高清 智能电视 黑色 ', '三星 UA55KUF30ZJXXZ ', '4000', '3599', 'picture/3.jpg', '\r\n    商品名称：三星UA55KUF30ZJXXZ\r\n    商品编号：3868158\r\n    商品毛重：18.3kg\r\n    商品产地：中国大陆\r\n    观看距离：3-3.5米\r\n    分辨率：超高清\r\n    电视类型：4K超清电视，HDR，智能电视\r\n    能效等级：三级能效\r\n    屏幕尺寸：55英寸\r\n商品名称：三星UA55KC20SAJXXZ\r\n商品编号：3052652\r\n商品毛重：23.1kg\r\n商品产地：中国大陆\r\n观看距离：3-3.5米\r\n分辨率：全高清\r\n电视类型：曲面', '1', '2017-06-02 08:21:24', '1');
INSERT INTO `product` VALUES ('4', '海信（Hisense）LED55EC520UA 55英寸 VIDAA3 14核 炫彩4K智能电视(黑色) ', '海信 LED55EC520UA ', '3600', '3049', 'picture/4.jpg', '商品名称：乐视TV超4 X55\r\n商品编号：2879767\r\n商品毛重：25.0kg\r\n商品产地：中国大陆\r\n观看距离：2.5-3米\r\n分辨率：超高清\r\n电视类型：超薄电视，4K超清电视，HDR，智能电视，互联网电视\r\n能效等级：三级能效\r\n屏幕尺寸：55英寸\r\n选购指数：10.0-8.0', '0', '2017-06-02 11:41:32', '1');
INSERT INTO `product` VALUES ('5', '乐视超级电视 超4 X55 55英寸 HDR 3GB+32GB 4K高清2D智能语音遥控 LED液晶电视（标配挂架）', '乐视电视 超4 X55', '4300', '3889', 'picture/5.jpg', '\r\n    商品名称：乐视TV超4 X55\r\n    商品编号：2879767\r\n    商品毛重：25.0kg\r\n    商品产地：中国大陆\r\n    观看距离：2.5-3米\r\n    分辨率：超高清\r\n    电视类型：超薄电视，4K超清电视，HDR，智能电视，互联网电视\r\n    能效等级：三级能效\r\n    屏幕尺寸：55英寸\r\n    选购指数：8.0-10.0', '0', '2017-06-02 11:42:39', '1');
INSERT INTO `product` VALUES ('6', '小米（MI）小米电视3S 60英寸 HDR 4K超高清超薄金属机身64位智能网络液晶平板电视（L60M5-AA） ', '小米电视3S', '5000', '4499', 'picture/6.jpg', '商品名称：小米小米电视3S 60英寸\r\n商品编号：3948624\r\n商品毛重：28.57kg\r\n商品产地：中国大陆\r\n观看距离：2.5-3米\r\n分辨率：超高清\r\n电视类型：超薄电视，4K超清电视，HDR，智能电视，互联网电视\r\n能效等级：三级能效\r\n屏幕尺寸：58-60英寸', '1', '2017-06-02 13:00:40', '1');
INSERT INTO `product` VALUES ('7', '夏普（SHARP）LCD-60SU465A 60英寸 日本原装液晶面板 4K超高清 智能液晶电视', '夏普 LCD-60SU465A', '5500', '4999', 'picture/7.jpg', '商品名称：SHARPLCD-60SU465A\r\n商品编号：3755141\r\n商品毛重：25.5kg\r\n商品产地：中国大陆\r\n观看距离：3-3.5米\r\n分辨率：超高清\r\n电视类型：4K超清电视，智能电视\r\n能效等级：二级能效\r\n屏幕尺寸：58-60英寸', '1', '2017-06-02 13:03:16', '1');
INSERT INTO `product` VALUES ('8', '夏普（SHARP ）LCD-50SU460A 50英寸 4K超高清智能超薄液晶电视', '夏普 LCD-50SU460A', '3200', '2999', 'picture/8.jpg', '商品名称：SHARPLCD-50SU460A\r\n商品编号：4189028\r\n商品毛重：14.0kg\r\n商品产地：中国大陆\r\n观看距离：2.5-3米\r\n分辨率：超高清\r\n电视类型：4K超清电视，智能电视\r\n能效等级：三级能效\r\n屏幕尺寸：49-50英寸', '1', '2017-06-02 13:05:34', '1');
INSERT INTO `product` VALUES ('9', '索尼（SONY）KD-55X7000D 55英寸高清4K HDR 安卓6.0系统 智能液晶电视', '索尼 KD-55X7000D', '5000', '4780', 'picture/9.jpg', '商品名称：索尼KD-55X7000D\r\n商品编号：3498623\r\n商品毛重：17.8kg\r\n商品产地：中国大陆\r\n观看距离：3-3.5米\r\n屏幕尺寸：55英寸\r\n电视类型：4K超清电视，HDR，智能电视\r\n能效等级：三级能效\r\n选购指数：10.0-8.0', '1', '2017-06-02 13:08:10', '1');
INSERT INTO `product` VALUES ('10', '长虹（CHANGHONG）55U3C 55英寸双64位4K安卓智能LED液晶电视(黑色)', '长虹 55U3C', '3200', '2999', 'picture/10.jpg', '商品名称：长虹55U3C\r\n商品编号：1927536\r\n商品毛重：19.5kg\r\n商品产地：中国大陆\r\n观看距离：3-3.5米\r\n分辨率：超高清\r\n电视类型：4K超清电视，智能电视，互联网电视\r\n能效等级：三级能效\r\n屏幕尺寸：55英寸\r\n选购指数：10.0-8.0', '1', '2017-06-02 13:10:40', '1');
INSERT INTO `product` VALUES ('11', 'TCL D49A620U 49英寸观影王 4K超高清14核安卓智能LED液晶电视机（黑色）', 'TCL D49A620U', '2500', '2388', 'picture/11.jpg', '商品名称：TCLD49A620U\r\n    商品编号：4108550\r\n    商品毛重：15.1kg\r\n    商品产地：中国大陆\r\n    观看距离：2.5-3米\r\n    分辨率：超高清\r\n    电视类型：4K超清电视，HDR，智能电视\r\n    能效等级：三级能效\r\n    屏幕尺寸：49-50英寸\r\n    选购指数：10.0-8.0', '1', '2017-06-02 13:12:50', '1');
INSERT INTO `product` VALUES ('12', '飞利浦（PHILIPS）50PUF6061/T3 50英寸 64位十一核4K超高清智能液晶平板电视机（黑色）', '飞利浦 50PUF6061/T3', '2600', '2688', 'picture/12.jpg', '商品名称：飞利浦50PUF6061/T3\r\n商品编号：3339537\r\n商品毛重：17.84kg\r\n商品产地：中国大陆\r\n观看距离：2.5-3米\r\n分辨率：超高清\r\n电视类型：4K超清电视，智能电视，互联网电视\r\n能效等级：三级能效\r\n屏幕尺寸：49-50英寸\r\n选购指数：10.0-8.0', '0', '2017-06-02 13:14:27', '1');
INSERT INTO `product` VALUES ('13', '创维（Skyworth）55V6 55英寸 18核金属边框4色4K超高清智能电视（银色）', '创维 55V6', '3600', '3199', 'picture/13.jpg', '商品名称：创维55V6\r\n商品编号：2151534\r\n商品毛重：18.0kg\r\n商品产地：中国大陆\r\n合约方案：爱奇艺视频合约\r\n观看距离：3-3.5米\r\n分辨率：超高清\r\n电视类型：4K超清电视，智能电视，互联网电视\r\n能效等级：三级能效\r\n屏幕尺寸：55英寸\r\n选购指数：10.0-8.0', '0', '2017-06-02 13:16:06', '1');
INSERT INTO `product` VALUES ('14', '美的（Midea）正1.5匹 变频 智弧 冷暖 智能壁挂式空调 KFR-35GW/WDAA3@', '美的 KFR-35GW/WDAA3', '3000', '2899', 'picture/14.jpg', '商品名称：美的KFR-35GW/WDAA3@\r\n商品编号：3082122\r\n商品毛重：9.5kg\r\n商品产地：中国大陆\r\n变频/定频：变频\r\n冷暖类型：冷暖空调\r\n产品特色：智能空调，变频空调，静音空调，自动清洁\r\n内机颜色：白色\r\n商品匹数：1.5匹\r\n能效等级：三级能效\r\n使用面积：15-20㎡，20-30㎡\r\n空调类别：壁挂式空调', '0', '2017-06-02 13:20:31', '2');
INSERT INTO `product` VALUES ('15', 'Apple iPhone 7 128G 红色特别版 移动联通电信4G手机', 'Apple iPhone 7 128G', '6000', '5588', 'picture/15.jpg', '商品名称：AppleiPhone7\r\n商品编号：3995643\r\n商品毛重：390.00g\r\n商品产地：中国大陆\r\n机身内存：128GB\r\n后置摄像头像素：1200万-1999万', '0', '2017-06-02 13:24:47', '7');
INSERT INTO `product` VALUES ('16', 'Apple MacBook Air 13.3英寸笔记本电脑 银色(Core i5 处理器/8GB内存/128GB SSD闪存 MMGF2CH/A)', 'Apple MacBook Air', '6500', '6000', 'picture/16.jpg', '商品名称：AppleMacBook Air\r\n商品编号：2342601\r\n商品毛重：3.0kg\r\n商品产地：中国大陆\r\n系统：其他\r\n厚度：15.1mm—20.0mm\r\n内存容量：8G\r\n分辨率：其他\r\n显卡型号：其他\r\n待机时长：9小时以上\r\n处理器：Intel i5低功耗版\r\n特性：背光键盘\r\n显卡类别：集成显卡\r\n裸机重量：1-1.5KG\r\n硬盘容量：128G固态\r\n显存容量：其他\r\n分类：轻薄本\r\n屏幕尺寸：13.3英寸', '0', '2017-06-02 13:27:25', '12');
INSERT INTO `product` VALUES ('17', '极米（XGIMI）H1S 家用全高清投影机（哈曼卡顿音响 1100ANSI流明 1080P分辨率 左右梯形校正 全自动对焦 无屏电视）', '极米（XGIMI）H1S', '5000', '4788', 'picture/17.jpg', '商品名称：极米H1S\r\n商品编号：4860246\r\n商品毛重：4.85kg\r\n商品产地：中国大陆\r\n亮度：1000-1999流明\r\n产品类别：品质家用\r\n分辨率：1080P(1920*1080)\r\n个性：安卓系统，手机同屏，3D显示', '0', '2017-06-02 13:29:32', '16');
INSERT INTO `product` VALUES ('18', '索尼（SONY） DSC-RX100M5（RX100V）黑卡数码相机 等效24-70mm F1.8-2.8蔡司镜头（WIFI/NFC）', '索尼 DSC-RX100M5', '7000', '6500', 'picture/18.jpg', '商品名称：索尼RX100M5\r\n商品编号：3965552\r\n商品毛重：0.54kg\r\n商品产地：中国大陆\r\n颜色：黑色', '0', '2017-06-02 13:33:05', '22');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `sex` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  `possword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '男', 'aaa', 'aaa', '张宁', 'aaa@shop.com', '15726607618', '广东省吉林大学珠海学院', '1', null, null);
INSERT INTO `user` VALUES ('2', '男', 'a', '123', '速度', '5@asdsad.com', '12345678923', '撒旦飒飒的', '1', 'fdba087815b442e5b7afa7f2adea309e6f22753ceef346c4b5bc9d6d03fc738f', null);
INSERT INTO `user` VALUES ('4', '男', '1', '1', '1', '1847786689@qq.com', '13631251562', '1', '1', null, null);
