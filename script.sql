/*
 Navicat Premium Data Transfer

 Source Server         : pttk-httt
 Source Server Type    : PostgreSQL
 Source Server Version : 150006 (150006)
 Source Host           : dpg-co1flb6ct0pc73dbnh5g-a.singapore-postgres.render.com:5432
 Source Catalog        : restaurant_management_a76y
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 150006 (150006)
 File Encoding         : 65001

 Date: 15/05/2024 16:56:26
*/


-- ----------------------------
-- Sequence structure for tb_categories_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tb_categories_id_seq";
CREATE SEQUENCE "public"."tb_categories_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tb_detail_import_bill_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tb_detail_import_bill_id_seq";
CREATE SEQUENCE "public"."tb_detail_import_bill_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tb_detail_order_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tb_detail_order_id_seq";
CREATE SEQUENCE "public"."tb_detail_order_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tb_detail_recipe_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tb_detail_recipe_id_seq";
CREATE SEQUENCE "public"."tb_detail_recipe_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tb_import_bill_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tb_import_bill_id_seq";
CREATE SEQUENCE "public"."tb_import_bill_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tb_ingredients_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tb_ingredients_id_seq";
CREATE SEQUENCE "public"."tb_ingredients_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tb_invoices_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tb_invoices_id_seq";
CREATE SEQUENCE "public"."tb_invoices_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tb_menu_item_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tb_menu_item_id_seq";
CREATE SEQUENCE "public"."tb_menu_item_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tb_orders_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tb_orders_id_seq";
CREATE SEQUENCE "public"."tb_orders_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tb_supplier_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tb_supplier_id_seq";
CREATE SEQUENCE "public"."tb_supplier_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tb_tables_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tb_tables_id_seq";
CREATE SEQUENCE "public"."tb_tables_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tb_users_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tb_users_id_seq";
CREATE SEQUENCE "public"."tb_users_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for __EFMigrationsHistory
-- ----------------------------
DROP TABLE IF EXISTS "public"."__EFMigrationsHistory";
CREATE TABLE "public"."__EFMigrationsHistory" (
  "MigrationId" varchar(150) COLLATE "pg_catalog"."default" NOT NULL,
  "ProductVersion" varchar(32) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of __EFMigrationsHistory
-- ----------------------------
INSERT INTO "public"."__EFMigrationsHistory" VALUES ('20240305164657_update-database', '7.0.15');
INSERT INTO "public"."__EFMigrationsHistory" VALUES ('20240320040646_database_v1', '7.0.15');
INSERT INTO "public"."__EFMigrationsHistory" VALUES ('20240320044546_database_v2', '7.0.15');
INSERT INTO "public"."__EFMigrationsHistory" VALUES ('20240414051133_database_v3', '7.0.15');
INSERT INTO "public"."__EFMigrationsHistory" VALUES ('20240414051613_database_v4', '7.0.15');

-- ----------------------------
-- Table structure for tb_categories
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_categories";
CREATE TABLE "public"."tb_categories" (
  "id" int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1
),
  "name" text COLLATE "pg_catalog"."default" NOT NULL,
  "des" text COLLATE "pg_catalog"."default" NOT NULL,
  "isdeleted" bool NOT NULL
)
;

-- ----------------------------
-- Records of tb_categories
-- ----------------------------
INSERT INTO "public"."tb_categories" VALUES (638471313852664844, 'Món phụ', 'MONPHU', 'f');
INSERT INTO "public"."tb_categories" VALUES (638471313853280599, 'Đồ uống', 'DOUONG', 'f');
INSERT INTO "public"."tb_categories" VALUES (638471313852228536, 'Món chính', 'MONCHINH', 'f');
INSERT INTO "public"."tb_categories" VALUES (638471313852958317, 'Tráng ', 'TRANG MIENG', 'f');
INSERT INTO "public"."tb_categories" VALUES (1715324096321, 'Khai vị', 'Khai vi', 't');
INSERT INTO "public"."tb_categories" VALUES (1715566288686, 'Khai vị', 'KHAI VI', 'f');

-- ----------------------------
-- Table structure for tb_detail_import_bill
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_detail_import_bill";
CREATE TABLE "public"."tb_detail_import_bill" (
  "id" int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1
),
  "quantity" int4 NOT NULL,
  "price" float8 NOT NULL,
  "total" float8 NOT NULL,
  "billid" int8,
  "ingredientid" int8,
  "isdeleted" bool
)
;

-- ----------------------------
-- Records of tb_detail_import_bill
-- ----------------------------
INSERT INTO "public"."tb_detail_import_bill" VALUES (1839006153, 50, 5500, 275000, 1838994384, 1753363165, 'f');
INSERT INTO "public"."tb_detail_import_bill" VALUES (1839015832, 120, 20, 2400, 1838994384, 1752987656, 'f');
INSERT INTO "public"."tb_detail_import_bill" VALUES (1234, 50, 5500, 275000, 123124, 1753363165, 'f');
INSERT INTO "public"."tb_detail_import_bill" VALUES (4321, 120, 20, 2400, 123124, 1752987656, 'f');

-- ----------------------------
-- Table structure for tb_detail_order
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_detail_order";
CREATE TABLE "public"."tb_detail_order" (
  "id" int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1
),
  "price" float8 NOT NULL,
  "profit" float8 NOT NULL,
  "quantity" int4 NOT NULL,
  "total" float8 NOT NULL,
  "isdeleted" bool NOT NULL,
  "itemid" int8,
  "orderid" int8,
  "invoiceid" int8
)
;

