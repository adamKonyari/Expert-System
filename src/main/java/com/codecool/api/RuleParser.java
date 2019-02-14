package com.codecool.api;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Arrays;
import java.util.List;

public class RuleParser extends XMLParser {

    private RuleRepository ruleRepository;
    private NodeList nodeList;

    public RuleParser(String xmlPath) {
        loadXmlDocument(xmlPath); //We get the actual document
        this.ruleRepository = new RuleRepository();
        this.nodeList = getDoc().getElementsByTagName("Rule"); //Counting how many Rules there are - needed for iteration later
        addRulesToRepository();
    }

    public RuleRepository getRuleRepository() {
        return ruleRepository;
    }

    private void addRulesToRepository() {
        for (int i = 0; i < nodeList.getLength(); i++) {

            Node node = nodeList.item(i);
            if (node.getNodeType() == node.ELEMENT_NODE) {
                Element element = (Element) node;
                String id = element.getAttribute("id");
                String questionString = element.getElementsByTagName("Question").item(0).getTextContent();
                Answer answer = getAnswers(element);
                Question question = new Question(id, questionString, answer);
                this.ruleRepository.addQuestion(question);
            }
        }
    }

    private Answer getAnswers(Element element) {
        Answer answer = new Answer();
        NodeList answerList = element.getElementsByTagName("Selection");
        for(int i = 0; i < answerList.getLength(); i++) {
            Node answerNode = answerList.item(i);

            if(answerNode.getNodeType() == Node.ELEMENT_NODE) {
                Element answerElement = (Element) answerNode;
                Element valueNode = (Element) answerNode.getChildNodes().item(1);
                boolean answerType = Boolean.valueOf(answerElement.getAttribute("value"));
                Value value;

                if(valueNode.getNodeName().equalsIgnoreCase("SingleValue")) {
                    String param = valueNode.getAttribute("value");
                    value = new SingeValue(param, answerType);
                } else {
                    List<String> params = Arrays.asList(valueNode.getAttribute("value").split(","));
                    value = new MultipleValue(params, answerType);
                }
                answer.addValue(value);
            }
        }
        return answer;
    }
}
