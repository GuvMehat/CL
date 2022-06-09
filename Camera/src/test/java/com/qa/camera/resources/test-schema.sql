drop table is exists camera CASCADDE;
drop table is exists lens CASCADDE;

create table camera (
id interger auto_increment NOT NULL,
brand varchar(50),
type interger,
mount interger
);

create table lens (
id interger auto_increment NOT NULL,
mount interger,
fstop interger,
range interger,
brand varchar(50)
);

