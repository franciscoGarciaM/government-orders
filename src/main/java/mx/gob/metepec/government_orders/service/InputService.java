package mx.gob.metepec.government_orders.service;

import jakarta.transaction.Transactional;
import mx.gob.metepec.government_orders.entity.Input;
import mx.gob.metepec.government_orders.mapper.InputMapper;
import mx.gob.metepec.government_orders.repository.InputRepository;
import mx.gob.metepec.government_orders.request.InputRequest;
import mx.gob.metepec.government_orders.response.InputResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InputService {

    private final InputRepository inputRepository;

    public InputService(InputRepository inputRepository) {
        this.inputRepository = inputRepository;
    }

    public List<InputResponse> buscarTodos(){
        return InputMapper.mapEntityListToResponseList(inputRepository.findAll());
    }

    public InputResponse getByUuid(UUID uuid){
        Input input = inputRepository.findByUuid(uuid).orElseThrow(() -> new IllegalArgumentException("Input not found"));
        return InputMapper.mapEntityToResponse(input);
    }

    public void delete(UUID uuid){
        Input input = inputRepository.findByUuid(uuid).orElseThrow(() -> new IllegalArgumentException("Input not found"));
        inputRepository.delete(input);
    }

    @Transactional
    public InputResponse save(InputRequest inputRequest){
        Input input = InputMapper.mapRequestToEntity(inputRequest);
        return InputMapper.mapEntityToResponse(inputRepository.save(input));
    }

    public InputResponse update(UUID uuid, InputRequest inputRequest){
        Input input = inputRepository.findByUuid(uuid).orElseThrow(() -> new IllegalArgumentException("Input not found"));
        input.setDescription(inputRequest.getDescription());
        input.setUnitPrice(inputRequest.getUnitPrice());
        input.setUuid(inputRequest.getUuid());
        return InputMapper.mapEntityToResponse(inputRepository.save(input));
    }

}
