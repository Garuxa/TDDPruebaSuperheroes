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
    @Embedded(prefix = "pwrsts_") val powerstats: SuperHeroPojo.SuperHeroPojoItem.Powerstats,
    @Embedded(prefix = "appear_") val appearance: SuperHeroPojo.SuperHeroPojoItem.Appearance?,
    @Embedded(prefix = "bio_") val biography: SuperHeroPojo.SuperHeroPojoItem.Biography?,
    @Embedded(prefix = "work_") val work: SuperHeroPojo.SuperHeroPojoItem.Work,
    @Embedded(prefix = "connect_") val connections: SuperHeroPojo.SuperHeroPojoItem.Connections,
    @Embedded(prefix = "img_") val images: SuperHeroPojo.SuperHeroPojoItem.Images
)