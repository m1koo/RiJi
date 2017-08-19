Drop table article;

CREATE TABLE `article` (
  `article_id` varchar(40) Not null,
  `user_id` varchar(20) NOT NULL,
  `edit_time` bigint(20) NOT NULL,
  `year` int(5) not null,
  `month` int(2) not null,
  `day` int(2) not null,
  `location` int(5) not null,
  `completeFlag` tinyint(1) not null default '0',
  `content` varchar(6000) NOT NULL,
  `out_visible` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `article_shared` (
  `article_id` varchar(40) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `share_time` bigint(20) NOT NULL,
  `title` varchar(100) not null,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `user_article_push` (
  `user_id` varchar(20) NOT NULL,
  `lastest_time` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `article_push` (
  `user_id` varchar(20) NOT NULL,
  `article_id` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8
