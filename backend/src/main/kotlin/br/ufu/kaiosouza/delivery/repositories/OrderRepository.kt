package br.ufu.kaiosouza.delivery.repositories

import br.ufu.kaiosouza.delivery.entities.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query


interface OrderRepository : JpaRepository<Order, Long> {
    @Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products WHERE obj.status = 0 ORDER BY obj.moment ASC")
    fun findOrdersWithProducts(): List<Order>
}
