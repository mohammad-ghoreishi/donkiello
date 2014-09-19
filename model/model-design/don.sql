/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     9/1/2014 4:47:44 PM                          */
/*==============================================================*/


alter table "don_bussiness"
   drop constraint FK_DON_BUSS_BUSS_DONB_DON_BUSS;

alter table "don_bussiness-info"
   drop constraint FK_DON_BUSS_BUSS_CUST_DON_CUST;

alter table "don_customer"
   drop constraint FK_DON_CUST_BUSS_CUST_DON_BUSS;

alter table "don_customer"
   drop constraint FK_DON_CUST_EDU_CUSTO_DON_EDUC;

alter table "don_customer"
   drop constraint FK_DON_CUST_PER_CUSTO_DON_PERS;

alter table "don_educational-info"
   drop constraint FK_DON_EDUC_EDU_CUSTO_DON_CUST;

alter table "don_hobbies"
   drop constraint FK_DON_HOBB_PER_HOBBY_DON_PERS;

alter table "don_past"
   drop constraint FK_DON_PAST_EDU_PAST_DON_EDUC;

alter table "don_personal"
   drop constraint FK_DON_PERS_PER_CUSTO_DON_CUST;

alter table "don_products"
   drop constraint FK_DON_PROD_BUSS_PROD_DON_BUSS;

alter table "don_program"
   drop constraint FK_DON_PROG_EDU_PROGR_DON_EDUC;

drop index "buss_donbuss_FK";

drop table "don_bussiness" cascade constraints;

drop index "buss_customer2_FK";

drop table "don_bussiness-info" cascade constraints;

drop index "per_customer_FK";

drop index "edu_customer_FK";

drop index "buss_customer_FK";

drop table "don_customer" cascade constraints;

drop index "edu_customer2_FK";

drop table "don_educational-info" cascade constraints;

drop index "per_hobby_FK";

drop table "don_hobbies" cascade constraints;

drop index "edu_past_FK";

drop table "don_past" cascade constraints;

drop index "per_customer2_FK";

drop table "don_personal" cascade constraints;

drop index "buss_product_FK";

drop table "don_products" cascade constraints;

drop index "edu_program_FK";

drop table "don_program" cascade constraints;

/*==============================================================*/
/* Table: "don_bussiness"                                       */
/*==============================================================*/
create table "don_bussiness" 
(
   "don368id"           INTEGER              not null,
   "don366id"           INTEGER,
   "don368buss_name"    CLOB,
   "don368position"     CLOB,
   "don368buss_address" CLOB,
   "don368brand"        CLOB,
   "don368buss_field"   CLOB,
   "don368office_tel"   CLOB,
   "don368secretary_name" CLOB,
   "don368secretary_tel" CLOB,
   "don368fax"          CLOB,
   "don368buss_mail"    CLOB,
   "don368buss_website" CLOB,
   "don368branch_comp"  CLOB,
   "don368past_comps"   CLOB,
   "don368buss_descreption" CLOB,
   constraint PK_DON_BUSSINESS primary key ("don368id")
);

/*==============================================================*/
/* Index: "buss_donbuss_FK"                                     */
/*==============================================================*/
create index "buss_donbuss_FK" on "don_bussiness" (
   "don366id" ASC
);

/*==============================================================*/
/* Table: "don_bussiness-info"                                  */
/*==============================================================*/
create table "don_bussiness-info" 
(
   "don366id"           INTEGER              not null,
   "don360id"           INTEGER,
   constraint "PK_DON_BUSSINESS-INFO" primary key ("don366id")
);

/*==============================================================*/
/* Index: "buss_customer2_FK"                                   */
/*==============================================================*/
create index "buss_customer2_FK" on "don_bussiness-info" (
   "don360id" ASC
);

/*==============================================================*/
/* Table: "don_customer"                                        */
/*==============================================================*/
create table "don_customer" 
(
   "don360id"           INTEGER              not null,
   "don361id"           INTEGER,
   "don363id"           INTEGER,
   "don366id"           INTEGER,
   "don360customer_rate" CLOB,
   "don360customer_eco_rate" CLOB,
   constraint PK_DON_CUSTOMER primary key ("don360id")
);

/*==============================================================*/
/* Index: "buss_customer_FK"                                    */
/*==============================================================*/
create index "buss_customer_FK" on "don_customer" (
   "don366id" ASC
);

/*==============================================================*/
/* Index: "edu_customer_FK"                                     */
/*==============================================================*/
create index "edu_customer_FK" on "don_customer" (
   "don363id" ASC
);

/*==============================================================*/
/* Index: "per_customer_FK"                                     */
/*==============================================================*/
create index "per_customer_FK" on "don_customer" (
   "don361id" ASC
);

/*==============================================================*/
/* Table: "don_educational-info"                                */
/*==============================================================*/
create table "don_educational-info" 
(
   "don363id"           INTEGER              not null,
   "don360id"           INTEGER,
   constraint "PK_DON_EDUCATIONAL-INFO" primary key ("don363id")
);

/*==============================================================*/
/* Index: "edu_customer2_FK"                                    */
/*==============================================================*/
create index "edu_customer2_FK" on "don_educational-info" (
   "don360id" ASC
);

/*==============================================================*/
/* Table: "don_hobbies"                                         */
/*==============================================================*/
create table "don_hobbies" 
(
   "don362id"           INTEGER              not null,
   "don361id"           INTEGER,
   "don362hobby_name"   CLOB,
   constraint PK_DON_HOBBIES primary key ("don362id")
);

