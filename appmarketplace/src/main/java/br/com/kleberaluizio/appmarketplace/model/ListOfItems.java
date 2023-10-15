package br.com.kleberaluizio.appmarketplace.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_list")
public class ListOfItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_list")
    private Integer id;
    @Column(name = "creation_date", nullable = false)
    private Date dateOfCreation;
    @Column(name = "marketplace_name", length = 50)
    private String marketplaceName;
    @Column(name = "total_value")
    private Double totalValue;
    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "listOfItems", cascade = CascadeType.ALL)
    private List<ItemList> items;

    public ListOfItems(){}

    public ListOfItems(Date dateOfCreation, String marketplaceName, Double totalValue, Integer status) {
        this.dateOfCreation = dateOfCreation;
        this.marketplaceName = marketplaceName;
        this.totalValue = totalValue;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getMarketplaceName() {
        return marketplaceName;
    }

    public void setMarketplaceName(String marketplaceName) {
        this.marketplaceName = marketplaceName;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public java.util.List<ItemList> getItems() {
        return items;
    }

    public void setItems(java.util.List<ItemList> items) {
        this.items = items;
    }
}