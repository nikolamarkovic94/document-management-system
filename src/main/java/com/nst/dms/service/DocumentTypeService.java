package com.nst.dms.service;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.nst.dms.domain.DocumentType;
import com.nst.dms.service.base.BaseService;

import java.util.List;
import java.util.Optional;

/**
 * Created by nmarkovi on 3/4/18.
 */
public interface DocumentTypeService extends BaseService<DocumentType> {

    List<DocumentType> findAll();

}
