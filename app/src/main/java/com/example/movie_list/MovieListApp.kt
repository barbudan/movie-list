package com.example.movie_list

import android.app.Application
import android.content.Context
import com.example.movie_list.middlewares.UpdateListMiddleware
import com.example.movie_list.model.AppState
import com.example.movie_list.reducers.AppStateReducer
import com.github.raulccabreu.redukt.Redukt

class MovieListApp : Application() {

    companion object {
        lateinit var redukt: Redukt<AppState>

        fun initializeRedukt(context: Context, appState: AppState): Redukt<AppState> {
            val redukt = Redukt(appState)

            addReducers(redukt)
            addMiddlewares(context, redukt)

            return redukt
        }

        private fun addReducers(redukt: Redukt<AppState>) {
            redukt.reducers["appStateReducer"] = AppStateReducer()
        }

        private fun addMiddlewares(context: Context, redukt: Redukt<AppState>) {
            redukt.middlewares["updateListMiddleware"] = UpdateListMiddleware()
        }
    }

    override fun onCreate() {
        super.onCreate()

        initializeRedukt(applicationContext,
            AppState()).let {
            redukt = it
        }
    }

    override fun onTerminate() {
        redukt.stop()
        super.onTerminate()
    }

}