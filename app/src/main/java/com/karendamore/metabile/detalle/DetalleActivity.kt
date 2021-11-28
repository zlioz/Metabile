package com.karendamore.metabile.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.karendamore.metabile.R
import com.karendamore.metabile.databinding.ActivityDetalleBinding
import com.karendamore.metabile.model.LugarItem
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {
    private lateinit var detalleBinding: ActivityDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val lugar: LugarItem= intent.extras?.getSerializable("lugar") as LugarItem

        with(detalleBinding){
            nameTextView.text=lugar.name
            descriptionTextView.text=lugar.description
            ubicacionTextView.text=lugar.ubicacion
            temperaturaTextView.text=lugar.temperatura
            otrosLugaresTextView.text=lugar.otros_lugares
            Picasso.get().load(lugar.urlimagen).into(pictureImageView)

        }



    }
}
