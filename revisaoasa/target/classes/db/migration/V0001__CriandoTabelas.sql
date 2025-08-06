create table aluno(
id bigint not null auto_increment primary key,
nome varchar(100),
datacadastro datetime not null,
data_atualizacao datetime not null,
curso_id bigint not null
)engine=InnoDB default charset=utf8;

create table curso(
id bigint not null auto_increment primary key,
nomecurso varchar(100),
datacadastro datetime not null,
data_atualizacao datetime not null
)engine=InnoDB default charset=utf8;

alter table aluno add constraint fk_aluno_curso foreign key (curso_id) references curso(id);