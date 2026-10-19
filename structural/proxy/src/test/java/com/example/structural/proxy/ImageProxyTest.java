package com.example.structural.proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ImageProxyTest {
    @Test
    void loadsRealImageOnlyOnFirstDisplayAndReusesIt() {
        ImageProxy image = new ImageProxy("art/poster.png");

        assertFalse(image.isLoaded());
        assertEquals("Displaying image: art/poster.png", image.display());
        assertTrue(image.isLoaded());
        assertEquals("Displaying image: art/poster.png", image.display());
    }

    @Test
    void proxyAndRealImageShareTheImageInterface() {
        Image direct = new RealImage("direct.png");
        Image deferred = new ImageProxy("deferred.png");

        assertEquals("Displaying image: direct.png", direct.display());
        assertEquals("Displaying image: deferred.png", deferred.display());
    }

    @Test
    void rejectsInvalidPaths() {
        assertThrows(NullPointerException.class, () -> new ImageProxy(null));
        assertThrows(IllegalArgumentException.class, () -> new ImageProxy(" "));
    }
}
