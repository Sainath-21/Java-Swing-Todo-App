import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoApp {
    public static void main(String[] args) {
        // Create main frame
        JFrame frame = new JFrame("To-Do App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create components
        JTextField taskField = new JTextField(20);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");

        // Top panel with input and buttons
        JPanel topPanel = new JPanel();
        topPanel.add(taskField);
        topPanel.add(addButton);
        topPanel.add(deleteButton);

        // Add task action
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    taskField.setText("");
                }
            }
        });

        // Delete task action
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = taskList.getSelectedIndex();
                if (index != -1) {
                    listModel.remove(index);
                }
            }
        });

        // Layout setup
        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Show frame
        frame.setVisible(true);
    }
}
