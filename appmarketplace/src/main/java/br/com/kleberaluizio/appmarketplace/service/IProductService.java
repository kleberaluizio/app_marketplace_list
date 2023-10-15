package br.com.kleberaluizio.appmarketplace.service;

import br.com.kleberaluizio.appmarketplace.model.Product;

import java.util.List;

public interface IProductService {

    public Product createNewProduct(Product product);
    public Product updateProduct(Product product);
    public void removeProduct();
    public List<Product> listAll();
    public List<Product> searchForKeyWord(String keyword);
    public Product findById(Integer id);


}
