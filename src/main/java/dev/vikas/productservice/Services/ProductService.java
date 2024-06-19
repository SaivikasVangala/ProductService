package dev.vikas.productservice.Services;

import dev.vikas.productservice.Models.Category;
import dev.vikas.productservice.Models.Products;

import java.util.List;

public interface ProductService {

     Products getSingleProduct(long ProductId);

     List<Products> getAllProducts();

      Products createProduct(String title, double price, String description, String category,String imageURL);
}
