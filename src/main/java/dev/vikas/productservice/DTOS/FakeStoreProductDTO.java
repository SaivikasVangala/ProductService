package dev.vikas.productservice.DTOS;

import dev.vikas.productservice.Models.Category;
import dev.vikas.productservice.Models.Products;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {

  private   int id;

  private   String title;

   private String description;

   private double price;

    private String imageURL;

    private String category;

    //We are accepting a dto and converting it into a product.
    public Products toProduct() {
        Products p = new Products();
        p.setId(id);
        p.setTitle(title);
        p.setDescription(description);
        p.setPrice(price);
        p.setImageUrl(imageURL);

        Category category1 = new Category();
        category1.setTitle(category);

         p.setCategory(category1);

        return p;
    }
}
