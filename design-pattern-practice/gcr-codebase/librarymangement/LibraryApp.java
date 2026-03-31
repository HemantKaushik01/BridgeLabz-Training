package com.librarymangement;

public class LibraryApp {
public static void main(String[] args) {
LibraryCatalog catalog = LibraryCatalog.getInstance();
User student = UserFactory.createUser("student", "Hemant");
User faculty = UserFactory.createUser("faculty", "Bhaskar");
User student1 = UserFactory.createUser("student", "Hemant");
User faculty1 = UserFactory.createUser("faculty", "Bhaskar");
catalog.addObserver(student);
catalog.addObserver(faculty);
catalog.addObserver(student1);
catalog.addObserver(faculty1);
Book book1 = new Book.BookBuilder("ClassNotes")
.author("Dr. Shardul")
.edition("200nd")
.genre("Software Eng.")
.build();
Book book2 = new Book.BookBuilder("ClassNotes2")
.author("Dr. Shardul")
.edition("200nd")
.genre("Software Eng.")
.build();
catalog.addBook(book1);
catalog.addBook(book2);
}
}