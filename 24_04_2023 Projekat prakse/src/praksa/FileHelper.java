package praksa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
	
		// javna staticka metoda koja cita podatke iz fajla i vraca string

	public static String loadMetaData() {
		StringBuffer characterData = new StringBuffer();			// StringBuffer je klasa slicna Stringu, ali koja moze da se modifikuje...
		File file = new File("resource/got_meta_data.txt");			// ...bez potrebe za pravljenjem novog objekta

		try {
			BufferedReader buffer = new BufferedReader(new FileReader(file));		// otvara se bufferedreader...
			String aLine;
			while ((aLine = buffer.readLine()) != null) {							// ...koji cita red po red, dok ima redova...
				characterData.append(aLine);										// ...i dodaje ih
				characterData.append(System.lineSeparator());
			}
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return characterData.toString();
	}
	
		// javna staticka metoda koja cita podatke iz fajla, svaki red cuva kao string i pohranjuje u listu koju vraca

	public static List<String> loadMessages(String fileName) {
		List<String> messages = new ArrayList<String>();
		File file = new File("resource/message_logs/" + fileName);

		try {
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String aLine;
			while ((aLine = buffer.readLine()) != null) {
				messages.add(aLine);
			}
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return messages;
	}

}
