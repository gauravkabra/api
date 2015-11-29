package com.shadow.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.shadow.entity.User;
import com.shadow.model.AllRequests;
import com.shadow.model.Credentials;
import com.shadow.model.UserModel;
import com.shadow.service.LoginService;
import com.shadow.service.RequestService;
import com.shadow.service.impl.LoginServiceImpl;
import com.shadow.util.HashingService;
import com.shadow.util.impl.HashingServiceImpl;

@Path("/login")
public class LoginResource {

	private LoginService loginService;

	private RequestService requestService;

	private HashingService hashingService;

	@GET
	@Produces("application/json")
	public Response login_test() {
		Credentials c = new Credentials();
		c.setPassword("as");
		return Response.ok(c).build();

	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response login(Credentials cred) {
		loginService = new LoginServiceImpl();
		hashingService = new HashingServiceImpl();
		User user = loginService.getUser(cred.getUsername());
		if (user == null) {
			return Response.serverError().build();
		}
		String hash = hashingService.hash(cred.getPassword(), user.getSalt());
		if (hash.equals(user.getPassword())) {
			if (cred.getRole() != null && cred.getRole().equals("MANAGER")) {
				AllRequests allRequests = requestService.getAllRequests(cred
						.getUsername());
				return Response.ok(allRequests).build();
			}
			return Response.ok().build();
		} else {
			return Response.serverError().build();
		}
	}

	@POST
	@Path("/register")
	@Consumes("application/json")
	@Produces("application/json")
	public Response register(UserModel userModel) {
		loginService = new LoginServiceImpl();
		hashingService = new HashingServiceImpl();
		User user = new User();
		user.setUserName(userModel.getUsername());
		user.setFirstName(userModel.getFirstName());
		user.setLastName(user.getLastName());
		user.setContactNumber(userModel.getContactNumber());
		String salt = hashingService.salt();
		String hash = hashingService.hash(userModel.getPassword(), salt);
		user.setSalt(salt);
		user.setPassword(hash);
		loginService.addUser(user);
		return Response.ok(userModel).build();

	}
}
