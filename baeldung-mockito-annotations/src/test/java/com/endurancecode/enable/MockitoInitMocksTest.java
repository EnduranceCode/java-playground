package com.endurancecode.enable;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public class MockitoInitMocksTest {
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
}
