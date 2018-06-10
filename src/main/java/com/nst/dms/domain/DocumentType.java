package com.nst.dms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nmarkovi on 3/4/18.
 */

@Getter
@Setter
@Entity
@Table(name = "document_type")
public class DocumentType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "documentType")
    List<Descriptor> descriptors;

    @Column(name = "name")
    String name;

    public DocumentType() {
        this.descriptors = new ArrayList<Descriptor>();
    }

    public DocumentType(Long id, String name) {
        this.id = id;
        this.name = name;
        this.descriptors = new ArrayList<>();
    }
}
