package com.shadow.util;

import java.util.LinkedHashMap;

import com.plivo.helper.api.client.RestAPI;
import com.plivo.helper.api.response.message.MessageResponse;
import com.plivo.helper.exception.PlivoException;

public class SendMessage {

	public void sendMessage(String number, String otp) {
		String authId = "MAOGMWYTYWODG3YZAZZD";
		String authToken = "OWZiMDMyNjdmY2YzNjVlMTU0MzcxYzk1N2U5Y2Q3";
		RestAPI api = new RestAPI(authId, authToken, "v1");

		LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
		parameters.put("src", "919557777321"); // Sender's phone number with
												// country code
		parameters.put("dst", "919986300023"); // Receiver's phone number with
												// country
		// code
		parameters.put("text", otp + ""); // Your SMS text message
		// Send Unicode text
		parameters.put("url",
				"https://api.plivo.com/v1/Account/{auth_id}/Message/"); // The
																		// URL
																		// to
																		// which
																		// with
																		// the
																		// status
																		// of
																		// the
																		// message
																		// is
																		// sent
		parameters.put("method", "POST"); // The method used to call the url

		try {
			// Send the message
			MessageResponse msgResponse = api.sendMessage(parameters);

			// Print the response
			System.out.println(msgResponse);
			// Print the Api ID
			System.out.println("Api ID : " + msgResponse.apiId);
			// Print the Response Message
			System.out.println("Message : " + msgResponse.message);

			if (msgResponse.serverCode == 202) {
				// Print the Message UUID
				System.out.println("Message UUID : "
						+ msgResponse.messageUuids.get(0).toString());
			} else {
				System.out.println(msgResponse.error);
			}
		} catch (PlivoException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	public static void main(String[] args) {
	}
}
