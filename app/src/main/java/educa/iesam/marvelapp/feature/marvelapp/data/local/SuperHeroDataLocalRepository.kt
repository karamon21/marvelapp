package educa.iesam.marvelapp.feature.marvelapp.data.local

import educa.iesam.marvelapp.feature.marvelapp.data.local.xml.SuperHeroXmlLocalDataSource
import educa.iesam.marvelapp.feature.marvelapp.domain.Superhero
import educa.iesam.marvelapp.feature.marvelapp.domain.SuperheroRepository

class SuperHeroDataLocalRepository(private val xmlLocalDatasource: SuperHeroXmlLocalDataSource) : SuperheroRepository {
   override fun getAll(): List<Superhero> {
        return xmlLocalDatasource.findAll()
    }
}