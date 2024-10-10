package dev.bwchef.repository;

import dev.bwchef.model.Menu;
import dev.bwchef.model.MenuType;
import dev.bwchef.model.Restaurant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class MenuRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional // 식당에 맞는 메뉴만 줘야함
    public List<Menu> findAllByRestaurantId(int restaurantId) {
        TypedQuery<Menu> query = em.createQuery("SELECT m FROM Menu m WHERE m.restaurant.id = :restaurantId", Menu.class);
        query.setParameter("restaurantId", restaurantId); // 파라미터 설정
        return query.getResultList();
    }

    @Transactional
    public List<Menu> findAllByRestaurantIdAndMenuType(int restaurantId, MenuType menuType) {
        TypedQuery<Menu> query = em.createQuery("SELECT m FROM Menu m WHERE m.restaurant.id = :restaurantId AND m.menuType = :menuType", Menu.class);
        query.setParameter("restaurantId", restaurantId); // restaurantId 파라미터 설정
        query.setParameter("menuType", menuType); // menuType 파라미터 설정
        return query.getResultList();
    }

    @Transactional
    public Optional<Menu> findById(Long menuId) {
        return Optional.ofNullable(em.find(Menu.class, menuId));
    }

}
