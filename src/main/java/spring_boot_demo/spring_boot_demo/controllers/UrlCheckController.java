package spring_boot_demo.spring_boot_demo.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlCheckController {
	private final String IS_SITE_UP = "Site is up!";
	private final String IS_SITE_DOWN = "Site is down!";
	private final String INCORRECT_URL = "URL is incorrect!";	

	@GetMapping("/check")
	public String getUrlStatusMsg(@RequestParam  String url) throws IOException {
		String returnMsg = "";
		try {
			URL objURL = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) objURL.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			// get response status code
			int responseCodeCategory = conn.getResponseCode() / 100;
			if (responseCodeCategory != 2 || responseCodeCategory != 3) {
				returnMsg = this.IS_SITE_DOWN;
			} else {
				returnMsg = this.IS_SITE_UP;
			}
		}catch (MalformedURLException ex) {
			returnMsg = this.INCORRECT_URL;
		} catch (IOException ex) {
			returnMsg = this.IS_SITE_DOWN;
		}

		return returnMsg;
	}
}
