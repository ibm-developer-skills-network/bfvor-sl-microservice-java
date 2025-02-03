package com.hello.crud;
import com.hello.crud.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
   
    private final List<Product> products; 

    public ProductController() {
        products = new ArrayList<>();
        
        // Initialize with sample data
        Product notebook = new Product();
        notebook.setId(143);
        notebook.setName("Notebook");
        notebook.setPrice(5.49);
        
        Product marker = new Product();
        marker.setId(144);
        marker.setName("Black Marker");
        marker.setPrice(1.99);
        
        products.add(notebook);
        products.add(marker);
    }

    // All Rest Endpoint Goes Here



}


