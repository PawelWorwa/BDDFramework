package com.bdd.framework.reporting;

import com.bdd.framework.exceptions.ReportGenerationException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Report {
    private static final Logger LOGGER = LogManager.getLogger(Report.class);

	private static final String REPORT_DIRECTORY = "target";
	private static final String JSON_REPORT_DIRECTORY = "target/cucumber-parallel";
	private static List<String> jsonFiles = new ArrayList<>();

	private static void generateReport() {
		File reportDirectory = new File(REPORT_DIRECTORY);
		String projectName = "Functional tests";

		Configuration configuration = new Configuration(reportDirectory, projectName);
		configuration.setParallelTesting(true);
		configuration.setRunWithJenkins(false);
		configuration.setBuildNumber("1");

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
	}

	private static void handleError(String eMessage) throws ReportGenerationException {
        LOGGER.error(eMessage);
        throw new ReportGenerationException(eMessage);
    }

	public static void main(String[] args) throws ReportGenerationException {
		File folder = new File(JSON_REPORT_DIRECTORY);
		File[] files = folder.listFiles();

		if (files == null) {
		    String eMessage = "Report folder does not exist: " + JSON_REPORT_DIRECTORY;
            handleError(eMessage);

		} else if(files.length == 0) {
            String eMessage = "No Cucumber reports were found.";
            handleError(eMessage);

        } else {
            for (File file : files) {
                String fileName = file.getName();
                jsonFiles.add(JSON_REPORT_DIRECTORY + "/" + fileName);
            }

            Report.generateReport();
        }
	}
}