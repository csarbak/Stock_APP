package com.wiley.schoolJPA.controller;

import com.wiley.schoolJPA.dao.StockRepo;
import com.wiley.schoolJPA.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class StockController {

    private final Logger log = LoggerFactory.getLogger(StockController.class);
    @Autowired
    private StockRepo stockRepo;

    @GetMapping("/stocks")
    public Collection<Stock> allStocks() {
        return stockRepo.findAll();
        //return ResponseEntity.status(HttpStatus.OK).body(stocks);
    }

    @GetMapping("/stock/{id}")
    public ResponseEntity<?> getStock(@PathVariable("id") Integer id) {
        Optional<Stock> group = stockRepo.findById(id);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//        Stock stock = stockRepo.findById(id).orElse(null);
//        if (stock == null) {
//            return new ResponseEntity<Stock>(stock, HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<Stock>(stock, HttpStatus.OK);
//        }
    }

    @PostMapping("/stock")
    public ResponseEntity<Stock> createStock( @RequestBody Stock stock) throws URISyntaxException {
        log.info("Request to create stock: {}", stock);
        Stock result = stockRepo.save(stock);
        return ResponseEntity.created(new URI("/stock/" + result.getId()))
                .body(result);
//        if(stock.getId()!=null){
//            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//        }
//        stockRepo.save(stock);
//        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/stock/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable("id") Integer id) {
        log.info("Request to delete stock: {}", id);
        stockRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/stock/{id}")
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock) {
        log.info("Request to update stock: {}", stock);
        Stock result = stockRepo.save(stock);
        return ResponseEntity.ok().body(result);
    }
}
