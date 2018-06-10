package com.nst.dms.service;

import com.nst.dms.base.BaseServiceTest;
import com.nst.dms.domain.DocumentType;
import com.nst.dms.utils.TestHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

/**
 * Created by nmarkovi on 3/18/18.
 */
public class DocumentTypeServiceTest extends BaseServiceTest {

    @Test
    public void crudTest() {
        //create
        DocumentType documentType = TestHelper.createDocumentTypeEntity();
        documentTypeService.save(documentType);
        Assert.assertNotNull(documentType.getId());

        //read
        Optional<DocumentType> byId = documentTypeService.findById(documentType.getId());
        Assert.assertTrue(byId.isPresent());

        //update
        documentType.setName("Updated name");
        DocumentType updatedDocumentType = documentTypeService.save(documentType);
        Assert.assertNotEquals(byId.get().getName(), documentType.getName());

        //delete
        documentTypeService.deleteById(documentType.getId());
        Optional<DocumentType> documentDeleted = documentTypeService.findById(documentType.getId());
        Assert.assertFalse(documentDeleted.isPresent());
    }
}
