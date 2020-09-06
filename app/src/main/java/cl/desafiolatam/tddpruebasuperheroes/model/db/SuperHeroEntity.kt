package cl.desafiolatam.tddpruebasuperheroes.model.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import cl.desafiolatam.tddpruebasuperheroes.model.remote.pojo.SuperHeroPojo

@Entity(tableName = "supehero_table")
data class SuperHeroEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val slug: String,
    @Embedded val powerstats: SuperHeroPojo.SuperHeroPojoItem.Powerstats,
    @Embedded val appearance: SuperHeroPojo.SuperHeroPojoItem.Appearance,
    @Embedded val biography: SuperHeroPojo.SuperHeroPojoItem.Biography,
    @Embedded val work: SuperHeroPojo.SuperHeroPojoItem.Work,
    @Embedded val connections: SuperHeroPojo.SuperHeroPojoItem.Connections,
    @Embedded val images: SuperHeroPojo.SuperHeroPojoItem.Images
)