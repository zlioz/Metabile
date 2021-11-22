package com.karendamore.metabile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class SitiosTuristicosListActivity : AppCompatActivity() {

    private lateinit var listLugares: ArrayList<LugarItem>
    private lateinit var lugaresAdapter: LugaresAdapter
    private lateinit var lugaresRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sitios_turisticos_list)

        lugaresRecyclerView=findViewById(R.id.lugares_recycler_view)

        //listLugares= createMockLugares()
        listLugares= LoadMockLugaresFromJSON()

        lugaresAdapter=LugaresAdapter(listLugares)

        lugaresRecyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        lugaresRecyclerView.adapter=lugaresAdapter
    }

    private fun LoadMockLugaresFromJSON(): ArrayList<LugarItem> {
        val lugaresString: String =
            applicationContext.assets.open("lugares.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        return gson.fromJson(lugaresString, Lugar::class.java)
    }

    /*private fun createMockLugares(): ArrayList<Lugar>{
        return arrayListOf(
            Lugar(
                name ="Basilica",
                description = "La Basílica Menor de La Inmaculada Concepción es una de las iglesias más lindas de Antioquia, está construida en piedra labrada a mano, su estilo es neogótico y ha sido decorada en su interior con arcos recubiertos en oro. ",
                puntuacion = "3.2",
                urlimagen = "https://imgs-akamai.mnstatic.com/a9/b0/a9b0cd229baaa4367e2b716804cd5143.jpg"
            ),
            Lugar(
                name ="MIRADOR CRISTO REY",
                description = "Para llegar puedes caminar desde el parque principal de Jardín durante una 1 hora, o puedes ir en Tuk-Tuk durante unos 10 minutos llegaras al mirador. ",
                puntuacion = "4.5",
                urlimagen = "https://www.livevalledelcauca.com/assets2018/images/cali/monumento-a-cristo-rey-3.jpg"
            ),
            Lugar(
                name ="TELEFÉRICO LA GARRUCHA",
                description = "El Teleférico La Garrucha es un transporte autóctono que utilizaban los campesinos para moverse entre el pueblo y sus fincas y también mover con mucho más rápido sus cosechas. ",
                puntuacion = "4.2",
                urlimagen = "https://live.staticflickr.com/1508/26560912101_b5cb4b5e00_c.jpg"
            ),
            Lugar(
                name ="CUEVA DEL ESPLENDOR",
                description = "La Cueva del Esplendor también es conocida como la Cueva del Encanto y es una de las atracciones naturales más emblemáticas del municipio de Jardín. ",
                puntuacion = "3.9",
                urlimagen = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/La_Cueva_del_Esplendor_Jard%C3%ADn%2C_Antioquia.jpg/640px-La_Cueva_del_Esplendor_Jard%C3%ADn%2C_Antioquia.jpg"
            ),
            Lugar(
                name ="CUEVA DE LOS GUÁCHAROS",
                description = "El parque nacional natural Cueva de los Guácharos es una de las 59 áreas protegidas del sistema de Parques Nacionales Naturales de Colombia y la más antigua. ",
                puntuacion = "4.9",
                urlimagen = "https://miviaje.com/wp-content/uploads/2019/11/cascada-guacharos.jpg"
            ),
            Lugar(
                name ="LAS TRUCHERAS",
                description = "es un sitio de recreo donde podrás encontrar Pesca Deportiva, Restaurante y Bar. Las truchas tienen unas preparaciones especiales como, por ejemplo, a la mostaza, finas hierbas y la Trucha Jardín, rellena de verduras. ",
                puntuacion = "3.2",
                urlimagen = "https://media-cdn.tripadvisor.com/media/photo-s/0a/33/53/21/fish-nursery.jpg"
            )

        )
    }*/



}