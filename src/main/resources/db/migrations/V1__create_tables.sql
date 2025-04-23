CREATE TABLE tb_missao (
    id INTEGER PRIMARY KEY,
    nome VARCHAR,
    dificuldade VARCHAR UNIQUE
);

CREATE TABLE tb_cadastro (
    id INTEGER PRIMARY KEY,
    nome VARCHAR,
    email VARCHAR UNIQUE,
    img_url VARCHAR,
    idade INTEGER,
    missoes_id INTEGER REFERENCES tb_missao(id)
);