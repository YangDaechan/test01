-- 이름 : 양대찬

-- 테이블 작성쿼리
CREATE TABLE TBL_STUDENT(
	STUDENT_ID NUMBER,
	STUDENT_NAME VARCHAR(100),
	STUDENT_AGE NUMBER,
	DEPARTMENT_ID NUMBER,
	ADDRESS_ID NUMBER,
	CONSTRAINT PK_STUDENT PRIMARY KEY(STUDENT_ID),
	CONSTRAINT FK_STUDENT_DEPARTMENT FOREIGN KEY(DEPARTMENT_ID)
	REFERENCES TBL_DEPARTMENT(DEPARTMENT_ID),
	CONSTRAINT FK_STUDENT_ADDRESS FOREIGN KEY(ADDRESS_ID)
	REFERENCES TBL_ADDRESS(ADDRESS_ID)
);

CREATE TABLE TBL_DEPARTMENT(
	DEPARTMENT_ID NUMBER,
	DEPARTMENT_NAME VARCHAR(100),
	CONSTRAINT PK_DEPARTMENT PRIMARY KEY(DEPARTMENT_ID)
);

CREATE TABLE TBL_ADDRESS(
	ADDRESS_ID NUMBER,
	ADDRESS_POSTAL_CODE NUMBER,
	ADDRESS_LINE1 VARCHAR(100),
	ADDRESS_LINE2 VARCHAR(100),
	CONSTRAINT PK_ADDRESS PRIMARY KEY(ADDRESS_ID)
);

CREATE SEQUENCE SEQ_STUDENT;
CREATE SEQUENCE SEQ_DEPARTMENT;
CREATE SEQUENCE SEQ_ADDRESS;

SELECT * FROM ALL_SEQUENCES 
--WHERE SEQUENCE_NAME = 'SEQ_STUDENT';
--WHERE SEQUENCE_NAME = 'SEQ_DEPARTMENT';
WHERE SEQUENCE_NAME = 'SEQ_ADDRESS';

SELECT * FROM TBL_DEPARTMENT td;

INSERT INTO TBL_DEPARTMENT td VALUES 
(SEQ_DEPARTMENT.NEXTVAL, '컴퓨터공학');
INSERT INTO TBL_DEPARTMENT td VALUES 
(SEQ_DEPARTMENT.NEXTVAL, '인공지능학');
INSERT INTO TBL_DEPARTMENT td VALUES 
(SEQ_DEPARTMENT.NEXTVAL, '정보보호학');

SELECT * FROM TBL_ADDRESS ta ;

INSERT INTO TBL_ADDRESS ta VALUES
(SEQ_ADDRESS.NEXTVAL, 12345, '123 서울시 강남구', '아파트 101');
INSERT INTO TBL_ADDRESS ta VALUES
(SEQ_ADDRESS.NEXTVAL, 45678, '456 서울시 동작구', '빌라 202');
INSERT INTO TBL_ADDRESS ta VALUES
(SEQ_ADDRESS.NEXTVAL, 56789, '789 서울시 송파구', '주택 305');

SELECT * FROM TBL_STUDENT ts ;

INSERT INTO TBL_STUDENT ts VALUES
(SEQ_STUDENT.NEXTVAL, '짱구', 22, 1, 1);
INSERT INTO TBL_STUDENT ts VALUES
(SEQ_STUDENT.NEXTVAL, '철수', 21, 2, 2);
INSERT INTO TBL_STUDENT ts VALUES
(SEQ_STUDENT.NEXTVAL, '맹구', 20, 1, 1);
INSERT INTO TBL_STUDENT ts VALUES
(SEQ_STUDENT.NEXTVAL, '유리', 22, 3, 3);

SELECT STUDENT_ID , STUDENT_NAME , department_name, ADDRESS_POSTAL_CODE , ADDRESS_LINE1 ,ADDRESS_LINE2 
FROM TBL_STUDENT ts 
JOIN TBL_DEPARTMENT td 
ON ts.DEPARTMENT_ID = td.DEPARTMENT_ID 
JOIN TBL_ADDRESS ta 
ON ts.ADDRESS_ID = ta.ADDRESS_ID ;

SELECT 
FROM TBL_STUDENT ts 
JOIN TBL_DEPARTMENT td ;























