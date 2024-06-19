package dev.vikas.productservice.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date CreatedAt;
    private Date UpdatedAt;
    private boolean isDeleted;
}

//By using MappedSuperClass we are saying it is the Base Class ,
// in which all classes are going to inherit.

//GeneratedValue is used when we create a row in product or category table it will automatically adds id value