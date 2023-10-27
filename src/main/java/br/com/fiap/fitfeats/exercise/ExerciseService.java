package br.com.fiap.fitfeats.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    ExerciseRepository exerciseRepository;

    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    public void delete(Long id) {
        exerciseRepository.deleteById(id);
    }

    public void create(Exercise exercise) { exerciseRepository.save(exercise); }

}
