package com.dale.ladder;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.dale.ladder.data.MyData;

public class MainGameFrame extends JFrame {
	private static final String TITLE = "사다리 타기";
	
	private FirstInputPanel firstInputPanel;
	private SetComponent setComponentPanel;
	public static void main(String[] args) {
		MainGameFrame mainFrame = new MainGameFrame();
		mainFrame.run();
	}
	
	MainGameFrame(){
		firstInputPanel = new FirstInputPanel();
		setComponentPanel = new SetComponent();
		setSize(1080, 504);
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
	}
	private void run() {
		this.setVisible(true);
		
		firstInputPanel.getGoToNext().addActionListener(new ToSetComponetPanel());
		this.add(firstInputPanel);
	}
	
	class ToSetComponetPanel implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MyData.setOneWidth(720/(MyData.getPeopleNumber()));
			MyData.setOneHeight(360/(MyData.getBridgeNumber()));
			setComponentPanel.createPanel();
			MainGameFrame.this.firstInputPanel.getNumberOfPeople().setText("");
			MainGameFrame.this.firstInputPanel.getNumberOfBranch().setText("");
			MainGameFrame.this.getContentPane().removeAll();
			MainGameFrame.this.getContentPane().add(setComponentPanel);
			revalidate();
			repaint();
		}
	}
}
