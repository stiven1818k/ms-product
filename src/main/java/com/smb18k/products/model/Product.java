package com.smb18k.products.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "Product")
@ToString @EqualsAndHashCode
public class Product implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  @Setter @Getter
    private Long id;

    @Setter @Getter
    private String name;

    @Setter @Getter
    private String description;

    @Setter @Getter
    private Double high;

    @Setter @Getter
    private Double width;

    @Setter @Getter
    private Double weight;

    @Setter @Getter @Column(name="releasedate") @Temporal(TemporalType.DATE) @JsonFormat(pattern = "dd/MM/yyyy")
    private Date releaseDate;






}
