package edu.serjmaks.training_project.controller;

import edu.serjmaks.training_project.model.Cat;
import edu.serjmaks.training_project.service.CatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cat")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    //в параметрах метода нужно указывать именно объект Integer, несмотря на то, что поле в классе Cat
    //имеет примитивный тип int
    public Cat get(@PathVariable Integer id) {
        log.debug("getById - start: id = {}", id);

        Cat result = catService.get(id);

        log.debug("getById - end: result = {}", result);
        return result;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cat> getAll() {
        log.debug("getAll - start");

        List<Cat> result = catService.getAll();

        log.debug("getAll - end: result = {}", result);
        return result;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Cat cat) {
        log.debug("create - start");

        catService.create(cat);

        log.debug("create - end");
        return "cat was created successfully";
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String update(@RequestBody Cat cat) {
        log.debug("update - start");

        catService.update(cat);

        log.debug("update - end");
        return "cat was updated successfully";
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    //здесь вместо @PathVariable (для примера) используется @RequestParam
    //теперь, чтобы удалить объект, нужно использовать данный URL: 'http://localhost:8080/cat?id=2'
    public String delete(@RequestParam Integer id) {
        log.debug("delete - start");

        catService.delete(id);

        log.debug("delete - end");
        return "cat was deleted successfully";
    }

    //метод для демонстрации работы аннотаций @RestControllerAdvice и @ExceptionHandler
    //поведение описано в классе exception/GlobalExceptionHandler
    @GetMapping("/testControllerAdvice")
    public void testControllerAdvice() {
        log.debug("testControllerAdvice - start");

        if (true) {
            throw new IllegalArgumentException("некорректный запрос!");
        }

        log.debug("testControllerAdvice - end");
    }
}
