package com.example.movie_list.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.example.movie_list.ui.components.MovieDetailActivityComponent
import trikita.anvil.DSL.linearLayout
import trikita.anvil.RenderableView
import trikita.anvil.DSL.*

class MovieDetailActivity : MovieDetailActivityComponent() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getView())
    }

}
