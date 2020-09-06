package cl.desafiolatam.tddpruebasuperheroes.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.desafiolatam.tddpruebasuperheroes.model.remote.pojo.SuperHeroMin

@Dao
interface SuperHeroDao {

    @Query("SELECT * from supehero_table")
    fun getSuperHeroes(): LiveData<List<SuperHeroEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSuperHeroes(superHeroList: List<SuperHeroEntity>)

    @Query("DELETE FROM supehero_table")
    suspend fun deleteAll()

    @Query("SELECT id, name, appear_race, appear_height, appear_weight, bio_publisher, img_md FROM supehero_table")
    fun getMinimalSuperHeroesList(): LiveData<List<SuperHeroMin>>
}