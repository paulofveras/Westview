-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
INSERT INTO Produto (id, nome, dataPublicacao, edicao, escritor, artistaCapa, descricao, preco, quantidadeEstoque)
VALUES (1, 'Exemplo de HQ', '2023-01-01', 'Edição 1', 'Escritor Exemplo', 'Artista Capa', 'Descrição do produto de exemplo', 29.99, 100);