package uz.nodir.searchwithelastic.service.business.impl

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import uz.nodir.searchwithelastic.model.dto.MovieBaseResponseDTO
import uz.nodir.searchwithelastic.model.dto.MovieCreateRequestDTO
import uz.nodir.searchwithelastic.model.entity.Movie
import uz.nodir.searchwithelastic.service.business.MovieService
import uz.nodir.searchwithelastic.service.dao.MovieDAO


/**
@author: Nodir
@date: 07.06.2025
@group: Meloman

 **/

@Service
class MovieServiceImpl(
    private val dao: MovieDAO
) : MovieService {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    override fun createMovie(requestDTO: MovieCreateRequestDTO): MovieBaseResponseDTO {
        log.info("Received command to create movie with request dto: $requestDTO")

        val preparedMovie = Movie.from(requestDTO)
        val movie = dao.save(preparedMovie)

        val response = MovieBaseResponseDTO.from(movie)
        log.info("Finished command to create movie with response dto: $response")
        return response
    }

    override fun findByName(name: String): List<MovieBaseResponseDTO> {
        log.info("Received command to find movie by name: $name")

        val response = dao.findByName(name)
            .map(MovieBaseResponseDTO::from)

        log.info("Finished command to find movie by name with response dto: $response")
        return response
    }


}