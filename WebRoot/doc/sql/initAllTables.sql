drop table T_UR_BASE_CONFIG cascade constraints;
drop table T_UR_CAR_MODEL cascade constraints;
drop table T_UR_CAR_PRODUCT_CONFIG cascade constraints;
drop table T_UR_EXAM cascade constraints;
drop table T_UR_EXAM_QUESTION cascade constraints;
drop table T_UR_EXAM_QUESTION_REL cascade constraints;
drop table T_UR_EXAM_RESULT cascade constraints;
drop table T_UR_EXAM_TYPE cascade constraints;
drop table T_UR_FAQ cascade constraints;
drop table T_UR_FAQ_FILE cascade constraints;
drop table T_UR_FAQ_FILE_REL cascade constraints;
drop table T_UR_FAQ_IMG cascade constraints;
drop table T_UR_FAQ_IMG_REL cascade constraints;
drop table T_UR_FAQ_INTEREST cascade constraints;
drop table T_UR_FAQ_STORE cascade constraints;
drop table T_UR_FAQ_TMP_HOT_NEW cascade constraints;
drop table T_UR_FAQ_TYPE cascade constraints;
drop table T_UR_LEAVE_MSG_TO_ADMIN cascade constraints;
drop table T_UR_LEAVE_MSG_TO_FAQ cascade constraints;
drop table T_UR_LISTEN_LOG cascade constraints;
drop table T_UR_MSG cascade constraints;
drop table T_UR_NOT_TO_MATCH_LOG cascade constraints;
drop table T_UR_PROPER_NOUN cascade constraints;
drop table T_UR_SEARCH_LOG cascade constraints;
drop table T_UR_SPECIAL_SHOP cascade constraints;
drop table T_UR_USER cascade constraints;
drop table T_UR_USER_POWER cascade constraints;
drop table T_UR_USER_ROLE cascade constraints;
drop table T_UR_USER_ROLE_POWER cascade constraints;
drop table T_UR_USER_ROLE_REL cascade constraints;
create table T_UR_BASE_CONFIG
(
  id              VARCHAR2(32) not null,
  copyright       VARCHAR2(64) not null,
  logo            VARCHAR2(64) not null,
  version         VARCHAR2(64) not null,
  add_datetime    TIMESTAMP(6) default SYSDATE not null,
  update_datetime TIMESTAMP(6),
  sort            NUMBER(6),
  enable          NUMBER(6) default 1 not null
)
;
comment on table T_UR_BASE_CONFIG
  is '基本配置表';
comment on column T_UR_BASE_CONFIG.id
  is '主键';
comment on column T_UR_BASE_CONFIG.copyright
  is '版权';
comment on column T_UR_BASE_CONFIG.logo
  is 'logo图片 默认logo_default.jpg';
comment on column T_UR_BASE_CONFIG.version
  is '版本名称';
comment on column T_UR_BASE_CONFIG.add_datetime
  is '添加时间';
comment on column T_UR_BASE_CONFIG.update_datetime
  is '修改时间';
comment on column T_UR_BASE_CONFIG.sort
  is 'sort';
comment on column T_UR_BASE_CONFIG.enable
  is '是否有效 1表示有效 0表示无效 默认1';
alter table T_UR_BASE_CONFIG
  add constraint PK_T_UR_BASE_CONFIG primary key (ID);

create table T_UR_CAR_MODEL
(
  id              VARCHAR2(32) not null,
  model_code      VARCHAR2(32) default '-1' not null,
  model_name      VARCHAR2(32) not null,
  model_remark    VARCHAR2(128) default '' not null,
  create_user_id  VARCHAR2(32),
  update_user_id  VARCHAR2(32),
  add_datetime    TIMESTAMP(6) default SYSDATE not null,
  update_datetime TIMESTAMP(6),
  enable          NUMBER(6) default 1 not null,
  sort            NUMBER(6)
)
;
comment on table T_UR_CAR_MODEL
  is '车辆型号表';
comment on column T_UR_CAR_MODEL.id
  is '主键';
comment on column T_UR_CAR_MODEL.model_code
  is '编号';
comment on column T_UR_CAR_MODEL.model_name
  is '型号名称';
comment on column T_UR_CAR_MODEL.model_remark
  is '型号描述';
comment on column T_UR_CAR_MODEL.create_user_id
  is '入库人';
comment on column T_UR_CAR_MODEL.update_user_id
  is '最后修改人';
comment on column T_UR_CAR_MODEL.add_datetime
  is '入库时间';
comment on column T_UR_CAR_MODEL.update_datetime
  is '修改时间';
comment on column T_UR_CAR_MODEL.enable
  is '是否有效 1表示有效 0表示失效 默认1';
comment on column T_UR_CAR_MODEL.sort
  is '排序';
alter table T_UR_CAR_MODEL
  add constraint PK_T_UR_CAR_MODEL primary key (ID);

create table T_UR_CAR_PRODUCT_CONFIG
(
  id              VARCHAR2(32) not null,
  model_id        VARCHAR2(32) not null,
  detail_info     VARCHAR2(4000 CHAR) not null,
  create_user_id  VARCHAR2(32),
  update_user_id  VARCHAR2(32),
  add_datetime    TIMESTAMP(6) default SYSDATE not null,
  update_datetime TIMESTAMP(6),
  enable          NUMBER(6) default 1 not null,
  sort            NUMBER(6)
)
;
comment on table T_UR_CAR_PRODUCT_CONFIG
  is '车辆产品配置表';
comment on column T_UR_CAR_PRODUCT_CONFIG.id
  is '主键';
comment on column T_UR_CAR_PRODUCT_CONFIG.model_id
  is '所属型号ID';
comment on column T_UR_CAR_PRODUCT_CONFIG.detail_info
  is '详细信息(用JSON存储)';
comment on column T_UR_CAR_PRODUCT_CONFIG.create_user_id
  is '入库人';
comment on column T_UR_CAR_PRODUCT_CONFIG.update_user_id
  is '最后修改人';
comment on column T_UR_CAR_PRODUCT_CONFIG.add_datetime
  is '入库时间';
comment on column T_UR_CAR_PRODUCT_CONFIG.update_datetime
  is '修改时间';
comment on column T_UR_CAR_PRODUCT_CONFIG.enable
  is '是否有效 1表示有效 0表示失效 默认1';
comment on column T_UR_CAR_PRODUCT_CONFIG.sort
  is '排序';
alter table T_UR_CAR_PRODUCT_CONFIG
  add constraint PK_T_UR_CAR_PRODUCT_CONFIG primary key (ID);

create table T_UR_EXAM
(
  id                    VARCHAR2(32) not null,
  exam_title            VARCHAR2(60 CHAR) not null,
  exam_type             VARCHAR2(32) not null,
  exam_time_interval    NUMBER(6) default 90 not null,
  exam_total_score      NUMBER(6) default 100 not null,
  exam_pass_score       NUMBER(6) default 60 not null,
  exam_effect_datetime  TIMESTAMP(6) default SYSDATE not null,
  exam_invaild_datetime TIMESTAMP(6),
  exam_max_times        NUMBER(6) default -1 not null,
  create_user_id        VARCHAR2(32),
  create_user_name      VARCHAR2(32),
  update_user_id        VARCHAR2(32),
  update_user_name      VARCHAR2(32),
  add_datetime          TIMESTAMP(6) default SYSDATE not null,
  update_datetime       TIMESTAMP(6),
  enable                NUMBER(6) default 1 not null,
  sort                  NUMBER(6)
)
;
comment on table T_UR_EXAM
  is '考试主表';
comment on column T_UR_EXAM.id
  is '主键';
comment on column T_UR_EXAM.exam_title
  is '试题标题';
comment on column T_UR_EXAM.exam_type
  is '所属试题类型';
comment on column T_UR_EXAM.exam_time_interval
  is '考试时长(单位分)';
comment on column T_UR_EXAM.exam_total_score
  is '总分数';
comment on column T_UR_EXAM.exam_pass_score
  is '及格分数';
comment on column T_UR_EXAM.exam_effect_datetime
  is '试题生效时间';
comment on column T_UR_EXAM.exam_invaild_datetime
  is '试题失效时间(为null 表示永不失效)';
comment on column T_UR_EXAM.exam_max_times
  is '试题最大考试次数 为-1表示可以无次数限制';
comment on column T_UR_EXAM.create_user_id
  is '创建人ID';
comment on column T_UR_EXAM.create_user_name
  is '创建人姓名';
comment on column T_UR_EXAM.update_user_id
  is '最后修改人ID';
comment on column T_UR_EXAM.update_user_name
  is '最后修改人名称';
