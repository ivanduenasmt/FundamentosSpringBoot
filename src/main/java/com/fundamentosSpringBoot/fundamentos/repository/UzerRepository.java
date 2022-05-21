package com.fundamentosSpringBoot.fundamentos.repository;

import com.fundamentosSpringBoot.fundamentos.dto.UzerDto;
import com.fundamentosSpringBoot.fundamentos.entity.Uzer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UzerRepository extends JpaRepository<Uzer, Long> {
    @Query("Select u from Uzer u where u.email=?1")
    Optional<Uzer> findByUzerEmail(String email);

    @Query("Select u from Uzer u where u.name like ?1%")
    List<Uzer> findAndSort(String name, Sort sort);

    List<Uzer> findByName(String name);

    Optional<Uzer> findByEmailAndName(String email, String name);

    List<Uzer> findByNameLike(String name);

    /*@Query("SELECT new package com.fundamentosSpringBoot.fundamentos.dto.UzerDto(u.id, u.name, u.birthDate)" +
    "FROM Uzer u " +
    "WHERE u.birthDate=:parametroFecha"+
    "AND u.email=:parametroEmail"
    )
    Optional<UzerDto> getAllByBirthDateAndEmail(@Param("parametroFecha") LocalDate date, @Param("parametroEmail") String email);*/
}
