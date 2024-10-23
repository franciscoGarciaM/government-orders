package mx.gob.metepec.government_orders.service;

import jakarta.transaction.Transactional;
import mx.gob.metepec.government_orders.entity.Supplier;
import mx.gob.metepec.government_orders.exception.ResourceNotFoundException;
import mx.gob.metepec.government_orders.mapper.SupplierMapper;
import mx.gob.metepec.government_orders.repository.SupplierRepository;
import mx.gob.metepec.government_orders.request.SupplierRequest;
import mx.gob.metepec.government_orders.response.SupplierResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<SupplierResponse> buscarTodos(){
        return SupplierMapper.mapEntityListToResponseList(supplierRepository.findAll());
    }

    public SupplierResponse getByUuid(UUID uuid){
        Supplier supplier = supplierRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        return SupplierMapper.mapEntityToResponse(supplier);
    }

    public void delete(UUID uuid){
        Supplier supplier = supplierRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        supplierRepository.delete(supplier);
    }

    @Transactional
    public SupplierResponse save(SupplierRequest supplierRequest){
        Supplier supplier = SupplierMapper.mapRequestToEntity(supplierRequest);
        return SupplierMapper.mapEntityToResponse(supplierRepository.save(supplier));
    }

    public SupplierResponse update(UUID uuid, SupplierRequest supplierRequest){
        Supplier supplier = supplierRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        supplier.setRfc(supplierRequest.getRfc());
        supplier.setCompanyName(supplierRequest.getCompanyName());
        supplier.setUuid(supplierRequest.getUuid());
        return SupplierMapper.mapEntityToResponse(supplierRepository.save(supplier));
    }

}
