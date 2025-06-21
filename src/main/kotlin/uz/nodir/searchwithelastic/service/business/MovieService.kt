package uz.nodir.searchwithelastic.service.business

import uz.nodir.searchwithelastic.model.dto.MovieBaseResponseDTO
import uz.nodir.searchwithelastic.model.dto.MovieCreateRequestDTO


/**
@author: Nodir
@date: 07.06.2025
@group: Meloman

 **/

interface MovieService {

    fun createMovie(requestDTO: MovieCreateRequestDTO): MovieBaseResponseDTO

    fun findByName(name: String): List<MovieBaseResponseDTO>
}