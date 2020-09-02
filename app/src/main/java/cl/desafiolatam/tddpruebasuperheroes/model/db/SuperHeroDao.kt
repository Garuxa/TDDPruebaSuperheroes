package cl.desafiolatam.tddpruebasuperheroes.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SuperHeroDao {

    @Query("SELECT * from superHero ORDER BY superHero_name ASC")
    fun getSuperHeroes(): LiveData<List<SuperHeroEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSuperHeroes(superHero: List<SuperHeroEntity>)

    @Query("DELETE FROM superHero")
    suspend fun deleteAll()
}