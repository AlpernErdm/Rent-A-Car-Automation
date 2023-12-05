package kodlama.io.ders.business.abstracts;

import kodlama.io.ders.entities.concretes.ProgrammingLang;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProgrammingLangService {
    List<ProgrammingLang> getall();
    void add(ProgrammingLang programmingLang) throws Exception;
    void update(ProgrammingLang programmingLang);
    void delete(ProgrammingLang programmingLang);
    void getById(int id);

}
