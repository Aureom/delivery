package br.ufu.kaiosouza.delivery.controllers

import br.ufu.kaiosouza.delivery.dto.OrderDTO
import br.ufu.kaiosouza.delivery.entities.OrderStatus
import br.ufu.kaiosouza.delivery.servicecs.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder


@RestController
@RequestMapping(value = ["/orders"])
class OrderController @Autowired constructor(private val service: OrderService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<OrderDTO>> {
        val list = service.findAll()
        return ResponseEntity.ok().body(list)
    }

    @PostMapping
    fun insert(@RequestBody orderDTO: OrderDTO): ResponseEntity<OrderDTO> {
        var orderDTO = orderDTO
        orderDTO = service.insert(orderDTO)
        val uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(orderDTO.id).toUri()
        return ResponseEntity.created(uri).body(orderDTO)
    }

    @PutMapping("/{id}/{status}")
    fun insert(
        @RequestBody orderDTO: OrderDTO?,
        @PathVariable(value = "id") id: Long?,
        @PathVariable(value = "status") status: OrderStatus?
    ): ResponseEntity<OrderDTO> {
        var orderDTO = orderDTO
        orderDTO = service.updateStatus(id!!, status)
        return ResponseEntity.ok().body(orderDTO)
    }
}
