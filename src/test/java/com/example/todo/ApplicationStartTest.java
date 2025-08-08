package com.example.todo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ApplicationStartTest {

    @Test
    void applicationStarts() {
        assertDoesNotThrow(() -> TaskMasterProApplication.main(new String[]{}));
    }
}
