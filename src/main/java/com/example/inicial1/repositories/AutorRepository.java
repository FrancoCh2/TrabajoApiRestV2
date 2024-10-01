package com.example.inicial1.repositories;


import com.example.inicial1.entities.Autor;

import com.example.inicial1.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends BaseRepository<Autor,Long> {
    Page<Autor> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);
    //boolean existsByDni(int dni);
    @Query(value = "SELECT p FROM Autor p WHERE  p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro% ")
    List<Autor> search(@Param("filtro") String filtro);


    @Query(value = "SELECT p FROM Autor p WHERE  p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro% ")
    Page<Autor> search(@Param("filtro") String filtro,Pageable pageable);
    @Query(
            value = "SELECT * FROM Autor WHERE Autor.nombre LIKE %:filtro% OR Autor.apellido LIKE %:filtro%",
            nativeQuery = true

    )
    List<Autor> searchNative(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM Autor WHERE Autor.nombre LIKE %:filtro% OR Autor.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM Autor",
            nativeQuery = true

    )
    Page<Autor> searchNative(@Param("filtro") String filtro,Pageable pageable);
}
