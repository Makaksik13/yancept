DROP TABLE IF EXISTS something;

CREATE TABLE IF NOT EXISTS students (
    id              bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    first_name      varchar(64) NOT NULL,
    second_name     varchar(64) NOT NULL,
    patronymic      varchar(64) NOT NULL,
    course_name     varchar(128),
    mentor_id       bigint,
    about_me        varchar(4096)
);

CREATE TABLE IF NOT EXISTS teachers (
    id              bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    first_name      varchar(64) NOT NULL,
    second_name     varchar(64) NOT NULL,
    patronymic      varchar(64) NOT NULL,
    link_to_profile varchar(64) NOT NULL,
    about_me        varchar(4096)
);

CREATE TABLE IF NOT EXISTS projects
(
    id               bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    name             VARCHAR(128) NOT NULL,
    description      VARCHAR(4096),
    owner_id         bigint NOT NULL,
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_owner_id FOREIGN KEY (owner_id) REFERENCES teachers (id)
);

CREATE TABLE IF NOT EXISTS requests (
    id bigint           PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    description         varchar(4096) NOT NULL,
    requester_id        bigint NOT NULL,
    receiver_id         bigint NOT NULL,
    is_accepted         boolean DEFAULT false NOT NULL,
    rejection_reason    varchar(4096),
    created_at          timestamptz DEFAULT current_timestamp,

    CONSTRAINT fk_requester_id FOREIGN KEY (requester_id) REFERENCES students (id),
    CONSTRAINT fk_receiver_id FOREIGN KEY (receiver_id) REFERENCES teachers (id)
);

