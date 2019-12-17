insert into categoria(id, nome) values (1, 'TECNOLOGIA')
insert into categoria(id, nome) values (2, 'ARQUITETURA DE SOLUÇÕES')
insert into categoria(id, nome) values (3, 'GERENCIAMENTO DE PROJETOS')
insert into categoria(id, nome) values (4, 'ENGENHARIA DE SOFTWARE')
insert into categoria(id, nome) values (5, 'DATA CIENCE')

insert into produto(id, logo, nome, quantidade, valor) values (1, 'legalizzr.png', 'Camiseta - Darth Vader', 1, 80)
insert into produto(id, logo, nome, quantidade, valor) values (2, 'ABA.png', 'Macbook Pro', 1, 12000)
insert into produto(id, logo, nome, quantidade, valor) values (3, 'digiyto.png', 'Teclado Mecânico', 1, 450)
insert into produto(id, logo, nome, quantidade, valor) values (4, 'goytacaz.png', 'iMac Tela de Retina', 1, 22000)
insert into produto(id, logo, nome, quantidade, valor) values (5, 'dana.png', 'IPhone 11 PRO', 1, 6000)

insert into produto_categoria(id_categoria, id_produto) values (1, 1)
insert into produto_categoria(id_categoria, id_produto) values (1, 2)

insert into cliente(id, nome, email, senha, sobrenome, idade, profissao, telefone) values (1, 'Thiago', 'thiago@thiago', 123, 'Azevedo', 33, 'Personal Treinee', '98999437427')
insert into cliente(id, nome, email, senha, sobrenome, idade, profissao, telefone) values (2, 'Fadia', 'quatro@legalizzr.com.br', 123, 'Fadiga', 34, 'Paisagista', '48 898952564584')
insert into cliente(id, nome, email, senha, sobrenome, idade, profissao, telefone) values (3, 'Wesley', 'nove@legalizzr.com.br', 123, 'Amorim', 32, 'Ator', '98999437427')
insert into cliente(id, nome, email, senha, sobrenome, idade, profissao, telefone) values (4, 'Roberto', 'hagata@legalizzr.com.br', 123, 'Cascos', 23, 'Programador', '48 9889254585')
insert into cliente(id, nome, email, senha, sobrenome, idade, profissao, telefone) values (5, 'Jaber', 'jaber@jaber', 123, 'Jhony', 19, 'Zelador', '48 8985522525')


insert into role(id, nome) values (1, 'ROLE_ADMIN');
insert into role(id, nome) values (2, 'ROLE_USER');


insert into cliente_role(id_clientes, id_roles) values (1, 1)
insert into cliente_role(id_clientes, id_roles) values (1, 2)
insert into cliente_role(id_clientes, id_roles) values (2, 2)
insert into cliente_role(id_clientes, id_roles) values (3, 2)
insert into cliente_role(id_clientes, id_roles) values (4, 2)
insert into cliente_role(id_clientes, id_roles) values (5, 2)