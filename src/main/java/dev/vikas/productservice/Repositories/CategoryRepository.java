package dev.vikas.productservice.Repositories;

import dev.vikas.productservice.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByTitle(String title);
    //Spring will create a query for select title from category where title equal to this title.
    //And get you a category if that exists in database.

    Category save(Category category);
    //If we want to save a category in the database.

    Category findById(long id);
}
