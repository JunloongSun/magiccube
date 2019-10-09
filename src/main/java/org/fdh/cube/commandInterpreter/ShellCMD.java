package org.fdh.cube.commandInterpreter;

import org.fdh.cube.util.Environment;

/** 包含命令行 */
public class ShellCMD{
    private String cmdString;
    public ShellCMD(String cmdString) {
        super();
        this.cmdString = cmdString;
    }
    public void resolveCMD(String cmdString) {
        switch (cmdString) {
        case "help":Environment.println(cmdString+"\n");break;
        //case "threadInfo":Environment.threadInfo();break;
        default: break;
        }
    }
    
}
