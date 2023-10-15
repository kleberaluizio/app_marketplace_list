package br.com.kleberaluizio.appmarketplace.service;

import br.com.kleberaluizio.appmarketplace.model.Product;
import br.com.kleberaluizio.appmarketplace.repository.IProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class ProductServiceImplTests {

    @InjectMocks
    private ProductServiceImpl service;
    @Mock
    private IProductRepository repository;
    private Integer existingId = 1;
    private Integer nonExistingId = 100;
    private String keyword = "cookie";
    private Product newProduct;
    private Product createdProduct;
    private ArrayList<Product> listOfProducts;

    @BeforeEach
    public void setup() throws Exception{
        newProduct = new Product("cookie");
        createdProduct = new Product("cookie");
        createdProduct.setId(1);

        listOfProducts = new ArrayList<>();
        Product p1, p2;
        p1 = new Product("Special cookie");
        p1.setId(2);
        p2 = new Product("Salt water cookie");
        p2.setId(3);
        listOfProducts.add(p1);
        listOfProducts.add(p2);


        Mockito.when(repository.save(newProduct)).thenReturn(createdProduct);
        Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(new Product("cookie")));
        Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.ofNullable(null));
        Mockito.when(repository.findAllByNameContaining("Biscoito")).thenReturn(new ArrayList<Product>());
        Mockito.when(repository.findAllByNameContaining(keyword)).thenReturn(listOfProducts);


    }

    @Test
    public void shouldRegisterProduct(){
        assertEquals(service.createNewProduct(newProduct), createdProduct);
    }

    @Test
    public void shouldReturnById(){
        assertNotNull(service.findById(existingId));
    }

    @Test
    public void shouldNotFoundId(){
        assertNull(service.findById(nonExistingId));
    }

    @Test
    public void shouldReturnListByKeyword(){
        assertTrue(service.searchForKeyWord(keyword).size() > 0);
    }

    @Test
    public void shouldReturnEmptyList(){
        assertTrue(service.searchForKeyWord("Biscoito").isEmpty());
    }
}
