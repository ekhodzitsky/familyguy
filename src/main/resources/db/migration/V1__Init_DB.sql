create sequence hibernate_sequence start 1 increment 1;

create table user_role (
  user_id int8 not null,
  roles   varchar(255)
);

create table usr (
  id       int8 not null,
  password varchar(255),
  username varchar(255),
  primary key (id)
);

create table video (
  id      int8 not null,
  episode int4,
  link    varchar(2000),
  season  int4,
  primary key (id)
);

alter table if exists user_role add constraint user_role_fk foreign key (user_id) references usr;