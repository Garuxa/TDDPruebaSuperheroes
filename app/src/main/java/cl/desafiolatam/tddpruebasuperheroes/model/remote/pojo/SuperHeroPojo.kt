package cl.desafiolatam.tddpruebasuperheroes.model.remote.pojo

import com.google.gson.annotations.SerializedName

/*
data class SuperHeroPojo(
    val id: Int,
    val name: String,
    val slug: String,
    val powerstats: Map<String, List<String>>,
    val appearance: Map<String, List<String>>,
    val biography: Map<String, List<String>>,
    val work: Map<String, List<String>>,
    val connections: Map<String, List<String>>,
    val images: Map<String, List<String>>
)*/

class SuperHeroPojo : ArrayList<SuperHeroPojo.SuperHeroPojoItem>() {
    data class SuperHeroPojoItem(
        @SerializedName("id")
        val id: Int, // 731
        @SerializedName("name")
        val name: String, // Zoom
        /*@SerializedName("slug")
        val slug: String, // 731-zoom
        @SerializedName("powerstats")
        val powerstats: Powerstats,
        @SerializedName("appearance")
        val appearance: Appearance,
        @SerializedName("biography")
        val biography: Biography,
        @SerializedName("work")
        val work: Work,
        @SerializedName("connections")
        val connections: Connections,*/
        @SerializedName("images")
        val images: Images
    ) {
        /*data class Powerstats(
            @SerializedName("intelligence")
            val intelligence: Int, // 50
            @SerializedName("strength")
            val strength: Int, // 10
            @SerializedName("speed")
            val speed: Int, // 100
            @SerializedName("durability")
            val durability: Int, // 28
            @SerializedName("power")
            val power: Int, // 100
            @SerializedName("combat")
            val combat: Int // 28
        )*/

        /*data class Appearance(
            @SerializedName("gender")
            val gender: String, // Male
            @SerializedName("race")
            val race: Any?, // null
            @SerializedName("height")
            val height: List<String>,
            @SerializedName("weight")
            val weight: List<String>,
            @SerializedName("eyeColor")
            val eyeColor: String, // Red
            @SerializedName("hairColor")
            val hairColor: String // Brown
        )*/

        /*data class Biography(
            @SerializedName("fullName")
            val fullName: String, // Hunter Zolomon
            @SerializedName("alterEgos")
            val alterEgos: String, // No alter egos found.
            @SerializedName("aliases")
            val aliases: List<String>,
            @SerializedName("placeOfBirth")
            val placeOfBirth: String, // -
            @SerializedName("firstAppearance")
            val firstAppearance: String, // Flash Secret Files #3
            @SerializedName("publisher")
            val publisher: String, // DC Comics
            @SerializedName("alignment")
            val alignment: String // bad
        )*/

        /*data class Work(
            @SerializedName("occupation")
            val occupation: String, // -
            @SerializedName("base")
            val base: String // Keystone City, Kansas
        )*/

        /*data class Connections(
            @SerializedName("groupAffiliation")
            val groupAffiliation: String, // Secret Society of Super Villains, formerly Keystone Police Department, F.B.I.
            @SerializedName("relatives")
            val relatives: String // Ashley Zolomon (ex-wife)
        )*/

        data class Images(
            @SerializedName("xs")
            val xs: String, // https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/xs/731-zoom.jpg
            @SerializedName("sm")
            val sm: String, // https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/sm/731-zoom.jpg
            @SerializedName("md")
            val md: String, // https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/731-zoom.jpg
            @SerializedName("lg")
            val lg: String // https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/731-zoom.jpg
        )
    }
}
