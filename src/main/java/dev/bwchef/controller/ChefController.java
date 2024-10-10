package dev.bwchef.controller;

import dev.bwchef.dto.ChefDTO;
import dev.bwchef.model.Chef;
import dev.bwchef.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chefs")
public class ChefController {

    @Autowired
    private ChefService chefService;

    // 모든 Chef 조회
    @GetMapping
    public List<ChefDTO> getAllChefs() {
        return chefService.findAll();
    }

    // Chef 추가
    @PostMapping
    public ChefDTO createChef(@RequestBody ChefDTO chefDTO) {
        return chefService.save(chefDTO);  // DTO를 받아서 처리
    }

    // 특정 ID의 Chef 조회
    @GetMapping("/{id}")
    public ResponseEntity<ChefDTO> getChefById(@PathVariable Long id) {
        ChefDTO chef = chefService.findById(id);
        return ResponseEntity.ok(chef);
    }

    // Chef 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChef(@PathVariable Long id) {
        chefService.delete(id);
        return ResponseEntity.noContent().build();
    }
}