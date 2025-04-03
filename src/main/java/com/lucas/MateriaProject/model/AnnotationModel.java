package com.lucas.MateriaProject.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Annotations")
public class AnnotationModel {
    @Id
    private String id;
    @Field("title")
    String title;
    @Field("Description")
    String description;
    @DBRef
    private MatterModel matter;
}
