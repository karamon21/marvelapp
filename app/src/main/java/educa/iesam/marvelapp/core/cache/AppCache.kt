package educa.iesam.marvelapp.core.cache

interface AppCache{
    fun updateTime(key:String)
    fun isExpired(key: String, ttl: Long) : Boolean

}