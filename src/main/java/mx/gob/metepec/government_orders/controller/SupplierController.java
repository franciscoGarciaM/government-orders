package mx.gob.metepec.government_orders.controller;

import mx.gob.metepec.government_orders.request.SupplierRequest;
import mx.gob.metepec.government_orders.response.SupplierResponse;
import mx.gob.metepec.government_orders.service.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class SupplierController {

    private  final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/supplier")
    public List<SupplierResponse> getAllSuppliers() {
        return supplierService.buscarTodos();
    }

    @PostMapping("/supplier")
    public ResponseEntity<SupplierResponse> createSupplier(@Validated @RequestBody SupplierRequest supplierRequest) {
        SupplierResponse supplierResponse = supplierService.save(supplierRequest);
        return ResponseEntity.ok(supplierResponse);
    }

    @GetMapping("/supplier/{uuid}")
    public ResponseEntity<SupplierResponse> getSupplierByUuid(@PathVariable UUID uuid) {
        SupplierResponse supplierResponse = supplierService.getByUuid(uuid);
        return ResponseEntity.ok(supplierResponse);
    }

    @PutMapping("/supplier/{uuid}")
    public ResponseEntity<SupplierResponse> updateSupplier(@PathVariable UUID uuid, @RequestBody SupplierRequest supplierRequest) {
        SupplierResponse supplierResponse = supplierService.update(uuid, supplierRequest);
        return ResponseEntity.ok(supplierResponse);
    }

    @DeleteMapping("/supplier/{uuid}")
    public ResponseEntity<SupplierResponse> deleteSupplier(@PathVariable UUID uuid) {
        supplierService.delete(uuid);
        return ResponseEntity.noContent().build();
    }

}
