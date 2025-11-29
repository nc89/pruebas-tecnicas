package com.app.base.infrastructure.build;


import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;


public class CoverageSonarCheck {
	
	private static final String LINE = "LINE";
    private static final String BRANCH = "BRANCH";
    private static final String COUNTER = "counter";
    private static final String MISSED = "missed";
    private static final String COVERED = "covered";
    private static final String TYPE = "type";
    @SuppressWarnings("squid:S2068")
    private static final String XML_FEATURE = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
    
    private static int linesCovered = 0;
    private static int linesMissed = 0;
    private static int branchesCovered = 0;
    private static int branchesMissed = 0;

    public static void main(String[] args) throws Exception {
        String reportPath = args[0];
        double minCoverage = Double.parseDouble(args[1]);

        // Configurar el parser para ignorar DTDs
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        dbf.setFeature(XML_FEATURE, false);

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(reportPath));

        NodeList counters = doc.getElementsByTagName(COUNTER);


        for (int i = 0; i < counters.getLength(); i++) {
            Element counter = (Element) counters.item(i);
            String type = counter.getAttribute(TYPE);
            int missed = Integer.parseInt(counter.getAttribute(MISSED));
            int covered = Integer.parseInt(counter.getAttribute(COVERED));

            if(type.equals(LINE)){
                linesMissed = missed;
                linesCovered = covered;
            }else if(type.equals(BRANCH)){
                branchesMissed = missed;
                branchesCovered = covered;
            }

        }

        double totalCovered = (linesCovered + branchesCovered);
        double total = (linesCovered + linesMissed + branchesCovered + branchesMissed);
        double ratio = totalCovered / total;

        System.out.printf("Cobertura Sonar: %.2f%%%n", ratio * 100);

        if (ratio < minCoverage) {
            throw new RuntimeException("Cobertura insuficiente, mínimo requerido " + minCoverage*100 + "%");
        }
    }
}
