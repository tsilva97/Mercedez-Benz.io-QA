package CLI;

import master.Master;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCLI {

    private Master mst;

    public void execute(){
        Scanner in = new Scanner(System.in);
        Messages.welcome();
        this.chooseBrowser(in);
        while(true) {
            this.chooseCommand(in);
        }
    }

    public void chooseBrowser(Scanner in){
        Messages.browserOptions();
        int browser;

        while(true){
            try{
                browser = in.nextInt();
                break;
            }catch(InputMismatchException e){
                in.nextLine();
                Messages.tryAgain();
            }
        }

        switch(browser){
            //Closes the program
            case 0:
                System.out.println("Bye bye");
                System.exit(0);
                break;

            //Chrome
            case 1:
                this.mst = new Master(1);
                break;

            //Firefox
            case 2:
                this.mst = new Master(2);
                break;


            //Invalid option, lets try again
            default:
                Messages.tryAgain();
                this.chooseBrowser(in);
                break;
        }
    }

    public void chooseCommand(Scanner in){
        int workflow;
        Messages.commandOptions();

        while(true){
            try{
                workflow = in.nextInt();
                break;
            }catch(InputMismatchException e){
                in.nextLine();
                Messages.tryAgain();
            }
        }

        switch(workflow){
            //Closes the program
            case 0:
                System.out.println("Bye bye");
                mst.flushReport();
                System.exit(0);
                break;

            //Workflow1
            case 1:
                mst.workflow1();
                break;

            //Workflow2
            case 2:
                mst.workflow2();
                break;

            //Invalid option, lets try again
            default:
                Messages.tryAgain();
                this.chooseCommand(in);
                break;
        }
    }
}

