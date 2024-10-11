package org.zerock.api2.product.domain;


import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "tags")
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    private String pname;

    private int price;

    private ProductStatus status;

    @ElementCollection
    @CollectionTable(name="tbl_product_tag")
    @Builder.Default
    private Set<String> tags = new HashSet<>();


    @ElementCollection
    @CollectionTable(name="tbl_product_img")
    private Set<String> images = new HashSet<>();

    public void changeImage(Set<ContentImage> imgs){
        this.images = images;
    }

    public void addTag(String tag){
        tags.add(tag);
    }

    public void removeTag(String tag){
        tags.remove(tag);
    }
    public void clearTag()
    {
        tags.clear();
    }

}
