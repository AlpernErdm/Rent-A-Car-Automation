package kodlama.io.rentACar.webAPI.controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelController {
    private final ModelService modelService;
    @Autowired
    public ModelController(ModelService modelService, ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelService = modelService;
    }
    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody @Valid() CreateModelRequest createModelRequest){
        modelService.add(createModelRequest);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, UpdateModelRequest updateModelRequest, Brand brand) {
        modelService.update(id, updateModelRequest, brand);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") int id){
        modelService.delete(id);
        }

    }
