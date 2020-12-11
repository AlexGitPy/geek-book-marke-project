package ru.geekbrains.mini.market.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.mini.market.dto.AuthorDto;
import ru.geekbrains.mini.market.entites.Author;
import ru.geekbrains.mini.market.exceptions.ResourceNotFoundException;
import ru.geekbrains.mini.market.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
@Api("Set of endpoints for authors")
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @ApiOperation("Returns all authors")
    public List<Author> getAllAuthor() {
        return authorService.getAllAuthor();
    }

    //GET http://localhost:9999/market/api/v1/authors/1
    @GetMapping("/{id}")
    @ApiOperation("Returns a specific author by their identifier. 404 if does not exist.")
    public AuthorDto getProductById(@ApiParam("Id of the book to be obtained. Cannot be empty.") @PathVariable Long id) {
        Author author = authorService.getOneById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find author with id: " + id));
        return new AuthorDto(author);
    }
}
