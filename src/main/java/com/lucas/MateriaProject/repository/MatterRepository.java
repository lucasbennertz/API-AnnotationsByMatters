package com.lucas.MateriaProject.repository;

import com.lucas.MateriaProject.model.MatterModel;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface MatterRepository extends MongoRepository<MatterModel, String> {

}