-- ----------------------------
-- Records of tb_detail_order
-- ----------------------------
INSERT INTO "public"."tb_detail_order" VALUES (1715508761317, 260000, 260000, 1, 260000, 'f', 638471313961204791, 1715508761317, 1715565943653);
INSERT INTO "public"."tb_detail_order" VALUES (1715508761320, 500000, 500000, 1, 500000, 'f', 638471313957515503, 1715508761317, 1715565943653);
INSERT INTO "public"."tb_detail_order" VALUES (1715508761322, 8000, 8000, 1, 8000, 'f', 638471313977696847, 1715508761317, 1715565943653);
INSERT INTO "public"."tb_detail_order" VALUES (1715490622301, 260000, 260000, 2, 520000, 'f', 638471313961204791, 1715490622301, 1715568798811);
INSERT INTO "public"."tb_detail_order" VALUES (1715582774149, 60000, 60000, 1, 60000, 'f', 638471313974137701, 1715582774149, 1715582833186);
INSERT INTO "public"."tb_detail_order" VALUES (1715585783996, 260000, 260000, 3, 780000, 'f', 638471313961204791, 1715585783996, NULL);
INSERT INTO "public"."tb_detail_order" VALUES (1715585558462, 260000, 260000, 100, 2860000, 'f', 638471313961204791, 1715585558462, 1715586992138);
INSERT INTO "public"."tb_detail_order" VALUES (1715585668094, 50000, 50000, 9, 450000, 'f', 638471313973299466, 1715585668094, 1715586992138);
INSERT INTO "public"."tb_detail_order" VALUES (1715609205559, 100000, 100000, 1, 100000, 'f', 638471313967006849, 1715609205559, NULL);
INSERT INTO "public"."tb_detail_order" VALUES (1715609205563, 1200000, 1200000, 1, 1200000, 'f', 638471313962101643, 1715609205559, NULL);
INSERT INTO "public"."tb_detail_order" VALUES (1715569220623, 260000, 260000, 2, 520000, 'f', 638471313961204791, 1715569220623, NULL);
INSERT INTO "public"."tb_detail_order" VALUES (1715569220625, 500000, 500000, 2, 1000000, 'f', 638471313957515503, 1715569220623, NULL);
INSERT INTO "public"."tb_detail_order" VALUES (1715569220627, 8000, 8000, 2, 16000, 'f', 638471313977696847, 1715569220623, NULL);
INSERT INTO "public"."tb_detail_order" VALUES (1715490622208, 260000, 260000, 2, 520000, 'f', 638471313961204791, 1715490622208, 1715569699326);
INSERT INTO "public"."tb_detail_order" VALUES (1715568902181, 500000, 500000, 1, 500000, 'f', 638471313957515503, 1715568902181, 1715569699326);
INSERT INTO "public"."tb_detail_order" VALUES (1715568902183, 8000, 8000, 1, 8000, 'f', 638471313977696847, 1715568902181, 1715569699326);
INSERT INTO "public"."tb_detail_order" VALUES (1715568902185, 30000, 30000, 1, 30000, 'f', 638471313969674607, 1715568902181, 1715569699326);
INSERT INTO "public"."tb_detail_order" VALUES (1715490665950, 500000, 500000, 1, 500000, 'f', 638471313957515503, 1715490665950, 1715569699326);
INSERT INTO "public"."tb_detail_order" VALUES (1715490665952, 8000, 8000, 1, 8000, 'f', 638471313977696847, 1715490665950, 1715569699326);
INSERT INTO "public"."tb_detail_order" VALUES (1715505448123, 260000, 260000, 1, 260000, 'f', 638471313961204791, 1715505448123, 1715569699326);
INSERT INTO "public"."tb_detail_order" VALUES (1715505448138, 500000, 500000, 2, 1000000, 'f', 638471313957515503, 1715505448123, 1715569699326);
INSERT INTO "public"."tb_detail_order" VALUES (1715502631722, 500000, 500000, 1, 500000, 'f', 638471313957515503, 1715502631722, 1715502649226);
INSERT INTO "public"."tb_detail_order" VALUES (1715505448154, 8000, 8000, 2, 16000, 'f', 638471313977696847, 1715505448123, 1715569699326);
INSERT INTO "public"."tb_detail_order" VALUES (1715609205689, 100000, 100000, 1, 100000, 'f', 638471313967006849, 1715609205689, NULL);
INSERT INTO "public"."tb_detail_order" VALUES (1715609205704, 1200000, 1200000, 1, 1200000, 'f', 638471313962101643, 1715609205689, NULL);
INSERT INTO "public"."tb_detail_order" VALUES (1715609205831, 100000, 100000, 1, 100000, 'f', 638471313967006849, 1715609205831, NULL);
INSERT INTO "public"."tb_detail_order" VALUES (1715609205833, 1200000, 1200000, 1, 1200000, 'f', 638471313962101643, 1715609205831, NULL);
INSERT INTO "public"."tb_detail_order" VALUES (1715765852364, 260000, 260000, 2, 520000, 'f', 638471313961204791, 1715765852364, NULL);
INSERT INTO "public"."tb_detail_order" VALUES (1715569982919, 30000, 30000, 2, 60000, 'f', 638471313969674607, 1715569982919, 1715570113356);
INSERT INTO "public"."tb_detail_order" VALUES (1715569899211, 8000, 8000, 1, 8000, 'f', 638471313977696847, 1715569899211, 1715570113356);
INSERT INTO "public"."tb_detail_order" VALUES (1715569899215, 500000, 500000, 2, 1000000, 'f', 638471313957515503, 1715569899211, 1715570113356);
INSERT INTO "public"."tb_detail_order" VALUES (1715569899218, 30000, 30000, 2, 60000, 'f', 638471313969674607, 1715569899211, 1715570113356);
INSERT INTO "public"."tb_detail_order" VALUES (1715569794310, 60000, 60000, 2, 120000, 'f', 638471313974137701, 1715569794310, 1715570216187);
INSERT INTO "public"."tb_detail_order" VALUES (1715569794312, 300000, 300000, 2, 600000, 'f', 638471313958568718, 1715569794310, 1715570216187);
INSERT INTO "public"."tb_detail_order" VALUES (1715569794314, 10000, 10000, 2, 20000, 'f', 638471313979439968, 1715569794310, 1715570216187);
INSERT INTO "public"."tb_detail_order" VALUES (1715569746420, 10000, 10000, 2, 20000, 'f', 638471313979439968, 1715569746420, 1715581180949);
INSERT INTO "public"."tb_detail_order" VALUES (1715569746423, 300000, 300000, 2, 600000, 'f', 638471313958568718, 1715569746420, 1715581180949);
INSERT INTO "public"."tb_detail_order" VALUES (1715569746425, 60000, 60000, 2, 120000, 'f', 638471313974137701, 1715569746420, 1715581180949);
INSERT INTO "public"."tb_detail_order" VALUES (1715508906447, 260000, 260000, 1, 260000, 'f', 638471313961204791, 1715508906447, 1715581191881);
INSERT INTO "public"."tb_detail_order" VALUES (1715508846079, 260000, 260000, 1, 260000, 'f', 638471313961204791, 1715508846079, 1715581201697);
INSERT INTO "public"."tb_detail_order" VALUES (1715508846094, 500000, 500000, 2, 1000000, 'f', 638471313957515503, 1715508846079, 1715581201697);
INSERT INTO "public"."tb_detail_order" VALUES (1715508846110, 8000, 8000, 0, 0, 'f', 638471313977696847, 1715508846079, 1715581201697);
INSERT INTO "public"."tb_detail_order" VALUES (1715581407592, 8000, 8000, 2, 16000, 'f', 638471313977696847, 1715581407592, 1715581413110);

-- ----------------------------
-- Table structure for tb_detail_recipe
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_detail_recipe";
CREATE TABLE "public"."tb_detail_recipe" (
  "id" int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1
),
  "quantity" numeric NOT NULL,
  "unit" text COLLATE "pg_catalog"."default" NOT NULL,
  "ingredientid" int8,
  "isdeleted" bool,
  "itemid" int8
)
;

-- ----------------------------
-- Records of tb_detail_recipe
-- ----------------------------
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488333596, 1, 'kg', 1752964258, 'f', 638471313961204791);
INSERT INTO "public"."tb_detail_recipe" VALUES (123, 1, 'kg', 1759180548, 'f', 638471313961204791);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488349269, 1, 'kg', 1752987656, 'f', 638471313957515503);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488358462, 1, 'lon', 1753023238, 'f', 638471313977696847);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488367914, 1, 'kg', 1753069733, 'f', 638471313969674607);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488378563, 1, 'kg', 1753085230, 'f', 638471313958568718);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488387176, 1, 'kg', 1753108997, 'f', 638471313967006849);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488410096, 1, 'kg', 1753127437, 'f', 638471313960312870);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488425984, 1, 'kg', 1753747766, 'f', 638471313966137902);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488437980, 1, 'kg', 1753689315, 'f', 638471313967871051);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488451498, 1, 'kg', 1753663069, 'f', 638471313976835394);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488466285, 1, 'kg', 1753591614, 'f', 638471313976035634);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488493842, 1, 'phần', 1753576206, 'f', 638471313974137701);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488519283, 1, 'kg', 1753551293, 'f', 638471313971523156);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488525802, 1, 'kg', 1753532966, 'f', 638471313968764096);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488539593, 1, 'kg', 1753514413, 'f', 638471313963965173);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488550778, 1, 'phần', 1753496902, 'f', 638471313972465143);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488565926, 1, 'kg', 1753466086, 'f', 638471313962972762);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488597888, 1, 'kg', 1753155541, 'f', 638471313959465856);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488612522, 1, 'kg', 1753298045, 'f', 638471313955174431);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488632560, 1, 'kg', 1753281046, 'f', 638471313970657208);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488647537, 1, 'kg', 1753313845, 'f', 638471313962101643);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488662202, 1, 'kg', 1753331542, 'f', 638471313973299466);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488669768, 1, 'lon', 1753428461, 'f', 638471313978526168);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488676642, 1, 'kg', 1753444038, 'f', 638471313974989268);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488704081, 1, 'lon', 1753170933, 'f', 638471313979439968);
INSERT INTO "public"."tb_detail_recipe" VALUES (1715488736658, 1, 'kg', 1753363165, 'f', 638471313965292130);

-- ----------------------------
-- Table structure for tb_discounts
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_discounts";
CREATE TABLE "public"."tb_discounts" (
  "id" text COLLATE "pg_catalog"."default" NOT NULL,
  "name" text COLLATE "pg_catalog"."default" NOT NULL,
  "description" text COLLATE "pg_catalog"."default" NOT NULL,
  "minimum" int4 NOT NULL,
  "remaining" int4 NOT NULL,
  "value" float8 NOT NULL,
  "type" text COLLATE "pg_catalog"."default" NOT NULL,
  "expired_time" timestamp(6) NOT NULL,
  "isdeleted" bool NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL
)
;

-- ----------------------------
-- Records of tb_discounts
-- ----------------------------
INSERT INTO "public"."tb_discounts" VALUES ('125', 'Tết', 'Tết nha', 500000, 12, 20, 'percent', '2024-04-30 11:13:50', 'f', '2024-04-18 11:13:55', '2024-04-18 11:13:59');
INSERT INTO "public"."tb_discounts" VALUES ('124', 'Giỗ tổ Hùng Vương', 'Giỗ tổ Hùng Vương', 10000000, 999, 1000000, 'currency', '2024-04-29 11:13:10', 'f', '2024-04-18 11:13:14', '2024-04-18 11:13:16');
INSERT INTO "public"."tb_discounts" VALUES ('1714492800242', '333', '3333333', 33, 3, 3, 'currency', '2024-05-01 00:00:00', 't', '2024-04-30 23:00:00.242', '2024-04-30 23:14:13.972');
INSERT INTO "public"."tb_discounts" VALUES ('1714492605003', '123', '123', 123, 123, 123, 'currency', '2024-04-30 00:00:00', 't', '2024-04-30 22:56:45.005', '2024-04-30 23:14:54.215');
INSERT INTO "public"."tb_discounts" VALUES ('123', '123', '123', 123, 123, -100, 'currency', '2024-05-19 00:00:00', 't', '2024-02-08 21:33:25', '2024-05-13 08:55:30.746');
INSERT INTO "public"."tb_discounts" VALUES ('1715324303872', 'a', 'a', 12313, 12, -12, 'currency', '2024-05-17 00:00:00', 't', '2024-05-10 13:58:23.872', '2024-05-13 08:55:33.711');
INSERT INTO "public"."tb_discounts" VALUES ('1715575761355', 'aaa', 'aa', 12000, 12, -12, 'percent', '2024-05-31 00:00:00', 't', '2024-05-13 11:49:21.355', '2024-05-13 11:51:07.13');
INSERT INTO "public"."tb_discounts" VALUES ('1715575732320', 'fjshdfhs', 'áda', 400000, 12, 120, 'percent', '2024-05-16 00:00:00', 't', '2024-05-13 11:48:52.32', '2024-05-13 11:51:11.48');
INSERT INTO "public"."tb_discounts" VALUES ('1715565324303', 'a', 'czxc', 12000, 12, 200, 'percent', '2024-05-31 00:00:00', 't', '2024-05-13 08:55:24.303', '2024-05-13 11:51:16.558');
INSERT INTO "public"."tb_discounts" VALUES ('1714978695096', 'fjshdfhs', 'áda', 400000, 12, 120, 'percent', '2024-05-16 00:00:00', 't', '2024-05-06 13:58:15.098', '2024-05-13 11:51:21.683');
INSERT INTO "public"."tb_discounts" VALUES ('1715444209201', 'a', 'a', 12313, 12, 200, 'percent', '2024-05-17 00:00:00', 't', '2024-05-11 23:16:49.203', '2024-05-13 11:51:27.32');
INSERT INTO "public"."tb_discounts" VALUES ('1715575937714', 'qqq', 'aaa', 12000, 12, 80, 'percent', '2024-05-25 00:00:00', 'f', '2024-05-13 11:52:17.714', '2024-05-13 11:52:17.714');
INSERT INTO "public"."tb_discounts" VALUES ('1715576030997', 'aaa', 'aaa', 13660, 12, 50, 'percent', '2024-05-26 00:00:00', 'f', '2024-05-13 11:53:50.997', '2024-05-13 11:53:50.997');
INSERT INTO "public"."tb_discounts" VALUES ('1715581095854', 'aaaaaaa', 'aaaaaaaaa', 100000, 123, 122, 'currency', '2024-05-14 00:00:00', 'f', '2024-05-13 13:18:15.854', '2024-05-13 13:18:15.854');

