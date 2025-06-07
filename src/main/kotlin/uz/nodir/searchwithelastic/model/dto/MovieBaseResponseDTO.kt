package uz.nodir.searchwithelastic.model.dto

import uz.nodir.searchwithelastic.model.entity.Movie
import java.util.*


/**
@author: Nodir
@date: 07.06.2025
@group: Meloman

 **/
data class MovieBaseResponseDTO(
    val id: UUID? = null,
    val title: String? = null,
    val description: String? = null,
) {

    companion object {
        fun from(movie: Movie) =
            MovieBaseResponseDTO(
                id = movie.id,
                title = movie.title,
                description = movie.description,
            )
    }
}
