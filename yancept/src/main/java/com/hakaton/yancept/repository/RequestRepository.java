package com.hakaton.yancept.repository;

import com.hakaton.yancept.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query(value = "SELECT r.description FROM Request r WHERE r.id = :id")
    Optional<String> getDescriptionById(@Param("id") Long id);

    @Query(value = "SELECT r.createdAt FROM Request r WHERE r.id = :id")
    Optional<LocalDateTime> getCreatedAtById(@Param("id") Long id);

    @Query(value = "SELECT r.rejectionReason FROM Request r WHERE r.id = :id")
    Optional<String> getRejectionReasonById(@Param("id") Long id);

    List<Request> getAllByStudentId(long requesterId);

    List<Request> getAllByTeacherId(long receiverId);

    @Query("SELECT r.student FROM Request r WHERE r.teacher = :teacherId AND r.status = 0")
    List<Long> getIdsInProcessStudentByTeacherId(long teacherId);
}
