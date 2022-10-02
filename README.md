# Automated_Auction_System-


mysql commands to create tables;

Total Number of tables used :5:

1.admin

      create table admin
      (
      admin_id int primary key auto_increment,
      admin_name varchar(25) not null, 
      admin_email varchar(25) not null,
      admin_password varchar(15) not null
      );
      
      +----------------+-------------+------+-----+---------+----------------+
      | Field          | Type        | Null | Key | Default | Extra          |
      +----------------+-------------+------+-----+---------+----------------+
      | admin_id       | int         | NO   | PRI | NULL    | auto_increment |
      | admin_name     | varchar(25) | NO   |     | NULL    |                |
      | admin_email    | varchar(25) | NO   |     | NULL    |                |
      | admin_password | varchar(15) | NO   |     | NULL    |                |
      +----------------+-------------+------+-----+---------+----------------+
2.buyer

      create table buyer
      (
      buyer_id int primary key auto_increment,
      buyer_name varchar(20) not null,
      buyer_email varchar(25) not null,
      buyer_password varchar(15) not null,
      buyer_signup_date date not null
      );
      +-------------------+-------------+------+-----+---------+----------------+
      | Field             | Type        | Null | Key | Default | Extra          |
      +-------------------+-------------+------+-----+---------+----------------+
      | buyer_id          | int         | NO   | PRI | NULL    | auto_increment |
      | buyer_name        | varchar(20) | NO   |     | NULL    |                |
      | buyer_email       | varchar(25) | NO   |     | NULL    |                |
      | buyer_password    | varchar(15) | NO   |     | NULL    |                |
      | buyer_signup_date | date        | NO   |     | NULL    |                |
      +-------------------+-------------+------+-----+---------+----------------+
3.seller

      create table seller
      (
      seller_id int primary key auto_increment,
      seller_name varchar(20) not null,
      seller_email varchar(25) not null,
      seller_password varchar(15) not null,
      seller_signup_date date not null
      );
      +--------------------+-------------+------+-----+---------+----------------+
      | Field              | Type        | Null | Key | Default | Extra          |
      +--------------------+-------------+------+-----+---------+----------------+
      | seller_id          | int         | NO   | PRI | NULL    | auto_increment |
      | seller_name        | varchar(20) | NO   |     | NULL    |                |
      | seller_email       | varchar(25) | NO   |     | NULL    |                |
      | seller_password    | varchar(15) | NO   |     | NULL    |                |
      | seller_signup_date | date        | NO   |     | NULL    |                |
      +--------------------+-------------+------+-----+---------+----------------+
4.product

      create table product
      (
      product_id int primary key auto_increment,
      seller_id int not null,
      disputed boolean not null,
      product_added_date date not null,
      availability boolean not null,
      product_name varchar(25) not null,
      product_time_limit date not null,
      product_price int not null,
      product_selling_price int,
      buyer_id int,
      sold boolean not null,
      product_minimum_bid int not null,
      foreign key(seller_id) references seller(seller_id)
      );
      +-----------------------+-------------+------+-----+---------+----------------+
      | Field                 | Type        | Null | Key | Default | Extra          |
      +-----------------------+-------------+------+-----+---------+----------------+
      | product_id            | int         | NO   | PRI | NULL    | auto_increment |
      | seller_id             | int         | NO   | MUL | NULL    |                |
      | disputed              | tinyint(1)  | NO   |     | NULL    |                |
      | product_added_date    | date        | NO   |     | NULL    |                |
      | availability          | tinyint(1)  | NO   |     | NULL    |                |
      | product_name          | varchar(25) | NO   |     | NULL    |                |
      | product_time_limit    | date        | NO   |     | NULL    |                |
      | product_price         | int         | NO   |     | NULL    |                |
      | product_selling_price | int         | YES  |     | NULL    |                |
      | buyer_id              | int         | YES  |     | NULL    |                |
      | sold                  | tinyint(1)  | NO   |     | NULL    |                |
      | product_minimum_bid   | int         | NO   |     | NULL    |                |
      +-----------------------+-------------+------+-----+---------+----------------+
5.bid

      create table bid
      (
      product_id int not null,
      buyer_id int not null,
      bid_date date not null,
      bidding_amount int not null,
      prod_price_before_bid int not null,
      prod_price_after_bid int not null,
      foreign key(product_id) references product(product_id),
      foreign key(buyer_id) references buyer(buyer_id)
      );
      +-----------------------+------+------+-----+---------+-------+
      | Field                 | Type | Null | Key | Default | Extra |
      +-----------------------+------+------+-----+---------+-------+
      | product_id            | int  | NO   | MUL | NULL    |       |
      | buyer_id              | int  | NO   | MUL | NULL    |       |
      | bid_date              | date | NO   |     | NULL    |       |
      | bidding_amount        | int  | NO   |     | NULL    |       |
      | prod_price_before_bid | int  | NO   |     | NULL    |       |
      | prod_price_after_bid  | int  | NO   |     | NULL    |       |
      +-----------------------+------+------+-----+---------+-------+
