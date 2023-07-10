package api.endpoints;

/*
 *  CRUD operation and end-points
 * 1) Create User (POST)   = https://petstore.swagger.io/v2/user
 * 2) Read   User (GET)    = https://petstore.swagger.io/v2/user/{username}
 * 3) Update User (PUT)    = https://petstore.swagger.io/v2/user/{username}
 * 4) Delete User (Delete) = https://petstore.swagger.io/v2/user/{username}

 */
public class Routes {

	// STATIC variables
	public static String base_url = "https://petstore.swagger.io/v2";

	// end-point URLs
	public static String post_url = base_url + "/user";
	public static String get_url = base_url + "/user/{username}";
	public static String update_url = base_url + "/user/{username}";
	public static String delete_url = base_url + "/user/{username}";

}
