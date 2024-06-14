-- This file allow to write SQL commands that will be emitted in test and dev.
-- Insere categorias
INSERT INTO Categoria (id, universo) VALUES (1, 'Marvel');
INSERT INTO Categoria (id, universo) VALUES (2, 'DC');


-- Insere origens
INSERT INTO Origem (id, pais) VALUES (1, 'Brasil');
INSERT INTO Origem (id, pais) VALUES (2, 'Estados Unidos');

-- Insere generos
INSERT INTO Genero (id, genero, descricao) VALUES (1, 'Ação', 'Quadrinhos de ação');
INSERT INTO Genero (id, genero, descricao) VALUES (2, 'Aventura', 'Quadrinhos de aventura');

-- Insere artistas de capa
INSERT INTO ArtistaCapa (id, nome) VALUES (1, 'John Doe');
INSERT INTO ArtistaCapa (id, nome) VALUES (2, 'Jane Doe');

-- Insere escritores
INSERT INTO Escritor (id, nome) VALUES (1, 'Alan Moore');
INSERT INTO Escritor (id, nome) VALUES (2, 'Frank Miller');

-- Insere quadrinhos
INSERT INTO Quadrinho (
    id, nome, dataPublicacao, edicao, preco, quantidadePaginas, 
    id_categoria, id_escritor, id_artista_capa, classificacao, 
    id_genero, id_origem, estoque
) VALUES (
    1, 'Secret Wars', '1986-09-01', '1', 29.99, 100, 
    1, 1, 1, 'LIVRE', -- ou outro valor válido como 'DEZANOS', 'DOZEANOS', etc.
    1, 2, 50
);
INSERT INTO Quadrinho (
    id, nome, dataPublicacao, edicao, preco, quantidadePaginas, 
    id_categoria, id_escritor, id_artista_capa, classificacao, 
    id_genero, id_origem, estoque
) VALUES (
    2, 'Secret Wars', '1986-09-01', '1', 29.99, 100, 
    1, 1, 1, 'LIVRE', -- ou outro valor válido como 'DEZANOS', 'DOZEANOS', etc.
    1, 2, 50
);
-- Insere usuários
INSERT INTO Usuario (id, nome, username, dataNascimento, email, senha, genero, cpf) VALUES (1, 'Cliente 1', 'cliente1', '1990-01-01', 'cliente1@example.com', '2a53Ej+/maOm6nPUip4SVJmEMSQAzRY2ik/yto0ofPfLU07PYEA0UQCqosYGDUc0pgnJFNI4dDREc5eegwPLIA==', 'M', '123.456.789-00');
INSERT INTO Usuario (id, nome, username, dataNascimento, email, senha, genero, cpf) VALUES (2, 'Funcionario 1', 'funcionario1', '1985-01-01', 'funcionario1@example.com', '2a53Ej+/maOm6nPUip4SVJmEMSQAzRY2ik/yto0ofPfLU07PYEA0UQCqosYGDUc0pgnJFNI4dDREc5eegwPLIA==', 'F', '987.654.321-00');

-- Insere clientes
INSERT INTO Cliente (id, cep, endereco, estado, cidade, id_usuario) VALUES (1, '12345-678', 'Rua A', 'SP', 'São Paulo', 1);

-- Insere funcionários
INSERT INTO Funcionario (id, salario, cargo, id_usuario) VALUES (1, 3000.00, 'Gerente', 2);

-- Insere pedidos
INSERT INTO Pedido (id, data, total, id_cliente, formaPagamento, statusPagamento) VALUES (1, '2024-06-14 10:00:00', 55.98, 1, 1, 1);
INSERT INTO Pedido (id, data, total, id_cliente, formaPagamento, statusPagamento) VALUES (2, '2024-06-15 10:00:00', 55.98, 1, 2, 2);

-- Insere itens de pedidos
INSERT INTO ItemPedido (id, preco, desconto, quantidade, id_quadrinho, id_item) VALUES (1, 29.99, 0, 1, 1, 1);
INSERT INTO ItemPedido (id, preco, desconto, quantidade, id_quadrinho, id_item) VALUES (2, 25.99, 0, 1, 2, 1);