package com.shadow.resource;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.shadow.entity.AccountOpeningRequest;
import com.shadow.entity.User;
import com.shadow.model.AadharDetails;
import com.shadow.model.AccountDetails;
import com.shadow.model.AllRequests;
import com.shadow.model.Authorize;
import com.shadow.model.Request;
import com.shadow.service.LoginService;
import com.shadow.service.RequestService;
import com.shadow.service.impl.LoginServiceImpl;
import com.shadow.service.impl.RequestServiceImpl;
import com.shadow.util.SendMessage;

@Path("/request")
public class RequestResource {

	private Map<String, Integer> otpMap = new HashMap<>();
	private LoginService loginService;
	private RequestService requestService;

	private static Integer otp = 123456;

	@POST
	@Path("/auth")
	@Consumes("application/json")
	@Produces("application/json")
	public Response auth(Authorize auth) {
		loginService = new LoginServiceImpl();
		User user = loginService.getUser(auth.getUser());
		// Call for OTP
		SendMessage message = new SendMessage();
		otp = 123456;
		message.sendMessage(user.getContactNumber(),
				"One time password for your Aadhar Authentication is " + otp);
		otpMap.put(auth.getUser(), otp);
		return Response.ok().build();
	}

	@POST
	@Path("/otp")
	@Consumes("application/json")
	@Produces("application/json")
	public Response otpCheck(Authorize auth) {
		System.out.println("In OTP Check");
		if (auth.getUser() == null || auth.getOtp() == null) {
			return Response.noContent().build();
		}
		if (otpMap.get(auth.getUser()) != null
				&& Integer.parseInt(auth.getOtp()) == otpMap
						.get(auth.getUser())) {
			AadharDetails details = new AadharDetails();
			details.setAadharId("999999990019");
			details.setName("Shivshankar Choudhury");
			details.setDob("dob=13-05-1968");
			details.setGender("M");
			details.setPhone("2810806979");
			details.setEmail("sschoudhury@dummyemail.com");
			details.setAddress1("12 Maulana Azad Marg");
			details.setSubDistrict("New Delhi");
			details.setDistrict("New Delhi");
			details.setPincode("110002");
			return Response.ok(details).build();
		}
		return Response.serverError().build();
	}

	@POST
	@Path("/account")
	@Consumes("application/json")
	@Produces("application/json")
	public Response saveAccount(AccountDetails auth) {
		requestService = new RequestServiceImpl();
		loginService = new LoginServiceImpl();
		User user = loginService.getUser(auth.getUser());
		AccountOpeningRequest request = new AccountOpeningRequest();
		request.setAadharNumber(auth.getAadharNumber());
		request.setAddress1(auth.getAddress1());
		request.setAddress2(auth.getAddress2());
		request.setAddress3(auth.getAddress3());
		request.setAlternateAddress(auth.getAlternateAddress());
		request.setContactNumber(auth.getContactNumber());
		request.setEmailId(auth.getEmailId());
		request.setFirstName(auth.getFirstName());
		request.setLastName(auth.getLastName());
		request.setNationality(auth.getNationality());
		request.setSalary(auth.getSalary());
		request.setStatus("PENDING");
		request.setUser(user);
		requestService.saveRequest(request);
		return Response.ok(request).build();

	}

	@GET
	@Produces("application/json")
	public Response getAllRequests(Authorize auth) {
		requestService = new RequestServiceImpl();
		AllRequests requests = requestService.getAllRequests(auth.getUser());
		return Response.ok(requests).build();
	}

	@POST
	@Path("/close")
	@Consumes("application/json")
	@Produces("application/json")
	public Response closeRequest(Request request) {
		requestService = new RequestServiceImpl();
		Request requests = requestService.closeRequest(request);
		return Response.ok(requests).build();
	}

}
