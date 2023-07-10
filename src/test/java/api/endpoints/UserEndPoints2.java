package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.payload.User;

public class UserEndPoints2 {
	
	//Get URL
	static ResourceBundle getURL(){
		ResourceBundle routes = ResourceBundle.getBundle("routes.properties");
		return routes;
	}
	
	
	// Create operation method
	public static Response createUser(User payload) {
		
		String post_url = getURL().getString("post_url");
		
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(post_url);

		return response;
	}

	// Read operation method
	public static Response readUser(String username) {

		String get_url = getURL().getString("get_url");
		
		Response response = given().pathParam("username", username).when().get(get_url);

		return response;
	}

	// Update operation method
	public static Response updateUser(String username, User payload) {
		
		String update_url = getURL().getString("update_url");
		
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("username", username).body(payload).when()
				.put(update_url);

		return response;
	}

	// Delete operation method
	public static Response deleteUser(String username) {
		
		String delete_url = getURL().getString("delete_url");
		
		Response response = given().pathParam("username", username).when()
				.delete(delete_url);

		return response;
	}
}
