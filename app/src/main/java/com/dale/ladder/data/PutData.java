package com.dale.ladder.data;

import com.dale.ladder.SingletracePanel;
import com.dale.ladder.button.RoundButton;

public class PutData {
	int startPoint;
	public int getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(int startPoint) {
		this.startPoint = startPoint;
	}


	public SingletracePanel getSingleTracePanel() {
		return singleTracePanel;
	}


	public void setSingleTracePanel(SingletracePanel singleTracePanel) {
		this.singleTracePanel = singleTracePanel;
	}


	public RoundButton getButton() {
		return button;
	}


	public void setButton(RoundButton button) {
		this.button = button;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	SingletracePanel singleTracePanel;
	RoundButton button;
	int index;
	
	
	public PutData(int start, RoundButton b, int i){
		startPoint = start;
		button = b;
		index =i;
	}
}
