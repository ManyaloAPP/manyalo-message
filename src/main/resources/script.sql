create table careers
(
    id   int auto_increment
        primary key,
    name varchar(100) not null
);

create table university
(
    id      int auto_increment
        primary key,
    name    varchar(255) not null,
    address varchar(255) null
);

create table university_careers
(
    university_id int not null,
    career_id     int not null,
    primary key (university_id, career_id),
    constraint university_careers_ibfk_1
        foreign key (university_id) references university (id),
    constraint university_careers_ibfk_2
        foreign key (career_id) references careers (id)
);

create index career_id
    on university_careers (career_id);

create table users
(
    id            int auto_increment
        primary key,
    user_name     varchar(50)                 not null,
    email         varchar(100)                not null,
    password      varchar(100)                not null,
    university_id int                         null,
    type          enum ('Logged', 'Guest')    not null,
    careers_id    int                         null,
    status        enum ('active', 'inactive') null,
    constraint users_careers_id_fk
        foreign key (careers_id) references careers (id),
    constraint users_ibfk_1
        foreign key (university_id) references university (id)
);

create table feedback_messages
(
    id         int auto_increment
        primary key,
    user_id    int                                  not null,
    message    text                                 not null,
    times_tamp datetime default current_timestamp() null,
    constraint feedback_messages_ibfk_1
        foreign key (user_id) references users (id)
);

create index user_id
    on feedback_messages (user_id);

create index university_code
    on users (university_id);

create
    definer = root@localhost procedure get_universities_with_careers()
BEGIN
    SELECT
        u.id AS university_id,
        u.name AS university_name,
        u.address AS university_address,
        c.id AS career_id,
        c.name AS career_name
    FROM
        university u
            JOIN
        university_careers uc ON u.id = uc.university_id
            JOIN
        careers c ON uc.career_id = c.id;
END;

create
    definer = root@localhost procedure sp_create_user_guest_with_feedback(IN name_user varchar(50),
                                                                          IN email_user varchar(100),
                                                                          IN university int(255), IN career int(100),
                                                                          IN message_user varchar(100))
BEGIN
    DECLARE id_user INT;
    DECLARE id_feedback INT;

    -- Insertar el usuario
    INSERT INTO users (user_name, email, password, university_id, type,careers_id, status)
    VALUES (name_user, email_user, '0000000000', university, 'guest', career, 'inactive');
    SET id_user = LAST_INSERT_ID();

    -- Insertar el feedback
    INSERT INTO feedback_messages(user_id, message, times_tamp)
    VALUES(id_user, message_user, NOW());
    SET id_feedback = LAST_INSERT_ID();

    select * from feedback_messages as fm where fm.id=id_feedback;

END;

