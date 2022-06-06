DROP DATABASE IF EXISTS bmall;
CREATE DATABASE bmall;
USE bmall;
DROP TABLE IF EXISTS goods;
DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS `order`;

CREATE TABLE goods
(
    id BIGINT(20) NOT NULL COMMENT '主键ID',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '商品名',
    price INT(11) NOT NULL DEFAULT 0 COMMENT '商品单价',
    PRIMARY KEY (id)
);

CREATE TABLE inventory
(
    goods_id BIGINT(20) NOT NULL COMMENT '商品id',
    balance INT(11) NOT NULL DEFAULT 0 COMMENT '库存余额',
    PRIMARY KEY (goods_id)
);

CREATE TABLE `order`
(
    id BIGINT(20) NOT NULL COMMENT '主键ID',
    user_id BIGINT(20) NOT NULL COMMENT '用户id',
    goods_id BIGINT(20) NOT NULL COMMENT '商品id',
    count INT(11) NOT NULL DEFAULT 0 COMMENT '购买数量',
    amount INT(11) NOT NULL DEFAULT 0 COMMENT '订单金额',
    PRIMARY KEY (id)
);

INSERT INTO goods (id, name, price) VALUES
(1, 'iphone 13', 650000),
(2, 'xiaomi 12', 349900);

INSERT INTO inventory (goods_id, balance) VALUES
(1, 10),
(2, 10);

DELIMITER $$
DROP PROCEDURE IF EXISTS proc_initData$$

CREATE PROCEDURE proc_initData()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i<=1000 DO
        INSERT INTO goods (`id`, `name`, `price`) VALUES(i+100, CONCAT('goods_', i+100), 200000+i*100);
        INSERT INTO inventory (`goods_id`, `balance`) VALUES(i+100, 10);
        SET i = i+1;
    END WHILE;
END$$

DELIMITER ;
CALL proc_initData();