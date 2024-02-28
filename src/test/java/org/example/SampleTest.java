package org.example;

import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;

public class SampleTest {
    @Test
    // This test fails in Mockito versions <3.7.x
    // Change the version in the pom.xml file to verify
    public void singleStaticMethodTest() {
        try (MockedStatic<Sample> mocked = mockStatic(Sample.class, Mockito.CALLS_REAL_METHODS)) {
            mocked.when(() -> Sample.method1(anyString())).thenReturn("bar");
            assertEquals("bar", Sample.method1("foo")); // mocked
            assertEquals("foo", Sample.method2("foo")); // not mocked
        }
    }
}
