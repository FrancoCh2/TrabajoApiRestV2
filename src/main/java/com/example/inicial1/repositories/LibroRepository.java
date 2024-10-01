package com.example.inicial1.repositories;

import com.example.inicial1.entities.Libro;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends BaseRepository<Libro,Long> {
    Page<Libro> findBytituloContainingOrAutorContaining(String titulo, String autor, Pageable pageable);
    //boolean existsByDni(int dni);
    @Query(value = "SELECT p FROM Libro p WHERE  p.titulo LIKE %:filtro% OR p.autor LIKE %:filtro% ")
    List<Libro> search(@Param("filtro") String filtro);


    @Query(value = "SELECT p FROM Libro p WHERE  p.titulo LIKE %:filtro% OR p.autor LIKE %:filtro% ")
    Page<Libro> search(@Param("filtro") String filtro,Pageable pageable);
    @Query(
            value = "SELECT * FROM lIBRO WHERE Libro.titulo LIKE %:filtro% OR Libro.Autor LIKE %:filtro%",
            nativeQuery = true

    )
    List<Libro> searchNative(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM Persona WHERE Persona.nombre LIKE %:filtro% OR Persona.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM Libro",
            nativeQuery = true

    )
    Page<Libro> searchNative(@Param("filtro") String filtro,Pageable pageable);
}
