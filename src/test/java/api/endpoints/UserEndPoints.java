package api.endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.payload.User;

public class UserEndPoints {

	// Create operation method
	public static Response createUser(User payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.post_url);

		return response;
	}

	// Read operation method
	public static Response readUser(String username) {

		Response response = given().pathParam("username", username).when().get(Routes.get_url);

		return response;
	}

	// Update operation method
	public static Response updateUser(String username, User payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("username", username).body(payload).when()
				.put(Routes.update_url);

		return response;
	}

	// Delete operation method
	public static Response deleteUser(String username) {
		Response response = given().pathParam("username", username).when()
				.delete(Routes.delete_url);

		return response;
	}
}
