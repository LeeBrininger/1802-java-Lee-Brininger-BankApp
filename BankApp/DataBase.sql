--------------------------------------------------------
--  File created - Tuesday-March-13-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ACCOUNT
--------------------------------------------------------

  CREATE TABLE "BRININGER"."ACCOUNT" 
   (	"USERNAME" VARCHAR2(100 BYTE), 
	"FIRSTNAME" VARCHAR2(50 BYTE), 
	"LASTNAME" VARCHAR2(50 BYTE), 
	"SSN" NUMBER, 
	"PASSWORD" NUMBER, 
	"EMAIL" VARCHAR2(100 BYTE), 
	"ACCESSLEVEL" NUMBER DEFAULT 1, 
	"ACTIVEKEY" NUMBER DEFAULT 0
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ACCOUNT_WALLET
--------------------------------------------------------

  CREATE TABLE "BRININGER"."ACCOUNT_WALLET" 
   (	"USERNAME" VARCHAR2(100 BYTE), 
	"WALLETNAME" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TRANSACTION
--------------------------------------------------------

  CREATE TABLE "BRININGER"."TRANSACTION" 
   (	"LOG_ID" NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE , 
	"TODAYS_TIME" TIMESTAMP (6), 
	"LOG_STATEMENT" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table WALLET
--------------------------------------------------------

  CREATE TABLE "BRININGER"."WALLET" 
   (	"WALLETNAME" VARCHAR2(20 BYTE), 
	"MONEY_CONTAINED" NUMBER DEFAULT 0, 
	"TYPE" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into BRININGER.ACCOUNT
SET DEFINE OFF;
Insert into BRININGER.ACCOUNT (USERNAME,FIRSTNAME,LASTNAME,SSN,PASSWORD,EMAIL,ACCESSLEVEL,ACTIVEKEY) values ('SimpleMan','Joe','Bob',123456789,-1861299975,'generic@gmail.com',1,0);
Insert into BRININGER.ACCOUNT (USERNAME,FIRSTNAME,LASTNAME,SSN,PASSWORD,EMAIL,ACCESSLEVEL,ACTIVEKEY) values ('Crawdady','Lee','B',888888888,1403788689,'richmondbrininger@gmail.com',1,1);
Insert into BRININGER.ACCOUNT (USERNAME,FIRSTNAME,LASTNAME,SSN,PASSWORD,EMAIL,ACCESSLEVEL,ACTIVEKEY) values ('SSB4','Chris','Wagner',111111111,1403788689,'youknowitsthebestSSB@gmail.com',1,1);
Insert into BRININGER.ACCOUNT (USERNAME,FIRSTNAME,LASTNAME,SSN,PASSWORD,EMAIL,ACCESSLEVEL,ACTIVEKEY) values ('Emp1','John','Cena',0,-1706952071,'dodododo@yahoo.com',2,1);
Insert into BRININGER.ACCOUNT (USERNAME,FIRSTNAME,LASTNAME,SSN,PASSWORD,EMAIL,ACCESSLEVEL,ACTIVEKEY) values ('MrMan','Mr','Man',345678,1403788689,'r',1,1);
Insert into BRININGER.ACCOUNT (USERNAME,FIRSTNAME,LASTNAME,SSN,PASSWORD,EMAIL,ACCESSLEVEL,ACTIVEKEY) values ('Stuff','AJ','Williams',343443434,-792037285,'morestuff@gmail.com',1,1);
Insert into BRININGER.ACCOUNT (USERNAME,FIRSTNAME,LASTNAME,SSN,PASSWORD,EMAIL,ACCESSLEVEL,ACTIVEKEY) values ('Emp2','Cowman','Sad',0,-1097183709,'penguinz0@gmail.com',2,1);
Insert into BRININGER.ACCOUNT (USERNAME,FIRSTNAME,LASTNAME,SSN,PASSWORD,EMAIL,ACCESSLEVEL,ACTIVEKEY) values ('JW','jonny','walker',56565665,-792037285,'uyu',1,1);
Insert into BRININGER.ACCOUNT (USERNAME,FIRSTNAME,LASTNAME,SSN,PASSWORD,EMAIL,ACCESSLEVEL,ACTIVEKEY) values ('purchase','YOU','HERE',555555555,1003425250,'buynowyourname@gmail.com',1,0);
Insert into BRININGER.ACCOUNT (USERNAME,FIRSTNAME,LASTNAME,SSN,PASSWORD,EMAIL,ACCESSLEVEL,ACTIVEKEY) values ('NK','Nick','Nick',999999999,-1861299975,'nick@gmail.com',1,1);
Insert into BRININGER.ACCOUNT (USERNAME,FIRSTNAME,LASTNAME,SSN,PASSWORD,EMAIL,ACCESSLEVEL,ACTIVEKEY) values ('Admin','Richmond','Brininger',0,-604889065,'importantstuff@gmail.com',3,1);
Insert into BRININGER.ACCOUNT (USERNAME,FIRSTNAME,LASTNAME,SSN,PASSWORD,EMAIL,ACCESSLEVEL,ACTIVEKEY) values ('YOURNAME','Good','Opportunity',9001,811043868,'buytodayitsgreat@gmail.com',1,1);
REM INSERTING into BRININGER.ACCOUNT_WALLET
SET DEFINE OFF;
Insert into BRININGER.ACCOUNT_WALLET (USERNAME,WALLETNAME) values ('Crawdady','LeeAccount');
Insert into BRININGER.ACCOUNT_WALLET (USERNAME,WALLETNAME) values ('NK','two');
Insert into BRININGER.ACCOUNT_WALLET (USERNAME,WALLETNAME) values ('SSB4','SSB');
Insert into BRININGER.ACCOUNT_WALLET (USERNAME,WALLETNAME) values ('Stuff','LeeAccount');
Insert into BRININGER.ACCOUNT_WALLET (USERNAME,WALLETNAME) values ('Stuff','two');
Insert into BRININGER.ACCOUNT_WALLET (USERNAME,WALLETNAME) values ('YOURNAME','Pay');
Insert into BRININGER.ACCOUNT_WALLET (USERNAME,WALLETNAME) values ('purchase','Pay');
Insert into BRININGER.ACCOUNT_WALLET (USERNAME,WALLETNAME) values ('SimpleMan','SimpleWallet');
Insert into BRININGER.ACCOUNT_WALLET (USERNAME,WALLETNAME) values ('MrMan','two');
REM INSERTING into BRININGER.TRANSACTION
SET DEFINE OFF;
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (7,to_timestamp('13-MAR-18 02.40.49.263269000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Account JW activated');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (17,to_timestamp('13-MAR-18 09.04.54.993762000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Account test deleted');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (26,to_timestamp('13-MAR-18 09.18.45.340545000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (29,to_timestamp('13-MAR-18 09.23.52.580128000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (36,to_timestamp('13-MAR-18 09.28.58.253209000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Account purchase now owns Pay');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (38,to_timestamp('13-MAR-18 09.47.00.407917000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Wallet YOURNAME deleted');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (43,to_timestamp('13-MAR-18 10.23.27.318453000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Account MrMan now owns two');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (48,to_timestamp('13-MAR-18 10.28.33.959578000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (49,to_timestamp('13-MAR-18 10.31.31.156892000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (53,to_timestamp('13-MAR-18 10.41.59.946016000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (54,to_timestamp('13-MAR-18 10.47.02.222563000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (55,to_timestamp('13-MAR-18 10.55.36.615399000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (58,to_timestamp('13-MAR-18 11.13.37.976330000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (59,to_timestamp('13-MAR-18 11.19.18.934134000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Account YOURNAME activated');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (4,to_timestamp('13-MAR-18 02.39.55.244173000 AM','DD-MON-RR HH.MI.SSXFF AM'),'DataBase Altered');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (8,to_timestamp('13-MAR-18 02.47.07.714213000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (11,to_timestamp('13-MAR-18 02.48.46.787831000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Wallet ok deleted');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (20,to_timestamp('13-MAR-18 09.08.21.241531000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Wallet SimpleMan deleted');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (21,to_timestamp('13-MAR-18 09.08.42.332605000 AM','DD-MON-RR HH.MI.SSXFF AM'),'DataBase Altered');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (25,to_timestamp('13-MAR-18 09.15.17.146031000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Account test2 deleted');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (30,to_timestamp('13-MAR-18 09.24.15.381084000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (34,to_timestamp('13-MAR-18 09.28.57.931115000 AM','DD-MON-RR HH.MI.SSXFF AM'),'DataBase Altered');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (44,to_timestamp('13-MAR-18 10.24.22.528149000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Account MrMan activated');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (47,to_timestamp('13-MAR-18 10.27.23.994180000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (52,to_timestamp('13-MAR-18 10.40.33.995883000 AM','DD-MON-RR HH.MI.SSXFF AM'),'twofunds set to 662.0');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (5,to_timestamp('13-MAR-18 02.39.55.454526000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Wallet test created');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (9,to_timestamp('13-MAR-18 02.47.15.661300000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (10,to_timestamp('13-MAR-18 02.47.43.486595000 AM','DD-MON-RR HH.MI.SSXFF AM'),'twofunds set to 342.0');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (12,to_timestamp('13-MAR-18 02.49.16.833232000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (14,to_timestamp('13-MAR-18 09.03.51.797436000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Wallet testacc deleted');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (16,to_timestamp('13-MAR-18 09.04.43.795185000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Account y deleted');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (19,to_timestamp('13-MAR-18 09.05.29.550643000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Account p deleted');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (22,to_timestamp('13-MAR-18 09.08.42.831785000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Wallet SimpleWallet created');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (31,to_timestamp('13-MAR-18 09.24.24.051026000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (35,to_timestamp('13-MAR-18 09.28.58.041579000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Wallet Pay created');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (42,to_timestamp('13-MAR-18 10.23.21.986702000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Wallet MrMan deleted');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (46,to_timestamp('13-MAR-18 10.26.22.787518000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (51,to_timestamp('13-MAR-18 10.40.17.681034000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (1,to_timestamp('13-MAR-18 02.38.12.318697000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (2,to_timestamp('13-MAR-18 02.38.44.392241000 AM','DD-MON-RR HH.MI.SSXFF AM'),'twofunds set to 421.0');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (3,to_timestamp('13-MAR-18 02.39.31.791076000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Wallet JW deleted');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (13,to_timestamp('13-MAR-18 09.03.06.239616000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (18,to_timestamp('13-MAR-18 09.05.08.557983000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Account ok deleted');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (24,to_timestamp('13-MAR-18 09.13.44.298974000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (27,to_timestamp('13-MAR-18 09.20.41.216056000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (32,to_timestamp('13-MAR-18 09.26.09.276984000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (33,to_timestamp('13-MAR-18 09.28.34.985895000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Wallet purchase deleted');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (37,to_timestamp('13-MAR-18 09.40.20.947361000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (39,to_timestamp('13-MAR-18 09.47.09.004911000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Account YOURNAME now owns Pay');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (40,to_timestamp('13-MAR-18 09.56.57.793461000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (41,to_timestamp('13-MAR-18 10.11.11.372942000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (56,to_timestamp('13-MAR-18 11.05.46.872639000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (6,to_timestamp('13-MAR-18 02.39.56.320477000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Account JW now owns test');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (15,to_timestamp('13-MAR-18 09.04.37.755954000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Wallet test deleted');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (23,to_timestamp('13-MAR-18 09.08.43.296846000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Account SimpleMan now owns SimpleWallet');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (28,to_timestamp('13-MAR-18 09.21.01.842306000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (45,to_timestamp('13-MAR-18 10.25.00.517186000 AM','DD-MON-RR HH.MI.SSXFF AM'),'twofunds set to 312.0');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (50,to_timestamp('13-MAR-18 10.32.16.224702000 AM','DD-MON-RR HH.MI.SSXFF AM'),'twofunds set to 262.0');
Insert into BRININGER.TRANSACTION (LOG_ID,TODAYS_TIME,LOG_STATEMENT) values (57,to_timestamp('13-MAR-18 11.13.11.351035000 AM','DD-MON-RR HH.MI.SSXFF AM'),'System opened');
REM INSERTING into BRININGER.WALLET
SET DEFINE OFF;
Insert into BRININGER.WALLET (WALLETNAME,MONEY_CONTAINED,TYPE) values ('Pay',1234,'checking');
Insert into BRININGER.WALLET (WALLETNAME,MONEY_CONTAINED,TYPE) values ('SimpleWallet',450,'savings');
Insert into BRININGER.WALLET (WALLETNAME,MONEY_CONTAINED,TYPE) values ('two',662,'Savings');
Insert into BRININGER.WALLET (WALLETNAME,MONEY_CONTAINED,TYPE) values ('LeeAccount',4547,'Checking');
Insert into BRININGER.WALLET (WALLETNAME,MONEY_CONTAINED,TYPE) values ('SSB',10000,'Savings');
--------------------------------------------------------
--  DDL for Procedure GET_ACCOUNTS_WALLETS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "BRININGER"."GET_ACCOUNTS_WALLETS" 
(   ACCOUNTNAME IN VARCHAR2,
    WALLET_LIST OUT SYS_REFCURSOR
) IS
    BEGIN
    OPEN WALLET_LIST FOR SELECT W1.WALLETNAME FROM WALLET W1 JOIN ACCOUNT_WALLET AW1 ON
    W1.WALLETNAME LIKE AW1.WALLETNAME JOIN ACCOUNT A1 ON A1.USERNAME LIKE 
    AW1.USERNAME WHERE A1.USERNAME LIKE 'Stuff';
END;

/
--------------------------------------------------------
--  DDL for Procedure THIS_TEST
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "BRININGER"."THIS_TEST" (NAMES_CURSOR OUT SYS_REFCURSOR) AS
    BEGIN
        OPEN NAMES_CURSOR FOR SELECT * FROM EMPLOYEE;
    END THIS_TEST;

/
--------------------------------------------------------
--  Constraints for Table ACCOUNT_WALLET
--------------------------------------------------------

  ALTER TABLE "BRININGER"."ACCOUNT_WALLET" MODIFY ("WALLETNAME" NOT NULL ENABLE);
  ALTER TABLE "BRININGER"."ACCOUNT_WALLET" MODIFY ("USERNAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TRANSACTION
--------------------------------------------------------

  ALTER TABLE "BRININGER"."TRANSACTION" MODIFY ("LOG_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WALLET
--------------------------------------------------------

  ALTER TABLE "BRININGER"."WALLET" ADD UNIQUE ("WALLETNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ACCOUNT
--------------------------------------------------------

  ALTER TABLE "BRININGER"."ACCOUNT" ADD UNIQUE ("USERNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ACCOUNT_WALLET
--------------------------------------------------------

  ALTER TABLE "BRININGER"."ACCOUNT_WALLET" ADD CONSTRAINT "USERNAME_KEY" FOREIGN KEY ("USERNAME")
	  REFERENCES "BRININGER"."ACCOUNT" ("USERNAME") ON DELETE CASCADE ENABLE;
  ALTER TABLE "BRININGER"."ACCOUNT_WALLET" ADD CONSTRAINT "WALLET_KEY" FOREIGN KEY ("WALLETNAME")
	  REFERENCES "BRININGER"."WALLET" ("WALLETNAME") ON DELETE CASCADE ENABLE;
