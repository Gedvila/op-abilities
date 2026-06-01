INSERT INTO tb_elements(name) VALUES ('Sangue');
INSERT INTO tb_elements(name) VALUES ('Morte');
INSERT INTO tb_elements(name) VALUES ('Energia');
INSERT INTO tb_elements(name) VALUES ('Conhecimento');
INSERT INTO tb_elements(name) VALUES ('Medo');

INSERT INTO tb_items_prop(name,description) VALUES ('Armas Ágeis','Facas, punhais, cajados, nunchakus, floretes e katanas permitem que você aplique sua Agilidade em vez de sua Força em testes de ataque e rolagens de dano realizadas com elas.');
INSERT INTO tb_items_prop(name,description) VALUES ('Armas Automáticas','Fuzis de assalto,submetralhadoras e metralhadoras podem disparar tiro únicos, usando a regra normal, ou rajadas. Quando dispara uma rajada você sofre -1d20 no teste de ataque, mas causa 1 dado de dano adicional do mesmo tipo');
INSERT INTO tb_items_prop(name,description) VALUES ('Coronhada','Você pode usar uma arma de fogo como uma arma corpo a corpo. O dano é 1d4 de impacto para armas de fogo leves e de uma mão (como pistolas) e 1d6 para armas de fogo de duas mãos (como fuzis).');
INSERT INTO tb_items_prop(name,description) VALUES ('Duas Mãos','Uma arma grande que precisa ser empunhada com duas mãos');

INSERT INTO tb_damage_kind(name, description) VALUES ('Balístico','Dano causado por projéteis arremessados a altas velocidades, como balas de um fuzil. Armas de fogo são as principais fontes deste tipo de dano.');
INSERT INTO tb_damage_kind(name, description) VALUES ('Corte','Armas afiadas, como espadas, machados e as garras de um animal, causam dano de corte');
INSERT INTO tb_damage_kind(name, description) VALUES ('Eletricidade','Alguns rituais, itens e perigos naturais (como um relâmpago) causam dano deste tipo.');
INSERT INTO tb_damage_kind(name, description) VALUES ('Fogo','Causado por calor e chamas, tanto naturais quanto conjuradas por rituais.');
INSERT INTO tb_damage_kind(name, description) VALUES ('Frio','Alguns rituais, além de clima severo, causam dano de frio.');

INSERT INTO tb_paranormal_powers(name,prerequisite,description,affinity,element_id) VALUES ('Precognição','Conhecimento 1','Você possui um “sexto sentido” que o avisa do perigo antes que ele aconteça. Você recebe +2 em Defesa e em testes de resistência.','você fica imune à condição desprevenido',4);

INSERT INTO tb_items(name,category,space,damage,range,crit_roll,crit_multiplier,is_paranormal,description,damage_kind_id) VALUES ('Gadanho',1,2,'2d4','-',20,4,false,'Uma grande foice de duas mãos',2);

INSERT INTO tb_item_item_prop(item_id,item_prop_id) VALUES (1,4);