import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

public class ExplorerFrame {
    public static DefaultMutableTreeNode root;
    public static void explorerFrame() {
        SwingUtilities.invokeLater(() -> {

            // Create JFrame
            JFrame frame = new JFrame();
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create JTree
            root = new DefaultMutableTreeNode("Root");
            JTree tree = new JTree(root);

            // Add tree to JScrollPane
            JScrollPane scrollPane = new JScrollPane(tree);

            // Add JScrollPane to JFrame via ContentPane
            frame.getContentPane().add(scrollPane);

            // Set JFrame visible
            frame.setVisible(true);

            FileTree fileTree = new FileTree();

            // Populate tree with files and folders recursively
            File[] drives = File.listRoots();
            for(File drive : drives) {
                DefaultMutableTreeNode driveNode = new DefaultMutableTreeNode(drive);
                root.add(driveNode);
                fileTree.getFileTreeObject(drive);
            }

            // Get Directory Tree for only specified path. Testing purposes.
            // fileTree.getFileTree(root, new File("C://Users//Siddhesh//Desktop"));

        });
    }
}
