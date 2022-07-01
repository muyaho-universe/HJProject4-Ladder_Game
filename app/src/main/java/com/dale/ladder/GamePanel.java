package com.dale.ladder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.dale.ladder.data.MyData;

public class GamePanel extends JPanel {
	
	@Override
	public void paintComponent(Graphics g){
	    super.paintComponent(g); // 부모 페인트호출
	    Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.BLACK);
        for(int i=0; i<=770; i+=MyData.getOneWidth()) {
           g2d.drawLine(i+25, 0, i+25, 450);
        }
        for (int i = 0; i <MyData.getBridgeNumber(); i++) {//y값
           for(int j=0; j<MyData.getPeopleNumber(); j++) {//x값
              if(MyData.branches[i] == j) {
                 g2d.drawLine(j*MyData.getOneWidth()+25, i*MyData.getOneHeight()+10, (j+1)*MyData.getOneWidth()+25, i*MyData.getOneHeight()+10);
                 break;
              }
           }
         
      }
	    
	}
}
