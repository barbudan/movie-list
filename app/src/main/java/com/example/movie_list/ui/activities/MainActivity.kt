package com.example.movie_list.ui.activities

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.movie_list.R
import com.example.movie_list.model.AppState
import com.example.movie_list.ui.components.mainComponent
import trikita.anvil.RenderableView

class MainActivity : AppLifecycleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getView(this))
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        if (newState.list != oldState.list) return true
        return false
    }

    override fun onChanged(state: AppState) {
        state.list?.let {
            runOnUiThread {
                Toast.makeText(
                    this,
                    getString(R.string.list_has_been_updated),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun getView(c: Context): View {
        return object : RenderableView(c) {
            override fun view(){
                mainComponent { }
            }
        }
    }

}
