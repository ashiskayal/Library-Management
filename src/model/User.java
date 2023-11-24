package model;

import Statics.StaticMethods;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

public class User {
    private String name;
    private Set<Book> books;
    private String booksNamePath;

    public User(String name) {
        this.name = name;
        this.books = new HashSet<>();
        this.booksNamePath = StaticMethods.getUserBooksFileName(this.name);
    }

    public User(String name, String booksNamePath) {
        this.name = name;
        this.booksNamePath = booksNamePath;
    }

    public String getBooksNamePath() {
        return booksNamePath;
    }

    public void setBooksNamePath(String booksNamePath) {
        this.booksNamePath = booksNamePath;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        if(this.books == null) this.books = new HashSet<>();
        this.books.add(book);
    }
    
    public void addAllBooks(Set<Book> books) {
        if(this.books == null) {
            this.books = books;
            return;
        }
        this.books.addAll(books);
    }

    public void removeBook(Book book) {
        if(this.books != null) this.books.remove(book);
    }

    /**
     * @param pos is 1 based not 0 based
     */
    public void removeBook(int pos) {
        if(pos <= this.books.size()) this.books.remove(pos-1);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
