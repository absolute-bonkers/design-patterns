package com.absolute.bonkers.abstractfactory;

import java.math.BigDecimal;

public interface PaymentService {
  void processPayment(BigDecimal amount);
}
