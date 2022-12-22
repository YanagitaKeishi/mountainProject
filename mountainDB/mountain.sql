CREATE DATABASE  IF NOT EXISTS `mountain_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mountain_db`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mountain_db
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `mountain`
--

DROP TABLE IF EXISTS `mountain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mountain` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `erea` varchar(10) NOT NULL,
  `elevation` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mountain`
--

LOCK TABLES `mountain` WRITE;
/*!40000 ALTER TABLE `mountain` DISABLE KEYS */;
INSERT INTO `mountain` VALUES (1,'利尻岳','北海道',1719),(2,'羅臼岳','北海道',1661),(3,'斜里岳','北海道',1547),(4,'阿寒岳','北海道',1499),(5,'大雪山','北海道',2290),(6,'トムラウシ山','北海道',2141),(7,'十勝岳','北海道',2077),(8,'幌尻岳','北海道',2052),(9,'後方羊蹄山','北海道',1898),(10,'岩木山','東北',1625),(11,'八甲田山','東北',1585),(12,'八幡平','東北',1613),(13,'岩手山','東北',2038),(14,'早池峰山','東北',1917),(15,'鳥海山','東北',2236),(16,'月山','東北',1984),(17,'朝日連峰','東北',1870),(18,'蔵王山','東北',1841),(19,'飯豊連峰','東北',2105),(20,'吾妻山','東北',2035),(21,'安達太良山','東北',1700),(22,'磐梯山','東北',1819),(23,'会津駒ヶ岳','東北',2132),(24,'那須岳','北関東',1915),(25,'筑波山','北関東',877),(26,'燧ヶ岳','尾瀬',2356),(27,'至仏山','尾瀬',2228),(28,'武尊山','上州',2158),(29,'赤城山','上州',1828),(30,'男体山','日光',2486),(31,'日光白根山','日光',2578),(32,'皇海山','足尾',2144),(33,'越後駒ヶ岳','上信越',2003),(34,'平ヶ岳','上信越',2141),(35,'巻機山','上信越',1967),(36,'谷川岳','上信越',1963),(37,'苗場山','上信越',2145),(38,'雨飾山','上信越',1963),(39,'妙高山','上信越',2454),(40,'火打山','上信越',2462),(41,'高妻山','上信越',2353),(42,'草津白根山','上信越',2165),(43,'四阿山','上信越',2354),(44,'浅間山','上信越',2568),(45,'両神山','秩父',1723),(46,'甲武信岳','奥秩父',2475),(47,'金峰山','奥秩父',2595),(48,'瑞牆山','奥秩父',2230),(49,'雲取山','奥秩父',2017),(50,'大菩薩嶺','奥秩父',2057),(51,'丹沢','南関東',1567),(52,'富士山','南関東',3776),(53,'天城山','南関東',1406),(54,'白馬岳','北アルプス',2932),(55,'五竜岳','北アルプス',2814),(56,'鹿島槍ヶ岳','北アルプス',2890),(57,'剱岳','北アルプス',2999),(58,'立山','北アルプス',3015),(59,'薬師岳','北アルプス',2926),(60,'黒部五郎岳','北アルプス',2840),(61,'水晶岳','北アルプス',2978),(62,'鷲羽岳','北アルプス',2924),(63,'槍ヶ岳','北アルプス',3180),(64,'穂高岳','北アルプス',3190),(65,'常念岳','北アルプス',2857),(66,'笠ヶ岳','北アルプス',2897),(67,'焼岳','北アルプス',2444),(68,'乗鞍岳','北アルプス',3026),(69,'美ヶ原','美ヶ原',2034),(70,'霧ヶ峰','霧ヶ峰',1925),(71,'蓼科山','蓼科山',2530),(72,'八ヶ岳','八ヶ岳',2899),(73,'御嶽山','御嶽山',3067),(74,'木曽駒ヶ岳','中央アルプス',2956),(75,'空木岳','中央アルプス',2864),(76,'恵那山','中央アルプス',2191),(77,'甲斐駒ヶ岳','南アルプス',2967),(78,'仙丈ヶ岳','南アルプス',3033),(79,'鳳凰山','南アルプス',2840),(80,'北岳','南アルプス',3192),(81,'間ノ岳','南アルプス',3189),(82,'塩見岳','南アルプス',3047),(83,'悪沢岳','南アルプス',3141),(84,'赤石岳','南アルプス',3120),(85,'聖岳','南アルプス',3013),(86,'光岳','南アルプス',2591),(87,'白山','北陸',2702),(88,'荒島岳','北陸',1524),(89,'伊吹山','近畿',1377),(90,'大台ヶ原山','近畿',1695),(91,'大峰山','近畿',1915),(92,'大山','中国',1709),(93,'剣山','四国',1955),(94,'石鎚山','四国',1982),(95,'九重山','九州',1787),(96,'祖母山','九州',1756),(97,'阿蘇山','九州',1592),(98,'霧島山','九州',1700),(99,'開聞岳','九州',922),(100,'宮之浦岳','九州',1936);
/*!40000 ALTER TABLE `mountain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `erea` varchar(10) NOT NULL,
  `elevation` int NOT NULL,
  `note` varchar(100) DEFAULT NULL,
  `date` date NOT NULL,
  `report_id` varchar(20) NOT NULL,
  `status` varchar(7) NOT NULL DEFAULT 'active',
  PRIMARY KEY (`id`),
  KEY `fk_report_id` (`report_id`),
  CONSTRAINT `fk_report_id` FOREIGN KEY (`report_id`) REFERENCES `user` (`login_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (1,'利尻山','北海道',1719,'・天気が悪かった。','2022-11-05','mount01','active'),(3,'羅臼岳','北海道',1661,'・初のソロ登山\r\n\r\n','2022-11-29','mount01','active'),(4,'岩木山','東北',1625,'・予定より時間が押していたので、登頂後すぐ下山した。','2022-12-03','mount02','active'),(5,'月山','東北',1984,'・ペースが遅かった。\r\n\r\n','2022-12-10','mount01','active'),(6,'日光白根山','日光',2578,'','2022-12-03','mount03','active'),(7,'丹沢','南関東',1567,'・縦走','2022-11-26','mount04','active'),(8,'安達太良山','東北',1700,'','2022-12-04','mount01','deleted'),(9,'富士山','南関東',3776,'','2022-12-17','mount05','active'),(10,'トムラウシ山','北海道',2141,'aaaaaa編集した','2022-12-24','mount01','deleted');
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login_id` varchar(20) NOT NULL,
  `login_pass` char(60) NOT NULL,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_id_UNIQUE` (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'mount01','$2a$08$qlndkbSruIMaBPYADWd3Eeo5cV4xj7dsEypJBMA0fqTm2kJjyBy5O','山田五郎丸'),(2,'mount02','$2a$08$rh0En5O9I20RW2Hk8hGHfe1xobg32cLxEG73nDnUIkVIrUGnk8KOi','田中花子'),(3,'mount03','$2a$08$q2LQUo.9bOU18sfr1uu0YuLm.R1La0iK2wUWOZAVsAVKklIzPjScy','佐藤次郎'),(5,'mount04','$2a$10$UAsjXk2JKVAat.M5119NHu3vTYfsPmwr6iEvWpjTzuY1EsWZaO.HO','中村俊輔'),(6,'mount05','$2a$10$pB.lrlxda8bDVU9Ei7GxVOqFv9Ozj4L3m7LpTI7ckSW6vd0gim4oG','前田大然');
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

-- Dump completed on 2022-12-22 16:10:29
