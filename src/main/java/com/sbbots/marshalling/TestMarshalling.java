package com.sbbots.marshalling;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;

import com.sbbots.type.MySchemaOutput;
import com.sbbots.type.XMLType;

public class TestMarshalling {

	TestMarshalling() {
		
	}

	public static void main(String[] args) {

		JAXBContext jb;
		try {
			jb = JAXBContext.newInstance(XMLType.class);
			
			// Generating the schema output
			SchemaOutputResolver outputResolver = new MySchemaOutput();
			outputResolver.createOutput("", "../workspace/Marshalling/src/main/java/com/sbbots/marshalling/type.xsd");
			jb.generateSchema(outputResolver);
			
			//Marshalling
			Marshaller m = jb.createMarshaller();

			XMLType t = new XMLType();
			t.setName("Name");
			t.setValue("Value");

			m.marshal(t, new File(
					"../workspace/Marshalling/src/main/java/com/sbbots/marshalling/type.xml"));

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
