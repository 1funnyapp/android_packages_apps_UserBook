package com.shendu.userbook.json;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.shendu.userbook.R;

import android.content.Context;

public class CreateJsonUtill {

	private String[] functionName;
	private int[] functionId;
	private Context mContext;
	

	private JSONArray peopleJSON;
	private JSONArray summaryJSON;

	public CreateJsonUtill(Context context) {

		this.mContext = context;
		functionName = context.getResources().getStringArray(
				R.array.function_array);
		functionId = context.getResources().getIntArray(R.array.function_id);
		createData();
		peopleJSON = new JSONArray();
		summaryJSON = new JSONArray();
	}

	public String getFunctionName() {

		for (int index = 0; index < functionName.length; index++) {
			setJsonArray(functionName[index], functionId[index]);
		}

		return peopleJSON.toString();

	}
	
	public String getSummaryInfo(int id){
		String [] data1 = summaryContent1.get(id);
		String [] data2 = summaryContent1.get(id);
		String [] data3 = summaryContent1.get(id);
		Integer[] img = summaryImgId.get(id);
		for (int index = 0; index < data1.length; index++) {
			setSummaryArray(data1[index], data2[index] , data3 [index] , img[index]);
		}
		return summaryJSON.toString();
		
	}


	private void setJsonArray(String name, int id) {
		JSONObject jsonPeopleNumbers = new JSONObject();

		try {

			jsonPeopleNumbers.put("name", name);
			jsonPeopleNumbers.put("id", id);

		} catch (JSONException e) {
			e.printStackTrace();
		}
		peopleJSON.put(jsonPeopleNumbers);
	}
	
	private void setSummaryArray(String contents1 , String contents2 , String contents3 , int imgId){
		JSONObject jsonPeopleNumbers = new JSONObject();
		try {

			jsonPeopleNumbers.put("contents1", contents1);
			jsonPeopleNumbers.put("contents2", contents2);
			jsonPeopleNumbers.put("contents3", contents3);
			jsonPeopleNumbers.put("imgId", imgId);

		} catch (JSONException e) {
			e.printStackTrace();
		}
		summaryJSON.put(jsonPeopleNumbers);
	}
	

	
	private ArrayList<String []> summaryContent1  = new ArrayList<String[]>(); 
	private ArrayList<String []> summaryContent2  = new ArrayList<String[]>();
	private ArrayList<String []> summaryContent3  = new ArrayList<String[]>();
	private ArrayList<Integer []> summaryImgId  = new ArrayList<Integer []>();


	private void createData(){

		summaryContent1.add(mContext.getResources().getStringArray(R.array.summary_array1));
		summaryContent1.add(mContext.getResources().getStringArray(R.array.summary_array2));
		summaryContent1.add(mContext.getResources().getStringArray(R.array.summary_array3));
		summaryContent1.add(mContext.getResources().getStringArray(R.array.summary_array4));
		summaryContent1.add(mContext.getResources().getStringArray(R.array.summary_array5));
		summaryContent1.add(mContext.getResources().getStringArray(R.array.summary_array6));
		summaryContent1.add(mContext.getResources().getStringArray(R.array.summary_array7));
		
		summaryContent2.add(mContext.getResources().getStringArray(R.array.summary_array1));
		summaryContent2.add(mContext.getResources().getStringArray(R.array.summary_array2));
		summaryContent2.add(mContext.getResources().getStringArray(R.array.summary_array3));
		summaryContent2.add(mContext.getResources().getStringArray(R.array.summary_array4));
		summaryContent2.add(mContext.getResources().getStringArray(R.array.summary_array5));
		summaryContent2.add(mContext.getResources().getStringArray(R.array.summary_array6));
		summaryContent2.add(mContext.getResources().getStringArray(R.array.summary_array7));
		
		summaryContent3.add(mContext.getResources().getStringArray(R.array.summary_array1));
		summaryContent3.add(mContext.getResources().getStringArray(R.array.summary_array2));
		summaryContent3.add(mContext.getResources().getStringArray(R.array.summary_array3));
		summaryContent3.add(mContext.getResources().getStringArray(R.array.summary_array4));
		summaryContent3.add(mContext.getResources().getStringArray(R.array.summary_array5));
		summaryContent3.add(mContext.getResources().getStringArray(R.array.summary_array6));
		summaryContent3.add(mContext.getResources().getStringArray(R.array.summary_array7));
		
		summaryImgId.add(getImgId());
		summaryImgId.add(getImgId());
		summaryImgId.add(getImgId());
		summaryImgId.add(getImgId());
		summaryImgId.add(getImgId());
		summaryImgId.add(getImgId());
		summaryImgId.add(getImgId());

	}
	
	private Integer [] getImgId(){
		Integer [] img = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5}  ;
		return img;
		
	}
	
	
}
