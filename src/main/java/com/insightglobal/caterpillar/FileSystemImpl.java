package com.insightglobal.caterpillar;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringJoiner;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class FileSystemImpl implements Service {
	@Override
	public Object get(String key) {
		String[] values = null;
		try (CSVReader csvReader = new CSVReader(new FileReader("cache.csv"));) {

			while ((values = csvReader.readNext()) != null) {

				if (values[0].equals(key)) {
					break;
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (values == null) ? "Key not present in filesystem" : values[1];

		// String[] values = null;
		// StringJoiner joiner = new StringJoiner(" ");
		// try (CSVReader csvReader = new CSVReader(new FileReader("cache.csv"));) {
		//
		// while ((values = csvReader.readNext()) != null) {
		//
		// if (values[0].equals(key)) {
		// joiner.add(values[1]);
		//
		// }
		// }
		//
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// return joiner;

	}

	@Override
	public void put(String key, Object value) {

		CSVWriter writer;
		try {
			writer = new CSVWriter(new FileWriter("cache.csv", true));

			// Create record
			String[] record = { key, (String) value };

			// Write the record to file
			writer.writeNext(record);

			// close the writer
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
