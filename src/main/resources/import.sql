insert into telefone (codigoArea, numero) values ('63','888888888');
insert into telefone (codigoArea, numero) values ('61','333333333');
insert into telefone (codigoArea, numero) values ('62','222222222');
insert into telefone (codigoArea, numero) values ('11','111111111');
insert into telefone (codigoArea, numero) values ('22','442223344');
insert into telefone (codigoArea, numero) values ('11','333333333');
insert into telefone (codigoArea, numero) values ('22','555555555');
insert into telefone (codigoArea, numero) values ('63','848484848');

insert into endereco (cep, rua, numero) values (11111111,'Rua 1',12);
insert into endereco (cep, rua, numero) values (10101010,'Rua 10',2);
insert into endereco (cep, rua, numero) values (55555555,'Rua 5',14);
insert into endereco (cep, rua, numero) values (88888888,'Rua Paulista',8);
insert into endereco (cep, rua, numero) values (25252525,'Rua Cariora',3);
insert into endereco (cep, rua, numero) values (44445555,'Rua José',34);
insert into endereco (cep, rua, numero) values (66666777,'Rua Gisele',31);
insert into endereco (cep, rua, numero) values (77777888,'Rua Marcela',20);



INSERT INTO usuario (username, senha) VALUES ('joao123', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==');
INSERT INTO usuario (username, senha) VALUES ('gigi', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==');
INSERT INTO usuario (username, senha) VALUES ('roberto', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==');


insert into funcionario (nome,cargo,id_endereco,id_telefone,email,id_usuario) values ('João','Vendedor',1,1,'joao@gmail.com',1);

INSERT INTO cliente (nome, id_endereco, id_telefone, email, id_usuario)  VALUES ('Giovanna', 2, 2, 'giovanna@gmail.com', 2);
INSERT INTO cliente (nome, id_endereco, id_telefone, email, id_usuario)  VALUES ('Roberto', 7, 7, 'roberto@gmail.com', 3);


insert into fornecedor (nome,id_endereco,id_telefone,email) values ('José',6,6,'jose@gmail.com');
insert into fornecedor (nome,id_endereco,id_telefone,email) values ('Gisele',7,7,'gisele@gmail.com');

insert into quadrinho (nome,descricao,preco,quantPaginas,material,id_fornecedor,estoque) values ('Secret Wars','Marvel Comics',40.50,320,1,1,10);
insert into quadrinho (nome,descricao,preco,quantPaginas,material,id_fornecedor,estoque) values ('X-men','Marvel Comics',50.50,360,2,1,10);

insert into itempedido (preco,quantidade,desconto,id_quadrinho) values (100,1,5,1);