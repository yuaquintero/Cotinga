package com.example.sennova.cotinga;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Clase encargada de crear la base de datos local SQlite con la información de todas las aves
 * Con la propiedad SQLiteOpenHelper se crea una tabla con los parametros de cada ave
 *
 */

public class Aves_bd extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME="AvesBD";
    private static final int DATA_VERSION=1;
    String sqlCreate="CREATE TABLE Aves(codigo INTEGER PRIMARY KEY AUTOINCREMENT,color1 TEXT,color2 TEXT,colorpata TEXT,pico TEXT, forma TEXT, espanol TEXT, ingles TEXT, cientifico TEXT, residencia TEXT, conserva TEXT, link TEXT, rutas TEXT, vistas TEXT )";
    String iniciales="INSERT INTO Aves(color1,color2,colorpata,pico,forma,espanol,ingles,cientifico,residencia,conserva,link,rutas,vistas)VALUES" +

            "('4','6','9','8','10','Tinamú Cabecirrojo','Tawny-breasted Tinamou','Nothocercus julius','1','0','http://www.xeno-canto.org/236629','0','0'),"+
            "('4','6','9','10','8','Cormorán neotropical','Neotropic Cormorant','Phalacrocorax brasilianus','1','0','http://www.xeno-canto.org/227629','13','0'),"+
            "('3','3','1','10','8','Garcilla bueyera','Cattle egret','Bubulcus ibis','1','0','http://www.xeno-canto.org/148199','15','0'),"+
            "('3','3','9','10','8','Garza real','Great Egret','Ardea alba','1','0','http://www.xeno-canto.org/219024','9','0'),"+
            "('2','6','1','10','8','Garcita estriada','Striated heron','Butorides striata','1','0','http://www.xeno-canto.org/327284','13','0'),"+
            "('9','4','1','10','8','Ibis afeitado o coquito','Bare-faced Ibis','Phimosus infuscatus','1','0','http://www.xeno-canto.org/46344','15','0'),"+
            "('4','17','1','6','9','Barraquete aliazul','Blue-winged teal','Anas discors','0','0','http://www.xeno-canto.org/163734','13','0'),"+
            "('3','9','1','6','9','Pato torrentero','Torrent Duck','Merganetta armata','1','0','http://www.xeno-canto.org/98802','15','0'),"+
            "('9','11','11','1','1','Guala Cabeciroja','Turkey vulture','Cathartes aura','1','0','sin','15','0'),"+
            "('9','9','9','1','1','Gallinazo','Black vulture','Coragyps atratus','1','0','sin','15','0'),"+
            "('3','6','9','1','1','Aguila Pescadora','Osprey','Pandion haliaetus','0','0','http://www.xeno-canto.org/124926','9','0'),"+
            "('3','9','9','1','1','Aguila Tijereta','Swallow-tailed kite','Elanoides forticatus','0','0','sin','4','0'),"+
            "('6','4','1','1','1','Caracolero piquiganchudo','Hook-billed Kite','Chondrohierax uncinatus','1','0','http://www.xeno-canto.org/257345','7','0'),"+
            "('3','6','1','1','1','Elanio maromero','White-tailed kite','Elanus leucurus','1','0','http://www.xeno-canto.org/48397','8','0'),"+
            "('3','9','1','1','1','Elanio enano','Pearl Kite','Gampsonyx swainsonii','1','0','http://www.xeno-canto.org/37116','1','0'),"+
            "('4','6','1','1','1','Gavilán Pollero','Roadside Hawk','Buteo magnirostris','1','0','sin','15','0'),"+
            "('4','3','1','1','1','Gavilán americano','Sharp-shinned hawk','Accipiter striatus','1','0','sin','7','0'),"+
            "('4','17','1','1','1','Gavilan aliancho','Broad-winged hawk','Buteo platypterus','0','0','http://www.xeno-canto.org/353341','15','0'),"+
            "('9','3','1','1','1','Gavilan colicorto','Short-tailed Hawk','Buteo brachyurus','1','0','http://www.xeno-canto.org/97291','4','0'),"+
            "('3','6','1','1','1','Gavilán coliblanco','White-tailed hawk','Buteo albicaudatus','1','0','sin','3','0'),"+
            "('9','3','1','1','1','Gavilan negro','White-rumped hawk','Parabuteo lueucurrhous','1','0','http://www.xeno-canto.org/343838','1','0'),"+
            "('9','4','1','1','1','Aguila poma','Black-and-chestnut Eagle','Spizaetus isidori','1','1','http://www.xeno-canto.org/252691','7','0'),"+
            "('9','3','1','1','1','Caracara muñudo','Crested caracara','Caracara cheriway','1','0','http://www.xeno-canto.org/92403','15','0'),"+
            "('3','4','1','1','1','Pigua','Yellow-headed Caracara','Milvago chimachima','1','0','http://www.xeno-canto.org/345960','15','0'),"+
            "('4','3','1','1','1','Halcón reidor','Laughing falcon','Herpetotheres cachinnans','1','0','http://www.xeno-canto.org/335012','14','0'),"+
            "('4','6','1','1','1','Cernícalo americano','American kestrel','Falco sparverius','1','0','http://www.xeno-canto.org/79761','15','0'),"+
            "('4','4','11','8','10','Guacharaca','Colombian chachalaca','Ortalis columbiana','1','0','http://www.xeno-canto.org/353890','15','0'),"+
            "('4','13','11','8','10','Pava maraquera','Sickle-winged Guan','Chamaepetes goudotii','1','0','http://www.xeno-canto.org/311822','15','0'),"+
            "('4','13','9','8','10','Perdiz colorada','Chestnut wood quail','Odontophorus hyperythrus','1','2','http://www.xeno-canto.org/354285','7','0'),"+
            "('6','4','1','10','10','Rascón negruzco','Blackish rail','Pardirallus nigricans','1','0','http://www.xeno-canto.org/315911','9','0'),"+
            "('3','4','11','10','10','Caravana','Southern lapwing','Vanellus chilensis','1','0','http://www.xeno-canto.org/114069','15','0'),"+
            "('4','3','1','10','10','Agachadiza noble','Noble Snipe','Gallinago nobilis','1','0','http://www.xeno-canto.org/273811','0','0'),"+
            "('6','3','11','8','7','Paloma collareja','Band-tailed Pigeon','Patagioenas fasciata','1','0','http://www.xeno-canto.org/236036','8','0'),"+
            "('7','13','11','8','7','Paloma colorada','Pale-vented Pigeon','Patagioenas cayennensis','1','0','http://www.xeno-canto.org/353930','8','0'),"+
            "('4','9','11','8','7','Tortolita','Ruddy ground dove','Columbina talpacoti','1','0','http://www.xeno-canto.org/353901','8','0'),"+
            "('4','6','11','8','7','Torcaza naguiblanca','Eared Dove','Zenaida auriculata','1','0','http://www.xeno-canto.org/299431','8','0'),"+
            "('4','6','11','8','7','Paloma montaraz común','White-tipped Dove','Leptotila verreauxi','1','0','http://www.xeno-canto.org/344308','8','0'),"+
            "('4','6','11','8','7','Paloma perdiz gorjiblanca','White-throated Quail-Dove','Geotrygon frenata','1','0','http://www.xeno-canto.org/119738','0','0'),"+
            "('15','11','9','3','4','Cotorra frentirroja','Scarlet-fronted Parakeet','Psittacara wagleri','1','0','http://www.xeno-canto.org/312953','0','0'),"+
            "('15','1','9','3','4','Loro Orejiamarillo','Yellow-eared parrot','Ognorhynchus icterotis','1','2','http://www.xeno-canto.org/354201','8','0'),"+
            "('15','2','9','3','4','Periquito de anteojos','Spectacled Parrotlet','Forpus conspicillatus','1','0','http://www.xeno-canto.org/354206','8','0'),"+
            "('15','11','9','3','4','Cotorra gorriblanca','Speckle-faced parrot','Pionus tumultuosus','1','0','http://www.xeno-canto.org/299369','0','0'),"+
            "('7','11','11','3','4','Cotorra alibronceada o mocha','Bronze-winged Parrot','Pionus chalcopterus','1','0','http://www.xeno-canto.org/273655','8','0'),"+
            "('4','3','4','7','10','Cuco ardilla','Squirrel Cuckoo','Piaya cayana','1','0','http://www.xeno-canto.org/244789','8','0'),"+
            "('9','9','9','10','10','Garrapatero','Smooth-billed Ani','Crotophaga ani','1','0','http://www.xeno-canto.org/240064','8','0'),"+
            "('3','4','1','1','2','Lechuza común','Barn owl','Tyto alba','1','0','http://www.xeno-canto.org/313519','8','0'),"+
            "('4','6','9','1','2','Currucutu','Tropical Screech Owl','Megascops choliba','1','0','http://www.xeno-canto.org/265399','8','0'),"+
            "('4','4','9','1','2','Buho ocelado','Rufous-banded owl','strix albitarsis','1','0','http://www.xeno-canto.org/311827','0','0'),"+
            "('13','4','1','1','2','Mochuelo andino','Andean Pygmy-Owl','Glaucidium jardinii','1','0','http://www.xeno-canto.org/302282','0','0'),"+
            "('6','4','0','7','10','Bienparado comun','Common potoo','Nyctibius griseus','1','0','http://www.xeno-canto.org/344325','0','0'),"+
            "('4','4','0','10','10','Chotacabras pauraque','Common pauraque','Nyctidromus albicollis','1','0','http://www.xeno-canto.org/344326','8','0'),"+
            "('6','4','0','10','10','Guardacaminos andino','Band-winged nightjar','Caprimulgus longirostris','1','0','http://www.xeno-canto.org/344326','0','0'),"+
            "('4','4','0','10','10','Guardacaminos lyra','Lyre-tailed Nightjar','Uropsalis lyra','1','0','http://www.xeno-canto.org/291410','0','0'),"+
            "('9','3','9','10','10','Vencejo acollarado','White-collared swift','Streptoprocne zonaris','1','0','http://www.xeno-canto.org/116378','8','0'),"+
            "('4','13','9','10','6','Vencejo cuellirrojo','Chestnut-collared swift','Streptoprocne rutila','1','0','http://www.xeno-canto.org/273667','8','0'),"+
            "('15','4','11','10','6','Ermitaño verde','Green hermit','Phaethornis guy','1','0','http://www.xeno-canto.org/128060','8','0'),"+
            "('4','13','11','2','3','Ermitaño ventrihabano','Tawny-bellied hermit','Phaethornis syrmatophorus','1','0','http://www.xeno-canto.org/344329','0','0'),"+
            "('15','5','9','2','3','Colibrí picolanza mayor','Green-fronted lancebill','Doryfera ludovicae','1','0','http://www.xeno-canto.org/273887','8','0'),"+
            "('15','16','9','2','3','Colibrí verdemar','Green Violet-ear','Colibri thalassinus','1','0','http://www.xeno-canto.org/241503','8','0'),"+
            "('2','3','9','2','3','Colibrí nuquiblanco','White-necked jacobin','Florisuga melivora','1','0','http://www.xeno-canto.org/302215','8','0'),"+
            "('15','16','9','2','3','Colibrí rutilante','Sparkling violetear','Colibri coruscans','1','0','http://www.xeno-canto.org/353894','0','0'),"+
            "('10','16','9','2','3','Colibrí pardo','Brown violetear','Colibri delphinae','1','0','http://www.xeno-canto.org/344350','0','0'),"+
            "('15','9','9','2','3','Mango pechinegro','Black-throated Mango','Anthracothorax nigricollis','1','0','http://www.xeno-canto.org/353891','8','0'),"+
            "('15','15','9','2','3','Esmeralda Occidental','Western emerald','Chlorostilbon melanorhynchus','1','0','http://www.xeno-canto.org/115488','8','0'),"+
            "('15','3','9','2','3','Esmeralda andina','Andean Emerald','Amazilia franciae','1','0','http://www.xeno-canto.org/260479','8','0'),"+
            "('15','2','9','0','0','Amazilia verdiazul','Steely-vented hummingbird','Amazilia saucerrottei','1','0','http://www.xeno-canto.org/6392','8','0'),"+
            "('15','13','9','0','0','Amazilia colirufa','Rufous-tailed Hummingbird','Amazilia tzacatl','1','0','http://www.xeno-canto.org/271052','8','0'),"+
            "('15','4','11','0','0','Colibrí pechipunteado','Speckled Hummingbird','Adelomyia melanogenys','1','0','http://www.xeno-canto.org/299428','8','0'),"+
            "('15','4','11','0','0','Brillante pechigamuza','Fawn-breasted Brilliant','Heliodoxa rubinoides','1','0','http://www.xeno-canto.org/260497','8','0'),"+
            "('15','3','9','0','0','Brillante emperador','Empress brilliant','Heliodoxa imperatrix','1','0','http://www.xeno-canto.org/108952','0','0'),"+
            "('9','13','1','0','0','Halcon Murcielaguero','Bat Falcon','Falco rufigularis','1','1','sin','8','0'),"+
            "('15','9','9','0','0','Colibrí aterciopelado','mountain velvetbreast','Lafresnaya lafresnayi','1','0','http://www.xeno-canto.org/251033','0','0'),"+
            "('4','3','9','0','0','Inca bronceado','Bronzy Inca','Coeligena coeligena','1','0','http://www.xeno-canto.org/260504','0','0'),"+
            "('4','7','9','0','0','Inca pardo','Brown inca','Coeligena wilsoni','1','0','http://www.xeno-canto.org/275268','0','0'),"+
            "('15','5','9','0','0','Inca de Antioquía','Dusky Starfrontlet','Coeligena orina','1','3','http://www.xeno-canto.org/354209','0','0'),"+
            "('9','3','9','0','0','Inca acollarado','Collared inca','Coeligena torquata','1','0','http://www.xeno-canto.org/260506','0','0'),"+
            "('15','4','9','0','0','Colibrí picoespada','Sword-billed hummingbird','Ensifera ensifera','1','0','http://www.xeno-canto.org/260507','0','0'),"+
            "('15','17','9','0','0','Colibrí colihabano','Buff-tailed coronet','Boissonneaua flavescens','1','0','http://www.xeno-canto.org/260508','0','0'),"+
            "('7','9','9','0','0','Colibrí sietecolores','Velvet-purple Coronet','Boissonneaua jardini','1','0','http://www.xeno-canto.org/261762','0','0'),"+
            "('15','11','9','0','0','Colibrí turmalina','Tourmaline sunangel','Heliangelus exortis','1','0','http://www.xeno-canto.org/117488','0','0'),"+
            "('15','2','9','0','0','Calzadito reluciente','Glowing Puffleg','Eriocnemis vestita','1','0','http://www.xeno-canto.org/121114','0','0'),"+
            "('15','5','9','0','0','Calzadito verdoso norteño','Greenish Puffleg','Haplophaedia aureliae','1','0','http://www.xeno-canto.org/129834','0','0'),"+
            "('15','3','9','0','0','Colibrí de raquetas','Booted Racket-tail','Ocreatus underwoodii','1','0','http://www.xeno-canto.org/273648','0','0'),"+
            "('7','15','9','0','0','Colibri dorsimorado','Purple-backed Thornbill','Ramphomicron microrhynchum','1','0','http://www.xeno-canto.org/261765','0','0'),"+
            "('15','4','9','0','0','Metalura tiria','Tyrian metaltail','Metallura tyrianthina','1','0','http://www.xeno-canto.org/353239','0','0'),"+
            "('15','2','9','0','0','Silfo coliverde','Long-tailed sylph','Aglaiocercus kingi','1','0','http://www.xeno-canto.org/275707','0','0'),"+
            "('15','7','9','0','0','Silfo coliceleste','Violet-tailed sylph','Aglaiocercus coelestis','1','0','http://www.xeno-canto.org/264485','0','0'),"+
            "('15','6','9','0','0','Colibrí piquilargo','Long-billed starthroat','Heliomaster longirostris','1','0','http://www.xeno-canto.org/260534','0','0'),"+
            "('15','7','9','0','0','Colibrí de Mitchell','Purple-throated woodstar','Calliphlox mitchellii','1','0','http://www.xeno-canto.org/257869','0','0'),"+
            "('15','3','9','0','0','Colibrí de Mulsant','White-bellied Woodstar','Chaetocercus mulsant','1','0','http://www.xeno-canto.org/260536','0','0'),"+
            "('15','11','9','0','0','Quetzal cabecidorado','Golden-headed quetzal','Pharomachrus auriceps','1','0','http://www.xeno-canto.org/273890','0','0'),"+
            "('15','11','9','0','0','Trogón acollarado','Collared trogon','Trogon collaris','1','0','http://www.xeno-canto.org/353751','0','0'),"+
            "('15','11','9','0','0','trogon enmascarado','Masked trogon','Trogon personatus','1','0','http://www.xeno-canto.org/347842','0','0'),"+
            "('2','13','11','0','0','Martín pescador gigante','Ringed kingfisher','Megaceryle torquata','1','0','http://www.xeno-canto.org/56958','0','0'),"+
            "('0','0','0','0','0','Guardacaminos Migratorio','Common Nighthawk','chordeiles minor','0','0','sin','0','0'),"+
            "('15','3','9','0','0','Martín pescador verde','Green Kingfisher','Chloroceryle americana','1','0','http://www.xeno-canto.org/148103','0','0'),"+
            "('15','2','9','0','0','Barranquero','Andean Motmot','Momotus aequatorialis','1','0','http://www.xeno-canto.org/344320','0','0'),"+
            "('4','3','9','0','0','Bigotudo canoso','Moustached puffbird','Malacoptila mystacalis','1','0','http://www.xeno-canto.org/354181','0','0'),"+
            "('4','3','9','0','0','Buco cariblanco','White-faced Nunbird','Hapaloptila castanea','1','0','http://www.xeno-canto.org/260581','0','0'),"+
            "('15','11','9','0','0','Torito cabecirrojo','Red-headed barbet','Eubucco bourcierii','1','0','http://www.xeno-canto.org/344374','0','0'),"+
            "('15','11','9','0','0','Tucaneta esmeralda','Emerald toucanet','Aulacorhynchus prasinus','1','0','http://www.xeno-canto.org/98822','0','0'),"+
            "('15','2','9','0','0','Tucaneta culirroja','Crimson-rumped toucanet','Aulacorhynchus haematopygus','1','0','http://www.xeno-canto.org/310770','0','0'),"+
            "('2','3','9','0','0','Terlaque pechiazul','Black-billed Mountain Toucan','Andigena nigrirostris','1','1','http://www.xeno-canto.org/344416','0','0'),"+
            "('6','18','9','0','0','Carpinterito colombiano','Greyish Piculet','Picumnus granadensis','1','0','http://www.xeno-canto.org/354216','0','0'),"+
            "('11','1','9','0','0','Carpintero carmesi','Crimson-mantled Woodpecker','Colaptes rivolii','1','0','http://www.xeno-canto.org/130348','0','0'),"+
            "('18','11','9','0','0','Carpintero oliváceo','Golden-olive Woodpecker','Colaptes rubiginosus','1','0','http://www.xeno-canto.org/240044','0','0'),"+
            "('9','11','9','0','0','Carpintero real','Lineated woodpecker','Dryocopus lineatus','1','0','http://www.xeno-canto.org/48880','0','0'),"+
            "('9','3','9','0','0','Carpintero bellotero','Acorn Woodpecker','Melanerpes formicivorus','1','0','http://www.xeno-canto.org/57098','0','0'),"+
            "('6','9','9','0','0','Carpintero habado','Red-crowned Woodpecker','Melanerpes rubricapillus','1','0','http://www.xeno-canto.org/274160','0','0'),"+
            "('4','11','9','0','0','Carpintero ahumado','Smoky-brown Woodpecker','Picoides fumigatus','1','0','http://www.xeno-canto.org/57501','0','0'),"+
            "('9','11','0','0','0','Carpintero ventriamarillo','Yellow-vented Woodpecker','Veniliornis dignus','1','0','http://www.xeno-canto.org/51077','0','0'),"+
            "('9','11','9','0','0','Carpintero gigante','Powerful woodpecker','Campephilus pollens','1','0','http://www.xeno-canto.org/16848','0','0'),"+
            "('4','4','9','0','0','Trepatroncos Tiranino','Tyrannine Woodcreeper','Dendrocincla tyrannina','1','0','http://www.xeno-canto.org/273936','0','0'),"+
            "('4','3','9','0','0','Trepatroncos Manchado','Spotted woodcreeper','Xiphorhynchus erythropygius','1','0','http://www.xeno-canto.org/241539','0','0'),"+
            "('4','3','9','0','0','Trepatroncos Cabecirrayado','Streak-headed woodcreeper','Lepidocolaptes souleyetii','1','0','http://www.xeno-canto.org/16771','0','0'),"+
            "('4','3','9','0','0','Trepatroncos Montano','Montane woodcreeper','Lepidocolaptes lacrymiger','1','0','http://www.xeno-canto.org/276133','0','0'),"+
            "('4','4','9','0','0','Picoguadaña Andino','Brown-billed scythebill','Campylorhamphus pusillus','1','0','http://www.xeno-canto.org/131806','0','0'),"+
            "('4','6','9','0','0','Piscuis de Azara','Azaras Spinetail','Synallaxis azarae','1','0','http://www.xeno-canto.org/344361','0','0'),"+
            "('13','9','9','0','0','Chamicero de antifaz','Rufous spinetail','Synallaxis unirufa','1','0','http://www.xeno-canto.org/353244','0','0'),"+
            "('4','6','9','0','0','Chamicero palido','Pale-breasted Spinetail','Synallaxis albescens','1','0','http://www.xeno-canto.org/353740','0','0'),"+
            "('4','3','9','0','0','Chamicero cejiblanco','White-browed spinetail','Hellmayrea gularis','1','0','http://www.xeno-canto.org/119733','0','0'),"+
            "('13','6','11','0','0','Chamicero rubicundo','Red-faced Spinetail','Cranioleuca erythrops','1','0','http://www.xeno-canto.org/148271','0','0'),"+
            "('4','3','9','0','0','Trepatroncos Perlado','Pearled treerunner','Margarornis squamiger','1','0','http://www.xeno-canto.org/273418','0','0'),"+
            "('4','5','9','0','0','Trepatroncos Moteado','Spotted barbtail','Premnoplex brunnescens','1','0','http://www.xeno-canto.org/273617','0','0'),"+
            "('4','3','9','0','0','Trepatroncos gorgiblanco','Streaked tuftedcheek','Pseudocolaptes boissonneautii','1','0','http://www.xeno-canto.org/10764','0','0'),"+
            "('13','6','9','0','0','Hojarasquero montañero','Montane foliage-gleaner','Anabacerthia striaticollis','1','0','http://www.xeno-canto.org/312950','0','0'),"+
            "('4','3','9','0','0','Hojarasquero grande','Flammulated treehunter','Thripadectes flammulatus','1','0','http://www.xeno-canto.org/313048','0','0'),"+
            "('4','6','9','0','0','Xenops estriado','Streaked xenops','Xenops rutilans','1','0','http://www.xeno-canto.org/234210','0','0'),"+
            "('4','4','9','0','0','Saltarocas punteado','Sharp-tailed streamcreeper','Lochmias nematura','1','0','http://www.xeno-canto.org/346292','0','0'),"+
            "('6','3','9','0','0','Batará Carcajada','Bar-crested antshrike','Thamnophilus multistriatus','1','0','http://www.xeno-canto.org/353882','0','0'),"+
            "('1','6','9','0','0','Hormiguero Tiznado','Plain antvireo','Dysithamnus mentalis','1','0','http://www.xeno-canto.org/273407','0','0'),"+
            "('6','4','9','0','0','Hormiguero de Parker','Parker´s Antbird','Cercomacra parkeri','1','0','http://www.xeno-canto.org/344298','0','0'),"+
            "('4','6','9','0','0','Hormiguerito Rabilargo','Streak-headed Antbird','Drymophila striaticeps','1','0','http://www.xeno-canto.org/179738','0','0'),"+
            "('4','13','9','0','0','Tororoí gigante','Giant antpitta','Grallaria gigantea','1','1','http://www.xeno-canto.org/282395','0','0'),"+
            "('3','13','9','0','0','Tororoí Comprapan','Chestnut-crowned Antpitta','Grallaria ruficapilla','1','0','http://www.xeno-canto.org/353248','0','0'),"+
            "('13','6','9','0','0','Tororoí Nuquicastaño','Chestnut-naped Antpitta','Grallaria nuchalis','1','0','http://www.xeno-canto.org/302276','0','0'),"+
            "('13','13','9','0','0','Tororoí Rufo','Rufous Antpitta','Grallaria rufula','1','0','http://www.xeno-canto.org/353225','0','0'),"+
            "('6','13','9','0','0','Totoroí Enano','Slaty-crowned antpitta','Grallaricula nana','1','0','http://www.xeno-canto.org/354324','0','0'),"+
            "('9','9','9','0','0','Tapaculo Negruzco','Blackish Tapaculo','Scytalopus latrans','1','0','http://www.xeno-canto.org/354323','0','0'),"+
            "('9','4','9','0','0','Tapaculo de Spillmann','Spillmann´s tapaculo','Scytalopus Spillmanni','1','0','http://www.xeno-canto.org/186095','0','0'),"+
            "('13','9','9','0','0','Tapaculo Ocelado','Ocellated tapaculo','Acropternis orthonyx','1','0','http://www.xeno-canto.org/301259','0','0'),"+
            "('11','9','11','0','0','Gallito de Roca','Andean cock-of-the-rock','Rupicola peruvianus','1','0','http://www.xeno-canto.org/146364','0','0'),"+
            "('6','11','9','0','0','Cotinga Crestirroja','Red-crested cotinga','Ampelion rubrocristatus','1','0','http://www.xeno-canto.org/11217','0','0'),"+
            "('6','13','9','0','0','Cotinga Cresticastaño','Chestnut-crested cotinga','Ampelion rufaxilla','1','1','http://www.xeno-canto.org/59259','0','0'),"+
            "('15','9','11','0','0','Frutero Verdinegro','Green-and-black Fruiteater','Pipreola riefferii','1','0','http://www.xeno-canto.org/354321','0','0'),"+
            "('15','9','9','0','0','Frutero Barrado','Barred fruiteater','Pipreola arcuata','1','0','http://www.xeno-canto.org/53623','0','0'),"+
            "('6','6','9','0','0','Guardabosques cenizo','Dusky Piha','Lipaugus fuscocinereus','1','0','http://www.xeno-canto.org/302213','0','0'),"+
            "('1','9','9','0','0','Becard Barrado','Barred becard','Pachyramphus versicolor','1','0','http://www.xeno-canto.org/92744','0','0'),"+
            "('9','6','9','0','0','Becard Aliblanco','White-winged Becard','Pachyramphus polychopterus','1','0','http://www.xeno-canto.org/244797','0','0'),"+
            "('1','9','9','0','0','Mosquerito Capirotado','Black-capped Tyrannulet','Phyllomyias nigrocapillus','1','0','http://www.xeno-canto.org/354116','0','0'),"+
            "('0','1','9','0','0','Mosquerito Caridorado','Golden-faced Tyrannulet','Zimmerius chrysops','1','0','http://www.xeno-canto.org/353753','0','0'),"+
            "('1','6','9','0','0','Mosquerito Silbón','Southern Beardless Tyrannulet ·','Camptostoma obsoletum','1','0','http://www.xeno-canto.org/344295','0','0'),"+
            "('6','1','9','0','0','Elaenia Copetona','Yellow-bellied Elaenia','Elaenia flavogaster','1','0','http://www.xeno-canto.org/235741','0','0'),"+
            "('18','6','9','0','0','Elaenia Montañera','Mountain Elaenia','Elaenia frantzii','1','0','http://www.xeno-canto.org/241243','0','0'),"+
            "('18','6','9','0','0','Mosquero Verdoso','Acadian flycatcher','Empidonax virescens','0','0','http://www.xeno-canto.org/240101','0','0'),"+
            "('4','3','9','0','0','Tiranuelo Gorgiblanco','White-banded Tyrannulet','Mecocerculus leucophrys','1','0','http://www.xeno-canto.org/356616','0','0'),"+
            "('1','6','9','0','0','Siriri Bueyero','Cattle tyrant','Machetornis rixosa','1','0','http://www.xeno-canto.org/128386','0','0'),"+
            "('6','18','9','0','0','Tiranuelo Colilargo','White-banded tyrannulet','Mecocerculus stictopterus','1','0','http://www.xeno-canto.org/101713','0','0'),"+
            "('6','9','9','0','0','Tiranuelo Saltarroyos','Torrent Tyrannulet','Serpophaga cinerea','1','0','http://www.xeno-canto.org/264679','0','0'),"+
            "('18','15','9','0','0','Mosquero Gorgiestriado','Streak-necked flycatcher','Mionectes striaticollis','1','0','http://www.xeno-canto.org/264682','0','0'),"+
            "('18','6','9','0','0','Atrapamoscas sepia','Slaty-capped flycatcher','Leptopogon superciliaris','1','0','http://www.xeno-canto.org/240093','0','0'),"+
            "('1','13','9','0','0','Atrapamoscas pechirrufo','Rufous-breasted flycatcher','Leptopogon rufipectus','1','0','http://www.xeno-canto.org/354273','0','0'),"+
            "('1','6','9','0','0','Atrapamoscas marmoreo','Marble-faced Bristle-Tyrant','Phylloscartes ophthalmicus','1','0','sin','0','0'),"+
            "('1','6','9','0','0','Atrapamoscas variegado','Variegated Bristle-Tyrant','Phylloscartes poecilotis','1','0','sin','0','0'),"+
            "('18','13','9','0','0','Tiranuelo coronado','Rufous-crowned Tody-Flycatcher','Poecilotriccus ruficeps','1','0','http://www.xeno-canto.org/101703','0','0'),"+
            "('1','13','9','0','0','Tiranuelo Cabecirrojo','Rufous-headed Pygmy-tyrant','Pseudotriccus ruficeps','1','0','http://www.xeno-canto.org/254584','0','0'),"+
            "('6','18','9','0','0','Picochato carinegro','Black-throated Tody-Tyrant','Hemitriccus granadensis','1','0','http://www.xeno-canto.org/145674','0','0'),"+
            "('1','9','9','0','0','Espatulita Común','Common Tody-Flycatcher','Todirostrum cinereum','1','0','http://www.xeno-canto.org/121450','0','0'),"+
            "('1','6','9','0','0','Picoplano Sulfuroso','Yellow-olive Flatbill','Tolmomyias sulphurescens','1','0','http://www.xeno-canto.org/14014','0','0'),"+
            "('18','18','9','0','0','Atrapamoscas amarillento','Flavescent Flycatcher','Myiophobus flavicans','1','0','http://www.xeno-canto.org/347845','0','0'),"+
            "('13','6','9','0','0','Atrapamoscas pechirayado','Bran-colored Flycatcher','Myiophobus fasciatus','1','0','http://www.xeno-canto.org/190092','0','0'),"+
            "('13','13','9','0','0','Atrapamoscas canela','Cinnamon Flycatcher','Pyrrhomyias cinnamomea','1','0','sin','0','0'),"+
            "('6','6','9','0','0','Pibí Ahumado','Smoke-colored Pewee','Contopus fumigatus','1','0','http://www.xeno-canto.org/273865','0','0'),"+
            "('9','3','9','0','0','Atrapamoscas cuidapuentes','Black Phoebe','Sayornis nigricans','1','0','http://www.xeno-canto.org/264719','0','0'),"+
            "('6','13','9','0','0','Pitajo Pechirrufo','rufous-breasted chat-tyrant','Ochthoeca rufipectoralis','1','0','http://www.xeno-canto.org/94535','0','0'),"+
            "('13','9','9','0','0','Pitajo torrentero','Slaty-backed Chat-tyrant','Ochthoeca cinnamomeiventris','1','0','http://www.xeno-canto.org/273983','0','0'),"+
            "('18','1','9','0','0','Pitajo diademado','Yellow-bellied Chat-Tyrant','Ochthoeca diadema','1','0','sin','0','0'),"+
            "('4','6','9','0','0','Atrapamoscas chiflaperros','Streak-throated Bush Tyrant','Myiotheretes striaticollis','1','0','http://www.xeno-canto.org/236002','0','0'),"+
            "('4','6','9','0','0','Atrapamoscas tiznado','Smoky Bush Tyrant','Myiotheretes fumigatus','1','0','http://www.xeno-canto.org/273777','0','0'),"+
            "('6','1','9','0','0','Atrapamoscas Montañero','Pale-edged Flycatcher','Myiarchus cephalotes','1','0','http://www.xeno-canto.org/53387','0','0'),"+
            "('1','4','9','0','0','Bichofue','Great Kiskadee','Pitangus sulphuratus','1','0','http://www.xeno-canto.org/342397','0','0'),"+
            "('1','6','9','0','0','Bienteveo Alicastaño','Rusty-margined Flycatcher','Myiozetetes cayanensis','1','0','http://www.xeno-canto.org/244839','0','0'),"+
            "('4','1','9','0','0','Siriri Rayado','Streaked Flycatcher','Myiodynastes maculatus','1','0','http://www.xeno-canto.org/235996','0','0'),"+
            "('1','4','9','0','0','Bienteveo Lagartero','Golden-crowned Flycatcher','Myiodynastes chrysocephalus','1','0','http://www.xeno-canto.org/344376','0','0'),"+
            "('9','3','9','0','0','Siriri norteño','Eastern kingbird','Tyrannus tyrannus','0','0','http://www.xeno-canto.org/186676','0','0'),"+
            "('9','3','9','0','0','Siriri tijereta','Fork-tailed flycatcher','Tyrannus savana','1','0','http://www.xeno-canto.org/244972','0','0'),"+
            "('6','1','9','0','0','siriri comun','Tropical kingbird','Tyrannus melancholicus','1','0','http://www.xeno-canto.org/320170','0','0'),"+
            "('2','3','9','0','0','Golondrina azul y blanca','Blue-and-white swallow','Notiochelidon cyanoleuca','1','0','http://www.xeno-canto.org/303953','0','0'),"+
            "('4','6','9','0','0','Golondrina Gorgirrufa','Southern Rough-winged Swallow','Stelgidopteryx ruficollis','1','0','http://www.xeno-canto.org/273745','0','0'),"+
            "('2','9','9','0','0','Urraca Collareja','Black-collared jay','Cyanolyca armillata','1','0','http://www.xeno-canto.org/283527','0','0'),"+
            "('9','3','9','0','0','Carriqui pechiblanco','Black-chested jay','Cyanocorax affinis','1','0','http://www.xeno-canto.org/127036','0','0'),"+
            "('15','1','9','0','0','carriqui ventriamarillo','Green jay','Cyanocorax yncas','1','0','http://www.xeno-canto.org/343317','0','0'),"+
            "('9','3','9','0','0','Mirlo-acuático Coroniblanco','White-capped Dipper','Cinclus Leucocephalus','1','0','http://www.xeno-canto.org/259247','0','0'),"+
            "('13','13','9','0','0','Cucarachero Rufo','Rufous wren','Cinnycerthia unirufa','1','0','http://www.xeno-canto.org/356620','0','0'),"+
            "('18','18','9','0','0','Cucarachero Sepia','Sepia-brown wren','Cinnycerthia olivascens','1','0','http://www.xeno-canto.org/354114','0','0'),"+
            "('4','6','9','0','0','Cucarachero comun','House Wren','Troglodytes aedon','1','0','http://www.xeno-canto.org/344337','0','0'),"+
            "('4','6','9','0','0','Cucarachero montañero','Mountain Wren','Troglodytes solstitialis','1','0','http://www.xeno-canto.org/20474','0','0'),"+
            "('4','6','9','0','0','Cucarachero de Munchique','Munchique Wood Wren','Henicorhina negreti','1','3','http://www.xeno-canto.org/354290','0','0'),"+
            "('4','6','9','0','0','Cucarachero Pechigrís','Grey-breasted Wood Wren','Henicorhina leucophrys','1','0','http://www.xeno-canto.org/344301','0','0'),"+
            "('4','6','9','0','0','Cucarachero Bigotudo Montano','Whiskered wren','Pheugopedius mystacalis','1','0','http://www.xeno-canto.org/344378','0','0'),"+
            "('6','6','9','0','0','Sinsonte','Tropical mockingbird','Mimus gilvus','1','0','http://www.xeno-canto.org/353218','0','0'),"+
            "('4','6','8','0','0','Solitario andino o culumpio','Andean solitaire','Myadestes ralloides','1','0','http://www.xeno-canto.org/354220','0','0'),"+
            "('4','17','9','0','0','Zorzalito de Swainson','Swainson´s Thrush.','Catharus ustulatus','0','0','http://www.xeno-canto.org/273829','0','0'),"+
            "('6','8','8','0','0','Mirlo Grande','Great thrush','Turdus fuscater','1','0','http://www.xeno-canto.org/344362','0','0'),"+
            "('9','8','8','0','0','Mirlo Serrano','Glossy-black thrush','Turdus serranus','1','0','http://www.xeno-canto.org/12638','0','0'),"+
            "('6','4','9','0','0','Mayo','Black-billed Thrush','Turdus ignobilis','1','0','http://www.xeno-canto.org/327535','0','0'),"+
            "('4','6','9','0','0','Zorzal Pardo','Clay-colored thrush','Turdus grayi','1','0','http://www.xeno-canto.org/316134','0','0'),"+
            "('18','6','9','0','0','Verderon Piquinegro','Black-billed Peppershrike','Cyclarhis nigrirostris','1','0','http://www.xeno-canto.org/333542','0','0'),"+
            "('1','4','9','0','0','Vireo Coronipardo','Brown-capped Vireo','Vireo leucophrys','1','0','http://www.xeno-canto.org/273784','0','0'),"+
            "('9','9','9','0','0','Chamon','Shiny cowbird','Molothrus bonariensis','1','0','http://www.xeno-canto.org/89345','0','0'),"+
            "('9','9','9','0','0','Chamon gigante','Giant cowbird','Molothrus oryzivorus','1','0','http://www.xeno-canto.org/106293','0','0'),"+
            "('4','1','9','0','0','Gulungo','Russet-backed Oropendola','Psarocolius angustifrons','1','0','http://www.xeno-canto.org/131775','0','0'),"+
            "('9','1','9','0','0','Cacique Montañero','Mountain cacique','Cacicus chrysonotus','1','0','http://www.xeno-canto.org/310778','0','0'),"+
            "('9','11','9','0','0','Cacique Subtropical','Scarlet-rumped Cacique','Cacicus uropygialis','1','0','http://www.xeno-canto.org/241461','0','0'),"+
            "('9','11','9','0','0','Cacique candela','Red-bellied grackle','Hypopyrrhus pyrohypogaster','1','2','http://www.xeno-canto.org/74367','0','0'),"+
            "('1','9','9','0','0','Turpial Dorsidorado','Yellow-backed Oriole','Icterus chrysater','1','0','http://www.xeno-canto.org/235848','0','0'),"+
            "('3','9','9','0','0','Reinita Trepadora','Black-and-white Warbler,','Mniotilta varia','0','0','http://www.xeno-canto.org/299440','0','0'),"+
            "('6','1','9','0','0','Reinita Alidorada','Golden-winged Warbler','Vermivora chrysoptera','1','1','http://www.xeno-canto.org/329965','0','0'),"+
            "('2','1','8','0','0','Reinita Tropical','Tropical parula','Setophaga pitiayumi','1','0','http://www.xeno-canto.org/327636','0','0'),"+
            "('3','8','9','0','0','Reinita Gorjinaranja','Blackburnian warbler','Setophaga fusca','0','0','http://www.xeno-canto.org/53620','0','0'),"+
            "('9','1','9','0','0','Candelita plomiza','Slate-throated Redstart','Myioborus miniatus','1','0','http://www.xeno-canto.org/235990','0','0'),"+
            "('1','9','9','0','0','Candelita Adornada','Golden-fronted whitestart','Myioborus ornatus','1','0','http://www.xeno-canto.org/282400','0','0'),"+
            "('18','1','8','0','0','Reinita Citrina','Citrine Warbler','Myiothlypis luteoviridis','1','0','http://www.xeno-canto.org/341412','0','0'),"+
            "('18','6','9','0','0','Reinita Coronirroja','Russet-crowned warbler','Myiothlypis coronatus','1','0','http://www.xeno-canto.org/184784','0','0'),"+
            "('18','6','8','0','0','Reinita Cabecilistada','Three-striped warbler','Basileuterus tristriatus','1','0','http://www.xeno-canto.org/353318','0','0'),"+
            "('13','2','9','0','0','Conirrostro Dorsiazul','Blue-backed Conebill','Conirostrum sitticolor','1','0','http://www.xeno-canto.org/273490','0','0'),"+
            "('9','2','9','0','0','Conirrostro Coronado','Capped Conebill','Conirostrum albifrons','1','0','http://www.xeno-canto.org/22150','0','0'),"+
            "('1','6','9','0','0','Mielerito comun','Bananaquit','Coereba flaveola','1','0','http://www.xeno-canto.org/347839','0','0'),"+
            "('2','2','9','0','0','Pinchaflor Azulado','Bluish flowerpiercer','Diglossa Caerulescens','1','0','http://www.xeno-canto.org/278092','0','0'),"+
            "('2','9','9','0','0','Pinchaflor Enmascarado','Masked flowerpiercer','Diglossa cyanea','1','0','http://www.xeno-canto.org/179735','0','0'),"+
            "('9','3','9','0','0','Pinchaflor Flanquiblanco','White-sided flowerpiercer','Diglossa albilatera','1','0','http://www.xeno-canto.org/201041','0','0'),"+
            "('2','9','9','0','0','Mielerito Verde','Green honeycreeper','Chlorophanes spiza','1','0','http://www.xeno-canto.org/37275','0','0'),"+
            "('15','1','9','0','0','Clorofonia Nuquiazul','Blue-naped chlorophonia','Chlorophonia cyanea','1','0','http://www.xeno-canto.org/235634','0','0'),"+
            "('1','15','9','0','0','Clorofonia Pechicastaña','Chestnut-breasted chlorophonia','Chlorophonia pyrrhophrys','1','0','http://www.xeno-canto.org/102288','0','0'),"+
            "('1','2','9','0','0','Eufonia cabeciazul','Golden-rumped Euphonia','Euphonia cyanocephala','1','0','http://www.xeno-canto.org/310050','0','0'),"+
            "('1','2','9','0','0','Eufonia Ventrinaranja','Orange-bellied Euphonia','Euphonia xanthogaster','1','0','http://www.xeno-canto.org/237864','0','0'),"+
            "('1','2','9','0','0','Eufonia Piquigruesa','Thick-billed Euphonia','Euphonia laniirostris','1','0','http://www.xeno-canto.org/273431','0','0'),"+
            "('1','9','9','0','0','Tangara Dorada','Golden tanager','Tangara arthus','1','0','http://www.xeno-canto.org/354174','0','0'),"+
            "('2','1','9','0','0','Tangara Coronada','Saffron-crowned tanager','Tangara xanthocephala','1','0','http://www.xeno-canto.org/106365','0','0'),"+
            "('2','9','9','0','0','Tangara Verdiplata','Metallic-green tanager','Tangara labradorides','1','0','http://www.xeno-canto.org/22310','0','0'),"+
            "('2','9','9','0','0','Tangara real','Blue-necked tanager','Tangara cyanicollis','1','0','http://www.xeno-canto.org/296760','0','0'),"+
            "('2','13','9','0','0','Tangara Nuquirrufa','Golden-naped tanager','Tangara ruficervix','1','0','http://www.xeno-canto.org/22312','0','0'),"+
            "('15','11','9','0','0','Tangara Cabecibaya','Bay-headed tanager','Tangara gyrola','1','0','http://www.xeno-canto.org/353335','0','0'),"+
            "('6','13','9','0','0','Tangara Rastrojera','Scrub tanager','Tangara vitriolina','1','0','http://www.xeno-canto.org/273700','0','0'),"+
            "('2','9','9','0','0','Tangara de Lentejuelas','Beryl-spangled Tanager','Tangara nigroviridis','1','0','http://www.xeno-canto.org/354186','0','0'),"+
            "('2','9','9','0','0','Tangara Azulinegra','Blue-and-black tanager','Tangara vassorii','1','0','http://www.xeno-canto.org/10768','0','0'),"+
            "('2','9','9','0','0','Tangara Capirotada','Black-capped tanager','Tangara heinei','1','0','http://www.xeno-canto.org/245047','0','0'),"+
            "('2','1','9','0','0','Tangara Capiazul','Purplish-mantled tanager','Iridosornis porphyrocephalus','1','1','http://www.xeno-canto.org/354185','0','0'),"+
            "('2','1','9','0','0','Tangara Coroniadora','Golden-crowned tanager','Iridosornis rufivertex','1','0','http://www.xeno-canto.org/56441','0','0'),"+
            "('2','17','9','0','0','Tangara de Antifaz','Fawn-breasted tanager','Pipraeidea melanonota','1','0','http://www.xeno-canto.org/84009','0','0'),"+
            "('1','2','9','0','0','Tangara Lacrimosa','Lacrimose mountain tanager','Anisognathus lacrymosus','1','0','http://www.xeno-canto.org/353255','0','0'),"+
            "('1','2','9','0','0','Tangara Primavera','Blue-winged mountain tanager','Anisognathus somptuosus','1','0','http://www.xeno-canto.org/273921','0','0'),"+
            "('1','2','9','0','0','Tangara Montana','Hooded Mountain-Tanager','Buthraupis montana','1','0','http://www.xeno-canto.org/52693','0','0'),"+
            "('1','2','9','0','0','Tangara Diadema','Buff-breasted Mountain Tanager','Dubusia taeniata','1','0','http://www.xeno-canto.org/354214','0','0'),"+
            "('2','2','9','0','0','Azulejo','Blue-gray tanager','Thraupis episcopus','1','0','http://www.xeno-canto.org/245125','0','0'),"+
            "('6','18','9','0','0','Tangara Palmera','Palm tanager','Thraupis palmarum','1','0','http://www.xeno-canto.org/245423','0','0'),"+
            "('1','2','9','0','0','Tangara Coroniazul','Blue-capped tanager','Thraupis cyanocephala','1','0','http://www.xeno-canto.org/12417','0','0'),"+
            "('11','9','9','0','0','Toche Pico de plata','Crimson-backed tanager','Ramphocelus dimidiatus','1','0','http://www.xeno-canto.org/354337','0','0'),"+
            "('9','8','9','0','0','Toche','Flame-rumped tanager','Ramphocelus flammigerus','1','0','http://www.xeno-canto.org/237855','0','0'),"+
            "('11','11','9','0','0','Piranga Bermeja','Hepatic tanager','Piranga flava','1','0','http://www.xeno-canto.org/272879','0','0'),"+
            "('11','11','9','0','0','Piranga Roja','Summer Tanager','Piranga rubra','0','0','http://www.xeno-canto.org/298750','0','0'),"+
            "('11','9','9','0','0','Piranga Escarlata','Scarlet tanager','Piranga olivacea','0','0','http://www.xeno-canto.org/216611','0','0'),"+
            "('1','11','9','0','0','Piranga Capuchirroja','Red-hooded tanager','Piranga rubriceps','1','0','http://www.xeno-canto.org/119750','0','0'),"+
            "('11','11','9','0','0','Habia Copetona','Crested ant tanager','Habia cristata','1','0','http://www.xeno-canto.org/154861','0','0'),"+
            "('9','9','9','0','0','Tangara Negra','White-lined tanager','Tachyphonus rufus','1','0','http://www.xeno-canto.org/263414','0','0'),"+
            "('13','2','9','0','0','Tangara Crestirrufa','Rufous-crested tanager','Creurgops verticalis','1','0','http://www.xeno-canto.org/146401','0','0'),"+
            "('18','6','9','0','0','Tangara Güirá','Guira Tanager','Hemithraupis guira','1','0','http://www.xeno-canto.org/106374','0','0'),"+
            "('9','11','9','0','0','Pollo De Monte o Rey Del Quindio','White-capped tanager','Sericossypha albocristata','1','0','http://www.xeno-canto.org/344360','0','0'),"+
            "('18','6','8','0','0','Tangara Capuchigrís','Grey-hooded bush tanager','Cnemoscopus rubrirostris','1','0','http://www.xeno-canto.org/22318','0','0'),"+
            "('18','9','9','0','0','Hemispingo Capirotado','Black-capped Hemispingus','Hemispingus atropileus','1','0','http://www.xeno-canto.org/22219','0','0'),"+
            "('15','8','8','0','0','Tangara Lorito','Grass-green tanager','Chlorornis riefferii','1','0','http://www.xeno-canto.org/119759','0','0'),"+
            "('2','13','9','0','0','Gorrion afelpado','Plushcap','Catamblyrhynchus diadema','1','0','http://www.xeno-canto.org/234294','0','0'),"+
            "('18','6','9','0','0','Saltador ajisero','Buff-throated Saltator','Saltator maximus','1','0','http://www.xeno-canto.org/273546','0','0'),"+
            "('6','9','9','0','0','Saltador Alinegro','Black-winged saltator','Saltator atripennis','1','0','http://www.xeno-canto.org/273684','0','0'),"+
            "('6','18','9','0','0','Saltador pio judio','Streaked saltator','Saltator striatipectus','1','0','http://www.xeno-canto.org/344331','0','0'),"+
            "('3','11','9','0','0','Picogordo Degollado','Rose-breasted grosbeak','Pheucticus ludovicianus','0','0','http://www.xeno-canto.org/131800','0','0'),"+
            "('4','9','9','0','0','Gorrion Tangarino','Tanager Finch','Oreothraupis arremonops','1','1','http://www.xeno-canto.org/276313','0','0'),"+
            "('6','1','9','0','0','Atlapetes gorgiamarillo','White-naped Brush Finch','Atlapetes albinucha','1','0','http://www.xeno-canto.org/273564','0','0'),"+
            "('6','11','9','0','0','Gorrion montés pizarra','Slaty Brush-finch','Atlapetes schistaceus','1','0','http://www.xeno-canto.org/353249','0','0'),"+
            "('6','13','9','0','0','Gorrion Montés Collarejo','Chestnut-capped brush finch','Arremon brunneinucha','1','0','http://www.xeno-canto.org/273640','0','0'),"+
            "('18','1','9','0','0','Semillero cariamarillo','Yellow-faced grassquit','Tiaris olivaceus','1','0','http://www.xeno-canto.org/273686','0','0'),"+
            "('6','3','9','0','0','Semillero Intermedio','Grey Seedeater','Sporophila intermedia','1','0','http://www.xeno-canto.org/59588','0','0'),"+
            "('9','3','9','0','0','Semillero Negriblanco','Black-and-white seedeater','Sporophila luctuosa','1','0','http://www.xeno-canto.org/53201','0','0'),"+
            "('9','17','9','0','0','Semillero Capuchino','Yellow-bellied Seedeater','Sporophila nigricollis','1','0','http://www.xeno-canto.org/273666','0','0'),"+
            "('9','9','9','0','0','Semillero Volatinero','Blue-black Grassquit','Volatinia jacarina','1','0','http://www.xeno-canto.org/236258','0','0'),"+
            "('6','4','9','0','0','Copetoncito','Rufous-collared sparrow','Zonotrichia capensis','1','0','http://www.xeno-canto.org/344379','0','0'),"+
            "('1','6','9','0','0','Boton de oro','Saffron Finch','Sicalis flaveola','1','0','http://www.xeno-canto.org/273744','0','0'),"+
            "('1','9','9','0','0','Jilguero Ventriamarillo','Yellow-bellied Siskin','Spinus xanthogastra','1','0','http://www.xeno-canto.org/273622','0','0'),"+
            "('9','1','9','0','0','Jilguero Menor','Lesser Goldfinch','Spinus psaltria','1','0','http://www.xeno-canto.org/55022','0','0'),"+
            "('6','0','0','0','0','Paloma comun','Rock dove','Columba livia','1','0','http://www.xeno-canto.org/257593','0','0')";




    public Aves_bd(Context contexto) {
        super(contexto, DATA_BASE_NAME,null,DATA_VERSION);
    }


    /**
     * Metodo que Inicializa la base de datos
     *
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
        db.execSQL(iniciales);

    }

    /**
     * Metodo que actualiza la base de datos
     *
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISITS Usuarios");
        db.execSQL(sqlCreate);

    }




}
