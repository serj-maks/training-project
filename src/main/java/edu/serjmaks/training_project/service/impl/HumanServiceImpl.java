package edu.serjmaks.training_project.service.impl;

import edu.serjmaks.training_project.exception.AlreadyExistsException;
import edu.serjmaks.training_project.exception.NotFoundException;
import edu.serjmaks.training_project.mapper.HumanMapper;
import edu.serjmaks.training_project.model.Human;
import edu.serjmaks.training_project.model.Task;
import edu.serjmaks.training_project.repository.HumanRepository;
import edu.serjmaks.training_project.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HumanServiceImpl implements HumanService {

    private final HumanRepository humanRepository;
    private final HumanMapper humanMapper;

    @Override
    public Human getById(Integer id) {
        return humanRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Human.class, id));
    }

    @Override
    public List<Human> getAll() {
        return humanRepository.findAll();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public Human create(Human human) {
        if (humanRepository.existsByAge(human.getAge())) {
            throw new AlreadyExistsException(Human.class, human.getAge());
        }
        if (humanRepository.existsByName(human.getName())) {
            throw new AlreadyExistsException(Human.class, human.getName());
        }
        return humanRepository.save(human);
    }

    @Transactional
    @Override
    @Retryable(maxAttempts = 15)
    public Human update(Human newHuman, Integer id) {
        Human human = getById(id);
        humanMapper.updateHuman(newHuman, human);
        return humanRepository.save(human);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        if (!humanRepository.existsById(id)) {
            throw new NotFoundException(Human.class, id);
        }
        humanRepository.deleteById(id);
    }
}
