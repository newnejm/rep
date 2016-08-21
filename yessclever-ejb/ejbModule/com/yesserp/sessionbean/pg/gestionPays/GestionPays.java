package com.yesserp.sessionbean.pg.gestionPays;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.Pays;


@Stateless
@LocalBean
public class GestionPays implements GestionPaysLocal{
	

	
    public GestionPays() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterPays(Pays i) {
		em.persist(i);
	}


	@Override
	public void supprimerPays(Pays i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierPays(Pays i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<Pays> AfficherTousPays() {
		
		Query query = em.createQuery("SELECT c FROM Pays c");
        return query.getResultList();
	}

	

	@Override
	public void  RemplireTablePays() {
		
	//	Query q=em.createQuery("CREATE TABLE 'TABLE_pays' ('code' int(11) NOT NULL auto_increment,'abreviation pays' varchar(2) NOT NULL,'fr' varchar(255) NOT NULL,'en' varchar(255) default NULL,PRIMARY KEY  ('id_pays'))");
		Query q2=em.createNativeQuery("insert into pg_pays (code) values (1)");
		q2.executeUpdate();
	//	, (2,'ZA','Afrique du Sud','South Africa'), (3,'AL','Albanie','Albania'), (4,'DZ','Alg�rie','Algeria'), (5,'DE','Allemagne','Germany'), (6,'AD','Andorre','Andorra'), (7,'AO','Angola','Angola'), (8,'AI','Anguilla','Anguilla'), (9,'AQ','Antarctique','Antarctica'), (10,'AG','Antigua-et-Barbuda','Antigua & Barbuda'), (11,'AN','Antilles n�erlandaises','Netherlands Antilles'), (12,'SA','Arabie saoudite','Saudi Arabia'), (13,'AR','Argentine','Argentina'), (14,'AM','Arm�nie','Armenia'), (15,'AW','Aruba','Aruba'), (16,'AU','Australie','Australia'), (17,'AT','Autriche','Austria'), (18,'AZ','Azerba�djan','Azerbaijan'), (19,'BJ','B�nin','Benin'), (20,'BS','Bahamas','Bahamas, The'), (21,'BH','Bahre�n','Bahrain'), (22,'BD','Bangladesh','Bangladesh'), (23,'BB','Barbade','Barbados'), (24,'PW','Belau','Palau'), (25,'BE','Belgique','Belgium'), (26,'BZ','Belize','Belize'), (27,'BM','Bermudes','Bermuda'), (28,'BT','Bhoutan','Bhutan'), (29,'BY','Bi�lorussie','Belarus'), (30,'MM','Birmanie','Myanmar (ex-Burma)'), (31,'BO','Bolivie','Bolivia'), (32,'BA','Bosnie-Herz�govine','Bosnia and Herzegovina'), (33,'BW','Botswana','Botswana'), (34,'BR','Br�sil','Brazil'), (35,'BN','Brunei','Brunei Darussalam'), (36,'BG','Bulgarie','Bulgaria'), (37,'BF','Burkina Faso','Burkina Faso'), (38,'BI','Burundi','Burundi'), (39,'CI','C�te d\'Ivoire','Ivory Coast (see Cote d\'Ivoire)'), (40,'KH','Cambodge','Cambodia'), (41,'CM','Cameroun','Cameroon'), (42,'CA','Canada','Canada'), (43,'CV','Cap-Vert','Cape Verde'), (44,'CL','Chili','Chile'), (45,'CN','Chine','China'), (46,'CY','Chypre','Cyprus'), (47,'CO','Colombie','Colombia'), (48,'KM','Comores','Comoros'), (49,'CG','Congo','Congo'), (50,'KP','Cor�e du Nord','Korea, Demo. People s Rep. of'), (51,'KR','Cor�e du Sud','Korea, (South) Republic of'), (52,'CR','Costa Rica','Costa Rica'), (53,'HR','Croatie','Croatia'), (54,'CU','Cuba','Cuba'), (55,'DK','Danemark','Denmark'), (56,'DJ','Djibouti','Djibouti'), (57,'DM','Dominique','Dominica'), (58,'EG','�gypte','Egypt'), (59,'AE','�mirats arabes unis','United Arab Emirates'), (60,'EC','�quateur','Ecuador'), (61,'ER','�rythr�e','Eritrea'), (62,'ES','Espagne','Spain'), (63,'EE','Estonie','Estonia'), (64,'US','�tats-Unis','United States'), (65,'ET','�thiopie','Ethiopia'), (66,'FI','Finlande','Finland'), (67,'FR','France','France'), (68,'GE','G�orgie','Georgia'), (69,'GA','Gabon','Gabon'), (70,'GM','Gambie','Gambia, the'), (71,'GH','Ghana','Ghana'), (72,'GI','Gibraltar','Gibraltar'), (73,'GR','Gr�ce','Greece'), (74,'GD','Grenade','Grenada'), (75,'GL','Groenland','Greenland'), (76,'GP','Guadeloupe','Guinea, Equatorial'), (77,'GU','Guam','Guam'), (78,'GT','Guatemala','Guatemala'), (79,'GN','Guin�e','Guinea'), (80,'GQ','Guin�e �quatoriale','Equatorial Guinea'), (81,'GW','Guin�e-Bissao','Guinea-Bissau'), (82,'GY','Guyana','Guyana'), (83,'GF','Guyane fran�aise','Guiana, French'), (84,'HT','Ha�ti','Haiti'), (85,'HN','Honduras','Honduras'), (86,'HK','Hong Kong','Hong Kong, (China)'), (87,'HU','Hongrie','Hungary'), (88,'BV','Ile Bouvet','Bouvet Island'), (89,'CX','Ile Christmas','Christmas Island'), (90,'NF','Ile Norfolk','Norfolk Island'), (91,'KY','Iles Cayman','Cayman Islands'), (92,'CK','Iles Cook','Cook Islands'), (93,'FO','Iles F�ro�','Faroe Islands'), (94,'FK','Iles Falkland','Falkland Islands (Malvinas)'), (95,'FJ','Iles Fidji','Fiji'), (96,'GS','Iles G�orgie du Sud et Sandwich du Sud','S. Georgia and S. Sandwich Is.'), (97,'HM','Iles Heard et McDonald','Heard and McDonald Islands'), (98,'MH','Iles Marshall','Marshall Islands'), (99,'PN','Iles Pitcairn','Pitcairn Island'), (100,'SB','Iles Salomon','Solomon Islands'), (101,'SJ','Iles Svalbard et Jan Mayen','Svalbard and Jan Mayen Islands'), (102,'TC','Iles Turks-et-Caicos','Turks and Caicos Islands'), (103,'VI','Iles Vierges am�ricaines','Virgin Islands, U.S.'), (104,'VG','Iles Vierges britanniques','Virgin Islands, British'), (105,'CC','Iles des Cocos (Keeling)','Cocos (Keeling) Islands'), (106,'UM','Iles mineures �loign�es des �tats-Unis','US Minor Outlying Islands'), (107,'IN','Inde','India'), (108,'ID','Indon�sie','Indonesia'), (109,'IR','Iran','Iran, Islamic Republic of'), (110,'IQ','Iraq','Iraq'), (111,'IE','Irlande','Ireland'), (112,'IS','Islande','Iceland'), (113,'IL','Isra�l','Israel'), (114,'IT','Italie','Italy'), (115,'JM','Jama�que','Jamaica'), (116,'JP','Japon','Japan'), (117,'JO','Jordanie','Jordan'), (118,'KZ','Kazakhstan','Kazakhstan'), (119,'KE','Kenya','Kenya'), (120,'KG','Kirghizistan','Kyrgyzstan'), (121,'KI','Kiribati','Kiribati'), (122,'KW','Kowe�t','Kuwait'), (123,'LA','Laos','Lao People s Democratic Republic'), (124,'LS','Lesotho','Lesotho'), (125,'LV','Lettonie','Latvia'), (126,'LB','Liban','Lebanon'), (127,'LR','Liberia','Liberia'), (128,'LY','Libye','Libyan Arab Jamahiriya'), (129,'LI','Liechtenstein','Liechtenstein'), (130,'LT','Lituanie','Lithuania'), (131,'LU','Luxembourg','Luxembourg'), (132,'MO','Macao','Macao, (China)'), (133,'MG','Madagascar','Madagascar'), (134,'MY','Malaisie','Malaysia'), (135,'MW','Malawi','Malawi'), (136,'MV','Maldives','Maldives'), (137,'ML','Mali','Mali'), (138,'MT','Malte','Malta'), (139,'MP','Mariannes du Nord','Northern Mariana Islands'), (140,'MA','Maroc','Morocco'), (141,'MQ','Martinique','Martinique'), (142,'MU','Maurice','Mauritius'), (143,'MR','Mauritanie','Mauritania'), (144,'YT','Mayotte','Mayotte'), (145,'MX','Mexique','Mexico'), (146,'FM','Micron�sie','Micronesia, Federated States of'), (147,'MD','Moldavie','Moldova, Republic of'), (148,'MC','Monaco','Monaco'), (149,'MN','Mongolie','Mongolia'), (150,'MS','Montserrat','Montserrat'), (151,'MZ','Mozambique','Mozambique'), (152,'NP','N�pal','Nepal'), (153,'NA','Namibie','Namibia'), (154,'NR','Nauru','Nauru'), (155,'NI','Nicaragua','Nicaragua'), (156,'NE','Niger','Niger'), (157,'NG','Nigeria','Nigeria'), (158,'NU','Niou�','Niue'), (159,'NO','Norv�ge','Norway'), (160,'NC','Nouvelle-Cal�donie','New Caledonia'), (161,'NZ','Nouvelle-Z�lande','New Zealand'), (162,'OM','Oman','Oman'), (163,'UG','Ouganda','Uganda'), (164,'UZ','Ouzb�kistan','Uzbekistan'), (165,'PE','P�rou','Peru'), (166,'PK','Pakistan','Pakistan'), (167,'PA','Panama','Panama'), (168,'PG','Papouasie-Nouvelle-Guin�e','Papua New Guinea'), (169,'PY','Paraguay','Paraguay'), (170,'NL','TABLE_pays-Bas','Netherlands'), (171,'PH','Philippines','Philippines'), (172,'PL','Pologne','Poland'), (173,'PF','Polyn�sie fran�aise','French Polynesia'), (174,'PR','Porto Rico','Puerto Rico'), (175,'PT','Portugal','Portugal'), (176,'QA','Qatar','Qatar'), (177,'CF','R�publique centrafricaine','Central African Republic'), (178,'CD','R�publique d�mocratique du Congo','Congo, Democratic Rep. of the'), (179,'DO','R�publique dominicaine','Dominican Republic'), (180,'CZ','R�publique tch�que','Czech Republic'), (181,'RE','R�union','Reunion'), (182,'RO','Roumanie','Romania'), (183,'GB','Royaume-Uni','Saint Pierre and Miquelon'), (184,'RU','Russie','Russia (Russian Federation)'), (185,'RW','Rwanda','Rwanda'), (186,'SN','S�n�gal','Senegal'), (187,'EH','Sahara occidental','Western Sahara'), (188,'KN','Saint-Christophe-et-Ni�v�s','Saint Kitts and Nevis'), (189,'SM','Saint-Marin','San Marino'), (190,'PM','Saint-Pierre-et-Miquelon','Saint Pierre and Miquelon'), (191,'VA','Saint-Si�ge ','Vatican City State (Holy See)'), (192,'VC','Saint-Vincent-et-les-Grenadines','Saint Vincent and the Grenadines'), (193,'SH','Sainte-H�l�ne','Saint Helena'), (194,'LC','Sainte-Lucie','Saint Lucia'), (195,'SV','Salvador','El Salvador'), (196,'WS','Samoa','Samoa'), (197,'AS','Samoa am�ricaines','American Samoa'), (198,'ST','Sao Tom�-et-Principe','Sao Tome and Principe'), (199,'SC','Seychelles','Seychelles'), (200,'SL','Sierra Leone','Sierra Leone'), (201,'SG','Singapour','Singapore'), (202,'SI','Slov�nie','Slovenia'), (203,'SK','Slovaquie','Slovakia'), (204,'SO','Somalie','Somalia'), (205,'SD','Soudan','Sudan'), (206,'LK','Sri Lanka','Sri Lanka (ex-Ceilan)'), (207,'SE','Su�de','Sweden'), (208,'CH','Suisse','Switzerland'), (209,'SR','Suriname','Suriname'), (210,'SZ','Swaziland','Swaziland'), (211,'SY','Syrie','Syrian Arab Republic'), (212,'TW','Ta�wan','Taiwan'), (213,'TJ','Tadjikistan','Tajikistan'), (214,'TZ','Tanzanie','Tanzania, United Republic of'), (215,'TD','Tchad','Chad'), (216,'TF','Terres australes fran�aises','French Southern Territories - TF'), (217,'IO','Territoire britannique de l Oc�an Indien','British Indian Ocean Territory'), (218,'TH','Tha�lande','Thailand'), (219,'TL','Timor Oriental','Timor-Leste (East Timor)'), (220,'TG','Togo','Togo'), (221,'TK','Tok�laou','Tokelau'), (222,'TO','Tonga','Tonga'), (223,'TT','Trinit�-et-Tobago','Trinidad & Tobago'), (224,'TN','Tunisie','Tunisia'), (225,'TM','Turkm�nistan','Turkmenistan'), (226,'TR','Turquie','Turkey'), (227,'TV','Tuvalu','Tuvalu'), (228,'UA','Ukraine','Ukraine'), (229,'UY','Uruguay','Uruguay'), (230,'VU','Vanuatu','Vanuatu'), (231,'VE','Venezuela','Venezuela'), (232,'VN','Vi�t Nam','Viet Nam'), (233,'WF','Wallis-et-Futuna','Wallis and Futuna'), (234,'YE','Y�men','Yemen'), (235,'YU','Yougoslavie','Saint Pierre and Miquelon'), (236,'ZM','Zambie','Zambia'), (237,'ZW','Zimbabwe','Zimbabwe'), (238,'MK','ex-R�publique yougoslave de Mac�doine','Macedonia, TFYR')");
		
	}
/*
	@Override
	public List<Pays> trouverParNumPays(String numPays) {
		
		Query q=em.createQuery("select from Pays i where numPays = :numPays");
		q.setParameter("numPays",numPays);
		List<Pays> li=null;
		try {
			li= (List<Pays>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

*/	

	

	
}
