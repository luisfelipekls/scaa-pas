CREATE TABLE pagamento (
                           codigo BIGSERIAL PRIMARY KEY,
                           valor_pago DOUBLE PRECISION NOT NULL,
                           data_pagamento TIMESTAMP NOT NULL,
                           promocao VARCHAR(255),
                           assinatura_codigo BIGINT,
                           FOREIGN KEY (assinatura_codigo) REFERENCES assinatura(codigo)
);

INSERT INTO pagamento (valor_pago, data_pagamento, promocao, assinatura_codigo) VALUES
                                                                                (50.0, '2023-10-01 10:00:00', 'LUCAS10', 1),
                                                                                (50.0, '2023-10-02 11:00:00', 'RAVEL15', 2),
                                                                                (50.0, '2023-10-03 12:00:00', 'LUIS20', 3),
                                                                                (50.0, '2023-10-04 13:00:00', 'LUIS20', 4),
                                                                                (50.0, '2023-10-05 14:00:00', 'PROMOCAO5', 5);