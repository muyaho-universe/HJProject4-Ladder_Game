package com.dale.ladder;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class MainGameFrame extends JFrame {
	private static final String TITLE = "사다리 타기";
	
	private FirstInputPanel firstInputPanel;
	
	public static void main(String[] args) {
		MainGameFrame mainFrame = new MainGameFrame();
		mainFrame.run();
	}
	
	MainGameFrame(){
		firstInputPanel = new FirstInputPanel();
		setSize(1080, 504);
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
	}
	private void run() {
		this.setVisible(true);
		
		
		this.add(firstInputPanel);
	}
}
