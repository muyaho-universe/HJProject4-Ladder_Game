package com.dale.ladder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.dale.ladder.data.MyData;

public class SetComponent extends JPanel {
	private JPanel gamePanel;
	private JTextField[] names;
	private JTextField[] targets;
	private String[] enteredName;
	private String[] enteredTarget;
	
	private int i;
	
	
	public SetComponent(){
		setBounds(0, 0, 1080, 504);
		setLayout(null);
//		createPanel();
	}
	
	public void createPanel() {
		gamePanel = new JPanel();
		gamePanel.setBounds(50, 50, 720, 360);
		
		names= new JTextField[MyData.getPeopleNumber()];
		targets= new JTextField[MyData.getPeopleNumber()];
		enteredName = new String[MyData.getPeopleNumber()];
		enteredTarget = new String[MyData.getPeopleNumber()];
		
		for(i = 0; i< MyData.getPeopleNumber(); i++) {
			names[i] = new JTextField();
			names[i].setBounds(i*MyData.getOneWidth()+ 50, 0, 50, 50);
			
			targets[i] = new JTextField();
			targets[i].setBounds(i*MyData.getOneWidth()+ 50, 410, 50, 50);
			
			this.add(names[i]);
			this.add(targets[i]);
		}
		gamePanel.setBackground(Color.WHITE);
		this.add(gamePanel);
	}
	
	@Override
	public void paintComponent(Graphics g){
	    super.paintComponent(g); // 부모 페인트호출
	    
	    
	}
	
	
}
