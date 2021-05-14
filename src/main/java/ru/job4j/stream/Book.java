package ru.job4j.stream;

public class Book {
    private String name;
    private String author;
    private int year;
    private int pages;
    private String isbn;
    private String eBook;
    private boolean published;

    static class Builder {
        private String name;
        private String author;
        private int year;
        private int pages;
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

        Builder buildYear(int year) {
            this.year = year;
            return this;
        }

        Builder buildPages(int pages) {
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
                .buildYear(1988)
                .buildPages(272)
                .buildIsbn("0-340-49353-4")
                .buildEBook("https://www.fantasticfiction.com/a/jeffrey-archer/twist-in-tale.htm")
                .buildPublished(true)
                .build();
        System.out.println(book);
    }

    @Override
    public String toString() {
        return "BOOK CARD"
                + System.lineSeparator()
                + "name:      " + name
                + System.lineSeparator()
                + "author:    " + author
                + System.lineSeparator()
                + "year:      " + year
                + System.lineSeparator()
                + "pages:     " + pages
                + System.lineSeparator()
                + "isbn:      " + isbn
                + System.lineSeparator()
                + "ebook:     " + eBook
                + System.lineSeparator()
                + "published: " + published;
    }
}

