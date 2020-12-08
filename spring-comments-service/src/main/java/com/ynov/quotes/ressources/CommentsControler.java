package com.ynov.quotes.ressources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.quotes.models.Comment;

@RestController
@RequestMapping("/quote")
public class CommentsControler {

    @RequestMapping("/{quoteID}")
    public Comment getMovieRating(@PathVariable("quoteID") String quoteID) {
        return new Comment(quoteID, "Pas mal", "Patrik");
    }

}
