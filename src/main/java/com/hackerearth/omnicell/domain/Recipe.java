package com.hackerearth.omnicell.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Access(AccessType.FIELD)
@JsonIgnoreProperties
@Table(name="recipe",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
        })
public class Recipe {

    private static final long serialVersionUID = 5817953797350011611L;

    @Id
    @Column(name= "id", updatable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer Id;

    @Column(name="name")
    @Size(max = 50)
    @NotNull
    private String name;

    @Column(name="image")
    private String image;

    @Column(name="category")
    private String category;

    @Column(name="label")
    private String label;

    @Column(name="price")
    private Double price;

    @Column(name="description")
    private String description;
}
