package com.example.jardin.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jardin.databinding.FragmentListBinding
import com.example.jardin.ui.main.MainActivity
import com.example.jardin.model.LugarItem
import com.karendamore.metabile.LugaresAdapter


class ListFragment : Fragment() {

    private lateinit var lugaresAdapter: LugaresAdapter
    private var listLugares: ArrayList<LugarItem> = arrayListOf()
    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()

        /*    listViewModel.loadMockLugaresFromJson(context?.assets?.open("lugares.json"))*/

        listViewModel.getLugaresFromServer()

        listViewModel.onLugaresLoaded.observe(viewLifecycleOwner, { result ->
            onLugaresLoadedSubscribe(result)
        })
        lugaresAdapter = LugaresAdapter(listLugares!!, onItemClicked = { onLugaresClicked(it) })

        listBinding.lugaresRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }

    }

    private fun onLugaresLoadedSubscribe(result: ArrayList<LugarItem>?) {
        result?.let {listLugares ->
            lugaresAdapter.appendItems(listLugares)
    /*
    this.listLugares = listLugares
    lugaresAdapter.notifyDataSetChanged()
    */
}

    }

    private fun onLugaresClicked(lugar: LugarItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(lugar = lugar))

    }
}

