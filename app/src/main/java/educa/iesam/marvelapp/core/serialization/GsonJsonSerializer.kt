package educa.iesam.marvelapp.core.serialization

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import educa.iesam.marvelapp.feature.marvelapp.domain.Superhero
import java.lang.reflect.Type

class GsonJsonSerializer<T>(
    private val type: Type,
    private val gson: Gson = Gson()
) : JsonSerializer<T> {

    override fun toJson(obj: Superhero): String = gson.toJson(obj, type)

    override fun fromJson(json: String): T =
        gson.fromJson<T>(json, type)
            ?: throw IllegalArgumentException("El JSON está vacío o es null")

    companion object {
        inline fun <reified T> create(gson: Gson = Gson()): GsonJsonSerializer<T> =
            GsonJsonSerializer(object : TypeToken<T>() {}.type, gson)
    }
}