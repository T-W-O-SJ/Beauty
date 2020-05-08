package ru.sj.beauty.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
@Entity
@NamedQueries(
        {
                @NamedQuery(name = Product.DELETE ,query ="delete from Product u where u.id =:id" ),
                @NamedQuery(name = Product.GetSorted, query = "select from  User u Left Join Fetch u.roles where u.name,u.email")
        }
)
@Table(name = "entities",uniqueConstraints = @UniqueConstraint(name = "entities_unique_user_id_idx",columnNames ="id"))
public class Product extends  AbstractBaseEntity{
    public static final String DELETE ="Product.delete";
    public static final String GetSorted = "Product.getSorted";
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