comment on column T_UR_EXAM.add_datetime
  is '入库时间';
comment on column T_UR_EXAM.update_datetime
  is '最后修改时间';
comment on column T_UR_EXAM.enable
  is '1表示有效 0表示失效 默认1';
comment on column T_UR_EXAM.sort
  is '排序';
alter table T_UR_EXAM
  add constraint PK_T_UR_EXAM primary key (ID);

create table T_UR_EXAM_QUESTION
(
  id               VARCHAR2(32) not null,
  question_title   VARCHAR2(256) not null,
  question_answer  VARCHAR2(32) not null,
  question_main    VARCHAR2(512 CHAR),
  question_type    NUMBER(6) default 1 not null,
  question_score   NUMBER(6) default 0 not null,
  create_user_id   VARCHAR2(32),
  create_user_name VARCHAR2(32),
  update_user_id   VARCHAR2(32),
  update_user_name VARCHAR2(32),
  add_datetime     TIMESTAMP(6) default SYSDATE not null,
  update_datetime  TIMESTAMP(6),
  enable           NUMBER(6) default 1 not null,
  sort             NUMBER(6)
)
;
comment on table T_UR_EXAM_QUESTION
  is '考试题目表';
comment on column T_UR_EXAM_QUESTION.id
  is '主键';
comment on column T_UR_EXAM_QUESTION.question_title
  is '题目标题';
comment on column T_UR_EXAM_QUESTION.question_answer
  is '题目答案 多个以逗号隔开';
comment on column T_UR_EXAM_QUESTION.question_main
  is '题目主体 以类似JSON存储  多个以|分开 例如
"selectOp":"A","content":"123" |"selectOp":"B","content":"234"
selectOp表示选项 content 表示选项内容';
comment on column T_UR_EXAM_QUESTION.question_type
  is '题目类型 暂定 1表示 选择题 默认1 其他的未定';
comment on column T_UR_EXAM_QUESTION.question_score
  is '题目分数 默认0分';
comment on column T_UR_EXAM_QUESTION.create_user_id
  is '创建人ID';
comment on column T_UR_EXAM_QUESTION.create_user_name
  is '创建人名称';
comment on column T_UR_EXAM_QUESTION.update_user_id
  is '修改人ID';
comment on column T_UR_EXAM_QUESTION.update_user_name
  is '修改人名';
comment on column T_UR_EXAM_QUESTION.add_datetime
  is '入库时间';
comment on column T_UR_EXAM_QUESTION.update_datetime
  is '最后更改时间';
comment on column T_UR_EXAM_QUESTION.enable
  is '是否有效 0表示无效 1表示有效 默认 1';
comment on column T_UR_EXAM_QUESTION.sort
  is '排序';
alter table T_UR_EXAM_QUESTION
  add constraint PK_T_UR_EXAM_QUESTION primary key (ID);

create table T_UR_EXAM_QUESTION_REL
(
  exam_id          VARCHAR2(32) not null,
  question_id      VARCHAR2(32) not null,
  question_title   VARCHAR2(256) not null,
  question_answer  VARCHAR2(32) not null,
  question_main    VARCHAR2(512 CHAR),
  question_type    NUMBER(6) default 1 not null,
  question_score   NUMBER(6) default 0 not null,
  create_user_id   VARCHAR2(32),
  create_user_name VARCHAR2(32),
  update_user_id   VARCHAR2(32),
  update_user_name VARCHAR2(32),
  add_datetime     TIMESTAMP(6) default SYSDATE not null,
  update_datetime  TIMESTAMP(6),
  enable           NUMBER(6) default 1 not null,
  sort             NUMBER(6)
)
;
comment on table T_UR_EXAM_QUESTION_REL
  is '考试试卷与考试题目关联表';
comment on column T_UR_EXAM_QUESTION_REL.exam_id
  is '试卷ID';
comment on column T_UR_EXAM_QUESTION_REL.question_id
  is '题目ID';
comment on column T_UR_EXAM_QUESTION_REL.question_title
  is '题目标题';
comment on column T_UR_EXAM_QUESTION_REL.question_answer
  is '题目答案 多个以逗号隔开';
comment on column T_UR_EXAM_QUESTION_REL.question_main
  is '题目主体 以类似JSON存储  多个以|分开 例如
"selectOp":"A","content":"123" |"selectOp":"B","content":"234"
selectOp表示选项 content 表示选项内容';
comment on column T_UR_EXAM_QUESTION_REL.question_type
  is '题目类型 暂定 1表示 选择题 默认1 其他的未定';
comment on column T_UR_EXAM_QUESTION_REL.question_score
  is '题目分数 默认0分';
comment on column T_UR_EXAM_QUESTION_REL.create_user_id
  is '创建人ID';
comment on column T_UR_EXAM_QUESTION_REL.create_user_name
  is '创建人名称';
comment on column T_UR_EXAM_QUESTION_REL.update_user_id
  is '修改人ID';
comment on column T_UR_EXAM_QUESTION_REL.update_user_name
  is '修改人名';
comment on column T_UR_EXAM_QUESTION_REL.add_datetime
  is '入库时间';
comment on column T_UR_EXAM_QUESTION_REL.update_datetime
  is '最后更改时间';
comment on column T_UR_EXAM_QUESTION_REL.enable
  is '是否有效 0表示无效 1表示有效 默认 1';
comment on column T_UR_EXAM_QUESTION_REL.sort
  is '排序';
alter table T_UR_EXAM_QUESTION_REL
  add constraint PK_T_UR_EXAM_QUESTION_REL primary key (EXAM_ID, QUESTION_ID);

create table T_UR_EXAM_RESULT
(
  id                    VARCHAR2(32) not null,
  exam_id               VARCHAR2(32) not null,
  exam_user_id          VARCHAR2(32) not null,
  exam_num              NUMBER(6) default 1 not null,
  exam_user_name        VARCHAR2(32),
  exam_pass_score       NUMBER(6),
  exam_score            NUMBER(6) not null,
  exam_start_datetime   TIMESTAMP(6) not null,
  exam_end_datetime     TIMESTAMP(6),
  exam_answers          VARCHAR2(4000 CHAR) default '' not null,
  exam_answer_right_num NUMBER(6) default 0 not null,
  exam_answer_wrong_num NUMBER(6) default 0 not null,
  add_datetime          TIMESTAMP(6) default SYSDATE not null,
  update_datetime       TIMESTAMP(6),
  enable                NUMBER(6) default 1 not null,
  sort                  NUMBER(6)
)
;
comment on table T_UR_EXAM_RESULT
  is '考试成绩表';
comment on column T_UR_EXAM_RESULT.id
  is '主键';
comment on column T_UR_EXAM_RESULT.exam_id
  is '考试试题ID';
comment on column T_UR_EXAM_RESULT.exam_user_id
  is '考试人ID';
comment on column T_UR_EXAM_RESULT.exam_num
  is '第几次考试 默认1';
comment on column T_UR_EXAM_RESULT.exam_user_name
  is '考试人姓名';
comment on column T_UR_EXAM_RESULT.exam_pass_score
  is '及格分数';
comment on column T_UR_EXAM_RESULT.exam_score
  is '考试得分';
comment on column T_UR_EXAM_RESULT.exam_start_datetime
  is '考试开始时间';
comment on column T_UR_EXAM_RESULT.exam_end_datetime
  is '交卷时间';
comment on column T_UR_EXAM_RESULT.exam_answers
  is 'JSON存储 答案 每个答案以|隔开 例如 "NO":"1","answer":"A"| "NO":"2","answer":"A"|';
comment on column T_UR_EXAM_RESULT.exam_answer_right_num
  is '回答正确的数量';
comment on column T_UR_EXAM_RESULT.exam_answer_wrong_num
  is '回答错误的数量';
comment on column T_UR_EXAM_RESULT.add_datetime
  is '入库时间';
comment on column T_UR_EXAM_RESULT.update_datetime
  is '更新时间';
comment on column T_UR_EXAM_RESULT.enable
  is '是否有效 1表示有效 0表示失效 默认 1';
comment on column T_UR_EXAM_RESULT.sort
  is '排序';
alter table T_UR_EXAM_RESULT
  add constraint PK_T_UR_EXAM_RESULT primary key (ID);

create table T_UR_EXAM_TYPE
(
  id               VARCHAR2(32) not null,
  type_name        VARCHAR2(32) not null,
  type_desc        VARCHAR2(60 CHAR),
  parent_id        VARCHAR2(32) default '-1' not null,
  create_user_name VARCHAR2(32),
  create_user_id   VARCHAR2(32),
  update_user_name VARCHAR2(32),
  update_user_id   VARCHAR2(32),
  add_datetime     TIMESTAMP(6) default SYSDATE not null,
  update_datetime  TIMESTAMP(6),
  enable           NUMBER(6) default 1 not null,
  sort             NUMBER(6)
)
;
comment on table T_UR_EXAM_TYPE
  is '试题分类表';
