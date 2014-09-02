delete from T_UR_FAQ_TYPE;
commit;
insert into T_UR_FAQ_TYPE (id, faq_type_code, faq_type_name, faq_type_desc, parent_id, create_user_id, create_user_name, update_user_id, update_user_name, add_datetime, update_datetime, enable, sort)
values ('000002', '-1', '销售信息', null, '-1', null, null, null, null, to_timestamp('26-08-2014 07:20:47.062000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('26-08-2014 07:20:47.062000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1, null);
insert into T_UR_FAQ_TYPE (id, faq_type_code, faq_type_name, faq_type_desc, parent_id, create_user_id, create_user_name, update_user_id, update_user_name, add_datetime, update_datetime, enable, sort)
values ('00000101', '00000101', '企业简介', null, '000001', '000001', 'yanghao', null, null, to_timestamp('26-08-2014 17:18:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), null, 1, null);
insert into T_UR_FAQ_TYPE (id, faq_type_code, faq_type_name, faq_type_desc, parent_id, create_user_id, create_user_name, update_user_id, update_user_name, add_datetime, update_datetime, enable, sort)
values ('00000102', '00000102', '企业新闻', null, '000001', '000001', 'yanghao', null, null, to_timestamp('26-08-2014 17:18:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), null, 1, null);
insert into T_UR_FAQ_TYPE (id, faq_type_code, faq_type_name, faq_type_desc, parent_id, create_user_id, create_user_name, update_user_id, update_user_name, add_datetime, update_datetime, enable, sort)
values ('00000201', '00000201', '车辆配置', null, '000002', '000001', 'yanghao', null, null, to_timestamp('26-08-2014 17:18:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), null, 1, null);
insert into T_UR_FAQ_TYPE (id, faq_type_code, faq_type_name, faq_type_desc, parent_id, create_user_id, create_user_name, update_user_id, update_user_name, add_datetime, update_datetime, enable, sort)
values ('00000202', '00000202', '预约试驾', null, '000002', null, null, null, null, to_timestamp('26-08-2014 17:18:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), null, 1, null);
insert into T_UR_FAQ_TYPE (id, faq_type_code, faq_type_name, faq_type_desc, parent_id, create_user_id, create_user_name, update_user_id, update_user_name, add_datetime, update_datetime, enable, sort)
values ('00000301', '00000301', '车主手册', null, '000003', null, null, null, null, to_timestamp('26-08-2014 17:18:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), null, 1, null);
insert into T_UR_FAQ_TYPE (id, faq_type_code, faq_type_name, faq_type_desc, parent_id, create_user_id, create_user_name, update_user_id, update_user_name, add_datetime, update_datetime, enable, sort)
values ('00000302', '00000302', '预约维保', null, '000003', null, null, null, null, to_timestamp('26-08-2014 17:18:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), null, 1, null);
insert into T_UR_FAQ_TYPE (id, faq_type_code, faq_type_name, faq_type_desc, parent_id, create_user_id, create_user_name, update_user_id, update_user_name, add_datetime, update_datetime, enable, sort)
values ('000003', '-1', '售后信息', null, '-1', null, null, null, null, to_timestamp('26-08-2014 07:20:50.314000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('26-08-2014 07:23:55.421000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1, null);
insert into T_UR_FAQ_TYPE (id, faq_type_code, faq_type_name, faq_type_desc, parent_id, create_user_id, create_user_name, update_user_id, update_user_name, add_datetime, update_datetime, enable, sort)
values ('000001', '-1', '品牌信息', null, '-1', null, null, null, null, to_timestamp('26-08-2014 19:45:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('26-08-2014 19:45:55.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1, null);
commit;