package br.com.oimenu;


import br.com.oimenu.model.*;
import br.com.oimenu.net.HttpsRequest;
import com.google.gson.*;

import java.lang.reflect.Method;
import java.util.List;

public class OimenuClient {
	protected String token;
	protected GsonBuilder gsonBuilder = new GsonBuilder();
    protected Gson gson = gsonBuilder.create();
	
	public OimenuClient(String token) {
		this.token = token;
	}
	
	private <T> Object convertJson(String json, Class<T> returnClass) {
		Object obj = null;
		try {
			obj = gson.fromJson(json, returnClass);
		} catch (Exception e) {
			try {
				try {
					obj = returnClass.getDeclaredConstructor().newInstance();
					Class[] paramTypes = {String.class};
					Method m = obj.getClass().getMethod("setMessage", paramTypes);
					m.invoke(obj, e.getLocalizedMessage());
				
					Class[] paramTypes2 = {Integer.class};
					m = obj.getClass().getMethod("setResponseCode", paramTypes2);
					m.invoke(obj, 501);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return obj;
	}
	
	//PRODUCT
	public ProductResult createProduct(Product product){
		String json =  HttpsRequest.getResult(token, "POST", "product", product);
	    return (ProductResult) convertJson(json, ProductResult.class);
	}
	
	public SimpleResult batchProducts(List<Product> products){
		String json =  HttpsRequest.getResult(token, "POST", "products", products);
	    return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
	public ProductResult updateProduct(Product product){
		String json =  HttpsRequest.getResult(token, "PUT", "product/" + product.getCode(), product);
	    return (ProductResult) convertJson(json, ProductResult.class);
	}
	
	public SimpleResult deleteProduct(String id){
		String json =  HttpsRequest.getResult(token, "DELETE", "product/" + id, null);
	    return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
	//ORDER
	public OrderResult getAllOrders() {
	     String json =  HttpsRequest.getResult(token, "GET", "orders", null);
	     return (OrderResult) convertJson(json, OrderResult.class);
	}
	
	public SimpleResult setOrderAsReceived(String id){
		String json =  HttpsRequest.getResult(token, "PUT", "order/" + id + "/received", null);
	    return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
	//EVENT
	public EventResult getAllEvents() {
	     String json =  HttpsRequest.getResult(token, "GET", "events", null);
	     return (EventResult) convertJson(json, EventResult.class);
	}
	
	public SimpleResult setEventAsReceived(String id){
		String json =  HttpsRequest.getResult(token, "PUT", "event/" + id + "/received", null);
	    return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
	//TABLE MODE
	public SimpleResult closeTable(Integer code) {
	     String json =  HttpsRequest.getResult(token, "PUT", "table/" + String.valueOf(code) + "/close", null);
	     return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
	public SimpleResult transferTable(Integer code, Integer codeNew) {
	     String json =  HttpsRequest.getResult(token, "PUT", "table/" + String.valueOf(code) + "/transfer", "{\"new_table\":"+String.valueOf(codeNew)+"}");
	     return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
	public SimpleResult cancelTable(Integer code) {
	     String json =  HttpsRequest.getResult(token, "PUT", "table/" + String.valueOf(code) + "/cancel", null);
	     return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
	public SimpleResult reopenTable(Integer code) {
	     String json =  HttpsRequest.getResult(token, "PUT", "table/" + String.valueOf(code) + "/reopen", null);
	     return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
	public ItemResult createTableItem(Integer codeTable, OrderProduct product) {
	     String json =  HttpsRequest.getResult(token, "POST", "table/" + String.valueOf(codeTable) + "/item", product);
	     return (ItemResult) convertJson(json, ItemResult.class);
	}
	
	public ItemResult updateTableItem(Integer codeTable, String idItem, Integer quantity, Double price) {
	     String json =  HttpsRequest.getResult(token, "PUT", "table/" + String.valueOf(codeTable) + "/item/" + idItem, "{\"quantity\":"+String.valueOf(quantity)+",\"price\":"+String.valueOf(price)+"}");
	     return (ItemResult) convertJson(json, ItemResult.class);
	}
	
	public TransferResult transferTableItem(Integer codeTable, Integer codeTableNew, String idItem) {
	     String json =  HttpsRequest.getResult(token, "PUT", "table/" + String.valueOf(codeTable) + "/item/" + idItem + "/transfer", "{\"new_table\":"+String.valueOf(codeTableNew)+"}");
	     return (TransferResult) convertJson(json, TransferResult.class);
	}
	
	public TransferResult transferTableItem(Integer codeTable, Integer codeTableNew, String idItem, Integer quantity) {
	     String json =  HttpsRequest.getResult(token, "PUT", "table/" + String.valueOf(codeTable) + "/item/" + idItem + "/transfer", "{\"new_table\":"+String.valueOf(codeTableNew)+",\"quantity\":"+String.valueOf(quantity)+"}");
	     return (TransferResult) convertJson(json, TransferResult.class);
	}
	
	public ItemResult cancelTableItem(Integer codeTable, String idItem) {
	     String json =  HttpsRequest.getResult(token, "PUT", "table/" + String.valueOf(codeTable) + "/item/" + idItem + "/cancel", null);
	     return (ItemResult) convertJson(json, ItemResult.class);
	}
	
	public ItemResult cancelTableItem(Integer codeTable, String idItem, Integer quantity) {
	     String json =  HttpsRequest.getResult(token, "PUT", "table/" + String.valueOf(codeTable) + "/item/" + idItem + "/cancel", "{\"quantity\":"+String.valueOf(quantity)+"}");
	     return (ItemResult) convertJson(json, ItemResult.class);
	}
	
	
	//CARD MODE
	public SimpleResult closeCard(Integer code) {
	     String json =  HttpsRequest.getResult(token, "PUT", "card/" + String.valueOf(code) + "/close", null);
	     return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
	public SimpleResult transferCard(Integer code, Integer codeNew) {
	     String json =  HttpsRequest.getResult(token, "PUT", "card/" + String.valueOf(code) + "/transfer", "{\"new_card\":"+String.valueOf(codeNew)+"}");
	     return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
	public SimpleResult cancelCard(Integer code) {
	     String json =  HttpsRequest.getResult(token, "PUT", "card/" + String.valueOf(code) + "/cancel", null);
	     return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
	public SimpleResult reopenCard(Integer code) {
	     String json =  HttpsRequest.getResult(token, "PUT", "card/" + String.valueOf(code) + "/reopen", null);
	     return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
	public ItemResult createCardItem(Integer codeCard, OrderProduct product) {
	     String json =  HttpsRequest.getResult(token, "POST", "card/" + String.valueOf(codeCard) + "/item", product);
	     return (ItemResult) convertJson(json, ItemResult.class);
	}
	
	public ItemResult updateCardItem(Integer codeCard, String idItem, Integer quantity, Double price) {
	     String json =  HttpsRequest.getResult(token, "PUT", "card/" + String.valueOf(codeCard) + "/item/" + idItem, "{\"quantity\":"+String.valueOf(quantity)+",\"price\":"+String.valueOf(price)+"}");
	     return (ItemResult) convertJson(json, ItemResult.class);
	}
	
	public TransferResult transferCardItem(Integer codeCard, Integer codeTableNew, String idItem) {
	     String json =  HttpsRequest.getResult(token, "PUT", "card/" + String.valueOf(codeCard) + "/item/" + idItem + "/transfer", "{\"new_table\":"+String.valueOf(codeTableNew)+"}");
	     return (TransferResult) convertJson(json, TransferResult.class);
	}
	
	public TransferResult transferCardItem(Integer codeCard, Integer codeTableNew, String idItem, Integer quantity) {
	     String json =  HttpsRequest.getResult(token, "PUT", "card/" + String.valueOf(codeCard) + "/item/" + idItem + "/transfer", "{\"new_table\":"+String.valueOf(codeTableNew)+",\"quantity\":"+String.valueOf(quantity)+"}");
	     return (TransferResult) convertJson(json, TransferResult.class);
	}
	
	public ItemResult cancelCardItem(Integer codeCard, String idItem) {
	     String json =  HttpsRequest.getResult(token, "PUT", "card/" + String.valueOf(codeCard) + "/item/" + idItem + "/cancel", null);
	     return (ItemResult) convertJson(json, ItemResult.class);
	}
	
	public ItemResult cancelCardItem(Integer codeCard, String idItem, Integer quantity) {
	     String json =  HttpsRequest.getResult(token, "PUT", "card/" + String.valueOf(codeCard) + "/item/" +idItem+ "/cancel", "{\"quantity\":"+String.valueOf(quantity)+"}");
	     return (ItemResult) convertJson(json, ItemResult.class);
	}
	
	//TABLE
	public TablesResult getAllTables() {
	     String json =  HttpsRequest.getResult(token, "GET", "tables", null);
	     return (TablesResult) convertJson(json, TablesResult.class);
	}
	
	public TableResult createTable(Table table){
		String json =  HttpsRequest.getResult(token, "POST", "table", table);
	    return (TableResult) convertJson(json, TableResult.class);
	}
	
	public SimpleResult batchTables(List<Table> tables){
		String json =  HttpsRequest.getResult(token, "POST", "tables", tables);
	    return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
	public TableResult updateTable(Table table){
		String json =  HttpsRequest.getResult(token, "PUT", "table/" + table.getCode(), table);
	    return (TableResult) convertJson(json, TableResult.class);
	}
	
	public SimpleResult deleteTable(Integer code){
		String json =  HttpsRequest.getResult(token, "DELETE", "table/" + String.valueOf(code), null);
	    return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
	//CARD
	public CardsResult getAllCards() {
	     String json =  HttpsRequest.getResult(token, "GET", "cards", null);
	     return (CardsResult) convertJson(json, CardsResult.class);
	}
	
	public CardResult createCard(Card card){
		String json =  HttpsRequest.getResult(token, "POST", "card", card);
	    return (CardResult) convertJson(json, CardResult.class);
	}
	
	public SimpleResult batchCards(List<Card> cards){
		String json =  HttpsRequest.getResult(token, "POST", "cards", cards);
	    return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
	public CardResult updateCard(Card card){
		String json =  HttpsRequest.getResult(token, "PUT", "card/" + String.valueOf(card.getCode()), card);
	    return (CardResult) convertJson(json, CardResult.class);
	}
	
	public SimpleResult deleteCard(Integer code){
		String json =  HttpsRequest.getResult(token, "DELETE", "card/" + String.valueOf(code), null);
	    return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
	//USER
	public UsersResult getAllUsers() {
	     String json =  HttpsRequest.getResult(token, "GET", "users", null);
	     return (UsersResult) convertJson(json, UsersResult.class);
	}
	
	public UserResult createUser(User user){
		String json =  HttpsRequest.getResult(token, "POST", "user", user);
	    return (UserResult) convertJson(json, UserResult.class);
	}
	
	public SimpleResult batchUsers(List<User> users){
		String json =  HttpsRequest.getResult(token, "POST", "users", users);
	    return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
	public UserResult updateUser(User user){
		String json =  HttpsRequest.getResult(token, "PUT", "user/" + String.valueOf(user.getCode()), user);
	    return (UserResult) convertJson(json, UserResult.class);
	}
	
	public SimpleResult deleteUser(Integer code){
		String json =  HttpsRequest.getResult(token, "DELETE", "user/" + String.valueOf(code), null);
	    return (SimpleResult) convertJson(json, SimpleResult.class);
	}
	
}
