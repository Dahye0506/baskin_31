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

--승인번호
select * from payment;
desc payment;
--원본
select to_char(sysdate,'yyyymmdd') ||
    ( nvl ( max ( substr ( PAYMENT_APPR_NUM ), -6 ) ,100000 )  + 1 )
from payment
where substr ( PAYMENT_APPR_NUM, 1, 8) = to_char(sysdate, 'yyyymmdd');

--수정
select to_char(sysdate,'yyyymmdd') | |
    nvl2 ( max ( PAYMENT_APPR_NUM ), substr(MAX(PAYMENT_APPR_NUM ),-6) ,100000 )  + 1 
from payment
where substr ( PAYMENT_APPR_NUM, 1, 8) = to_char(sysdate, 'yyyymmdd');


-- 키 값 확인
SELECT 
	CONSTRAINT_NAME
    ,CONSTRAINT_TYPE
    , TABLE_NAME
    ,R_CONSTRAINT_NAME  
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'CART';
select * from cart;
ALTER TABLE CART DROP CONSTRAINT MEM_ID; --삭제
ALTER TABLE CART CONSTRAINT CART_MEM_ID_FK PRIMARY KEY (컬럼명) ENABLE;-- 생성

--멤버(관리자)
desc member;
select mem_id, mem_pw,mem_address,mem_name,mem_phone,mem_birth,
mem_gender,mem_account,mem_email,mem_email_ck from member;
INSERT INTO member
VALUES ('admin',123,456,'master',010,TO_DATE('2021-05-06'),1,456,'naver',1);
select * from member;


--임플로이
select * from employees;

select * from member; 



desc member;
alter table member add postNumber VARCHAR2(8);
alter table member add detail_add VARCHAR2(20);
alter table member rename column postNumber to POST_NUMBER;

--카트
select * from cart;

SUBIN.CART_MEM_ID_FK

