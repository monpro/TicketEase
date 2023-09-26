drop table if exists `member`;
create table `member` (
  `id` bigint not null,
  `mobile` varchar(11),
  primary key (`id`),
  unique key `mobile_unique` (`mobile`)
) engine=innodb default charset=utf8mb4;