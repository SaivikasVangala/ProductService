package dev.vikas.productservice.Services;

import dev.vikas.productservice.DTOS.FakeStoreProductDTO;
import dev.vikas.productservice.Models.Category;
import dev.vikas.productservice.Models.Products;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service("fake store")
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    /*Spring gives the RestTemplate to the class and it needs to accept it,
    From configuration where the Method has Bean it creates instance and give it to the spring.
    Then spring handles everything.
     */

    public FakeStoreProductService(RestTemplate restTemplate){

        this.restTemplate = restTemplate;
    }
    //Whatever Json response it is giving covert it into dto
        /*
        FakeStoreProducrDtO.class is We are Explicitly telling restTemplate that when we
        call getForObject and making request to url we are telling it  cast to object of
         FakeStoreProductdto.class
         */
    @Override
    public Products getSingleProduct(long ProductId) {

      ResponseEntity<FakeStoreProductDTO> fakestoreresponse  = restTemplate.getForEntity
                ("https://fakestoreapi.com/products/" +ProductId, FakeStoreProductDTO.class);
  // Here we are getting response entity of FakeStoreProductDTO
        if(ProductId == 0){
            throw new IllegalArgumentException("Ivalid ProductId, Try some other ProductId");
        }
        return fakestoreresponse.getBody().toProduct();
       //getBody() gives the FakeStoreProductDTO object.
    }

    /*
    We have called restTemplate with url,we had received list of fake store product dtos
    Then we looped each entry and converted it in to product. We created list and
    added each value into list then we returned the list.
     */

    @Override
    public List<Products> getAllProducts() {

       FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject
               ("https://fakestoreapi.com/products",FakeStoreProductDTO[].class);
       List <Products> productsList = new ArrayList<>();
       for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS){
           productsList.add(fakeStoreProductDTO.toProduct());
       }
        return productsList;
    }

    @Override
    public Products createProduct(String title,  double price, String description,
                                  String category, String imageURL) {

        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();

        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setCategory(category);
        fakeStoreProductDTO.setImageURL(imageURL);

       FakeStoreProductDTO fakeStoreProductDTO1 =  restTemplate.postForObject
               ("https://fakestoreapi.com/products",fakeStoreProductDTO,
                FakeStoreProductDTO.class);


        return fakeStoreProductDTO1.toProduct();
    }
}
