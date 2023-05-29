package com.andy.attire.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public abstract class BaseMapperAbs {
    protected static ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
