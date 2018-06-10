package com.nst.dms.repository;

import com.nst.dms.domain.Descriptor;
import com.nst.dms.domain.DocumentType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by nmarkovi on 3/4/18.
 */
public interface DescriptorRepository extends Repository<Descriptor, Long> {

    Optional<Descriptor> findById(Long id);

    Descriptor save(Descriptor descriptor);

    @Modifying
    @Transactional
    long deleteById(Long id);

    List<Descriptor> findByDocumentType(DocumentType documentType);

}
