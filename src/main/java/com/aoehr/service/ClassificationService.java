package com.aoehr.service;

import com.aoehr.entity.Classification;

import java.util.List;

public interface ClassificationService {

    Classification saveClassification(Classification classification);

    List<Classification> getClassification();
    Classification getClassificationById(Long id);

    void deleteClassification(Long id);
    Classification updateClassification(Classification classification);
}
