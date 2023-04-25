package praksa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

	public static String loadMetaData() {
		StringBuffer characterData = new StringBuffer();
		File file = new File("resource/got_meta_data.txt");

		try {
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String aLine;
			while ((aLine = buffer.readLine()) != null) {
				characterData.append(aLine);
				characterData.append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return characterData.toString();
	}

	public static List<String> loadMessages(String fileName) {
		List<String> messages = new ArrayList<String>();
		File file = new File("resource/message_logs/" + fileName);

		try {
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String aLine;
			while ((aLine = buffer.readLine()) != null) {
				messages.add(aLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return messages;
	}

}
