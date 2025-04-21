package com.lucas.MateriaProject.service;

import com.lucas.MateriaProject.model.AnnotationModel;
import com.lucas.MateriaProject.model.MatterModel;
import com.lucas.MateriaProject.repository.AnnotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnotationService {

    @Autowired
    private AnnotationRepository repository;
    @Autowired
    private MatterService matterService;

    public List<AnnotationModel> getAnnotations(){
        return repository.findAll();
    }
    public AnnotationModel getAnnotation(String id){
        return repository.findById(id).orElse(null);
    }

    public AnnotationModel createAnnotation(AnnotationModel annotation, String matterId){
        MatterModel matter = matterService.getMatter(matterId);
        if(matter == null){
            throw new RuntimeException("Materia não encontrada");
        }
        annotation.setMatter(matter);
        AnnotationModel savedAnnotation = repository.save(annotation);
        List<AnnotationModel> annotations = getAnnotations();
        annotations.add(savedAnnotation);
        matter.setAnnotations(annotations);
        return savedAnnotation;
    }
    public void deleteAnnotation(String id){
        repository.deleteById(id);
    }
    public AnnotationModel renameAnnotation(String id, AnnotationModel annotation){
        AnnotationModel ann = repository.findById(id).orElse(null);
        ann.setTitle(annotation.getTitle());
        return repository.save(ann);
    }

}
