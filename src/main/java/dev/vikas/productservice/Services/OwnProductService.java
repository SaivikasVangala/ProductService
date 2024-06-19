package dev.vikas.productservice.Services;

import dev.vikas.productservice.Models.Category;
import dev.vikas.productservice.Models.Products;
import dev.vikas.productservice.Repositories.CategoryRepository;
import dev.vikas.productservice.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("OwnService")
public class OwnProductService implements ProductService{


    CategoryRepository categoryRepository;
    ProductRepository productRepository;

    OwnProductService(CategoryRepository categoryRepository, ProductRepository productRepository) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Products getSingleProduct(long ProductId) {
        return productRepository.findByIdIs(ProductId);
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Products> getProductsByCategory(String category_name) {
        List<Products> pro = productRepository.findProductsByCategoryNameAndProductPrice("Electronics",85000.0);
        return productRepository.findAllByCategory_Title(category_name);
    }

    @Override
    public Products createProduct(String title,double price, String description,  String category, String imageURL) {

        Products P = new Products();
        P.setTitle(title);
        P.setPrice(price);
        P.setDescription(description);
        P.setImageUrl(imageURL);

        Category categoryFromDataBase = categoryRepository.findByTitle(category);
        //we are checking categoryRepository. there exist a name by category.

        if(categoryFromDataBase == null) {
            Category category1 = new Category();
            category1.setTitle(category);
            categoryFromDataBase = category1;
        }
      P.setCategory(categoryFromDataBase);

       Products savedProduct = productRepository.save(P);

        return savedProduct;
    }
}
