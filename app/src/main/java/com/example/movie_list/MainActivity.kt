package com.example.movie_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.example.movie_list.model.Movie.MovieItem
import com.example.movie_list.model.Movie.movies
import trikita.anvil.DSL.*
import trikita.anvil.RenderableAdapter
import trikita.anvil.RenderableView

import com.example.movie_list.MovieAdapter.movieAdapter
import com.example.movie_list.MovieListComponent

class MainActivity : AppCompatActivity() {

    /*var movieAdapter = RenderableAdapter.withItems(movies) { pos, movie ->
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
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Adding some movies manually to test UI
        movies.add(MovieItem("title1","2010","poster1","comedy1"))
        movies.add(MovieItem("title2","2011","poster2","comedy2"))
        movies.add(MovieItem("title3","2012","poster3","comedy3"))
        movies.add(MovieItem("title4","2013","poster4","comedy4"))
        movies.add(MovieItem("title5", "2041", "poster5", "comedy5"))
        movies.add(MovieItem("title6","2016","poster6","comedy6"))
        movies.add(MovieItem("title7","2015","poster7","comedy7"))

        setContentView(getView())
    }

    fun getView(): View {
        return object : RenderableView(this) {
            override fun view() {
                linearLayout {
                    size(MATCH, MATCH)
                    padding(dip(8))
                    orientation(LinearLayout.VERTICAL)
                    gravity(CENTER)
                    textView {
                        size(WRAP,WRAP)
                        text("Hello! Click on the button below to show our movies list!")
                        textSize(64f)
                        gravity(CENTER_HORIZONTAL)
                    }
                    button {
                        size(WRAP,WRAP)
                        text("List movies")
                        textSize(56f)
                        onClick {
                            val intent = Intent(applicationContext,MovieListActivity::class.java)
                            startActivity(intent)
                            //setContentView(MovieListComponent().showMoviesList(this.context))
                        }
                    }
                }
            }
        }
    }

    /*fun showMoviesList(): View {
        return object : RenderableView(this) {
            override fun view() {
                movieAdapter.notifyDataSetChanged()
                linearLayout {
                    size(MATCH,MATCH)
                    padding(dip(8))
                    orientation(LinearLayout.VERTICAL)

                    listView {
                        size(FILL,FILL)
                        adapter(movieAdapter)
                        onItemClick { av, v, pos, id ->
                            val intent = Intent(applicationContext,MovieDetailActivity::class.java)
                            intent.putExtra("movie_title", movies[pos].title)
                            intent.putExtra("movie_date", movies[pos].releaseDate)
                            intent.putExtra("movie_poster", movies[pos].posterPath)
                            intent.putExtra("movie_genre", movies[pos].genre)
                            startActivity(intent)
                        }
                    }
                }
            }
        }

    }*/
}
