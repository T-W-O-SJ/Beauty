package ru.sj.beauty.model;

import javax.persistence.*;
import javax.persistence.criteria.From;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NamedQueries(
        @NamedQuery(name = Product.DELETE, "DELETE FROM Product p WHERE m.id=:id "),
        @NamedQuery(name = Product.GetSorted,"SELECT FROM Product p id")

)

@Table(name = "products",uniqueConstraints = @UniqueConstraint(name = "entities_unique_user_id_idx",columnNames ="id"))
public class Product extends  AbstractBaseEntity{
    public static final String DELETE ="Product.delete";
    public static final String GetSorted = "Product.getSorted";
    public static final String GetImage = "Product.getProductImage";
    @NotBlank
    @Column(name = "description", nullable = false)
private String description;
    @NotNull
    @Column (name = "time",nullable = false)
private  Integer time;
    @NotNull
    @Size(min = 1 , max = 255)
    @Column(name = "price",nullable = false)
private Integer price;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @OneToMany(fetch = FetchType.EAGER,
    mappedBy = "product",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Image> images;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Product(){
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Product(Integer id, String description, Integer time, Integer price) {
        this.id = id;
        this.description = description;
        this.time = time;
        this.price = price;
    }

    {

    }

}
