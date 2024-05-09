package com.wiley.schoolJPA.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stockid", nullable = false)
    private Integer id;

    @Column(name = "logo", nullable = false)
    private String logo;

    @Column(name = "currentprice")
    private BigDecimal currentPrice;

    @ManyToMany
    @JoinTable(
            name = "person_stock",
            joinColumns = {@JoinColumn(name = "stock_id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id")}
    )
    private Set<Person> stockBuyers;

    public Stock() {}

    public Stock(Set<Person> stockBuyers) {
        this.stockBuyers =stockBuyers;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Set<Person> getStockBuyers() {
        return stockBuyers;
    }

    public void setStockBuyers(Set<Person> stockBuyers) {
        this.stockBuyers = stockBuyers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;
        Stock stock = (Stock) o;
        return Objects.equals(getId(), stock.getId()) &&
                Objects.equals(getLogo(), stock.getLogo()) &&
                Objects.equals(getCurrentPrice(), stock.getCurrentPrice()) &&
                Objects.equals(getStockBuyers(), stock.getStockBuyers());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getLogo(), getCurrentPrice(), getStockBuyers());
    }
}