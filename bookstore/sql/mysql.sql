##创建数据库的脚本
drop database if exists bookstore;
create database bookstore;
use bookstore;

##创建用户信息表
create table t_user( `id` int primary key auto_increment,
			 `username` varchar(20) not null unique,
			 `password` varchar(32) not null,
			 `email` varchar(200) );
##这是管理员的账户
insert into t_user(`username`,`password`,`email`) values('admin','admin','admin@163.com');
## 插入初始化测试数据
insert into t_user(`username`,`password`,`email`) values('123456','123456','number@163.com'),
                                                        ('admin1','passowrd','admin1@163.com'),
				             	                        ('admin2','passowrd','admin2@163.com'),
				                                        ('admin3','passowrd','admin3@163.com');
##创建图书库存表
create table t_book( `id` int primary key auto_increment,
                    `name` varchar(100), `price` decimal(11,2),
                    `author` varchar(100),
                    `sales` int,
                    `stock` int,
                    `img_path` varchar(200) );

/*
    插入初始化测试数据
    如果插入数据出现错误，可能是字符集出现问题，使用以下命令：
    set names gbk;
*/
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , 'java 从入门到放弃' , '国哥' , 80 , 9999 , 9 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , '数据结构与算法' , '严敏君' , 78.5 , 6 , 13 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , '怎样拐跑别人的媳妇' , '龙伍' , 68, 99999 , 52 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , '木虚肉盖饭' , '小胖' , 16, 1000 , 50 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , 'C++编程思想' , '刚哥' , 45.5 , 14 , 95 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , '蛋炒饭' , '周星星' , 9.9, 12 , 53 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , '赌神' , '龙伍' , 66.5, 125 , 535 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , 'Java 编程思想' , '阳哥' , 99.5 , 47 , 36 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , 'JavaScript 从入门到精通' , '婷姐' , 9.9 , 85 , 95 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , 'cocos2d-x 游戏编程入门' , '国哥' , 49, 52 , 62 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , 'C 语言程序设计' , '谭浩强' , 28 , 52 , 74 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , 'Lua 语言程序设计' , '雷丰阳' , 51.5 , 48 , 82 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , '西游记' , '罗贯中' , 12, 19 , 9999 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , '水浒传' , '华仔' , 33.05 , 22 , 88 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , '操作系统原理' , '刘优' , 133.05 , 122 , 188 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , '数据结构 java 版' , '封大神' , 173.15 , 21 , 81 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , 'UNIX 高级环境编程' , '乐天' , 99.15 , 210 , 810 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , 'javaScript 高级编程' , '国哥' , 69.15 , 210 , 810 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , '大话设计模式' , '国哥' , 89.15 , 20 , 10 , 'static/img/default.jpg');
insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(null , '人月神话' , '刚哥' , 88.15 , 20 , 80 , 'static/img/default.jpg');

#订单模块数据库
#订单信息
create table t_order( `order_id` varchar(50) primary key,
                        `create_time` datetime,
                         `price` decimal(11,2),
                        `status` int,
                        `user_id` int,
                        foreign key(`user_id`) references t_user(`id`)
                         );
#订单商品信息
create table t_order_item( `id` int primary key auto_increment,
                            `name` varchar(100),
                            `count` int,
                            `price` decimal(11,2),
                            `total_price` decimal(11,2),
                            `order_id` varchar(50),
                            foreign key(`order_id`) references t_order(`order_id`)
                            );