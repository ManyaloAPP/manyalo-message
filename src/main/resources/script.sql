create table university
(
    id      int auto_increment
        primary key,
    name    varchar(255) not null,
    address varchar(255) null
);

create table users
(
    id              int auto_increment
        primary key,
    user_name       varchar(50)  not null,
    email           varchar(100) not null,
    password        varchar(100) not null,
    university_code int          null,
    constraint users_ibfk_1
        foreign key (university_code) references university (id)
);

create table feedback_messages
(
    id         int auto_increment
        primary key,
    user_id    int                                                              not null,
    message    text                                                             not null,
    times_tamp datetime                             default current_timestamp() null,
    status     enum ('unread', 'read', 'responded') default 'unread'            null,
    response   text                                                             null,
    constraint feedback_messages_ibfk_1
        foreign key (user_id) references users (id)
);

create index user_id
    on feedback_messages (user_id);

create index university_code
    on users (university_code);

