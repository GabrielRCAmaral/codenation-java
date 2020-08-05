package br.com.codenation;

import br.com.codenation.paymentmethods.PaymentMethod;
import br.com.codenation.paymentmethods.PriceStrategy;

public class BillingProcessor {

    public Double calculate(Order order) {
        return order.getPaymentMethod().getPaymentStrategy().calculate(order.getPrice());
        //throw new RuntimeException("Payment method not implemented");
    }
}