package br.com.kleberaluizio.appmarketplace.service;

import br.com.kleberaluizio.appmarketplace.model.Product;
import br.com.kleberaluizio.appmarketplace.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // Vai permitir injetar a implementação em qualquer chamada
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductRepository repository;

    @Override
    public Product createNewProduct(Product product) {
        if(product.getName() == null || product.getName().length() == 0){
            return null;
        }
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public void removeProduct() {
    }

    @Override
    public List<Product> listAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public List<Product> searchForKeyWord(String keyword) {
        return repository.findAllByNameContaining(keyword);
    }

    @Override
    public Product findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
