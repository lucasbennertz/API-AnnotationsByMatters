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
    public AnnotationModel getAnnotation(int id){
        return getAnnotations().get(id - 1);
    }

    public AnnotationModel createAnnotation(AnnotationModel annotation, int matterId){
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
    public void deleteAnnotation(Long id){
        repository.deleteById(id.toString());
    }
    public AnnotationModel renameAnnotation(int id, AnnotationModel annotation){
        AnnotationModel ann = repository.findAll().get(id);
        ann.setTitle(annotation.getTitle());
        return repository.save(ann);
    }

}
