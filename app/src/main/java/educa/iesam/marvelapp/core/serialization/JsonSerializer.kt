package educa.iesam.marvelapp.core.serialization

import educa.iesam.marvelapp.feature.marvelapp.domain.Superhero

interface JsonSerializer<T> {
    fun toJson(obj: Superhero): String
    fun fromJson(json: String): T
}
