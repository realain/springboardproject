CREATE DATABASE  IF NOT EXISTS `springboard` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `springboard`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: springboard
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `userIdx` bigint NOT NULL,
  `title` varchar(45) NOT NULL,
  `boardIdx` int NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `insertdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`boardIdx`),
  UNIQUE KEY `boardnum_UNIQUE` (`boardIdx`),
  KEY `board_uesrIdx_user_userIdx_fk_idx` (`userIdx`),
  CONSTRAINT `board_uesrIdx_user_userIdx_fk` FOREIGN KEY (`userIdx`) REFERENCES `user` (`userIdx`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'제목 작성 완료',1,'내용 작성 완료','2022-09-29 07:09:47'),(1,'제목 작성 완료1',2,'내용 작성 완료1','2022-09-29 07:09:47');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cmt`
--

DROP TABLE IF EXISTS `cmt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cmt` (
  `cmtIdx` int NOT NULL AUTO_INCREMENT,
  `userIdx` bigint NOT NULL,
  `content` varchar(8000) NOT NULL,
  `boardIdx` int NOT NULL,
  `insertdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `parent` int DEFAULT NULL,
  `floor` int NOT NULL DEFAULT '0',
  `cmtorder` int NOT NULL DEFAULT '0',
  `cmtgroup` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`cmtIdx`),
  UNIQUE KEY `bcommentnum_UNIQUE` (`cmtIdx`),
  KEY `bcomment_boardnum_board_boardnum_fk_idx` (`boardIdx`),
  KEY `cmt_uesrIdx_user_userIdx_fk` (`userIdx`),
  CONSTRAINT `cmt_boardIdx_board_boardIdx_fk` FOREIGN KEY (`boardIdx`) REFERENCES `board` (`boardIdx`) ON DELETE CASCADE,
  CONSTRAINT `cmt_uesrIdx_user_userIdx_fk` FOREIGN KEY (`userIdx`) REFERENCES `user` (`userIdx`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cmt`
--

LOCK TABLES `cmt` WRITE;
/*!40000 ALTER TABLE `cmt` DISABLE KEYS */;
INSERT INTO `cmt` VALUES (1,1,'내용1',1,'2022-09-29 07:15:08',NULL,0,0,0),(2,1,'내용2',1,'2022-09-29 07:15:08',NULL,0,0,1),(3,1,'내용3',1,'2022-09-29 07:15:08',1,1,1,0),(4,1,'내용4',1,'2022-09-29 07:15:08',1,1,2,0),(5,1,'내용5',1,'2022-09-29 07:15:08',4,2,3,0),(6,1,'내용6',1,'2022-09-29 07:15:08',1,1,4,0),(7,1,'내용7',1,'2022-09-29 07:15:08',NULL,0,0,2),(8,1,'1234',1,'2022-09-29 07:22:14',7,1,1,2),(9,1,'1234',1,'2022-09-29 07:22:21',8,2,2,2),(10,1,'1234',1,'2022-09-29 07:22:25',8,2,2,2),(11,1,'1245',1,'2022-09-29 07:22:31',8,2,2,2);
/*!40000 ALTER TABLE `cmt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userIdx` bigint NOT NULL AUTO_INCREMENT,
  `id` varchar(45) NOT NULL,
  `pw` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `insertdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `grade` int NOT NULL,
  PRIMARY KEY (`userIdx`),
  UNIQUE KEY `userid_UNIQUE` (`id`),
  UNIQUE KEY `usernumber_UNIQUE` (`userIdx`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='			';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin','admin','01089373790','2022-09-27 07:48:59',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'springboard'
--
/*!50003 DROP PROCEDURE IF EXISTS `c_insert_logic` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `c_insert_logic`(
    in param_useridx integer,
    in param_content varchar(8000),
    in param_boardidx integer,
    in param_cmtgroup integer,
	in param_floor integer,
    in param_parent integer,
    in param_cmtorder integer,
    in param_cmtidx integer
)
BEGIN
	declare param_num integer;

	select count(*) into param_num from cmt where floor= param_floor and parent = param_parent;
    -- 대댓글이 하나 이상 경우
    if param_num > 0 then
    UPDATE cmt set cmtorder = cmtorder+1 where cmtorder > (select MIN(cmtorder) from ((select cmtorder from cmt as cmt_a3 where cmtorder > (select cmtorder from cmt as cmt_a4 where cmtIdx = param_cmtidx) and cmtgroup = param_cmtgroup and boardIdx = param_boardidx)) cmt1);
	INSERT INTO cmt
		(userIdx,content,boardIdx,parent,floor,cmtgroup,cmtorder)
	VALUES
		(param_useridx, param_content,param_boardidx,param_parent,param_floor,param_cmtgroup, (select max(cmtorder) from cmt as cmt_a1 where floor = param_floor and parent = param_parent));
    else
    -- 대댓글이 하나도 없을 경우
    UPDATE cmt set cmtorder = cmtorder+1 where cmtgroup = param_cmtgroup and cmtorder > param_cmtorder and boardIdx = param_boardidx;
	INSERT INTO cmt
		(userIdx,content,boardIdx,parent,floor,cmtgroup,cmtorder)
	VALUES
		(param_useridx, param_content,param_boardidx,param_parent,param_floor,param_cmtgroup, param_cmtorder+1);
    end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-29 16:36:16
