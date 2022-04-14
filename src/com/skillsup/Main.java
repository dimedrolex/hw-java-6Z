package com.skillsup;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        library.takeBook(LocalDate.of(2020, 10, 12), "Harry Potter");
        library.takeBook(LocalDate.of(2020, 10, 12), "Lord Of The Rings");
        library.takeBook(LocalDate.of(2020, 10, 12), "Around The World in 80 days");
        library.takeBook(LocalDate.of(2020, 7, 7), "Harry Potter 4");
        library.takeBook(LocalDate.of(2020, 5, 8), "Harry Potter 5");
        System.out.println(library.findBooks(LocalDate.of(2020, 10, 12)));
        System.out.println(library.takenBooksDatesRange());
        System.out.println(library.allTakenBooks());
    }
}

class Library {

    private final Map<LocalDate, List<String>> dateOnBooks = new TreeMap<>();

    public String takeBook(LocalDate date, String bookName) {
        List<String> booksByDate = dateOnBooks.get(date);
        if (booksByDate == null) {
            booksByDate = new ArrayList<>();
            booksByDate.add(bookName);
            dateOnBooks.put(date, booksByDate);
        } else {
            booksByDate.add(bookName);
        }
        return bookName;
    }

    public List<String> findBooks(LocalDate date) {
        List<String> booksByDate = dateOnBooks.get(date);
        if (booksByDate == null) {
            System.out.println("No books for chosen date");
        }
        return booksByDate;
    }

    public Set<LocalDate> takenBooksDatesRange() {
        return dateOnBooks.keySet();
    }

    public List<String> allTakenBooks() {
        List<String> allTakenBooks = new ArrayList<>();
        for (List<String> books : dateOnBooks.values()) {
            allTakenBooks.addAll(books);
        }
        return allTakenBooks;
    }
}

