package mx.gob.metepec.government_orders.mapper;

import mx.gob.metepec.government_orders.entity.Input;
import mx.gob.metepec.government_orders.request.InputRequest;
import mx.gob.metepec.government_orders.response.InputResponse;

import java.util.ArrayList;
import java.util.List;

public class InputMapper {

    public static Input mapRequestToEntity(InputRequest inputRequest){
        Input input = new Input();
        input.setDescription(inputRequest.getDescription());
        input.setUnitPrice(inputRequest.getUnitPrice());
        input.setUuid(inputRequest.getUuid());
        return input;
    }

    public static InputResponse mapEntityToResponse(Input input){
        InputResponse inputResponse = new InputResponse();
        inputResponse.setDescription(input.getDescription());
        inputResponse.setUnitPrice(input.getUnitPrice());
        inputResponse.setUuid(input.getUuid());
        return inputResponse;
    }

    public static List<InputResponse> mapEntityListToResponseList(List<Input> inputs){
        List<InputResponse> inputResponseList = new ArrayList<>();
        for(Input input : inputs){
            inputResponseList.add(mapEntityToResponse(input));
        }
        return inputResponseList;
    }
}