comment on column T_UR_EXAM_TYPE.id
  is '主键';
comment on column T_UR_EXAM_TYPE.type_name
  is '类别名称';
comment on column T_UR_EXAM_TYPE.type_desc
  is '描述';
comment on column T_UR_EXAM_TYPE.parent_id
  is '父亲节点 默认-1 表示根节点';
comment on column T_UR_EXAM_TYPE.create_user_name
  is '创建人名字';
comment on column T_UR_EXAM_TYPE.create_user_id
  is '创建人ID';
comment on column T_UR_EXAM_TYPE.update_user_name
  is '最后修改人名';
comment on column T_UR_EXAM_TYPE.update_user_id
  is '最后修改人ID';
comment on column T_UR_EXAM_TYPE.add_datetime
  is '入库时间';
comment on column T_UR_EXAM_TYPE.update_datetime
  is '最新更改时间';
comment on column T_UR_EXAM_TYPE.enable
  is '状态 1表示有效 0表示失效 默认1';
comment on column T_UR_EXAM_TYPE.sort
  is '排序';
alter table T_UR_EXAM_TYPE
  add constraint PK_T_UR_EXAM_TYPE primary key (ID);

create table T_UR_FAQ
(
  id                   VARCHAR2(32) not null,
  faq_code             VARCHAR2(32) default '-1' not null,
  question             VARCHAR2(256),
  answer               VARCHAR2(4000 CHAR),
  answer_type          NUMBER(6) not null,
  picture_path_last    VARCHAR2(256),
  picture_path_any     VARCHAR2(1024 CHAR),
  faq_file_url_any     VARCHAR2(1024 CHAR),
  create_user_id       VARCHAR2(32),
  create_user_name     VARCHAR2(32),
  faq_type_id          VARCHAR2(32) not null,
  click_num            NUMBER(11) default 0 not null,
  praise_num           NUMBER(11) default 0 not null,
  debase_num           NUMBER(11) default 0 not null,
  fav_num              NUMBER(11) default 0 not null,
  add_datetime         TIMESTAMP(6) default SYSDATE not null,
  update_datetime      TIMESTAMP(6),
  effect_datetime      TIMESTAMP(6) not null,
  invalid_datetime     TIMESTAMP(6),
  last_update_datetime TIMESTAMP(6) not null,
  update_user_id       VARCHAR2(32),
  update_user_name     VARCHAR2(64),
  enable               NUMBER(6) not null,
  sort                 NUMBER(6)
)
;
comment on table T_UR_FAQ
  is 'FAQ主表信息';
comment on column T_UR_FAQ.id
  is '主键';
comment on column T_UR_FAQ.faq_code
  is '自定义序号 默认-1';
comment on column T_UR_FAQ.question
  is '问题';
comment on column T_UR_FAQ.answer
  is '答案';
comment on column T_UR_FAQ.answer_type
  is '答案的类型: 0: text 1 html 2 freemarker';
comment on column T_UR_FAQ.picture_path_last
  is '最后添加的图片地址';
comment on column T_UR_FAQ.picture_path_any
  is '图片地址集合（最多5个）';
comment on column T_UR_FAQ.faq_file_url_any
  is '附件地址集合（最多5个）';
comment on column T_UR_FAQ.create_user_id
  is '创建者ID';
comment on column T_UR_FAQ.create_user_name
  is '创建者名';
comment on column T_UR_FAQ.faq_type_id
  is '知识类型';
comment on column T_UR_FAQ.click_num
  is '点击次数';
comment on column T_UR_FAQ.praise_num
  is '被赞次数';
comment on column T_UR_FAQ.debase_num
  is '被贬低次数';
comment on column T_UR_FAQ.fav_num
  is '收藏次数';
comment on column T_UR_FAQ.add_datetime
  is '入库时间';
comment on column T_UR_FAQ.update_datetime
  is '最后修改时间';
comment on column T_UR_FAQ.effect_datetime
  is '生效时间';
comment on column T_UR_FAQ.invalid_datetime
  is '失效时间';
comment on column T_UR_FAQ.last_update_datetime
  is '上次更新时间';
comment on column T_UR_FAQ.update_user_id
  is '最后一次修改人ID';
comment on column T_UR_FAQ.update_user_name
  is '最后一次修改人名';
comment on column T_UR_FAQ.enable
  is '有效状态 1表示有效 0表示无效 默认1';
comment on column T_UR_FAQ.sort
  is '排序';
alter table T_UR_FAQ
  add constraint PK_T_UR_FAQ primary key (ID);

create table T_UR_FAQ_FILE
(
  id               VARCHAR2(32) not null,
  file_name        VARCHAR2(32) not null,
  file_suffix      VARCHAR2(32) default 'rar' not null,
  file_remark      VARCHAR2(128) default '' not null,
  file_size        NUMBER(6) default 0 not null,
  file_unit        VARCHAR2(6) not null,
  create_user_id   VARCHAR2(32),
  create_user_name VARCHAR2(32),
  update_user_id   VARCHAR2(32),
  update_user_name VARCHAR2(32),
  add_datetime     TIMESTAMP(6) default SYSDATE not null,
  update_datetime  TIMESTAMP(6),
  enable           NUMBER(6) default 1 not null,
  sort             NUMBER(6)
)
;
comment on table T_UR_FAQ_FILE
  is '知识上传文件管理表';
comment on column T_UR_FAQ_FILE.id
  is '主键';
comment on column T_UR_FAQ_FILE.file_name
  is '文件名称';
comment on column T_UR_FAQ_FILE.file_suffix
  is '文件后缀';
comment on column T_UR_FAQ_FILE.file_remark
  is '文件描述';
comment on column T_UR_FAQ_FILE.file_size
  is '文件大小';
comment on column T_UR_FAQ_FILE.file_unit
  is '计算大小单位 默认 MB';
comment on column T_UR_FAQ_FILE.create_user_id
  is '上传者ID';
comment on column T_UR_FAQ_FILE.create_user_name
  is '上传者名称';
comment on column T_UR_FAQ_FILE.update_user_id
  is '修改者ID';
comment on column T_UR_FAQ_FILE.update_user_name
  is '修改者名称';
comment on column T_UR_FAQ_FILE.add_datetime
  is '入库时间';
comment on column T_UR_FAQ_FILE.update_datetime
  is '更新时间';
comment on column T_UR_FAQ_FILE.enable
  is '是否有效 1表示有效 0表示无效 默认1';
comment on column T_UR_FAQ_FILE.sort
  is '排序';
alter table T_UR_FAQ_FILE
  add constraint PK_T_UR_FAQ_FILE primary key (ID);

create table T_UR_FAQ_FILE_REL
(
  faq_id           VARCHAR2(32) not null,
  file_id          VARCHAR2(32) not null,
  file_name        VARCHAR2(32) not null,
  file_suffix      VARCHAR2(32) default 'rar' not null,
  file_remark      VARCHAR2(128) default '' not null,
  file_size        NUMBER(6) default 0 not null,
  file_unit        VARCHAR2(6) default 'MB' not null,
  create_user_id   VARCHAR2(32),
  create_user_name VARCHAR2(32),
  update_user_id   VARCHAR2(32),
  update_user_name VARCHAR2(32),
  add_datetime     TIMESTAMP(6) default SYSDATE not null,
  update_datetime  TIMESTAMP(6),
  enable           NUMBER(6) default 1 not null,
  sort             NUMBER(6)
)
;
comment on table T_UR_FAQ_FILE_REL
  is '知识上传文件与知识关联表';
comment on column T_UR_FAQ_FILE_REL.faq_id
  is '知识ID';
comment on column T_UR_FAQ_FILE_REL.file_id
  is '文件ID';
comment on column T_UR_FAQ_FILE_REL.file_name
  is '文件名称';
comment on column T_UR_FAQ_FILE_REL.file_suffix
  is '文件后缀';
comment on column T_UR_FAQ_FILE_REL.file_remark
  is '文件描述';
comment on column T_UR_FAQ_FILE_REL.file_size
  is '文件大小';
comment on column T_UR_FAQ_FILE_REL.file_unit
  is '文件大小描述单位';
comment on column T_UR_FAQ_FILE_REL.create_user_id
  is '上传者ID';
comment on column T_UR_FAQ_FILE_REL.create_user_name
  is '上传者名称';
