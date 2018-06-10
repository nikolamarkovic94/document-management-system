package com.nst.dms.service;

import com.nst.dms.domain.Descriptor;
import com.nst.dms.domain.DocumentType;
import com.nst.dms.service.base.BaseService;

import java.util.List;
import java.util.Optional;

/**
 * Created by nmarkovi on 3/4/18.
 */
public interface DescriptorService extends BaseService<Descriptor> {

    public List<Descriptor> findByDocumentType(DocumentType documentType);
}
