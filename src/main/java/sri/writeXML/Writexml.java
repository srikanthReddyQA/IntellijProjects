package sri.writeXML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class Writexml {
	public static String Homepath = System.getProperty("user.dir");
	public static String testdatasheet = Homepath + "\\DataFile\\Runner.xlsx";
	@SuppressWarnings("rawtypes")
	public static List alltestcases;

	@Test(priority=1)
	public static void getTestcases() {
		
		System.out.println("Read");
		@SuppressWarnings("unused")
		ReadStatus exl = new ReadStatus(testdatasheet);
		alltestcases = ReadStatus.storeTestcaseNeedToExecute("Sheet1");

	}
	@Test(priority=2)
	public static void startWriting() throws ParserConfigurationException, TransformerException {
		
		try
		{

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("suite");
		doc.appendChild(rootElement);

		// set attribute to root element
		Attr attr = doc.createAttribute("name");
		attr.setValue("Suite of Suits");
		rootElement.setAttributeNode(attr);

		// Test
		Element test = doc.createElement("test");
		rootElement.appendChild(test);

		// set attribute to Test element
		Attr testattr = doc.createAttribute("name");
		testattr.setValue("Test");
		test.setAttributeNode(testattr);

		// Classes
		Element classes = doc.createElement("classes");
		test.appendChild(classes);

		// Class

		System.out.println(alltestcases.size());
		for (int i = 0; i <= alltestcases.size() - 1; i++) {

			// Class
			Element classinsideclasses = doc.createElement("class");
			classes.appendChild(classinsideclasses);

			// set attribute to Class element
			Attr classattr = doc.createAttribute("name");
			
			classattr.setValue("sri.srikanth." + alltestcases.get(i).toString());
			classinsideclasses.setAttributeNode(classattr);
		}

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(Homepath + "\\XML\\testng.xml"));

		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");
		}
		catch(Exception e)
		{
			System.out.println("Writing xml is Faild");
		}

	}

	@AfterClass
	public static void runXML() throws InterruptedException {
		
		try
		{

		Thread.sleep(3000);

		// Create object of TestNG Class
		TestNG runner = new TestNG();

		// Create a list of String
		List<String> suitefiles = new ArrayList<String>();

		// Add xml file which you have to execute
		suitefiles.add(Homepath+ "\\XML\\testng.xml");

		// now set xml file for execution
		runner.setTestSuites(suitefiles);

		// finally execute the runner using run method
		
		runner.run();
		}
		catch(Exception e)
		{
			System.out.println("No class found");
		}


	}

}
