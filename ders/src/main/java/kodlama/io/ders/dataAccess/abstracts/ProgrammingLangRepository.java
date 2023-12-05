package kodlama.io.ders.dataAccess.abstracts;

import kodlama.io.ders.entities.concretes.ProgrammingLang;

import java.util.List;

public interface ProgrammingLangRepository {
    void add(ProgrammingLang programmingLang);
    void update(ProgrammingLang programmingLang);
    void delete(ProgrammingLang programmingLang);
    List<ProgrammingLang> getall();
    ProgrammingLang getById(int id);
}