-- ----------------------------
-- Table structure for tb_import_bill
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_import_bill";
CREATE TABLE "public"."tb_import_bill" (
  "id" int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1
),
  "quantity" int4 NOT NULL,
  "total" float8 NOT NULL,
  "import_date" timestamp(6) NOT NULL,
  "staffid" int8 NOT NULL,
  "supplierid" int8 NOT NULL,
  "isdeleted" bool NOT NULL
)
;

-- ----------------------------
-- Records of tb_import_bill
-- ----------------------------
INSERT INTO "public"."tb_import_bill" VALUES (1838994384, 3, 10520, '2024-05-13 00:00:00', 123, 2, 'f');
INSERT INTO "public"."tb_import_bill" VALUES (123124, 6, 20540, '2024-05-13 00:00:00', 123, 2, 'f');

-- ----------------------------
-- Table structure for tb_ingredients
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_ingredients";
CREATE TABLE "public"."tb_ingredients" (
  "id" int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1
),
  "name" text COLLATE "pg_catalog"."default" NOT NULL,
  "des" text COLLATE "pg_catalog"."default" NOT NULL,
  "quantity" numeric NOT NULL,
  "unit" text COLLATE "pg_catalog"."default" NOT NULL,
  "isdeleted" bool NOT NULL
)
;

-- ----------------------------
-- Records of tb_ingredients
-- ----------------------------
INSERT INTO "public"."tb_ingredients" VALUES (1759180548, 'Bom nguyên tử', 'nổ', 12, 'yeee', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753428461, 'Pepsi', 'nước giải khát', 20, 'lon', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753532966, 'Mì cay Hàn Quốc', 'Mì cay', 110, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1759212013, 'Bom hạt nhân', 'nổ', 0, 'kg', 't');
INSERT INTO "public"."tb_ingredients" VALUES (1759356693, 'Uranium 238', 'Uranium 238', 0, 'kg', 't');
INSERT INTO "public"."tb_ingredients" VALUES (1759229084, 'B52', 'máy bay ném bom', 0, 'chiếc', 't');
INSERT INTO "public"."tb_ingredients" VALUES (1753663069, 'Trà tắc mật ong', 'nước giải khát', 70, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1760422109, 'Moonlight greatsword', 'Greatsword', 1, 'cây', 't');
INSERT INTO "public"."tb_ingredients" VALUES (1760438934, 'Moonveil', 'Katana', 1, 'cây', 't');
INSERT INTO "public"."tb_ingredients" VALUES (1753155541, 'Tôm sốt Mayonese trái thơm', 'Tôm sốt', 50, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753281046, 'Chè khúc bạch', 'chè', 20, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753298045, 'Bò Hầm sốt vang', 'Bò hầm', 10, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1870593356, 'Tài hai lúa', 'đẹp trai', 0, 'Tài', 't');
INSERT INTO "public"."tb_ingredients" VALUES (1753444038, 'Cam vắt', 'nước giải khát', 20, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753466086, 'Heo sữa quay da giòn', 'heo sữa quay', 30, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753496902, 'Panna Cotta Caramel', 'tráng miệng', 30, 'phần', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753514413, 'Sụn gà chiên nước mắm', 'Sụn gà chiên', 30, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753551293, 'Trái cây nhiệt đới', 'tráng miệng', 40, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753591614, 'Nước ép chanh dây', 'giải khát', 40, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753127437, 'Vịt quay bắc kinh', 'vịt quay', 82, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753689315, 'Khoai tây chiên', 'khai vị', 50, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753747766, 'Tôm lăn bột chiên giòn', 'Tôm chiên', 50, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1752987656, 'Cá tai tượng chiên giòn', 'cá chiên', 620, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753085230, 'Beefsteak sốt tiêu đen', 'beefsteak', 113, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753170933, 'Bia Heneiken', 'Bia', 6, 'lon', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753363165, 'Mực chiên giòn', 'Mực chiên', 310, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753108997, 'Cơm hải sản', 'Cơm hải sản', 67, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753069733, 'Kem trái cây', 'kem', 65, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753313845, 'Cua hoàng đế hấp bia', 'Cua hấp', 7, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753023238, 'Coca Cola', 'nước giải khát', 43, 'lon', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753576206, 'Bánh Tiramisu', 'tráng miệng', 35, 'phần', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1752964258, 'Lẩu Tôm Yum hải sản', 'lẩu', 160, 'kg', 'f');
INSERT INTO "public"."tb_ingredients" VALUES (1753331542, 'Mochi trái cây', 'Bánh Mochi', 168, 'kg', 'f');

-- ----------------------------
-- Table structure for tb_invoices
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_invoices";
CREATE TABLE "public"."tb_invoices" (
  "id" int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1
),
  "amount" float8 NOT NULL,
  "discount_price" float8 NOT NULL,
  "total" float8 NOT NULL,
  "isdeleted" bool NOT NULL,
  "time" timestamp(6) NOT NULL,
  "discountid" text COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of tb_invoices
-- ----------------------------
INSERT INTO "public"."tb_invoices" VALUES (1714979851580, 100000, 0, 100000, 'f', '2024-05-06 14:17:31.58', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715130624907, 40000, 0, 40000, 'f', '2024-05-08 08:10:24.907', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715130639227, 100000, 0, 100000, 'f', '2024-05-08 08:10:39.227', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715130664054, 180000, 0, 180000, 'f', '2024-05-08 08:11:04.054', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715130676992, 300000, 0, 300000, 'f', '2024-05-08 08:11:16.992', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715130686986, 80000, 0, 80000, 'f', '2024-05-08 08:11:26.986', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715130698477, 60000, 0, 60000, 'f', '2024-05-08 08:11:38.477', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715130708084, 60000, 0, 60000, 'f', '2024-05-08 08:11:48.084', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715502649226, 500000, 0, 500000, 'f', '2024-05-12 15:30:49', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715565943653, 768000, 0, 768000, 'f', '2024-05-13 09:05:43.653', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715568798811, 1040000, 0, 1040000, 'f', '2024-05-12 09:53:18', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715569699326, 2842000, 0, 2842000, 'f', '2024-05-13 10:08:19.326', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715570113356, 1128000, 0, 1128000, 'f', '2024-05-13 10:15:13.356', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715570216187, 740000, 148000, 592000, 'f', '2024-05-13 10:16:56.187', '125');
INSERT INTO "public"."tb_invoices" VALUES (1715581180949, 740000, 0, 740000, 'f', '2024-05-13 13:19:40.949', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715581191881, 260000, 0, 260000, 'f', '2024-05-13 13:19:51.881', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715581201697, 1260000, 0, 1260000, 'f', '2024-05-13 13:20:01.697', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715581413110, 16000, 0, 16000, 'f', '2024-05-13 13:23:33.11', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715582833186, 60000, 0, 60000, 'f', '2024-05-13 13:47:13.186', NULL);
INSERT INTO "public"."tb_invoices" VALUES (1715586992138, 3310000, 0, 3310000, 'f', '2024-05-13 14:56:32.138', NULL);

-- ----------------------------
-- Table structure for tb_menu_item
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_menu_item";
CREATE TABLE "public"."tb_menu_item" (
  "id" int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1
),
  "name" text COLLATE "pg_catalog"."default" NOT NULL,
  "description" text COLLATE "pg_catalog"."default" NOT NULL,
  "image_path" text COLLATE "pg_catalog"."default" NOT NULL,
  "price" float8 NOT NULL,
  "profit" float8 NOT NULL,
  "isdeleted" bool NOT NULL,
  "statusid" text COLLATE "pg_catalog"."default",
  "categoryid" int8,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL
)
;

