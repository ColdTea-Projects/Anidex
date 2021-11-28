package de.coldtea.anidex.domain.model

enum class Genre(val genreId: Int, val genreName: String) {
    ACTION(1, "Action"),
    ADVENTURE(2, "Adventure"),
    COMEDY(4, "Comedy"),
    DRAMA(8, "Drama"),
    FANTASY(10, "Fantasy"),
    SHOUNEN(27, "Shounen"),
    SUPER_POWER(31, "Super Power"),
    MILITARY(38, "Military")
}