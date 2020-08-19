package Problem3;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        FileExplorer fileExplorer = new FileExplorer();
        boolean runFlag = true;
        Scanner sn = new Scanner(System.in);
        while (runFlag){
            String temp = sn.nextLine();
            if(temp.equalsIgnoreCase("exit")){
                runFlag = false;
            } else if (temp.equalsIgnoreCase("ls")){
                fileExplorer.ls();
            } else if(temp.startsWith("cd")){
                fileExplorer.cd(temp);
            } else {
                System.out.println("Invalid Input.");
            }
        }
    }
}
