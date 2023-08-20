package my.packlol.pokemonapi.ui.theme

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import my.packlol.pokemonapi.Retro
import my.packlol.pokemonapi.database.Poke
import my.packlol.pokemonapi.database.PokemonDao

class PokeVM : ViewModel(){
    private val _state = MutableStateFlow(PokeUIState())
    val state = _state.asStateFlow()
    val api = Retro.pokemonAPI
    
    init {
        APICall()
    }

    fun APICall(){
        //creating new list of pokemons
        viewModelScope.launch {
            val response = api.getPoke()
            response.body()?.let{
                val newlist = it.results.map{ poke ->
                    poke.name
                }
                _state.update { it ->
                    it.copy(
                        loading = false,
                        pokeList = newlist
                    )
                }
            }
            _state.update{
                it.copy(
                    loading = false
                )

            }
        }
    }

}

@Immutable
data class PokeUIState(
    val loading : Boolean = true,
    val pokeList : List<String> = listOf()
){

}