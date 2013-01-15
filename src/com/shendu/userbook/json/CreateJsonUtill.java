package com.shendu.userbook.json;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.shendu.userbook.R;

import android.content.Context;

public class CreateJsonUtill {

	private String[] mFunctionName;
	private String [] mFunctionIcons;
	private int[] functionId;
	private Context mContext;
	

	private JSONArray peopleJSON;
	private JSONArray summaryJSON;

	public CreateJsonUtill(Context context) {

		this.mContext = context;
		
		functionId = context.getResources().getIntArray(R.array.function_id);
		createData();
		peopleJSON = new JSONArray();
		summaryJSON = new JSONArray();
	}

	public String getFunctionInfo() {
		mFunctionName = mContext.getResources().getStringArray(
				R.array.function_array);
		mFunctionIcons = mContext.getResources().getStringArray(
				R.array.function_icons);
		for (int index = 0; index < mFunctionName.length; index++) {
			setJsonArray(mFunctionName[index], functionId[index], mFunctionIcons[index]);
		}

		return peopleJSON.toString();

	}
	
	public String getSummaryInfo(int id){
		String [] data1 = mSummaryContent1.get(id);
		String [] data2 = mSummaryContent1.get(id);
		String [] data3 = mSummaryContent1.get(id);
		String [] img = mSummaryImgName.get(id);
		for (int index = 0; index < data1.length; index++) {
			setSummaryArray(data1[index], data2[index] , data3 [index] , img[index]);
		}
		return summaryJSON.toString();
		
	}


	private void setJsonArray(String name, int id , String iconName) {
		JSONObject jsonPeopleNumbers = new JSONObject();

		try {

			jsonPeopleNumbers.put("name", name);
			jsonPeopleNumbers.put("id", id);
			jsonPeopleNumbers.put("iconName", iconName);

		} catch (JSONException e) {
			e.printStackTrace();
		}
		peopleJSON.put(jsonPeopleNumbers);
	}
	
	private void setSummaryArray(String contents1 , String contents2 , String contents3 , String imgName){
		JSONObject jsonPeopleNumbers = new JSONObject();
		try {

			jsonPeopleNumbers.put("contents1", contents1);
			jsonPeopleNumbers.put("contents2", contents2);
			jsonPeopleNumbers.put("contents3", contents3);
			jsonPeopleNumbers.put("imgName", imgName);

		} catch (JSONException e) {
			e.printStackTrace();
		}
		summaryJSON.put(jsonPeopleNumbers);
	}
	

	
	private ArrayList<String []> mSummaryContent1  = new ArrayList<String[]>(); 
	private ArrayList<String []> mSummaryContent2  = new ArrayList<String[]>();
	private ArrayList<String []> mSummaryContent3  = new ArrayList<String[]>();
	private ArrayList<String []> mSummaryImgName  = new ArrayList<String []>();
	
	private void createData(){

		mSummaryContent1.add(mContext.getResources().getStringArray(R.array.summary_array1));
		mSummaryContent1.add(mContext.getResources().getStringArray(R.array.summary_array2));
		mSummaryContent1.add(mContext.getResources().getStringArray(R.array.summary_array3));
		mSummaryContent1.add(mContext.getResources().getStringArray(R.array.summary_array4));
		mSummaryContent1.add(mContext.getResources().getStringArray(R.array.summary_array5));
		mSummaryContent1.add(mContext.getResources().getStringArray(R.array.summary_array6));
		mSummaryContent1.add(mContext.getResources().getStringArray(R.array.summary_array7));
		mSummaryContent1.add(mContext.getResources().getStringArray(R.array.summary_array8));
		mSummaryContent1.add(mContext.getResources().getStringArray(R.array.summary_array9));
		mSummaryContent1.add(mContext.getResources().getStringArray(R.array.summary_array10));
		
		mSummaryContent2.add(mContext.getResources().getStringArray(R.array.summary_array1));
		mSummaryContent2.add(mContext.getResources().getStringArray(R.array.summary_array2));
		mSummaryContent2.add(mContext.getResources().getStringArray(R.array.summary_array3));
		mSummaryContent2.add(mContext.getResources().getStringArray(R.array.summary_array4));
		mSummaryContent2.add(mContext.getResources().getStringArray(R.array.summary_array5));
		mSummaryContent2.add(mContext.getResources().getStringArray(R.array.summary_array6));
		mSummaryContent2.add(mContext.getResources().getStringArray(R.array.summary_array7));
		mSummaryContent2.add(mContext.getResources().getStringArray(R.array.summary_array8));
		mSummaryContent2.add(mContext.getResources().getStringArray(R.array.summary_array9));
		mSummaryContent2.add(mContext.getResources().getStringArray(R.array.summary_array10));
		
		mSummaryContent3.add(mContext.getResources().getStringArray(R.array.summary_array1));
		mSummaryContent3.add(mContext.getResources().getStringArray(R.array.summary_array2));
		mSummaryContent3.add(mContext.getResources().getStringArray(R.array.summary_array3));
		mSummaryContent3.add(mContext.getResources().getStringArray(R.array.summary_array4));
		mSummaryContent3.add(mContext.getResources().getStringArray(R.array.summary_array5));
		mSummaryContent3.add(mContext.getResources().getStringArray(R.array.summary_array6));
		mSummaryContent3.add(mContext.getResources().getStringArray(R.array.summary_array7));
		mSummaryContent3.add(mContext.getResources().getStringArray(R.array.summary_array8));
		mSummaryContent3.add(mContext.getResources().getStringArray(R.array.summary_array9));
		mSummaryContent3.add(mContext.getResources().getStringArray(R.array.summary_array10));
		
		mSummaryImgName.add(mContext.getResources().getStringArray(R.array.summary_img1));
		mSummaryImgName.add(mContext.getResources().getStringArray(R.array.summary_img2));
		mSummaryImgName.add(mContext.getResources().getStringArray(R.array.summary_img3));
		mSummaryImgName.add(mContext.getResources().getStringArray(R.array.summary_img4));
		mSummaryImgName.add(mContext.getResources().getStringArray(R.array.summary_img5));
		mSummaryImgName.add(mContext.getResources().getStringArray(R.array.summary_img6));
		mSummaryImgName.add(mContext.getResources().getStringArray(R.array.summary_img7));
		mSummaryImgName.add(mContext.getResources().getStringArray(R.array.summary_img8));
		mSummaryImgName.add(mContext.getResources().getStringArray(R.array.summary_img9));
		mSummaryImgName.add(mContext.getResources().getStringArray(R.array.summary_img10));


	}	
	
}
