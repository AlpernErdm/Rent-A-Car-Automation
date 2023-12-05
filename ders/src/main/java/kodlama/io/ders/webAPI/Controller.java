package kodlama.io.ders.webAPI;

import kodlama.io.ders.business.abstracts.ProgrammingLangService;
import kodlama.io.ders.entities.concretes.ProgrammingLang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ders")
public class Controller {
    private final ProgrammingLangService programmingLangService;
@Autowired
    public Controller(ProgrammingLangService programmingLangService) {
        this.programmingLangService = programmingLangService;
    }

    @GetMapping("/getAll")
    public List<ProgrammingLang> getAll(){
        return programmingLangService.getall();

    }

    @PostMapping("/add")
    public void add(@RequestBody ProgrammingLang programmingLang) throws Exception {
        programmingLangService.add(programmingLang);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody ProgrammingLang programmingLang) {
        programmingLangService.delete(programmingLang);
    }

    @PostMapping("/update")
    public void update(@RequestBody ProgrammingLang programmingLang) {
        programmingLangService.update(programmingLang);
    }

    @GetMapping("/getbyid")
    public void getById(int id) {
        programmingLangService.getById(id);
    }

}
