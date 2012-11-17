# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table product (
  id                        varchar(255) not null,
  name                      varchar(255),
  description               varchar(255),
  bar_code                  varchar(255),
  price                     double,
  constraint pk_product primary key (id))
;

create sequence product_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists product;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists product_seq;

