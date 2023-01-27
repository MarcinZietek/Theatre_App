
--  1st step to create DataBase
# CREATE DATABASE theatre_web_app
#         CHARACTER SET utf8mb4
#         COLLATE utf8mb4_unicode_ci;

-- 2nd step automatically populates chosen tables
INSERT INTO role (name) values('ROLE_USER');
INSERT INTO role (name) values('ROLE_ADMIN');
INSERT INTO role (name) values('ROLE_MANAGER');
INSERT INTO role (name) values('ROLE_CUSTOMER');

insert into user_role(user_id, role_id) values (1,2);
insert into user_role(user_id, role_id) values (1,3);
insert into user_role(user_id, role_id) values (1,4);

insert into  rooms(no_seats, room_name) values (20, 'Kosmiczna');
insert into  rooms(no_seats, room_name) values (25, 'Bajkowa');
insert into  rooms(no_seats, room_name) values (30, 'Magiczna');

insert into films(description, length_min, name) VALUES ('Pierwsza adaptacja powieści', 120, 'Nowy Film');
insert into films(description, length_min, name) VALUES ('Kolejna adaptacja powieści', 120, 'Najnowszy Film');

--  3rd step create admin user by typing address in a browser
# localhost:8080/create-user #