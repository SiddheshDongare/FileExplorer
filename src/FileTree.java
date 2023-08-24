import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.io.Serializable;

public class FileTree implements Serializable {

    public DefaultMutableTreeNode getFileTreeObject(File directory) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(directory.getName());
        getFileTree(root, directory);
        return root;
    }

    public void getFileTree(DefaultMutableTreeNode root, File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                DefaultMutableTreeNode subNode = new DefaultMutableTreeNode(file.getName());
                root.add(subNode);
                System.out.println(file.getName());
                if (file.isDirectory()) {
                    getFileTree(subNode, file);
                }
            }
        }
    }

}
