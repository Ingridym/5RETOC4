package com.cuatroa.retodos.repository;

import com.cuatroa.retodos.model.CleaningProduct;
import com.cuatroa.retodos.repository.crud.CleaningCrudProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ingrid Moncayo
 */
@Repository
public class CleaningProductRepository {

    @Autowired
    private CleaningCrudProductRepository repository;

    public List<CleaningProduct> getAll() {
        return repository.findAll();
    }

    public Optional<CleaningProduct> getProduct(String reference) {
        return repository.findById(reference);
    }

    public CleaningProduct create(CleaningProduct cosmetic) {
        return repository.save(cosmetic);
    }

    public void update(CleaningProduct cosmetic) {
        repository.save(cosmetic);
    }

    public void delete(CleaningProduct cosmetic) {
        repository.delete(cosmetic);
    }

    public List<CleaningProduct> productByPrice(double precio) {
        return repository.findByPriceLessThanEqual(precio);
    }

    //Reto 5
    public List<CleaningProduct> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }
}
