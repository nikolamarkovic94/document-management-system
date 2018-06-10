package com.nst.dms.service;

import com.nst.dms.base.BaseServiceTest;
import com.nst.dms.domain.Descriptor;
import com.nst.dms.utils.TestHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

/**
 * Created by nmarkovi on 3/4/18.
 */
public class DescriptorServiceTest extends BaseServiceTest {

    @Test
    public void crudTest() {

        //create
        Descriptor descriptor = TestHelper.createDescriptorEntity();
        descriptor = descriptorService.save(descriptor);
        Assert.assertNotNull(descriptor.getId());

        //read
        Optional<Descriptor> byId = descriptorService.findById(descriptor.getId());
        Assert.assertTrue(byId.isPresent());

        List<Descriptor> descriptorListByType = descriptorService.findByDocumentType(descriptor.getDocumentType());
        Assert.assertEquals(descriptorListByType.size(), 1);

        //update
        descriptor.setName("Updated name");
        Descriptor updatedDescriptor = descriptorService.save(descriptor);
        Assert.assertNotEquals(byId.get().getName(), descriptor.getName());

        //delete
        descriptorService.deleteById(descriptor.getId());
        Optional<Descriptor> descriptorDeleted = descriptorService.findById(descriptor.getId());
        Assert.assertFalse(descriptorDeleted.isPresent());
    }
}
