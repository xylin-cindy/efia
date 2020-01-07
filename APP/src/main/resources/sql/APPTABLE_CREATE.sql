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
