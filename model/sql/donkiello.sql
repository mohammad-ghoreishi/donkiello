/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2/27/2015 11:58:51 AM                        */
/*==============================================================*/


drop table if exists DON_BUSSINESS;

drop table if exists DON_CUSTOMER;

drop table if exists DON_PAST;

drop table if exists DON_PERSONAL;

drop table if exists DON_PROGRAM;

drop table if exists DON_USERS;

/*==============================================================*/
/* Table: DON_BUSSINESS                                         */
/*==============================================================*/
create table DON_BUSSINESS
(
   DON368ID             int not null auto_increment,
   DON360ID             int not null,
   DON368BUSS_NAME      varchar(1000),
   DON368POSITION       varchar(1000),
   DON368BUSS_ADDRESS   varchar(3000),
   DON368BRAND          varchar(1000),
   DON368BUSS_FIELD     varchar(1000),
   DON368OFFICE_TEL     varchar(1000),
   DON368SECRETARY_NAME varchar(1000),
   DON368SECRETARY_TEL  varchar(1000),
   DON368FAX            varchar(1000),
   DON368BUSS_MAIL      varchar(1000),
   DON368BUSS_WEBSITE   varchar(200),
   DON368BRANCH_COMP    varchar(1000),
   DON368PAST_COMPS     varchar(1000),
   DON368BUSS_DESCREPTION varchar(2000),
   DON368TAG            varchar(500),
   DON368DELETED        decimal(1) default 0,
   primary key (DON368ID)
);

/*==============================================================*/
/* Table: DON_CUSTOMER                                          */
/*==============================================================*/
create table DON_CUSTOMER
(
   DON360ID             int not null auto_increment,
   DON360CUSTOMER_RATE  text,
   DON360CUSTOMER_ECO_RATE text,
   DON360DELETED        decimal(1) default 0,
   DON360NAME           varchar(1000),
   DON360IMAGE          longblob,
   DON360BUSSINESS_NAMES varchar(5000),
   DON360PROGRAMS       varchar(500),
   DON360PAYMENT_STATUS varchar(100),
   DON360MOBILENO       varchar(200),
   primary key (DON360ID)
);

/*==============================================================*/
/* Table: DON_PAST                                              */
/*==============================================================*/
create table DON_PAST
(
   DON365ID             int not null auto_increment,
   DON360ID             int not null,
   DON365DEGREE         varchar(1000),
   DON365EDU_FIELD      varchar(1000),
   DON365UNI_NAME       varchar(1000),
   DON365UNI_CITY       varchar(1000),
   DON365GRADIATION_DATE date,
   DON365DELETED        decimal(1) default 0,
   primary key (DON365ID)
);

/*==============================================================*/
/* Table: DON_PERSONAL                                          */
/*==============================================================*/
create table DON_PERSONAL
(
   DON361ID             int not null auto_increment,
   DON360ID             int not null,
   DON361NAME           varchar(1000),
   DON361FAMILY_NAME    varchar(1000),
   DON361GENDER         decimal(1),
   DON361MOBILE_NUMBER  varchar(1000),
   DON361EN_NAME        varchar(1000),
   DON361EN_FAMILY      varchar(1000),
   DON361PREFIX         varchar(1000),
   DON361EN_PREFIX      varchar(1000),
   DON361HOME_TEL       varchar(1000),
   DON361HOME_FAX       varchar(1000),
   DON361POSTAL_CODE    varchar(1000),
   DON361HOME_ADDRESS   varchar(3000),
   DON361F_H_NAME       varchar(1000),
   DON361EN_F_H_NAME    varchar(1000),
   DON361BIRTHDAY       date,
   DON361EN_HOME_ADDRESS varchar(1000),
   DON361BIRTH_PLACE    varchar(1000),
   DON361PASSPORT_NO    varchar(1000),
   DON361BIRTH_CER_NO   varchar(100),
   DON361PERSONAL_MAIL  varchar(100),
   DON361PASSPORT_SCAN  longblob,
   DON361BIRTH_CERT_SCAN longblob,
   DON361DESCRIPTION    text,
   DON361HOBBIES        varchar(1000),
   DON364DELETED        decimal(1) default 0,
   primary key (DON361ID)
);

/*==============================================================*/
/* Table: DON_PROGRAM                                           */
/*==============================================================*/
create table DON_PROGRAM
(
   DON364ID             int not null auto_increment,
   DON360ID             int not null,
   DON364PROGRAM_NAME   varchar(1000),
   DON364MASTER_THESIS  varchar(2000),
   DON364THESIS_SUBJECT varchar(2000),
   DON364SUPERVISOR     varchar(1000),
   DON364FIRST_PAYMENT  varchar(100),
   DON364SECOND_PAYMENT varchar(100),
   DON364PAYMENT_DESC   varchar(2000),
   DON364DELETED        decimal(1) default 0,
   DON364ISSTUDYING     varchar(100),
   DON364PAYMENT_STATUS varchar(100),
   primary key (DON364ID)
);

/*==============================================================*/
/* Table: DON_USERS                                             */
/*==============================================================*/
create table DON_USERS
(
   DON369ID             int not null auto_increment,
   DON369USERNAME       varchar(30),
   DON369PASSWORD       varchar(30),
   DON369NAME           varchar(50),
   DON369FAMILY         varchar(50),
   DON369IMAGE          longblob,
   DON369ROLE           varchar(30),
   DON369DELETED        decimal(1) default 0,
   primary key (DON369ID)
);

alter table DON_BUSSINESS add constraint FK_CUSTOMER_BUSSINESS foreign key (DON360ID)
      references DON_CUSTOMER (DON360ID) on delete cascade on update cascade;

alter table DON_PAST add constraint FK_CUSTOMER_PAST foreign key (DON360ID)
      references DON_CUSTOMER (DON360ID) on delete cascade on update cascade;

alter table DON_PERSONAL add constraint FK_CUSTOMER_PERSONAL foreign key (DON360ID)
      references DON_CUSTOMER (DON360ID) on delete cascade on update cascade;

alter table DON_PROGRAM add constraint FK_CUSTOMER_PROGRAM foreign key (DON360ID)
      references DON_CUSTOMER (DON360ID) on delete cascade on update cascade;

