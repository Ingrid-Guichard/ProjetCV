create table users
(
    id bigint auto_increment,
    constraint users_pk
        primary key (id),
    first_name VARCHAR(100) not null,
    last_name VARCHAR(100) not null,
    age int not null,
    address VARCHAR(255) not null,
    job_status VARCHAR(100) not null,
    mail VARCHAR(255) not null,
    photo VARCHAR(100) not null
);

create table languages
(
    id bigint auto_increment,
    constraint languages_pk
        primary key (id),
    user_id bigint not null references users(id),
    name VARCHAR(100) not null,
    level VARCHAR(100) not null
);

create table skills
(
    id bigint auto_increment,
    constraint skills_pk
        primary key (id),
    user_id bigint not null references users(id),
    name VARCHAR(100) not null
);

create table educations
(
    id bigint auto_increment,
    constraint educations_pk
        primary key (id),
    user_id bigint not null references users(id),
    title VARCHAR(100) not null,
    place VARCHAR(255) null,
    starting_date date null,
    final_date date null,
    summary TEXT null
);

create table experiences
(
    id bigint auto_increment,
    constraint experiences_pk
        primary key (id),
    user_id bigint not null references users(id),
    title VARCHAR(100) not null,
    place VARCHAR(255) null,
    starting_date date null,
    final_date date null,
    summary TEXT null
);

create table projects
(
    id bigint auto_increment,
    constraint projects_pk
        primary key (id),
    user_id bigint not null references users(id),
    title VARCHAR(100) not null,
    summary TEXT null
);


create table links
(
    id bigint auto_increment,
    constraint links_pk
        primary key (id),
    user_id bigint not null references users(id),
    title TEXT not null,
    link TEXT null,
    is_checked TINYINT default 0
);