/*==============================================================*/
/* Index: "per_hobby_FK"                                        */
/*==============================================================*/
create index "per_hobby_FK" on "don_hobbies" (
   "don361id" ASC
);

/*==============================================================*/
/* Table: "don_past"                                            */
/*==============================================================*/
create table "don_past" 
(
   "don365id"           INTEGER              not null,
   "don363id"           INTEGER,
   "don365degree"       CLOB,
   "don365edu_field"    CLOB,
   "don365uni_name"     CLOB,
   "don365uni_city"     CLOB,
   "don365gradiation_date" DATE,
   constraint PK_DON_PAST primary key ("don365id")
);

/*==============================================================*/
/* Index: "edu_past_FK"                                         */
/*==============================================================*/
create index "edu_past_FK" on "don_past" (
   "don363id" ASC
);

/*==============================================================*/
/* Table: "don_personal"                                        */
/*==============================================================*/
create table "don_personal" 
(
   "don361id"           INTEGER              not null,
   "don360id"           INTEGER,
   "don361name"         CLOB,
   "don361family_name"  CLOB,
   "don361gender"       NUMBER(1),
   "don361mobile_number" CLOB,
   "don361en_name"      CLOB,
   "don361en_family"    CLOB,
   "don361prefix"       CLOB,
   "don361en_prefix"    CLOB,
   "don361home_tel"     CLOB,
   "don361home_fax"     CLOB,
   "don361postal_code"  CLOB,
   "don361home_address" CLOB,
   "don361f_h_name"     CLOB,
   "don361en_f_h_name"  CLOB,
   "don361birthday"     DATE,
   "don361en_home_address" CLOB,
   "don361birth_place"  CLOB,
   "don361passport_no"  CLOB,
   "don361birth_cer_no" CLOB,
   "don361personal_mail" CLOB,
   "don361passport_scan" RAW(100000),
   "don361birth_cert_scan" RAW(100000),
   "don361description"  CLOB,
   constraint PK_DON_PERSONAL primary key ("don361id")
);

/*==============================================================*/
/* Index: "per_customer2_FK"                                    */
/*==============================================================*/
create index "per_customer2_FK" on "don_personal" (
   "don360id" ASC
);

/*==============================================================*/
/* Table: "don_products"                                        */
/*==============================================================*/
create table "don_products" 
(
   "don367id"           INTEGER              not null,
   "don366id"           INTEGER,
   "don367tag_name"     CLOB,
   "don367description"  CLOB,
   constraint PK_DON_PRODUCTS primary key ("don367id")
);

/*==============================================================*/
/* Index: "buss_product_FK"                                     */
/*==============================================================*/
create index "buss_product_FK" on "don_products" (
   "don366id" ASC
);

/*==============================================================*/
/* Table: "don_program"                                         */
/*==============================================================*/
create table "don_program" 
(
   "don364id"           INTEGER              not null,
   "don363id"           INTEGER,
   "don364program_name" CLOB,
   "don364master_thesis" CLOB,
   "don364thesis_subject" CLOB,
   "don364supervisor"   CLOB,
   "don364first_payment" NUMBER(1),
   "don364second_payment" NUMBER(1),
   "don364payment_desc" CLOB,
   constraint PK_DON_PROGRAM primary key ("don364id")
);

/*==============================================================*/
/* Index: "edu_program_FK"                                      */
/*==============================================================*/
create index "edu_program_FK" on "don_program" (
   "don363id" ASC
);

alter table "don_bussiness"
   add constraint FK_DON_BUSS_BUSS_DONB_DON_BUSS foreign key ("don366id")
      references "don_bussiness-info" ("don366id");

alter table "don_bussiness-info"
   add constraint FK_DON_BUSS_BUSS_CUST_DON_CUST foreign key ("don360id")
      references "don_customer" ("don360id");

alter table "don_customer"
   add constraint FK_DON_CUST_BUSS_CUST_DON_BUSS foreign key ("don366id")
      references "don_bussiness-info" ("don366id");

alter table "don_customer"
   add constraint FK_DON_CUST_EDU_CUSTO_DON_EDUC foreign key ("don363id")
      references "don_educational-info" ("don363id");

alter table "don_customer"
   add constraint FK_DON_CUST_PER_CUSTO_DON_PERS foreign key ("don361id")
      references "don_personal" ("don361id");

alter table "don_educational-info"
   add constraint FK_DON_EDUC_EDU_CUSTO_DON_CUST foreign key ("don360id")
      references "don_customer" ("don360id");

alter table "don_hobbies"
   add constraint FK_DON_HOBB_PER_HOBBY_DON_PERS foreign key ("don361id")
      references "don_personal" ("don361id");

alter table "don_past"
   add constraint FK_DON_PAST_EDU_PAST_DON_EDUC foreign key ("don363id")
      references "don_educational-info" ("don363id");

alter table "don_personal"
   add constraint FK_DON_PERS_PER_CUSTO_DON_CUST foreign key ("don360id")
      references "don_customer" ("don360id");

alter table "don_products"
   add constraint FK_DON_PROD_BUSS_PROD_DON_BUSS foreign key ("don366id")
      references "don_bussiness-info" ("don366id");

alter table "don_program"
   add constraint FK_DON_PROG_EDU_PROGR_DON_EDUC foreign key ("don363id")
      references "don_educational-info" ("don363id");

