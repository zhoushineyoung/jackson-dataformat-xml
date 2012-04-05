package com.fasterxml.jackson.dataformat.xml;

import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.annotation.*;

public class TestTextValue extends XmlTestBase
{
    /*
    /**********************************************************
    /* Helper types
    /**********************************************************
     */

	static class Simple
	{
		@JacksonXmlProperty(isAttribute=true)
		// same as: @javax.xml.bind.annotation.XmlAttribute
		public int a = 13;

		@JacksonXmlText
		// about same as: @javax.xml.bind.annotation.XmlValue
		public String text = "something";
	}
	
    /*
    /**********************************************************
    /* Unit tests
    /**********************************************************
     */

    public void testSimpleAsText() throws IOException
    {
    	XmlMapper mapper = new XmlMapper();
    	String xml = mapper.writeValueAsString(new Simple());
    	assertEquals("<Simple a=\"13\">something</Simple>", xml);
    }
    
    /* // Uncomment to see how JAXB works here:
    public void testJAXB() throws Exception
    {
        java.io.StringWriter sw = new java.io.StringWriter();
        javax.xml.bind.JAXB.marshal(new Simple(), sw);
        System.out.println("JAXB -> "+sw);
    }
    */
}