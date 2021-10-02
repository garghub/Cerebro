/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cerebro;

import cerebro.controller;

/**
 *
 * @author aayush.garg
 */
public class main {

    static controller _controller;

    public static void main(String[] args) {
        try {
            //args = new String[]{data.taskPrep, "java", "100", "partial"};
            //args = new String[]{data.taskTest, "c", "50", "full"};
            //args = new String[]{data.taskCombineToSimulate, "java", "50", "full"};
            Initialize(args);
        } catch (Exception ex) {
            System.err.println("error at main.main():");
            ex.printStackTrace();
        }
    }

    private static void Initialize(String[] args) {
        try {
            String errorMessage = "please verify the arguments passed";
            if (args.length < 4) {
                throw new Exception(errorMessage);
            }
            String task = args[0].toLowerCase();
            String srcLang = args[1].toLowerCase();
            Integer seqLen = Integer.parseInt(args[2]);
            String abstractionType = args[3].toLowerCase();
            if (data.lstSupportedTasks.contains(task) == false || data.lstSupportedSrcLangs.contains(srcLang) == false
                    || seqLen.getClass().equals(Integer.class) == false || data.lstSupportedAbstractionTypes.contains(abstractionType) == false) {
                throw new Exception(errorMessage);
            }
            _controller = new controller(task, srcLang, seqLen, abstractionType);
            _controller.PerformTasks();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("please pass below as arguments and try again");
            System.out.println("1. task to perform (options: prep / test / combinetosimulate) (e.g. prep)");
            System.out.println("2. project's source code language (options: c / java) (e.g. c)");
            System.out.println("3. sequence length (e.g. 25 / 50 / 100)");
            System.out.println("4. abstration type (options: full / partial) (e.g. full)");
        }
    }

}
