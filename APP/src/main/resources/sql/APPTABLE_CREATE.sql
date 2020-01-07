DROP TABLE IF EXISTS APPWNON_BUSINESS_UNIT;

CREATE TABLE APPWNON_BUSINESS_UNIT
(
    PERIOD         VARCHAR(50)    NOT NULL    COMMENT  '期間',
    RANK           INT(50)        NOT NULL    COMMENT  '排名',
    COUNTRY        VARCHAR(12)                COMMENT  '國家',
    AMT            BIGINT(30)                 COMMENT  '貿易總值',
    PERCENTAGE     FLOAT(5,2)                 COMMENT  '百分比',
    COMMENTS       VARCHAR(20)                COMMENT  '備註',
    PRIMARY KEY (PERIOD, RANK)
)
COMMENT '貿易統計暫存檔'
COLLATE 'utf8mb4_general_ci'
;

DROP TABLE IF EXISTS APPTNON_BUSINESS_UNIT;

CREATE TABLE APPTNON_BUSINESS_UNIT
(
    PERIOD         VARCHAR(50)    NOT NULL    COMMENT  '期間',
    RANK           INT(50)        NOT NULL    COMMENT  '排名',
    COUNTRY        VARCHAR(12)                COMMENT  '國家',
    AMT            BIGINT(30)                 COMMENT  '貿易總值',
    PERCENTAGE     FLOAT(5,2)                 COMMENT  '百分比',
    COMMENTS       VARCHAR(20)                COMMENT  '備註',
    PRIMARY KEY (PERIOD, RANK)
)
COMMENT '貿易統計'
COLLATE 'utf8mb4_general_ci'
;

/*
DROP TABLE IF EXISTS APPWNON_BUSINESS_UNIT;

CREATE TABLE APPWNON_BUSINESS_UNIT
(
    BAN   VARCHAR(10)    NOT NULL    COMMENT  '非營利事業單位統一編號',
    UNIT_NM  VARCHAR(120)            COMMENT  '非營利事業單位名稱',
    HSN_NM   VARCHAR(12)             COMMENT  '縣市名稱',
    MODIFY_DATE    VARCHAR(8)        COMMENT  '異動日期',
    MODIFY_CD      VARCHAR(2)        COMMENT  '異動代號',
    MODIFY_REASON  VARCHAR(120)      COMMENT  '異動原因',
    CREATE_TIME    DATETIME          COMMENT '建立時間',
    UPDATE_TIME    DATETIME          COMMENT '更新時間',
    PRIMARY KEY (BAN)
)
COMMENT '非營利事業機關團體表暫存檔'
COLLATE 'utf8mb4_general_ci'
;

DROP TABLE IF EXISTS APPTNON_BUSINESS_UNIT;

CREATE TABLE APPTNON_BUSINESS_UNIT
(
    BAN   VARCHAR(10)    NOT NULL    COMMENT  '非營利事業單位統一編號',
    UNIT_NM  VARCHAR(120)            COMMENT  '非營利事業單位名稱',
    HSN_NM   VARCHAR(12)             COMMENT  '縣市名稱',
    MODIFY_DATE    VARCHAR(8)        COMMENT  '異動日期',
    MODIFY_CD      VARCHAR(2)        COMMENT  '異動代號',
    MODIFY_REASON  VARCHAR(120)      COMMENT  '異動原因',
    CREATE_TIME    DATETIME          COMMENT '建立時間',
    UPDATE_TIME    DATETIME          COMMENT '更新時間',
    PRIMARY KEY (BAN)
)
COMMENT '非營利事業機關團體表'
COLLATE 'utf8mb4_general_ci'
;

CREATE INDEX I_APPTNON_BUSINESS_UNIT_1 ON APPTNON_BUSINESS_UNIT(HSN_NM);
*/