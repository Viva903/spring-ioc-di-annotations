package com.viva903.springdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private Random random = new Random();

	private List<String> theFortunesList;
	
	public FileFortuneService() {
		File localFile = new File("fortunes.txt");
		System.out.println("Reading fortunes from file: " + localFile);
		System.out.println("File exists: " + localFile.exists());
		
		try {
			Scanner reader = new Scanner(localFile);
			theFortunesList = new ArrayList<String>();
			
			while (reader.hasNextLine()) {
				theFortunesList.add(reader.nextLine());
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String getFortune() {
		int index = random.nextInt(theFortunesList.size());
		return theFortunesList.get(index);
	}

}
