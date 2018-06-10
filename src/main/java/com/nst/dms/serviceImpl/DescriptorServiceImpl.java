package com.nst.dms.serviceImpl;

import com.nst.dms.domain.Descriptor;
import com.nst.dms.domain.DocumentType;
import com.nst.dms.repository.DescriptorRepository;
import com.nst.dms.service.DescriptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by nmarkovi on 3/4/18.
 */
@Service
@Transactional
public class DescriptorServiceImpl implements DescriptorService {

    @Autowired
    private DescriptorRepository descriptorRepository;

    @Override
    public Descriptor save(Descriptor entity) {
        return descriptorRepository.save(entity);
    }

    @Override
    public Optional<Descriptor> findById(Long id) {
        return descriptorRepository.findById(id);
    }

    @Override
    public boolean deleteById(Long id) {

        long deleteById = descriptorRepository.deleteById(id);
        return deleteById == 0 ? false : true;
    }

    @Override
    public List<Descriptor> findByDocumentType(DocumentType documentType) {
        return descriptorRepository.findByDocumentType(documentType);
    }
}
