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
public class Libro extends Base {

    private String titulo;
    private int fecha;
    private String genero;

    private int paginas;
    private String autor;
    @ManyToMany(cascade = CascadeType.REFRESH)


    private List<Autor> autores;

}