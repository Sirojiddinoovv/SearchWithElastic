package uz.nodir.searchwithelastic.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import uz.nodir.searchwithelastic.model.dto.MovieCreateRequestDTO
import uz.nodir.searchwithelastic.service.business.MovieService


/**
@author: Nodir
@date: 07.06.2025
@group: Meloman

 **/

@RestController
@RequestMapping("/api/v1/movie")
class MovieController(
    private val movieService: MovieService
) {

    @PostMapping
    fun createMovie(@RequestBody requestDTO: MovieCreateRequestDTO) =
        ResponseEntity.ok(movieService.createMovie(requestDTO))

    @GetMapping
    fun findByName(@RequestParam("name") name: String) =
        ResponseEntity.ok(movieService.findByName(name))
}