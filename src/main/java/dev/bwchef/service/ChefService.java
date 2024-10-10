package dev.bwchef.service;

import dev.bwchef.dto.ChefDTO;
import dev.bwchef.model.Chef;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChefService {

    @PersistenceContext
    private EntityManager em;

    // 모든 Chef 찾기 (엔티티 → DTO 변환)
    public List<ChefDTO> findAll() {
        List<Chef> chefs = em.createQuery("SELECT c FROM Chef c", Chef.class).getResultList();
        return chefs.stream().map(this::toDTO).collect(Collectors.toList());
    }

    // ID로 특정 Chef 찾기 (엔티티 → DTO 변환)
    public ChefDTO findById(Long id) {
        Chef chef = em.find(Chef.class, id);
        return toDTO(chef);
    }

    // 새로운 Chef 추가 (DTO → 엔티티 변환)
    @Transactional
    public ChefDTO save(ChefDTO chefDTO) {  // DTO로 변경
        Chef chef = toEntity(chefDTO);  // DTO를 엔티티로 변환
        em.persist(chef);
        return toDTO(chef);  // 저장 후 엔티티를 다시 DTO로 반환
    }

    // Chef 삭제
    @Transactional
    public void delete(Long id) {
        Chef chef = em.find(Chef.class, id);
        if (chef != null) {
            em.remove(chef);
        }
    }

    // 엔티티를 DTO로 변환하는 메서드
    private ChefDTO toDTO(Chef chef) {
        ChefDTO dto = new ChefDTO();
        dto.setId(chef.getId());
        dto.setName(chef.getName());
        dto.setTheme(chef.getTheme());  // theme을 직접 문자열로 받음
        return dto;
    }

    // DTO를 엔티티로 변환하는 메서드
    private Chef toEntity(ChefDTO dto) {  // ChefDTO로 변경
        Chef chef = new Chef();
        chef.setId(dto.getId());  // 만약 ID가 자동 생성이라면, 이 부분 생략 가능
        chef.setName(dto.getName());
        chef.setTheme(dto.getTheme());  // theme도 직접 설정
        return chef;
    }
}