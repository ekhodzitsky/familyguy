create table cmmnts (
id int8 not null,
authorid int8 not null,
creation_date timestamp,
value varchar(2048),
primary key (id)
);

create table video_comments (
video_id int8 not null,
comments_id int8 not null
);

alter table if exists video_comments
add constraint UK_comments unique (comments_id);

alter table if exists video_comments
add constraint FK4w6fpu607vii0jaaskxei8ol7 foreign key (comments_id) references cmmnts;

alter table if exists video_comments
add constraint FKm4g6ciwahoi7e0q5sa9lqg6jg foreign key (video_id) references video;