package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //this class is object of business
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository; //db olarak kullanıcaz iş kurallarını yazarken(injection)
    private  ModelMapperService modelMapperService;
    @Autowired //Brandmanager parametrelerine bakıyo kim brandRepo interfaceini implement ederse onları new'le getir
    public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService) { //business codes yazmam için bana bir repo ver diyoruz(hibernate-jdbc vs de verilebilir)
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        //Business codes
      List<Brand> brands=brandRepository.findAll(); //veritabanından brand'leri çekiyoruz
        List<GetAllBrandsResponse> brandsResponse=brands.stream() //burası bana birden fazla entity olsaydı oluşacak kod yükünden kurtardı
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList()); //bunları topla şu tipe çevir
        return brandsResponse;//oluşturduğumuz listenin içine ekleniyor
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand=this.brandRepository.findById(id).orElseThrow(); //değilse hata fırlat
        return this.modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand =this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);//createBrandRequesti brand'e çevirdik//arka planda forRequest Brandı newlıyo aynı olanları maplıyo
        this.brandRepository.save(brand);//repoya yeni bir insert işlemi yapıldı
    }

    @Override
    public void delete(int id) {
    this.brandRepository.deleteById(id);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand =this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);//createBrandRequesti brand'e çevirdik//arka planda forRequest Brandı newlıyo aynı olanları maplıyo
        this.brandRepository.save(brand); //save id yoksa insert yapar yoksa update
    }


}
