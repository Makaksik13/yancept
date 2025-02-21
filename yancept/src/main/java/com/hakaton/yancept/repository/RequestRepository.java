package com.hakaton.yancept.repository;

import com.hakaton.yancept.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
//    @Query(nativeQuery = true, value = "SELECT t.link FROM Request t WHERE t.id = :id")
//    Optional<String> findLinkById(@Param("id") Long id);
}
