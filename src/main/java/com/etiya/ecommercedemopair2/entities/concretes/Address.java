package com.etiya.ecommercedemopair2.entities.concretes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    //FK
    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonIgnoreProperties("address")
    private Country country;

    @OneToMany(mappedBy = "id")
    @JsonIgnoreProperties("id")
    private List<User> users;


}
