package br.ufu.kaiosouza.delivery.entities

import br.ufu.kaiosouza.delivery.annotation.NoArg
import java.io.Serializable
import javax.persistence.*


@Entity
@NoArg
@Table(name = "products")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var name: String,
    var description: String,
    var imageUri: String,
    var price: Double
) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
