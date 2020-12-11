package ru.geekbrains.mini.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.mini.market.entites.Book;

@Data
@NoArgsConstructor
@ApiModel(description = "Book dto in the application.")
public class BookDto {
    @ApiModelProperty(notes = "Unique identifier of the product. No two books can have the same id.", example = "1", required = true, position = 0)
    private Long id;

    @ApiModelProperty(notes = "Title of the book.", example = "Robinson Crusoe", required = true, position = 1)
    private String title;

    @ApiModelProperty(notes = "Price of the book.", example = "300", required = true, position = 2)
    private int price;

    @ApiModelProperty(notes = "Author title of the book.", example = "Daniel Defoe", required = true, position = 3)
    private String authorName;

    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.price = book.getPrice();
        this.authorName = book.getAuthor().getTitle();
    }
}
