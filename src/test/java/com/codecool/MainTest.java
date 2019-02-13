package com.codecool;

import com.codecool.main.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testGetWelcomeString() {
        Main main = new Main();
        assertEquals("Hi!", main.getWelcomeString());
    }
}
