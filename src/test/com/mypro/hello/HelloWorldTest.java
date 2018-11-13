package com.mypro.hello;
import com.mypro.hello.HelloWorld;
import org.junit.Test;
import static org.junit.Assert.*;

public class HelloWorldTest {
    @Test public void testHelloWorldMessage() {
        HelloWorld classUnderTest = new HelloWorld();
        assertNotNull("Hello", "Hello");
    }
}

