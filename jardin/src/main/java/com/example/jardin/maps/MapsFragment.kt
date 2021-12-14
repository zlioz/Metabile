package com.example.jardin.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jardin.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val basilica = LatLng(5.5988511,-75.818949)
        googleMap.addMarker(MarkerOptions().position(basilica).title("Basílica Menor de la Inmaculada Concepción"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(basilica,15F))

       val mirador = LatLng(5.6047515,-75.8200618)
        googleMap.addMarker(MarkerOptions().position(mirador).title("Mirador Cristo Rey"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mirador,15F))

        val teleferico = LatLng(5.6047514,-75.8266548)
        googleMap.addMarker(MarkerOptions().position(teleferico).title("Teleferico la Garrucha"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(teleferico,15F))

        val cueva = LatLng(5.6425455,-75.8101889)
        googleMap.addMarker(MarkerOptions().position(cueva).title("Cueva del Esplendor"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cueva,15F))

        val guarachos = LatLng(5.6184286,-75.7882565)
        googleMap.addMarker(MarkerOptions().position(guarachos).title("Basílica Menor de la Inmaculada Concepción"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(guarachos,15F))

        val trucheras = LatLng(5.5916204,-75.8103345)
        googleMap.addMarker(MarkerOptions().position(trucheras).title("Basílica Menor de la Inmaculada Concepción"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(trucheras,15F))

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