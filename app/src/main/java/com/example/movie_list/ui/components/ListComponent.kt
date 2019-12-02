package com.example.movie_list.ui.components

import android.content.Context
import android.view.View

import trikita.anvil.RenderableView

class ListComponent<T: Any> {

    fun showItemList(c: Context, v: () -> Unit): View {
        return object : RenderableView(c) {
            override fun view() {
                v()
            }
        }
    }

    fun showItem(item: T, view: (T) -> Unit) {
        view(item)
    }

}