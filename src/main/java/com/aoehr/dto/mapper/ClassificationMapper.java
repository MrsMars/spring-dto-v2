package com.aoehr.dto.mapper;

import com.aoehr.dto.ClassificationDto;
import com.aoehr.entity.Classification;
import com.aoehr.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.aoehr.dto.converter.ClassificationConverter.classificationEntityToClassificationDto;
import static com.aoehr.dto.converter.ClassificationConverter.classificationToClassificationEntity;

@Service
public class ClassificationMapper {

    @Autowired
    private ClassificationService classificationService;

    public Classification saveClassification(ClassificationDto classificationDto) {
        return classificationService.saveClassification(classificationToClassificationEntity(classificationDto));
    }

    public List<ClassificationDto> getClassification() {
        List<Classification> classifications = classificationService.getClassification();
        return classificationEntityToClassificationDto(classifications);
    }

    public ClassificationDto getClassificationById(Long id) {
        Classification classification = classificationService.getClassificationById(id);
        return classificationEntityToClassificationDto(classification);
    }

    public void deleteClassification(Long id) {
        classificationService.deleteClassification(id);
    }

    public Classification updateClassification(ClassificationDto classificationDto) {
        return classificationService.updateClassification(classificationToClassificationEntity(classificationDto));
    }
}
