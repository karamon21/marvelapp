package educa.iesam.marvelapp.feature.marvelapp.data.local.xml

import android.content.Context
import educa.iesam.marvelapp.R
import educa.iesam.marvelapp.core.cache.AppCacheTTL
import educa.iesam.marvelapp.core.serialization.JsonSerializer
import educa.iesam.marvelapp.feature.marvelapp.domain.Superhero

class SuperHeroXmlLocalDataSource(private val context: Context,
    private val serialization: JsonSerializer<List<Superhero>>,
    private val appCacheTTL: AppCacheTTL,
    private val ttl: AppCacheTTL
) {

    val sharedPreference = context.getSharedPreferences(context.getString(R.string.local_source_superhero),
        Context.MODE_PRIVATE
    )

    fun save(superHeroes: List<Superhero>){
        sharedPreference.edit().apply{
           superHeroes.forEach { superhero ->
               putString(superhero.id,serialization.toJson(superhero))
           }
            apply()
            appCacheTTL.updateTime(superheroKey)
        }
    }
    fun findAll(): List<Superhero> {
      // if (!appCacheTTL.isExpired(superheroKey,ttl))
       val jsonList : String? = sharedPreference.getString(superheroKey,null)
         jsonList?.let {
          return serialization.fromJson(it)
         }
        return emptyList()

    }

    fun findById(id: String): Superhero? {
        return findAll()?.find{it.id == id}
    }

    fun deleteById(id: String){
        save(findAll().filterNot { it.id == id })
    }
    fun deleteAll(){
        sharedPreference.edit().apply{
            remove(superheroKey)
            apply()
        }
    }
    companion object {
        private const val superheroKey: String = "superhero"
    }
}

