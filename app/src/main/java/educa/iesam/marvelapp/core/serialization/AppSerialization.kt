package educa.iesam.marvelapp.core.serialization

interface AppSerialization {

    fun <T> toJson(obj: T): String
    fun <T> fromJson(json: String, classCasting: Class<T>)
}