comment on column T_UR_FAQ_FILE_REL.update_user_id
  is '修改者ID';
comment on column T_UR_FAQ_FILE_REL.update_user_name
  is '修改者名称';
comment on column T_UR_FAQ_FILE_REL.add_datetime
  is '入库时间';
comment on column T_UR_FAQ_FILE_REL.update_datetime
  is '更新时间';
comment on column T_UR_FAQ_FILE_REL.enable
  is '是否有效 1表示有效 0表示无效 默认1';
comment on column T_UR_FAQ_FILE_REL.sort
  is '排序';
alter table T_UR_FAQ_FILE_REL
  add constraint PK_T_UR_FAQ_FILE_REL primary key (FAQ_ID, FILE_ID);

create table T_UR_FAQ_IMG
(
  id               VARCHAR2(32) not null,
  img_name         VARCHAR2(32) not null,
  img_suffix       VARCHAR2(32) default 'jpg' not null,
  img_remark       VARCHAR2(128) default '' not null,
  img_size         NUMBER(6) not null,
  img_unit         VARCHAR2(6) not null,
  create_user_id   VARCHAR2(32),
  create_user_name VARCHAR2(32),
  update_user_id   VARCHAR2(32),
  update_user_name VARCHAR2(32),
  add_datetime     TIMESTAMP(6) default SYSDATE not null,
  update_datetime  TIMESTAMP(6),
  enable           NUMBER(6) default 1 not null,
  sort             NUMBER(6)
)
;
comment on table T_UR_FAQ_IMG
  is '知识上传图片管理表';
comment on column T_UR_FAQ_IMG.id
  is '主键';
comment on column T_UR_FAQ_IMG.img_name
  is '图片名称';
comment on column T_UR_FAQ_IMG.img_suffix
  is '图片后缀';
comment on column T_UR_FAQ_IMG.img_remark
  is '图片描述';
comment on column T_UR_FAQ_IMG.img_size
  is '图片大小';
comment on column T_UR_FAQ_IMG.img_unit
  is '计算大小单位';
comment on column T_UR_FAQ_IMG.create_user_id
  is '上传者ID';
comment on column T_UR_FAQ_IMG.create_user_name
  is '上传者名称';
comment on column T_UR_FAQ_IMG.update_user_id
  is '修改者ID';
comment on column T_UR_FAQ_IMG.update_user_name
  is '修改者名称';
comment on column T_UR_FAQ_IMG.add_datetime
  is '入库时间';
comment on column T_UR_FAQ_IMG.update_datetime
  is '更新时间';
comment on column T_UR_FAQ_IMG.enable
  is '是否有效 1表示有效 0表示无效 默认1';
comment on column T_UR_FAQ_IMG.sort
  is '排序';
alter table T_UR_FAQ_IMG
  add constraint PK_T_UR_FAQ_IMG primary key (ID);

create table T_UR_FAQ_IMG_REL
(
  faq_id           VARCHAR2(32) not null,
  img_id           VARCHAR2(32) not null,
  img_name         VARCHAR2(32) not null,
  img_suffix       VARCHAR2(32) default 'jpg' not null,
  img_remark       VARCHAR2(128) default '' not null,
  img_size         NUMBER(6) not null,
  img_unit         VARCHAR2(6) not null,
  create_user_id   VARCHAR2(32),
  create_user_name VARCHAR2(32),
  update_user_id   VARCHAR2(32),
  update_user_name VARCHAR2(32),
  add_datetime     TIMESTAMP(6) default SYSDATE not null,
  update_datetime  TIMESTAMP(6),
  enable           NUMBER(6) default 1 not null,
  sort             NUMBER(6)
)
;
comment on table T_UR_FAQ_IMG_REL
  is '知识上传图片与知识关联表';
comment on column T_UR_FAQ_IMG_REL.faq_id
  is '知识ID';
comment on column T_UR_FAQ_IMG_REL.img_id
  is '图片ID';
comment on column T_UR_FAQ_IMG_REL.img_name
  is '图片名称';
comment on column T_UR_FAQ_IMG_REL.img_suffix
  is '图片后缀';
comment on column T_UR_FAQ_IMG_REL.img_remark
  is '图片描述';
comment on column T_UR_FAQ_IMG_REL.img_size
  is '图片大小';
comment on column T_UR_FAQ_IMG_REL.img_unit
  is '计算大小单位';
comment on column T_UR_FAQ_IMG_REL.create_user_id
  is '上传者ID';
comment on column T_UR_FAQ_IMG_REL.create_user_name
  is '上传者名称';
comment on column T_UR_FAQ_IMG_REL.update_user_id
  is '修改者ID';
comment on column T_UR_FAQ_IMG_REL.update_user_name
  is '修改者名称';
comment on column T_UR_FAQ_IMG_REL.add_datetime
  is '入库时间';
comment on column T_UR_FAQ_IMG_REL.update_datetime
  is '更新时间';
comment on column T_UR_FAQ_IMG_REL.enable
  is '是否有效 1表示有效 0表示无效 默认1';
comment on column T_UR_FAQ_IMG_REL.sort
  is '排序';
alter table T_UR_FAQ_IMG_REL
  add constraint PK_T_UR_FAQ_IMG_REL primary key (FAQ_ID, IMG_ID);

create table T_UR_FAQ_INTEREST
(
  id                   VARCHAR2(32) not null,
  faq_code             VARCHAR2(32) default '-1' not null,
  question             VARCHAR2(256),
  answer               VARCHAR2(4000 CHAR),
  answer_type          NUMBER(6) not null,
  picture_path_last    VARCHAR2(256),
  picture_path_any     VARCHAR2(1024 CHAR),
  faq_file_url_any     VARCHAR2(1024 CHAR),
  create_user_id       VARCHAR2(32),
  create_user_name     VARCHAR2(32),
  faq_type_id          VARCHAR2(32) not null,
  click_num            NUMBER(11) default 0 not null,
  praise_num           NUMBER(11) default 0 not null,
  debase_num           NUMBER(11) default 0 not null,
  fav_num              NUMBER(11) default 0 not null,
  add_datetime         TIMESTAMP(6) default SYSDATE not null,
  update_datetime      TIMESTAMP(6),
  effect_datetime      TIMESTAMP(6) not null,
  invalid_datetime     TIMESTAMP(6),
  last_update_datetime TIMESTAMP(6) not null,
  update_user_id       VARCHAR2(32),
  update_user_name     VARCHAR2(64),
  enable               NUMBER(6) not null,
  sort                 NUMBER(6)
)
;
comment on table T_UR_FAQ_INTEREST
  is '趣味库知识表';
comment on column T_UR_FAQ_INTEREST.id
  is '主键';
comment on column T_UR_FAQ_INTEREST.faq_code
  is '自定义序号 默认-1';
comment on column T_UR_FAQ_INTEREST.question
  is '问题';
comment on column T_UR_FAQ_INTEREST.answer
  is '答案 多个答案以| 分割';
comment on column T_UR_FAQ_INTEREST.answer_type
  is '答案的类型: 0: text 1 html 2 freemarker';
comment on column T_UR_FAQ_INTEREST.picture_path_last
  is '最后添加的图片地址';
comment on column T_UR_FAQ_INTEREST.picture_path_any
  is '图片地址集合（最多5个）';
comment on column T_UR_FAQ_INTEREST.faq_file_url_any
  is '附件地址集合（最多5个）';
comment on column T_UR_FAQ_INTEREST.create_user_id
  is '创建者ID';
comment on column T_UR_FAQ_INTEREST.create_user_name
  is '创建者名';
comment on column T_UR_FAQ_INTEREST.faq_type_id
  is '知识类型';
comment on column T_UR_FAQ_INTEREST.click_num
  is '点击次数';
comment on column T_UR_FAQ_INTEREST.praise_num
  is '被赞次数';
comment on column T_UR_FAQ_INTEREST.debase_num
  is '被贬低次数';
comment on column T_UR_FAQ_INTEREST.fav_num
  is '收藏次数';
comment on column T_UR_FAQ_INTEREST.add_datetime
  is '入库时间';
comment on column T_UR_FAQ_INTEREST.update_datetime
  is '最后修改时间';
comment on column T_UR_FAQ_INTEREST.effect_datetime
  is '生效时间';
comment on column T_UR_FAQ_INTEREST.invalid_datetime
  is '失效时间';
comment on column T_UR_FAQ_INTEREST.last_update_datetime
  is '上次更新时间';
comment on column T_UR_FAQ_INTEREST.update_user_id
  is '最后一次修改人ID';
