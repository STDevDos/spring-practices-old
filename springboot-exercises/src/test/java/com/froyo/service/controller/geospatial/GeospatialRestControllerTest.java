package com.froyo.service.controller.geospatial;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GeospatialRestControllerTest {

    @InjectMocks
    private GeospatialRestController geospatialRestController;

    @Test
    void testPointSpringFramework() {
        geospatialRestController.testPointSpringFramework();
    }
}