-- ----------------------------
-- Records of tb_menu_item
-- ----------------------------
INSERT INTO "public"."tb_menu_item" VALUES (638471313957515503, 'Cá tai tượng chiên gòn', 'Món Cá Tai Tượng Chiên Giòn là một trải nghiệm ẩm thực độc đáo tại nhà hàng chúng tôi. Những chiếc cá tai tượng tươi ngon được chiên giòn đến vàng óng, tạo nên lớp vỏ giòn tan kết hợp với bên trong mềm mại và thơm ngon', 'cataituongchienxu.jpg', 500000, 500000, 'f', 'SANSANG', 638471313852228536, '2024-03-27 10:16:35.751552', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313961204791, 'Lẩu Tom Yum hải sản', 'Lẩu Tom Yum Hải Sản tại nhà hàng chúng tôi là một hòa quyện tuyệt vời giữa hương vị tươi ngon của hải sản và hương thơm đặc trưng của nước lẩu Tom Yum. Sự kết hợp này tạo nên một bữa ăn ngon miệng và đậm đà, làm hài lòng các thực khách yêu thích ẩm thực Đông Nam Á.', 'lautomyumhaisan.jpg', 260000, 260000, 'f', 'SANSANG', 638471313852228536, '2024-03-27 10:16:36.12048', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313977696847, 'Cocacola', 'Coca-Cola không chỉ là một đồ uống phổ biến và thơm ngon mà còn là nguồn cảm hứng cho nhiều biến thể khác nhau như coca-cola với chanh, coca-cola với đá, hoặc các cocktail phức tạp hơn. Đây là một lựa chọn thưởng thức giải khát và tận hưởng mọi khoảnh khắc.', 'coca.jpg', 8000, 8000, 'f', 'SANSANG', 638471313853280599, '2024-03-27 10:16:37.769686', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313969674607, 'Kem trái cây', 'Món Kem Trái Cây là một lựa chọn hoàn hảo cho những ai yêu thích sự kết hợp giữa vị ngọt, tươi mới và nhẹ nhàng. Thưởng thức món ăn này, bạn sẽ được đắm chìm trong hương vị thơm ngon và tinh tế, tạo nên một kết thúc hoàn hảo cho bữa ăn.', 'kemtraicay.jpg', 30000, 30000, 'f', 'SANSANG', 638471313852958317, '2024-03-27 10:16:36.967462', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313959465856, 'Tôm sốt mayonese trái thơm', 'Món Tôm Sốt Mayonnaise Trái Thơm tại nhà hàng chúng tôi là một sự kết hợp tinh tế giữa hương vị tươi ngon của tôm biển và sự thơm ngon của trái cây thơm. Những con tôm tươi ngon được ướp sốt mayonnaise, tạo nên lớp vỏ hấp dẫn, kết hợp với trái thơm tạo nên sự phong phú và tươi mới đặc biệt.', 'tomsotmayonese.jpg', 600000, 600000, 'f', 'SANSANG', 638471313852228536, '2024-03-27 10:16:35.946588', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313967006849, 'Cơm chiên hải sản', 'Cơm Chiên Hải Sản tại nhà hàng chúng tôi là một tác phẩm nghệ thuật ẩm thực, kết hợp hài hòa giữa hương vị đậm đà của cơm chiên và sự tươi ngon của hải sản. Mỗi hạt cơm được chiên giòn và hòa quyện với hải sản đa dạng, tạo nên một bữa ăn ngon miệng và đa dạng.', 'comchienhaisan.jpg', 100000, 100000, 'f', 'SANSANG', 638471313852664844, '2024-03-27 10:16:36.700686', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313962101643, 'Cua hoàng đế hấp bia', 'Món Cua Hoàng Đế Hấp Bia không chỉ là một món biểu tượng của hương vị biển cả mà còn là sự hòa quyện tuyệt vời giữa hương thơm độc đáo của bia và vị ngon của cua. Mỗi miếng cua hấp kết hợp hài hòa với hương vị nồng nàn từ bia, mang lại trải nghiệm ẩm thực đặc sắc và sang trọng.', 'cuahoangdehapbia.jpg', 1200000, 1200000, 'f', 'SANSANG', 638471313852228536, '2024-03-27 10:16:36.210166', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313960312870, 'Vịt quay Bắc Kinh', 'Món Vịt Quay Bắc Kinh tại nhà hàng chúng tôi là một hòa quyện tuyệt vời giữa vị béo ngậy của thịt vịt và hương vị đặc trưng của phương pháp quay Bắc Kinh. Sự giữ được vị ngon của thịt vịt cùng với lớp da giòn tan là điểm đặc biệt của món ăn này.', 'vitquaybackinh.jpg', 1000000, 1000000, 'f', 'SANSANG', 638471313852228536, '2024-03-27 10:16:36.031288', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313970657208, 'Chè khúc bạch', 'Món Chè Khúc Bạch là sự hòa quyện của vị ngọt dịu từ nước cốt dừa, vị thơm mát của bánh khúc, và hương vị độc đáo từ hạt sen và đậu phộng rang. Mỗi ngụm chè là một hành trình qua vị giác và mang lại cảm giác thoải mái và ngon miệng cho thực khách.', 'chekhucbach.jpg', 25000, 25000, 'f', 'SANSANG', 638471313852958317, '2024-03-27 10:16:37.065723', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313979439968, 'Bia Heneiken', 'Heineken mang lại sự kết hợp hài hòa giữa hương vị lạnh mát và sảng khoái của bia Heineken với độ chua ngọt từ cam và chanh tươi. Mỗi giọt nước đều mang lại cảm giác tươi mới và hứng khởi, làm tăng thêm trải nghiệm thưởng thức của bạn.', 'heneiken.jpg', 10000, 10000, 'f', 'SANSANG', 638471313853280599, '2024-03-27 10:16:37.943998', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313958568718, 'Beefsteak sốt tiêu đen', 'Món Beefsteak Sốt Tiêu Đen tại nhà hàng chúng tôi là một sự kết hợp tuyệt vời giữa thịt bò tươi ngon, sốt tiêu đen hấp dẫn, trứng pate mềm mại và khoai nghiền thơm béo. Thịt bò được nướng vừa chín tới, giữ nguyên độ mềm mại và tinh tế, tạo nên sự phong phú trong khẩu vị.', 'beefsteaksottieuden.jpg', 300000, 300000, 'f', 'SANSANG', 638471313852228536, '2024-03-27 10:16:35.856874', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313955174431, 'Bò hầm sốt vang', 'Bò Hầm Sốt Vang - thịt bò mềm mại, hấp thụ hương vị độc đáo của sốt vang đỏ, kèm theo rau củ tươi ngon. Gia vị hài hòa, tạo nên trải nghiệm ẩm thực đặc sắc, hứa hẹn làm hài lòng khẩu vị của bạn.', 'bohamsotvang.jpg', 100000, 100000, 'f', 'SANSANG', 638471313852228536, '2024-03-27 10:16:35.51875', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313965292130, 'Mực chiên giòn', 'Mực Chiên Gòn tại nhà hàng chúng tôi là một sự phối hợp hài hòa giữa sự giòn rụm của mực và hương vị đặc trưng của phương pháp chiên Gòn truyền thống. Mỗi miếng mực được chiên giòn tới mức hoàn hảo, tạo nên lớp vỏ giòn và mực bên trong vẫn giữ được sự mềm mại và thơm ngon.', 'mucchiengion.jpg', 80000, 80000, 'f', 'SANSANG', 638471313852664844, '2024-03-27 10:16:36.529214', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313978526168, 'Pepsi', 'Pepsi không chỉ là một đồ uống phổ biến và thơm ngon mà còn là nguồn cảm hứng cho nhiều biến thể khác nhau như Pepsi với chanh, coca-cola với đá, hoặc các cocktail phức tạp hơn. Đây là một lựa chọn thưởng thức giải khát và tận hưởng mọi khoảnh khắc.', 'pepsi.jpg', 8000, 8000, 'f', 'SANSANG', 638471313853280599, '2024-03-27 10:16:37.852618', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313967871051, 'Khoai Tây Chiên', 'Khoai Tây Chiên tại nhà hàng chúng tôi là một món ăn giản đơn nhưng vô cùng phổ biến và phục vụ mọi lứa tuổi. Khoai tây được cắt thành từng sợi mảnh, sau đó chiên giòn để tạo nên lớp vỏ hấp dẫn và hương vị thơm ngon.', 'khoaitaychien.jpg', 50000, 50000, 'f', 'SANSANG', 638471313852664844, '2024-03-27 10:16:36.787107', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313972465143, 'Panna Cotta Caramel', 'Món Panna Cotta Caramel của chúng tôi thường được chế biến cầu kỳ, với lớp caramel mượt mà trải đều lên trên cùng của từng chiếc panna cotta. Bạn sẽ cảm nhận được sự hòa quyện tuyệt vời giữa sự ngọt ngào và béo ngậy, tạo nên một hương vị độc đáo và không thể cưỡng. Món tráng miệng này thường được trình bày trong các đồ uống tráng miệng hoặc trên bàn dessert, hứa hẹn làm say đắm vị giác của thực khách.', 'pannacottacaramel.jpg', 60000, 60000, 'f', 'SANSANG', 638471313852958317, '2024-03-27 10:16:37.246516', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313962972762, 'Heo sửa quay da giòn', 'Món Heo Sữa Quay Da Giòn không chỉ là một tác phẩm nghệ thuật ẩm thực mà còn là sự kết hợp tuyệt vời giữa vị thơm ngon của thịt heo sữa và độ giòn của lớp da quay. Thưởng thức món ăn này, thực khách sẽ được trải nghiệm hương vị độc đáo và đầy hấp dẫn.', 'heosuaquaydagion.jpg', 1000000, 1000000, 'f', 'SANSANG', 638471313852228536, '2024-03-27 10:16:36.297278', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313966137902, 'Tôm lăn bột chiên giòn', 'Tôm Lăn Bột Chiên Giòn tại nhà hàng chúng tôi là một sự kết hợp tuyệt vời giữa sự tươi ngon của tôm biển và vị giòn tan của bột chiên. Mỗi con tôm được lăn đều trong lớp bột chiên giòn, tạo nên một lớp vỏ hấp dẫn, giữ nguyên hương vị ngon và tinh tế của tôm.', 'tomlanbot.jpg', 60000, 60000, 'f', 'SANSANG', 638471313852664844, '2024-03-27 10:16:36.613792', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313971523156, 'Trái cây nhiệt đới', 'Món Trái Cây Nhiệt Đới tại nhà hàng chúng tôi là một tuyển chọn tinh tế của những loại trái cây tươi ngon, mỗi loại đều đem lại hương vị đặc trưng và dinh dưỡng đa dạng. Sự kết hợp này không chỉ là một bữa ăn ngon miệng mà còn là một chuyến phiêu lưu qua hương vị của các quốc gia nhiệt đới.', 'traicaynhietdoi.jpg', 30000, 30000, 'f', 'SANSANG', 638471313852958317, '2024-03-27 10:16:37.152317', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313976035634, 'Nước ép chanh dây', 'Món Nước Chanh Dây là một lựa chọn kh refreshing và lành mạnh, làm bổ sung năng lượng và vitamin cho cơ thể, đồng thời mang lại trải nghiệm thưởng thức thức uống tinh tế.', 'nuocepchanhday.jpg', 20000, 20000, 'f', 'SANSANG', 638471313853280599, '2024-03-27 10:16:37.603565', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313963965173, 'Sụn gà chiên nước mắm', 'Sụn Gà Chiên Nước Mắm tại nhà hàng chúng tôi là một món ăn độc đáo, kết hợp giữa sự giòn rụm của sụn gà và hương vị đậm đà của nước mắm. Mỗi miếng sụn gà được chiên giòn tới mức hoàn hảo, tạo nên lớp vỏ hấp dẫn và giữ được hương vị tinh tế của sụn gà.', 'sungachiennuocmam.jpg', 60000, 60000, 'f', 'SANSANG', 638471313852664844, '2024-03-27 10:16:36.396519', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313968764096, 'Mì Cay Hàn Quốc', 'Mì Cay Hàn Quốc tại nhà hàng chúng tôi là một món ăn thú vị và đậm đà, kết hợp giữa hương vị cay nồng và độ ngon của mì. Mỗi sợi mì được đặt trong nước dùng cay nồng, tạo nên một tác phẩm ẩm thực phản ánh đặc sắc văn hóa ẩm thực Hàn Quốc.', 'mycayhanquoc.jpg', 50000, 50000, 'f', 'SANSANG', 638471313852664844, '2024-03-27 10:16:36.876411', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313974137701, 'Bánh Tiramisu', 'Món Tiramisu tại nhà hàng chúng tôi là một tác phẩm nghệ thuật ẩm thực, kết hợp hài hòa giữa hương vị cà phê đậm đà, kem phô mai mềm mại và lớp bánh ladyfinger ẩm cách. "Ánh Tiramisu" không chỉ là một món tráng miệng thơm ngon mà còn là một trải nghiệm ẩm thực tinh tế.', 'tiramisu.jpg', 60000, 60000, 'f', 'SANSANG', 638471313852958317, '2024-03-27 10:16:37.413771', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313976835394, 'Trà tắc mật ong', 'Món Trà Tắc Mật Ong tại nhà hàng chúng tôi là sự kết hợp tuyệt vời giữa hương vị thơm ngon của trà và vị ngọt của mật ong, cùng sự tươi mới của trái tắc, tạo nên một thức uống ấm áp và bổ dưỡng.', 'tratacmatong.jpg', 30000, 30000, 'f', 'SANSANG', 638471313853280599, '2024-03-27 10:16:37.683541', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313974989268, 'Cam vắt', 'Món Cam Vắt tại nhà hàng chúng tôi là một lựa chọn tươi mới và bổ dưỡng, tận hưởng hương vị tinh tế và ngon ngọt của cam tươi vắt.', 'camvat.jpg', 20000, 20000, 'f', 'SANSANG', 638471313853280599, '2024-03-27 10:16:37.498928', '2024-05-12 00:00:00');
INSERT INTO "public"."tb_menu_item" VALUES (638471313973299466, 'Mochi Trái Cây', 'Món Mochi Trái Cây tại nhà hàng chúng tôi là sự kết hợp tuyệt vời giữa hương vị trái cây tươi ngon và độ ngon của lớp bánh mochi mềm mại. Mỗi chiếc mochi nhỏ được chế biến cầu kỳ, mang lại trải nghiệm ẩm thực độc đáo và thú vị.', 'mochitraicay.jpg', 50000, 50000, 'f', 'SANSANG', 638471313852958317, '2024-03-27 10:16:37.329948', '2024-05-12 00:00:00');

