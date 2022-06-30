package com.dale.ladder;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.dale.ladder.data.MyData;

public class SetComponent extends JPanel {
	String[] names = {"Ã¶¼ö", "¿µÈñ", "¸Í±¸", "´ë¼®", "¾ßÈ£"};
	String[] targets = {"1000", "400", "500", "600", "9999"};
	
	public SetComponent(){
		setBounds(0, 0, 1080, 504);
		setLayout(new BorderLayout());
//		createPanel();
	}
	
	public void createPanel() {
		int i;
		for(i = 0; i <MyData.getPeopleNumber(); i++) {
			MyData.peopleData.put(i, names[i]);
			MyData.targetData.put(i, targets[i]);
		}
		Integer[] branches = new Integer[MyData.getBridgeNumber()];
		
		for(i= 0; i < MyData.getBridgeNumber(); i++) {
			branches[i] = (int) (Math.random() * (MyData.getPeopleNumber()-1));
			System.out.println("Origin: "+ MyData.peopleData.get(i) + " " + branches[i] + " "+ MyData.getPeopleNumber());
		}
		
		
		
		for(i = 0; i < MyData.getBridgeNumber(); i++) {
			String temp1 = MyData.targetData.get(branches[i]);
			String temp2 = MyData.targetData.get(branches[i]+1);
			
			MyData.targetData.put(branches[i], temp2);
			MyData.targetData.put(branches[i]+1, temp1);
			
		}
		for(i= 0; i < MyData.getBridgeNumber(); i++) {
			System.out.println("Change: "+ MyData.targetData.get(i));
		}

	}
	
}
