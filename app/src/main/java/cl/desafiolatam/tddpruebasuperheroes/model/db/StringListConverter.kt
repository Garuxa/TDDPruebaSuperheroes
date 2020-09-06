package cl.desafiolatam.tddpruebasuperheroes.model.db

/*
SOLUCION ENCONTRADA EN https://stackoverflow.com/a/57424101/12955298
Y
https://developer.android.com/reference/androidx/room/TypeConverters
*/

import androidx.room.TypeConverter

class StringListConverter {
    @TypeConverter
    fun fromString(stringListString: String): List<String> {
        return stringListString.split(",").map { it }
    }

    @TypeConverter
    fun toString(stringList: List<String>): String {
        return stringList.joinToString()
    }
}
