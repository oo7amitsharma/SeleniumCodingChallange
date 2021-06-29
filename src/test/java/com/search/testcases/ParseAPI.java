package com.search.testcases;
/*
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import org.joda.time.DateTime;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ParseAPI {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String Password = "P@ssw0rd";
		 UUID uuid = UUID.randomUUID();
		 AESEncryptionKantech test = new AESEncryptionKantech();
	        String uuidAsString = uuid.toString();
		RestAssured.baseURI = "Http://192.168.43.117:8801/SmartService/Login?username=kcOy6Y4kOA1rfdn5LGgSZA%3d%3d&password=QvOuYvbV0i5o1AimWHviDg%3d%3d&encrypted=1&ConnectedProgram=3TsBBP3atfHtX38%2fVZzA0MUAPfxL46vp6R18g4ZCacdrho%2fPjwtOx7nJTwHW1KRMC3DH7j5e1CFnBGYZk5MFqfHvWSjQ0GovPqwHLv2ZRJc%3d";
		RestAssured.basePath ="";

		

		
		String connectedProgram = test.DoEncrypt("608d637d-cd3e-4a32-afbd-252d1bbc46b4" + "," + uuidAsString, Password);

		connectedProgram = connectedProgram.substring(0, connectedProgram.length() - 1);

		String HTMLConnectedProgram = URLEncoder.encode(connectedProgram, "utf-8");
		System.out.println(HTMLConnectedProgram);
		RestAssured.baseURI = "Http://192.168.43.117:8801/SmartService/Login?username=kcOy6Y4kOA1rfdn5LGgSZA%3d%3d&password=QvOuYvbV0i5o1AimWHviDg%3d%3d&encrypted=1&ConnectedProgram="+HTMLConnectedProgram;
        
		
		System.out.println(baseURI);
		                  //   "username=kcOy6Y4kOA1rfdn5LGgSZA%3d%3d&password=QvOuYvbV0i5o1AimWHviDg%3d%3d&encrypted=1&ConnectedProgram=3TsBBP3atfHtX38%2fVZzA0MUAPfxL46vp6R18g4ZCacdrho%2fPjwtOx7nJTwHW1KRMC3DH7j5e1CFnBGYZk5MFqfHvWSjQ0GovPqwHLv2ZRJc%3d"
//		RestAssured.basePath="username=kcOy6Y4kOA1rfdn5LGgSZA%3d%3d&password=QvOuYvbV0i5o1AimWHviDg%3d%3d&encrypted=1&ConnectedProgram=3TsBBP3atfHtX38%2fVZzA0MUAPfxL46vp6R18g4ZCacdrho%2fPjwtOx7nJTwHW1KRMC3DH7j5e1CFnBGYZk5MFqfHvWSjQ0GovPqwHLv2ZRJc%3d";
//		Response response = 
//				given()
//				.when()
//					.get(baseURI);
//		System.out.println(response.asString());
		
		LocalDateTime timeNow=LocalDateTime.now();
		
		String params2 = "Http://192.168.43.117:8801/SmartService/Login?" + "userName=" + "kcOy6Y4kOA1rfdn5LGgSZA%3d%3d" + "&" + "password=" +
		                    "QvOuYvbV0i5o1AimWHviDg%3d%3d" + 
		                    "&encrypted=1&SourceId=MOBILEAPP&DateFormat=yyyy-MM-dd&TimeFormat=HH:mm:ss&&LocalDateTime="
				             + timeNow + "&ConnectedProgram="+HTMLConnectedProgram;
		
		System.out.println(params2);

	}
	
	public void logout() {
		RestAssured.baseURI="Http://192.168.43.117:8801/SmartService/Operators?sdKey=e8847343-4c48-44c9-8746-405b3756dd49";
	}

}

*/
