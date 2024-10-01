package com.example.inicial1.repositories;

import com.example.inicial1.entities.Localidad;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad,Long>{

    Page<Localidad> findByDenominacionContaining(String denominacion, Pageable pageable);
    //boolean existsByDni(int dni);
    @Query(value = "SELECT p FROM Localidad p WHERE  p.denominacion LIKE %:filtro% ")
    List<Localidad> search(@Param("filtro") String filtro);


    @Query(value = "SELECT p FROM Localidad p WHERE  p.denominacion LIKE %:filtro% ")
    Page<Localidad> search(@Param("filtro") String filtro,Pageable pageable);
    @Query(
            value = "SELECT * FROM Localidad WHERE localidad.denominacion LIKE %:filtro% ",
            nativeQuery = true

    )
    List<Localidad> searchNative(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM Localidad WHERE Localidad.denominacion LIKE %:filtro% ",
            countQuery = "SELECT count(*) FROM Localidad",
            nativeQuery = true

    )
    Page<Localidad> searchNative(@Param("filtro") String filtro,Pageable pageable);

}
