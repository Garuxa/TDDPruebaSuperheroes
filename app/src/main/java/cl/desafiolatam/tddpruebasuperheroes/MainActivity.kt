package cl.desafiolatam.tddpruebasuperheroes

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cl.desafiolatam.tddpruebasuperheroes.model.Repository
import cl.desafiolatam.tddpruebasuperheroes.model.remote.RetrofitClient
import cl.desafiolatam.tddpruebasuperheroes.model.remote.pojo.SuperHeroPojo
import cl.desafiolatam.tddpruebasuperheroes.view.SuperHeroAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var superHeroesList = ArrayList<SuperHeroPojo.SuperHeroPojoItem>()
    private lateinit var viewAdapter: SuperHeroAdapter
    private var repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewAdapter = SuperHeroAdapter(superHeroesList)
        superHero_Recycler.adapter = viewAdapter

        superHero_Recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        repository.loadApidata()
        repository.listSuperHero.observe(this, { viewAdapter.updateItems(it) })

        /*val picasso = Picasso.Builder(applicationContext)
            //.indicatorsEnabled(true)
            .loggingEnabled(true)
            .build()

        Picasso.setSingletonInstance(picasso)*/
    }
}
