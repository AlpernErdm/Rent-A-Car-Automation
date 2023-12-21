package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {
    @NotNull //Boş geçemez
    @NotBlank //Boşluk ekleyemez
    @Size(min = 2,max = 20)
    private String name;
    @NotBlank //Boşluk ekleyemez
    @Size(min = 2,max = 20)
    private int brandId ;
}
