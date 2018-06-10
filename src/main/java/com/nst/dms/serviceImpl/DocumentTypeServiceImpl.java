package com.nst.dms.serviceImpl;

import com.nst.dms.domain.DocumentType;
import com.nst.dms.repository.DocumentTypeRepository;
import com.nst.dms.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by nmarkovi on 3/4/18.
 */
@Service
@Transactional
public class DocumentTypeServiceImpl implements DocumentTypeService {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Override
    public DocumentType save(DocumentType entity) {
        return documentTypeRepository.save(entity);
    }

    @Override
    public Optional<DocumentType> findById(Long id) {
        return documentTypeRepository.findById(id);
    }

    @Override
    public boolean deleteById(Long id) {

        long deleteById = documentTypeRepository.deleteById(id);
        return deleteById == 0 ? false : true;
    }

    @Override
    public List<DocumentType> findAll() {
        return documentTypeRepository.findAll();
    }
}
