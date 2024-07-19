package com.example.itxtechnicaltest.jpa.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="PRICES")
public class Price {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Integer brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priceList;
    private Long productId;
    private Integer priority;
    private Double price;
    private String curr;

    public Integer getBrandId() { return brandId; }

    public void setBrandId(Integer brandId) { this.brandId = brandId; }

    public LocalDateTime getStartDate() { return startDate; }

    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }

    public Long getPriceList() { return priceList; }

    public void setPriceList(Long priceList) { this.priceList = priceList; }

    public LocalDateTime getEndDate() { return endDate; }

    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }

    public Integer getPriority() { return priority; }

    public void setPriority(Integer priority) { this.priority = priority; }

    public Long getProductId() { return productId; }

    public void setProductId(Long productId) { this.productId = productId; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public String getCurr() { return curr; }

    public void setCurr(String curr) { this.curr = curr; }
}