-- ----------------------------
-- Table structure for tb_menu_item_status
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_menu_item_status";
CREATE TABLE "public"."tb_menu_item_status" (
  "id" text COLLATE "pg_catalog"."default" NOT NULL,
  "name" text COLLATE "pg_catalog"."default" NOT NULL,
  "des" text COLLATE "pg_catalog"."default" NOT NULL,
  "isdeleted" bool NOT NULL
)
;

-- ----------------------------
-- Records of tb_menu_item_status
-- ----------------------------
INSERT INTO "public"."tb_menu_item_status" VALUES ('SANSANG', 'Món ăn sẵn sàng', 'Món ăn sẵn sàng', 'f');
INSERT INTO "public"."tb_menu_item_status" VALUES ('SAPRAMAT', 'Sắp ra mắt', 'Sắp ra mắt', 'f');
INSERT INTO "public"."tb_menu_item_status" VALUES ('TAMHET', 'Món ăn tạm hết', 'Món ăn tạm hết', 'f');

-- ----------------------------
-- Table structure for tb_orders
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_orders";
CREATE TABLE "public"."tb_orders" (
  "id" int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1
),
  "customer_code" text COLLATE "pg_catalog"."default" NOT NULL,
  "total" float8 NOT NULL,
  "isdeleted" bool NOT NULL,
  "staffid" int8,
  "tableid" int8,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL
)
;

