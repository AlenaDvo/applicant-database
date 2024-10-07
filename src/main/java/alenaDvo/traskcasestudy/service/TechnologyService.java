package alenaDvo.traskcasestudy.service;

import alenaDvo.traskcasestudy.entity.TechnologyEntity;
import alenaDvo.traskcasestudy.repository.TechnologyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {
    private final TechnologyRepository technologyRepository;

    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    public List<TechnologyEntity> findAll() {
        return technologyRepository.findAll();
    }

    public TechnologyEntity findById(Long id) {
        return technologyRepository.findById(id).orElse(null);
    }

    public TechnologyEntity create(TechnologyEntity technologyEntity) {
        return technologyRepository.save(technologyEntity);
    }

    public boolean existsById(Long id) {
        return technologyRepository.existsById(id);
    }

    public TechnologyEntity update(TechnologyEntity technologyEntity) {
        return technologyRepository.save(technologyEntity);
    }

    public void deleteById(Long id) {
        technologyRepository.deleteById(id);
    }
}
