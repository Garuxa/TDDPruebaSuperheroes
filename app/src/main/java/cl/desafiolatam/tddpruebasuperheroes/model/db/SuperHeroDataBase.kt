package cl.desafiolatam.tddpruebasuperheroes.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = [SuperHeroEntity::class], version = 1, exportSchema = false)
@TypeConverters(StringListConverter::class) // MAS INFO EN CLASE StringListConverter
abstract class SuperHeroRoomDatabase : RoomDatabase() {

    abstract fun getSuperHeroDao(): SuperHeroDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: SuperHeroRoomDatabase? = null

        fun getDatabase(context: Context): SuperHeroRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SuperHeroRoomDatabase::class.java,
                    "superhero_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}