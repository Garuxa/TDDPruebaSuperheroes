package cl.desafiolatam.tddpruebasuperheroes.model.remote

import cl.desafiolatam.tddpruebasuperheroes.model.remote.pojo.SuperHeroPojo
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SuperHeroesAPI {
    @GET("/all.json")
    fun allSuperHeroes(): Call<SuperHeroPojo>
}

class RetrofitClient {
    companion object {
        private const val BASE_URL = "https://akabab.github.io/superhero-api/api"

        fun retrofitInstance(): SuperHeroesAPI {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(SuperHeroesAPI::class.java)
        }
    }
}

