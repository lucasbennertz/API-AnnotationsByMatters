package com.lucas.MateriaProject.repository;

import com.lucas.MateriaProject.model.AnnotationModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnotationRepository  extends MongoRepository<AnnotationModel, String> {
    List<AnnotationModel> getByMatterId(String matterId);
}
