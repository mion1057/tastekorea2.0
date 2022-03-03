-- ====================================
--         [Region]
-- ====================================   
DROP TABLE Region;

CREATE TABLE Region (
   id           BIGINT         PRIMARY KEY      AUTO_INCREMENT,
   
   kor          VARCHAR(50)    NOT NULL,
   eng          VARCHAR(50)    NOT NULL,
   guide        BOOLEAN        NOT NULL      DEFAULT FALSE,
   
   regDate      TIMESTAMP      NOT NULL      DEFAULT CURRENT_TIMESTAMP,
   updateDate   TIMESTAMP      NOT NULL      DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)AUTO_INCREMENT = 10000001;

SELECT * FROM Region;



-- insert region data --
INSERT INTO Region(kor, eng, guide) VALUES('서울', 'Seoul', true);
INSERT INTO Region(kor, eng, guide) VALUES('부산', 'Busan', true);
INSERT INTO Region(kor, eng, guide) VALUES('대구', 'Daegu', true);
INSERT INTO Region(kor, eng, guide) VALUES('광주', 'Gwangju', true);
INSERT INTO Region(kor, eng, guide) VALUES('제주', 'Jeju', true);
INSERT INTO Region(kor, eng, guide) VALUES('인천', 'Incheon', true);
INSERT INTO Region(kor, eng, guide) VALUES('춘천', 'Chuncheon', true);
INSERT INTO Region(kor, eng, guide) VALUES('울릉도', 'Ulleungdo', true);
INSERT INTO Region(kor, eng, guide) VALUES('평양', 'Pyongyang', true);


INSERT INTO Region(kor, eng, guide) VALUES('중국', 'China', false);
INSERT INTO Region(kor, eng, guide) VALUES('일본', 'Japan', false);
INSERT INTO Region(kor, eng, guide) VALUES('대만', 'Taiwan', false);
INSERT INTO Region(kor, eng, guide) VALUES('미국', 'USA', false);
INSERT INTO Region(kor, eng, guide) VALUES('홍콩', 'HonKong', false);
INSERT INTO Region(kor, eng, guide) VALUES('태국', 'Thailand', false);
INSERT INTO Region(kor, eng, guide) VALUES('말레이시아', 'Malaysia', false);
INSERT INTO Region(kor, eng, guide) VALUES('베트남', 'Vietnam', false);
INSERT INTO Region(kor, eng, guide) VALUES('필리핀', 'Philippines', false);
INSERT INTO Region(kor, eng, guide) VALUES('러시아,', 'Russia,', false);
INSERT INTO Region(kor, eng, guide) VALUES('인도네시아', 'Indonesia', false);
INSERT INTO Region(kor, eng, guide) VALUES('싱가포르', 'Singapore', false);
INSERT INTO Region(kor, eng, guide) VALUES('캐나다', 'Canada', false);
INSERT INTO Region(kor, eng, guide) VALUES('호주', 'Austrailia', false);
INSERT INTO Region(kor, eng, guide) VALUES('영국', 'United Kingdom', false);
INSERT INTO Region(kor, eng, guide) VALUES('터키', 'Turkey', false);





-- ====================================
--         [ForeignLanguage]
-- ====================================   
DROP TABLE LanguageSkill;
DROP TABLE ForeignLanguage;

CREATE TABLE ForeignLanguage (
   id           BIGINT         PRIMARY KEY      AUTO_INCREMENT,
   kor          VARCHAR(50)    NOT NULL      DEFAULT '영어',
   eng          VARCHAR(50)    NOT NULL      DEFAULT   'English',   
   
   regDate      TIMESTAMP      NOT NULL      DEFAULT CURRENT_TIMESTAMP,
   updateDate   TIMESTAMP      NOT NULL      DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)AUTO_INCREMENT = 10000001;


