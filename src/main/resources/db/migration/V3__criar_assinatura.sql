CREATE TABLE assinatura (
    codigo BIGSERIAL PRIMARY KEY,
    inicio_vigencia DATE NOT NULL,
    fim_vigencia DATE,
    aplicativo_codigo BIGINT NOT NULL,
    cliente_codigo BIGINT NOT NULL,
    CONSTRAINT fk_aplicativo FOREIGN KEY (aplicativo_codigo) REFERENCES aplicativo(codigo),
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_codigo) REFERENCES cliente(codigo)
);