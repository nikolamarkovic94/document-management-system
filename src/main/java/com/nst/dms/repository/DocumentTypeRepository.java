package com.nst.dms.repository;

import com.nst.dms.domain.DocumentType;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by nmarkovi on 3/4/18.
 */
public interface DocumentTypeRepository extends Repository<DocumentType, Long> {

    Optional<DocumentType> findById(Long id);

    DocumentType save(DocumentType entity);

    long deleteById(long id);

    List<DocumentType> findAll();
}
