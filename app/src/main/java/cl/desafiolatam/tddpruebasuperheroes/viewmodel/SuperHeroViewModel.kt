package cl.desafiolatam.tddpruebasuperheroes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import cl.desafiolatam.tddpruebasuperheroes.model.Repository

class SuperHeroViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: Repository = Repository(application)
    var listSuperHero = repository.listSuperHero

    init {
        repository = Repository(application)
        repository.loadApidata()
    }
}