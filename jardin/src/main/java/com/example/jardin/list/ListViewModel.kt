package com.example.jardin.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jardin.model.Lugar
import com.example.jardin.model.LugarItem
import com.google.gson.Gson
import java.io.InputStream

class ListViewModel: ViewModel() {
    private var lugaresLoad : MutableLiveData<ArrayList<LugarItem>> = MutableLiveData()
    val onLugaresLoaded: LiveData<ArrayList<LugarItem>> = lugaresLoad

 fun loadMockLugaresFromJson(lugaresString: InputStream?) {
    val lugarString = lugaresString?.bufferedReader().use{it!!.readText() }
    val gson = Gson()
    lugaresLoad.value = gson.fromJson(lugarString,Lugar::class.java)
    }
}
