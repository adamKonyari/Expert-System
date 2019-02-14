package com.codecool.api;


import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class FactParser extends XMLParser {

    private FactRepository factRepository = new FactRepository();
    private NodeList nodeList;

    public FactParser(String xmlPath) {
        loadXmlDocument(xmlPath);
        this.factRepository = new FactRepository();
        this.nodeList = getDoc().getElementsByTagName("Fact");
        addFactsRepository();
    }

    private void addFactsRepository() {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node tempNode = nodeList.item(i);
            Element tempElement = (Element) tempNode;
            String id = tempElement.getAttribute("id");
            Node descriptionNode = tempElement.getElementsByTagName("Description").item(0);
            String description = ((Element) descriptionNode).getAttribute("value");

            Fact fact = new Fact(id, description);
            setFactEvaluations(fact, tempElement);

            this.factRepository.addFact(fact);
        }
    }

    private void setFactEvaluations(Fact fact, Element tempElement) {
        Element evaluationNode = (Element) tempElement.getElementsByTagName("Evals").item(0);
        NodeList evaluations = evaluationNode.getElementsByTagName("Eval");

        for (int i = 0; i < evaluations.getLength(); i++) {
            Element evaluation = (Element) evaluations.item(i);
            String id = evaluation.getAttribute("id");
            String value = evaluation.getTextContent();
            fact.setFactValueById(id, Boolean.valueOf(value));
        }
    }

    public FactRepository getFactRepository() {
        return factRepository;
    }
}