comment on column T_UR_FAQ_INTEREST.update_user_name
  is '最后一次修改人名';
comment on column T_UR_FAQ_INTEREST.enable
  is '有效状态 1表示有效 0表示无效 默认1';
comment on column T_UR_FAQ_INTEREST.sort
  is '排序';
alter table T_UR_FAQ_INTEREST
  add constraint PK_T_UR_FAQ_INTEREST primary key (ID);

create table T_UR_FAQ_STORE
(
  user_id         VARCHAR2(32) not null,
  faq_id          VARCHAR2(32) not null,
  add_datetime    TIMESTAMP(6) default SYSDATE not null,
  update_datetime TIMESTAMP(6),
  enable          NUMBER(6) not null,
  sort            NUMBER(6)
)
;
comment on table T_UR_FAQ_STORE
  is '知识收藏表';
comment on column T_UR_FAQ_STORE.user_id
  is '用户ID';
comment on column T_UR_FAQ_STORE.faq_id
  is '关联知识ID';
comment on column T_UR_FAQ_STORE.add_datetime
  is '收藏时间';
comment on column T_UR_FAQ_STORE.update_datetime
  is '修改时间';
comment on column T_UR_FAQ_STORE.enable
  is '是否有效 1表示有效 0表示失效 默认1';
comment on column T_UR_FAQ_STORE.sort
  is '排序';
alter table T_UR_FAQ_STORE
  add constraint PK_T_UR_FAQ_STORE primary key (USER_ID, FAQ_ID);

create table T_UR_FAQ_TMP_HOT_NEW
(
  id                   VARCHAR2(32) not null,
  faq_code             VARCHAR2(32) default '-1' not null,
  question             VARCHAR2(256),
  answer               VARCHAR2(4000 CHAR),
  answer_type          NUMBER(6) not null,
  picture_path_last    VARCHAR2(256),
  picture_path_any     VARCHAR2(1024 CHAR),
  faq_file_url_any     VARCHAR2(1024 CHAR),
  create_user_id       VARCHAR2(32),
  create_user_name     VARCHAR2(32),
  faq_type_id          VARCHAR2(32) not null,
  click_num            NUMBER(11) default 0 not null,
  praise_num           NUMBER(11) default 0 not null,
  debase_num           NUMBER(11) default 0 not null,
  fav_num              NUMBER(11) default 0 not null,
  add_datetime         TIMESTAMP(6) default SYSDATE not null,
  update_datetime      TIMESTAMP(6),
  effect_datetime      TIMESTAMP(6) not null,
  invalid_datetime     TIMESTAMP(6),
  faq_tmp_type         NUMBER(6) default 0 not null,
  last_update_datetime TIMESTAMP(6) not null,
  update_user_id       VARCHAR2(32),
  update_user_name     VARCHAR2(64),
  enable               NUMBER(6) not null,
  sort                 NUMBER(6)
)
;
comment on table T_UR_FAQ_TMP_HOT_NEW
  is '最新问题和热点问题零时表';
comment on column T_UR_FAQ_TMP_HOT_NEW.id
  is '主键';
comment on column T_UR_FAQ_TMP_HOT_NEW.faq_code
  is '自定义序号 默认-1';
comment on column T_UR_FAQ_TMP_HOT_NEW.question
  is '问题';
comment on column T_UR_FAQ_TMP_HOT_NEW.answer
  is '答案';
comment on column T_UR_FAQ_TMP_HOT_NEW.answer_type
  is '答案的类型: 0: text 1 html 2 freemarker';
comment on column T_UR_FAQ_TMP_HOT_NEW.picture_path_last
  is '最后添加的图片地址';
comment on column T_UR_FAQ_TMP_HOT_NEW.picture_path_any
  is '图片地址集合（最多5个）';
comment on column T_UR_FAQ_TMP_HOT_NEW.faq_file_url_any
  is '附件地址集合（最多5个）';
comment on column T_UR_FAQ_TMP_HOT_NEW.create_user_id
  is '创建者ID';
comment on column T_UR_FAQ_TMP_HOT_NEW.create_user_name
  is '创建者名';
comment on column T_UR_FAQ_TMP_HOT_NEW.faq_type_id
  is '知识类型';
comment on column T_UR_FAQ_TMP_HOT_NEW.click_num
  is '点击次数';
comment on column T_UR_FAQ_TMP_HOT_NEW.praise_num
  is '被赞次数';
comment on column T_UR_FAQ_TMP_HOT_NEW.debase_num
  is '被贬低次数';
comment on column T_UR_FAQ_TMP_HOT_NEW.fav_num
  is '收藏次数';
comment on column T_UR_FAQ_TMP_HOT_NEW.add_datetime
  is '入库时间';
comment on column T_UR_FAQ_TMP_HOT_NEW.update_datetime
  is '最后修改时间';
comment on column T_UR_FAQ_TMP_HOT_NEW.effect_datetime
  is '生效时间';
comment on column T_UR_FAQ_TMP_HOT_NEW.invalid_datetime
  is '失效时间';
comment on column T_UR_FAQ_TMP_HOT_NEW.faq_tmp_type
  is '类型 0表示最新问题 1表示最热问题 默认0';
comment on column T_UR_FAQ_TMP_HOT_NEW.last_update_datetime
  is '上次更新时间';
comment on column T_UR_FAQ_TMP_HOT_NEW.update_user_id
  is '最后一次修改人ID';
comment on column T_UR_FAQ_TMP_HOT_NEW.update_user_name
  is '最后一次修改人名';
comment on column T_UR_FAQ_TMP_HOT_NEW.enable
  is '有效状态 1表示有效 0表示无效 默认1';
comment on column T_UR_FAQ_TMP_HOT_NEW.sort
  is '排序';
alter table T_UR_FAQ_TMP_HOT_NEW
  add constraint PK_T_UR_FAQ_TMP_HOT_NEW primary key (ID);

create table T_UR_FAQ_TYPE
(
  id               VARCHAR2(32) not null,
  faq_type_code    VARCHAR2(32) default '-1' not null,
  faq_type_name    VARCHAR2(32) not null,
  faq_type_desc    VARCHAR2(60 CHAR),
  parent_id        VARCHAR2(32) default '-1' not null,
  create_user_id   VARCHAR2(32),
  create_user_name VARCHAR2(32),
  update_user_id   VARCHAR2(32),
  update_user_name VARCHAR2(32),
  add_datetime     TIMESTAMP(6) default SYSDATE not null,
  update_datetime  TIMESTAMP(6),
  enable           NUMBER(6) default 1 not null,
  sort             NUMBER(6)
)
;
comment on table T_UR_FAQ_TYPE
  is '知识类型表';
comment on column T_UR_FAQ_TYPE.id
  is '主键';
comment on column T_UR_FAQ_TYPE.faq_type_code
  is '知识类型编号（这个可以用户自定义 默认-1）';
comment on column T_UR_FAQ_TYPE.faq_type_name
  is '知识类型名称';
comment on column T_UR_FAQ_TYPE.faq_type_desc
  is '知识类型描述';
comment on column T_UR_FAQ_TYPE.parent_id
  is '父类型ID 默认-1 表示根类型';
comment on column T_UR_FAQ_TYPE.create_user_id
  is '创建者ID';
comment on column T_UR_FAQ_TYPE.create_user_name
  is '创建者名称';
comment on column T_UR_FAQ_TYPE.update_user_id
  is '最后一次更新者ID';
comment on column T_UR_FAQ_TYPE.update_user_name
  is '最后一次更新者名称';
comment on column T_UR_FAQ_TYPE.add_datetime
  is '入库时间';
comment on column T_UR_FAQ_TYPE.update_datetime
  is '更新时间';
comment on column T_UR_FAQ_TYPE.enable
  is '状态 默认1 表示有效 0表示失效';
comment on column T_UR_FAQ_TYPE.sort
  is '排序';
alter table T_UR_FAQ_TYPE
  add constraint PK_T_UR_FAQ_TYPE primary key (ID);

create table T_UR_LEAVE_MSG_TO_ADMIN
(
  id               VARCHAR2(32) not null,
  title            VARCHAR2(32) not null,
  content          VARCHAR2(256) not null,
  create_user_name VARCHAR2(32),
  create_user_id   VARCHAR2(32) not null,
  source           NUMBER(6) default 0 not null,
  add_datetime     TIMESTAMP(6) default SYSDATE not null,
  update_datetime  TIMESTAMP(6),
  enable           NUMBER(6) default 1 not null,
  sort             NUMBER(6)
)
;
comment on table T_UR_LEAVE_MSG_TO_ADMIN
  is '给管理员留言表';
