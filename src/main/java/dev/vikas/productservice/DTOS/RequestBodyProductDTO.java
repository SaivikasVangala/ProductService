package dev.vikas.productservice.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestBodyProductDTO {

    private String title;

    private double price;

    private String description;

    private String category;

    private String image;


    /*
    Dto for each request, so in future  if the request needs additional params
    we can add easily.

     */
}
