package com.example.jardin.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.jardin.R
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    val args: MapsFragmentArgs by navArgs()

    private val callback = OnMapReadyCallback { googleMap ->

        val marcador = args.lugar

        val lugarMapa = LatLng(marcador.Latitud,marcador.Longitud)
        googleMap.addMarker(MarkerOptions().position(lugarMapa).title(marcador.name))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lugarMapa,15F))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}