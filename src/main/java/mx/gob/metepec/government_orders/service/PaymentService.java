package mx.gob.metepec.government_orders.service;

import jakarta.transaction.Transactional;
import mx.gob.metepec.government_orders.entity.PaymentMethod;
import mx.gob.metepec.government_orders.exception.ResourceNotFoundException;
import mx.gob.metepec.government_orders.mapper.PaymentMapper;
import mx.gob.metepec.government_orders.repository.PaymentRepository;
import mx.gob.metepec.government_orders.request.PaymentRequest;
import mx.gob.metepec.government_orders.response.PaymentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<PaymentResponse> buscarTodos(){
        return PaymentMapper.mapEntityListToResponseList(paymentRepository.findAll());
    }

    public PaymentResponse getByUuid(UUID uuid){
        PaymentMethod paymentMethod = paymentRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("PaymentMethod not found"));
        return PaymentMapper.mapEntityToResponse(paymentMethod);
    }

    public void delete(UUID uuid){
        PaymentMethod paymentMethod = paymentRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("PaymentMethod not found"));
        paymentRepository.delete(paymentMethod);
    }

    @Transactional
    public PaymentResponse save(PaymentRequest paymentRequest){
        PaymentMethod paymentMethod = PaymentMapper.mapRequestToEntity(paymentRequest);
        return PaymentMapper.mapEntityToResponse(paymentRepository.save(paymentMethod));
    }

    public PaymentResponse update(UUID uuid, PaymentRequest paymentRequest){
        PaymentMethod paymentMethod = paymentRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("PaymentMethod not found"));
        paymentRequest.setUuid(uuid);
        paymentRequest.setDescription(paymentRequest.getDescription());
        paymentRequest.setActive(paymentRequest.getActive());
        return PaymentMapper.mapEntityToResponse(paymentRepository.save(paymentMethod));
    }

}
