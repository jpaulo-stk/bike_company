alter table vendas add foreign key (id_user) references user(id);
alter table vendas add valor_total int not null;