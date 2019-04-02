package main;

import java.io.IOException;
import java.util.List;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.SAXException;


public class Main {
	static String origin = "<abc    attr=\"value1\"    title=\"something\">   </abc>";
	static String target="<aabc attr=\"value1\" title=\"something\"></aabc>";
	public static void main(String[] args) throws SAXException, IOException {
		
		
		System.out.println(comparar(origin,target));
	}
	
	public static boolean comparar(String r1, String r2) throws SAXException, IOException {
		XMLUnit.setIgnoreWhitespace(true);
		XMLUnit.setIgnoreAttributeOrder(true);
		
		DetailedDiff comparacion = new DetailedDiff(XMLUnit.compareXML(r1, r2));
		List<?> diferencias = comparacion.getAllDifferences();
		
		if(diferencias.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
		
	}

}
