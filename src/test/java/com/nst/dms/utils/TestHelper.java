package com.nst.dms.utils;

import com.nst.dms.domain.Descriptor;
import com.nst.dms.domain.DocumentType;
import com.nst.dms.domain.enums.DescriptorType;

/**
 * Created by nmarkovi on 3/11/18.
 */
public class TestHelper {

    public static String getRandomString(Integer length) {
        String value = new String();
        int strLength = length != null ? length.intValue() : (int) (Math.random() * 10.0D) + 5;
        int rand = 0;

        for (int i = 0; i < strLength; ++i) {
            rand = (int) (Math.random() * 10.0D) % 3;
            if (rand == 0) {
                value = value + (int) (Math.random() * 10.0D);
            } else if (rand == 1) {
                value = value + (char) ((int) (Math.random() * 26.0D + 65.0D));
            } else {
                value = value + (char) ((int) (Math.random() * 26.0D + 97.0D));
            }
        }

        return value;
    }

    public static Descriptor createDescriptorEntity() {

        Descriptor descriptor = new Descriptor();
        descriptor.setName("Descriptor_ " + getRandomString(6));
        descriptor.setMandatory(true);
        descriptor.setDocumentType(createDocumentTypeEntity());
        descriptor.setDescriptorType(DescriptorType.BOOLEAN);

        return descriptor;

    }

    public static DocumentType createDocumentTypeEntity() {

        DocumentType documentType = new DocumentType();
        documentType.setName("DocumentType_" + getRandomString(6));

        return documentType;
    }
}
