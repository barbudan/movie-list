package com.example.movie_list.ui.components

import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView

abstract class MovieDetailActivityComponent : AppCompatActivity() {

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
                        text(intent.getStringExtra("movie_genre"))
                        textSize(56f)
                        gravity(CENTER_HORIZONTAL)
                    }
                }
            }
        }
    }

}