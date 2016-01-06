package com.sbbots.marshalling;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.sbbots.type.XMLType;

public class TestUnmarshalling {

	TestUnmarshalling() {

	}

	public static void main(String[] args) {
		try {

			JAXBContext jb = JAXBContext.newInstance(XMLType.class);
			Unmarshaller m = jb.createUnmarshaller();

			XMLType xml = (XMLType) m.unmarshal(new File(
					"/Users/Maansy/Documents/workspace/Marshalling/src/main/java/com/sbbots/marshalling/type.xml"));
			System.out.println(xml.getName());
			System.out.println(xml.getValue());

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
