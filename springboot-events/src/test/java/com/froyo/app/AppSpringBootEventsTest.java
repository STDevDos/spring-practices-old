package com.froyo.app;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplication;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppSpringBootEventsTest {

    @Disabled("here hay: org.mockito.exceptions.base.MockitoException")
    @Test
    public void main() {

        when(SpringApplication.run(mock(Class.class), "uno")) //
                .thenReturn(null);

        AppSpringBootEvents.main(null);
    }
}
