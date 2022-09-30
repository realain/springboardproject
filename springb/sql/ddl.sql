-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema springboard
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema springboard
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springboard` DEFAULT CHARACTER SET utf8 ;
USE `springboard` ;

-- -----------------------------------------------------
-- Table `springboard`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springboard`.`user` ;

CREATE TABLE IF NOT EXISTS `springboard`.`user` (
    `userNum` BIGINT(100) NOT NULL AUTO_INCREMENT,
    `userId` VARCHAR(45) NOT NULL,
    `userPw` VARCHAR(45) NOT NULL,
    `userName` VARCHAR(45) NOT NULL,
    `userPhone` VARCHAR(45) NOT NULL,
    `userInsertDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `userGrade` INT NOT NULL,
    UNIQUE INDEX `userid_UNIQUE` (`userId` ASC) VISIBLE,
    UNIQUE INDEX `usernumber_UNIQUE` (`userNum` ASC) VISIBLE,
    PRIMARY KEY (`userNum`))
    ENGINE = InnoDB
    COMMENT = '			';


-- -----------------------------------------------------
-- Table `springboard`.`board`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springboard`.`board` ;

CREATE TABLE IF NOT EXISTS `springboard`.`board` (
    `userNum` BIGINT(100) NOT NULL,
    `boardTitle` VARCHAR(45) NOT NULL,
    `boardNum` INT NOT NULL AUTO_INCREMENT,
    `boardContent` TEXT NOT NULL,
    `boardInsertDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`boardNum`),
    UNIQUE INDEX `boardnum_UNIQUE` (`boardNum` ASC) VISIBLE,
    CONSTRAINT `board_uesrNum_user_userNum_fk`
    FOREIGN KEY (`userNum`)
    REFERENCES `springboard`.`user` (`userNum`)
                                                                   ON DELETE NO ACTION
                                                                   ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springboard`.`cmt`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springboard`.`cmt` ;

CREATE TABLE IF NOT EXISTS `springboard`.`cmt` (
                                                   `cmtNum` INT NOT NULL AUTO_INCREMENT,
                                                   `userNum` BIGINT(100) NOT NULL,
    `cmtContent` VARCHAR(8000) NOT NULL,
    `boardNum` INT NOT NULL,
    `cmtInsertDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `cmtParent` INT NULL DEFAULT NULL,
    `cmtFloor` INT NOT NULL DEFAULT 0,
    `cmtOrder` INT NOT NULL DEFAULT 0,
    `cmtGroup` INT NOT NULL DEFAULT 0,
    PRIMARY KEY (`cmtNum`),
    UNIQUE INDEX `bcommentnum_UNIQUE` (`cmtNum` ASC) VISIBLE,
    INDEX `bcomment_boardnum_board_boardnum_fk_idx` (`boardNum` ASC) VISIBLE,
    UNIQUE INDEX `bcommentorder_UNIQUE` (`cmtOrder` ASC) VISIBLE,
    CONSTRAINT `cmt_uesrNum_user_userNum_fk`
    FOREIGN KEY (`userNum`)
    REFERENCES `springboard`.`user` (`userNum`)
                                                                 ON DELETE NO ACTION
                                                                 ON UPDATE NO ACTION,
    CONSTRAINT `cmt_boardNum_board_boardNum_fk`
    FOREIGN KEY (`boardNum`)
    REFERENCES `springboard`.`board` (`boardNum`)
                                                                 ON DELETE NO ACTION
                                                                 ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


use springboard;
show tables;
desc user;
desc cmt;
desc board;
ALTER TABLE user AUTO_INCREMENT=1;
delete from user;
INSERT INTO `springboard`.`user`
(`id`,
 `pw`,
 `name`,
 `phone`,
 `grade`)
VALUES
    (
        'admin',
        'admin',
        'admin',
        '01089373790',
        '0');
select * from user;

INSERT INTO `springboard`.`board`
(`userIdx`,
 `title`,
 `content`)
VALUES
    ('1','제목 작성 완료', '내용 작성 완료'),
    ('1','제목 작성 완료1','내용 작성 완료1');

select * from board;

INSERT INTO `springboard`.`cmt`
(`userIdx`,`content`,`boardIdx`,`parent`,`floor`,`order`,`group`)
VALUES
    ('1','내용1','1',null,'0','0','0'),
    ('1','내용2','1',null,'0','5','1'),
    ('1','내용3','1','1','1','1','0'),
    ('1','내용4','1','1','1','2','0'),
    ('1','내용5','1','4','2','3','0'),
    ('1','내용6','1','1','1','4','0'),
    ('1','내용7','1',null,'0','6','2');

select * from cmt order by cmtorder;


-- 가장 잘 동작하는 프로시저
-- 지금 문제점 / 답글의 답글 사이에 답글이 존재할때 순서가 꼬여서 들어감
-- elseif param_num > 1 then 부분에서 해결을 해야함 아직 고민중 주말동안 해결 ㄱ

CREATE DEFINER=`root`@`localhost` PROCEDURE `c_insert_logic3`(
    in param_useridx integer,
    in param_content varchar(8000),
    in param_boardidx integer,
    in param_cmtgroup integer,
    in param_floor integer,
    in param_parent integer,
    in param_cmtorder integer,
    in param_cmtidx integer
)
BEGIN
    declare param_num integer;
    declare param_cmtnum integer;
    select count(*) into param_num from cmt where floor=param_floor and parent = param_parent ;
    select Max(cmtorder) into param_cmtnum from cmt where floor >= param_floor and cmtgroup = param_cmtgroup;
    -- 대댓글
    if param_num > 0 then
        UPDATE cmt set cmtorder = cmtorder+param_num where cmtorder > param_cmtnum;
        INSERT INTO cmt
        (userIdx,content,boardIdx,parent,floor,cmtgroup,cmtorder)
        VALUES
            (param_useridx, param_content,param_boardidx,param_parent,param_floor,param_cmtgroup,param_cmtnum+param_num);
    else
        -- 대댓글이 하나도 없을 경우
        UPDATE cmt set cmtorder = cmtorder+1 where cmtgroup = param_cmtgroup and cmtorder > param_cmtorder and boardIdx = param_boardidx;
        INSERT INTO cmt
        (userIdx,content,boardIdx,parent,floor,cmtgroup,cmtorder)
        VALUES
            (param_useridx, param_content,param_boardidx,param_parent,param_floor,param_cmtgroup,param_cmtorder+1);
    end if;
END