package uz.nodir.searchwithelastic.service.dao

import uz.nodir.searchwithelastic.model.entity.Movie


/**
@author: Nodir
@date: 07.06.2025
@group: Meloman

 **/

interface MovieDAO {

    fun save(movie: Movie): Movie

    fun findByName(name: String): List<Movie>
}