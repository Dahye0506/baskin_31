desc products;
ALTER TABLE products ADD CTGR VARCHAR(300);

desc products;
desc cart;

desc payment;
select* from member;

select* from employees;
desc employees;

desc purchase;
select* from purchase;

desc purchase_list;
select* from purchase_list;



create SEQUENCE prod_seq
start with 100000;

--���ι�ȣ
select * from payment;
desc payment;
--����
select to_char(sysdate,'yyyymmdd') ||
    ( nvl ( max ( substr ( PAYMENT_APPR_NUM ), -6 ) ,100000 )  + 1 )
from payment
where substr ( PAYMENT_APPR_NUM, 1, 8) = to_char(sysdate, 'yyyymmdd');

--����
select to_char(sysdate,'yyyymmdd') | |
    nvl2 ( max ( PAYMENT_APPR_NUM ), substr(MAX(PAYMENT_APPR_NUM ),-6) ,100000 )  + 1 
from payment
where substr ( PAYMENT_APPR_NUM, 1, 8) = to_char(sysdate, 'yyyymmdd');


-- Ű �� Ȯ��
SELECT 
	CONSTRAINT_NAME
    ,CONSTRAINT_TYPE
    , TABLE_NAME
    ,R_CONSTRAINT_NAME  
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'CART';
select * from cart;
ALTER TABLE CART DROP CONSTRAINT MEM_ID; --����
ALTER TABLE CART CONSTRAINT CART_MEM_ID_FK PRIMARY KEY (�÷���) ENABLE;-- ����

--���(������)
desc member;
select mem_id, mem_pw,mem_address,mem_name,mem_phone,mem_birth,
mem_gender,mem_account,mem_email,mem_email_ck from member;
INSERT INTO member
VALUES ('admin',123,456,'master',010,TO_DATE('2021-05-06'),1,456,'naver',1);
select * from member;


--���÷���
select * from employees;

select * from member; 



desc member;
alter table member add postNumber VARCHAR2(8);
alter table member add detail_add VARCHAR2(20);
alter table member rename column postNumber to POST_NUMBER;

--īƮ
select * from cart;

SUBIN.CART_MEM_ID_FK

