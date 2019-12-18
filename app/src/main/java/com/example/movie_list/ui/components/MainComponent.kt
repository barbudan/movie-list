package com.example.movie_list.ui.components

import android.content.Context
import android.content.Intent
import android.widget.LinearLayout
import android.widget.Toast
import com.example.movie_list.R
import com.example.movie_list.MovieListApp
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.model.AppState
import com.example.movie_list.model.Movie
import com.example.movie_list.ui.activities.MovieListActivity
import trikita.anvil.RenderableView
import trikita.anvil.DSL.*

inline fun mainComponent(crossinline func: MainComponent.() -> Unit) {
    highOrderComponent(func)
}

class MainComponent(context: Context) : RenderableView(context) {

    protected val state: AppState
        get() = MovieListApp.redukt.state

    override fun view() {

        linearLayout {
            size(MATCH, MATCH)
            padding(dip(8))
            orientation(LinearLayout.VERTICAL)
            gravity(CENTER)
            textView {
                size(WRAP, WRAP)
                text(context.getString(R.string.hello_msg))
                textSize(64f)
                gravity(CENTER_HORIZONTAL)
            }
            linearLayout {
                size(WRAP, WRAP)
                orientation(LinearLayout.HORIZONTAL)
                gravity(CENTER)
                button {
                    size(WRAP, WRAP)
                    text(context.getString(R.string.update_list))
                    textSize(56f)
                    onClick {
                        // Dunno if it's still going to be necessary to pass this movies instance to this action
                        // because middleware will intercept it and create a new list.
                        val movies = mutableListOf<Movie>()
                        ActionCreator.instance.updateMovieList(movies)
                    }
                }
                button {
                    size(WRAP, WRAP)
                    text(context.getString(R.string.list_movies))
                    textSize(56f)
                    onClick {
                        if(state.list==null) {
                            Toast.makeText(
                                context,
                                context.getString(R.string.list_not_populated),
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            val intent = Intent(context,MovieListActivity::class.java)
                            context.startActivity(intent)
                        }
                    }
                }
            }
        }
    }

}