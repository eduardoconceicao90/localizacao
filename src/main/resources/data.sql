CREATE TABLE TB_CIDADE (
    ID_CIDADE BIGINT NOT NULL PRIMARY KEY,
    NOME VARCHAR(50) NOT NULL,
    QTD_HABITANTES BIGINT
);

INSERT INTO TB_CIDADE
    (ID_CIDADE, NOME, QTD_HABITANTES)
VALUES
    (1, 'Salvador', 2886698),
    (2, 'Recife', 1653461);

