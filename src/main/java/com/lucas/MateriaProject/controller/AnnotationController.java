package com.lucas.MateriaProject.controller;

import com.lucas.MateriaProject.model.AnnotationModel;
import com.lucas.MateriaProject.service.AnnotationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annotations")
public class AnnotationController {

    private final AnnotationService service;

    public AnnotationController(AnnotationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AnnotationModel>> getAnnotations() {
        List<AnnotationModel> annotations = service.getAnnotations();
        return ResponseEntity.ok(annotations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnotationModel> getAnnotation(@PathVariable int id) {
        return ResponseEntity.ok(service.getAnnotation(id));
    }

    @PostMapping("/{matterId}")
    public ResponseEntity<AnnotationModel> createAnnotation(@RequestBody AnnotationModel annotation, @PathVariable int matterId) {
        AnnotationModel createdAnnotation = service.createAnnotation(annotation, matterId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnnotation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnotation(@PathVariable Long id) {
        service.deleteAnnotation(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}/rename")
    public ResponseEntity<AnnotationModel> renameAnnotation(@PathVariable int id, @RequestBody AnnotationModel annotation) {
        return ResponseEntity.ok(service.renameAnnotation(id, annotation));
    }
}
