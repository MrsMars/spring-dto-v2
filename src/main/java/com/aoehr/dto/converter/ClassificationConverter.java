package com.aoehr.dto.converter;

import com.aoehr.dto.ClassificationDto;
import com.aoehr.entity.Classification;

import java.util.List;
import java.util.stream.Collectors;

public class ClassificationConverter {

    public static List<ClassificationDto> classificationEntityToClassificationDto(List<Classification> classifications) {
        return classifications != null ? classifications.stream()
                .map(c -> new ClassificationDto(c.getId(), c.getName()))
                .collect(Collectors.toList()) : null;
    }

    public static ClassificationDto classificationEntityToClassificationDto(Classification classification) {
        return classification != null ?
                new ClassificationDto(classification.getId(), classification.getName()) : null;
    }

    public static Classification classificationToClassificationEntity(ClassificationDto classificationDto) {
        return classificationDto != null ?
                new Classification(classificationDto.getId(), classificationDto.getName()) : null;
    }

    private ClassificationConverter() {
    }
}