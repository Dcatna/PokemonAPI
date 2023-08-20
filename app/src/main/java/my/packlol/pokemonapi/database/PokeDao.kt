package my.packlol.pokemonapi.database

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import org.jetbrains.annotations.NotNull



@Dao
interface PokemonDao{
    @Query("SELECT * FROM poke")
    suspend fun getAll() : List<Poke>

    @Query("SELECT * FROM poke WHERE name = :name")
    suspend fun getPokeName(name : String) : String


    //insert and delete from personal pokedex??
    @Insert
    suspend fun insertPoke(name : String)

    @Delete
    suspend fun deletePoke(name : String)

}