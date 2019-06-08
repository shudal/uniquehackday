-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: hackday
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accept`
--

DROP TABLE IF EXISTS `accept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accept`
--

LOCK TABLES `accept` WRITE;
/*!40000 ALTER TABLE `accept` DISABLE KEYS */;
/*!40000 ALTER TABLE `accept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `ddl_register` varchar(15) DEFAULT NULL,
  `start_time` varchar(15) DEFAULT NULL,
  `people_need` int(3) DEFAULT NULL COMMENT 'type为2时，需要的人数',
  `description` text COMMENT '需求内容',
  `img_url` varchar(500) DEFAULT NULL COMMENT '图片链接，多张图片以|分开',
  `last_days` int(6) DEFAULT NULL,
  `create_time` varchar(15) DEFAULT NULL,
  `school_id` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrw0k95wa4nk2rirxjonogktyj` (`school_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,'急需教师a','1559729180000','1559901980000',8,'这里是秒速','www.baidu.com|www.bing.com',30,'1559988380491',1,1),(2,'重庆酉阳山区书包公益支教志愿者招募','2019.6.6','2019.7.7',15,'项目通过一年轮换，输送项目老师进行长期教育服务，为教育资源匮乏地区提供持续稳定的师资力量','http://www.cta613.org/data/attachment/forum/201904/03/102035upt67l2lbgp6hbrp.jpg',30,'1559990038349',1,1),(3,'四川省凉山彝族自治州本木源助学支教志愿者招募','2019.6.9','2019.8.5',25,'一年的项目体验，加以专业的培训支持，让项目老师经历扎实的基层教学实践，使提供优质教育、促进青年成长成为可能，为中国教育资源的均衡化发展积累大批未来人才。','http://www.cta613.org/data/attachment/forum/201903/13/112242iigippjn677puq6w.jpg',60,'1559990033969',2,1),(4,'四川省凉山彝族自治州本木源助学支教志愿者招募','2019.6.9','2019.8.5',25,'一年的项目体验，加以专业的培训支持，让项目老师经历扎实的基层教学实践，使提供优质教育、促进青年成长成为可能，为中国教育资源的均衡化发展积累大批未来人才。','http://www.cta613.org/data/attachment/forum/201903/13/112242iigippjn677puq6w.jpg',60,'1559990038349',1,1),(5,'need teacher','1559729180000','1559901980000',8,'this is description','www.baidu.com|www.bing.com',30,'1559990033969',4,1);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `province` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `county` varchar(30) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `school` varchar(30) DEFAULT NULL COMMENT '志愿者的学校',
  `education_bg` varchar(30) DEFAULT NULL,
  `id_number` varchar(50) DEFAULT NULL,
  `name_of_contact_person` varchar(30) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `role` tinyint(1) DEFAULT NULL,
  `description` text,
  `school_level` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'武汉理工','湖北','武汉','武汉','某个街道','17396178857',NULL,'111111',NULL,NULL,NULL,NULL,1,1,'某个984.5','中学'),(2,'大雄马子反','云南','昭通','彝良','某小草坝镇','17296178857',NULL,'123456',NULL,NULL,NULL,NULL,1,1,'主要开展社区综合社会服务；为山区儿童提供社区教育、同伴教育、助学、营期游学等儿童及青少年教育支持项目','小学'),(3,'瓦拖','四川','凉山彝族自治区','美姑','无','1729278857',NULL,'123456',NULL,NULL,NULL,NULL,1,1,'为山区失学儿童提供持续教育资源。目前项目部涵盖教师培训、校点管理、物资支持、爱心助学等方面内容','小学'),(4,'wut','hubei','wuhan','wuhan','somewhere in wuhan','17396178857','17396178857','3d4f2bf07dc1be38b20cd6e46949a1071f9d0e3d',NULL,NULL,NULL,NULL,1,1,'i am a 984.5','high school'),(5,'whut','hubei','wuhan','wuhan','somewhere in wuhan','17396178858','17396178858','3d4f2bf07dc1be38b20cd6e46949a1071f9d0e3d',NULL,NULL,NULL,NULL,1,1,'i am a 984.5','high school');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-08 19:21:50
