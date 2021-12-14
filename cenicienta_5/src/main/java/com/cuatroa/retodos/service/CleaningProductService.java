package com.cuatroa.retodos.service;

import com.cuatroa.retodos.model.CleaningProduct;
import com.cuatroa.retodos.repository.CleaningProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Ingrid Moncayo
 */
@Service
public class CleaningProductService {

    @Autowired
    private CleaningProductRepository repository;

    public List<CleaningProduct> getAll() {
        return repository.getAll();
    }

    public Optional<CleaningProduct> getClothe(String reference) {
        return repository.getProduct(reference);
    }

    public CleaningProduct create(CleaningProduct accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return repository.create(accesory);
        }
    }

    public CleaningProduct update(CleaningProduct accesory) {

        if (accesory.getReference() != null) {
            Optional<CleaningProduct> accesoryDb = repository.getProduct(accesory.getReference());
            if (!accesoryDb.isEmpty()) {

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getBrand() != null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                if (accesory.getMaterial() != null) {
                    accesoryDb.get().setMaterial(accesory.getMaterial());
                }
                if (accesory.getPresentacion() != null) {
                    accesoryDb.get().setPresentacion(accesory.getPresentacion());
                }
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                repository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            repository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    //Reto 5
    public List<CleaningProduct> productByPrice(double price) {
        return repository.productByPrice(price);
    }

    //Reto 5
    public List<CleaningProduct> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }
}
