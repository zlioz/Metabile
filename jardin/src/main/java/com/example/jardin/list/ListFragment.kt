package com.example.jardin.list

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jardin.R
import com.example.jardin.databinding.FragmentDetailBinding
import com.example.jardin.databinding.FragmentListBinding
import com.example.jardin.model.Lugar
import com.example.jardin.model.LugarItem
import com.google.gson.Gson
import com.karendamore.metabile.LugaresAdapter


class ListFragment : Fragment() {

    private lateinit var lugaresAdapter: LugaresAdapter
    private lateinit var listLugares: ArrayList<LugarItem>
    private lateinit var listBinding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        listBinding= FragmentListBinding.inflate(inflater, container, false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listLugares = loadMockLugaresFromJson()
        lugaresAdapter= LugaresAdapter(listLugares, onItemClicked = {onLugaresClicked(it)})

        listBinding.lugaresRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }
    }

    private fun onLugaresClicked (lugar: LugarItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(lugar=lugar))

    }
    private fun loadMockLugaresFromJson(): ArrayList<LugarItem> {
        val lugaresString: String =
            context?.assets?.open("lugares.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        return gson.fromJson(lugaresString, Lugar::class.java)
    }



}