package com.nseit.rest.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestCtrClientPost {
	
	public static void main(String[] args) {

		try {

			Client client = Client.create();

			//Original
			WebResource webResource = client.resource("http://localhost:8080/OESRestWebService/rest/json/tstctr/post");
			
			//JSON Supported
			//WebResource webResource = client.resource("http://localhost:8080/OESRest/rest/json/tstctrsummary/post");

			String input = "{\"resPullFlag\":\"ALERT1\",\"module_Count\":\"1\",\"appear\":\"150\",\"code\":\"9999\",\"clupFlag\":\"ALERT\",\"pullTime\":\"09:07:03\",\"session\":\"10:00-12:00\",\"sessionEnd\":\"06:22:03\",\"batStartFlag\":\"ALERT\",\"bkupFlag\":\"ALERT\",\"cnt\":\"100\",\"canStartTime\":\"09:45:45\",\"present\":\"25\",\"moduleName\":\"NSS1-E\",\"resPushTime\":\"06:22:03\",\"event_name\":\"NSEIT Limited - Nagpur\",\"totCand\":\"100\",\"clnupTime\":\"06:30:30\",\"batEndFlag\":\"ALERT\",\"qBankPullFlag\":\"ALERT\",\"resPushFlag\":\"ALERT\",\"resultMode\":\"FTP\",\"absenCand\":\"20\",\"resPullTime\":\"06:30:30\",\"bkupTime\":\"06:30:30\",\"canEndTime\":\"06:30:30\"}";
			
			ClientResponse response = webResource.type("application/json")
					.post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}



}
