package br.ufu.kaiosouza.delivery.dto

import br.ufu.kaiosouza.delivery.entities.Product
import java.io.Serializable


class ProductDTO : Serializable {
    var id: Long
    var name: String?
    var description: String?
    var imageUri: String?
    var price: Double?

    constructor(id: Long, name: String?, description: String?, imageUri: String?, price: Double?) {
        this.id = id
        this.name = name
        this.description = description
        this.imageUri = imageUri
        this.price = price
    }

    constructor(entity: Product) {
        id = entity.id
        name = entity.name
        description = entity.description
        imageUri = entity.imageUri
        price = entity.price
    }
}
