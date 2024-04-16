-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
-- Inserção de Categorias
INSERT INTO Categoria (nome, universo) VALUES ('Marvel', 'Universo Marvel');
INSERT INTO Categoria (nome, universo) VALUES ('DC Comics', 'Universo DC');

-- Inserção de Gêneros
INSERT INTO Genero (genero, descricao) VALUES ('Ação', 'Quadrinhos de ação e aventura');
INSERT INTO Genero (genero, descricao) VALUES ('Ficção Científica', 'Quadrinhos de ficção científica');

-- Inserção de Origens
INSERT INTO Origem (pais) VALUES ('Estados Unidos');
INSERT INTO Origem (pais) VALUES ('Japão');

-- Inserção de Pessoas
INSERT INTO Pessoa (nome, cpf, email) VALUES ('Escritor Exemplo', '12345678900', 'escritor@example.com');
INSERT INTO Pessoa (nome, cpf, email) VALUES ('Artista Capa', '98765432100', 'artista@example.com');

-- Inserção de Quadrinhos com referências a Categoria, Gênero, Origem e Pessoas
INSERT INTO Quadrinho (nome, dataPublicacao, edicao, descricao, preco, quantidadeEstoque, categoria_id, genero_id, origem_id, escritor_id, artistaCapa_id) 
VALUES ('Exemplo de HQ', '2023-01-01', 'Edição 1', 'Descrição do Quadrinho de exemplo', 29.99, 100, 1, 1, 1, 1, 2);
