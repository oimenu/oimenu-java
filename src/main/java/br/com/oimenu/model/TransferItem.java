package br.com.oimenu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransferItem {

    
    @SerializedName("new_item")
    @Expose
    private OrderItem newItem = new OrderItem();
    
    public OrderItem getNewItem() {
        return newItem;
    }
    public void setNewItem(OrderItem newItem) {
        this.newItem = newItem;
    }
  
}
