package com.ironyard.services;

import com.ironyard.entities.Indicator;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by graceconnelly on 1/22/17.
 */
public interface IndicatorsRepository extends CrudRepository<Indicator, Integer> {
}
