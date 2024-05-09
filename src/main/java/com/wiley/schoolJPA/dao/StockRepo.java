package com.wiley.schoolJPA.dao;
import com.wiley.schoolJPA.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Stock, Integer> {
}
