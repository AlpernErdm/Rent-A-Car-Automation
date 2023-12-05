package kodlama.io.ders.dataAccess.concretes;

import kodlama.io.ders.dataAccess.abstracts.ProgrammingLangRepository;
import kodlama.io.ders.entities.concretes.ProgrammingLang;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryRepository implements ProgrammingLangRepository {
    List<ProgrammingLang> programmingLangs;

    public InMemoryRepository() {
    programmingLangs= new ArrayList<ProgrammingLang>();
    programmingLangs.add(new ProgrammingLang(1,"Java"));
    programmingLangs.add(new ProgrammingLang(2,"C#"));
    programmingLangs.add(new ProgrammingLang(3,"C"));


    }

    @Override
    public void add(ProgrammingLang programmingLang) {
        programmingLangs.add(programmingLang);
    }

    @Override
    public void update(ProgrammingLang programmingLang) {
        programmingLangs.add(programmingLang);
    }

    @Override
    public void delete(ProgrammingLang programmingLang) {
        programmingLangs.remove(programmingLang);
    }

    @Override
    public List<ProgrammingLang> getall() {
        return programmingLangs;
    }

    @Override
    public ProgrammingLang getById(int id) {
        return programmingLangs.get(id);
    }
}
