package uz.nodir.searchwithelastic.repository

import org.springframework.data.elasticsearch.annotations.Query
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import uz.nodir.searchwithelastic.model.entity.Movie
import java.util.*


/**
@author: Nodir
@date: 07.06.2025
@group: Meloman

 **/


interface MovieRepository: ElasticsearchRepository<Movie, UUID> {

    @Query("{\"match\": {\"title\": {\"query\": \"?0\"}}}")
    fun searchByTitleCustom(query: String?): List<Movie>
}