-- -- Insert USERS
-- INSERT INTO USERS (user_name, password) VALUES ('jooyul', 'likelion');
-- INSERT INTO USERS (user_name, password) VALUES ('jihyeok', 'likelion');
-- INSERT INTO USERS (user_name, password) VALUES ('jaewon', 'likelion');
-- INSERT INTO USERS (user_name, password) VALUES ('yongjun', 'likelion');
-- INSERT INTO USERS (user_name, password) VALUES ('dasom', 'likelion');

-- -- Insert POST
-- INSERT INTO POST (writer, post_title, post_date, post_pic_id, description)
-- VALUES (1, 'Hi, everyone', '2023-09-26','odajdh395_nf', 'Welcome to the Lionstagram!');
-- INSERT INTO POST (writer, post_title, post_date, post_pic_id, description)
-- VALUES (5, 'Sharing my day', '2023-09-27', '939fjgjslsl1030000', 'I attended likelion meeting today');
-- INSERT INTO POST (writer, post_title, post_date, post_pic_id, description)
-- VALUES (3, 'Tried new korean restaurant', '2023-09-28', '1230599559fkg', 'The food was amazing!');

-- -- Insert COMMENT
-- INSERT INTO COMMENT (post_id, writer, comment_date, contents)
-- VALUES (1, 4, '2023-09-27', 'Thank you for the warm welcome!');
-- INSERT INTO COMMENT (post_id, writer, comment_date, contents)
-- VALUES (2, 2, '2023-09-28', 'How was the meeting?');

-- -- Insert ROARS for post 1
-- INSERT INTO ROARS (user_id, post_id) VALUES (1, 1);
-- INSERT INTO ROARS (user_id, post_id) VALUES (2, 1);

-- -- Insert ROARS for post 2
-- INSERT INTO ROARS (user_id, post_id) VALUES (3, 2);
-- INSERT INTO ROARS (user_id, post_id) VALUES (4, 2);
-- INSERT INTO ROARS (user_id, post_id) VALUES (5, 2);

-- -- Insert ROARS for post 3
-- INSERT INTO ROARS (user_id, post_id) VALUES (1, 3);

-- -- Query roars_count for post 1
-- SELECT roars_count FROM POST WHERE post_id = 1;

-- -- Query roars_count for post 2
-- SELECT roars_count FROM POST WHERE post_id = 2;

-- -- Query roars_count for post 3
-- SELECT roars_count FROM POST WHERE post_id = 3;

-- -- The results of these queries above should show you the roars_count for each post