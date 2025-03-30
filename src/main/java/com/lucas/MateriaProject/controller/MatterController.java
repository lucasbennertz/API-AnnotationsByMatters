package com.lucas.MateriaProject.controller;

import com.lucas.MateriaProject.model.AnnotationModel;
import com.lucas.MateriaProject.model.MatterModel;
import com.lucas.MateriaProject.service.MatterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matters")
public class MatterController {

    private final MatterService service;

    public MatterController(MatterService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MatterModel>> getMatters() {
        return ResponseEntity.ok(service.getMatters());
    }

    @PostMapping
    public ResponseEntity<MatterModel> createMatter(@RequestBody MatterModel matter) {
        MatterModel createdMatter = service.createMatter(matter);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMatter);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatterModel> getMatter(@PathVariable int id) {
        MatterModel matter = service.getMatter(id);
        return matter != null ? ResponseEntity.ok(matter) : ResponseEntity.notFound().build();
    }
    @GetMapping("/{matterId}/annotations")
    public ResponseEntity<List<AnnotationModel>> getAnnotations(@PathVariable int matterId) {
        return ResponseEntity.ok(service.getAnnotations(matterId)) ;
    }
    @PutMapping("/{id}")
    public ResponseEntity<MatterModel> renameMatter(@PathVariable int id, @RequestBody MatterModel matter){
        return ResponseEntity.ok(service.renameMatter(id, matter));
    }
}
