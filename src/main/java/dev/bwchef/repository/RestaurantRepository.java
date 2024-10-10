package dev.bwchef.repository;

import dev.bwchef.model.Restaurant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RestaurantRepository {

    @PersistenceContext
    private EntityManager em;

    // 전체 레스토랑 조회
    public List<Restaurant> findAll() {
        return em.createQuery("select r from Restaurant r", Restaurant.class).getResultList();
    }

    // id로 레스토랑 조회
    public Optional<Restaurant> findById(Long id) {
        return Optional.ofNullable(em.find(Restaurant.class, id));
    }

    // 저장
    public Restaurant save(Restaurant restaurant) {
        em.persist(restaurant);
        return restaurant;
    }

    // 삭제
    public void delete(Restaurant restaurant) {
        em.remove(restaurant);
    }
}
