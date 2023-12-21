package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> //Table adı ve primary key olan entitynin tipi(Integer)
{
    boolean existsByName(String name); //jpa cevabı T/F olan bi sorgu döndürür arka planda

}