comment on column T_UR_LEAVE_MSG_TO_ADMIN.id
  is '主键';
comment on column T_UR_LEAVE_MSG_TO_ADMIN.title
  is '标题';
comment on column T_UR_LEAVE_MSG_TO_ADMIN.content
  is '内容';
comment on column T_UR_LEAVE_MSG_TO_ADMIN.create_user_name
  is '留言人名称';
comment on column T_UR_LEAVE_MSG_TO_ADMIN.create_user_id
  is '留言人ID';
comment on column T_UR_LEAVE_MSG_TO_ADMIN.source
  is '0表示 内部员工 1表示微信 2表示app';
comment on column T_UR_LEAVE_MSG_TO_ADMIN.add_datetime
  is '入库时间';
comment on column T_UR_LEAVE_MSG_TO_ADMIN.update_datetime
  is '修改时间';
comment on column T_UR_LEAVE_MSG_TO_ADMIN.enable
  is '状态 默认1 1表示未失效 0表示失效';
comment on column T_UR_LEAVE_MSG_TO_ADMIN.sort
  is '排序';
alter table T_UR_LEAVE_MSG_TO_ADMIN
  add constraint PK_T_UR_LEAVE_MSG_TO_ADMIN primary key (ID);

create table T_UR_LEAVE_MSG_TO_FAQ
(
  id               VARCHAR2(32) not null,
  title            VARCHAR2(32) not null,
  content          VARCHAR2(256),
  create_user_id   VARCHAR2(32) not null,
  create_user_name VARCHAR2(32),
  faq_id           VARCHAR2(32),
  question         VARCHAR2(256),
  answer           VARCHAR2(4000 CHAR),
  add_datetime     TIMESTAMP(6) default SYSDATE not null,
  update_datetime  TIMESTAMP(6),
  enable           NUMBER(6) default 1 not null,
  sort             NUMBER(6)
)
;
comment on table T_UR_LEAVE_MSG_TO_FAQ
  is '针对FAQ留言';
comment on column T_UR_LEAVE_MSG_TO_FAQ.id
  is '主键';
comment on column T_UR_LEAVE_MSG_TO_FAQ.title
  is '主题';
comment on column T_UR_LEAVE_MSG_TO_FAQ.content
  is '留言内容';
comment on column T_UR_LEAVE_MSG_TO_FAQ.create_user_id
  is '内部员工编号';
comment on column T_UR_LEAVE_MSG_TO_FAQ.create_user_name
  is '内部员工姓名';
comment on column T_UR_LEAVE_MSG_TO_FAQ.faq_id
  is 'FEQID';
comment on column T_UR_LEAVE_MSG_TO_FAQ.question
  is '问题';
comment on column T_UR_LEAVE_MSG_TO_FAQ.answer
  is '答案';
comment on column T_UR_LEAVE_MSG_TO_FAQ.add_datetime
  is '创建时间';
comment on column T_UR_LEAVE_MSG_TO_FAQ.update_datetime
  is '更新时间';
comment on column T_UR_LEAVE_MSG_TO_FAQ.enable
  is '有效状态 0表示无效 1表示有效 默认1';
comment on column T_UR_LEAVE_MSG_TO_FAQ.sort
  is '排序';
alter table T_UR_LEAVE_MSG_TO_FAQ
  add constraint PK_T_UR_LEAVE_MSG_TO_FAQ primary key (ID);

create table T_UR_LISTEN_LOG
(
  id              VARCHAR2(32) not null,
  order_no        VARCHAR2(32) not null,
  staff_id        VARCHAR2(32) not null,
  staff_name      VARCHAR2(32) not null,
  customer_id     VARCHAR2(32),
  customer_name   VARCHAR2(32),
  query_content   VARCHAR2(256),
  answer          VARCHAR2(4000 CHAR),
  add_datetime    TIMESTAMP(6) default SYSDATE not null,
  update_datetime TIMESTAMP(6),
  enable          NUMBER(6) default 1 not null,
  sort            NUMBER(6)
)
;
comment on table T_UR_LISTEN_LOG
  is '监控日志';
comment on column T_UR_LISTEN_LOG.id
  is '主键';
comment on column T_UR_LISTEN_LOG.order_no
  is '工单号';
comment on column T_UR_LISTEN_LOG.staff_id
  is '员工ID';
comment on column T_UR_LISTEN_LOG.staff_name
  is '员工姓名';
comment on column T_UR_LISTEN_LOG.customer_id
  is '客户ID';
comment on column T_UR_LISTEN_LOG.customer_name
  is '客户名称';
comment on column T_UR_LISTEN_LOG.query_content
  is '查询内容';
comment on column T_UR_LISTEN_LOG.answer
  is '回答 多个回复 以他点击的那个为主';
comment on column T_UR_LISTEN_LOG.add_datetime
  is '入库时间';
comment on column T_UR_LISTEN_LOG.update_datetime
  is '更新时间';
comment on column T_UR_LISTEN_LOG.enable
  is '是否有效 1表示有效 0 表示无效 默认 1';
comment on column T_UR_LISTEN_LOG.sort
  is '排序';
alter table T_UR_LISTEN_LOG
  add constraint PK_T_UR_LISTEN_LOG primary key (ID);

create table T_UR_MSG
(
  id               VARCHAR2(32) not null,
  title            VARCHAR2(32) not null,
  content          VARCHAR2(1024 CHAR),
  create_user_name VARCHAR2(32),
  create_user_id   VARCHAR2(32),
  update_user_id   VARCHAR2(32),
  update_user_name VARCHAR2(32),
  add_datetime     TIMESTAMP(6) default SYSDATE not null,
  update_datetime  TIMESTAMP(6),
  enable           NUMBER(6) default 1 not null,
  sort             NUMBER(6)
)
;
comment on table T_UR_MSG
  is '消息通知';
comment on column T_UR_MSG.id
  is '主键';
comment on column T_UR_MSG.title
  is '主题';
comment on column T_UR_MSG.content
  is '内容';
comment on column T_UR_MSG.create_user_name
  is '创建人名字';
comment on column T_UR_MSG.create_user_id
  is '创建人ID';
comment on column T_UR_MSG.update_user_id
  is '最后更新人ID';
comment on column T_UR_MSG.update_user_name
  is '最后更新人名称';
comment on column T_UR_MSG.add_datetime
  is '创建时间';
comment on column T_UR_MSG.update_datetime
  is '更新时间';
comment on column T_UR_MSG.enable
  is '有效状态 1表示有效 0表示失效 默认1';
comment on column T_UR_MSG.sort
  is '排序';
alter table T_UR_MSG
  add constraint PK_T_UR_MSG primary key (ID);

create table T_UR_NOT_TO_MATCH_LOG
(
  id              VARCHAR2(32) not null,
  staff_id        VARCHAR2(32),
  staff_name      VARCHAR2(32),
  customer_id     VARCHAR2(32),
  customer_name   VARCHAR2(32),
  query_content   VARCHAR2(256),
  add_datetime    TIMESTAMP(6) default SYSDATE not null,
  update_datetime TIMESTAMP(6),
  enable          NUMBER(6) default 1 not null,
  sort            NUMBER(6)
)
;
comment on table T_UR_NOT_TO_MATCH_LOG
  is '未回答上来的问题记录';
comment on column T_UR_NOT_TO_MATCH_LOG.id
  is '主键';
comment on column T_UR_NOT_TO_MATCH_LOG.staff_id
  is '员工ID';
comment on column T_UR_NOT_TO_MATCH_LOG.staff_name
  is '员工姓名';
comment on column T_UR_NOT_TO_MATCH_LOG.customer_id
  is '客户ID';
comment on column T_UR_NOT_TO_MATCH_LOG.customer_name
  is '客户名称';
comment on column T_UR_NOT_TO_MATCH_LOG.query_content
  is '查询内容';
comment on column T_UR_NOT_TO_MATCH_LOG.add_datetime
  is '入库时间';
comment on column T_UR_NOT_TO_MATCH_LOG.update_datetime
  is '更新时间';
comment on column T_UR_NOT_TO_MATCH_LOG.enable
  is '是否有效 1表示有效 0 表示无效 默认 1';
comment on column T_UR_NOT_TO_MATCH_LOG.sort
  is '排序';
alter table T_UR_NOT_TO_MATCH_LOG
  add constraint PK_T_UR_NOT_TO_MATCH_LOG primary key (ID);

