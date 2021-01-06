package br.ufu.kaiosouza.delivery.entities

import br.ufu.kaiosouza.delivery.annotation.NoArg
import java.io.Serializable
import java.time.Instant
import javax.persistence.*
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.GenerationType
import javax.persistence.GeneratedValue

@Entity
@NoArg
@Table(name = "orders")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var address: String,
    var latitude: Double,
    var longitude: Double,
    var moment: Instant,
    var status: OrderStatus,

    @ManyToMany
    @JoinTable(name = "orders_products", joinColumns = [JoinColumn(name = "orders_id")], inverseJoinColumns = [JoinColumn(name = "products_id")])
    val products: MutableSet<Product> = HashSet()
): Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Order

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}
