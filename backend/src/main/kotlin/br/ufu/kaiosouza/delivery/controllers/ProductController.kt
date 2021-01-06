package br.ufu.kaiosouza.delivery.controllers

import br.ufu.kaiosouza.delivery.dto.ProductDTO
import br.ufu.kaiosouza.delivery.servicecs.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(value = ["/products"])
class ProductController @Autowired constructor(private val service: ProductService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<ProductDTO>> {
        val list = service.findAll()
        return ResponseEntity.ok().body(list)
    }
}
