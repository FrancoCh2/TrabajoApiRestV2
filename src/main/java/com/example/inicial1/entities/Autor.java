package com.example.inicial1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import lombok.*;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Builder
public class Autor extends Base {


    private String nombre;
    private String apellido;
    @Column(name="biografia",length = 1500)
    private String biografia;

}
