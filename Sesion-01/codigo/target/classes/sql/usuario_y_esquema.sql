create schema if not exists `BEDU_JSE2`;

create user if not exists 'admin'@'localhost' identified by 'ADMIN_PWD';

grant all on BEDU_JSE2.* to 'admin'@'localhost';

create user if not exists 'usuario2'@'localhost' identified by 'PASSWD';

grant SELECT on BEDU_JSE2.* to 'usuario'@'localhost';

flush privileges;
