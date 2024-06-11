-- This file allow to write SQL commands that will be emitted in test and dev.
-- Inserindo dados na tabela Usuario
-- Inserindo dados na tabela Usuario
INSERT INTO Usuario (id, nome, username, dataNascimento, email, senha, genero, cpf) VALUES
(1, 'João Silva', 'joaosilva', '1985-05-10', 'joao.silva@email.com', 'senha123', 'Masculino', '123.456.789-00'),
(2, 'Maria Santos', 'mariasantos', '1990-08-20', 'maria.santos@email.com', 'senha456', 'Feminino', '987.654.321-00'),
(3, 'Lala Ri', 'lalari', '1992-12-25', 'lalari@email.com', 'senha789', 'Feminino', '123.456.789-00'),
(4, 'Ru Paul', 'rupaul', '1960-06-15', 'rupaul@email.com', 'dcnllbEz5N6TGS0Ek6I01Gasc6SRk7d+bHYqT69MByiGqtfUTqZ4CUHT+nM5NWI+BDeNKk3s85ykccMp543NEw==', 'Masculino', '987.654.321-00');

-- Inserindo dados na tabela Funcionario
INSERT INTO Funcionario (id, salario, cargo, id_usuario) VALUES 
(1, 5000.00, 'Gerente', 4);

-- Inserindo dados na tabela Cliente
INSERT INTO Cliente (id, id_usuario, cep, endereco, estado, cidade) VALUES 
(1, 3, '01000-000', 'Rua A, 123', 'São Paulo', 'São Paulo');

-- Inserindo dados na tabela ArtistaCapa
INSERT INTO ArtistaCapa (id, nome) VALUES 
(1, 'João Silva');

-- Inserindo dados na tabela Escritor
INSERT INTO Escritor (id, nome) VALUES 
(1, 'Maria Santos');

-- Inserindo dados na tabela Categoria
INSERT INTO Categoria (id, universo) VALUES 
(1, 'DC Comics');

-- Inserindo dados na tabela Genero
INSERT INTO Genero (id, genero, descricao) VALUES 
(1, 'Ação', 'Histórias de ação');

-- Inserindo dados na tabela Origem
INSERT INTO Origem (id, pais) VALUES 
(1, 'Estados Unidos');

-- Inserindo dados na tabela Quadrinho
INSERT INTO Quadrinho (id, nome, dataPublicacao, edicao, preco, quantidadeEstoque, id_categoria, classificacao, id_genero, id_origem, id_escritor, id_artista_capa) VALUES 
(1, 'Batman: O Cavaleiro das Trevas', '1986-02-01', 'Edição Especial', 19.90, 10, 1, 'DEZANOS', 1, 1, 1, 1);

-- -- Inserindo dados na tabela QuadrinhoPedido
-- INSERT INTO QuadrinhoPedido (id, preco, desconto, quantidade, id_quadrinho) VALUES 
-- (1, 19.90, 0, 1, 1);

-- -- Inserindo dados na tabela Pedido
-- INSERT INTO Pedido (id, data, total, id_cliente) VALUES 
-- (1, '2024-06-01 12:00:00', 19.90, 1);

-- -- Vinculando QuadrinhoPedido ao Pedido
-- INSERT INTO Pedido_QuadrinhoPedido (id_pedido, id_quadrinho_pedido) VALUES 
-- (1, 1);