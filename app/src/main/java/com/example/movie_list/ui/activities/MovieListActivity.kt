package com.example.movie_list.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.model.AppState
import com.example.movie_list.model.Movie
import com.example.movie_list.ui.components.ListAdapter
import com.example.movie_list.ui.components.ListComponent
import com.example.movie_list.ui.components.MovieListComponent
import trikita.anvil.DSL.*

class MovieListActivity : AppLifecycleActivity() {

    var position = 0
    val movieListComponent = MovieListComponent()
    val listComponent = ListComponent<Movie>() // TALVEZ MODIFICAR/RETIRAR ESSE COMPONENTE
    val movieAdapter =
        ListAdapter<Movie> { item ->
                movieView(item) // IRÁ PARA UM COMPONENTE ESPECÍFICO (MOVIEVIEWCOMPONENT)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        state.list?.let { movieAdapter.items = it }
        setContentView(listComponent.showItemList(this) {
                movieListView() // IRÁ PARA UM COMPONENTE ESPECÍFICO (MOVIELISTCOMPONENT)
        })
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        if (newState.movieClicked != oldState.movieClicked) return true
        return false
    }

    override fun onChanged(state: AppState) {
        // PÔR TUDO NO COMPONENTE (ONDE HÁ CLICK) PARA MUDANÇA DE TELA
        state.movieClicked?.let {
            if(state.movieClicked) {
                state.list?.let {
                    val item = state.list[position]
                    val intent = Intent(this, MovieDetailActivity::class.java)
                    intent.putExtra("movie_title", item.title)
                    intent.putExtra("movie_date", item.releaseDate)
                    intent.putExtra("movie_poster", item.posterPath)
                    intent.putExtra("movie_genre", item.genre)
                    this.startActivity(intent)
                }
            }
        }
    }

    fun movieView(movie: Movie) {
        linearLayout {
            size(FILL,WRAP)
            padding(dip(8))
            orientation(LinearLayout.VERTICAL)
            linearLayout {
                size(FILL, WRAP)
                padding(dip(8))
                orientation(LinearLayout.VERTICAL)
                linearLayout {
                    orientation(LinearLayout.HORIZONTAL)
                    size(WRAP, WRAP)
                    textView {
                        size(WRAP, WRAP)
                        text(movie.posterPath)
                        textSize(64f)
                    }
                    linearLayout {
                        orientation(LinearLayout.VERTICAL)
                        size(WRAP,WRAP)
                        margin(100,0,0,0)
                        textView {
                            size(WRAP, WRAP)
                            text(movie.title)
                            textSize(64f)
                        }
                        textView {
                            size(WRAP, WRAP)
                            text(movie.releaseDate)
                            textSize(48f)
                        }
                        textView {
                            size(WRAP, WRAP)
                            text(movie.genre)
                            textSize(48f)
                        }
                    }
                }
            }
        }
    }

    fun movieListView() {
        linearLayout {
            size(MATCH,MATCH)
            padding(dip(8))
            orientation(LinearLayout.VERTICAL)

            listView {
                size(FILL,FILL)
                adapter(movieAdapter)
                onItemClick { av, v, pos, id ->
                    position = pos
                    ActionCreator.instance.showMovie()
                }
            }
        }
    }

}
