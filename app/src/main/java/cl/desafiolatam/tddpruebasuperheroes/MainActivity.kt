package cl.desafiolatam.tddpruebasuperheroes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cl.desafiolatam.tddpruebasuperheroes.model.Repository
import cl.desafiolatam.tddpruebasuperheroes.model.remote.pojo.SuperHeroMin
import cl.desafiolatam.tddpruebasuperheroes.view.SuperHeroAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var superHeroesList = ArrayList<SuperHeroMin>()
    private lateinit var viewAdapter: SuperHeroAdapter
    private lateinit var repository: Repository

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

        repository = Repository(applicationContext)
        repository.loadApidata()
        repository.listSuperHero.observe(this, {
            viewAdapter.updateItems(it)
        })
    }
}
