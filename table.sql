prompt PL/SQL Developer import file
prompt Created on 2011��6��30�� ������ by Administrator
set feedback off
set define off
prompt Creating DEPT...
create table DEPT
(
  DEPTNO    INTEGER not null,
  DEPTNAME  VARCHAR2(20) not null,
  MANAGER   INTEGER not null,
  OFFICETEL VARCHAR2(20) not null,
  DEPTDUTY  VARCHAR2(200) not null
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DEPT
  add primary key (DEPTNO)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating EDU...
create table EDU
(
  DEUNO          INTEGER not null,
  EMPNO          INTEGER not null,
  EDUCATION      VARCHAR2(20) not null,
  SCHOOL         VARCHAR2(50) not null,
  SPECIAL        VARCHAR2(50) not null,
  GRADUATETIME   DATE not null,
  FORIGNLANGUAGE VARCHAR2(20) not null
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table EDU
  add primary key (DEUNO)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating EMP...
create table EMP
(
  EMPNO      INTEGER not null,
  NAME       VARCHAR2(20) not null,
  IDENTITYNO VARCHAR2(20) not null,
  JIGUAN     VARCHAR2(200),
  ZZMM       VARCHAR2(20),
  AGE        INTEGER,
  SEX        VARCHAR2(2) not null,
  ADDRESS    VARCHAR2(200),
  TEL        VARCHAR2(20),
  WORKAGE    INTEGER,
  PHOTO      VARCHAR2(50),
  POSITIONO  INTEGER not null,
  DEPTNO     INTEGER,
  EMPCONDION VARCHAR2(4) not null
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table EMP
  add primary key (EMPNO)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating ENTERPRISEPOSITION...
create table ENTERPRISEPOSITION
(
  POSITIONNO   INTEGER not null,
  POSITIONNAME VARCHAR2(50) not null,
  ATTACHDEPTNO INTEGER,
  POSITIONDUTY VARCHAR2(200)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ENTERPRISEPOSITION
  add primary key (POSITIONNO)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating MARRY...
create table MARRY
(
  MARRYNO    INTEGER not null,
  EMPNO      INTEGER not null,
  ISMARRY    VARCHAR2(4) not null,
  SPOUSENAME VARCHAR2(20),
  SPOUSEJOB  VARCHAR2(20),
  TEL        VARCHAR2(20),
  ZZMM       VARCHAR2(20)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MARRY
  add primary key (MARRYNO)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Disabling triggers for DEPT...
alter table DEPT disable all triggers;
prompt Disabling triggers for EDU...
alter table EDU disable all triggers;
prompt Disabling triggers for EMP...
alter table EMP disable all triggers;
prompt Disabling triggers for ENTERPRISEPOSITION...
alter table ENTERPRISEPOSITION disable all triggers;
prompt Disabling triggers for MARRY...
alter table MARRY disable all triggers;
prompt Deleting MARRY...
delete from MARRY;
commit;
prompt Deleting ENTERPRISEPOSITION...
delete from ENTERPRISEPOSITION;
commit;
prompt Deleting EMP...
delete from EMP;
commit;
prompt Deleting EDU...
delete from EDU;
commit;
prompt Deleting DEPT...
delete from DEPT;
commit;
prompt Loading DEPT...
insert into DEPT (DEPTNO, DEPTNAME, MANAGER, OFFICETEL, DEPTDUTY)
values (1, '���Բ�', 1, '0731-5487517', '����');
insert into DEPT (DEPTNO, DEPTNAME, MANAGER, OFFICETEL, DEPTDUTY)
values (2, '������', 2, '0731-5487518', '����');
insert into DEPT (DEPTNO, DEPTNAME, MANAGER, OFFICETEL, DEPTDUTY)
values (3, '�г���', 3, '0731-5487519', '����');
insert into DEPT (DEPTNO, DEPTNAME, MANAGER, OFFICETEL, DEPTDUTY)
values (4, '�ͷ���', 4, '0731-5487520', '�ͷ�');
commit;
prompt 4 records loaded
prompt Loading EDU...
insert into EDU (DEUNO, EMPNO, EDUCATION, SCHOOL, SPECIAL, GRADUATETIME, FORIGNLANGUAGE)
values (1, 1, '��ʿ', '�廪��ѧ', '�����', to_date('20-06-2007', 'dd-mm-yyyy'), 'Ӣ������');
insert into EDU (DEUNO, EMPNO, EDUCATION, SCHOOL, SPECIAL, GRADUATETIME, FORIGNLANGUAGE)
values (2, 2, '˶ʿ', '������ѧ', '�����', to_date('29-05-2008', 'dd-mm-yyyy'), 'Ӣ������');
insert into EDU (DEUNO, EMPNO, EDUCATION, SCHOOL, SPECIAL, GRADUATETIME, FORIGNLANGUAGE)
values (3, 3, '����', '��ɽ��ѧ', '���', to_date('27-06-2005', 'dd-mm-yyyy'), 'Ӣ������');
insert into EDU (DEUNO, EMPNO, EDUCATION, SCHOOL, SPECIAL, GRADUATETIME, FORIGNLANGUAGE)
values (4, 4, '����', '������ѧ', '���', to_date('24-06-2007', 'dd-mm-yyyy'), 'Ӣ������');
insert into EDU (DEUNO, EMPNO, EDUCATION, SCHOOL, SPECIAL, GRADUATETIME, FORIGNLANGUAGE)
values (5, 5, '˶ʿ', '�人��ѧ', '����', to_date('23-06-2009', 'dd-mm-yyyy'), 'Ӣ������');
insert into EDU (DEUNO, EMPNO, EDUCATION, SCHOOL, SPECIAL, GRADUATETIME, FORIGNLANGUAGE)
values (6, 6, '˶ʿ', '�人��ѧ', '����', to_date('23-06-2009', 'dd-mm-yyyy'), 'Ӣ������');
insert into EDU (DEUNO, EMPNO, EDUCATION, SCHOOL, SPECIAL, GRADUATETIME, FORIGNLANGUAGE)
values (7, 7, '˶ʿ', '�人��ѧ', '����', to_date('23-06-2009', 'dd-mm-yyyy'), 'Ӣ������');
insert into EDU (DEUNO, EMPNO, EDUCATION, SCHOOL, SPECIAL, GRADUATETIME, FORIGNLANGUAGE)
values (8, 8, '˶ʿ', '�人��ѧ', '����', to_date('23-06-2009', 'dd-mm-yyyy'), 'Ӣ������');
insert into EDU (DEUNO, EMPNO, EDUCATION, SCHOOL, SPECIAL, GRADUATETIME, FORIGNLANGUAGE)
values (9, 9, '˶ʿ', '�人��ѧ', '����', to_date('23-06-2009', 'dd-mm-yyyy'), 'Ӣ������');
insert into EDU (DEUNO, EMPNO, EDUCATION, SCHOOL, SPECIAL, GRADUATETIME, FORIGNLANGUAGE)
values (10, 10, '˶ʿ', '�人��ѧ', '����', to_date('23-06-2009', 'dd-mm-yyyy'), 'Ӣ������');
commit;
prompt 10 records loaded
prompt Loading EMP...
insert into EMP (EMPNO, NAME, IDENTITYNO, JIGUAN, ZZMM, AGE, SEX, ADDRESS, TEL, WORKAGE, PHOTO, POSITIONO, DEPTNO, EMPCONDION)
values (2, 'zoro', '430422198506284243', '��', '��Ա', 27, '��', '���ɽ�67��', '15111275726', 4, null, 2, 1, '��ְ');
insert into EMP (EMPNO, NAME, IDENTITYNO, JIGUAN, ZZMM, AGE, SEX, ADDRESS, TEL, WORKAGE, PHOTO, POSITIONO, DEPTNO, EMPCONDION)
values (3, 'namy', '430422198506284243', '��', '��Ա', 26, 'Ů', '���ɽ�67��', '15111275726', 1, null, 3, 2, '��ְ');
insert into EMP (EMPNO, NAME, IDENTITYNO, JIGUAN, ZZMM, AGE, SEX, ADDRESS, TEL, WORKAGE, PHOTO, POSITIONO, DEPTNO, EMPCONDION)
values (4, 'luobin', '430422198506284243', '��', '��Ա', 30, 'Ů', '���ɽ�67��', '15111275726', 6, null, 4, 2, '��ְ');
insert into EMP (EMPNO, NAME, IDENTITYNO, JIGUAN, ZZMM, AGE, SEX, ADDRESS, TEL, WORKAGE, PHOTO, POSITIONO, DEPTNO, EMPCONDION)
values (5, 'sanzi', '430422198506284243', '��', '��Ա', 31, '��', '���ɽ�67��', '15111275726', 3, null, 5, 3, '��ְ');
insert into EMP (EMPNO, NAME, IDENTITYNO, JIGUAN, ZZMM, AGE, SEX, ADDRESS, TEL, WORKAGE, PHOTO, POSITIONO, DEPTNO, EMPCONDION)
values (6, 'jacky', '430422198506284243', '��', '��Ա', 28, '��', '���ɽ�67��', '15111275726', 2, null, 6, 4, '����');
insert into EMP (EMPNO, NAME, IDENTITYNO, JIGUAN, ZZMM, AGE, SEX, ADDRESS, TEL, WORKAGE, PHOTO, POSITIONO, DEPTNO, EMPCONDION)
values (7, 'jacky', '430422198506284243', '��', '��Ա', 28, '��', '���ɽ�67��', '15111275726', 2, null, 6, 3, '��ְ');
insert into EMP (EMPNO, NAME, IDENTITYNO, JIGUAN, ZZMM, AGE, SEX, ADDRESS, TEL, WORKAGE, PHOTO, POSITIONO, DEPTNO, EMPCONDION)
values (8, 'jacky', '430422198506284243', '��', '��Ա', 28, '��', '���ɽ�67��', '15111275726', 2, null, 6, 3, '��ְ');
insert into EMP (EMPNO, NAME, IDENTITYNO, JIGUAN, ZZMM, AGE, SEX, ADDRESS, TEL, WORKAGE, PHOTO, POSITIONO, DEPTNO, EMPCONDION)
values (9, 'jacky', '430422198506284243', '��', '��Ա', 28, '��', '���ɽ�67��', '15111275726', 2, null, 6, 3, '��ְ');
insert into EMP (EMPNO, NAME, IDENTITYNO, JIGUAN, ZZMM, AGE, SEX, ADDRESS, TEL, WORKAGE, PHOTO, POSITIONO, DEPTNO, EMPCONDION)
values (1, 'luffy', '430422198506284243', '��', '��Ա', 25, '��', '���ɽ�67��', '15111275726', 2, null, 1, 1, '��ְ');
commit;
prompt 9 records loaded
prompt Loading ENTERPRISEPOSITION...
insert into ENTERPRISEPOSITION (POSITIONNO, POSITIONNAME, ATTACHDEPTNO, POSITIONDUTY)
values (1, '���ž���', null, '������');
insert into ENTERPRISEPOSITION (POSITIONNO, POSITIONNAME, ATTACHDEPTNO, POSITIONDUTY)
values (2, '�ܹ�ʦ', 2, '�������ܹ�');
insert into ENTERPRISEPOSITION (POSITIONNO, POSITIONNAME, ATTACHDEPTNO, POSITIONDUTY)
values (3, '���繤��ʦ', 2, '��������');
insert into ENTERPRISEPOSITION (POSITIONNO, POSITIONNAME, ATTACHDEPTNO, POSITIONDUTY)
values (4, '���Է���Ա', 1, '������Ŀ');
insert into ENTERPRISEPOSITION (POSITIONNO, POSITIONNAME, ATTACHDEPTNO, POSITIONDUTY)
values (5, '��Ŀ����', 2, '������Ŀ');
insert into ENTERPRISEPOSITION (POSITIONNO, POSITIONNAME, ATTACHDEPTNO, POSITIONDUTY)
values (6, '�������ʦ', 2, '�������');
insert into ENTERPRISEPOSITION (POSITIONNO, POSITIONNAME, ATTACHDEPTNO, POSITIONDUTY)
values (7, '����Ա', 3, '��Ʒ����');
insert into ENTERPRISEPOSITION (POSITIONNO, POSITIONNAME, ATTACHDEPTNO, POSITIONDUTY)
values (8, '�ͷ�Ա', 4, '��ϵ�ͻ����ۺ����');
commit;
prompt 8 records loaded
prompt Loading MARRY...
insert into MARRY (MARRYNO, EMPNO, ISMARRY, SPOUSENAME, SPOUSEJOB, TEL, ZZMM)
values (1, 1, '�ѻ�', 'namy', '���繤��ʦ', '15111275726', '��Ա');
insert into MARRY (MARRYNO, EMPNO, ISMARRY, SPOUSENAME, SPOUSEJOB, TEL, ZZMM)
values (2, 2, '�ѻ�', 'luobin', '���Է���Ա', '15111275726', '��Ա');
insert into MARRY (MARRYNO, EMPNO, ISMARRY, SPOUSENAME, SPOUSEJOB, TEL, ZZMM)
values (3, 3, '�ѻ�', 'luffy', '���ž���', '15111275726', '��Ա');
insert into MARRY (MARRYNO, EMPNO, ISMARRY, SPOUSENAME, SPOUSEJOB, TEL, ZZMM)
values (4, 4, '�ѻ�', 'zoro', '�ܹ�ʦ', '15111275726', '��Ա');
insert into MARRY (MARRYNO, EMPNO, ISMARRY, SPOUSENAME, SPOUSEJOB, TEL, ZZMM)
values (5, 5, 'δ��', null, null, null, null);
insert into MARRY (MARRYNO, EMPNO, ISMARRY, SPOUSENAME, SPOUSEJOB, TEL, ZZMM)
values (6, 6, 'δ��', null, null, null, null);
insert into MARRY (MARRYNO, EMPNO, ISMARRY, SPOUSENAME, SPOUSEJOB, TEL, ZZMM)
values (7, 7, 'δ��', null, null, null, null);
insert into MARRY (MARRYNO, EMPNO, ISMARRY, SPOUSENAME, SPOUSEJOB, TEL, ZZMM)
values (8, 8, 'δ��', null, null, null, null);
insert into MARRY (MARRYNO, EMPNO, ISMARRY, SPOUSENAME, SPOUSEJOB, TEL, ZZMM)
values (9, 9, 'δ��', null, null, null, null);
insert into MARRY (MARRYNO, EMPNO, ISMARRY, SPOUSENAME, SPOUSEJOB, TEL, ZZMM)
values (10, 10, 'δ��', null, null, null, null);
commit;
prompt 10 records loaded
prompt Enabling triggers for DEPT...
alter table DEPT enable all triggers;
prompt Enabling triggers for EDU...
alter table EDU enable all triggers;
prompt Enabling triggers for EMP...
alter table EMP enable all triggers;
prompt Enabling triggers for ENTERPRISEPOSITION...
alter table ENTERPRISEPOSITION enable all triggers;
prompt Enabling triggers for MARRY...
alter table MARRY enable all triggers;
set feedback on
set define on
prompt Done.
