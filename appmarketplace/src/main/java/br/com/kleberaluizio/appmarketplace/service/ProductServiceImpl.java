package br.com.kleberaluizio.appmarketplace.service;

import br.com.kleberaluizio.appmarketplace.model.Product;
import br.com.kleberaluizio.appmarketplace.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // Vai permitir injetar a implementação em qualquer chamada
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductoRepository repository;

    @Override
    public Product createNewProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public void removeProduct() {

    }

    @Override
    public List<Product> listAll() {
        return null;
    }

    @Override
    public List<Product> searchForKeyWord(String keyword) {
        return null;
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }
}