INSERT INTO ForeignLanguage(kor, eng) VALUES('영어', 'English');
INSERT INTO ForeignLanguage(kor, eng) VALUES('중국어', 'Chinese');
INSERT INTO ForeignLanguage(kor, eng) VALUES('러시아어', 'Russian');
INSERT INTO ForeignLanguage(kor, eng) VALUES('일본어', 'Japanese');
INSERT INTO ForeignLanguage(kor, eng) VALUES('스페인어', 'Spanish');
INSERT INTO ForeignLanguage(kor, eng) VALUES('프랑스어', 'French');
INSERT INTO ForeignLanguage(kor, eng) VALUES('아랍어', 'Arabic');
INSERT INTO ForeignLanguage(kor, eng) VALUES('포르투갈어', 'Portuguese');
INSERT INTO ForeignLanguage(kor, eng) VALUES('독일어', 'Deutsch');
INSERT INTO ForeignLanguage(kor, eng) VALUES('이탈리아어', 'Italian');
INSERT INTO ForeignLanguage(kor, eng) VALUES('한국어', 'Korean');


SELECT * FROM ForeignLanguage;


-- ====================================
--         [TasteMember]
-- ====================================   
DROP TABLE LanguageSkill;
DROP TABLE TasteMember ;
drop table appreply ;
drop table pin ;

CREATE TABLE TasteMember(
   id            BIGINT         PRIMARY KEY AUTO_INCREMENT,
   regionId      BIGINT          NOT NULL,
   
   email          VARCHAR(30)    NOT NULL,
   passwd          VARCHAR(20)    NOT NULL, 
   guide          BOOLEAN       NOT NULL   DEFAULT FALSE,
   firstName      VARCHAR(30)      NOT NULL,
   lastName      VARCHAR(30)      NOT NULL,
   phone         VARCHAR(20),
   ssn            VARCHAR(6),
   sex            CHAR(1)         NOT NULL,
   alias         VARCHAR(20),
   profileImage   VARCHAR(120),
   introduction    VARCHAR(100),
   
   regDate       TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP,
   updateDate      TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   
   CONSTRAINT       TasteMember_regionId_FK FOREIGN KEY(regionId) REFERENCES Region(id)
)AUTO_INCREMENT = 15000001;

ALTER TABLE TasteMember MODIFY COLUMN sex CHAR(1) DEFAULT 'x' NOT NULL;
ALTER TABLE TasteMember MODIFY COLUMN sex CHAR(1);
alter table tastemember modify column ssn varchar(8);
ALTER TABLE TasteMember ADD region VARCHAR(20) NOT NULL DEFAULT '서울';

SELECT * FROM TasteMember c ;

insert into tastemember (regionId, email, passwd, guide, firstName, lastName, phone, ssn, 
sex, alias, profileImage, introduction) values (10000001, "spring@java.com", "123123", true, "spring", 
"java", "010-1111-2222", "911111", "m", "john", "abcd", "hi");

truncate table TasteMember ;
truncate table languageskill ;

select * from languageskill l ;





-- ====================================
--         [LanguageSkill]
-- ====================================   
DROP TABLE LanguageSkill;

CREATE TABLE LanguageSkill(
   id              BIGINT         PRIMARY KEY AUTO_INCREMENT,
   memberId        BIGINT         NOT NULL,
   languageId      BIGINT         NOT NULL,
   
   skillLevel      DOUBLE         NOT NULL,
   
   regDate         TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP,
   updateDate      TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   
   CONSTRAINT LanguageSkill_memberId_FK FOREIGN KEY(memberId) REFERENCES TasteMember(id),
   CONSTRAINT LanguageSkill_languageId_FK FOREIGN KEY(languageId) REFERENCES ForeignLanguage(id)
)AUTO_INCREMENT = 2000001;




-- ====================================
--         [PinCategory]
-- ====================================
CREATE TABLE PinCategory(
   id      BIGINT      PRIMARY KEY AUTO_INCREMENT,
   
   kor      VARCHAR(30)   NOT NULL,
   eng      VARCHAR(30)   NOT NULL,
   
   regDate       TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP,
   updateDate      TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP

)AUTO_INCREMENT = 1000001;

