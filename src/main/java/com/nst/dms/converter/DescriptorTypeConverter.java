package com.nst.dms.converter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.nst.dms.domain.enums.DescriptorType;

/**
 * Created by nmarkovi on 6/9/18.
 */
public class DescriptorTypeConverter implements Converter<String, DescriptorType> {

    @Override
    public DescriptorType convert(String s) {
        return DescriptorType.valueOf(s);
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }
}
