package edu.cmu.DirManager;

public class Manager {
    private DirOps dirOps;
    
    /**
     * Creates a new directory at the specified path.
     *
     * @param path the path where the new directory should be created
     * @return 0 if the directory creation was successful
     *        -1 if the directory already exists,
     *        -2 if the path is invalid
     */

    // Q4: prevent failure or fail fast
    // should checkPathValid first before checkDirectoryExists
    public void newDirectory(String path) {
        if (!dirOps.checkPathValid(path)) {
            throw new IllegalArgumentException("Invalid path: " + path);
        } else if (dirOps.checkDirectoryExists(path)) {
            throw new IllegalStateException("Directory already exists at: " + path);
        } else {
            dirOps.createDirectory(path);
        }
    }
}
