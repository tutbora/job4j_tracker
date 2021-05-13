package ru.job4j.stream;

import java.util.Locale;

public class Book {
    private String name;
    private String author;
    private byte year;
    private byte pages;
    private String isbn;
    private String eBook;
    private boolean published;

    static class Builder {
        private String name;
        private String author;
        private byte year;
        private byte pages;
        private String isbn;
        private String eBook;
        private boolean published;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildAuthor(String author) {
            this.author = author;
            return this;
        }

        Builder buildYear(byte year) {
            this.year = year;
            return this;
        }

        Builder buildPages(byte pages) {
            this.pages = pages;
            return this;
        }

        Builder buildIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        Builder buildEBook(String eBook) {
            this.eBook = eBook;
            return this;
        }

        Builder buildPublished(boolean published) {
            this.published = published;
            return this;
        }

    Book build() {
        Book book = new Book();
        book.name = name;
        book.author = author;
        book.year = year;
        book.pages = pages;
        book.isbn = isbn;
        book.eBook = eBook;
        book.published = published;
        return book;
    }

}

        public static void main(String[] args) {
            Book book = new Builder()
                    .buildName("A Twist in the Tale")
                    .buildAuthor("Jeffrey Archer")
                    .buildYear((byte) 1988)
                    .buildPages((byte) 272)
                    .buildIsbn("0-340-49353-4")
                    .buildEBook("https://www.fantasticfiction.com/a/jeffrey-archer/twist-in-tale.htm")
                    .buildPublished(true)
                    .build();
            System.out.println(book);
        }
}
