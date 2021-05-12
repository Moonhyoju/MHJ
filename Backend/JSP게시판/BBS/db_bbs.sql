-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        8.0.22 - MySQL Community Server - GPL
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- bbs 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `bbs` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bbs`;

-- 테이블 bbs.bbs 구조 내보내기
CREATE TABLE IF NOT EXISTS `bbs` (
  `bbsID` int NOT NULL,
  `bbsTitle` varchar(50) DEFAULT NULL,
  `userID` varchar(20) DEFAULT NULL,
  `bbsDate` datetime DEFAULT NULL,
  `bbsContent` varchar(2048) DEFAULT NULL,
  `bbsAvailable` int DEFAULT NULL,
  PRIMARY KEY (`bbsID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 bbs.bbs:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `bbs` DISABLE KEYS */;
INSERT INTO `bbs` (`bbsID`, `bbsTitle`, `userID`, `bbsDate`, `bbsContent`, `bbsAvailable`) VALUES
	(1, 'aaa', 'aaa', '2021-05-11 17:37:53', 'aaa', 1);
/*!40000 ALTER TABLE `bbs` ENABLE KEYS */;

-- 테이블 bbs.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `userID` varchar(20) NOT NULL,
  `userPassword` varchar(20) DEFAULT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `userGender` varchar(20) DEFAULT NULL,
  `userEmail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 bbs.user:~7 rows (대략적) 내보내기
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`userID`, `userPassword`, `userName`, `userGender`, `userEmail`) VALUES
	('aaa', '1234', 'aaa', '남자', 'aaa@aaa'),
	('bbb', '1234', 'bbb', '여자', 'bbb@bbb'),
	('ccc', '1234', 'ccc', '남자', 'ccc@ccc'),
	('ddd', '1234', 'ddd', '여자', 'ddd@ddd'),
	('fff', '1234', 'fff', '여자', 'fff@fff'),
	('ggg', '1234', 'ggg', '남자', 'ggg@ggg'),
	('hhh', '1234', 'hhh', '여자', 'hhh@hhh');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
