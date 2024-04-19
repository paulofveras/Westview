-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
-- Inserir dados na tabela Pessoa
INSERT INTO Pessoa (id, nome, cpf, email) VALUES (1, 'João Silva', '123.456.789-00', 'joao.silva@email.com');
INSERT INTO Pessoa (id, nome, cpf, email) VALUES (2, 'Maria Santos', '987.654.321-00', 'maria.santos@email.com');
INSERT INTO Pessoa (id, nome, cpf, email) VALUES (3, 'Artista da Capa', '111.222.333-44', 'artista.capa@email.com');
INSERT INTO Pessoa (id, nome, cpf, email) VALUES (4, 'Escritor Principal', '555.666.777-88', 'escritor.principal@email.com');

-- Inserir dados na tabela Origem
INSERT INTO Origem (id, pais) VALUES (1, 'Brasil');

-- Inserir dados na tabela Genero
INSERT INTO Genero (id, genero, descricao) VALUES (1, 'Ação', 'Histórias de ação');

-- Inserir dados na tabela Categoria
INSERT INTO Categoria (id, universo) VALUES (1, 'Marvel');

-- Inserir dados na tabela ArtistaCapa
INSERT INTO ArtistaCapa (id, id_pessoa) VALUES (1, 3);

-- Inserir dados na tabela Escritor
INSERT INTO Escritor (id, id_pessoa) VALUES (1, 4);

-- Inserir dados na tabela Quadrinho
INSERT INTO Quadrinho (id, nome, dataPublicacao, edicao, preco, quantidadeEstoque, id_categoria, id_escritor, id_artista_capa, classificacao, id_genero, id_origem) 
VALUES (1, 'Homem Aranha', '2024-01-01', 'Edição 1', 19.99, 100, 1, 1, 1, 'LIVRE', 1, 1);
