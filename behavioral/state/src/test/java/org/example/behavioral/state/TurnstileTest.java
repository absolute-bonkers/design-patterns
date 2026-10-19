package org.example.behavioral.state;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TurnstileTest {
    @Test
    void lockedTurnstileSoundsAlarmUntilCoinIsInserted() {
        var turnstile = new Turnstile();

        assertEquals("locked", turnstile.stateName());
        assertEquals("alarm", turnstile.push());
        assertEquals("unlocked", turnstile.insertCoin());
        assertEquals("unlocked", turnstile.stateName());
        assertEquals("passed", turnstile.push());
        assertEquals("locked", turnstile.stateName());
    }

    @Test
    void extraCoinWhileUnlockedIsReturned() {
        var turnstile = new Turnstile();
        turnstile.insertCoin();

        assertEquals("coin returned", turnstile.insertCoin());
    }
}
