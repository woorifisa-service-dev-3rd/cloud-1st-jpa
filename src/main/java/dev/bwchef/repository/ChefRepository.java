package dev.bwchef.repository;

import dev.bwchef.model.Chef;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ChefRepository {

    @PersistenceContext
    private EntityManager em;

    // id로 셰프 조회
    public Optional<Chef> findById(Long id) {
        return Optional.ofNullable(em.find(Chef.class, id));
    }
}
