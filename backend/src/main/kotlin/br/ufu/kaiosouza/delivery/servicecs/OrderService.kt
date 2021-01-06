package br.ufu.kaiosouza.delivery.servicecs

import br.ufu.kaiosouza.delivery.dto.OrderDTO
import br.ufu.kaiosouza.delivery.entities.Order
import br.ufu.kaiosouza.delivery.entities.OrderStatus
import br.ufu.kaiosouza.delivery.repositories.OrderRepository
import br.ufu.kaiosouza.delivery.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Instant


@Service
class OrderService @Autowired constructor(private val orderRepository: OrderRepository, private val productRepository: ProductRepository) {
    @Transactional(readOnly = true)
    fun findAll(): List<OrderDTO> {
        val list = orderRepository.findOrdersWithProducts()
        return list
            .map { OrderDTO(it) }
            .toList()
    }

    @Transactional
    fun insert(orderDTO: OrderDTO): OrderDTO {
        var order = Order(null, orderDTO.address, orderDTO.latitude, orderDTO.longitude, Instant.now(), OrderStatus.PENDING)

        for (productDTO in orderDTO.getProducts()) {
            val product = productRepository.getOne(productDTO.id)
            order.products.add(product)
        }

        order = orderRepository.save(order)
        return OrderDTO(order)
    }

    @Transactional
    fun updateStatus(id: Long, status: OrderStatus?): OrderDTO {
        var order = orderRepository.getOne(id)
        order.status = status!!
        order = orderRepository.save(order)
        return OrderDTO(order)
    }
}
