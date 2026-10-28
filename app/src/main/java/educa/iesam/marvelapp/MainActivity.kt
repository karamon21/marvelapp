package educa.iesam.marvelapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import educa.iesam.marvelapp.feature.marvelapp.data.local.xml.SuperHeroXmlLocalDataSource
import educa.iesam.marvelapp.feature.marvelapp.domain.Superhero

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Crear un fichero SharedPreference
        val xml = SuperHeroXmlLocalDataSource(this)

        xml.save(mutableListOf(Superhero("1", "Super Man", "super-man", "https://")))
        xml.save(mutableListOf(Superhero("2", "Black Panther", "black panther", "https://")))
        xml.save(mutableListOf(Superhero("3", "Capitan America", "capitan america", "https://")))


        val superhero = xml.findById("2")
        Log.d(MainActivity::class.java.simpleName, superhero.toString())
    }

}