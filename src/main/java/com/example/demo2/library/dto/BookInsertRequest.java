package com.example.demo2.library.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class BookInsertRequest {


    private final String title;
    private final String author;
    private final int prive;

    @JsonCreator
    public BookInsertRequest(@JsonProperty("title") String title, @JsonProperty("author") String author, @JsonProperty("price") int prive) {
        this.title = title;
        this.author = author;
        this.prive = prive;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrive() {
        return prive;
    }

    @Override
    public String toString() {
        return "BookInsertRequest{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", prive=" + prive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookInsertRequest that = (BookInsertRequest) o;
        return prive == that.prive &&
                Objects.equals(title, that.title) &&
                Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, author, prive);
    }
}
