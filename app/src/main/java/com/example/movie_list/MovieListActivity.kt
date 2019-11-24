package com.example.movie_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

import trikita.anvil.DSL.*
import trikita.anvil.DSL.linearLayout

import com.example.movie_list.model.Movie.MovieItem
import com.example.movie_list.model.Movie.movies

class MovieListActivity : AppCompatActivity() {

    val listComponent = ListComponent<MovieItem>()
    val movieAdapter = ListAdapter<MovieItem> { item -> listComponent.showItem(item) { movieView(item) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieAdapter.items = movies
        setContentView(listComponent.showItemList(this) { movieListView() } )
    }

    fun movieView(movie: MovieItem) {
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
                    val intent = Intent(this, MovieDetailActivity::class.java)
                    intent.putExtra("movie_title", movies[pos].title)
                    intent.putExtra("movie_date", movies[pos].releaseDate)
                    intent.putExtra("movie_poster", movies[pos].posterPath)
                    intent.putExtra("movie_genre", movies[pos].genre)
                    this.startActivity(intent)
                }
            }
        }
    }

}
