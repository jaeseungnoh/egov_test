drop table sample;

create table sample (
	id INT primary key,
	title varchar2(200),
	reg_user varchar2(20),
	content varchar2(2000),
	reg_date date default SYSDATE
);
insert into sample values(1, 'Java Programming', '관리자', 'JAVA 관련 글만 등록하세요.', SYSDATE);

select * from sample;