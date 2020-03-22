package model;

import java.util.Map;

public class Quorum {
	
	int min = 0; 
	int max = 0; 
	
	public Quorum (Map<String, String> params){
		this(params.get("min"), params.get("max"));
	}
		
	public Quorum(String minS, String maxS){
		if (minS != null){
			min = Integer.valueOf(minS);
		}
		if (maxS != null){
			max = Integer.valueOf(maxS);
		}
		if (isSet() && min == 0) {
			min = 1;
		}
	}
	
	public boolean isSet(){
		return (min > 0 || max > 0);
	}
	
	public boolean meets(int count){
		return count >= min && count <= max;
	}
	
	public boolean exceeds (int count){
		return count > max;
	}

}
