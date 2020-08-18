package com.sidj.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/mail")
public class EmailController {
	
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	@Autowired
	private MailContentBuilder mailContentBuilder;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private ResMail resmail;
	
	@RequestMapping(value = "/send")
	   public String sendEmailTxt() {
		String to = "sjxplor@gmail.com";
		String from = "siddharth@dacorp.in";
		String subject = "Update for Your Account on womansadda";
		String text = "Dear SIddharth, Thanks For Registering.";
		String res = null;
		try 
		{
			emailServiceImpl.sendSimpleMessage(to, subject, text, from);
			res = "Mail Sent Successfully.";
		}
		catch (Exception e) {
			res = "Mail in CATCH Error =:=  " +e.getMessage();
		}
		
	      return res;
	   } 
	
	@RequestMapping(value = "/sendform")
	   public String sendMailTemp() {
		String to = "sjxplor@gmail.com";
		String from = "noreply-womansadda@dacorp.in";
		String subject = "Sample Mail with Attachment API";
		String message = "Dear SIddharth, Thanks For Registering.";
		String res = null;
		try 
		{
			MimeMessagePreparator messagePreparator = mimeMessage -> {
		        // ... 
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
		        messageHelper.setFrom(from);
		        messageHelper.setTo(to);
		        messageHelper.setReplyTo("sjainsid@gmail.com");
		        messageHelper.setSubject(subject);
		        messageHelper.setBcc("saum1991@gmail.com");
		        String content = mailContentBuilder.build(message,"SUCC_SMS");
		        messageHelper.setText(content,true);
		        FileSystemResource file = new FileSystemResource("C:/Users/A172CTDI/Desktop/NOC_Siddharth_Jain.docx");
		        messageHelper.addAttachment(file.getFilename(), file);
		        
		        
		    };
		 
		    mailSender.send(messagePreparator);
		    res = "Mail Sent Successfully.";
		}
		catch (Exception e) {
			res = "Mail in CATCH Error =:=  " +e.getMessage();
		}
		
	      return res;
	   } 
	
	  /* @RequestMapping(method=RequestMethod.POST,value = "/sendmailtemplate")
	   public String sendMailwithTemplates(@RequestBody ReqMail reqmail) {
		String to = reqmail.getMailTo();
		String typ = reqmail.getMailType();
		String from = "siddharth@dacorp.in";
		String subject = "";
		String message = "";
		if(typ.equals("SUCC_SMS"))
		{
			subject ="ORDER PLACED.. WOMAN's ADDA Order Confirmation";
			message = "Thanks for your order \n Here's your confirmation for order. \n We will be soon processing your order. ";
		}
		else if(typ.equals("SHIP_SMS"))
		{
			subject ="ORDER SHIPPED.. WOMAN's ADDA Order Notification";
			message = "You can track your order on http://www.womansadda.com/track.htm?s="+reqmail.getMailData();
		}
		else if(typ.equals("DELI_SMS"))
		{
			subject ="Thankyou for Your Order. WOMAN's ADDA Order Confirmation";
			message = "Dear Customer, \n Your order has been delivered successfully.\n Please rate us at https://www.facebook.com/womansaddaindia \n Keep shopping with us..  \n For any concern please visit our website to talk to our customer care. \\n Thanks a lot.. \\n Team WOMAN's ADDA";
		}
		
		String subjectfinal = subject ;
		String messagefinal = message;
	
		//String message = "Dear SIddharth, Thanks For Registering.";
		String res = null;
		try 
		{
			MimeMessagePreparator messagePreparator = mimeMessage -> {
		        // ... 
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
		        messageHelper.setFrom(from);
		        messageHelper.setTo(to);
		        messageHelper.setSubject(subjectfinal);
		        String content = mailContentBuilder.build(messagefinal,reqmail.getMailType());
		        if (reqmail.getMailfile()==1 && reqmail.getFilePath()!="" && reqmail.getFilePath()!=null)
		        {
		        	 //for attachment
			        FileSystemResource file = new FileSystemResource(reqmail.getFilePath());
			        messageHelper.addAttachment(file.getFilename(), file);
		        }
		        messageHelper.setText(content,true);
		        
			};
		 
		    mailSender.send(messagePreparator);
		    res = "Mail Sent Successfully.";
		}
		catch (Exception e) {
			res = "Mail in CATCH Error =:=  " +e.getMessage();
		}
		
	      return res;
	   }*/ 
	   
	   
	   
	   @RequestMapping(method=RequestMethod.POST,value = "/sendmailtemplate")
	   public ResMail sendMailwithTemplates(@RequestBody ReqMail reqmail) {
		String to = reqmail.getMailTo();
		String typ = reqmail.getMailType();
		//String from = "noreply-womansadda@dacorp.in";
		String from="orders.womansadda@dacorpindia.com";
		String subject = "";
		String message = "";
		if(typ.equals("SUCC_SMS"))
		{
			subject ="Order Placed | WOMAN's ADDA Order Confirmation"; 
			message = "Confirmed..";  
		}
		else if(typ.equals("SHIP_SMS"))
		{
			subject ="Order Shipped | WOMAN's ADDA Order Status";
			message = "You can track your order with Tracking Number "+reqmail.getMailData()+". Click on this link to track your order. "+" http://www.womansadda.com/track.htm?s="+reqmail.getMailData();
		}
		else if(typ.equals("DELI_SMS"))
		{
			subject ="Order Delivered | WOMAN's ADDA Notification";
			message = "Delivered..";
		}
		else if(typ.equals("PROM_SMS"))
		{
			subject ="New Arrivals | WOMAN's ADDA Notification";
			message = reqmail.getMailData();
		}
		
		String subjectfinal = subject ;
		String messagefinal = message;
	
		//String message = "Dear SIddharth, Thanks For Registering.";
		//String res = null;
		try 
		{
			MimeMessagePreparator messagePreparator = mimeMessage -> {
		        // ... 
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
		        messageHelper.setFrom(from);
		        messageHelper.setTo(to);
		        messageHelper.setReplyTo("womansaddaindia@gmail.com");
		        messageHelper.setCc("womansaddaindia@gmail.com");
		        messageHelper.setSubject(subjectfinal);
		        String content = mailContentBuilder.build(messagefinal,reqmail.getMailType());
		        if (reqmail.getMailfile()==1 && reqmail.getFilePath()!="" && reqmail.getFilePath()!=null)
		        {
		        	 //for attachment
			        FileSystemResource file = new FileSystemResource(reqmail.getFilePath());
			        messageHelper.addAttachment(file.getFilename(), file);
		        }
		        messageHelper.setText(content,true);
		        
			};
		 
		    mailSender.send(messagePreparator);
		    resmail.setResult("Mail Sent Successfully.");
		}
		catch (Exception e) {
			//res = "Mail in CATCH Error =:=  " +e.getMessage();
			resmail.setResult("Mail in CATCH Error =:=  "+e.getMessage());
		}
		
	      return resmail;
	   } 
	
	

}
