# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table product (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  description               varchar(255),
  bar_code                  varchar(255),
  price                     double,
  constraint pk_product primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table product;

SET FOREIGN_KEY_CHECKS=1;

