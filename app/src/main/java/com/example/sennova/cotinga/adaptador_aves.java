package com.example.sennova.cotinga;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 *  Clase encargada de construir el modelo para cada cardview que almacenara la información local de cada ave
 *
 */

public class adaptador_aves extends RecyclerView.Adapter<adaptador_aves.MyViewHolder> {

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nom1, nom2,nom3,nom4;
        CardView cv;
        ImageView imagen;
        String dato;
        SQLiteDatabase db;
        String[] nombreave = new String[150];
        String contador,nombres;
        Integer cuenta=0;
        String[] numero = new String[290];

        public MyViewHolder(View view) {
            super(view);
            cv = (CardView)view.findViewById(R.id.aves_cardview);
            nom1 = (TextView) view.findViewById(R.id.nombre_ave);
            nom2 = (TextView) view.findViewById(R.id.cientifico_ave);
            nom3 = (TextView) view.findViewById(R.id.ingles_ave);
            nom4 = (TextView) view.findViewById(R.id.avistamiento_ave);
            imagen=(ImageView) view.findViewById(R.id.foto_ave);
            Aves_bd Ave = new Aves_bd(view.getContext());
            db=Ave.getWritableDatabase();


            //Para los extras de cada ave
            for (int j = 0; j < 290; j ++){
                numero[j]= Integer.toString(j+1);
            }


            /**
             *  Rutina para pasar el id de cada ave seleccionada, a la actividad Ave_info.class
             *
             */
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    dato = MyViewHolder.this.getItem(nom1).toString();


                    switch (dato){
                        case "Tinamú Cabecirrojo":
                            lanzarAve(view,numero[0]);
                            break;
                        case "Cormorán neotropical":
                            lanzarAve(view,numero[1]);
                            break;
                        case "Garcilla bueyera":
                            lanzarAve(view,numero[2]);
                            break;
                        case "Garza real":
                            lanzarAve(view,numero[3]);
                            break;
                        case "Garcita estriada":
                            lanzarAve(view,numero[4]);
                            break;
                        case "Ibis afeitado o coquito":
                            lanzarAve(view,numero[5]);
                            break;
                        case "Barraquete aliazul":
                            lanzarAve(view,numero[6]);
                            break;
                        case "Pato torrentero":
                            lanzarAve(view,numero[7]);
                            break;
                        case "Guala Cabeciroja":
                            lanzarAve(view,numero[8]);
                            break;
                        case "Gallinazo":
                            lanzarAve(view,numero[9]);
                            break;
                        case "Aguila Pescadora":
                            lanzarAve(view,numero[10]);
                            break;
                        case "Aguila Tijereta":
                            lanzarAve(view,numero[11]);
                            break;
                        case "Caracolero piquiganchudo":
                            lanzarAve(view,numero[12]);
                            break;
                        case "Elanio maromero":
                            lanzarAve(view,numero[13]);
                            break;
                        case "Elanio enano":
                            lanzarAve(view,numero[14]);
                            break;
                        case "Gavilán Pollero":
                            lanzarAve(view,numero[15]);
                            break;
                        case "Gavilán americano":
                            lanzarAve(view,numero[16]);
                            break;
                        case "Gavilan aliancho":
                            lanzarAve(view,numero[17]);
                            break;
                        case "Gavilan colicorto":
                            lanzarAve(view,numero[18]);
                            break;
                        case "Gavilán coliblanco":
                            lanzarAve(view,numero[19]);
                            break;
                        case "Gavilan negro":
                            lanzarAve(view,numero[20]);
                            break;
                        case "Águila poma":
                            lanzarAve(view,numero[21]);
                            break;
                        case "Caracara muñudo":
                            lanzarAve(view,numero[22]);
                            break;
                        case "Pigua":
                            lanzarAve(view,numero[23]);
                            break;
                        case "Halcón reidor":
                            lanzarAve(view,numero[24]);
                            break;
                        case "Cernícalo americano":
                            lanzarAve(view,numero[25]);
                            break;
                        case "Guacharaca":
                            lanzarAve(view,numero[26]);
                            break;
                        case "Pava maraquera":
                            lanzarAve(view,numero[27]);
                            break;
                        case "Perdiz colorada":
                            lanzarAve(view,numero[28]);
                            break;
                        case "Rascón negruzco":
                            lanzarAve(view,numero[29]);
                            break;
                        case "Caravana":
                            lanzarAve(view,numero[30]);
                            break;
                        case "Agachadiza noble":
                            lanzarAve(view,numero[31]);
                            break;
                        case "Paloma collareja":
                            lanzarAve(view,numero[32]);
                            break;
                        case "Paloma colorada":
                            lanzarAve(view,numero[33]);
                            break;
                        case "Tortolita":
                            lanzarAve(view,numero[34]);
                            break;
                        case "Torcaza naguiblanca":
                            lanzarAve(view,numero[35]);
                            break;
                        case "Paloma montaraz común":
                            lanzarAve(view,numero[36]);
                            break;
                        case "Paloma perdiz gorjiblanca":
                            lanzarAve(view,numero[37]);
                            break;
                        case "Cotorra frentirroja":
                            lanzarAve(view,numero[38]);
                            break;
                        case "Loro Orejiamarillo":
                            lanzarAve(view,numero[39]);
                            break;
                        case "Periquito de anteojos":
                            lanzarAve(view,numero[40]);
                            break;
                        case "Cotorra gorriblanca":
                            lanzarAve(view,numero[41]);
                            break;
                        case "Cotorra alibronceada o mocha":
                            lanzarAve(view,numero[42]);
                            break;
                        case "Cuco ardilla":
                            lanzarAve(view,numero[43]);
                            break;
                        case "Garrapatero":
                            lanzarAve(view,numero[44]);
                            break;
                        case "Lechuza común":
                            lanzarAve(view,numero[45]);
                            break;
                        case "Currucutu":
                            lanzarAve(view,numero[46]);
                            break;
                        case "Buho ocelado":
                            lanzarAve(view,numero[47]);
                            break;
                        case "Mochuelo andino":
                            lanzarAve(view,numero[48]);
                            break;
                        case "Bienparado comun":
                            lanzarAve(view,numero[49]);
                            break;
                        case "Chotacabras pauraque":
                            lanzarAve(view,numero[50]);
                            break;
                        case "Guardacaminos andino":
                            lanzarAve(view,numero[51]);
                            break;
                        case "Guardacaminos lyra":
                            lanzarAve(view,numero[52]);
                            break;
                        case "Vencejo acollarado":
                            lanzarAve(view,numero[53]);
                            break;
                        case "Vencejo rrojcuellio":
                            lanzarAve(view,numero[54]);
                            break;
                        case "Ermitaño verde":
                            lanzarAve(view,numero[55]);
                            break;
                        case "Ermitaño ventrihabano":
                            lanzarAve(view,numero[56]);
                            break;
                        case "Colibrí picolanza mayor":
                            lanzarAve(view,numero[57]);
                            break;
                        case "Colibrí verdemar":
                            lanzarAve(view,numero[58]);
                            break;
                        case "Colibrí nuquiblanco":
                            lanzarAve(view,numero[59]);
                            break;
                        case "Colibrí rutilante":
                            lanzarAve(view,numero[60]);
                            break;
                        case "Colibrí pardo":
                            lanzarAve(view,numero[61]);
                            break;
                        case "Mango pechinegro":
                            lanzarAve(view,numero[62]);
                            break;
                        case "Esmeralda Occidental":
                            lanzarAve(view,numero[63]);
                            break;
                        case "Esmeralda andina":
                            lanzarAve(view,numero[64]);
                            break;
                        case "Amazilia verdiazul":
                            lanzarAve(view,numero[65]);
                            break;
                        case "Amazilia colirufa":
                            lanzarAve(view,numero[66]);
                            break;
                        case "Colibrí pechipunteado":
                            lanzarAve(view,numero[67]);
                            break;
                        case "Brillante pechigamuza":
                            lanzarAve(view,numero[68]);
                            break;
                        case "Brillante emperador":
                            lanzarAve(view,numero[69]);
                            break;
                        case "Halcon Murcielaguero":
                            lanzarAve(view,numero[70]);
                            break;
                        case "Colibrí aterciopelado":
                            lanzarAve(view,numero[71]);
                            break;
                        case "Inca bronceado":
                            lanzarAve(view,numero[72]);
                            break;
                        case "Inca pardo":
                            lanzarAve(view,numero[73]);
                            break;
                        case "Inca de Antioquía":
                            lanzarAve(view,numero[74]);
                            break;
                        case "Inca acollarado":
                            lanzarAve(view,numero[75]);
                            break;
                        case "Colibrí picoespada":
                            lanzarAve(view,numero[76]);
                            break;
                        case "Colibrí colihabano":
                            lanzarAve(view,numero[77]);
                            break;
                        case "Colibrí sietecolores":
                            lanzarAve(view,numero[78]);
                            break;
                        case "Colibrí turmalina":
                            lanzarAve(view,numero[79]);
                            break;
                        case "Calzadito reluciente":
                            lanzarAve(view,numero[80]);
                            break;
                        case "Calzadito verdoso norteño":
                            lanzarAve(view,numero[81]);
                            break;
                        case "Colibrí de raquetas":
                            lanzarAve(view,numero[82]);
                            break;
                        case "Colibri dorsimorado":
                            lanzarAve(view,numero[83]);
                            break;
                        case "Metalura tiria":
                            lanzarAve(view,numero[84]);
                            break;
                        case "Silfo coliverde":
                            lanzarAve(view,numero[85]);
                            break;
                        case "Silfo coliceleste":
                            lanzarAve(view,numero[86]);
                            break;
                        case "Colibrí piquilargo":
                            lanzarAve(view,numero[87]);
                            break;
                        case "Colibrí de Mitchell":
                            lanzarAve(view,numero[88]);
                            break;
                        case "Colibrí de Mulsant":
                            lanzarAve(view,numero[89]);
                            break;
                        case "Quetzal cabecidorado":
                            lanzarAve(view,numero[90]);
                            break;
                        case "Trogón acollarado":
                            lanzarAve(view,numero[91]);
                            break;
                        case "Trogón enmascarado":
                            lanzarAve(view,numero[92]);
                            break;
                        case "Martín pescador gigante":
                            lanzarAve(view,numero[93]);
                            break;
                        case "Guardacaminos Migratorio":
                            lanzarAve(view,numero[94]);
                            break;
                        case "Martín pescador verde":
                            lanzarAve(view,numero[95]);
                            break;
                        case "Barranquero":
                            lanzarAve(view,numero[96]);
                            break;
                        case "Bigotudo canoso":
                            lanzarAve(view,numero[97]);
                            break;
                        case "Buco cariblanco":
                            lanzarAve(view,numero[98]);
                            break;
                        case "Torito cabecirrojo":
                            lanzarAve(view,numero[99]);
                            break;
                        case"Tucaneta esmeralda":
                            lanzarAve(view,numero[100]);
                            break;
                        case"Tucaneta culirroja":
                            lanzarAve(view,numero[101]);
                            break;
                        case"Terlaque pechiazul":
                            lanzarAve(view,numero[102]);
                            break;
                        case "Carpinterito colombiano":
                            lanzarAve(view,numero[103]);
                            break;
                        case "Carpintero carmesi":
                            lanzarAve(view,numero[104]);
                            break;
                        case "Carpintero oliváceo":
                            lanzarAve(view,numero[105]);
                            break;
                        case "Carpintero real":
                            lanzarAve(view,numero[106]);
                            break;
                        case "Carpintero bellotero":
                            lanzarAve(view,numero[107]);
                            break;
                        case "Carpintero habado":
                            lanzarAve(view,numero[108]);
                            break;
                        case "Carpintero ahumado":
                            lanzarAve(view,numero[109]);
                            break;
                        case "Carpintero ventriamarillo":
                            lanzarAve(view,numero[110]);
                            break;
                        case "Carpintero gigante":
                            lanzarAve(view,numero[111]);
                            break;
                        case "Trepatroncos Tiranino":
                            lanzarAve(view,numero[112]);
                            break;
                        case "Trepatroncos Manchado":
                            lanzarAve(view,numero[113]);
                            break;
                        case "Trepatroncos Cabecirrayado":
                            lanzarAve(view,numero[114]);
                            break;
                        case "Trepatroncos Montano":
                            lanzarAve(view,numero[115]);
                            break;
                        case "Picoguadaña Andino":
                            lanzarAve(view,numero[116]);
                            break;
                        case "Piscuis de Azara":
                            lanzarAve(view,numero[117]);
                            break;
                        case "Chamicero de antifaz":
                            lanzarAve(view,numero[118]);
                            break;
                        case "Chamicero palido":
                            lanzarAve(view,numero[119]);
                            break;
                        case "Chamicero cejiblanco":
                            lanzarAve(view,numero[120]);
                            break;
                        case "Chamicero rubicundo":
                            lanzarAve(view,numero[121]);
                            break;
                        case "Trepatroncos Perlado":
                            lanzarAve(view,numero[122]);
                            break;
                        case "Trepatroncos Moteado":
                            lanzarAve(view,numero[123]);
                            break;
                        case "Trepatroncos gorgiblanco":
                            lanzarAve(view,numero[124]);
                            break;
                        case "Hojarasquero montañero":
                            lanzarAve(view,numero[125]);
                            break;
                        case "Hojarasquero grande":
                            lanzarAve(view,numero[126]);
                            break;
                        case "Xenops estriado":
                            lanzarAve(view,numero[127]);
                            break;
                        case "Saltarocas punteado":
                            lanzarAve(view,numero[128]);
                            break;
                        case "Batará Carcajada":
                            lanzarAve(view,numero[129]);
                            break;
                        case "Hormiguero Tiznado":
                            lanzarAve(view,numero[130]);
                            break;
                        case "Hormiguero de Parker":
                            lanzarAve(view,numero[131]);
                            break;
                        case "Hormiguerito Rabilargo":
                            lanzarAve(view,numero[132]);
                            break;
                        case "Tororoí gigante":
                            lanzarAve(view,numero[133]);
                            break;
                        case "Tororoí Comprapan":
                            lanzarAve(view,numero[134]);
                            break;
                        case "Tororoí Nuquicastaño":
                            lanzarAve(view,numero[135]);
                            break;
                        case "Tororoí Rufo":
                            lanzarAve(view,numero[136]);
                            break;
                        case "Totoroí Enano":
                            lanzarAve(view,numero[137]);
                            break;
                        case "Tapaculo Negruzco":
                            lanzarAve(view,numero[138]);
                            break;
                        case "Tapaculo de Spillmann":
                            lanzarAve(view,numero[139]);
                            break;
                        case "Tapaculo Ocelado":
                            lanzarAve(view,numero[140]);
                            break;
                        case "Gallito de Roca":
                            lanzarAve(view,numero[141]);
                            break;
                        case "Cotinga Crestirroja":
                            lanzarAve(view,numero[142]);
                            break;
                        case "Cotinga Cresticastaño":
                            lanzarAve(view,numero[143]);
                            break;
                        case "Frutero Verdinegro":
                            lanzarAve(view,numero[144]);
                            break;
                        case "Frutero Barrado":
                            lanzarAve(view,numero[145]);
                            break;
                        case "Guardabosques cenizo":
                            lanzarAve(view,numero[146]);
                            break;
                        case "Becard Barrado":
                            lanzarAve(view,numero[147]);
                            break;
                        case "Becard Aliblanco":
                            lanzarAve(view,numero[148]);
                            break;
                        case "Mosquerito Capirotado":
                            lanzarAve(view,numero[149]);
                            break;
                        case "Mosquerito Caridorado":
                            lanzarAve(view,numero[150]);
                            break;
                        case "Mosquerito Silbón":
                            lanzarAve(view,numero[151]);
                            break;
                        case "Elaenia Copetona":
                            lanzarAve(view,numero[152]);
                            break;
                        case "Elaenia Montañera":
                            lanzarAve(view,numero[153]);
                            break;
                        case "Mosquero Verdoso":
                            lanzarAve(view,numero[154]);
                            break;
                        case "Tiranuelo Gorgiblanco":
                            lanzarAve(view,numero[155]);
                            break;
                        case "Siriri Bueyero":
                            lanzarAve(view,numero[156]);
                            break;
                        case "Tiranuelo Colilargo":
                            lanzarAve(view,numero[157]);
                            break;
                        case "Tiranuelo Saltarroyos":
                            lanzarAve(view,numero[158]);
                            break;
                        case "Mosquero Gorgiestriado":
                            lanzarAve(view,numero[159]);
                            break;
                        case "Atrapamoscas sepia":
                            lanzarAve(view,numero[160]);
                            break;
                        case "Atrapamoscas pechirrufo":
                            lanzarAve(view,numero[161]);
                            break;
                        case "Atrapamoscas marmoreo":
                            lanzarAve(view,numero[162]);
                            break;
                        case "Atrapamoscas variegado":
                            lanzarAve(view,numero[163]);
                            break;
                        case "Tiranuelo coronado":
                            lanzarAve(view,numero[164]);
                            break;
                        case "Tiranuelo Cabecirrojo":
                            lanzarAve(view,numero[165]);
                            break;
                        case "Picochato carinegro":
                            lanzarAve(view,numero[166]);
                            break;
                        case "Espatulita Común":
                            lanzarAve(view,numero[167]);
                            break;
                        case "Picoplano Sulfuroso":
                            lanzarAve(view,numero[168]);
                            break;
                        case "Atrapamoscas amarillento":
                            lanzarAve(view,numero[169]);
                            break;
                        case "Atrapamoscas pechirayado":
                            lanzarAve(view,numero[170]);
                            break;
                        case "Atrapamoscas canela":
                            lanzarAve(view,numero[171]);
                            break;
                        case "Pibí Ahumado":
                            lanzarAve(view,numero[172]);
                            break;
                        case "Atrapamoscas cuidapuentes":
                            lanzarAve(view,numero[173]);
                            break;
                        case "Pitajo Pechirrufo":
                            lanzarAve(view,numero[174]);
                            break;
                        case "Pitajo torrentero":
                            lanzarAve(view,numero[175]);
                            break;
                        case "Pitajo diademado":
                            lanzarAve(view,numero[176]);
                            break;
                        case "Atrapamoscas chiflaperros":
                            lanzarAve(view,numero[177]);
                            break;
                        case "Atrapamoscas tiznado":
                            lanzarAve(view,numero[178]);
                            break;
                        case "Atrapamoscas Montañero":
                            lanzarAve(view,numero[179]);
                            break;
                        case "Bichofue":
                            lanzarAve(view,numero[180]);
                            break;
                        case "Bienteveo Alicastaño":
                            lanzarAve(view,numero[181]);
                            break;
                        case "Siriri Rayado":
                            lanzarAve(view,numero[182]);
                            break;
                        case "Bienteveo Lagartero":
                            lanzarAve(view,numero[183]);
                            break;
                        case "Siriri norteño":
                            lanzarAve(view,numero[184]);
                            break;
                        case "Siriri tijereta":
                            lanzarAve(view,numero[185]);
                            break;
                        case "siriri comun":
                            lanzarAve(view,numero[186]);
                            break;
                        case "Golondrina azul y blanca":
                            lanzarAve(view,numero[187]);
                            break;
                        case "Golondrina Gorgirrufa":
                            lanzarAve(view,numero[188]);
                            break;
                        case "Urraca Collareja":
                            lanzarAve(view,numero[189]);
                            break;
                        case "Carriqui pechiblanco":
                            lanzarAve(view,numero[190]);
                            break;
                        case "carriqui ventriamarillo":
                            lanzarAve(view,numero[191]);
                            break;
                        case "Mirlo-acuático Coroniblanco":
                            lanzarAve(view,numero[192]);
                            break;
                        case "Cucarachero Rufo":
                            lanzarAve(view,numero[193]);
                            break;
                        case "Cucarachero Sepia":
                            lanzarAve(view,numero[194]);
                            break;
                        case "Cucarachero comun":
                            lanzarAve(view,numero[195]);
                            break;
                        case "Cucarachero montañero":
                            lanzarAve(view,numero[196]);
                            break;
                        case "Cucarachero de Munchique":
                            lanzarAve(view,numero[197]);
                            break;
                        case "Cucarachero Pechigrís":
                            lanzarAve(view,numero[198]);
                            break;
                        case "Cucarachero Bigotudo Montano":
                            lanzarAve(view,numero[199]);
                            break;
                        case "Sinsonte":
                            lanzarAve(view,numero[200]);
                            break;
                        case "Solitario andino o culumpio":
                            lanzarAve(view,numero[201]);
                            break;
                        case "Zorzalito de Swainson":
                            lanzarAve(view,numero[202]);
                            break;
                        case "Mirlo Grande":
                            lanzarAve(view,numero[203]);
                            break;
                        case "Mirlo Serrano":
                            lanzarAve(view,numero[204]);
                            break;
                        case "Mayo":
                            lanzarAve(view,numero[205]);
                            break;
                        case "Zorzal Pardo":
                            lanzarAve(view,numero[206]);
                            break;
                        case "Verderon Piquinegro":
                            lanzarAve(view,numero[207]);
                            break;
                        case "Vireo Coronipardo":
                            lanzarAve(view,numero[208]);
                            break;
                        case "Chamon":
                            lanzarAve(view,numero[209]);
                            break;
                        case "Chamon gigante":
                            lanzarAve(view,numero[210]);
                            break;
                        case "Gulungo":
                            lanzarAve(view,numero[211]);
                            break;
                        case "Cacique Montañero":
                            lanzarAve(view,numero[212]);
                            break;
                        case "Cacique Subtropical":
                            lanzarAve(view,numero[213]);
                            break;
                        case "Cacique candela":
                            lanzarAve(view,numero[214]);
                            break;
                        case "Turpial Dorsidorado":
                            lanzarAve(view,numero[215]);
                            break;
                        case "Reinita Trepadora":
                            lanzarAve(view,numero[216]);
                            break;
                        case "Reinita Alidorada":
                            lanzarAve(view,numero[217]);
                            break;
                        case "Reinita Tropical":
                            lanzarAve(view,numero[218]);
                            break;
                        case "Reinita Gorjinaranja":
                            lanzarAve(view,numero[219]);
                            break;
                        case "Candelita plomiza":
                            lanzarAve(view,numero[220]);
                            break;
                        case "Candelita Adornada":
                            lanzarAve(view,numero[221]);
                            break;
                        case "Reinita Citrina":
                            lanzarAve(view,numero[222]);
                            break;
                        case "Reinita Coronirroja":
                            lanzarAve(view,numero[223]);
                            break;
                        case "Reinita Cabecilistada":
                            lanzarAve(view,numero[224]);
                            break;
                        case "Conirrostro Dorsiazul":
                            lanzarAve(view,numero[225]);
                            break;
                        case "Conirrostro Coronado":
                            lanzarAve(view,numero[226]);
                            break;
                        case "Mielerito comun":
                            lanzarAve(view,numero[227]);
                            break;
                        case "Pinchaflor Azulado":
                            lanzarAve(view,numero[228]);
                            break;
                        case "Pinchaflor Enmascarado":
                            lanzarAve(view,numero[229]);
                            break;
                        case "Pinchaflor Flanquiblanco":
                            lanzarAve(view,numero[230]);
                            break;
                        case "Mielerito Verde":
                            lanzarAve(view,numero[231]);
                            break;
                        case "Clorofonia Nuquiazul":
                            lanzarAve(view,numero[232]);
                            break;
                        case "Clorofonia Pechicastaña":
                            lanzarAve(view,numero[233]);
                            break;
                        case "Eufonia cabeciazul":
                            lanzarAve(view,numero[234]);
                            break;
                        case "Eufonia Ventrinaranja":
                            lanzarAve(view,numero[235]);
                            break;
                        case "Eufonia Piquigruesa":
                            lanzarAve(view,numero[236]);
                            break;
                        case "Tangara Dorada":
                            lanzarAve(view,numero[237]);
                            break;
                        case "Tangara Coronada":
                            lanzarAve(view,numero[238]);
                            break;
                        case "Tangara Verdiplata":
                            lanzarAve(view,numero[239]);
                            break;
                        case "Tangara real":
                            lanzarAve(view,numero[240]);
                            break;
                        case "Tangara Nuquirrufa":
                            lanzarAve(view,numero[241]);
                            break;
                        case "Tangara Cabecibaya":
                            lanzarAve(view,numero[242]);
                            break;
                        case "Tangara Rastrojera":
                            lanzarAve(view,numero[243]);
                            break;
                        case "Tangara de Lentejuelas":
                            lanzarAve(view,numero[244]);
                            break;
                        case "Tangara Azulinegra":
                            lanzarAve(view,numero[245]);
                            break;
                        case "Tangara Capirotada":
                            lanzarAve(view,numero[246]);
                            break;
                        case "Tangara Capiazul":
                            lanzarAve(view,numero[247]);
                            break;
                        case "Tangara Coroniadora":
                            lanzarAve(view,numero[248]);
                            break;
                        case "Tangara de Antifaz":
                            lanzarAve(view,numero[249]);
                            break;
                        case "Tangara Lacrimosa":
                            lanzarAve(view,numero[250]);
                            break;
                        case "Tangara Primavera":
                            lanzarAve(view,numero[251]);
                            break;
                        case "Tangara Montana":
                            lanzarAve(view,numero[252]);
                            break;
                        case "Tangara Diadema":
                            lanzarAve(view,numero[253]);
                            break;
                        case "Azulejo":
                            lanzarAve(view,numero[254]);
                            break;
                        case "Tangara Palmera":
                            lanzarAve(view,numero[255]);
                            break;
                        case "Tangara Coroniazul":
                            lanzarAve(view,numero[256]);
                            break;
                        case "Toche Pico de plata":
                            lanzarAve(view,numero[257]);
                            break;
                        case "Toche":
                            lanzarAve(view,numero[258]);
                            break;
                        case "Piranga Bermeja":
                            lanzarAve(view,numero[259]);
                            break;
                        case "Piranga Roja":
                            lanzarAve(view,numero[260]);
                            break;
                        case "Piranga Escarlata":
                            lanzarAve(view,numero[261]);
                            break;
                        case "Piranga Capuchirroja":
                            lanzarAve(view,numero[262]);
                            break;
                        case "Habia Copetona":
                            lanzarAve(view,numero[263]);
                            break;
                        case "Tangara Negra":
                            lanzarAve(view,numero[264]);
                            break;
                        case "Tangara Crestirrufa":
                            lanzarAve(view,numero[265]);
                            break;
                        case "Tangara Güirá":
                            lanzarAve(view,numero[266]);
                            break;
                        case "Pollo De Monte o Rey Del Quindio":
                            lanzarAve(view,numero[267]);
                            break;
                        case "Tangara Capuchigrís":
                            lanzarAve(view,numero[268]);
                            break;
                        case "Hemispingo Capirotado":
                            lanzarAve(view,numero[269]);
                            break;
                        case "Tangara Lorito":
                            lanzarAve(view,numero[270]);
                            break;
                        case "Gorrion afelpado":
                            lanzarAve(view,numero[271]);
                            break;
                        case "Saltador ajisero":
                            lanzarAve(view,numero[272]);
                            break;
                        case "Saltador Alinegro":
                            lanzarAve(view,numero[273]);
                            break;
                        case "Saltador pio judio":
                            lanzarAve(view,numero[274]);
                            break;
                        case "Picogordo Degollado":
                            lanzarAve(view,numero[275]);
                            break;
                        case "Gorrion Tangarino":
                            lanzarAve(view,numero[276]);
                            break;
                        case "Atlapetes gorgiamarillo":
                            lanzarAve(view,numero[277]);
                            break;
                        case "Gorrion montés pizarra":
                            lanzarAve(view,numero[278]);
                            break;
                        case "Gorrion Montés Collarejo":
                            lanzarAve(view,numero[279]);
                            break;
                        case "Semillero cariamarillo":
                            lanzarAve(view,numero[280]);
                            break;
                        case "Semillero Intermedio":
                            lanzarAve(view,numero[281]);
                            break;
                        case "Semillero Negriblanco":
                            lanzarAve(view,numero[282]);
                            break;
                        case "Semillero Capuchino":
                            lanzarAve(view,numero[283]);
                            break;
                        case "Semillero Volatinero":
                            lanzarAve(view,numero[284]);
                            break;
                        case "Copetoncito":
                            lanzarAve(view,numero[285]);
                            break;
                        case "Boton de oro":
                            lanzarAve(view,numero[286]);
                            break;
                        case "Jilguero Ventriamarillo":
                            lanzarAve(view,numero[287]);
                            break;
                        case "Jilguero Menor":
                            lanzarAve(view,numero[288]);
                            break;
                        case "Paloma comun":
                            lanzarAve(view,numero[289]);
                            break;

                    }




                    /*}else if(dato.equals(nombreave[289])){
                        lanzarAve(view,numero[289]);
                    }*/
                }

            });

        }
        /**
         * Método para obtener el nombre comun del ave del cardview
         * @return Nombre en español del ave seleccionada
         *
         */
        private CharSequence getItem(TextView nom1) {
            return nom1.getText();
        }
    }
    /**
     * Construcción de la lista de aves
     *
     */
    List<Ave_constructor> lista_aves;
    adaptador_aves(List<Ave_constructor> lista_aves) {

        this.lista_aves = lista_aves;
    }
    /**
     * Método que establece la relación con el recyclerview
     *
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    /**
     * Método para obtener el recurso grafico a desplegar en el cardview
     *
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.aves_card, parent, false);
        return new MyViewHolder(itemView);
    }
    /**
     * Método para armar el cardview de aves con base en la información capturada de la base de datos local
     *
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int i) {

        holder.nom1.setText(lista_aves.get(i).nombre1);
        holder.nom2.setText(lista_aves.get(i).nombre2);
        holder.nom3.setText(lista_aves.get(i).nombre3);
        holder.nom4.setText(lista_aves.get(i).nombre4);
        holder.imagen.setImageResource(lista_aves.get(i).id);

    }

    @Override
    public int getItemCount() {

        return lista_aves.size();
    }


    public void lanzarAve(View view, String n){
        Intent intent= new Intent (view.getContext(), Ave_info.class);
        intent.putExtra("id",n);
        view.getContext().startActivity(intent);
    }
}



