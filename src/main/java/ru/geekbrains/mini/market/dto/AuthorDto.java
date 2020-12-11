package ru.geekbrains.mini.market.dto;

import io.swagger.annotations.ApiModelProperty;
import ru.geekbrains.mini.market.entites.Author;

public class AuthorDto {
    @ApiModelProperty(notes = "Unique identifier of the author. No two authors can have the same id.", example = "1", required = true, position = 0)
    private Long id;

    @ApiModelProperty(notes = "Authors name.", example = "Sir Arthur Ignatius Conan Doyle", required = true, position = 1)
    private String title;

    @ApiModelProperty(notes = "Books count.", example = "3", required = true, position = 2)
    private Integer bookCount;

    public AuthorDto(Author author) {
        this.id = author.getId();
        this.title = author.getTitle();
        this.bookCount = author.getBooks().size();
    }
}