INSERT INTO PinCategory(kor, eng) VALUES ('관광', 'sightseeing');
INSERT INTO PinCategory(kor, eng) VALUES ('쇼핑', 'shopping');
INSERT INTO PinCategory(kor, eng) VALUES ('음식 & 음료', 'food & drink');
INSERT INTO PinCategory(kor, eng) VALUES ('놀이 & 오락', 'play & arcade');
INSERT INTO PinCategory(kor, eng) VALUES ('의료 & 미용', 'medical & beauty');
INSERT INTO PinCategory(kor, eng) VALUES ('스포츠 & 레저', 'sports & leisure');
INSERT INTO PinCategory(kor, eng) VALUES ('직업 & 교육', 'job & education');

select * from pincategory ;



-- ====================================
--         [PinMapData]
-- ====================================
create table PinMapData(
	id              BIGINT      	PRIMARY KEY AUTO_INCREMENT,
	pinId			BIGINT			not null,
	coordinate		VARCHAR(100)		not null,
	   
	regDate			TIMESTAMP       NOT NULL   DEFAULT CURRENT_TIMESTAMP,
	updateDate		TIMESTAMP       NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	
	CONSTRAINT PinMapData_pinId_FK FOREIGN KEY(pinId) REFERENCES pin(id),
)AUTO_INCREMENT = 10000001;




-- ====================================
--         [Pin]
-- ====================================
CREATE TABLE Pin(
	id				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	memberId		BIGINT 			NOT NULL,
	regionId		BIGINT			NOT NULL,
	categoryId		BIGINT			NOT NULL,
	
	imagePath		VARCHAR(120)	NOT NULL,
	title			VARCHAR(150)	NOT NULL,
	description		VARCHAR(5000)	NOT NULL,
	mapData			VARCHAR(100)	NOT NULL,
	likeCount		BIGINT			NOT null	 default 0,
	dislikeCount	BIGINT			NOT null 	 default 0,
	
	regDate         TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP,
  	updateDate      TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT Pin_memberId_FK	FOREIGN KEY(memberId) REFERENCES TasteMember(id),
	CONSTRAINT Pin_regionId_FK	FOREIGN KEY(regionId) REFERENCES Region(id),
	CONSTRAINT Pin_categoryId_FK	FOREIGN KEY(categoryId) REFERENCES PinCategory(id)
)AUTO_INCREMENT = 10000001

alter table pin modify column title varchar(500);
alter table pin modify column description varchar(5000);
truncate table pin;
drop table pin;
select * from pin ;
delete from pin where id = 4;

insert into pin(memberId, regionId, categoryId, imagePath, title, description, mapData, likeCount, dislikeCount) 
(select memberId, regionId, categoryId, imagePath, title, description, mapData, likeCount, dislikeCount from pin);



-- ====================================
--         [AppReply]
-- ====================================
CREATE TABLE AppReply (
   id            BIGINT         PRIMARY KEY AUTO_INCREMENT,
   parentId      BIGINT         NULL,
   memberId      BIGINT         NOT NULL,
   
   appCode         INTEGER         NOT NULL,
   comment         VARCHAR(1000)   NOT NULL,
   recipient      VARCHAR(25),
   
   likeCount      INTEGER         NOT NULL   DEFAULT '0',
   dislikeCount   INTEGER         NOT NULL   DEFAULT '0',
   
   CONSTRAINT AppReply_memberId_FK FOREIGN KEY (memberId) REFERENCES TasteMember(id)
)AUTO_INCREMENT = 7000001;

drop table foreignlanguage ;
drop table languageskill ;
drop table region ;
drop table tastemember ;
drop table traveler ;
drop table Pin;

SELECT p.*, c.eng AS cateEng, c.kor AS cateKor, r.eng As regionEng,
 r.kor AS regionKor, m.alias as memberAlias, m.profileImage as memberProfile
	FROM Pin p INNER JOIN Region r ON p.regionId = r.id
	INNER JOIN PinCategory c ON p.categoryId = c.id
	INNER JOIN TasteMember m ON p.memberId = m.id;
	
select p.regionKor as regionKor from pin p inner join region r on p.regionId = r.id;