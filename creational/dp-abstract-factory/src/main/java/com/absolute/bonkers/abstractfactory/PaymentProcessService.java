package com.absolute.bonkers.abstractfactory;

import com.absolute.bonkers.abstractfactory.factories.PaymentGatewayFactory;
import java.math.BigDecimal;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class PaymentProcessService {
  private final PaymentGatewayFactoryProvider paymentGatewayFactoryProvider;

  public PaymentProcessService(PaymentGatewayFactoryProvider paymentGatewayFactoryProvider) {
    this.paymentGatewayFactoryProvider =
        Objects.requireNonNull(paymentGatewayFactoryProvider, "paymentGatewayFactoryProvider");
  }

  public void processPayment(PaymentGateway gateway, BigDecimal amount) {
    Objects.requireNonNull(amount, "amount");
    if (amount.signum() <= 0) {
      throw new IllegalArgumentException("Payment amount must be positive");
    }
    PaymentGatewayFactory factory = paymentGatewayFactoryProvider.getFactory(gateway);
    PaymentService paymentService = factory.createPaymentService();
    paymentService.processPayment(amount);
  }

  public void processRefund(PaymentGateway gateway, String transactionId) {
    if (transactionId == null || transactionId.isBlank()) {
      throw new IllegalArgumentException("Transaction ID is required");
    }
    PaymentGatewayFactory factory = paymentGatewayFactoryProvider.getFactory(gateway);
    RefundService refundService = factory.createRefundService();
    refundService.processRefund(transactionId);
  }
}
