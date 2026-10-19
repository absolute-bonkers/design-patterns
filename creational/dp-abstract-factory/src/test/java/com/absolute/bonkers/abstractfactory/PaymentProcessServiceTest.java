package com.absolute.bonkers.abstractfactory;

import static com.absolute.bonkers.abstractfactory.PaymentGateway.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.absolute.bonkers.abstractfactory.paypal.PaypalPaymentService;
import com.absolute.bonkers.abstractfactory.paypal.PaypalRefundService;
import com.absolute.bonkers.abstractfactory.stripe.StripePaymentService;
import com.absolute.bonkers.abstractfactory.stripe.StripeRefundService;
import java.math.BigDecimal;
import java.util.UUID;
import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentProcessServiceTest {

  @Autowired private PaymentProcessService paymentProcessService;

  private LogCaptor logCaptor;

  @AfterEach
  void tearDown() {
    if (logCaptor != null) {
      logCaptor.clearLogs();
      logCaptor.close();
    }
  }

  @Test
  void processPaypalPayment() {
    logCaptor = LogCaptor.forClass(PaypalPaymentService.class);

    // given payment processing via PAYPAL
    paymentProcessService.processPayment(PAYPAL, new BigDecimal("100.00"));

    assertThat(logCaptor.getInfoLogs().size()).isEqualTo(1);

    // verify the Paypal payment is called
    assertThat(logCaptor.getInfoLogs())
        .contains("Payment via PayPal of amount 100.00 is successful");
  }

  @Test
  void processPaypalRefund() {
    String transactionId = UUID.randomUUID().toString();

    logCaptor = LogCaptor.forClass(PaypalRefundService.class);
    // given payment refund via PAYPAL
    paymentProcessService.processRefund(PAYPAL, transactionId);

    assertThat(logCaptor.getInfoLogs().size()).isEqualTo(1);
    // verify the Paypal refund is called
    assertThat(logCaptor.getInfoLogs())
        .contains("Refund via PayPal for transactionId %s is successful".formatted(transactionId));
  }

  @Test
  void processStripePayment() {
    logCaptor = LogCaptor.forClass(StripePaymentService.class);

    // given payment processing via STRIPE
    paymentProcessService.processPayment(STRIPE, new BigDecimal("120.00"));

    assertThat(logCaptor.getInfoLogs().size()).isEqualTo(1);

    // verify the Stripe payment is called
    assertThat(logCaptor.getInfoLogs())
        .contains("Payment via Stripe of amount 120.00 is successful");
  }

  @Test
  void processStripeRefund() {
    String transactionId = UUID.randomUUID().toString();

    logCaptor = LogCaptor.forClass(StripeRefundService.class);
    // given payment refund via STRIPE
    paymentProcessService.processRefund(STRIPE, transactionId);

    assertThat(logCaptor.getInfoLogs().size()).isEqualTo(1);

    // verify the Stripe refund is called
    assertThat(logCaptor.getInfoLogs())
        .contains("Refund via Stripe for transactionId %s is successful".formatted(transactionId));
  }

  @Test
  void rejectsInvalidPaymentAmountsAndRefundIdentifiers() {
    assertThrows(
        IllegalArgumentException.class,
        () -> paymentProcessService.processPayment(PAYPAL, BigDecimal.ZERO));
    assertThrows(
        IllegalArgumentException.class,
        () -> paymentProcessService.processRefund(STRIPE, " "));
    assertThrows(
        NullPointerException.class,
        () -> paymentProcessService.processPayment(null, BigDecimal.ONE));
  }
}
