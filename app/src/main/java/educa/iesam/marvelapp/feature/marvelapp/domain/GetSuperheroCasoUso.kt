package educa.iesam.marvelapp.feature.marvelapp.domain

class GetSuperheroCasoUso(private val superHeroRepository: SuperheroRepository) {
    operator fun invoke(): List<Superhero> {
        return superHeroRepository.getAll()
    }
}