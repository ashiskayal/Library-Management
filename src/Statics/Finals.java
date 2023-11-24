package Statics;

public final class Finals {
    private Finals() {
    }

    public static final String USER_DIRECTORY_NAME = "Users";
    public static final String USERS_FILE = USER_DIRECTORY_NAME+"/users.dat";
    public static final String USER_BOOKS = USER_DIRECTORY_NAME+"/UserBooks"; // File name will be added in the code, file name should contain the user's id

    public static final String BOOK_DIRECTORY_NAME = "Books";
    public static final String BOOKS_FILE = BOOK_DIRECTORY_NAME+"/books.dat";

    public static final String MAIN_MENU = """
            1. Add Book
            2. Add User
            3. Return Book
            4. Borrow Book
            5. Display Books
            6. Display Users
            7. Exit
            Choose option: """;



}
