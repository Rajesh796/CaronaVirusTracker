package com.example.demo;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class CaronaVirusDataService {
	
	public List<LocationStats> allstats=new ArrayList<>();
	private String virus_data_url="https://raw.githack.com/stccenter/COVID-19-Data/5a9bc4c5a495a751c8298634b5f32288c480ccc1/India/States_level_summary/India_States_summary_covid19_confirmed.csv";
	@PostConstruct
	//@Scheduled(cron="******")
	public void getdata() throws IOException, InterruptedException {
		List<LocationStats> newstat=new ArrayList<>();
		
		HttpClient client=HttpClient.newHttpClient();
		HttpRequest reuqest=HttpRequest.newBuilder().uri(URI.create(virus_data_url)).build();
		HttpResponse<String> response=client.send(reuqest, HttpResponse.BodyHandlers.ofString());
		StringReader string=new StringReader(response.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(string);
		for (CSVRecord record : records) {
			LocationStats locationstat=new LocationStats();
			 Map<String, String> csvMap = record.toMap();

//		    locationstat.setId(csvMap.get("id"));
		    locationstat.setHasc(csvMap.get("hasc"));
		   locationstat.setState(csvMap.get("States"));
		  int latest=Integer.parseInt(csvMap.get("2021-10-19"));
		  int before=Integer.parseInt(csvMap.get("2021-10-04"));
		  int reported=latest-before;
		  locationstat.setTotalcases(Integer.toString(latest));
		  locationstat.setCasesReported(Integer.toString(reported));
		  
		   System.out.println(locationstat);
		   
		   newstat.add(locationstat);
		   
	}
		this.allstats=newstat;
	}
	public List<LocationStats> getAllstats() {
		return allstats;
	}
	public void setAllstats(List<LocationStats> allstats) {
		this.allstats = allstats;
	}
}
