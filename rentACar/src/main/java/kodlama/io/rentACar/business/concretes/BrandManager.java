package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //bu sınıf bir business nesnesidir
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository; //db olarak kullanıcaz iş kurallarını yazarken(injection)

    @Autowired //Brandmanager parametrelerine bakıyo kim brandRepo interfaceini implement ederse onları new'le getir
    public BrandManager(BrandRepository brandRepository) { //business codes yazmam için bana bir repo ver diyoruz(hibernate-jdbc vs de verilebilir)
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getAll() {
        //İş kuralları
        return brandRepository.getAll();
    }
}
