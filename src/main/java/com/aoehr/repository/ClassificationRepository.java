package com.aoehr.repository;

import com.aoehr.entity.Classification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificationRepository extends JpaRepository<Classification, Long> {
    Classification findClassificationById(Long id);
}
