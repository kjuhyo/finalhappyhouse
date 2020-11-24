create database if not exists happyvue;

use happyvue;

CREATE TABLE `qaboard` (
  `no` int NOT NULL AUTO_INCREMENT,
  `writer` varchar(20) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` varchar(2000) NOT NULL,
  `regtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`no`)
); 


insert into qaboard(writer, title, content) 
values('ssafy', '안녕', '어 안녕'), 
      ('ssafy', '김주효', '바보'),
      ('ssafy', 'ㅇㅇㅇㅇ', 'ㅇㅋㅇㅋㅇㅋㅇㅋㅇㅋㅇㅋㅇㅋㅇㅋ');

commit;

select * from qaboard;