package br.com.kleberaluizio.appmarketplace.repository;

import br.com.kleberaluizio.appmarketplace.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductoRepository extends CrudRepository<Product, Integer> {
}
