-- v2: Migrations para adicionar a coluna RANK na tablea de cadastro

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);