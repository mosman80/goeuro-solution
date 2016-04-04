package com.goeuro.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;


public class ExportFile {	
		
	private static String FILE_EXTENTION = ".csv";
	private static char   SEPRATOR = ',';
	private static String GENERATED_FILE_PROPERTY="generated.file";
	final static Logger   logger = Logger.getLogger(ExportFile.class);
	
	public <T> boolean exportCSVFile(String fileName,Object data, Class<T> cls) throws IOException {

		try{
			// create mapper and schema
			CsvMapper mapper = new CsvMapper();		
			CsvSchema schema = mapper.schemaFor(cls).withHeader();
			schema = schema.withColumnSeparator(SEPRATOR);
			ObjectWriter myObjectWriter = mapper.writer(schema);
			
	        String filePath = ConfigurationUtil.getInstance().getWsProperty(GENERATED_FILE_PROPERTY);
	        
	        File dir = new File(filePath);
	        if(!dir.exists()){
	        	dir.mkdir();
	        }
	        File tempFile = new File(filePath+fileName+FILE_EXTENTION);
	        
	        FileOutputStream tempFileOutputStream = new FileOutputStream(tempFile);
	        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(tempFileOutputStream, 1024);
	        OutputStreamWriter writerOutputStream = new OutputStreamWriter(bufferedOutputStream);
	        myObjectWriter.writeValue(writerOutputStream, data);
	        writerOutputStream.close();
	        logger.info("Success to write details of \""+fileName +"\" to the following file \""+tempFile.getPath()+"\"");
		}catch(Exception e){
			logger.info("Faild to export data to CSV file:");
			logger.error(e.getMessage(),e);
			return false;
		}
		return true;
	}
	
	

}
