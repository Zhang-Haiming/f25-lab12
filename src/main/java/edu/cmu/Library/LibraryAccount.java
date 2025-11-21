package edu.cmu.Library;

public class LibraryAccount {
    private LibraryService libraryService;
 
    /**
     * Retrieves an array of checked out books associated with the specified user ID. If the user
     * has no books checked out, the returned list will be empty. Since multiple households may
     * share a single account, the user ID is of the form "libraryID:userName".
     * e.g., "12345:John Doe"
     *
     * @param userId the ID of the user whose books are to be retrieved
     * @return an array of Book objects the user has checked out
     */

    // violate Q3: Make it easy for user to do what is preferable
    // violate Q4: Prevent failure
    // name and id are swapped
    // should check userID format first
    public Book[] getBooks(String userId) {
        if(userId == null || !userId.contains(":")) {
            throw new IllegalArgumentException("Invalid userId format");
        }
        String[] parts = userId.split(":");
        if(parts.length != 2) {
            throw new IllegalArgumentException("Invalid userId format");
        }
        String name = parts[1];
        String id = parts[0];
        return libraryService.getBooks(name, id);        
    }
}
