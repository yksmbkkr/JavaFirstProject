package Problem3;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileExplorer {

    private List<String> currentPath;

    public FileExplorer() {
        this.currentPath = new ArrayList<>();
        this.currentPath.add("C:");
        System.out.println("Welcome to JAVA file explorer (Use ls to list content of current directory, cd to enter directory and cd .. to exit. Use '/' for multiple directories");
        System.out.println(currentPathString()+" >");
    }

    private String currentPathString(){
        StringBuilder temp = new StringBuilder();
        for (String dir: currentPath
             ) {
            temp.append(dir);
            temp.append("\\");
        }
        return temp.toString();
    }

    private boolean addToCurrentPath(String dir){
        if(dir.equalsIgnoreCase("..") && currentPath.size()>1){
            currentPath.remove(currentPath.size()-1);
//            System.out.println(currentPathString()+" >");
            return true;
        } else {
            String currentDir = currentPathString();
            File temp = new File(currentDir);
            File[] fileList = temp.listFiles();
            for (File current:fileList) {
                if(dir.equalsIgnoreCase(current.getName())){
                    if(current.isDirectory()){
                        this.currentPath.add(dir);
                        return true;
                    }
                    System.out.println(dir+" is not a folder!");
                    return false;
                }

            }
            System.out.println(dir+" is not in current directory!");
        }
        return false;
    }

    public void ls(){
        String currentDir = currentPathString();
        File dir = new File(currentDir);
        if(dir.list() == null){
            System.out.println(currentDir + "is a file.");
        }else{
            for (final File entry:dir.listFiles()) {
                if(entry.isDirectory()){
                    System.out.println("\t"+entry.getName()+" (FOLDER)");
                } else {
                    System.out.println("\t"+entry.getName()+" (FILE)");
                }
            }
        }
        System.out.println(currentPathString()+" >");
    }

    public void cd(String string){
        if (string.indexOf('/') == -1){
            String[] cmd_1 = string.split(" ",2);
            if (cmd_1[0].equalsIgnoreCase("cd")){
                addToCurrentPath(cmd_1[1]);
            }
            System.out.println(currentPathString()+" >");
            return;
        }
        String[] cmd = string.split(" ");
        if(cmd.length != 2){
            System.out.println("More or less than expected arguments !");
            System.out.println(currentPathString()+" >");
        } else if (cmd[0].equalsIgnoreCase("cd")){
            String[] paths = cmd[1].split("/");
            for (int i = 0; i < paths.length; i++) {
                if(!addToCurrentPath(paths[i])){
                    break;
                }
            }
            System.out.println(currentPathString()+" >");
        } else {
            System.out.println("Improper CD command !");
            System.out.println(currentPathString()+" >");
        }
    }
}
