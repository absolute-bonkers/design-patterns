package com.absolute.bonkers.singleton.eager;

import com.absolute.bonkers.singleton.ConnectionPool;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BreakSingletonPatternBySerializationTest {

  @Autowired EagerDatabaseConnectionPool eagerDatabaseConnectionPool;

  @Test
  void deserializationCreatesASecondEagerSingletonInstance()
      throws IOException, ClassNotFoundException {
    ConnectionPool originalPool = eagerDatabaseConnectionPool.getConnectionPool();
    byte[] serialized;
    try (var bytes = new ByteArrayOutputStream();
        var output = new ObjectOutputStream(bytes)) {
      output.writeObject(eagerDatabaseConnectionPool);
      output.flush();
      serialized = bytes.toByteArray();
    }

    EagerDatabaseConnectionPool restored;
    try (var input = new ObjectInputStream(new ByteArrayInputStream(serialized))) {
      restored = (EagerDatabaseConnectionPool) input.readObject();
    }

    Assertions.assertThat(restored).isNotSameAs(eagerDatabaseConnectionPool);
    Assertions.assertThat(restored.getConnectionPool()).isNotSameAs(originalPool);
  }
}
