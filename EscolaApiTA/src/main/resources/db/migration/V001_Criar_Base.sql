create table curso(
id int primary key auto_increment not null,
nomecurso varchar(100)
);

create table aluno(
id int not null primary key auto_increment,
nome varchar(100),
cursoid int not null
);

alter table aluno add constraint fk_curso_aluno foreign key(cursoid) references curso(id);