create table T_UR_PROPER_NOUN
(
  id               VARCHAR2(32) not null,
  name             VARCHAR2(32),
  noun_synonym     VARCHAR2(4000 CHAR),
  create_user_id   VARCHAR2(32),
  create_user_name VARCHAR2(64),
  update_user_id   VARCHAR2(32),
  update_user_name VARCHAR2(64),
  add_datetime     TIMESTAMP(6) default SYSDATE not null,
  update_datetime  TIMESTAMP(6),
  sort             NUMBER(6),
  enable           NUMBER(6) default 1 not null
)
;
comment on table T_UR_PROPER_NOUN
  is '专有名词';
comment on column T_UR_PROPER_NOUN.id
  is '主键';
comment on column T_UR_PROPER_NOUN.name
  is '名词';
comment on column T_UR_PROPER_NOUN.noun_synonym
  is '同义词，多个以| 隔开';
comment on column T_UR_PROPER_NOUN.create_user_id
  is '入库者ID';
comment on column T_UR_PROPER_NOUN.create_user_name
  is '入库者名称';
comment on column T_UR_PROPER_NOUN.update_user_id
  is '最后更新者ID';
comment on column T_UR_PROPER_NOUN.update_user_name
  is '最后更新者名称';
comment on column T_UR_PROPER_NOUN.add_datetime
  is '入库时间';
comment on column T_UR_PROPER_NOUN.update_datetime
  is '更新时间';
comment on column T_UR_PROPER_NOUN.sort
  is '排序';
comment on column T_UR_PROPER_NOUN.enable
  is '有效状态 1表示有效 0表示失效 默认1';
alter table T_UR_PROPER_NOUN
  add constraint PK_T_UR_PROPER_NOUN primary key (ID);
alter table T_UR_PROPER_NOUN
  add constraint CKC_ENABLE_T_UR_PRO
  check (enable between 0 and 1);

create table T_UR_SEARCH_LOG
(
  id                  VARCHAR2(32) not null,
  user_id             VARCHAR2(32) not null,
  user_name           VARCHAR2(32),
  search_content      VARCHAR2(1024 CHAR) not null,
  replay_faq_answer   VARCHAR2(4000 CHAR) not null,
  replay_faq_id       VARCHAR2(32) not null,
  replay_faq_question VARCHAR2(1024 CHAR) not null,
  source              NUMBER(6) default 0 not null,
  add_datetime        TIMESTAMP(6) default SYSDATE not null,
  update_datetime     TIMESTAMP(6),
  enable              NUMBER(6) default 1 not null,
  sort                NUMBER(6)
)
;
comment on table T_UR_SEARCH_LOG
  is '搜索记录表';
comment on column T_UR_SEARCH_LOG.id
  is '主键';
comment on column T_UR_SEARCH_LOG.user_id
  is '用户ID';
comment on column T_UR_SEARCH_LOG.user_name
  is '用户名称';
comment on column T_UR_SEARCH_LOG.search_content
  is '搜索内容';
comment on column T_UR_SEARCH_LOG.replay_faq_answer
  is '回答内容 多个答案默认取第一个';
comment on column T_UR_SEARCH_LOG.replay_faq_id
  is '回答的知识 ID 多个默认取第一个';
comment on column T_UR_SEARCH_LOG.replay_faq_question
  is '搜索后的知识题目  多个默认取第一个';
comment on column T_UR_SEARCH_LOG.source
  is '0表示 内部员工 1表示微信 2表示app';
comment on column T_UR_SEARCH_LOG.add_datetime
  is '入库时间';
comment on column T_UR_SEARCH_LOG.update_datetime
  is '修改时间';
comment on column T_UR_SEARCH_LOG.enable
  is '有效状态';
comment on column T_UR_SEARCH_LOG.sort
  is '排序';
alter table T_UR_SEARCH_LOG
  add constraint PK_T_UR_SEARCH_LOG primary key (ID);
alter table T_UR_SEARCH_LOG
  add constraint CKC_ENABLE_T_UR_SEA
  check (enable between 0 and 1);

create table T_UR_SPECIAL_SHOP
(
  id               VARCHAR2(32) not null,
  shop_name        VARCHAR2(32) not null,
  address          VARCHAR2(128),
  sale_tel         VARCHAR2(128),
  server_tel       VARCHAR2(128),
  longitude        NUMBER(3,8) not null,
  lat              NUMBER(3,8) not null,
  create_user_id   VARCHAR2(32),
  create_user_name VARCHAR2(32),
  update_user_id   VARCHAR2(32),
  update_user_name VARCHAR2(32),
  add_datetime     TIMESTAMP(6) default SYSDATE not null,
  update_datetime  TIMESTAMP(6),
  enable           NUMBER(6) default 1 not null,
  sort             NUMBER(6)
)
;
comment on table T_UR_SPECIAL_SHOP
  is '特约店';
comment on column T_UR_SPECIAL_SHOP.id
  is '主键';
comment on column T_UR_SPECIAL_SHOP.shop_name
  is '特约店名称';
comment on column T_UR_SPECIAL_SHOP.address
  is '具体地址';
comment on column T_UR_SPECIAL_SHOP.sale_tel
  is '销售电话,多个以分号隔开,最多9个';
comment on column T_UR_SPECIAL_SHOP.server_tel
  is '服务电话，多个以分号隔开，最多9个';
comment on column T_UR_SPECIAL_SHOP.longitude
  is '精度';
comment on column T_UR_SPECIAL_SHOP.lat
  is '纬度';
comment on column T_UR_SPECIAL_SHOP.create_user_id
  is '创建人ID';
comment on column T_UR_SPECIAL_SHOP.create_user_name
  is '创建人名称';
comment on column T_UR_SPECIAL_SHOP.update_user_id
  is '更新人ID';
comment on column T_UR_SPECIAL_SHOP.update_user_name
  is '更新人名';
comment on column T_UR_SPECIAL_SHOP.add_datetime
  is '入库时间';
comment on column T_UR_SPECIAL_SHOP.update_datetime
  is '最后修改时间';
comment on column T_UR_SPECIAL_SHOP.enable
  is '1表示有效 0表示失效 默认1';
comment on column T_UR_SPECIAL_SHOP.sort
  is '排序';

create table T_UR_USER
(
  id               VARCHAR2(32) not null,
  user_code        VARCHAR2(32),
  user_name        VARCHAR2(32) not null,
  nick_name        VARCHAR2(32) not null,
  password         VARCHAR2(32) not null,
  user_remark      VARCHAR2(60 CHAR),
  create_user_id   VARCHAR2(32),
  create_user_name VARCHAR2(32),
  udpate_user_id   VARCHAR2(32),
  update_user_name VARCHAR2(32),
  add_datetime     TIMESTAMP(6) default SYSDATE not null,
  update_datetime  TIMESTAMP(6),
  enable           NUMBER(6) default 1 not null,
  sort             NUMBER(6)
)
;
comment on table T_UR_USER
  is '用户表';
comment on column T_UR_USER.id
  is '主键';
comment on column T_UR_USER.user_code
  is '员工编号( 方便查询)';
comment on column T_UR_USER.user_name
  is '用户名';
comment on column T_UR_USER.nick_name
  is '用户昵称';
comment on column T_UR_USER.password
  is '用户密码';
comment on column T_UR_USER.user_remark
  is '备注';
comment on column T_UR_USER.create_user_id
  is '添加人ID';
comment on column T_UR_USER.create_user_name
  is '添加人姓名';
comment on column T_UR_USER.udpate_user_id
  is '更新人ID';
comment on column T_UR_USER.update_user_name
  is '更新人名称';
comment on column T_UR_USER.add_datetime
  is '入库时间';
comment on column T_UR_USER.update_datetime
  is '最后更新时间';
comment on column T_UR_USER.enable
  is '有效状态 1表示有效 0表示失效 默认1';
comment on column T_UR_USER.sort
  is '排序';
alter table T_UR_USER
  add constraint PK_T_UR_USER primary key (ID);

create table T_UR_USER_POWER
(
  id              VARCHAR2(32) not null,
  power_name      VARCHAR2(32) not null,
  page_url        VARCHAR2(256),
  action_url      VARCHAR2(256),
  create_user_id  VARCHAR2(32),
  update_user_id  VARCHAR2(32),
  add_datetime    TIMESTAMP(6) not null,
  update_datetime TIMESTAMP(6),
  enable          NUMBER(6) default 1 not null,
  sort            NUMBER(6)
)
;
comment on table T_UR_USER_POWER
  is '用户权限表';
comment on column T_UR_USER_POWER.id
  is '主键';
comment on column T_UR_USER_POWER.power_name
  is '权限名称';
comment on column T_UR_USER_POWER.page_url
  is '页面访问地址,多个以逗号隔开';
comment on column T_UR_USER_POWER.action_url
  is '后台action访问地址 ，多个以逗号隔开';
