# MOVIES LIST TMDB

## What does the app do?
    * On the first page, the user will see a welcome message with a button, which redirects to the movies list when clicked. 
    * The app lists all movies from TMDb (The Movie Database) on the second page.
    * The user can click on any of them, redirecting to the third page, giving more specific information about the chosen movie.

## What informations are present for each movie in the main page?
    Movie Title
    Movie Release Date
    Movie Poster

## What informations are present for each movie in the specific movie page?
    Movie Title
    Movie Release Date
    Movie Poster
    Movie Backdrop
    Movie Summary

## Techs to be used:
    Redukt
    Anvil
    Glide
    Retrofit
    Test Framework

# Modeling the APP

#### packages -> model, action, middleware, reducer, api

## Actions
    Update Movie List
    Load Next Page

## Middlewares
    Before Listing Movies, we'll need to intercept it (because we need to consume the API through Middleware) and generate another Action

## UI
    # First Page:
        - TextView (Welcome message)
        - Button (Updates and fills the List)
        - Button (Redirects to second page)

    # Second Page:
        - LinearLayout [horizontal]
            - ListView
            - Button (Load next page)
                
        - ListView Adapter
            - RelativeLayout
                - ImageView (movie poster)
                - TextView (movie title)
                - TextView (movie year)

    # Third Page:
        RelativeLayout
            - ImageView (movie backdrop)
            - ImageView (movie poster)
            - TextView (movie title)
            - TextView (movie year)
            - TextView (movie summary)


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