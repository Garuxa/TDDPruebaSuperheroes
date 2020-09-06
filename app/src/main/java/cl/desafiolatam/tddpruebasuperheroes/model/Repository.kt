package cl.desafiolatam.tddpruebasuperheroes.model

import android.content.Context
import android.util.Log
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
                Log.d("REPOSITORY", "Respuesta del servidor: ${response.code()}")
                saveDB(superHeroToSuperHeroEntity(response.body()!!))
            }

            override fun onFailure(call: Call<SuperHeroPojo>, t: Throwable) {
                Log.d("REPOSITORY", "Error " + t)
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