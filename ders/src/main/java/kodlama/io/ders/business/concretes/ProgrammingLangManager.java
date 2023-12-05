package kodlama.io.ders.business.concretes;

import kodlama.io.ders.business.abstracts.ProgrammingLangService;
import kodlama.io.ders.dataAccess.abstracts.ProgrammingLangRepository;
import kodlama.io.ders.entities.concretes.ProgrammingLang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProgrammingLangManager implements ProgrammingLangService {
    private final ProgrammingLangRepository programmingLangRepository;

    @Autowired
    public ProgrammingLangManager(ProgrammingLangRepository programmingLangRepository) {
        this.programmingLangRepository = programmingLangRepository;
    }

    @Override
    public List<ProgrammingLang> getall() {
        return programmingLangRepository.getall();
    }

    @Override
    public void add(ProgrammingLang programmingLang) throws Exception {
        for (ProgrammingLang a : programmingLangRepository.getall()) {
            if (!(a.getKursAd().isEmpty())) {
                if (a.getKursAd().equals(programmingLang.getKursAd())) {
                    throw new Exception("Bu isim kullanılmıştır : " + programmingLang.getKursAd());
                }
            }
        }

        programmingLangRepository.add(programmingLang);

        }

        @Override
        public void update(ProgrammingLang programmingLang){
        programmingLangRepository.update(programmingLang);

        }

        @Override
        public void delete(ProgrammingLang programmingLang){
         programmingLangRepository.delete(programmingLang);

        }

        @Override
        public void getById(int id) {
            programmingLangRepository.getById(id);

        }
    }

