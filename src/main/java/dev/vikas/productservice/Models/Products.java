package dev.vikas.productservice.Models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    private int id;

    private String name;

    private String description;

    private double price;

    private String imageUrl;
}
