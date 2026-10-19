package com.absolute.bonkers.abstractfactory.paypal;

import com.absolute.bonkers.abstractfactory.PaymentService;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaypalPaymentService implements PaymentService {
  @Override
  public void processPayment(BigDecimal amount) {
    // some fancy payment processing logic
    log.info("Payment via PayPal of amount %s is successful".formatted(amount));
  }
}
