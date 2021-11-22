package com.karendamore.metabile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class LugaresAdapter(private val lugaresList: ArrayList<LugarItem>) : RecyclerView.Adapter<LugaresAdapter.LugaresViewHolder>() {
//aqui se defino cual es el layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugaresViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.card_view_lugar_item,parent,false)
        return LugaresViewHolder(view)
    }
//
    override fun onBindViewHolder(holder: LugaresViewHolder, position: Int) {
        val lugar= lugaresList[position]
        holder.bind(lugar)
    }

    override fun getItemCount(): Int {
        return lugaresList.size
    }

    class LugaresViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private var nameTextureView: TextView= itemView.findViewById(R.id.name_text_view)
        private var descriptionTextView: TextView=itemView.findViewById(R.id.description_text_view)
        private var puntuacionTextView: TextView=itemView.findViewById(R.id.puntuacion_text_view)
        private var pictureImageView: ImageView=itemView.findViewById(R.id.picture_image_view)

        fun bind(lugar: LugarItem){
            nameTextureView.text=lugar.name
            descriptionTextView.text=lugar.description
            puntuacionTextView.text=lugar.puntuacion
            Picasso.get().load(lugar.urlimagen).into(pictureImageView)

        }
    }
}