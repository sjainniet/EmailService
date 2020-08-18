package com.sidj.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailContentBuilder {
 
    private TemplateEngine templateEngine;
 
    @Autowired
    public MailContentBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }
 
    public String build(String message, String typ) {
        Context context = new Context();
        String templateName = "";
        context.setVariable("message", message);
        
        if(typ.equals("SHIP_SMS"))
        	templateName="shippingMail";
        else if (typ.equals("SUCC_SMS"))
        	templateName="successMail";
        else if (typ.equals("DELI_SMS"))
        	templateName="deliveryMail";
        else if (typ.equals("PROM_SMS"))
        	templateName="mailTemplate";
        
        
        return templateEngine.process(templateName, context);
        
        
    }
 
}
