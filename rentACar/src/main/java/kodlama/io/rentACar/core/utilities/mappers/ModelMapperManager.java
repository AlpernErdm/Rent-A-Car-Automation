package kodlama.io.rentACar.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;

@Service//her seferinde yeni bir ModelMapper oluşturulmasını istemediğimiz için IOC'ye yerleşmesi için Service annotation'u yazıyoruz
@AllArgsConstructor //modelmapper injection için
public class ModelMapperManager implements  ModelMapperService{
    private ModelMapper modelMapper; //IOC için
    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)//belirsizlik anında ıgnore etme fonksiyonu
                .setMatchingStrategy(MatchingStrategies.LOOSE);//gevşek mapleme yap yani 4 entityden 2 si de alınsa da olabilir
        return this.modelMapper;
    }

    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);//tam mapleme yap
        return this.modelMapper;
    }
}
