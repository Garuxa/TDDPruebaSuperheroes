package cl.desafiolatam.tddpruebasuperheroes.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "superHero")
data class SuperHeroEntity(@PrimaryKey @ColumnInfo(name = "superHero_name") val SuperHeroName: String)