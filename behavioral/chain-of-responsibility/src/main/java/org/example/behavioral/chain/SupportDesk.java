package org.example.behavioral.chain;

import java.util.Objects;
import java.util.Optional;

/** A small support-request chain; handlers can pass requests to their successor. */
public final class SupportDesk {
    private SupportDesk() {}

    public record Request(String topic) {
        public Request {
            Objects.requireNonNull(topic, "topic");
        }
    }

    public abstract static class Handler {
        private Handler next;

        public Handler setNext(Handler next) {
            this.next = next;
            return next;
        }

        public final Optional<String> handle(Request request) {
            Objects.requireNonNull(request, "request");
            if (canHandle(request)) {
                return Optional.of(name());
            }
            return next == null ? Optional.empty() : next.handle(request);
        }

        protected abstract boolean canHandle(Request request);

        protected abstract String name();
    }

    public static final class PasswordSupport extends Handler {
        @Override
        protected boolean canHandle(Request request) {
            return request.topic().equalsIgnoreCase("password");
        }

        @Override
        protected String name() {
            return "password support";
        }
    }

    public static final class BillingSupport extends Handler {
        @Override
        protected boolean canHandle(Request request) {
            return request.topic().equalsIgnoreCase("billing");
        }

        @Override
        protected String name() {
            return "billing support";
        }
    }

    public static final class GeneralSupport extends Handler {
        @Override
        protected boolean canHandle(Request request) {
            return true;
        }

        @Override
        protected String name() {
            return "general support";
        }
    }

    public static Handler standardChain() {
        Handler password = new PasswordSupport();
        Handler billing = new BillingSupport();
        password.setNext(billing).setNext(new GeneralSupport());
        return password;
    }
}
