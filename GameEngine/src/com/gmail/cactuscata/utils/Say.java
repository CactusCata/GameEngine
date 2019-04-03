package com.gmail.cactuscata.utils;

import javax.swing.JOptionPane;

public class Say {

	public static String inputMessage(String message) {
		return JOptionPane.showInputDialog(message);
	}

	public static void sendMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
//		InformationMessage inforMesag = new InformationMessage(message);
//		inforMesag.setVisible(true);
	}

}
