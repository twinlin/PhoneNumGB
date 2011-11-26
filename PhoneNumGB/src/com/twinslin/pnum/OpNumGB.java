package com.twinslin.pnum;

public class OpNumGB {
	private double opDouNum;
	private int opIntNum;
  	private double opResulto;
	
		
	public double getVolumn(String cutPNum){
		opDouNum = Double.parseDouble(cutPNum);
		opIntNum = Integer.parseInt(cutPNum);
	    opResulto = ((opDouNum/80-opIntNum/80)*80);
		return opResulto;
	}
}
