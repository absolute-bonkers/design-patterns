package org.example.behavioral.chain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.behavioral.chain.SupportDesk.Request;
import org.junit.jupiter.api.Test;

class SupportDeskTest {
    @Test
    void routesToFirstMatchingHandler() {
        var chain = SupportDesk.standardChain();

        assertEquals("password support", chain.handle(new Request("password")).orElseThrow());
        assertEquals("billing support", chain.handle(new Request("billing")).orElseThrow());
        assertEquals("general support", chain.handle(new Request("shipping")).orElseThrow());
    }

    @Test
    void emptyChainLeavesRequestUnhandled() {
        assertEquals(java.util.Optional.empty(), new SupportDesk.PasswordSupport()
                .handle(new Request("billing")));
    }

    @Test
    void rejectsNullRequest() {
        assertThrows(NullPointerException.class, () -> SupportDesk.standardChain().handle(null));
    }
}
