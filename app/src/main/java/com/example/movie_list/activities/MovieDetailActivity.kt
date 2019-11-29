package com.example.movie_list.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.example.movie_list.MovieListApp
import com.example.movie_list.model.AppState
import trikita.anvil.DSL.linearLayout
import trikita.anvil.RenderableView
import trikita.anvil.DSL.*

class MovieDetailActivity : AppCompatActivity() {

    protected val state: AppState
        get() = MovieListApp.redukt.state

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getView())
    }

    fun getView(): View {
        return object : RenderableView(this) {
            override fun view() {
                linearLayout {
                    size(MATCH,MATCH)
                    orientation(LinearLayout.VERTICAL)
                    padding(dip(8))
                    gravity(CENTER)
                    textView {
                        size(WRAP,WRAP)
                        text(intent.getStringExtra("movie_title"))
                        textSize(56f)
                        gravity(CENTER_HORIZONTAL)
                    }
                    textView {
                        size(WRAP,WRAP)
                        text(intent.getStringExtra("movie_date"))
                        textSize(56f)
                        gravity(CENTER_HORIZONTAL)
                    }
                    textView {
                        size(WRAP,WRAP)
                        text(intent.getStringExtra("movie_poster"))
                        textSize(56f)
                        gravity(CENTER_HORIZONTAL)
                    }
                }
            }
        }
    }
}
