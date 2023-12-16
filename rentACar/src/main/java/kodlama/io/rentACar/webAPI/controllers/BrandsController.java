package kodlama.io.rentACar.webAPI.controllers;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation
@RequestMapping("/api/brands") //api çağırırken bu adresle çağıracağız
public class BrandsController {
    private final BrandService brandService;

    @Autowired //brandsControllerın parametresi olan brandservice'i implement edenleri bana new'le ver
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }
    @GetMapping()
    public List<GetAllBrandsResponse> getAll()  {
        return  brandService.getAll();
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)//201 döndürmesi için
    public void add(@RequestBody CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }
    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }
}
