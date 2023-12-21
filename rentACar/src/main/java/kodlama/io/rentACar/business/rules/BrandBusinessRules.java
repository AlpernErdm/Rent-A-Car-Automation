package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
        if(this.brandRepository.existsByName(name)) // brand repo'da yazdığımız method ile isim var mı yok mu sorgusu oluşturduk
        {
            throw  new BusinessException("Brand name already exists");
        }
    }
    public void checkIfBrandNameValid(String name){
        if(this.brandRepository.existsByName(name)) // brand repo'da yazdığımız method ile isim var mı yok mu sorgusu oluşturduk
        {
            throw  new BusinessException("Brand name size must be between 2 and 20");
        }
    }
}