-- ----------------------------
-- Records of tb_orders
-- ----------------------------
INSERT INTO "public"."tb_orders" VALUES (1715502631722, 'S-649207', 500000, 'f', 123, 638486928682406464, '2024-05-12 15:30:31.676', '2024-05-12 15:30:31.676');
INSERT INTO "public"."tb_orders" VALUES (1715508761317, 'S-463509', 768000, 'f', 123, 638486928685338984, '2024-05-12 17:12:41.282', '2024-05-12 17:12:41.282');
INSERT INTO "public"."tb_orders" VALUES (1715508906447, 'S-993251', 260000, 'f', 123, 638486928686982232, '2024-05-12 17:15:06.407', '2024-05-12 17:15:06.407');
INSERT INTO "public"."tb_orders" VALUES (1715490622301, 'M-578759', 520000, 'f', 123, 638486928681420078, '2024-05-12 12:10:22.173', '2024-05-12 17:35:45.562');
INSERT INTO "public"."tb_orders" VALUES (1715508846079, 'S-106113', 1260000, 'f', 123, 638486928679878230, '2024-05-12 17:14:06.037', '2024-05-12 17:39:06.29');
INSERT INTO "public"."tb_orders" VALUES (1715569220623, 'S-444263', 1536000, 'f', 123, 638471313761646464, '2024-05-13 10:00:20.57', '2024-05-13 10:00:20.57');
INSERT INTO "public"."tb_orders" VALUES (1715490622208, 'M-196597', 520000, 'f', 123, 638471313761646464, '2024-05-12 12:10:22.173', '2024-05-12 17:33:03.425');
INSERT INTO "public"."tb_orders" VALUES (1715490665950, 'M-196597', 508000, 'f', 123, 638486928682729903, '2024-05-11 12:11:05', '2024-05-11 12:11:05');
INSERT INTO "public"."tb_orders" VALUES (1715505448123, 'M-196597', 1276000, 'f', 123, 638486928684034323, '2024-05-12 16:17:28.076', '2024-05-12 17:36:24.36');
INSERT INTO "public"."tb_orders" VALUES (1715568902181, 'M-196597', 538000, 'f', 123, 638486928681746845, '2024-05-13 09:55:02.142', '2024-05-13 09:58:03.064');
INSERT INTO "public"."tb_orders" VALUES (1715569746420, 'S-905282', 740000, 'f', 123, 638471313761646464, '2024-05-13 10:09:06.38', '2024-05-13 10:09:06.38');
INSERT INTO "public"."tb_orders" VALUES (1715569794310, 'S-367359', 740000, 'f', 123, 638486928681420078, '2024-05-13 10:09:54.264', '2024-05-13 10:09:54.264');
INSERT INTO "public"."tb_orders" VALUES (1715569982919, 'S-993127', 60000, 'f', 123, 638486928682729903, '2024-05-13 10:13:02.919', '2024-05-13 10:13:02.919');
INSERT INTO "public"."tb_orders" VALUES (1715569899211, 'S-993127', 1068000, 'f', 123, 638486928682729903, '2024-05-13 10:11:39.137', '2024-05-13 10:15:01.415');
INSERT INTO "public"."tb_orders" VALUES (1715581407592, 'S-566731', 16000, 'f', 123, 638471313761646464, '2024-05-13 13:23:27.536', '2024-05-13 13:23:27.536');
INSERT INTO "public"."tb_orders" VALUES (1715582774149, 'S-693532', 60000, 'f', 123, 638486928681420078, '2024-05-13 13:46:14.064', '2024-05-13 13:46:14.064');
INSERT INTO "public"."tb_orders" VALUES (1715585558462, 'S-380922', 2860000, 'f', 123, 638471313761646464, '2024-05-13 14:32:38.415', '2024-05-13 14:32:38.415');
INSERT INTO "public"."tb_orders" VALUES (1715585783996, 'S-281348', 780000, 'f', 123, 638486928682729903, '2024-05-13 14:36:23.964', '2024-05-13 14:36:23.964');
INSERT INTO "public"."tb_orders" VALUES (1715585668094, 'S-380922', 450000, 'f', 123, 638471313761646464, '2024-05-13 14:34:28.094', '2024-05-13 14:49:35.714');
INSERT INTO "public"."tb_orders" VALUES (1715609205559, 'M-677870', 1300000, 'f', 123, 638486928684357293, '2024-05-13 21:06:45.512', '2024-05-13 21:06:45.512');
INSERT INTO "public"."tb_orders" VALUES (1715609205689, 'M-677870', 1300000, 'f', 123, 638486928682076969, '2024-05-13 21:06:45.512', '2024-05-13 21:06:45.512');
INSERT INTO "public"."tb_orders" VALUES (1715609205831, 'M-677870', 1300000, 'f', 123, 638486928685010023, '2024-05-13 21:06:45.512', '2024-05-13 21:06:45.512');
INSERT INTO "public"."tb_orders" VALUES (1715765852364, 'S-867760', 520000, 'f', 123, 638471313761646464, '2024-05-15 16:37:32.327', '2024-05-15 16:37:32.327');

-- ----------------------------
-- Table structure for tb_roles
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_roles";
CREATE TABLE "public"."tb_roles" (
  "id" text COLLATE "pg_catalog"."default" NOT NULL,
  "name" text COLLATE "pg_catalog"."default" NOT NULL,
  "des" text COLLATE "pg_catalog"."default" NOT NULL,
  "isdeleted" bool NOT NULL
)
;

-- ----------------------------
-- Records of tb_roles
-- ----------------------------
INSERT INTO "public"."tb_roles" VALUES ('ADMIN', 'Admin', 'Admin', 'f');
INSERT INTO "public"."tb_roles" VALUES ('MANAGER', 'Quản lý', 'Quản lý', 'f');
INSERT INTO "public"."tb_roles" VALUES ('STAFF', 'Nhân viên', 'Nhân viên', 'f');

-- ----------------------------
-- Table structure for tb_staff
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_staff";
CREATE TABLE "public"."tb_staff" (
  "id" int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1
),
  "username" text COLLATE "pg_catalog"."default" NOT NULL,
  "password" text COLLATE "pg_catalog"."default" NOT NULL,
  "email" text COLLATE "pg_catalog"."default" NOT NULL,
  "phone" text COLLATE "pg_catalog"."default" NOT NULL,
  "address" text COLLATE "pg_catalog"."default" NOT NULL,
  "isdeleted" bool NOT NULL,
  "roleid" text COLLATE "pg_catalog"."default",
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "first_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "last_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of tb_staff
-- ----------------------------
INSERT INTO "public"."tb_staff" VALUES (1714761199933, 'ducanh', '123', 'ducanh@gmail.com', '1234567890', 'dia chi duc anh', 'f', 'STAFF', '2024-05-04 01:33:19.871', '2024-05-04 00:00:00', 'Vũ Lê Đức Anh ', '');
INSERT INTO "public"."tb_staff" VALUES (1714763621223, 'NgA', '123', 'A@gmail.com', '2222222222', 'dia chi NgA', 'f', 'ADMIN', '2024-05-04 02:13:41.144', '2024-05-04 02:13:41.144', 'A', 'Nguyên Văn');
INSERT INTO "public"."tb_staff" VALUES (1714763652418, 'NgB', '123', 'B@gmail.com', '0987654321', 'dia chi NgB', 'f', 'MANAGER', '2024-05-04 02:14:12.33', '2024-05-04 02:14:12.33', 'B', 'Nguyên Văn');
INSERT INTO "public"."tb_staff" VALUES (1714763670471, 'NgC', '123', 'C@gmail.com', '1234512345', 'dia chi NgC', 'f', 'MANAGER', '2024-05-04 02:14:30.392', '2024-05-04 02:14:30.392', 'C', 'Nguyên Văn');
INSERT INTO "public"."tb_staff" VALUES (1714763813810, 'Yui', '123456', 'Yui@gmail.com', '5678956789', 'dia chi Yui', 'f', 'STAFF', '2024-05-04 02:16:53.719', '2024-05-04 02:16:53.719', '', 'Yui');
INSERT INTO "public"."tb_staff" VALUES (1714763836211, 'Mugi', '123456', 'Mugi@gmail.com', '9876598765', 'dia chi Mugi', 'f', 'STAFF', '2024-05-04 02:17:16.071', '2024-05-04 02:17:16.071', '', 'Mugi');
INSERT INTO "public"."tb_staff" VALUES (1714763863280, 'Bochi', '123456', 'Bochi@gmail.com', '0000000000', 'dia chi Bochi', 'f', 'STAFF', '2024-05-04 02:17:43.191', '2024-05-04 02:17:43.191', '', 'Bochi');
INSERT INTO "public"."tb_staff" VALUES (1714762936275, 'milos', '123456', 'Milos@gmail.com', '1111111111', 'dia chi Milos', 't', 'STAFF', '2024-05-04 02:02:16.194', '2024-05-04 00:00:00', 'Milos', 'Ricardo');
INSERT INTO "public"."tb_staff" VALUES (1714763708136, 'Tân Phát Tài', '123', 'TaA@gmail.com', '5432154312', 'dia chiTaA', 'f', 'STAFF', '2024-05-04 02:15:08.057', '2024-05-04 00:00:00', 'A Tạ', 'thị');
INSERT INTO "public"."tb_staff" VALUES (1714762999855, 'nhadat', '123', 'Home@gmail.com', '6666666666', 'dia chi Home', 'f', 'ADMIN', '2024-05-04 02:03:19.76', '2024-05-04 00:00:00', 'Lander', 'Home');
INSERT INTO "public"."tb_staff" VALUES (123, 'quangdeptrai', '123', 'zzz@gmail.com', '0333333333', '123123', 'f', 'ADMIN', '2024-05-03 21:37:07', '2024-05-03 21:37:10', 'Quang', 'Nguyễn Nhật');
INSERT INTO "public"."tb_staff" VALUES (1714761400609, 'qwer', '1234', 'qwer@gmail.com', '1234567890', 'diachi', 't', 'ADMIN', '2024-05-04 01:36:40.551', '2024-05-04 00:00:00', 'Anh', 'Vu Le Duc');

-- ----------------------------
-- Table structure for tb_supplier
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_supplier";
CREATE TABLE "public"."tb_supplier" (
  "id" int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1
),
  "name" text COLLATE "pg_catalog"."default" NOT NULL,
  "address" text COLLATE "pg_catalog"."default" NOT NULL,
  "phone" text COLLATE "pg_catalog"."default" NOT NULL,
  "isdeleted" bool NOT NULL
)
;

-- ----------------------------
-- Records of tb_supplier
-- ----------------------------
INSERT INTO "public"."tb_supplier" VALUES (2, 'Aquebus', 'HÀ NỘI', '1234567891', 't');
INSERT INTO "public"."tb_supplier" VALUES (1249292101, 'quang', 'Ha Noi', '1111111111', 'f');
INSERT INTO "public"."tb_supplier" VALUES (1250206887, 'zxcv', 'dia chi', '1234567899', 'f');
INSERT INTO "public"."tb_supplier" VALUES (1246067553, 'duc anh', 'dia chi', '1234567890', 't');
INSERT INTO "public"."tb_supplier" VALUES (1, 'Balam', 'TP.HCM', '2222222222', 'f');
INSERT INTO "public"."tb_supplier" VALUES (1249756174, 'Random', 'dia chi', '1111111112', 'f');

