package com.dale.ladder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.dale.ladder.button.RoundButton;
import com.dale.ladder.data.MyData;

public class SetComponent extends JPanel {
	private JPanel blindPanel;
	private JTextField[] names;
	private JTextField[] targets;
	private String[] enteredName;
	private String[] enteredTarget;
	private JLabel[] results;
	private JPanel controlPanel;
	
	private RoundButton start;
	private RoundButton[] buttons ;
	
	private GamePanel gamePanel;
	
	private int i;
	
	private boolean isShowAll = false;
	
	public SetComponent(){
		setBounds(0, 0, 1080, 504);
		setLayout(null);
//		createPanel();
	}
	
	public void createPanel() {
		blindPanel = new JPanel();
		blindPanel.setBounds(50, 50, 770, 360);
		blindPanel.setLayout(null);
		gamePanel = new GamePanel();
		controlPanel = new JPanel();
		controlPanel.setBounds(850, 50, 150, 360);
		controlPanel.setBackground(Color.WHITE);
		names= new JTextField[MyData.getPeopleNumber()];
		targets= new JTextField[MyData.getPeopleNumber()];
		enteredName = new String[MyData.getPeopleNumber()];
		enteredTarget = new String[MyData.getPeopleNumber()];
		results = new JLabel[MyData.getPeopleNumber()];
		controlPanel.setLayout(null);
		buttons = new RoundButton[MyData.getPeopleNumber()];
		
		for(i = 0; i< MyData.getPeopleNumber(); i++) {
			names[i] = new JTextField();
			names[i].setBounds(i*MyData.getOneWidth()+50, 0, 50, 50);
			int j = i +1;
			names[i].setText(j+"");
			
			targets[i] = new JTextField();
			targets[i].setBounds(i*MyData.getOneWidth()+ 50, 410, 50, 50);
			targets[i].setText(j+"");
			this.add(names[i]);
			this.add(targets[i]);
		}
		
		start = new RoundButton("Go!");
		start.setBounds(770/4, 360/4, 770/2, 360/2);
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(i= 0; i < MyData.getBridgeNumber(); i++) {
					MyData.branches[i] = (int) (Math.random() * (MyData.getPeopleNumber()-1));
					System.out.println("i: "+MyData.branches[i]);
				}
				for(i = 0; i< MyData.getPeopleNumber(); i++) {
					buttons[i] = new RoundButton(names[i].getText()); 
					names[i].setVisible(false);
					buttons[i].setBounds(i*MyData.getOneWidth()+50, 0, 50, 50);
					targets[i].setEnabled(false);
					gamePanel.setBounds(50, 50, 770, 360);
					gamePanel.repaint();
					enteredName[i] = names[i].getText();
					enteredTarget[i] = targets[i].getText();
					System.out.println("enteredName[" +i+"]: " + enteredName[i] + " enteredTarget["+i+"]: " + enteredTarget[i]);
					MyData.peopleData.put(i, enteredName[i]);
					MyData.targetData.put(i, enteredTarget[i]);
					
					SetComponent.this.blindPanel.setVisible(false);
					SetComponent.this.start.setVisible(false);
					SetComponent.this.add(gamePanel);
					SetComponent.this.add(buttons[i]);
				}
				
				for(i = 0; i< MyData.getPeopleNumber(); i++) {
					System.out.println("원본 " +MyData.peopleData.get(i) + "는 " + MyData.targetData.get(i));
					
				}
				for(i = MyData.getBridgeNumber()-1; i>=0 ; i--) {
					String temp1 = MyData.targetData.get(MyData.branches[i]);
					String temp2 = MyData.targetData.get(MyData.branches[i]+1);
					System.out.println("temp1: " + temp1 + " temp2: "+ temp2 + " MyData.branches["+i+"] " + MyData.branches[i]);
					MyData.targetData.put(MyData.branches[i], temp2);
					MyData.targetData.put(MyData.branches[i]+1, temp1);
					System.out.println("MyData.targetData.get(MyData.branches["+i+"]) :" +MyData.targetData.get(MyData.branches[i]) + "MyData.targetData.get(MyData.branches["+i+"]+ 1) :" + MyData.targetData.get(MyData.branches[i]+1));
				}
				for(i = 0; i< MyData.getPeopleNumber(); i++) {
					results[i] = new JLabel(MyData.peopleData.get(i) + " → " + MyData.targetData.get(i));
					System.out.println(MyData.peopleData.get(i) + " → " + MyData.targetData.get(i));
					results[i].setBounds(10, 10 + 5*i, 20, 4);
					results[i].setVisible(false);
					results[i].setAlignmentX(CENTER_ALIGNMENT);
					controlPanel.add(results[i]);
				}
//				controlPanel.setLayout(new BoxLayout(controlPanel));
				controlPanel.setVisible(true);
				
				SetComponent.this.add(controlPanel);
			}
		});
		
		RoundButton showAll = new RoundButton("전체 보기");
		showAll.setBounds(5,5, 40, 30);
		showAll.setAlignmentX(CENTER_ALIGNMENT);
		showAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isShowAll) {
					for(i = 0; i< MyData.getPeopleNumber(); i++) {
						results[i].setVisible(false);
					}
					showAll.setColor("가리기", Color.GRAY);
					isShowAll = false;
				}
				else {
					for(i = 0; i< MyData.getPeopleNumber(); i++) {
						results[i].setVisible(true);
					}
					showAll.setColor("전체보기", new Color(61,205,91));
					isShowAll = true;
				}
			}
		});
//		controlPanel.setLayout(null);
		controlPanel.add(showAll);
		
		blindPanel.add(start);
		controlPanel.setVisible(false);
		blindPanel.setBackground(Color.WHITE);
		this.add(blindPanel);
		this.add(controlPanel);
	}
}
