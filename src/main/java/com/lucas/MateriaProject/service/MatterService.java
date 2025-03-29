package com.lucas.MateriaProject.service;

import com.lucas.MateriaProject.model.AnnotationModel;
import com.lucas.MateriaProject.model.MatterModel;
import com.lucas.MateriaProject.repository.AnnotationRepository;
import com.lucas.MateriaProject.repository.MatterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatterService {

    @Autowired
    private MatterRepository repository;
    @Autowired
    private AnnotationRepository annotationRepository;

    public List<MatterModel> getMatters(){
        return repository.findAll();
    }
    public MatterModel getMatter(int id){
        return getMatters().get(id - 1);
    }
    public MatterModel createMatter(MatterModel matter){
        return repository.save(matter);
    }
    public List<AnnotationModel> getAnnotations(int matterId){
        MatterModel matter = getMatter(matterId);
        return annotationRepository.getByMatterId(matter.getId());
    }
    public void deleteMatter(MatterModel matter){
        repository.delete(matter);
    }
}
