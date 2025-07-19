package edu.serjmaks.training_project.test.service.impl;

import edu.serjmaks.training_project.test.exception.AlreadyExistsException;
import edu.serjmaks.training_project.test.exception.NotFoundException;
import edu.serjmaks.training_project.test.mapper.HumanMapper;
import edu.serjmaks.training_project.test.model.Human;
import edu.serjmaks.training_project.test.repository.HumanRepository;
import edu.serjmaks.training_project.test.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HumanServiceImpl implements HumanService {
    private final HumanRepository humanRepository;
    private final HumanMapper humanMapper;

    @Override
    public Human getById(Long id) {
        return humanRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Human.class, id));
    }

    @Override
    public List<Human> getAll() {
        return humanRepository.findAll();
    }

    @Override
    @Transactional
    public Human create(Human human) {
        if (humanRepository.existsByName(human.getName()) || humanRepository.existsByAge(human.getAge())) {
            throw new AlreadyExistsException(Human.class, human.getName());
        }

        return humanRepository.save(human);
    }

    @Override
    @Transactional
    public Human update(Human newHuman, Long id) {
        Human human = getById(id);
        Human updatedHuman = humanMapper.update(newHuman, human);
        return humanRepository.save(updatedHuman);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!humanRepository.existsById(id)) {
            throw new NotFoundException(Human.class, id);
        }

        humanRepository.deleteById(id);
    }
}
