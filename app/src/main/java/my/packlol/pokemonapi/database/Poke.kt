package my.packlol.pokemonapi.database

import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
data class Poke(
    @PrimaryKey val name : String,
    //@NotNull @ColumnInfo(name = "_name") val name : String,
    @NotNull @ColumnInfo(name = "_weight") val weight : Int,
    @NotNull @ColumnInfo(name = "_height") val height : Int,
    @NotNull @ColumnInfo(name = "_sprite") val sprite : Drawable
)