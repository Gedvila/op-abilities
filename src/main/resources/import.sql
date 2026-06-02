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
INSERT INTO tb_paranormal_powers(name,prerequisite,description,affinity,element_id) VALUES ('Expansão de Conhecimento','Conhecimento 1','Você aprende um poder de classe que não pertença à sua classe.','você aprende um segundo poder de classe que não pertença à sua classe',4);
INSERT INTO tb_paranormal_powers(name,prerequisite,description,affinity,element_id) VALUES ('Percepção Paranormal','-','Em cenas de investigação, sempre que fizer um teste para procurar pistas, você pode rolar novamente um dado com resultado menor que 10.','você pode rolar novamente até dois dados com resultado menor que 10',4);
INSERT INTO tb_paranormal_powers(name,prerequisite,description,affinity,element_id) VALUES ('Afortunado','-','Uma vez por rolagem, você pode rolar novamente um resultado 1 em qualquer dado que não seja d20.','uma vez por teste, você pode rolar novamente um resultado 1 em d20',3);
INSERT INTO tb_paranormal_powers(name,prerequisite,description,affinity,element_id) VALUES ('Campo Protetor','Energia 1','Quando usa a ação esquiva, você pode gastar 1 PE para receber +5 em Defesa.','você também recebe +5 em Reflexo e não sofre nenhum dano caso o teste normalmente reduziria à metade',3);
INSERT INTO tb_paranormal_powers(name,prerequisite,description,affinity,element_id) VALUES ('Encarar a Morte','-','Durante cenas de ação, seu limite de gasto de PE aumenta em +1 (isso não afeta a DT).','durante cenas de ação, seu limite de gasto de PE aumenta em +2',2);
INSERT INTO tb_paranormal_powers(name,prerequisite,description,affinity,element_id) VALUES ('Escapar da Morte','Morte 1','Uma vez por cena, quando receber dano que o deixaria com 0 PV, você fica com 1 PV.','em vez do normal, você evita completamente o dano',2);
INSERT INTO tb_paranormal_powers(name,prerequisite,description,affinity,element_id) VALUES ('Anatomia Insana','Sangue 2','Você tem 50% de chance de ignorar o dano adicional de um acerto crítico ou ataque furtivo.','você é imune aos efeitos de acertos críticos e ataques furtivos',1);
INSERT INTO tb_paranormal_powers(name,prerequisite,description,affinity,element_id) VALUES ('Arma de Sangue','-','Você produz garras ou uma lâmina de sangue cristalizado em seu antebraço que causa 1d6 de dano e lhe dá ataques adicionais.','a arma se torna permanentemente parte de você e causa 1d10 pontos de dano',1);
INSERT INTO tb_paranormal_powers(name,prerequisite,description,affinity,element_id) VALUES ('Sangue de Ferro','-','Você recebe +2 pontos de vida por NEX.','você recebe +5 em Fortitude e se torna imune a venenos e doenças',1);

INSERT INTO tb_items(name,category,space,damage,range,crit_roll,crit_multiplier,is_paranormal,description,damage_kind_id) VALUES ('Gadanho',1,2,'2d4','-',20,4,false,'Uma grande foice de duas mãos',2);
INSERT INTO tb_items(name,category,space,damage,range,crit_roll,crit_multiplier,is_paranormal,description,damage_kind_id) VALUES ('Faca',0,1,'1d4','Curto',19,2,false,'Uma lâmina longa e afiada que pode ser arremessada.',2);
INSERT INTO tb_items(name,category,space,damage,range,crit_roll,crit_multiplier,is_paranormal,description,damage_kind_id) VALUES ('Machete',0,1,'1d6','-',19,2,false,'Uma lâmina longa, muito usada como ferramenta para abrir trilhas.',2);
INSERT INTO tb_items(name,category,space,damage,range,crit_roll,crit_multiplier,is_paranormal,description,damage_kind_id) VALUES ('Espada',1,1,'1d8','-',19,2,false,'Uma arma medieval, como uma espada longa dos cavaleiros europeus.',2);
INSERT INTO tb_items(name,category,space,damage,range,crit_roll,crit_multiplier,is_paranormal,description,damage_kind_id) VALUES ('Machado',1,1,'1d8','-',20,3,false,'Uma ferramenta importante para lenhadores e bombeiros que causa ferimentos terríveis.',2);
INSERT INTO tb_items(name,category,space,damage,range,crit_roll,crit_multiplier,is_paranormal,description,damage_kind_id) VALUES ('Acha',1,2,'1d12','-',20,3,false,'Um machado grande e pesado, usado no corte de árvores largas.',2);
INSERT INTO tb_items(name,category,space,damage,range,crit_roll,crit_multiplier,is_paranormal,description,damage_kind_id) VALUES ('Pistola',1,1,'1d12','Curto',18,2,false,'Uma arma de mão comum entre policiais e militares por ser facilmente recarregável.',1);
INSERT INTO tb_items(name,category,space,damage,range,crit_roll,crit_multiplier,is_paranormal,description,damage_kind_id) VALUES ('Revólver',1,1,'2d6','Curto',19,3,false,'A arma de fogo mais comum, e uma das mais confiáveis.',1);
INSERT INTO tb_items(name,category,space,damage,range,crit_roll,crit_multiplier,is_paranormal,description,damage_kind_id) VALUES ('Espingarda',1,2,'4d6','Curto',20,3,false,'Arma de fogo longa e com cano liso.',1);
INSERT INTO tb_items(name,category,space,damage,range,crit_roll,crit_multiplier,is_paranormal,description,damage_kind_id) VALUES ('Fuzil de assalto',2,2,'2d10','Médio',19,3,false,'A arma de fogo padrão da maioria dos exércitos modernos.',1);

INSERT INTO tb_item_item_prop(item_id,item_prop_id) VALUES (1,4);
INSERT INTO tb_item_item_prop(item_id,item_prop_id) VALUES (2,1);
INSERT INTO tb_item_item_prop(item_id,item_prop_id) VALUES (3,1);
INSERT INTO tb_item_item_prop(item_id,item_prop_id) VALUES (4,1);
INSERT INTO tb_item_item_prop(item_id,item_prop_id) VALUES (5,1);
INSERT INTO tb_item_item_prop(item_id,item_prop_id) VALUES (6,4);
INSERT INTO tb_item_item_prop(item_id,item_prop_id) VALUES (7,3);
INSERT INTO tb_item_item_prop(item_id,item_prop_id) VALUES (8,3);
INSERT INTO tb_item_item_prop(item_id,item_prop_id) VALUES (9,3);
INSERT INTO tb_item_item_prop(item_id,item_prop_id) VALUES (10,3);
INSERT INTO tb_item_item_prop(item_id,item_prop_id) VALUES (10,2);
