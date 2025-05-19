package com.lucas.MateriaProject.service;

import com.lucas.MateriaProject.model.AnnotationModel;
import com.lucas.MateriaProject.model.MatterModel;
import com.lucas.MateriaProject.repository.AnnotationRepository;
import com.lucas.MateriaProject.repository.MatterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatterService {

    @Autowired
    private MatterRepository repository;
    @Autowired
    private AnnotationRepository annotationRepository;

    public List<MatterModel> getMatters(){
        return repository.findAll();
    }
    public MatterModel getMatter(String id){
        return repository.findById(id).orElse(null);

    }
    public MatterModel createMatter(MatterModel matter){
        return repository.save(matter);
    }
    public List<AnnotationModel> getAnnotations(String matterId){
        MatterModel matter = getMatter(matterId);
        return annotationRepository.getByMatterId(matter.getId());
    }
    public MatterModel renameMatter(String id, MatterModel matter){
       MatterModel matt = getMatter(id);
       matt.setNome(matter.getNome());
       return repository.save(matt);
    }
    public void deleteMatter(String matterId){
        repository.deleteById(matterId);
    }
}
