package educa.iesam.marvelapp.feature.marvelapp.data.local.xml

import android.content.Context
import educa.iesam.marvelapp.R
import educa.iesam.marvelapp.core.serialization.AppSerialization
import educa.iesam.marvelapp.feature.marvelapp.domain.Superhero

class SuperHeroXmlLocalDataSource(
    private val context: Context,
    private val serialization: AppSerialization
) {

    val sharedPreference = context.getSharedPreferences(
        context.getString(R.string.local_source_superhero),
        Context.MODE_PRIVATE
    )

    fun findAll(): List<Superhero> {
        val superhero = Superhero("1", "Capitan America", "capitan-america", "https://")
        val json = serialization.toJson(superhero)
        serialization.fromJson(json, Superhero::class.java)
        return emptyList()
    }
}

