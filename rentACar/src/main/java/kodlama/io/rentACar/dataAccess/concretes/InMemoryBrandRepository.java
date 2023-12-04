package kodlama.io.rentACar.dataAccess.concretes;

import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //annotaion ne işe yarıyo onun bilgisini verir-bu sınıf bir DataAccess  nesnesidir
public class InMemoryBrandRepository implements BrandRepository {
    List<Brand>brands;

    public InMemoryBrandRepository() { //noparameter ctor oluşturduk
    brands=new ArrayList<Brand>();
    brands.add(new Brand(1,"Bmw"));
    brands.add(new Brand(2,"Mercedes"));
    brands.add(new Brand(3,"Opel"));
    brands.add(new Brand(4,"Volkswagen"));
    brands.add(new Brand(5,"Tesla"));

    }

    @Override
    public List<Brand> getAll() {
        return brands;
    }

}