comment on column T_UR_USER_POWER.create_user_id
  is '创建人ID';
comment on column T_UR_USER_POWER.update_user_id
  is '更新人ID';
comment on column T_UR_USER_POWER.add_datetime
  is '入库时间';
comment on column T_UR_USER_POWER.update_datetime
  is '更新时间';
comment on column T_UR_USER_POWER.enable
  is '是否有效 默认1 1有效 0表示无效';
comment on column T_UR_USER_POWER.sort
  is '排序';
alter table T_UR_USER_POWER
  add constraint PK_T_UR_USER_POWER primary key (ID);

create table T_UR_USER_ROLE
(
  id              VARCHAR2(32) not null,
  role_name       VARCHAR2(32) not null,
  role_remark     VARCHAR2(60 CHAR),
  create_user_id  VARCHAR2(32),
  update_user_id  VARCHAR2(32),
  add_datetime    TIMESTAMP(6) default SYSDATE not null,
  update_datetime TIMESTAMP(6),
  enable          NUMBER(6) default 1 not null,
  sort            NUMBER(6)
)
;
comment on table T_UR_USER_ROLE
  is '角色表';
comment on column T_UR_USER_ROLE.id
  is '主键';
comment on column T_UR_USER_ROLE.role_name
  is '角色名称';
comment on column T_UR_USER_ROLE.role_remark
  is '角色备注';
comment on column T_UR_USER_ROLE.create_user_id
  is '创建者ID';
comment on column T_UR_USER_ROLE.update_user_id
  is '修改者ID';
comment on column T_UR_USER_ROLE.add_datetime
  is '入库时间';
comment on column T_UR_USER_ROLE.update_datetime
  is '修改时间';
comment on column T_UR_USER_ROLE.enable
  is '是否有效 1表示有效 0表示失效 默认1';
comment on column T_UR_USER_ROLE.sort
  is '排序';
alter table T_UR_USER_ROLE
  add constraint PK_T_UR_USER_ROLE primary key (ID);

create table T_UR_USER_ROLE_POWER
(
  role_id         VARCHAR2(32) not null,
  power_id        VARCHAR2(32) not null,
  create_user_id  VARCHAR2(32),
  update_user_id  VARCHAR2(32),
  add_datetime    TIMESTAMP(6) default SYSDATE not null,
  update_datetime TIMESTAMP(6),
  enable          NUMBER(6) default 1 not null,
  sort            NUMBER(6)
)
;
comment on table T_UR_USER_ROLE_POWER
  is '用户角色权限关联表';
comment on column T_UR_USER_ROLE_POWER.role_id
  is '角色ID';
comment on column T_UR_USER_ROLE_POWER.power_id
  is '权限ID';
comment on column T_UR_USER_ROLE_POWER.create_user_id
  is '创建者ID';
comment on column T_UR_USER_ROLE_POWER.update_user_id
  is '修改者ID';
comment on column T_UR_USER_ROLE_POWER.add_datetime
  is '入库时间';
comment on column T_UR_USER_ROLE_POWER.update_datetime
  is '修改时间';
comment on column T_UR_USER_ROLE_POWER.enable
  is '状态 1表示有效 0表示无效 默认1';
comment on column T_UR_USER_ROLE_POWER.sort
  is '排序';
alter table T_UR_USER_ROLE_POWER
  add constraint PK_T_UR_USER_ROLE_POWER primary key (ROLE_ID, POWER_ID);

create table T_UR_USER_ROLE_REL
(
  role_id         VARCHAR2(32) not null,
  user_id         VARCHAR2(32) not null,
  create_user_id  VARCHAR2(32),
  update_user_id  VARCHAR2(32),
  add_datetime    TIMESTAMP(6) default SYSDATE not null,
  update_datetime TIMESTAMP(6),
  enable          NUMBER(6) default 1 not null,
  sort            NUMBER(6)
)
;
comment on table T_UR_USER_ROLE_REL
  is '用户和角色关联表';
comment on column T_UR_USER_ROLE_REL.role_id
  is '角色ID';
comment on column T_UR_USER_ROLE_REL.user_id
  is '用户ID';
comment on column T_UR_USER_ROLE_REL.create_user_id
  is '创建者ID';
comment on column T_UR_USER_ROLE_REL.update_user_id
  is '修改者ID';
comment on column T_UR_USER_ROLE_REL.add_datetime
  is '入库时间';
comment on column T_UR_USER_ROLE_REL.update_datetime
  is '修改时间';
comment on column T_UR_USER_ROLE_REL.enable
  is '状态 1表示有效 0表示无效 默认1';
comment on column T_UR_USER_ROLE_REL.sort
  is '排序';
alter table T_UR_USER_ROLE_REL
  add constraint PK_T_UR_USER_ROLE_REL primary key (ROLE_ID, USER_ID);

alter table T_UR_BASE_CONFIG disable all triggers;
alter table T_UR_CAR_MODEL disable all triggers;
alter table T_UR_CAR_PRODUCT_CONFIG disable all triggers;
alter table T_UR_EXAM disable all triggers;
alter table T_UR_EXAM_QUESTION disable all triggers;
alter table T_UR_EXAM_QUESTION_REL disable all triggers;
alter table T_UR_EXAM_RESULT disable all triggers;
alter table T_UR_EXAM_TYPE disable all triggers;
alter table T_UR_FAQ disable all triggers;
alter table T_UR_FAQ_FILE disable all triggers;
alter table T_UR_FAQ_FILE_REL disable all triggers;
alter table T_UR_FAQ_IMG disable all triggers;
alter table T_UR_FAQ_IMG_REL disable all triggers;
alter table T_UR_FAQ_INTEREST disable all triggers;
alter table T_UR_FAQ_STORE disable all triggers;
alter table T_UR_FAQ_TMP_HOT_NEW disable all triggers;
alter table T_UR_FAQ_TYPE disable all triggers;
alter table T_UR_LEAVE_MSG_TO_ADMIN disable all triggers;
alter table T_UR_LEAVE_MSG_TO_FAQ disable all triggers;
alter table T_UR_LISTEN_LOG disable all triggers;
alter table T_UR_MSG disable all triggers;
alter table T_UR_NOT_TO_MATCH_LOG disable all triggers;
alter table T_UR_PROPER_NOUN disable all triggers;
alter table T_UR_SEARCH_LOG disable all triggers;
alter table T_UR_SPECIAL_SHOP disable all triggers;
alter table T_UR_USER disable all triggers;
alter table T_UR_USER_POWER disable all triggers;
alter table T_UR_USER_ROLE disable all triggers;
alter table T_UR_USER_ROLE_POWER disable all triggers;
alter table T_UR_USER_ROLE_REL disable all triggers;
commit;
alter table T_UR_BASE_CONFIG enable all triggers;
alter table T_UR_CAR_MODEL enable all triggers;
alter table T_UR_CAR_PRODUCT_CONFIG enable all triggers;
alter table T_UR_EXAM enable all triggers;
alter table T_UR_EXAM_QUESTION enable all triggers;
alter table T_UR_EXAM_QUESTION_REL enable all triggers;
alter table T_UR_EXAM_RESULT enable all triggers;
alter table T_UR_EXAM_TYPE enable all triggers;
alter table T_UR_FAQ enable all triggers;
alter table T_UR_FAQ_FILE enable all triggers;
alter table T_UR_FAQ_FILE_REL enable all triggers;
alter table T_UR_FAQ_IMG enable all triggers;
alter table T_UR_FAQ_IMG_REL enable all triggers;
alter table T_UR_FAQ_INTEREST enable all triggers;
alter table T_UR_FAQ_STORE enable all triggers;
alter table T_UR_FAQ_TMP_HOT_NEW enable all triggers;
alter table T_UR_FAQ_TYPE enable all triggers;
alter table T_UR_LEAVE_MSG_TO_ADMIN enable all triggers;
alter table T_UR_LEAVE_MSG_TO_FAQ enable all triggers;
alter table T_UR_LISTEN_LOG enable all triggers;
alter table T_UR_MSG enable all triggers;
alter table T_UR_NOT_TO_MATCH_LOG enable all triggers;
alter table T_UR_PROPER_NOUN enable all triggers;
alter table T_UR_SEARCH_LOG enable all triggers;
alter table T_UR_SPECIAL_SHOP enable all triggers;
alter table T_UR_USER enable all triggers;
alter table T_UR_USER_POWER enable all triggers;
alter table T_UR_USER_ROLE enable all triggers;
alter table T_UR_USER_ROLE_POWER enable all triggers;
alter table T_UR_USER_ROLE_REL enable all triggers;
