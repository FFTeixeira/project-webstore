INSERT INTO tb_category (name, created_At) VALUES ('Smartphone', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Laptop', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Tablet', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Headphone', NOW());


INSERT INTO tb_product (sku, name, unit_price, manufacturer, units_in_stock, units_in_order, description, discontinued, condition, created_At) VALUES ('P1234', 'iPhone 6s', 500, 'Apple', 1000, 450, 'Apple iPhone 6s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera.', false, 'New', NOW());
INSERT INTO tb_product (sku, name, unit_price, manufacturer, units_in_stock, units_in_order, description, discontinued, condition, created_At) VALUES ('P1235', 'Dell Inspiron', 500, 'Dell', 1000, 450, 'Dell Inspiron with 14-inch Laptop (Black) with 3rd Generation Intel Core processors.', false, 'New', NOW());
INSERT INTO tb_product (sku, name, unit_price, manufacturer, units_in_stock, units_in_order, description, discontinued, condition, created_At) VALUES ('P1236', 'Nexus 7', 500, 'Google', 1000, 450, 'Google Nexus 7 is the lightest 7-inch tablet with a quad-core Qualcomm Snapdragon S4 Pro processor.', false, 'New', NOW());

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 3);
