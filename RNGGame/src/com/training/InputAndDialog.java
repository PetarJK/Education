package com.training;

import javax.swing.*;

public class InputAndDialog {

    public void dialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public String inputDialog(String inputDialog) {
        return JOptionPane.showInputDialog(inputDialog);
    }
}
