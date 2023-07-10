package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;

	@BeforeClass
	public void setupData() {
		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}

	@Test(priority = 1)
	public void testPostUser() {
		Response postResp = UserEndPoints.createUser(userPayload);
		postResp.then().log().all();

		Assert.assertEquals(postResp.getStatusCode(), 200);
	}

	@Test(priority = 2)
	public void testGetUser() {
		Response getResp = UserEndPoints.readUser(userPayload.getUsername());
		getResp.then().log().all();

		Assert.assertEquals(getResp.getStatusCode(), 200);
	}
}
