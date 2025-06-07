package uz.nodir.searchwithelastic.service.dao.impl

import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders
import org.slf4j.LoggerFactory
import org.springframework.data.elasticsearch.core.SearchHit
import org.springframework.stereotype.Service
import uz.nodir.searchwithelastic.model.entity.Movie
import uz.nodir.searchwithelastic.repository.MovieRepository
import uz.nodir.searchwithelastic.service.dao.MovieDAO


/**
@author: Nodir
@date: 07.06.2025
@group: Meloman

 **/

@Service
class MovieDAOImpl(
    private val repository: MovieRepository
) : MovieDAO {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    override fun save(movie: Movie): Movie {
        log.info("Saving Movie: {}", movie)
        val entity = repository.save(movie)

        log.info("Saved Movie with id: {}", entity.id)
        return entity
    }

    override fun findByName(name: String): List<Movie> {
        log.info("Finding Movie by name: {}", name)
        val result = repository.searchByTitleCustom(name)

        log.info("Found Movies with {} size", result.size)
        return result
    }

}