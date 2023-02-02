package com.yummyapps.employeeservice.stripe;


import com.stripe.exception.CardException;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.stereotype.Service;

@Service
public class PaymentIntentService {


    public PaymentIntent createPaymentIntent(String card) {

        try {
            PaymentIntentCreateParams params =
                    PaymentIntentCreateParams.builder()
                            .setAmount(1099L)
                            .setCurrency("jpy")
                            .addPaymentMethodType(card)
                            .build();

            return PaymentIntent.create(params);

        } catch (CardException ex) {
            if (ex.getStripeError()
                    .getPaymentIntent()
                    .getCharges()
                    .getData()
                    .get(0)
                    .getOutcome()
                    .getType().equals("blocked")) {
                System.out.println("Payment blocked for suspected fraud.");

            } else if (ex.getCode().equals("card_declined")) {
                System.out.println("Declined by the issuer.");
            } else if (ex.getCode().equals("expired_card")) {
                System.out.println("Card expired.");
            } else {
                System.out.println("Other card error.");
            }
        } catch (StripeException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);

        }
        return null;
    }
}