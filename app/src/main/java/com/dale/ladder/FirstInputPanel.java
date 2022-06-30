package com.dale.ladder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.dale.ladder.button.RoundButton;
import com.dale.ladder.data.MyData;

public class FirstInputPanel extends JPanel {
	
	private static JLabel numberOfPeopleLabel = new JLabel("인원 수를 입력하세요: ");
	private static JLabel numberOfBranchLabel = new JLabel("가짓수를 입력하세요: ");
	
	private RoundButton goToNext;
	
	private TextField numberOfPeople;
	private TextField numberOfBranch;
	
	private boolean isNumberInPeopel = false;
	private boolean isNumberInBranch = false;
	
	
	
	private Font normalFont = new Font("",Font.BOLD, 30);
	
	FirstInputPanel(){
//		setBackground(Color.WHITE);
		setBounds(0, 0, 1080, 504);
		setLayout(new BorderLayout());
		createPanel();
	}
	
	private void createPanel() {
		JPanel centerPanel = new JPanel();
				
		centerPanel.setLayout(null);
		
		goToNext = new RoundButton("시작", Color.GRAY);
		goToNext.setEnabled(false);
		
		numberOfPeople = new TextField();
		numberOfBranch = new TextField();
		
		numberOfPeopleLabel.setAlignmentX(CENTER_ALIGNMENT);
		numberOfPeopleLabel.setBounds(150, 15, 350, 50);
		numberOfPeopleLabel.setFont(normalFont);
		numberOfPeople.setBounds(150, 60, 350, 50);
		numberOfPeople.setFont(normalFont);
		numberOfPeople.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				try {
					MyData.setPeopleNumber(Integer.parseInt(numberOfPeople.getText()));
					isNumberInPeopel = true;
					if(isNumberInBranch && isNumberInPeopel) {
						goToNext.setColor("시작", new Color(61,205,91));
						goToNext.setEnabled(true);
					}
				}catch (Exception e1) {
//					e1.printStackTrace();
					goToNext.setColor("시작", Color.GRAY);
					goToNext.setEnabled(false);
					isNumberInPeopel = false;
				}
			}
			
		});
		
		numberOfBranchLabel.setAlignmentX(CENTER_ALIGNMENT);
		numberOfBranchLabel.setBounds(150, 125, 350, 50);
		numberOfBranchLabel.setFont(normalFont);
		numberOfBranch.setBounds(150, 170, 350, 50);
		numberOfBranch.setFont(normalFont);
		numberOfBranch.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				try {
					MyData.setBridgeNumber(Integer.parseInt(numberOfBranch.getText()));
					isNumberInBranch = true;
					if(isNumberInBranch && isNumberInPeopel) {
						goToNext.setColor("시작", new Color(61,205,91));
						goToNext.setEnabled(true);
					}
				}catch (Exception e1) {
//					e1.printStackTrace();
					isNumberInPeopel = false;
					goToNext.setColor("시작", Color.GRAY);
					goToNext.setEnabled(false);
				}
			}
			
		});
		
		centerPanel.add(numberOfPeopleLabel);
		centerPanel.add(numberOfPeople);
		
		centerPanel.add(numberOfBranchLabel);
		centerPanel.add(numberOfBranch);
		
		
		
		this.add(goToNext, BorderLayout.EAST);
		this.add(centerPanel,BorderLayout.CENTER);
	}

	public RoundButton getGoToNext() {
		return goToNext;
	}

	public TextField getNumberOfPeople() {
		return numberOfPeople;
	}

	public TextField getNumberOfBranch() {
		return numberOfBranch;
	}
}
