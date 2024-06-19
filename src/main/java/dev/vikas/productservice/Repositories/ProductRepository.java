package dev.vikas.productservice.Repositories;

import dev.vikas.productservice.Models.Category;
import dev.vikas.productservice.Models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products,Long> {


    @Query("select p from Products p where p.title = : title")
    List<Products> findProductsByName(@Param("title") String title);

    @Query("select p.price,p.description,p.category.title from Products p where p.category =: categoryName and p.price =: Price")
    List<Products> findProductsByCategoryNameAndProductPrice(@Param("CategoryName") String categoryName,
                                                             @Param("Price") Double Price);
   //when we say native query it will be a normal sql query
    @Query(value = "select p from Products p where p.category =: categoryName and p.price >: Price",nativeQuery = true)
    List<Products> findProductsByCategoryNameAndProductPrice2(@Param("CategoryName") String categoryName,
                                                             @Param("Price") Double Price);




    Products save(Products product);

    /*
    Spring will automatically run a query on the database for the corresponding
    method call.
     */

    /*
    Create a method on mybehalf, the ORM creates queries and and run them behind the scenes.
     */

    Products findByIdIs(long id);

    List<Products> findAll();

    List<Products> findAllByTitle(String title);

    List<Products> findAllByCategory(Category category);

    List<Products> findAllByCategory_Title(String title);

    List<Products> findAllByCategory_Id(long id);

    //you dont need entire Object to filter products, we can also filter by using attributes.


}
