package br.ufu.kaiosouza.delivery.servicecs

import br.ufu.kaiosouza.delivery.dto.ProductDTO
import br.ufu.kaiosouza.delivery.entities.Product
import br.ufu.kaiosouza.delivery.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors


@Service
class ProductService @Autowired constructor(private val repository: ProductRepository) {

    @Transactional(readOnly = true)
    fun findAll(): List<ProductDTO> {
        val list = repository.findAllByOrderByNameAsc()
        return list.stream().map { entity: Product? -> ProductDTO(entity!!) }.collect(Collectors.toList())
    }
}
