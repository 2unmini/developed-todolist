user 테이블 생성   
CREATE TABLE user
(
    user_id BIGINT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NULL,
    PRIMARY KEY (user_id)
);

schedule 테이블 생성
CREATE TABLE schedule
(
    schdule_id BIGINT          NOT NULL AUTO_INCREMENT,
    user_id    BIGINT          NOT NULL,
    title      VARCHAR(45)  NOT NULL,
    content    LONGTEXT NULL,
    created_at DATE         NOT NULL,
    updated_at DATE         NULL,
    PRIMARY KEY (schdule_id),
    INDEX `fk_schedule_user_idx` (user_id),
    CONSTRAINT `fk_schedule_user`
        FOREIGN KEY (user_id)
            REFERENCES user (user_id)
);

사용자 정보 생성
INSERT INTO user (user_name, email, password)
    VALUES ("user_name","email","password");

사용자 정보 조회
SELECT *
FROM user
    WHERE user_id="고유번호";

사용자 정보 삭제
DELETE 
FROM user
    WHERE user_id= 고유번호;

일정 정보 생성
INSERT INTO schedule (user_id, title, content)
    VALUES ("user_id","title","content");


전체 일정 조회
SELECT *
FROM schedule
    WHERE schedule_id=고유번호;

상세 일정 조회
SELECT *
FROM schedule
    WHERE schedule_id=고유번호;

선택 일정의 내용 변경 
UPDATE schedule SET title ="입력값",content ="입력값"
WHERE schdule_id=고유번호;

일정 삭제
DELETE 
FROM user
    WHERE schdule_id= 고유번호;

