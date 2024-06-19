package dev.vikas.productservice.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseModel {

  private   String title;

  // Cardinality between Category and Product
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
  @JsonIgnore
  private List<Products> productsList;
}
//Mapped by specifies that in the Products it already has Cardinality
// now you dont need to specify other cardinality which prevents in creating other Mapping table..

//JsonIgnore will stop the infinite loop of printing category again and again.