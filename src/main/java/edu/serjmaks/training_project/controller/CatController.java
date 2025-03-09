package edu.serjmaks.training_project.controller;

import edu.serjmaks.training_project.model.Cat;
import edu.serjmaks.training_project.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cat")
@Controller
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    //в параметрах метода нужно указывать именно объект Integer, несмотря на то, что поле в классе Cat
    //имеет примитивный тип int
    public Cat get(@PathVariable Integer id) {
        return catService.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cat> getAll() {
        return catService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Cat cat) {
        catService.create(cat);
        return "cat was created successfully";
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String update(@RequestBody Cat cat) {
        catService.update(cat);
        return "cat was updated successfully";
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    //здесь вместо @PathVariable (для примера) используется @RequestParam
    //теперь, чтобы удалить объект, нужно использовать данный URL: 'http://localhost:8080/cat?id=2'
    public String delete(@RequestParam Integer id) {
        catService.delete(id);
        return "cat was deleted successfully";
    }
}
