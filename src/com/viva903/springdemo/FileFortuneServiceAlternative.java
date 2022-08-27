package com.viva903.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneServiceAlternative implements FortuneService {

	private List<String> theFortunes;
	private Random theRandom = new Random();

	public FileFortuneServiceAlternative() {
		File localFile = new File("fortunes.txt");

//		System.out.println("Reading fortunes from file: " + localFile);
//		System.out.println("File exists: " + localFile.exists());

		theFortunes = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(localFile))) {

			String tempLine;
			while ((tempLine = br.readLine()) != null) {
				theFortunes.add(tempLine);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getFortune() {
		int index = theRandom.nextInt(theFortunes.size());
		return theFortunes.get(index);
	}

}
