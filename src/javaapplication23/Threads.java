/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication23;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Threads {

    public static void main(String[] args) {
        ThreadClass Thre1 = new ThreadClass(100,"src/javaapplication23/textfile1.txt");
        Thre1.setName("File 1 : ");
        Thre1.setPriority(Thread.MIN_PRIORITY);

        ThreadClass Thre2 = new ThreadClass(100,"src/javaapplication23/textfile2.txt");
        Thre2.setName("File 2 : ");
        Thre2.setPriority(Thread.MAX_PRIORITY);

        Thre1.start();
        Thre2.start();

    }

}

class ThreadClass extends Thread {

    private int sleep;
    private Scanner scanner;

    @Override
    public void run() {
        try {
            while (scanner.hasNextLine()) {
                System.out.println(this.getName() + " " + scanner.nextLine());
                Thread.sleep(sleep);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ThreadClass(int sleep, String Path) {
        super();
        try {
            this.scanner = new Scanner(new File(Path));
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        }
        this.sleep = sleep;
    }
}