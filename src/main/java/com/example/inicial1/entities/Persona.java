package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Persona extends Base {

    private String nombre;

    private String apellido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;


    @OneToMany(cascade =CascadeType.ALL,orphanRemoval = true)
    @JoinTable(
            name = "persona_Libro",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    @Builder.Default
    private List<Libro> libros = new ArrayList<>();
}

