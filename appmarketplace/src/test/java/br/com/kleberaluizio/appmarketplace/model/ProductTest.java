package br.com.kleberaluizio.appmarketplace.model;

import br.com.kleberaluizio.appmarketplace.service.IProductService;
import br.com.kleberaluizio.appmarketplace.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class ProductTest {

    @Autowired
    private IProductService service;
//    private static ProductServiceImpl service;
    private static Integer idFound = 1;
    private static Integer idNotFound = 100;
    private static Product newProduct;
    private static Product createdProduct;


    @BeforeAll
    public static void setup(){
        System.out.println("Configuring test's parameters");
        newProduct = new Product("cookie");

        createdProduct = new Product("cookie");
        createdProduct.setId(1);


//        service = Mockito.mock(ProductServiceImpl.class);
//        Mockito.when(service.createNewProduct(newProduct)).thenReturn(new Product("cookie"));
//        Mockito.when(service.findById(idFound)).thenReturn(createdProduct);
//        Mockito.when(service.findById(idNotFound)).thenReturn(null);
//        Mockito.when(service.searchForKeyWord("b")).thenReturn(new ArrayList<Product>());
//        Mockito.when(service.listAll()).thenReturn(new ArrayList<Product>());
//        Mockito.when(service.updateProduct(createdProduct)).thenReturn(createdProduct);

    }
    @Test
    public void shouldStoreProduct(){
        assertNotNull(service.createNewProduct(newProduct));
    }
}
