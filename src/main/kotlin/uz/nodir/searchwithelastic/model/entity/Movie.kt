package uz.nodir.searchwithelastic.model.entity

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import uz.nodir.searchwithelastic.model.dto.MovieBaseResponseDTO
import uz.nodir.searchwithelastic.model.dto.MovieCreateRequestDTO
import java.util.UUID


/**
@author: Nodir
@date: 07.06.2025
@group: Meloman

 **/

@Document(indexName = "movies")
data class Movie(
    @Id
    val id: UUID? = null,
    val title: String? = null,
    val description: String? = null,
) {
    companion object {
        fun from(requestDTO: MovieCreateRequestDTO) =
            Movie(
                UUID.randomUUID(),
                requestDTO.title,
                requestDTO.description,
            )
    }
}