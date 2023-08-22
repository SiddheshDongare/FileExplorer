import java.io.*;
import javax.swing.*;
import javax.swing.tree.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create JFrame
            JFrame frame = new JFrame();
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create JTree
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
            JTree tree = new JTree(root);

            // Add tree to JScrollPane
            JScrollPane scrollPane = new JScrollPane(tree);

            // Add JScrollPane to JFrame
            frame.getContentPane().add(scrollPane);

            // Set JFrame visible
            frame.setVisible(true);

            // Populate tree with files and folders recursively
            File[] drives = File.listRoots();
            for (File drive : drives){
                DefaultMutableTreeNode driveNode = new DefaultMutableTreeNode(drive);
                root.add(driveNode);
                getFileTree(driveNode, drive);
            }
        });
    }

    private static void getFileTree(DefaultMutableTreeNode root, File directory) {
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
