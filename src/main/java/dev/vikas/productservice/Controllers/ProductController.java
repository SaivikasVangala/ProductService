package dev.vikas.productservice.Controllers;

import dev.vikas.productservice.Models.Products;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
@RestController
public class ProductController {

    @PostMapping
    public void createProduct(){

    }
    @GetMapping("/Products/{id}")
    public Products Productdetails(@PathVariable("id") int id){
        return new Products();
    }

    @GetMapping("/Products")
    public void getAllProducts(){

    }

    @PutMapping()
    public void updateProduct(){

    }
}
