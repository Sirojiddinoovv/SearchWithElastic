package uz.nodir.searchwithelastic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SearchWithElasticApplication

fun main(args: Array<String>) {
    runApplication<SearchWithElasticApplication>(*args)
}
