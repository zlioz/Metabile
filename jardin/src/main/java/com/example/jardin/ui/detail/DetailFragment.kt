package com.example.jardin.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.jardin.databinding.FragmentDetailBinding
import com.example.jardin.ui.main.MainActivity
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private  val detailViewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lugar = args.lugar
        with(detailBinding){
            nameTextView.text=lugar.name
            descriptionTextView.text=lugar.description
            ubicacionTextView.text=lugar.ubicacion
            temperaturaTextView.text=lugar.temperatura
            otrosLugaresTextView.text=lugar.otros_lugares
            Picasso.get().load(lugar.urlimagen).into(pictureImageView)

            mapButton.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToMapsFragment(lugar = lugar))
            }
        }
    }
}
