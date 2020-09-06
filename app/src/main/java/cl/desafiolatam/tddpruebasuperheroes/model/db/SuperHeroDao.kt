package cl.desafiolatam.tddpruebasuperheroes.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SuperHeroDao {

    @Query("SELECT * from supehero_table")
    fun getSuperHeroes(): LiveData<List<SuperHeroEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSuperHeroes(superHeroList: List<SuperHeroEntity>)

    @Query("DELETE FROM supehero_table")
    suspend fun deleteAll()
}