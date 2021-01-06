package br.ufu.kaiosouza.delivery.repositories

import br.ufu.kaiosouza.delivery.entities.Product
import org.springframework.data.jpa.repository.JpaRepository


interface ProductRepository : JpaRepository<Product, Long> {
    fun findAllByOrderByNameAsc(): List<Product>
}
