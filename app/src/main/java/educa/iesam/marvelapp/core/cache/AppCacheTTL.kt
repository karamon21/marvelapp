package educa.iesam.marvelapp.core.cache

import android.content.Context
import educa.iesam.marvelapp.R
import educa.iesam.marvelapp.core.time.AppTime

class AppCacheTTL(private val context: Context,private val appTime: AppTime): AppCache {
    val sharedPref = context.getSharedPreferences(context.getString(R.string.app_cache), Context.MODE_PRIVATE)
    override fun updateTime(key: String) {
       sharedPref.edit().apply(){
           putLong(key,appTime.currentTimeToLong())
           apply()
       }
    }

    override fun isExpired(key: String, ttl: Long): Boolean {
       val timeSave = sharedPref.getLong(key,-1)
        return (appTime.currentTimeToLong() - timeSave) >= ttl
    }
}