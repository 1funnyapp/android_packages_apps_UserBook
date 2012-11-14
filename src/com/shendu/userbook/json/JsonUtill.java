package com.shendu.userbook.json;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.shendu.userbook.FuntionInfo;
import com.shendu.userbook.SummaryInfo;

public class JsonUtill {
	
	public static ArrayList<FuntionInfo> getFuntionInfo(String json , Context context){
		ArrayList<FuntionInfo> info = new ArrayList<FuntionInfo>();
		try {
			JSONArray jsonArray =  new JSONArray(json);
			 for (int i = 0; i < jsonArray.length(); i++) {
				 FuntionInfo funtionInfo = new FuntionInfo();
				  JSONObject item = jsonArray.getJSONObject(i);
				  funtionInfo.id = item.getInt("id");
				  funtionInfo.name = item.getString("name");
				  String iconName =  item.getString("iconName");
				  funtionInfo.iconId = context.getResources().getIdentifier(
							"com.shendu.userbook:drawable/" + iconName, null, null);
				  info.add(funtionInfo);
			 }
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
		
	}
	
	public static ArrayList<SummaryInfo> getSummaryInfo(String json , Context context){
		ArrayList<SummaryInfo> info = new ArrayList<SummaryInfo>();
		try {
			JSONArray jsonArray =  new JSONArray(json);
			 for (int i = 0; i < jsonArray.length(); i++) {
				 SummaryInfo summaryInfo = new SummaryInfo();
				  JSONObject item = jsonArray.getJSONObject(i);
				  summaryInfo.contents1 = item.getString("contents1");
				  summaryInfo.contents2 = item.getString("contents2");
				  summaryInfo.contents3 = item.getString("contents3");
				  String imgName  = item.getString("imgName");
				  summaryInfo.imgId = context.getResources().getIdentifier(
							"com.shendu.userbook:drawable/" + imgName, null, null);
				  info.add(summaryInfo);
			 }
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
		
	}

}
