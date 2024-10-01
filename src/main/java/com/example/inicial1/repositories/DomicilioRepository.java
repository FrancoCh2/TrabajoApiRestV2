package com.example.inicial1.repositories;

import com.example.inicial1.entities.Domicilio;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio,Long> {
    Page<Domicilio> findByCalleContaining(String Calle, Pageable pageable);
    //boolean existsByDni(int dni);
    @Query(value = "SELECT p FROM Domicilio p WHERE  p.calle LIKE %:filtro% ")
    List<Domicilio> search(@Param("filtro") String filtro);


    @Query(value = "SELECT p FROM Domicilio p WHERE  p.calle LIKE %:filtro% ")
    Page<Domicilio> search(@Param("filtro") String filtro,Pageable pageable);
    @Query(
            value = "SELECT * FROM Domicilio WHERE Domicilio.calle LIKE %:filtro% ",
            nativeQuery = true

    )
    List<Domicilio> searchNative(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM Domicilio WHERE Domicilio.calle LIKE %:filtro% ",
            countQuery = "SELECT count(*) FROM Domicilio",
            nativeQuery = true

    )
    Page<Domicilio> searchNative(@Param("filtro") String filtro,Pageable pageable);
}
