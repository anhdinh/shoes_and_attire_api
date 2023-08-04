package com.andy.attire.dto.mapper;

import org.modelmapper.ModelMapper;

public abstract class BaseMapperAbs {
    protected static ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
