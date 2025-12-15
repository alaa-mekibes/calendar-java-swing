package util;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MsgHandler {

    public static void showError(JDialog dialog, String message) {
        JOptionPane.showMessageDialog(dialog, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void showSuccess(JDialog dialog, String message) {
        JOptionPane.showMessageDialog(dialog, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showWarning(JDialog dialog, String message) {
        JOptionPane.showMessageDialog(dialog, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public static void showInfo(JPanel panel, String message) {
        JOptionPane.showMessageDialog(panel, message, "info", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showSuccess(JPanel panel, String message) {
        JOptionPane.showMessageDialog(panel, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showError(JPanel panel, String message) {
        JOptionPane.showMessageDialog(panel, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public static void showSuccess(JFrame frame, String message) {
        JOptionPane.showMessageDialog(frame, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showError(JFrame frame, String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
