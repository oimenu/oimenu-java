package br.com.oimenu.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventCallWaiter {
	@SerializedName("table")
    @Expose
    private String table = "";
    
    @SerializedName("waiter")
    @Expose
    private String waiter = "";
    
    @SerializedName("options")
    @Expose
    private List<String> options = new ArrayList<String>();

    public String getTable() {
        return table;
    }
    public void setTable(String table) {
        this.table = table;
    }

    public String getWaiter() {
        return waiter;
    }
    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }
    
    public List<String> getOptions() {
        return options;
    }
    public void setOptions(List<String> options) {
        this.options = options;
    }
}
