package cl.desafiolatam.tddpruebasuperheroes.model.remote.pojo

import com.google.gson.annotations.SerializedName

class SuperHeroPojo : ArrayList<SuperHeroPojo.SuperHeroPojoItem>() {
    data class SuperHeroPojoItem(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("slug")
        val slug: String,
        @SerializedName("powerstats")
        val powerstats: Powerstats,
        @SerializedName("appearance")
        val appearance: Appearance,
        @SerializedName("biography")
        val biography: Biography,
        @SerializedName("work")
        val work: Work,
        @SerializedName("connections")
        val connections: Connections,
        @SerializedName("images")
        val images: Images
    ) {
        data class Powerstats(
            @SerializedName("intelligence")
            val intelligence: Int,
            @SerializedName("strength")
            val strength: Int,
            @SerializedName("speed")
            val speed: Int,
            @SerializedName("durability")
            val durability: Int,
            @SerializedName("power")
            val power: Int,
            @SerializedName("combat")
            val combat: Int
        )

        data class Appearance(
            @SerializedName("gender")
            val gender: String,
            @SerializedName("race")
            val race: String?,
            @SerializedName("height")
            val height: List<String>,
            @SerializedName("weight")
            val weight: List<String>,
            @SerializedName("eyeColor")
            val eyeColor: String,
            @SerializedName("hairColor")
            val hairColor: String
        )

        data class Biography(
            @SerializedName("fullName")
            val fullName: String,
            @SerializedName("alterEgos")
            val alterEgos: String,
            @SerializedName("aliases")
            val aliases: List<String>,
            @SerializedName("placeOfBirth")
            val placeOfBirth: String,
            @SerializedName("firstAppearance")
            val firstAppearance: String,
            @SerializedName("publisher")
            val publisher: String?,
            @SerializedName("alignment")
            val alignment: String
        )

        data class Work(
            @SerializedName("occupation")
            val occupation: String,
            @SerializedName("base")
            val base: String
        )

        data class Connections(
            @SerializedName("groupAffiliation")
            val groupAffiliation: String,
            @SerializedName("relatives")
            val relatives: String
        )

        data class Images(
            @SerializedName("xs")
            val xs: String,
            @SerializedName("sm")
            val sm: String,
            @SerializedName("md")
            val md: String,
            @SerializedName("lg")
            val lg: String
        )
    }
}

data class SuperHeroMin(
    val id: Int,
    val name: String,
    var appear_race: String?,
    val appear_height: List<String>,
    val appear_weight: List<String>,
    val bio_publisher: String?,
    val img_md: String
)
