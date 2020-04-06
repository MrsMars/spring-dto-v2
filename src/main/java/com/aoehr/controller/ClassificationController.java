package com.aoehr.controller;

import com.aoehr.dto.ClassificationDto;
import com.aoehr.dto.mapper.ClassificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClassificationController {

    @Autowired
    private ClassificationMapper classificationMapper;

    @PostMapping("/saveClassification")
    public ResponseEntity<String> saveClassification(@Valid @RequestBody ClassificationDto classificationDto) {
        return classificationMapper.saveClassification(classificationDto) != null ?
                new ResponseEntity<>("save successfully", HttpStatus.OK) :
                new ResponseEntity<>("save failed", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/listClassification")
    public List<ClassificationDto> getAllClassifications() {
        return classificationMapper.getClassification();
    }

    @GetMapping("/listClassificationId/{id}")
    public ClassificationDto getClassificationById(@PathVariable Long id) {
        return classificationMapper.getClassificationById(id);
    }

    @DeleteMapping("/deleteclass/{id}")
    public ResponseEntity<String> deleteClassification(@PathVariable Long id) {
        if (classificationMapper.getClassificationById(id) != null) {
            classificationMapper.deleteClassification(id);
            return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("delete failed", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateClassification(@RequestBody ClassificationDto classificationDto) {
        return classificationMapper.updateClassification(classificationDto) != null ?
                new ResponseEntity<>("success update", HttpStatus.OK) :
                new ResponseEntity<>("update failed", HttpStatus.BAD_REQUEST);
    }
}
