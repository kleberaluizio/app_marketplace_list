package br.com.kleberaluizio.appmarketplace.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_itemlist")
public class ItemList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_itemlist")
    private Integer id;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "finished")
    private Integer finished;

    @ManyToOne
    @JoinColumn(name = "tbl_product_id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "tbl_list_id_list")
    private ListOfItems listOfItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ListOfItems getList() {
        return listOfItems;
    }

    public void setList(ListOfItems listOfItems) {
        this.listOfItems = listOfItems;
    }
}
