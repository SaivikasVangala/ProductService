package dev.vikas.productservice.Models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Products extends BaseModel{


    private String title;

    private String description;

    private double price;

    private String imageUrl;

    @ManyToOne(cascade = CascadeType.PERSIST) //M:1
    private Category category;


}
//This Cascade Persist will say if we create a new product if THere is no category name it will create, if category name already present it uses same category name.
//By Annotating class with entity it creates the Products table with all attributes as columns

//THe cardinality of Product and Category is M:1 so Many to One is used
//In product table category id column is created.