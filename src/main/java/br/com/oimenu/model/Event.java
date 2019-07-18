package br.com.oimenu.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

public class Event {
	@SerializedName("id")
    @Expose
    private String id = "";
	
    @SerializedName("date")
    @Expose
    private String date = "";
    
    @SerializedName("type")
    @Expose
    private String type = "";
    
    @SerializedName("data")
    @Expose
    private Object data;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getTye() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    public Object getData() {
    	if (data.getClass().equals(LinkedTreeMap.class)) {
    		GsonBuilder gsonBuilder = new GsonBuilder();
    	    Gson gson = gsonBuilder.create();
			if (type.equalsIgnoreCase("call-waiter")) {
				data = gson.fromJson(gson.toJsonTree(data).getAsJsonObject().toString(),EventCallWaiter.class);
			} else if (type.equalsIgnoreCase("the-check")) {
				data = gson.fromJson(gson.toJsonTree(data).getAsJsonObject().toString(),EventTheCheck.class);
			}
    	}
    	return data;
    }
    public void setData(Object data) {
    	this.data = data;
    }
    
}
