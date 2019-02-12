package com.codecool.api;

import org.w3c.dom.NodeList;

public class RuleParser extends XMLParser {

    private RuleRepository ruleRepository;
    private NodeList nodeList;

    public RuleParser(String xmlPath) {
        loadXmlDocument(xmlPath);
        this.ruleRepository = new RuleRepository();
        this.nodeList = getDoc().getElementsByTagName("Rule");
    }






    public RuleRepository getRuleRepository() {
        return ruleRepository;
    }
}
