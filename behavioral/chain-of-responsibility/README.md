# Chain of Responsibility

**Intent:** Let several possible handlers inspect a request in sequence. Each
handler either deals with it or forwards it, so the sender does not need to
choose a concrete receiver.

`SupportDesk.Handler` defines the common handling operation and successor link.
Password and billing support handle their own topics; general support is the
fallback. `standardChain()` assembles them. Try `handle(new Request("billing"))`
to see the first matching handler report its name.

- Implementation: [SupportDesk.java](src/main/java/org/example/behavioral/chain/SupportDesk.java)
- Tests: [SupportDeskTest.java](src/test/java/org/example/behavioral/chain/SupportDeskTest.java)

This is useful for request middleware, validation pipelines, support routing,
and event processing where the sender should be decoupled from the handler.
Order matters, and an unhandled request needs an explicit policy (here, an
empty `Optional`; the standard chain instead has a fallback). Long chains can
also make routing harder to understand or debug.

In a Spring Boot web application, servlet filters and Spring Security's filter
chain are familiar framework-level examples of requests passing through
ordered handlers. This module keeps its own tiny chain so its matching and
fallback behavior can be exercised without a web server.
