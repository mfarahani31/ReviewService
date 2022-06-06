create sequence hibernate_sequence start with 1 increment by 1;
create table REVIEWS
(
    id            bigint    not null,
    created_at    timestamp not null,
    updated_at    timestamp not null,
    COMMENT       varchar(255),
    RATE          int,
    REVIEW_STATUS int,
    USER_ID       bigint,
    PRODUCT_ID    bigint,
    primary key (id)
);

create table PRODUCT_OPTIONS
(
    id                 bigint    not null,
    created_at         timestamp not null,
    updated_at         timestamp not null,
    RATE_STATUS        int,
    COMMENT_STATUS     int,
    PRODUCT_VISIBILITY boolean,
    PRODUCT_ID         bigint,
    primary key (id)
);
