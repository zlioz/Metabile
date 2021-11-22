package com.karendamore.metabile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SitiosTuristicosListActivity : AppCompatActivity() {

    private lateinit var listLugares: ArrayList<Lugar>
    private lateinit var lugaresAdapter: LugaresAdapter
    private lateinit var lugaresRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sitios_turisticos_list)

        lugaresRecyclerView=findViewById(R.id.lugares_recycler_view)

        listLugares= createMockLugares()

        lugaresAdapter=LugaresAdapter(listLugares)

        lugaresRecyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        lugaresRecyclerView.adapter=lugaresAdapter

        //para ajustar algunas cosas
        lugaresRecyclerView.apply{
            layoutManager= LinearLayoutManager(context)
            adapter= lugaresAdapter
            setHasFixedSize(false)
        }
    }

    private fun createMockLugares(): ArrayList<Lugar>{
        return arrayListOf(
            Lugar(
                name ="Basilica",
                description = "La Basílica Menor de La Inmaculada Concepción es una de las iglesias más lindas de Antioquia, está construida en piedra labrada a mano, su estilo es neogótico y ha sido decorada en su interior con arcos recubiertos en oro. ",
                puntuacion = "puntuación: 3.2",
                urlimagen = "https://elturismoencolombia.com/wp-content/uploads/2018/08/jardin_antioquia_iglesia_inmaculada_concepcion_colombia.jpg"
            ),
            Lugar(
                name ="MIRADOR CRISTO REY",
                description = "Para llegar puedes caminar desde el parque principal de Jardín durante una 1 hora, o puedes ir en Tuk-Tuk durante unos 10 minutos llegaras al mirador. ",
                puntuacion = "puntuación: 4.5",
                urlimagen = "https://elturismoencolombia.com/wp-content/uploads/2018/08/jardin_antioquia_iglesia_inmaculada_concepcion_colombia.jpg"
        ),
            Lugar(
                name ="TELEFÉRICO LA GARRUCHA",
                description = "El Teleférico La Garrucha es un transporte autóctono que utilizaban los campesinos para moverse entre el pueblo y sus fincas y también mover con mucho más rápido sus cosechas. ",
                puntuacion = "puntuación: 4.2",
                urlimagen = "https://elturismoencolombia.com/wp-content/uploads/2018/08/jardin_antioquia_iglesia_inmaculada_concepcion_colombia.jpg"
            ),
            Lugar(
                name ="CUEVA DEL ESPLENDOR",
                description = "La Cueva del Esplendor también es conocida como la Cueva del Encanto y es una de las atracciones naturales más emblemáticas del municipio de Jardín. ",
                puntuacion = "puntuación: 3.9",
                urlimagen = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/La_Cueva_del_Esplendor_Jard%C3%ADn%2C_Antioquia.jpg/640px-La_Cueva_del_Esplendor_Jard%C3%ADn%2C_Antioquia.jpg"
            ),
            Lugar(
                name ="CUEVA DE LOS GUÁCHAROS",
                description = "El parque nacional natural Cueva de los Guácharos es una de las 59 áreas protegidas del sistema de Parques Nacionales Naturales de Colombia y la más antigua. ",
                puntuacion = "puntuación: 4.9",
                urlimagen = "https://miviaje.com/wp-content/uploads/2019/11/cascada-guacharos.jpg"
            ),
            Lugar(
                name ="LAS TRUCERAS",
                description = "es un sitio de recreo donde podrás encontrar Pesca Deportiva, Restaurante y Bar. Las truchas tienen unas preparaciones especiales como, por ejemplo, a la mostaza, finas hierbas y la Trucha Jardín, rellena de verduras. ",
                puntuacion = "puntuación: 3.2",
                urlimagen = "https://media-cdn.tripadvisor.com/media/photo-s/0a/33/53/21/fish-nursery.jpg"
            )

        )
    }



}