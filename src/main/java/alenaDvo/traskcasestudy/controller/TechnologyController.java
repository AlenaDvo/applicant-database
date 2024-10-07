package alenaDvo.traskcasestudy.controller;

import alenaDvo.traskcasestudy.entity.TechnologyEntity;
import alenaDvo.traskcasestudy.service.TechnologyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
    private final TechnologyService technologyService;

    @Autowired
    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping
    public List<TechnologyEntity> getAll() {
        return technologyService.findAll();
    }

    @GetMapping("/{id}")
    public TechnologyEntity getById(@PathVariable Long id) {
        return technologyService.findById(id);
    }

    @PostMapping
    public ResponseEntity<TechnologyEntity> create(@Valid @RequestBody TechnologyEntity technologyEntity) {
        TechnologyEntity createdTechnologyEntity = technologyService.create(technologyEntity);
        return new ResponseEntity<>(
                createdTechnologyEntity,
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnologyEntity> updateById(@PathVariable Long id, @Valid @RequestBody TechnologyEntity technologyEntity) {
        if (!technologyService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            technologyEntity.setId(id); // ignoring the id in the request body
            TechnologyEntity updatedTechnologyEntity = technologyService.update(technologyEntity);
            return ResponseEntity.ok(updatedTechnologyEntity);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@Valid @PathVariable Long id) {
        if (!technologyService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Technology with id " + id + " does not exist.");
        } else {
            technologyService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }
}