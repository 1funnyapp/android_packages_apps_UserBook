package com.shendu.userbook.json;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.shendu.userbook.FuntionInfo;
import com.shendu.userbook.SummaryInfo;

public class JsonUtill {
	
	public static ArrayList<FuntionInfo> getFuntionInfo(String json){
		ArrayList<FuntionInfo> info = new ArrayList<FuntionInfo>();
		try {
			JSONArray jsonArray =  new JSONArray(json);
			 for (int i = 0; i < jsonArray.length(); i++) {
				 FuntionInfo funtionInfo = new FuntionInfo();
				  JSONObject item = jsonArray.getJSONObject(i);
				  funtionInfo.id = item.getInt("id");
				  funtionInfo.name = item.getString("name");
				  funtionInfo.iconId = item.getInt("iconId");
				  info.add(funtionInfo);
			 }
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
		
	}
	
	public static ArrayList<SummaryInfo> getSummaryInfo(String json){
		ArrayList<SummaryInfo> info = new ArrayList<SummaryInfo>();
		try {
			JSONArray jsonArray =  new JSONArray(json);
			 for (int i = 0; i < jsonArray.length(); i++) {
				 SummaryInfo summaryInfo = new SummaryInfo();
				  JSONObject item = jsonArray.getJSONObject(i);
				  summaryInfo.contents1 = item.getString("contents1");
				  summaryInfo.contents2 = item.getString("contents2");
				  summaryInfo.contents3 = item.getString("contents3");
				  summaryInfo.imgId = item.getInt("imgId");
				  info.add(summaryInfo);
			 }
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
		
	}

}
