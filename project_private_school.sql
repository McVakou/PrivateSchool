CREATE DATABASE  IF NOT EXISTS `project_private_school` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `project_private_school`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: project_private_school
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `ass_per_course`
--

DROP TABLE IF EXISTS `ass_per_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ass_per_course` (
  `assignment_id` int NOT NULL,
  `course_id` int NOT NULL,
  PRIMARY KEY (`assignment_id`,`course_id`),
  KEY `fk_ass_per_course__course_cid_idx` (`course_id`),
  CONSTRAINT `fk_ass_per_course__assignments_aid` FOREIGN KEY (`assignment_id`) REFERENCES `assignments` (`assignment_id`),
  CONSTRAINT `fk_ass_per_course__course_cid` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ass_per_course`
--

LOCK TABLES `ass_per_course` WRITE;
/*!40000 ALTER TABLE `ass_per_course` DISABLE KEYS */;
INSERT INTO `ass_per_course` VALUES (1,1),(2,1),(7,2),(9,2),(3,3),(11,3),(5,4),(10,5),(4,6),(8,6);
/*!40000 ALTER TABLE `ass_per_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ass_per_student_per_course`
--

DROP TABLE IF EXISTS `ass_per_student_per_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ass_per_student_per_course` (
  `assignment_id` int NOT NULL,
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  `oral_mark` int DEFAULT '0',
  `total_mark` int DEFAULT '0',
  PRIMARY KEY (`assignment_id`,`student_id`,`course_id`),
  KEY `mlkia_idx` (`student_id`,`course_id`),
  KEY `mlkia 2_idx` (`assignment_id`),
  CONSTRAINT `fk_apspc_assignments_aid` FOREIGN KEY (`assignment_id`) REFERENCES `assignments` (`assignment_id`),
  CONSTRAINT `fk_apspc_enrollments_sid_cid` FOREIGN KEY (`student_id`, `course_id`) REFERENCES `enrollments` (`student_id`, `course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ass_per_student_per_course`
--

LOCK TABLES `ass_per_student_per_course` WRITE;
/*!40000 ALTER TABLE `ass_per_student_per_course` DISABLE KEYS */;
INSERT INTO `ass_per_student_per_course` VALUES (1,6,1,100,100),(2,7,1,15,22),(3,9,3,0,0),(4,1,6,0,0),(5,3,4,0,0),(7,5,2,0,0),(8,1,6,0,0),(9,8,2,0,0),(10,1,5,0,0),(10,2,5,75,70),(11,4,3,0,0);
/*!40000 ALTER TABLE `ass_per_student_per_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignments`
--

DROP TABLE IF EXISTS `assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignments` (
  `assignment_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `description` varchar(400) NOT NULL,
  `sub_date_time` date DEFAULT NULL,
  PRIMARY KEY (`assignment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignments`
--

LOCK TABLES `assignments` WRITE;
/*!40000 ALTER TABLE `assignments` DISABLE KEYS */;
INSERT INTO `assignments` VALUES (1,'Math ex.1','Project math 1','2020-01-01'),(2,'Math ex.2','Project math 2','2020-01-01'),(3,'Music ex.1','Project music 1','2020-01-01'),(4,'Music ex.2','Project music 2','2020-01-01'),(5,'Poetry intro','Project  poetry','2020-01-01'),(6,'Philosophy thesis','Explaine why apples fall','2020-01-01'),(7,'Science ex.1','Calculate an explosion','2020-01-01'),(8,'Analyse a song','Choose any song and analyse it','2020-01-01'),(9,'Science final project','Calories of an explosion','2020-01-01'),(10,'Pot And Pan Precision','Cook a breakfast meal','2020-01-01'),(11,'Play your first piano song','Play dupstep on piano','2020-01-01');
/*!40000 ALTER TABLE `assignments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `stream` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Math','Vectors','full-time','2019-01-01','2020-09-01'),(2,'Science','Nuclear physics','part-time','2019-01-02','2020-09-02'),(3,'Music','Clarinet','part-time','2019-01-03','2020-09-03'),(4,'Poetry','Greek poets','part-time','2019-01-04','2020-09-04'),(5,'Cooking','Mediterranean recipes','full-time','2019-01-05','2020-09-05'),(6,'Music','Piano','full-time','2019-01-03','2020-09-03'),(7,'Proramming','Java','part-time','2019-01-03','2020-05-01');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrollments`
--

DROP TABLE IF EXISTS `enrollments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enrollments` (
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  PRIMARY KEY (`student_id`,`course_id`),
  KEY `fk_enrollments_student_idx` (`student_id`),
  KEY `fk_enrollments_course_idx` (`course_id`),
  CONSTRAINT `fk_enrollments_course_cid` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`),
  CONSTRAINT `fk_enrollments_student_sid` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollments`
--

LOCK TABLES `enrollments` WRITE;
/*!40000 ALTER TABLE `enrollments` DISABLE KEYS */;
INSERT INTO `enrollments` VALUES (1,5),(1,6),(2,5),(3,4),(4,3),(5,2),(6,1),(7,1),(8,2),(8,6),(9,2),(9,3);
/*!40000 ALTER TABLE `enrollments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `tuition_fees` double DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'Konstantinos','Vakouftsis',100,'1992-03-21'),(2,'Dimitra','Vakouftsi',222,'1980-01-01'),(3,'Eleni','Vakouftsi',546,'1980-01-01'),(4,'Ioannis','Vakouftsis',412,'1953-01-01'),(5,'Vasiliki','Mixalopoulou',545,'1955-01-01'),(6,'Eva','Lefa',423,'1995-01-01'),(7,'Simeon','Simeonidis',45,'1991-01-01'),(8,'Dimitris','Zotos',56,'1990-01-01'),(9,'Vasilis','Zotos',999,'1991-01-01');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainer_per_course`
--

DROP TABLE IF EXISTS `trainer_per_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainer_per_course` (
  `trainer_id` int NOT NULL,
  `course_id` int NOT NULL,
  PRIMARY KEY (`trainer_id`,`course_id`),
  KEY `fk_trainer_per_course__courses_cid_idx` (`course_id`),
  CONSTRAINT `fk_trainer_per_course__courses_cid` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`),
  CONSTRAINT `fk_trainer_per_course__trainers_tid` FOREIGN KEY (`trainer_id`) REFERENCES `trainers` (`trainer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainer_per_course`
--

LOCK TABLES `trainer_per_course` WRITE;
/*!40000 ALTER TABLE `trainer_per_course` DISABLE KEYS */;
INSERT INTO `trainer_per_course` VALUES (1,1),(2,2),(5,3),(6,3),(4,4),(7,5),(3,7);
/*!40000 ALTER TABLE `trainer_per_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainers`
--

DROP TABLE IF EXISTS `trainers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainers` (
  `trainer_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `subject` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`trainer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainers`
--

LOCK TABLES `trainers` WRITE;
/*!40000 ALTER TABLE `trainers` DISABLE KEYS */;
INSERT INTO `trainers` VALUES (1,'Aditya','Leon','Math'),(2,'Danielle ','Truong','Physics'),(3,'Lyndon ','Strickland','Programmer'),(4,'Susie ','Pugh','Poetry'),(5,'Fergus ','Jacobson','Music'),(6,'Stacie ','Prentice','Music'),(7,'Allana ','Boyer','Cooking');
/*!40000 ALTER TABLE `trainers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-22 14:26:15
