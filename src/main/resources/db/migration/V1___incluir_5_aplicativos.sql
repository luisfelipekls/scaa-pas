-- Criação da tabela 'aplicativo' com autoincremento no campo 'codigo'
-- Usar o schema 'scaa' explicitamente
CREATE TABLE IF NOT EXISTS scaa.aplicativo (
                                               codigo BIGSERIAL PRIMARY KEY,
                                               nome VARCHAR(255) NOT NULL,
    custo_mensal DOUBLE PRECISION NOT NULL
    );


-- Inserindo 5 aplicativos na tabela
INSERT INTO aplicativo (nome, custo_mensal) VALUES
                                                ('Finanças App', 29.99),
                                                ('Clima App', 49.99),
                                                ('Futebol App', 19.99),
                                                ('Social App', 9.99),
                                                ('Saúde App', 59.99);
