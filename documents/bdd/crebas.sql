/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     11/2/2019 10:02:27 PM                        */
/*==============================================================*/

dependeindo de como instalamos postgres podemos usar:

CREATE DATABASE "tracingdb"  WITH OWNER = postgres  
		ENCODING = 'UTF8'
		TABLESPACE = pg_default
		LC_COLLATE = 'Spanish_Spain.1252'
		LC_CTYPE = 'Spanish_Spain.1252'
		CONNECTION LIMIT = -1;

o esto --->

CREATE DATABASE "tracingdb"  WITH OWNER = postgres  
		ENCODING = 'UTF8'
		TABLESPACE = pg_default
		LC_COLLATE = 'English_United States.1252'
		LC_CTYPE = 'English_United States.1252'
		CONNECTION LIMIT = -1;

drop table CLIENT;

drop table COMPONENT;

drop table PROVIDER;

drop table RESPONSIBLE;

drop table SOLUTION;

drop table TICKET;

drop table TICKET_DETAIL;

drop table TICKET_PROD;

drop table TICKET_QA;

/*==============================================================*/
/* Table: CLIENT                                                */
/*==============================================================*/
create table CLIENT (
   CLI_ID               SERIAL               not null,
   CLI_NAME             VARCHAR(20)          null,
   constraint PK_CLIENT primary key (CLI_ID)
);

/*==============================================================*/
/* Table: COMPONENT                                             */
/*==============================================================*/
create table COMPONENT (
   CMP_ID               SERIAL               not null,
   CMP_NAME             VARCHAR(20)          null,
   SOL_ID               INT4                 null,
   constraint PK_COMPONENT primary key (CMP_ID)
);

/*==============================================================*/
/* Table: PROVIDER                                              */
/*==============================================================*/
create table PROVIDER (
   PRV_ID               SERIAL               not null,
   PRV_NAME             VARCHAR(50)          null,
   constraint PK_PROVIDER primary key (PRV_ID)
);

/*==============================================================*/
/* Table: RESPONSIBLE                                           */
/*==============================================================*/
create table RESPONSIBLE (
   RPS_ID               SERIAL               not null,
   RPS_NAME             VARCHAR(50)          null,
   RPS_LAST_NAME        VARCHAR(20)          null,
   PRV_ID               INT4                 null,
   constraint PK_RESPONSIBLE primary key (RPS_ID)
);

/*==============================================================*/
/* Table: SOLUTION                                              */
/*==============================================================*/
create table SOLUTION (
   SOL_ID               SERIAL               not null,
   SOL_NAME             VARCHAR(20)          null,
   CLI_ID               INT4                 null,
   constraint PK_SOLUTION primary key (SOL_ID)
);

/*==============================================================*/
/* Table: TICKET                                                */
/*==============================================================*/
create table TICKET (
   TCK_ID               SERIAL               not null,
   TCK_CODE             VARCHAR(20)          null,
   TCK_URL              VARCHAR(200)         null,
   TCK_TYPE             INT4                 null,
   TCK_STATUS           INT4                 null,
   TCK_FLOW             INT4                 null,
   TCK_ESTIMATED        DECIMAL(3,2)         null,
   TCK_DATE_INI         DATE                 null,
   TCK_DATE_END         DATE                 null,
   TCK_DATE_END_PLAN    DATE                 null,
   SOL_ID               INT4                 null,
   constraint PK_TICKET primary key (TCK_ID)
);

/*==============================================================*/
/* Table: TICKET_DETAIL                                         */
/*==============================================================*/
create table TICKET_DETAIL (
   DTK_ID               SERIAL               not null,
   DTK_STATUS           INT4                 null,
   DTK_ESTIMATED        DECIMAL(3,2)         null,
   DTK_DATE_INI         DATE                 null,
   DTK_DATE_END         DATE                 null,
   DTK_DATE_END_PLAN    DATE                 null,
   RPS_ID               INT4                 null,
   TCK_ID               INT4                 null,
   CMP_ID               INT4                 null,
   constraint PK_TICKET_DETAIL primary key (DTK_ID)
);

/*==============================================================*/
/* Table: TICKET_PROD                                           */
/*==============================================================*/
create table TICKET_PROD (
   TPD_ID               SERIAL               not null,
   TPD_CODE             VARCHAR(20)          null,
   TPD_URL              VARCHAR(200)         null,
   TPD_VERSION          VARCHAR(10)          null,
   TPD_STATUS           INT4                 null,
   TPD_COMMENT          VARCHAR(200)         null,
   DTK_ID               INT4                 null,
   constraint PK_TICKET_PROD primary key (TPD_ID)
);

/*==============================================================*/
/* Table: TICKET_QA                                             */
/*==============================================================*/
create table TICKET_QA (
   TQA_ID               SERIAL               not null,
   TQA_CODE             VARCHAR(20)          null,
   TQA_URL              VARCHAR(200)         null,
   TQA_CYCLE            INT4                 null,
   TQA_VERSION          VARCHAR(10)          null,
   TQA_STATUS           INT4                 null,
   TQA_COMMENT          VARCHAR(200)         null,
   DTK_ID               INT4                 null,
   constraint PK_TICKET_QA primary key (TQA_ID)
);

alter table COMPONENT
   add constraint FK_COMPONEN_RELATIONS_SOLUTION foreign key (SOL_ID)
      references SOLUTION (SOL_ID)
      on delete restrict on update restrict;

alter table RESPONSIBLE
   add constraint FK_RESPONSI_RELATIONS_PROVIDER foreign key (PRV_ID)
      references PROVIDER (PRV_ID)
      on delete restrict on update restrict;

alter table SOLUTION
   add constraint FK_SOLUTION_RELATIONS_CLIENT foreign key (CLI_ID)
      references CLIENT (CLI_ID)
      on delete restrict on update restrict;

alter table TICKET
   add constraint FK_TICKET_RELATIONS_SOLUTION foreign key (SOL_ID)
      references SOLUTION (SOL_ID)
      on delete restrict on update restrict;

alter table TICKET_DETAIL
   add constraint FK_TICKET_D_RELATIONS_RESPONSI foreign key (RPS_ID)
      references RESPONSIBLE (RPS_ID)
      on delete restrict on update restrict;

alter table TICKET_DETAIL
   add constraint FK_TICKET_D_RELATIONS_TICKET foreign key (TCK_ID)
      references TICKET (TCK_ID)
      on delete restrict on update restrict;

alter table TICKET_DETAIL
   add constraint FK_TICKET_D_RELATIONS_COMPONEN foreign key (CMP_ID)
      references COMPONENT (CMP_ID)
      on delete restrict on update restrict;

alter table TICKET_PROD
   add constraint FK_TICKET_P_RELATIONS_TICKET_D foreign key (DTK_ID)
      references TICKET_DETAIL (DTK_ID)
      on delete restrict on update restrict;

alter table TICKET_QA
   add constraint FK_TICKET_Q_RELATIONS_TICKET_D foreign key (DTK_ID)
      references TICKET_DETAIL (DTK_ID)
      on delete restrict on update restrict;

