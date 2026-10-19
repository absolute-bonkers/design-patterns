package org.example.behavioral.state;

/** A turnstile delegates coin and push behavior to its current state object. */
public final class Turnstile {
    public interface State {
        String insertCoin(Turnstile turnstile);

        String push(Turnstile turnstile);

        String name();
    }

    private static final State LOCKED = new Locked();
    private static final State UNLOCKED = new Unlocked();
    private State state = LOCKED;

    public String insertCoin() {
        return state.insertCoin(this);
    }

    public String push() {
        return state.push(this);
    }

    public String stateName() {
        return state.name();
    }

    private void transitionTo(State state) {
        this.state = state;
    }

    private static final class Locked implements State {
        @Override
        public String insertCoin(Turnstile turnstile) {
            turnstile.transitionTo(UNLOCKED);
            return "unlocked";
        }

        @Override
        public String push(Turnstile turnstile) {
            return "alarm";
        }

        @Override
        public String name() {
            return "locked";
        }
    }

    private static final class Unlocked implements State {
        @Override
        public String insertCoin(Turnstile turnstile) {
            return "coin returned";
        }

        @Override
        public String push(Turnstile turnstile) {
            turnstile.transitionTo(LOCKED);
            return "passed";
        }

        @Override
        public String name() {
            return "unlocked";
        }
    }
}
