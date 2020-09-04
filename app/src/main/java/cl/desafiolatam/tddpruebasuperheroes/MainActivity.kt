package cl.desafiolatam.tddpruebasuperheroes

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cl.desafiolatam.tddpruebasuperheroes.model.remote.RetrofitClient
import cl.desafiolatam.tddpruebasuperheroes.model.remote.pojo.SuperHeroPojo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadApidata()
    }

    private fun loadApidata() {
        val service = RetrofitClient.retrofitInstance()
        val call = service.listaHeroes()

        call.enqueue(object : Callback<SuperHeroPojo> {
            override fun onResponse(call: Call<SuperHeroPojo>, response: Response<SuperHeroPojo>) {
                Log.d("MAIN", "${response.code()}")
                Log.d("MAIN", "${call.request().url()}")
                Log.d("MAIN", "${response.body()}")
            }

            override fun onFailure(call: Call<SuperHeroPojo>, t: Throwable) {
                Log.d("MAIN", "Error " + t)
                Toast.makeText(
                    applicationContext,
                    "Error: no pudimos recuperar los datos desde la api",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}
