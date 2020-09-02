package cl.desafiolatam.tddpruebasuperheroes.model.remote.pojo

data class SuperHeroPojo(
    val name: String,
    val appearance: Map<String, List<String>>,
    val images: Map<String, List<String>>
)

data class SuperHeroImagesPojo(val name: String, val images: List<String>)