-- ----------------------------
-- Table structure for tb_table_status
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_table_status";
CREATE TABLE "public"."tb_table_status" (
  "id" text COLLATE "pg_catalog"."default" NOT NULL,
  "name" text COLLATE "pg_catalog"."default" NOT NULL,
  "des" text COLLATE "pg_catalog"."default" NOT NULL,
  "isdeleted" bool NOT NULL
)
;

-- ----------------------------
-- Records of tb_table_status
-- ----------------------------
INSERT INTO "public"."tb_table_status" VALUES ('BANTRONG', 'Bàn trống', 'Bàn trống', 'f');
INSERT INTO "public"."tb_table_status" VALUES ('DANGSUACHUA', 'Đang sửa chữa', 'Đang sửa chữa', 'f');
INSERT INTO "public"."tb_table_status" VALUES ('DANGSUDUNG', 'Đang sử dụng', 'Đang sử dụng', 'f');
INSERT INTO "public"."tb_table_status" VALUES ('DADATTRUOC', 'Đã đặt trước', 'Đã đặt trước', 'f');

-- ----------------------------
-- Table structure for tb_tables
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_tables";
CREATE TABLE "public"."tb_tables" (
  "id" int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1
),
  "name" text COLLATE "pg_catalog"."default" NOT NULL,
  "des" text COLLATE "pg_catalog"."default" NOT NULL,
  "isdeleted" bool NOT NULL,
  "customer_code" text COLLATE "pg_catalog"."default" NOT NULL,
  "statusid" text COLLATE "pg_catalog"."default",
  "update_time" timestamp(0) NOT NULL,
  "create_time" timestamp(0),
  "note" text COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of tb_tables
