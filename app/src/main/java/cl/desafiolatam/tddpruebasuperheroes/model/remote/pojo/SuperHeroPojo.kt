package cl.desafiolatam.tddpruebasuperheroes.model.remote.pojo

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
)