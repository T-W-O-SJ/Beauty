package ru.sj.beauty.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Embeddable
@Table(name = "images",uniqueConstraints = @UniqueConstraint( name = "image_id_idx" ,columnNames = "id"))

public class Image extends AbstractBaseEntity{

    @NotBlank
    @Column(name = "image")
    private String image;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
