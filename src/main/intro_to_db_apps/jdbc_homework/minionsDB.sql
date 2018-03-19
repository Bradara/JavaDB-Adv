CREATE DATABASE MinionsDB;
use MinionsDB;

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
-- Table structure for table `evilness`
--

DROP TABLE IF EXISTS `evilness`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evilness` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `factor` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evilness`
--

LOCK TABLES `evilness` WRITE;
/*!40000 ALTER TABLE `evilness` DISABLE KEYS */;
INSERT INTO `evilness` VALUES (1,'good'),(2,'bad'),(3,'evil'),(4,'super evil');
/*!40000 ALTER TABLE `evilness` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `minions`
--

DROP TABLE IF EXISTS `minions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `minions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `town_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_minions_town_id` (`town_id`),
  CONSTRAINT `fk_minions_town_id` FOREIGN KEY (`town_id`) REFERENCES `towns` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `minions`
--

LOCK TABLES `minions` WRITE;
/*!40000 ALTER TABLE `minions` DISABLE KEYS */;
INSERT INTO `minions` VALUES (2,'Marti',29,1),(3,'Neli',38,4),(4,'Stojno',52,4),(5,'Shop',35,3),(6,'Ivo',44,5),(7,'Misho',25,1),(8,'Bob',14,11),(10,'Bob',14,11),(12,'Bob',14,11),(13,'Bob',14,11),(15,'Mars',23,4),(16,'Carry',20,13),(17,'Bob',14,11);
/*!40000 ALTER TABLE `minions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `towns`
--

DROP TABLE IF EXISTS `towns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `towns` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `country` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `towns`
--

LOCK TABLES `towns` WRITE;
/*!40000 ALTER TABLE `towns` DISABLE KEYS */;
INSERT INTO `towns` VALUES (1,'BURGAS','Bulgaria'),(2,'VARNA','Bulgaria'),(3,'PLOVDIV','Bulgaria'),(4,'SOFIA','Bulgaria'),(5,'RUSE','Bulgaria'),(6,'London','Great Britain'),(7,'BERLIN','Germany'),(8,'Liverpool','Great Britain'),(9,'Eindhoven','Netherlands');
/*!40000 ALTER TABLE `towns` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `villains`
--

DROP TABLE IF EXISTS `villains`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `villains` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `evilness` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_villains_evilness` (`evilness`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `villains`
--

LOCK TABLES `villains` WRITE;
/*!40000 ALTER TABLE `villains` DISABLE KEYS */;
INSERT INTO `villains` VALUES (2,'Boian',1),(3,'Asen',1),(4,'Zdrawko',1),(5,'Bojko',3),(8,'Gru',3),(9,'Poppy',3),(10,'Jimmy',3);
/*!40000 ALTER TABLE `villains` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `villains_minions`
--

DROP TABLE IF EXISTS `villains_minions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `villains_minions` (
  `villain_id` int(11) NOT NULL,
  `minion_id` int(11) NOT NULL,
  KEY `fk_villain_id` (`villain_id`),
  KEY `fk_minion_id` (`minion_id`),
  CONSTRAINT `fk_minion_id` FOREIGN KEY (`minion_id`) REFERENCES `minions` (`id`),
  CONSTRAINT `fk_villain_id` FOREIGN KEY (`villain_id`) REFERENCES `villains` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `villains_minions`
--

LOCK TABLES `villains_minions` WRITE;
/*!40000 ALTER TABLE `villains_minions` DISABLE KEYS */;
INSERT INTO `villains_minions` VALUES (2,2),(2,1),(2,3),(3,1),(3,2),(3,3),(3,4),(3,5),(3,6),(4,5),(4,4),(8,8),(8,14),(9,15),(10,16),(8,8),(8,14);
/*!40000 ALTER TABLE `villains_minions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-19  6:58:46
