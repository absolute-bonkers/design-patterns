# Proxy

Proxy provides a stand-in with the same interface as a real subject and controls access to it. A proxy can defer work, enforce access rules, cache results, or add remote communication without changing clients.

## Structure and example

[`Image`](src/main/java/com/example/structural/proxy/Image.java) is the shared subject interface. [`RealImage`](src/main/java/com/example/structural/proxy/RealImage.java) is the real subject, and [`ImageProxy`](src/main/java/com/example/structural/proxy/ImageProxy.java) lazily creates and retains it on first display.

```java
Image image = new ImageProxy("art/poster.png");
String output = image.display(); // Real image is created on demand.
```

## Tradeoffs and uses

Virtual proxies defer expensive resources, protection proxies enforce permissions, and remote proxies represent network objects. A proxy preserves client-facing behavior but adds indirection and may complicate state, failures, and concurrency. This small lazy proxy is intentionally local; production loading may need synchronization and explicit load-error handling.

See [proxy tests](src/test/java/com/example/structural/proxy/ImageProxyTest.java) for deferred creation, reuse, interface substitution, and invalid paths.

## ☕ Spring connection

Spring commonly implements services and repositories with proxies. For example,
`@Transactional` lets Spring wrap a service in a proxy that opens a transaction
before calling the real method and commits or rolls back afterward. The caller
uses the same service interface without handling transaction management itself.
This repository's `ImageProxy` keeps the mechanics explicit; Spring supplies the
proxy-generation and lifecycle machinery in an application.
