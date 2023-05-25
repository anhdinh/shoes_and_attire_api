package com.andy.attire.repository;

import com.andy.attire.entity.ErrorEntity;
import org.springframework.data.repository.CrudRepository;

public interface ErrorRepository extends CrudRepository<ErrorEntity,Long> {
}
