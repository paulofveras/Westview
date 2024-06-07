-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
-- Inserindo dados na tabela Pessoa
-- Inserindo dados na tabela Usuario
INSERT INTO Usuario (id, username, password) VALUES
(1, 'joaosilva', 'senha123'),
(2, 'mariasantos', 'senha456'),
(3, 'lalari', 'senha789'),
(4, 'rupaul', 'senhaabc');

-- Inserindo dados na tabela Pessoa
INSERT INTO Pessoa (id, nome, cpf, email, id_usuario) VALUES 
(1, 'João Silva', '123.456.789-00', 'joao.silva@email.com', 1),
(2, 'Maria Santos', '987.654.321-00', 'maria.santos@email.com', 2),
(3, 'Lala Ri', '123.456.789-00', 'lalari@email.com', 3),
(4, 'Ru Paul', '987.654.321-00', 'rupaul@email.com', 4);

-- Inserindo dados na tabela Funcionario
INSERT INTO Funcionario (cargo, id_pessoa) VALUES ('Gerente', 4);

-- Inserindo dados na tabela Cliente
INSERT INTO Cliente (id_pessoa, cidade, estado) VALUES (3, 'São Paulo', 'São Paulo');

-- Inserindo dados na tabela ArtistaCapa
INSERT INTO ArtistaCapa (id_pessoa) VALUES (1);

-- Inserindo dados na tabela Escritor
INSERT INTO Escritor (id_pessoa) VALUES (2);

-- Inserindo dados na tabela Categoria
INSERT INTO Categoria (id, universo) VALUES (1, 'DC Comics');

-- Inserindo dados na tabela Genero
INSERT INTO Genero (id, genero, descricao) VALUES (1, 'Ação', 'Histórias de ação');

-- Inserindo dados na tabela Origem
INSERT INTO Origem (id, pais) VALUES (1, 'Estados Unidos');

-- Inserindo dados na tabela Quadrinho
INSERT INTO Quadrinho (id, nome, dataPublicacao, edicao, preco, quantidadeEstoque, id_categoria, classificacao, id_genero, id_origem, id_escritor, id_artista_capa) VALUES 
(1, 'Batman: O Cavaleiro das Trevas', '1986-02-01', 'Edição Especial', 19.90, 10, 1, 'DEZANOS', 1, 1, 1, 1);

