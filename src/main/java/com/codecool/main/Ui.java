package com.codecool.main;

import com.codecool.api.Fact;
import com.codecool.api.FactParser;
import com.codecool.api.FactRepository;
import com.codecool.api.RuleParser;
import java.util.Scanner;

public class Ui {

    void program_menu() {
        int option = 0;
        do {
            clearScreen();
            FactParser factParser = new FactParser("src/main/resources/Facts.xml");
            RuleParser ruleParser = new RuleParser("src/main/resources/Rules.xml");
            ESProvider esp = new ESProvider(factParser, ruleParser);
            System.out.println("Main Menu\n");
            String[] options = {
                    "List all superheroes.",
                    "Find out who is your superhero!"
                    };
            menuPrinter(options);
            System.out.print("Please select an option: ");
            option = Integer.parseInt(getInput());

            switch (option) {
                case 0:
                    System.exit(0);

                case 1:
                    clearScreen();
                    FactRepository factRepository = factParser.getFactRepository();
                    int i = 1;
                    for(Fact fact: factRepository.getFacts()) {
                        System.out.println(i + ". " + fact.getDescription());
                        i++;
                    }
                    promptEnterKey();
                    break;

                case 2:
                    clearScreen();
                    esp.collectAnswers();
                    if(esp.evaluate().size() == 0) {
                        clearScreen();
                        System.out.println("No superhero found. You're probably dead by now anyway...");
                        promptEnterKey();
                        break;
                    } else {
                        if(esp.evaluate().size() == 1) {
                            clearScreen();
                            System.out.println("Based on your answers, this might be your superhero:\n");
                        } else if(esp.evaluate().size() > 1) {
                            clearScreen();
                            System.out.println("Based on your answers, these are your superheroes:\n");
                        }
                        int counter = 1;
                        for(Fact fact: esp.evaluate()) {
                            System.out.println(counter + ". " + fact.getDescription());
                            counter++;
                        }
                    }

                    promptEnterKey();
                    break;

                default:
                    clearScreen();
                    System.out.println("\nInvalid option! \n");
                    promptEnterKey();
            }
        } while (option != 0);
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    private void menuPrinter(String[] options){
        int counter=1;
        for(String option:options){
            System.out.println(counter+". "+option);
            counter++;
        }
        System.out.println("0. Exit\n");
    }

    public void promptEnterKey(){
        System.out.println("\n Press \"ENTER\" to continue...");
        getInput();
    }

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
