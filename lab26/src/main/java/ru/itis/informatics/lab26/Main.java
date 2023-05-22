package ru.itis.informatics.lab26;

import javax.net.ssl.HttpsURLConnection;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
	private static String getPlainTextFromHTML(final String htmlLine) {
		return htmlLine.replaceAll("<.*?>|&.*?;", "");
	}

	public static void main(String[] args) {

		try {
//			URL url = new URL("https://kpfu.ru/Michael.Abramsky");
//			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
//
//			int r = connection.getResponseCode();
//
//			System.out.println(r);
//
//			InputStream is = connection.getInputStream();
//
//			FileOutputStream fos = new FileOutputStream("abramsky.html");
//
//			is.transferTo(fos);
//
//			fos.flush();
//
//			is.close();
//			fos.close();

			List<String> htmlLines = Files.readAllLines(Paths.get("abramsky.html"), Charset.forName("cp1251"));

			for (String line : htmlLines) {
				if (line.contains("<div class=\"top_menu_div_in\"><span>")) {
					System.out.println(getPlainTextFromHTML(line));
				}
				if (line.contains("font-weight:bold;width:420px;margin-bottom:2px;")) {
					System.out.println(getPlainTextFromHTML(line) + ": ");
				}
				if (line.contains("class=\"li_spec\"")) {
					System.out.println(getPlainTextFromHTML(line));
				}
				if (line.contains("<tr><td  align=\"left\" valign=\"top\">")) {
					System.out.println(getPlainTextFromHTML(line));
				}
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}