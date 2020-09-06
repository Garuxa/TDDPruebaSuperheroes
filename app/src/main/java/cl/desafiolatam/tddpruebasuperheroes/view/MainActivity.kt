package cl.desafiolatam.tddpruebasuperheroes.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cl.desafiolatam.tddpruebasuperheroes.R
import cl.desafiolatam.tddpruebasuperheroes.model.remote.pojo.SuperHeroMin
import cl.desafiolatam.tddpruebasuperheroes.viewmodel.SuperHeroViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var superHeroesList = ArrayList<SuperHeroMin>()
    private lateinit var viewAdapter: SuperHeroAdapter
    private lateinit var superHeroViewModel: SuperHeroViewModel


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

        superHeroViewModel = ViewModelProvider(this).get(SuperHeroViewModel::class.java)

        superHeroViewModel.listSuperHero.observe(this, {
            viewAdapter.updateItems(it)
        })
    }
}
