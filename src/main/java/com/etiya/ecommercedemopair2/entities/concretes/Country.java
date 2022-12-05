package com.etiya.ecommercedemopair2.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "country_name")
    private String country_name;

    //FK
    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonIgnoreProperties("country")
    private City city;

    @OneToMany(mappedBy = "id")
    @JsonIgnoreProperties("id")
    private List<Address> addresses;

}
