package mx.gob.metepec.government_orders.mapper;

import mx.gob.metepec.government_orders.entity.Supplier;
import mx.gob.metepec.government_orders.request.SupplierRequest;
import mx.gob.metepec.government_orders.response.SupplierResponse;

import java.util.ArrayList;
import java.util.List;

public class SupplierMapper {

    public static Supplier mapRequestToEntity(SupplierRequest supplierRequest){
        Supplier supplier = new Supplier();
        supplier.setRfc(supplierRequest.getRfc());
        supplier.setCompanyName(supplierRequest.getCompanyName());
        supplier.setUuid(supplierRequest.getUuid());
        supplier.setActive(supplierRequest.getActive());
        return supplier;
    }

    public static SupplierResponse mapEntityToResponse(Supplier supplier){
        SupplierResponse supplierResponse = new SupplierResponse();
        supplierResponse.setRfc(supplier.getRfc());
        supplierResponse.setCompanyName(supplier.getCompanyName());
        supplierResponse.setUuid(supplier.getUuid());
        supplierResponse.setActive(supplier.getActive());
        return supplierResponse;
    }

    public static List<SupplierResponse> mapEntityListToResponseList(List<Supplier> suppliers){
        List<SupplierResponse> supplierResponseList = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            supplierResponseList.add(mapEntityToResponse(supplier));
        }
        return supplierResponseList;
    }

}
