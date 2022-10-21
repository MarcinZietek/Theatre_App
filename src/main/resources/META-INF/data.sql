
--  1 step
CREATE DATABASE theatre_web_app
        CHARACTER SET utf8mb4
        COLLATE utf8mb4_unicode_ci;

-- 2 step
INSERT INTO role (name) values('ROLE_USER');
INSERT INTO role (name) values('ROLE_ADMIN');
INSERT INTO role (name) values('ROLE_MANAGER');
INSERT INTO role (name) values('ROLE_CUSTOMER');

--  3 step
localhost:8080/create-user

-- 4 step
insert into user_role(user_id, role_id) values (1,2);
insert into user_role(user_id, role_id) values (1,3);
insert into user_role(user_id, role_id) values (1,4);


insert into  rooms(no_seats, room_name) values (20, 'Kosmiczna');
insert into  rooms(no_seats, room_name) values (25, 'Bajkowa');
insert into  rooms(no_seats, room_name) values (30, 'Magiczna');