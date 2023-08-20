package my.packlol.pokemonapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.gson.Gson
import my.packlol.pokemonapi.converter.PokeResponse
import my.packlol.pokemonapi.ui.theme.PokeVM
import my.packlol.pokemonapi.ui.theme.PokemonAPITheme
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            val model by viewModels<PokeVM>()
            val state by model.state.collectAsState()
            
            
            PokemonAPITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    
                    Column() {
                        Text(text = state.toString())
                    }
                }
            }
        }
    }
}
val gson : Gson = Gson()

object Retro{
    val instance = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val pokemonAPI = instance.create(Pokemo::class.java)
}

interface Pokemo{
    @GET("pokemon")
    suspend fun getPoke() : Response<PokeResponse>
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

