package dev.vikas.productservice.Controllers;
import dev.vikas.productservice.DTOS.RequestBodyProductDTO;
import dev.vikas.productservice.Models.Products;
import dev.vikas.productservice.Services.FakeStoreProductService;
import dev.vikas.productservice.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
public class ProductController {

    ProductService ps ;

    //Qualifier injects the object of OwnproductService through dependency injection.

    ProductController(@Qualifier("OwnService") ProductService ps) {
        this.ps = ps;
    }

    //By using Request Body we dont need to specify all the attributes separately.
    @PostMapping("/Products")
    public Products createProduct(@RequestBody RequestBodyProductDTO request){
       return ps.createProduct(request.getTitle(), request.getPrice(), request.getDescription(),
                request.getCategory(), request.getImage());
    }
    @GetMapping("/Products/{id}")
    public Products Productdetails(@PathVariable("id") int id){

        return ps.getSingleProduct(id);
    }

    @GetMapping("/Products")
    public ResponseEntity<List<Products>> getAllProducts(){
        List<Products> products = ps.getAllProducts();
       return new ResponseEntity<>(products, HttpStatus.CONFLICT);
    }

    @PutMapping()
    public void updateProduct(){

    }
}

//Dto is used for calling or reading any thirdparty's.