ALTER TABLE video
ADD COLUMN description varchar(1000),
ADD COLUMN rus_name varchar(255),
ADD COLUMN eng_name varchar(255);

create table video_id (
  video_id int8 not null,
  links   varchar(1000),
  translation bytea not null,
  primary key (video_id, translation)
);

alter table if exists video_id add constraint video_id__fk foreign key (video_id) references video;