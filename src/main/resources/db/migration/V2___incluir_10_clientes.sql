-- Migration V2: Criação da tabela 'cliente' e inserção de 10 clientes
CREATE TABLE IF NOT EXISTS scaa.cliente (
                                            codigo BIGSERIAL PRIMARY KEY,
                                            nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
    );

INSERT INTO scaa.cliente (nome, email) VALUES
                                           ('Ana Silva', 'ana.silva@email.com'),
                                           ('Bruno Souza', 'bruno.souza@email.com'),
                                           ('Carla Oliveira', 'carla.oliveira@email.com'),
                                           ('Daniel Santos', 'daniel.santos@email.com'),
                                           ('Eduarda Costa', 'eduarda.costa@email.com'),
                                           ('Fernando Lima', 'fernando.lima@email.com'),
                                           ('Gabriela Nunes', 'gabriela.nunes@email.com'),
                                           ('Hugo Almeida', 'hugo.almeida@email.com'),
                                           ('Isabela Rocha', 'isabela.rocha@email.com'),
                                           ('João Mendes', 'joao.mendes@email.com');
