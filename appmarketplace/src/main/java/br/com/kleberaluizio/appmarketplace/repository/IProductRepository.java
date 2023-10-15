package br.com.kleberaluizio.appmarketplace.repository;

import br.com.kleberaluizio.appmarketplace.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductRepository extends CrudRepository<Product, Integer> {

    public List<Product> findAllByNameContaining(String keyword);

}
