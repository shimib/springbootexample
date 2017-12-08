package com.example.demo2.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class WebController {

    private final BookDao dao;

    @Autowired
    public WebController(BookDao dao) {
        this.dao = dao;
    }

    @RequestMapping(path="/books/{title}", method = RequestMethod.GET, produces = "text/html")
    public String showBook(@PathVariable  String title, Model model) {
        Book book = dao.getBookByTitle(title);
        // TODO: on null return 404 status
        System.out.println("Book: " + book);
        model.addAttribute("book", book);
        return "displayBook";

    }

    @RequestMapping(path="/books", method = RequestMethod.GET)
    public String showBooks(Model model) {
       List<Book> books= dao.findAll();
       fj.data.List<Book> booksToRender =  fj.data.List.arrayList(books.toArray(new Book[]{}));

        model.addAttribute("books", booksToRender);
        return "showbooks";

    }



}
