package com.vekomy;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Mahesh
 */
public class Addition extends TagSupport{
    private int one;
    private int two;
    
   
    
    
    public int getOne() {
		return one;
	}


	public void setOne(int one) {
		this.one = one;
	}


	public int getTwo() {
		return two;
	}


	public void setTwo(int two) {
		this.two = two;
	}


	public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            /*Date today = new Date();
            SimpleDateFormat dateFormatter = new SimpleDateFormat(mFormat);
            out.print(dateFormatter.format(today));*/
//            out.println("<input type =\"text\" value = \"vekomy\" >");
        	Properties prop = ReadPropertyFile.getInstance().getProperties(getClass());
        	
            out.println(prop.getProperty("form", "form"));
            
        } catch(IOException ioe) {
            throw new JspException("Error: " + ioe.getMessage());
        }       
        return EVAL_PAGE;
    }
    
    
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}

