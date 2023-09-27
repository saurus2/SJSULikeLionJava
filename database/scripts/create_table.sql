CREATE TABLE USERS(
    user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(20) NOT NULL,
    profile_pic_id VARCHAR(20)
);

CREATE TABLE POST(
    post_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    writer INT NOT NULL,
    post_title VARCHAR(30) NOT NULL,
    post_date DATE NOT NULL,
    post_pic_id VARCHAR(20) NOT NULL,
    description VARCHAR(100) NOT NULL,
    roars_count INT NOT NULL DEFAULT 0,
    FOREIGN KEY (writer) REFERENCES USERS(user_id)
);

CREATE TABLE COMMENT(
    comment_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    post_id INT NOT NULL,
    writer INT NOT NULL,
    comment_date DATE NOT NULL,
    contents VARCHAR(40),
    FOREIGN KEY (post_id) REFERENCES POST(post_id),
    FOREIGN KEY (writer) REFERENCES USERS(user_id)
);

CREATE TABLE ROARS(
    roar_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    post_id INT NOT NULL,
    UNIQUE KEY (user_id, post_id), --Ensure a user can like a post only once
    FOREIGN KEY (user_id) REFERENCES USERS(user_id),
    FOREIGN KEY (post_id) REFERENCES POST(post_id)
);