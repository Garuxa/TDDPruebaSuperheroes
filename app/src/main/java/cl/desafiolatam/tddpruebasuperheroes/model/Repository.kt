package cl.desafiolatam.tddpruebasuperheroes.model

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cl.desafiolatam.tddpruebasuperheroes.model.remote.RetrofitClient
import cl.desafiolatam.tddpruebasuperheroes.model.remote.pojo.SuperHeroPojo
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    var listSuperHero = MutableLiveData<SuperHeroPojo>()

    fun loadApidata() {
        val service = RetrofitClient.retrofitInstance()
        val call = service.listaHeroes()

        call.enqueue(object : Callback<SuperHeroPojo> {
            override fun onResponse(call: Call<SuperHeroPojo>, response: Response<SuperHeroPojo>) {
                //Log.d("MAIN", "${response.code()}")
                //Log.d("MAIN", "${call.request().url()}")
                //Log.d("MAIN", "${response.body()}")
                response.body()?.map {
                    Log.d("MAIN", "${it.id} - ${it.name} - ${it.images.md}")
                }
                listSuperHero.value = response.body()
                //viewAdapter.updateItems(response.body()!!)
                //viewAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<SuperHeroPojo>, t: Throwable) {
                Log.d("MAIN", "Error " + t)
                /*Toast.makeText(
                    applicationContext,
                    "Error: no pudimos recuperar los datos desde la api",
                    Toast.LENGTH_SHORT
                ).show()*/
            }
        })
    }

}