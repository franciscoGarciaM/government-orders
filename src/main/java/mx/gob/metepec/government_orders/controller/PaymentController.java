package mx.gob.metepec.government_orders.controller;

import mx.gob.metepec.government_orders.request.PaymentRequest;
import mx.gob.metepec.government_orders.response.PaymentResponse;
import mx.gob.metepec.government_orders.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    public List<PaymentResponse> getAllPayments() {
        return paymentService.buscarTodos();
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentResponse> createPayment(@Validated @RequestBody PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = paymentService.save(paymentRequest);
        return ResponseEntity.ok(paymentResponse);
    }

    @GetMapping("/payment/{uuid}")
    public ResponseEntity<PaymentResponse> getPaymentByUuid(@PathVariable UUID uuid) {
        PaymentResponse paymentResponse = paymentService.getByUuid(uuid);
        return ResponseEntity.ok(paymentResponse);
    }

    @PutMapping("/payment/{uuid}")
    public ResponseEntity<PaymentResponse> updatePayment(@PathVariable UUID uuid, @RequestBody PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = paymentService.update(uuid, paymentRequest);
        return ResponseEntity.ok(paymentResponse);
    }

    @DeleteMapping("/payment/{uuid}")
    public ResponseEntity<PaymentResponse> deletePayment(@PathVariable UUID uuid) {
        paymentService.delete(uuid);
        return ResponseEntity.ok().build();
    }

}
