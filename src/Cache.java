import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Cache {
    public void directoryCache() throws IOException {

        // Create FileTree object
        FileTree fileTree = new FileTree();

        // Initialize File and Object Output Stream
        FileOutputStream fileOut = new FileOutputStream("DirectoryCache.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        // Write Directory Tree as Byte Stream object
        out.writeObject(fileTree.getFileTreeObject(new File("C://Program Files (x86)")));

        // Close processes
        out.close();
        fileOut.close();
    }
}
