/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     11/7/2019 7:57:14 PM                         */
/*==============================================================*/
-- dependeindo de como instalamos postgres podemos usar:

CREATE DATABASE "tracingdb"  WITH OWNER = postgres  
		ENCODING = 'UTF8'
		TABLESPACE = pg_default
		LC_COLLATE = 'Spanish_Spain.1252'
		LC_CTYPE = 'Spanish_Spain.1252'
		CONNECTION LIMIT = -1;

-- o esto --->

CREATE DATABASE "tracingdb"  WITH OWNER = postgres  
		ENCODING = 'UTF8'
		TABLESPACE = pg_default
		LC_COLLATE = 'English_United States.1252'
		LC_CTYPE = 'English_United States.1252'
		CONNECTION LIMIT = -1;


drop table CLIENT;

drop table COMPONENT;

drop table DETAIL_PROD;

drop table DETAIL_QA;

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
/* Table: DETAIL_PROD                                           */
/*==============================================================*/
create table DETAIL_PROD (
   DPROD_ID             SERIAL               not null,
   DTK_ID               INT4                 null,
   TPD_ID               INT4                 null,
   constraint PK_DETAIL_PROD primary key (DPROD_ID)
);

/*==============================================================*/
/* Table: DETAIL_QA                                             */
/*==============================================================*/
create table DETAIL_QA (
   DQA_ID               SERIAL               not null,
   DTK_ID               INT4                 null,
   TQA_ID               INT4                 null,
   constraint PK_DETAIL_QA primary key (DQA_ID)
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
   TCK_ESTIMATED        DECIMAL(5,2)         null,
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
   DTK_ESTIMATED        DECIMAL(5,2)         null,
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
   constraint PK_TICKET_QA primary key (TQA_ID)
);

alter table COMPONENT
   add constraint FK_COMPONEN_RELATIONS_SOLUTION foreign key (SOL_ID)
      references SOLUTION (SOL_ID)
      on delete restrict on update restrict;

alter table DETAIL_PROD
   add constraint FK_DETAIL_P_RELATIONS_TICKET_D foreign key (DTK_ID)
      references TICKET_DETAIL (DTK_ID)
      on delete restrict on update restrict;

alter table DETAIL_PROD
   add constraint FK_DETAIL_P_RELATIONS_TICKET_P foreign key (TPD_ID)
      references TICKET_PROD (TPD_ID)
      on delete restrict on update restrict;

alter table DETAIL_QA
   add constraint FK_DETAIL_Q_RELATIONS_TICKET_D foreign key (DTK_ID)
      references TICKET_DETAIL (DTK_ID)
      on delete restrict on update restrict;

alter table DETAIL_QA
   add constraint FK_DETAIL_Q_RELATIONS_TICKET_Q foreign key (TQA_ID)
      references TICKET_QA (TQA_ID)
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


/* INSERTS */
INSERT INTO provider(prv_id,prv_name) VALUES (1,'Todo1');
INSERT INTO provider(prv_id,prv_name) VALUES (2,'Oncedev');
INSERT INTO provider(prv_id,prv_name) VALUES (3,'softcaribean');
INSERT INTO provider(prv_id,prv_name) VALUES (4,'Nexos');
INSERT INTO provider(prv_id,prv_name) VALUES (5,'Clovin');

INSERT INTO responsible (rps_id,rps_name,rps_last_name,prv_id) VALUES (1,'Valeria','Baca',1);
INSERT INTO responsible (rps_id,rps_name,rps_last_name,prv_id) VALUES (2,'Sebastian','Caceres',1);

INSERT INTO client (cli_id,cli_name) VALUES (1,'Bancolombia');
INSERT INTO client (cli_id,cli_name) VALUES (2,'Davivienda');
INSERT INTO client (cli_id,cli_name) VALUES (3,'Colte');
INSERT INTO client (cli_id,cli_name) VALUES (4,'Banistmo');

INSERT INTO solution (sol_id,sol_name,cli_id) VALUES (1,'APP-BC',1);
INSERT INTO solution (sol_id,sol_name,cli_id) VALUES (2,'SVP-BC',1);
INSERT INTO solution (sol_id,sol_name,cli_id) VALUES (3,'PSE-BC',1);
INSERT INTO solution (sol_id,sol_name,cli_id) VALUES (4,'SUFI-BC',1);
INSERT INTO solution (sol_id,sol_name,cli_id) VALUES (5,'FILIALES-BC',1);
INSERT INTO solution (sol_id,sol_name,cli_id) VALUES (6,'APP_BDV_COL',2);
INSERT INTO solution (sol_id,sol_name,cli_id) VALUES (7,'APP_BDV_REG',2);
INSERT INTO solution (sol_id,sol_name,cli_id) VALUES (8,'PER_BDV',2);
INSERT INTO solution (sol_id,sol_name,cli_id) VALUES (9,'SVP_COLTE',3);
INSERT INTO solution (sol_id,sol_name,cli_id) VALUES (10,'SVE_COLTE',3);
INSERT INTO solution (sol_id,sol_name,cli_id) VALUES (11,'SVP_BSMO',4);
INSERT INTO solution (sol_id,sol_name,cli_id) VALUES (12,'SVE_BSMO',4);
INSERT INTO solution (sol_id,sol_name,cli_id) VALUES (13,'APP_BSMO',4);

INSERT INTO component (cmp_id,cmp_name,sol_id) VALUES ( 1,'servicios',1);
INSERT INTO component (cmp_id,cmp_name,sol_id) VALUES ( 2,'Android',1);
INSERT INTO component (cmp_id,cmp_name,sol_id) VALUES ( 3,'iOS',1);
INSERT INTO component (cmp_id,cmp_name,sol_id) VALUES ( 4,'QR',1);

INSERT INTO ticket (tck_id,tck_code,tck_url,tck_type,tck_status,tck_flow,tck_estimated,tck_date_ini,tck_date_end,tck_date_end_plan,sol_id) VALUES (1,'DEVBDV-789','https://prueba',1,1,1,4,'2019-11-05','2019-11-05','2019-11-05',1);

INSERT INTO ticket_detail (dtk_id,dtk_status,dtk_estimated,dtk_date_ini,dtk_date_end,dtk_date_end_plan,rps_id,tck_id,cmp_id) VALUES (1,1,4,'2019-11-05','2019-11-05','2019-11-05',1,1,1);
INSERT INTO ticket_detail (dtk_id,dtk_status,dtk_estimated,dtk_date_ini,dtk_date_end,dtk_date_end_plan,rps_id,tck_id,cmp_id) VALUES (2,1,2,'2019-11-05','2019-11-05','2019-11-05',2,1,2);

SELECT setval('provider_prv_id_seq', 5);
SELECT setval('responsible_rps_id_seq', 2);
SELECT setval('client_cli_id_seq', 4);
SELECT setval('solution_sol_id_seq', 13);
SELECT setval('component_cmp_id_seq', 4);
SELECT setval('ticket_tck_id_seq', 1);
SELECT setval('ticket_detail_dtk_id_seq', 2);

