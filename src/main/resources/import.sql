-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
-- Inserir dados para a entidade Categoria
INSERT INTO Categoria (universo) VALUES ('Categoria 1');
INSERT INTO Categoria (universo) VALUES ('Categoria 2');

-- Inserir dados para a entidade Pessoa (Escritor e Artista Capa)
INSERT INTO Pessoa (nome, cpf, email) VALUES ('Escritor 1', '12345678901', 'escritor1@email.com');
INSERT INTO Pessoa (nome, cpf, email) VALUES ('Artista Capa 1', '98765432109', 'artistacapa1@email.com');

-- Inserir dados para a entidade Classificacao
INSERT INTO Classificacao (descricao) VALUES ('Livre');
INSERT INTO Classificacao (descricao) VALUES ('10 Anos');
-- Faça o mesmo para os demais valores de Classificacao

-- Inserir dados para a entidade Genero
INSERT INTO Genero (genero, descricao) VALUES ('Genero 1', 'Descricao Genero 1');
INSERT INTO Genero (genero, descricao) VALUES ('Genero 2', 'Descricao Genero 2');
-- Faça o mesmo para os demais valores de Genero

-- Inserir dados para a entidade Origem
INSERT INTO Origem (pais) VALUES ('Pais 1');
INSERT INTO Origem (pais) VALUES ('Pais 2');
-- Faça o mesmo para os demais valores de Origem

-- Inserir dados para a entidade Quadrinho
INSERT INTO Quadrinho (nome, datapublicacao, edicao, preco, quantidadeestoque,
                       id_categoria, id_escritor, id_artista_capa, classificacao,
                       id_genero, id_origem)
VALUES ('Quadrinho 1', '2023-01-01', 'Edição 1', 29.99, 100, 1, 1, 2, 1, 1, 2);
INSERT INTO Quadrinho (nome, datapublicacao, edicao, preco, quantidadeestoque,
                       id_categoria, id_escritor, id_artista_capa, classificacao,
                       id_genero, id_origem)
VALUES ('Quadrinho 2', '2023-02-01', 'Edição 2', 34.99, 150, 2, 2, 1, 2, 2, 1);
-- Insira mais linhas conforme necessário