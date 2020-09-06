package cl.desafiolatam.tddpruebasuperheroes.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import cl.desafiolatam.tddpruebasuperheroes.model.db.SuperHeroEntity
import cl.desafiolatam.tddpruebasuperheroes.model.db.SuperHeroRoomDatabase
import cl.desafiolatam.tddpruebasuperheroes.model.remote.RetrofitClient
import cl.desafiolatam.tddpruebasuperheroes.model.remote.pojo.SuperHeroPojo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(context: Context) {


    var superHerodb = SuperHeroRoomDatabase.getDatabase(context)
    var listSuperHero = superHerodb.getSuperHeroDao().getMinimalSuperHeroesList()

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
                //listSuperHero.value = response.body()
                saveDB(superHeroToSuperHeroEntity(response.body()!!))
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

    fun superHeroToSuperHeroEntity(superHeroList: ArrayList<SuperHeroPojo.SuperHeroPojoItem>): List<SuperHeroEntity> {
        return superHeroList.map { superHero ->
            SuperHeroEntity(
                superHero.id,
                superHero.name,
                superHero.slug,
                superHero.powerstats,
                superHero.appearance,
                superHero.biography,
                superHero.work,
                superHero.connections,
                superHero.images
            )
        }
    }

    fun saveDB(listSuperHeroEntity: List<SuperHeroEntity>) {
        CoroutineScope(Dispatchers.IO).launch {
            superHerodb.getSuperHeroDao().insertSuperHeroes(listSuperHeroEntity)
        }
    }

}