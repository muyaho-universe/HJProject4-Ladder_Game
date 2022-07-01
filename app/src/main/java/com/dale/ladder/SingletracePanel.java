package com.dale.ladder;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.dale.ladder.data.MyData;

public class SingletracePanel extends JPanel {
	private int startX, startY;
	private int index;
	SingletracePanel(int x, int y, int index){
		startX = x;
		startY =y;
		this.index = index;
	}
	
	@Override
	public void paintComponent(Graphics g){
	    super.paintComponent(g); // 부모 페인트호출
	    Graphics2D g2d = (Graphics2D) g.create();
	    Graphics2D g2dMain = (Graphics2D) g.create();
        g2d.setColor(Color.BLACK);
        g2dMain.setColor(Color.RED);
        g2dMain.setStroke(new BasicStroke(7, BasicStroke.CAP_ROUND,0));
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
       int i = 0;
       g2dMain.drawLine(startX, startY, startX, 10);
       startY+= 10;
       for(i=0; i <MyData.getBridgeNumber(); i ++) {
    	  System.out.println(index);
//    	   
    	   if((MyData.getBranches()[i] == (index-1)) ) {
    		   System.out.println(("야호: " + MyData.getBranches()[i]+ " " +index));
    		   g2dMain.drawLine(startX - MyData.getOneWidth(), startY, startX, startY);
    		   startX -= MyData.getOneWidth();
    		   index --;
    		   g2dMain.drawLine(startX, startY, startX, startY+MyData.getOneHeight());
    		   startY+= MyData.getOneHeight();
    		   continue;
    	   }
    	   else if(MyData.getBranches()[i] == index) {
    		   System.out.println("무야호: " +MyData.getBranches()[i]+" "+(index+1));
    		   g2dMain.drawLine(startX, startY, startX+MyData.getOneWidth(), startY);
    		   startX += MyData.getOneWidth();
    		   index++;
    		   g2dMain.drawLine(startX, startY, startX, startY+MyData.getOneHeight());
    		   startY+= MyData.getOneHeight();
    		   continue;
    	   }
    	   g2dMain.drawLine(startX, startY, startX, startY+MyData.getOneHeight());
    	   startY += MyData.getOneHeight();
    	   
       }
       g2dMain.drawLine(startX, startY, startX, startY+MyData.getOneHeight());
	}
}
