package educa.iesam.marvelapp.feature.marvelapp.domain

interface SuperheroRepository {

    fun getAll(): List<Superhero>
}