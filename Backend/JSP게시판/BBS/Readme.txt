Mysql << HeidiSQL
IP : localhost
port : 3306
user : root
password : root
database : bbs

table bbs
+--------------+---------------+------+-----+---------+-------+
| Field           | Type            | Null  | Key  | Default | Extra |
+--------------+---------------+------+-----+---------+-------+
| bbsID          | int               | NO   | PRI | NULL    |        |
| bbsTitle       | varchar(50)     | YES  |      | NULL     |       |
| userID         | varchar(20)     | YES  |       | NULL    |       |
| bbsDate       | datetime       | YES  |       | NULL    |       |
| bbsContent   | varchar(2048) | YES   |       | NULL    |       |
| bbsAvailable  | int              | YES   |       | NULL    |       |
+--------------+---------------+------+-----+---------+-------+


table user
+--------------+-------------+------+-----+---------+-------+
| Field           | Type          | Null  | Key  | Default  | Extra |
+--------------+-------------+------+-----+---------+-------+
| userID          | varchar(20) | NO   | PRI   | NULL    |       |
| userPassword | varchar(20) | YES  |        | NULL    |       |
| userName     | varchar(20) | YES  |        | NULL    |       |
| userGender   | varchar(20) | YES   |       | NULL    |       |
| userEmail     | varchar(50)  | YES   |       | NULL    |       |
+--------------+-------------+------+-----+---------+-------+

Bootstrap-3.3.2
Tomcat v9.0
