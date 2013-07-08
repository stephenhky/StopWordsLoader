package home.kwyho.stopwords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class StopWordCollections {
	private List<String> stopWordList;
	
	public StopWordCollections(String filename) throws IOException {
		this(new File(filename));
	}
	
	public StopWordCollections(File inFile) throws IOException {
		stopWordList = new ArrayList<String>();
		Reader fileReader = new FileReader(inFile);
		BufferedReader reader = new BufferedReader(fileReader);
		
		String line = "";
		while ((line=reader.readLine())!=null) {
			stopWordList.add(line.trim().replaceAll("[^A-Za-z]", "").toLowerCase());
		}
		reader.close();
	}

	public List<String> getStopWordList() {
		return stopWordList;
	}

	public void setStopWordList(List<String> stopWordList) {
		this.stopWordList = stopWordList;
	}
	
	public Boolean isStopWord(String word) {
		return stopWordList.contains(word);
	}
}
