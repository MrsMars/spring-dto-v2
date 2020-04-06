package com.aoehr.service.impl;

import com.aoehr.entity.Classification;
import com.aoehr.repository.ClassificationRepository;
import com.aoehr.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    @Autowired
    private ClassificationRepository classificationRepository;

    @Override
    public Classification saveClassification(Classification classification) {
        return classificationRepository.save(classification);
    }

    @Override
    public List<Classification> getClassification() {
        return classificationRepository.findAll();
    }

    @Override
    public Classification getClassificationById(Long id) {
        return classificationRepository.findClassificationById(id);
    }

    @Override
    public void deleteClassification(Long id) {
        classificationRepository.deleteById(id);
    }

    @Override
    public Classification updateClassification(Classification classification) {
        return classificationRepository.findClassificationById(classification.getId()) != null ?
                classificationRepository.save(classification) : null;
    }
}
