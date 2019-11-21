# MOVIES LIST TMDB

## What does the app do?
    * On the first page, the user will see a welcome message with a button, which redirects to the movies list when clicked. 
    * The app lists all movies from TMDb (The Movie Database) on the second page.
    * The user can click on any of them, redirecting to the third page, giving more specific information about the chosen movie.

## What informations are present for each movie in the main page?
    Movie Title
    Movie Genre
    Movie Release Date
    Movie Poster/Pic

## What informations are present for each movie in the specific movie page?
    Movie Title
    Movie Genre
    Movie Release Date
    Larger Movie Poster/Pic
    Movie Summary
    Movie Cast (perhaps)

## Techs to be used:
    Redukt
    Anvil
    Glide
    Retrofit
    Test Framework

# Modeling the APP

#### packages -> model, action, middleware, reducer, api

## Actions
    List Movies
    Show Movie

## Middlewares
    Before Listing Movies, we'll need to intercept it (because we need to consume the API through Middleware) and generate another Action
    Before Showing a specific movie, we'll need to intercept it (because we need to consume the API through Middleware) and generate another Action

## UI
    # First Page:
        - TextView (Welcome message)
        - Button (Redirects to second page)

    # Second Page:
        - LinearLayout [horizontal]
            - ListView (Rodrigo told me that RecyclerView isn't very good to use on Anvil yet)
                
        - ListView Adapter
            - RelativeLayout
                - ImageView (movie poster)
                - TextView (movie title)
                - TextView (movie year)
                - TextView (movie genre)

    # Third Page:
        RelativeLayout
            - ImageView (movie poster [larger size])
            - TextView (movie title)
            - TextView (movie year)
            - TextView (movie genre)
            - TextView (movie summary)
            - TextView (movie cast)


# TRELLO CARDS

## Create Project, Add everything and Organize packages
    Init Project
    Add Anvil
    Add Redukt
    Add Retrofit
    Add Glide
    Add Test Framework
    Create Packages

## Create UI
    First Page
    Second Page
    Third Page

## Create Models
    Movie

## Create Actions
    List Movies
    Show Movie

## Create Middlewares
    Intercept List Movies
    Intercept Show Movie

## Create Reducers
    Reduce AppState to list the movies
    Reduce AppState to show specific movie

## Create Class for API
    Retrofit/TMDB