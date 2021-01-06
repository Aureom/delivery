package br.ufu.kaiosouza.delivery.dto

import br.ufu.kaiosouza.delivery.entities.Order
import br.ufu.kaiosouza.delivery.entities.OrderStatus
import java.io.Serializable
import java.time.Instant
import java.util.ArrayList


class OrderDTO : Serializable {
    var id: Long
    var address: String
    var latitude: Double
    var longitude: Double
    var moment: Instant
    var status: OrderStatus
    private var products: List<ProductDTO> = ArrayList<ProductDTO>()

    constructor(id: Long, address: String, latitude: Double, longitude: Double, moment: Instant, status: OrderStatus) {
        this.id = id
        this.address = address
        this.latitude = latitude
        this.longitude = longitude
        this.moment = moment
        this.status = status
    }

    constructor(entity: Order) {
        id = entity.id!!
        address = entity.address
        latitude = entity.latitude
        longitude = entity.longitude
        moment = entity.moment
        status = entity.status
        products = entity.products
            .map { ProductDTO(it) }
            .toList()
    }

    fun getProducts(): List<ProductDTO> {
        return products
    }
}
