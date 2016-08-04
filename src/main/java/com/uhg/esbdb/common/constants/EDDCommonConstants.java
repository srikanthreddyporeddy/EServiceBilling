package com.uhg.esbdb.common.constants;

public interface EDDCommonConstants {
	
	//date formats
	String DATEFORMAT01 = "yyyyMMddHHmmss";
	String START="Started Job For DataDelivery Batch";
	String INBOUND_DIR="Saving The Queue Data To The Inbound Directory";
	String PROCESSED_DIR_PATH="C:/EnvironmentPaths/edb/lcl/data/ProcessedDirectory/be111Limited.trig";
	String WORKING_DIR_PATH="C:/EnvironmentPaths/edb/lcl/data/WorkingDirectory/be111Limited.trig";
	String WORKING_DIR_PATH_VALIDATED_FILE="C:/EnvironmentPaths/edb/lcl/data/WorkingDirectory/be111LimitedValidated.txt";
	String BE111_QUEUE_NAME="A5701DSR.BE111_EBILL_CASE_STRUCTURE_QUEUE";
	String GENERICMESSAGERETRIEVALCONTEXTNAME = "com/uhg/esbdb/datadeliverybatch/configs/BE111CaseStructureContext.xml";
	String BE111_TRIG_FILE_PATH="C:/EnvironmentPaths/edb/lcl/data/InboundDirectory/be111Limited.trig";
	String CHECK_RECORD_TYPE="Checking whether the file is containing valid record";
	String MOVE_VALID_FILE_TO_PROCESSED_DIR="Valid Data file. Moving The .trig File To Processed Directory";
	String VALID_RECORD="Valid Record";
	String INVALID_REDORD="InValid Record type";
	String VALIDATION_MSG="Validation Starts From Here For Sections";
	String SEVEN_BYTES_SPACE ="       ";
	String THREE_BYTES_SPACE = "   ";
	String SIX_BYTES_SPACE = "      ";
	String THIRTY_NINE_BYTES_SPACE = "                                       ";
	String EMPTY_SPACE = " ";
	String NON_EMPTY_SPACES = "";
	String HYPHEN = "-";
	String FOURTY_SIX_BYTES_SPACE = "                                              ";
	String SEVENTEEN_BYTES_SPACE = "                 ";
	String TWELEVE_BYTES_SPACE = "            ";
	String ONE_BYTES_SPACE = " ";
	String TWO_BYTES_SPACE = "  ";
	String EIGHT_BYTES_SPACE = "        ";
	String FIVE_BYTES_SPACE = "     ";
	String TRUE_STATUS = "1";
	String PROCESSING_SENDING_MAIL = "Sending mail in Process............";
	String PROCESSED_SENDING_MAIL = "Mail Sending process Finished";
}
