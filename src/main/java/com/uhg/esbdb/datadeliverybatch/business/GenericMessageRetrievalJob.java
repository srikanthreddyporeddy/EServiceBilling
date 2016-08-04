package com.uhg.esbdb.datadeliverybatch.business;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import com.uhg.esbdb.common.exception.EDBException;
import com.uhg.esbdb.common.util.FileIOOperationsUtil;
import com.uhg.esbdb.datadeliverybatch.beans.BE111CaseStructureRecordBean;
import com.uhg.esbdb.common.constants.EDDCommonConstants;
import com.uhg.esbdb.common.email.ESBMailSendingTemplate;

public class GenericMessageRetrievalJob {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		  ApplicationContext context = new ClassPathXmlApplicationContext(EDDCommonConstants.GENERICMESSAGERETRIEVALCONTEXTNAME);
		  
		  JmsTemplate jmsTemplate=(JmsTemplate) context.getBean("jmsTemplate");
		  System.out.println(EDDCommonConstants.START);
		  Message receivedMessage=jmsTemplate.receive(EDDCommonConstants.BE111_QUEUE_NAME);
		  
		  ActiveMQTextMessage msg = (ActiveMQTextMessage)receivedMessage;
		  System.out.println("Receiving the date from Queue:"+EDDCommonConstants.BE111_QUEUE_NAME);
		  System.out.println(EDDCommonConstants.INBOUND_DIR);
		  System.out.println("Message Received :"+msg.getText());
		  
		  System.out.println("Saving Queue data to file.......");
		  FileIOOperationsUtil.saveQueueDataTOInboundDirectory(msg.getText().toString());
		  
		  BE111PrimeCaseStructureProcessor be111PrimeCaseStructureProcessor=new BE111PrimeCaseStructureProcessor();
		  List<BE111CaseStructureRecordBean> list=be111PrimeCaseStructureProcessor.processPrimeMessageData();
		  
		  System.out.println("Saving the validated data in the working directory.");
		  FileIOOperationsUtil.createValidatedInWorkingDirectory(list.toString());
		  
		 // ESBMailSendingTemplate.sendMailWithAttachment();
		  App.mailSent();
	}
	
}
