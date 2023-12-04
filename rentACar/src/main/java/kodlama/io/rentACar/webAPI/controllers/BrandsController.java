package kodlama.io.rentACar.webAPI.controllers;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //annotation
@RequestMapping("/api/brands") //api çağırırken bu adresle çağıracağız
public class BrandsController {
    private final BrandService brandService;

    @Autowired //brandsControllerın parametresi olan brandservice'i implement edenleri bana new'le ver
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }
    @GetMapping("/getAll")
    public List<Brand> getAll(){
        return  brandService.getAll();
    }
}
