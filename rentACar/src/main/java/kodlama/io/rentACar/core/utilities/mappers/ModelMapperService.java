package kodlama.io.rentACar.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


public interface ModelMapperService {

    ModelMapper forRequest();
    ModelMapper forResponse();
}
