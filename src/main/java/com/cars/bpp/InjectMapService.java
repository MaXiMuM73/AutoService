package com.cars.bpp;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Map;

@Log4j2
@Service(value = "InjectMapService")
@Transactional
public class InjectMapService {

    @InjectMap
    private Map<String, MyCustomService> map;

    public InjectMapService() {
        log.info("Constructor");
    }

    @PostConstruct
    public void initMethod() {
        log.info("Post construct");
        log.info(map);
    }
}
