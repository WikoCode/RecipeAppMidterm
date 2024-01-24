# Recipe App

## Description

Recipe App is an Android application designed to help users discover and prepare various recipes. It offers a user-friendly interface, access to a vast collection of recipes, and functionalities like searching, favoriting, and categorizing recipes.

## Features
- **User Authentication**: Allows users to sign up, log in, and manage their accounts using Firebase Authentication.
- **Recipe Search**: Users can search for recipes based on ingredients, cuisine types, and other filters using a custom-built search functionality.
- **Favorites**: Users can bookmark their favorite recipes for easy access, utilizing local database storage.
- **Recipe Details**: Provides detailed preparation instructions, ingredient lists, and nutritional information for each recipe.
- **Offline Access**: Local caching of recipes for offline viewing.

## Tech Stack
- **Kotlin**: Primary programming language for app development.
- **Android Studio**: Integrated development environment for app building.
- **Firebase**: Backend service for authentication, data storage, and social integration.
- **Retrofit**: For making API calls to a recipe database service.
- **Dagger-Hilt**: Dependency injection framework for managing object lifecycles and dependencies.
- **Coroutines & Flow**: For managing background tasks, asynchronous operations, and data streams.
- **DataStore**: For storing key-value pairs for user settings and preferences.
- **MVVM Architecture**: Utilizing Model-View-ViewModel pattern for scalable and maintainable code.
- **Navigation Component**: For in-app navigation and handling fragment transactions.
- **MutableState/SharedFlow**: For observing and responding to data changes in the app.
- **View Binding**: For more efficient interaction with Views.


