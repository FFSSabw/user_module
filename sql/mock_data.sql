INSERT INTO USER(name, email, description, localtion, username, hashedPassword) 
    values('路人A', '123456@qq.com', '这个就是一个路人A', '地址A', '1', '12345678');
INSERT INTO USER(name, email, description, localtion, username, hashedPassword) 
    values('路人B', '123456@gmail.com', '这个就是一个路人B', '地址B', '2', '12345678');
INSERT INTO USER(name, email, description, localtion, username, hashedPassword) 
    values('路人C', '123456@163.com', '这个就是一个路人C', '地址C', '3', '12345678');
INSERT INTO USER(name, email, description, localtion, username, hashedPassword) 
    values('路人D', '123456@126.com', '这个就是一个路人D', '地址D', '4', '12345678');
INSERT INTO USER(name, email, description, localtion, username, hashedPassword) 
    values('路人E', '123456@qwe.com', '这个就是一个路人E', '地址E', '5', '12345678');

INSERT INTO ROLE(rid, name) 
    values(0, 'unauthorized');
INSERT INTO ROLE(rid, name) 
    values(1, 'authorized');
INSERT INTO ROLE(rid, name) 
    values(2, 'admin');

INSERT INTO USER_ROLE_RELA(user_id, role_id) 
    values(1, 1);
INSERT INTO USER_ROLE_RELA(user_id, role_id) 
    values(2, 1);
INSERT INTO USER_ROLE_RELA(user_id, role_id) 
    values(3, 3);
INSERT INTO USER_ROLE_RELA(user_id, role_id) 
    values(4, 2);
INSERT INTO USER_ROLE_RELA(user_id, role_id) 
    values(5, 1);
