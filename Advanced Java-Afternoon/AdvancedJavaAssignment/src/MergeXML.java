import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MergeXML {
	
	public static void mergeDocuments(Document doc1, Document doc2, Document writeDocument) throws TransformerFactoryConfigurationError, TransformerException, IOException {
		Element root = writeDocument.createElement("CSR_Producer");
		writeDocument.appendChild(root);
		
		NodeList nList1 = doc1.getElementsByTagName("CSR_Producer");
        NodeList nList2 = doc2.getElementsByTagName("CSR_Producer");
        
		for(int i=0; i<nList1.getLength(); i++) {
			Node node1 = nList1.item(i);
			
			if(node1.getNodeType() == Node.ELEMENT_NODE) {
				Element ele1 = (Element) node1;
	            
	            for(int j=0; j<nList2.getLength(); j++) {
	            	Node node2 = nList2.item(j);
	            	
	            	if(node1.getNodeType() == Node.ELEMENT_NODE) {
	            		Element ele2 = (Element) node2;
		                
		                if(ele1.getAttribute("NIPR_Number").equals(ele2.getAttribute("NIPR_Number"))) {
		                	NodeList licenseList1 = ele1.getChildNodes();
		                    NodeList licenseList2 = ele2.getChildNodes();
		                    
		                    for(int k=0; k<licenseList1.getLength(); k++) {
		                    	Node license1 = licenseList1.item(k);
		                    	
		                    	if(license1.getNodeType() == Node.ELEMENT_NODE) {
		                    		Element license1Element = (Element) license1;
		                    		
		                    		for(int l=0; l<licenseList2.getLength(); l++) {
		                    			Node license2 = licenseList2.item(l);
		                    			
		                    			if(license2.getNodeType() == Node.ELEMENT_NODE) {
		                    				Element licence2Element = (Element) license2;
		                    				
		                    				if ((license1Element.getAttribute("Date_Status_Effective").equals(licence2Element.getAttribute("Date_Status_Effective")))
		                    						&& (license1Element.getAttribute("State_Code").equals(licence2Element.getAttribute("State_Code")))
		                    							&& (license1Element.getAttribute("License_Number").equals(licence2Element.getAttribute("License_Number")))) {
		                    					Node licenceToAdded = writeDocument.importNode(licence2Element, true) ;
		                                        root.appendChild(licenceToAdded) ;
		                                        File file = new File("src/mergedXMLFile.xml");
		                                        file.createNewFile();
		                                        Transformer transformer = TransformerFactory.newInstance().newTransformer();
		                                        transformer.transform(new DOMSource(writeDocument), new StreamResult(file));
		                    				}
		                    			}
		                    		}
		                    	}
		                    }
		                }
	            	}
	            }
			}
		}
	}

	public static void validOrInvalid(Document doc1, Document doc2, Document validDoc, Document invalidDoc) throws TransformerException, IOException {
		//Creating root element for VALID LICENSES
		Element validRoot = validDoc.createElement("Valid_Licences");
		validDoc.appendChild(validRoot);
		
		//Creating root element for INVALID LICENSES
		Element invalidRoot = invalidDoc.createElement("Invalid_Licences");
		invalidDoc.appendChild(invalidRoot);
		
		NodeList nList1 = doc1.getElementsByTagName("License");
        NodeList nList2 = doc2.getElementsByTagName("License");
        
        //For each LICENSE NodeList in DOCUMENT 1 
        for(int i=0; i<nList1.getLength(); i++) {
        	Node license = nList1.item(i);
            Element licenseElement = (Element) license;
            
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String expirationDate = licenseElement.getAttribute("License_Expiration_Date");
            LocalDate licenseExpirationDate = LocalDate.parse(expirationDate, dateTimeFormatter);
            LocalDate today = LocalDate.now();
            int diff = today.compareTo(licenseExpirationDate);
            
            //if Difference is less than 0 that means LICENSE is VALID
            if(diff < 0) {
            	Node licenceToAddedAsValid = validDoc.importNode(licenseElement, true) ;
                validRoot.appendChild(licenceToAddedAsValid) ;
            }
            else {	//else considered as INVALID
            	Node licenceToAddedAsInvalid = invalidDoc.importNode(licenseElement, true) ;
                invalidRoot.appendChild(licenceToAddedAsInvalid) ;
            }
        }
        //For each LICENSE NodeList in DOCUMENT 2 (Same as we did in the upper for loop)
        for(int i=0; i<nList2.getLength(); i++) {
        	Node license = nList2.item(i);
            Element licenseElement = (Element) license;
            
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String expirationDate = licenseElement.getAttribute("License_Expiration_Date");
            LocalDate licenseExpirationDate = LocalDate.parse(expirationDate, dateTimeFormatter);
            LocalDate today = LocalDate.now();
            int diff = today.compareTo(licenseExpirationDate);
            
            //if Difference is less than 0 that means LICENSE is VALID
            if(diff < 0) {
            	Node licenceToAddedAsValid = validDoc.importNode(licenseElement, true) ;
                validRoot.appendChild(licenceToAddedAsValid) ;
            }
            else {	//else considered as INVALID
            	Node licenceToAddedAsInvalid = invalidDoc.importNode(licenseElement, true) ;
                invalidRoot.appendChild(licenceToAddedAsInvalid) ;
            }
        }
        //Creating file for VALID LICENSES
        File fileValid = new File("src/validLicences.xml");
        fileValid.createNewFile();
        Transformer transformerVaild = TransformerFactory.newInstance().newTransformer();
        transformerVaild.transform(new DOMSource(validDoc), new StreamResult(fileValid));
        
      //Creating file for INVALID LICENSES
        File fileInvalid = new File("src/invalidLicences.xml");
        fileInvalid.createNewFile();
        Transformer transformerInvalid = TransformerFactory.newInstance().newTransformer();
        transformerInvalid.transform(new DOMSource(invalidDoc), new StreamResult(fileInvalid));
        
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file1 = new File("src/inputFile1.xml");
		File file2 = new File("src/inputFile2.xml");
		try {
			DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			//Document for File 1
			Document document1= dBuilder.parse(file1);
			document1.getDocumentElement().normalize();
			
			//Document for File 2
			Document document2= dBuilder.parse(file2);
			document2.getDocumentElement().normalize();
			
			//New Document created for writing the merging XML's Output.
			Document writeDocument;
			writeDocument = dBuilder.newDocument();
			
			//Calling Merging method to merge both the XML's given
			mergeDocuments(document1, document2, writeDocument);
			
			//New Document Creating for Valid Documents
			Document validDocument;
			validDocument = dBuilder.newDocument();
			
			//New Document Creating for Invalid Documents
			Document invalidDocument;
			invalidDocument = dBuilder.newDocument();
			
			//Calling Valid or Invalid methods which takes 4 arguments first 2 arguments are 2 input files given and last 2 are newly created documents.
			validOrInvalid(document1, document2, validDocument, invalidDocument);          			
		} 
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