-- ----------------------------
INSERT INTO "public"."tb_tables" VALUES (1715411072504, '123', '123', 't', '', 'BANTRONG', '2024-05-11 14:04:43', '2024-05-11 14:04:36', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928686022512, 'C.05', 'Bàn C.05', 'f', '', 'BANTRONG', '2024-05-11 13:49:09', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928686982232, 'B.06', 'Bàn B.06', 'f', '', 'BANTRONG', '2024-05-13 13:19:56', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928679878230, 'B.01', 'Bàn B.01', 'f', '', 'BANTRONG', '2024-05-13 13:20:06', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (1713772057665, '123123', '123123', 't', '', 'BANTRONG', '2024-04-28 15:17:39', '2024-04-22 14:47:47', NULL);
INSERT INTO "public"."tb_tables" VALUES (1713759338603, '1111', '1111', 't', '', 'BANTRONG', '2024-04-28 20:44:48', '2024-04-22 11:15:40', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928682729903, 'A.03', 'Bàn A.03', 'f', 'S-281348', 'DANGSUDUNG', '2024-05-13 14:36:24', '2024-04-14 00:00:00', 'Ca ko cay
Coca ko co da');
INSERT INTO "public"."tb_tables" VALUES (638486928681420078, 'A.02', 'Bàn A.02', 'f', '', 'DADATTRUOC', '2024-05-13 13:47:24', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928684357293, 'B.04', 'Bàn B.04', 'f', 'M-677870', 'DANGSUDUNG', '2024-05-13 21:06:46', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928685338984, 'A.05', 'Bàn A.05', 'f', '', 'BANTRONG', '2024-05-13 09:05:50', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928682076969, 'C.02', 'Bàn C.02', 'f', 'M-677870', 'DANGSUDUNG', '2024-05-13 21:06:46', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928685010023, 'D.04', 'Bàn D.04', 'f', 'M-677870', 'DANGSUDUNG', '2024-05-13 21:06:46', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928683388075, 'C.03', 'Bàn C.03', 'f', '', 'BANTRONG', '2024-05-08 08:11:32', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638471313761646464, 'A.01', 'Bàn A.01', 'f', 'S-867760', 'DANGSUDUNG', '2024-05-15 16:37:32', '2024-03-21 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928686652757, 'A.06', 'Bàn A.06', 't', '', 'BANTRONG', '2024-05-11 16:06:39', '2024-04-14 00:00:00', '');
INSERT INTO "public"."tb_tables" VALUES (638486928685665460, 'B.05', 'Bàn B.05', 'f', '', 'BANTRONG', '2024-05-08 08:10:45', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928687317163, 'C.06', 'Bàn C.06', 'f', '', 'BANTRONG', '2024-05-08 08:11:09', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928680672564, 'C.01', 'Bàn C.01', 'f', '', 'DADATTRUOC', '2024-04-28 22:59:49', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928681090621, 'D.01', 'Bàn D.01', 'f', '', 'DADATTRUOC', '2024-05-08 08:11:09', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928684686934, 'C.04', 'Bàn C.04', 'f', '', 'DANGSUACHUA', '2024-05-08 08:11:43', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928682406464, 'D.02', 'Bàn D.02', 'f', '', 'BANTRONG', '2024-05-12 15:30:53', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928684034323, 'A.04', 'Bàn A.04', 'f', '', 'BANTRONG', '2024-05-13 10:08:23', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (1714563051349, 'aaaaaa', 'aaaaaa', 't', '', 'BANTRONG', '2024-05-01 18:31:04', '2024-05-01 18:30:56', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928681746845, 'B.02', 'Bàn B.02', 'f', '', 'BANTRONG', '2024-05-13 10:08:23', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928683057268, 'B.03', 'Bàn B.03', 'f', '', 'BANTRONG', '2024-04-20 21:40:50', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928683709294, 'D.03', 'Bàn D.03', 'f', '', 'BANTRONG', '2024-04-23 09:54:20', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928686338523, 'D.05', 'Bàn D.05', 'f', '', 'BANTRONG', '2024-04-30 17:39:08', '2024-04-14 00:00:00', NULL);
INSERT INTO "public"."tb_tables" VALUES (638486928687646656, 'D.06', 'Bàn D.06', 'f', '', 'BANTRONG', '2024-04-30 17:38:41', '2024-04-14 00:00:00', '');

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."tb_categories_id_seq"
OWNED BY "public"."tb_categories"."id";
SELECT setval('"public"."tb_categories_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."tb_detail_import_bill_id_seq"
OWNED BY "public"."tb_detail_import_bill"."id";
SELECT setval('"public"."tb_detail_import_bill_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."tb_detail_order_id_seq"
OWNED BY "public"."tb_detail_order"."id";
SELECT setval('"public"."tb_detail_order_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."tb_detail_recipe_id_seq"
OWNED BY "public"."tb_detail_recipe"."id";
SELECT setval('"public"."tb_detail_recipe_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."tb_import_bill_id_seq"
OWNED BY "public"."tb_import_bill"."id";
SELECT setval('"public"."tb_import_bill_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."tb_ingredients_id_seq"
OWNED BY "public"."tb_ingredients"."id";
SELECT setval('"public"."tb_ingredients_id_seq"', 1, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."tb_invoices_id_seq"
OWNED BY "public"."tb_invoices"."id";
SELECT setval('"public"."tb_invoices_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."tb_menu_item_id_seq"
OWNED BY "public"."tb_menu_item"."id";
SELECT setval('"public"."tb_menu_item_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."tb_orders_id_seq"
OWNED BY "public"."tb_orders"."id";
SELECT setval('"public"."tb_orders_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."tb_supplier_id_seq"
OWNED BY "public"."tb_supplier"."id";
SELECT setval('"public"."tb_supplier_id_seq"', 3, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."tb_tables_id_seq"
OWNED BY "public"."tb_tables"."id";
SELECT setval('"public"."tb_tables_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."tb_users_id_seq"
OWNED BY "public"."tb_staff"."id";
SELECT setval('"public"."tb_users_id_seq"', 1, true);

-- ----------------------------
-- Primary Key structure for table __EFMigrationsHistory
-- ----------------------------
ALTER TABLE "public"."__EFMigrationsHistory" ADD CONSTRAINT "PK___EFMigrationsHistory" PRIMARY KEY ("MigrationId");

-- ----------------------------
-- Auto increment value for tb_categories
-- ----------------------------
SELECT setval('"public"."tb_categories_id_seq"', 1, false);

-- ----------------------------
-- Primary Key structure for table tb_categories
-- ----------------------------
ALTER TABLE "public"."tb_categories" ADD CONSTRAINT "PK_tb_categories" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for tb_detail_import_bill
-- ----------------------------
SELECT setval('"public"."tb_detail_import_bill_id_seq"', 1, false);

-- ----------------------------
-- Indexes structure for table tb_detail_import_bill
-- ----------------------------
CREATE INDEX "IX_tb_detail_import_bill_billid" ON "public"."tb_detail_import_bill" USING btree (
  "billid" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "IX_tb_detail_import_bill_ingredientid" ON "public"."tb_detail_import_bill" USING btree (
  "ingredientid" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table tb_detail_import_bill
-- ----------------------------
ALTER TABLE "public"."tb_detail_import_bill" ADD CONSTRAINT "PK_tb_detail_import_bill" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for tb_detail_order
-- ----------------------------
SELECT setval('"public"."tb_detail_order_id_seq"', 1, false);

-- ----------------------------
-- Indexes structure for table tb_detail_order
-- ----------------------------
CREATE INDEX "IX_tb_detail_order_invoiceid" ON "public"."tb_detail_order" USING btree (
  "invoiceid" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "IX_tb_detail_order_itemid" ON "public"."tb_detail_order" USING btree (
  "itemid" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "IX_tb_detail_order_orderid" ON "public"."tb_detail_order" USING btree (
  "orderid" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table tb_detail_order
-- ----------------------------
ALTER TABLE "public"."tb_detail_order" ADD CONSTRAINT "PK_tb_detail_order" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for tb_detail_recipe
-- ----------------------------
SELECT setval('"public"."tb_detail_recipe_id_seq"', 1, false);

-- ----------------------------
-- Indexes structure for table tb_detail_recipe
-- ----------------------------
CREATE INDEX "IX_tb_detail_recipe_ingredientid" ON "public"."tb_detail_recipe" USING btree (
  "ingredientid" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table tb_detail_recipe
-- ----------------------------
ALTER TABLE "public"."tb_detail_recipe" ADD CONSTRAINT "PK_tb_detail_recipe" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table tb_discounts
-- ----------------------------
ALTER TABLE "public"."tb_discounts" ADD CONSTRAINT "PK_tb_discounts" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for tb_import_bill
-- ----------------------------
SELECT setval('"public"."tb_import_bill_id_seq"', 1, false);

-- ----------------------------
-- Indexes structure for table tb_import_bill
-- ----------------------------
CREATE INDEX "IX_tb_import_bill_supplierid" ON "public"."tb_import_bill" USING btree (
  "supplierid" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "IX_tb_import_bill_userid" ON "public"."tb_import_bill" USING btree (
  "staffid" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table tb_import_bill
-- ----------------------------
ALTER TABLE "public"."tb_import_bill" ADD CONSTRAINT "PK_tb_import_bill" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for tb_ingredients
-- ----------------------------
SELECT setval('"public"."tb_ingredients_id_seq"', 1, true);

-- ----------------------------
-- Primary Key structure for table tb_ingredients
-- ----------------------------
ALTER TABLE "public"."tb_ingredients" ADD CONSTRAINT "PK_tb_ingredients" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for tb_invoices
-- ----------------------------
SELECT setval('"public"."tb_invoices_id_seq"', 1, false);

-- ----------------------------
-- Indexes structure for table tb_invoices
-- ----------------------------
CREATE INDEX "IX_tb_invoices_discountid" ON "public"."tb_invoices" USING btree (
  "discountid" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table tb_invoices
-- ----------------------------
ALTER TABLE "public"."tb_invoices" ADD CONSTRAINT "PK_tb_invoices" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for tb_menu_item
-- ----------------------------
SELECT setval('"public"."tb_menu_item_id_seq"', 1, false);

-- ----------------------------
-- Indexes structure for table tb_menu_item
-- ----------------------------
CREATE INDEX "IX_tb_menu_item_categoryid" ON "public"."tb_menu_item" USING btree (
  "categoryid" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "IX_tb_menu_item_statusid" ON "public"."tb_menu_item" USING btree (
  "statusid" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table tb_menu_item
-- ----------------------------
ALTER TABLE "public"."tb_menu_item" ADD CONSTRAINT "PK_tb_menu_item" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table tb_menu_item_status
-- ----------------------------
ALTER TABLE "public"."tb_menu_item_status" ADD CONSTRAINT "PK_tb_menu_item_status" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for tb_orders
-- ----------------------------
SELECT setval('"public"."tb_orders_id_seq"', 1, false);

-- ----------------------------
-- Indexes structure for table tb_orders
-- ----------------------------
CREATE INDEX "IX_tb_orders_staffid" ON "public"."tb_orders" USING btree (
  "staffid" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "IX_tb_orders_tableid" ON "public"."tb_orders" USING btree (
  "tableid" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table tb_orders
-- ----------------------------
ALTER TABLE "public"."tb_orders" ADD CONSTRAINT "PK_tb_orders" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table tb_roles
-- ----------------------------
ALTER TABLE "public"."tb_roles" ADD CONSTRAINT "PK_tb_roles" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for tb_staff
-- ----------------------------
SELECT setval('"public"."tb_users_id_seq"', 1, true);

-- ----------------------------
-- Indexes structure for table tb_staff
-- ----------------------------
CREATE INDEX "IX_tb_users_roleid" ON "public"."tb_staff" USING btree (
  "roleid" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table tb_staff
-- ----------------------------
ALTER TABLE "public"."tb_staff" ADD CONSTRAINT "PK_tb_users" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for tb_supplier
-- ----------------------------
SELECT setval('"public"."tb_supplier_id_seq"', 3, true);

-- ----------------------------
-- Primary Key structure for table tb_supplier
-- ----------------------------
ALTER TABLE "public"."tb_supplier" ADD CONSTRAINT "PK_tb_supplier" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table tb_table_status
-- ----------------------------
ALTER TABLE "public"."tb_table_status" ADD CONSTRAINT "PK_tb_table_status" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for tb_tables
-- ----------------------------
SELECT setval('"public"."tb_tables_id_seq"', 1, false);

-- ----------------------------
-- Indexes structure for table tb_tables
-- ----------------------------
CREATE INDEX "IX_tb_tables_statusid" ON "public"."tb_tables" USING btree (
  "statusid" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table tb_tables
-- ----------------------------
ALTER TABLE "public"."tb_tables" ADD CONSTRAINT "PK_tb_tables" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table tb_detail_import_bill
-- ----------------------------
ALTER TABLE "public"."tb_detail_import_bill" ADD CONSTRAINT "FK_tb_detail_import_bill_tb_import_bill_billid" FOREIGN KEY ("billid") REFERENCES "public"."tb_import_bill" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."tb_detail_import_bill" ADD CONSTRAINT "FK_tb_detail_import_bill_tb_ingredients_ingredientid" FOREIGN KEY ("ingredientid") REFERENCES "public"."tb_ingredients" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table tb_detail_order
-- ----------------------------
ALTER TABLE "public"."tb_detail_order" ADD CONSTRAINT "FK_tb_detail_order_tb_invoices_invoiceid" FOREIGN KEY ("invoiceid") REFERENCES "public"."tb_invoices" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."tb_detail_order" ADD CONSTRAINT "FK_tb_detail_order_tb_menu_item_itemid" FOREIGN KEY ("itemid") REFERENCES "public"."tb_menu_item" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."tb_detail_order" ADD CONSTRAINT "FK_tb_detail_order_tb_orders_orderid" FOREIGN KEY ("orderid") REFERENCES "public"."tb_orders" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table tb_detail_recipe
-- ----------------------------
ALTER TABLE "public"."tb_detail_recipe" ADD CONSTRAINT "FK_tb_detail_menu_item" FOREIGN KEY ("itemid") REFERENCES "public"."tb_menu_item" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."tb_detail_recipe" ADD CONSTRAINT "FK_tb_detail_recipe_tb_ingredients_ingredientid" FOREIGN KEY ("ingredientid") REFERENCES "public"."tb_ingredients" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table tb_import_bill
-- ----------------------------
ALTER TABLE "public"."tb_import_bill" ADD CONSTRAINT "FK_tb_import_bill_tb_supplier_supplierid" FOREIGN KEY ("supplierid") REFERENCES "public"."tb_supplier" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."tb_import_bill" ADD CONSTRAINT "FK_tb_import_bill_tb_users_userid" FOREIGN KEY ("staffid") REFERENCES "public"."tb_staff" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table tb_invoices
-- ----------------------------
ALTER TABLE "public"."tb_invoices" ADD CONSTRAINT "FK_tb_invoices_tb_discounts_discountid" FOREIGN KEY ("discountid") REFERENCES "public"."tb_discounts" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table tb_menu_item
-- ----------------------------
ALTER TABLE "public"."tb_menu_item" ADD CONSTRAINT "FK_tb_menu_item_tb_categories_categoryid" FOREIGN KEY ("categoryid") REFERENCES "public"."tb_categories" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."tb_menu_item" ADD CONSTRAINT "FK_tb_menu_item_tb_menu_item_status_statusid" FOREIGN KEY ("statusid") REFERENCES "public"."tb_menu_item_status" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table tb_orders
-- ----------------------------
ALTER TABLE "public"."tb_orders" ADD CONSTRAINT "FK_tb_orders_tb_tables_tableid" FOREIGN KEY ("tableid") REFERENCES "public"."tb_tables" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."tb_orders" ADD CONSTRAINT "FK_tb_orders_tb_users_staffid" FOREIGN KEY ("staffid") REFERENCES "public"."tb_staff" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table tb_staff
-- ----------------------------
ALTER TABLE "public"."tb_staff" ADD CONSTRAINT "FK_tb_users_tb_roles_roleid" FOREIGN KEY ("roleid") REFERENCES "public"."tb_roles" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table tb_tables
-- ----------------------------
ALTER TABLE "public"."tb_tables" ADD CONSTRAINT "FK_tb_table_status" FOREIGN KEY ("statusid") REFERENCES "public"."tb_table_status" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
