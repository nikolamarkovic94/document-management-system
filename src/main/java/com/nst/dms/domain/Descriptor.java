package com.nst.dms.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nst.dms.domain.enums.DescriptorType;
import lombok.*;

import javax.persistence.*;


/**
 * Created by nmarkovi on 3/4/18.
 */

@Getter
@Setter
@Entity
@Table(name = "descriptor")
public class Descriptor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mandatory")
    private boolean mandatory;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    DescriptorType descriptorType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "document_type_id")
    DocumentType documentType;

}
