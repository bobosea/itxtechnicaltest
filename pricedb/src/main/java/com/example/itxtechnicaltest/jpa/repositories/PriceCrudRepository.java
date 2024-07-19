package com.example.itxtechnicaltest.jpa.repositories;

import com.example.itxtechnicaltest.jpa.entities.Price;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceCrudRepository extends CrudRepository<Price, Long> {

    @Query(value = "SELECT p FROM Price p " +
            "WHERE p.productId = :productId AND p.brandId = :brandId " +
            "AND p.startDate <= :applicationDate AND p.endDate >= :applicationDate " +
            "ORDER BY p.priority DESC")
    Optional<Price> findByApplicationDateAndProductIdAndBrandIdAndTopPriority(
            @Param("applicationDate") LocalDateTime applicationDate,
            @Param("productId")Integer productId,
            @Param("brandId")Integer brandId,
            Limit l);
}
