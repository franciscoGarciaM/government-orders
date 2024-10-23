package mx.gob.metepec.government_orders.mapper;

import mx.gob.metepec.government_orders.entity.PaymentMethod;
import mx.gob.metepec.government_orders.request.PaymentRequest;
import mx.gob.metepec.government_orders.response.PaymentResponse;

import java.util.ArrayList;
import java.util.List;

public class PaymentMapper {

    public static PaymentMethod mapRequestToEntity(PaymentRequest paymentRequest) {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setDescription(paymentRequest.getDescription());
        paymentMethod.setActive(paymentRequest.getActive());
        paymentMethod.setUuid(paymentRequest.getUuid());
        return paymentMethod;
    }

    public static PaymentResponse mapEntityToResponse(PaymentMethod paymentMethod) {
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setDescription(paymentMethod.getDescription());
        paymentResponse.setActive(paymentMethod.getActive());
        paymentResponse.setUuid(paymentMethod.getUuid());
        return paymentResponse;
    }

    public static List<PaymentResponse> mapEntityListToResponseList(List<PaymentMethod> paymentMethods) {
        List<PaymentResponse> paymentResponsesList = new ArrayList<>();
        for (PaymentMethod paymentMethod : paymentMethods) {
            paymentResponsesList.add(mapEntityToResponse(paymentMethod));
        }
        return paymentResponsesList;
    }

}
