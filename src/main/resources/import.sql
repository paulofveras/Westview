-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
-- Inserindo dados na tabela Pessoa
INSERT INTO Pessoa (id, nome, cpf, email) VALUES (1, 'João Silva', '123.456.789-00', 'joao.silva@email.com');
INSERT INTO Pessoa (id, nome, cpf, email) VALUES (2, 'Maria Santos', '987.654.321-00', 'maria.santos@email.com');
INSERT INTO Pessoa (id, nome, cpf, email) VALUES (3, 'Lala Ri', '123.456.789-00', 'lalari@email.com');
INSERT INTO Pessoa (id, nome, cpf, email) VALUES (4, 'Ru Paul', '987.654.321-00', 'rupaul@email.com');

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
INSERT INTO Genero (id, descricao, genero) VALUES (1, 'Histórias de ação', 'Ação');

-- Inserindo dados na tabela Origem
INSERT INTO Origem (id, pais) VALUES (1, 'Estados Unidos');

-- Inserindo dados na tabela Quadrinho
INSERT INTO Quadrinho (id, nome, datapublicacao, edicao, preco, quantidadeEstoque, id_categoria, classificacao, id_genero, id_origem) VALUES (1, 'Batman: O Cavaleiro das Trevas', '1986-02-01', 'Edição Especial', 19.90, 10, 1, 'DEZANOS', 1, 1);

INSERT INTO quadrinho_artistacapa (id_quadrinho, id_artista_capa) VALUES (1, 1);

INSERT INTO quadrinho_escritor (id_quadrinho, id_escritor) VALUES (1, 1);


