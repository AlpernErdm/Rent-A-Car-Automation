package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapperService modelMapperService;
    private final BrandRepository brandRepository;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = this.modelRepository.findAll();
        return models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class)).toList();
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Brand brand = this.brandRepository.findById(createModelRequest.getBrandId()).get();

        Model model = new Model();
        model.setName(createModelRequest.getName());
        model.setBrand(brand);

        modelRepository.save(model);

    }

    @Override
    public void delete(int id) {
        this.modelRepository.deleteById(id);

    }

    @Override
    public void update(int id, UpdateModelRequest updateModelRequest, Brand brand) {
        Model model = this.modelRepository.findById(id).orElseThrow();
        model.setName(updateModelRequest.getName());

        this.modelRepository.save(model);


    }
}
