package com.example.inicial1.entities;

import jakarta.persistence.Entity;

import lombok.*;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Localidad extends Base {

    private String denominacion;
}
