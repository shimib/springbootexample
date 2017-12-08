package com.example.demo2.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
ADD the following REST APIs:
1) get a book by title (returns a JSON)
2) insert a book
3) update the price of a book
4) delete a book
http://tinyurl.com/hibhib/
spring_mvc_example.tgz
 */
@RestController
public class LibraryController {

    private final BookDao dao;

    private final ExecutorService es;

    @Autowired
    public LibraryController(BookDao dao, ExecutorService es) {
        this.dao = dao;
        this.es = es;
    }

    @RequestMapping(path = "/populate", method = RequestMethod.POST)
    public DeferredResult<Integer> populateLibrary() {
        DeferredResult<Integer> dr = new DeferredResult<>();

        es.submit(() -> {
            List<Book> books = Arrays.asList(new Book("Java_Programming", "Joesling", 50),
                    new Book("Spring_Development", "Rod Johnson", 70),
                    new Book("Harry_Potter", "JK", 100));
            dao.save(books);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dr.setResult(1);

        });
        return dr;
    }

    @RequestMapping(path = "/show", method = RequestMethod.GET, produces = "application/json")
    public Callable<List<Book>> getAll() {
        return dao::findAll;
        // return () -> dao.findAll();

//        new Callable<List<Book>>() {
//            @Override
//            public List<Book> call() throws Exception {
//                return dao.getBookByTitle(title);
//            }
//        }
    }


}
