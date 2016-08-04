package com.uhg.esbdb.common.util;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import com.uhg.esbdb.common.constants.EDDCommonConstants;

public class FileIOOperationsUtil {
	
	public static void saveQueueDataTOInboundDirectory(String queueData){
		File file=new File(EDDCommonConstants.BE111_TRIG_FILE_PATH);
		System.out.println(EDDCommonConstants.INBOUND_DIR);
		try{
			FileUtils.writeStringToFile(file, queueData,"UTF-8");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public static String readFileFromInboundDir(){
		String primeMessage=null;
		File file=new File(EDDCommonConstants.BE111_TRIG_FILE_PATH);
		try{
			primeMessage=FileUtils.readFileToString(file, "UTF-8");
		}catch(IOException e){
			e.printStackTrace();
		}
		return primeMessage;
	}
	public static void moveFileToProcessedDirectory() throws IOException{
		File source=new File(EDDCommonConstants.BE111_TRIG_FILE_PATH);
		File destination=new File(EDDCommonConstants.PROCESSED_DIR_PATH);
		
		FileUtils.moveFile(source, destination);
	}
	
	public static void createValidatedInWorkingDirectory(String validatedData) throws IOException{
		File file=new File(EDDCommonConstants.WORKING_DIR_PATH_VALIDATED_FILE);
		try{
			FileUtils.writeStringToFile(file, validatedData,"UTF-8");
		}catch(Exception e){
			System.out.println(e);
		}
	}


}
