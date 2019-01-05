package com.oops.inmemory;
import java.util.Scanner;
import java.util.Stack;

public class MyFileHandle {
	Stack<MyFileSys> mfs = new Stack<MyFileSys>();

	public String cwd(){
		StringBuilder sb = new StringBuilder();
		int i=0;
		for(MyFileSys ss: mfs){
			if(i>0){
				sb.insert(0,ss.dirName+"/");
			}i++;
		}
		return sb.toString();
	}
	
	
	
	public void doOperations() {
		Scanner sc = new Scanner(System.in);
		String path="/";
		MyFileSys ms = new MyFileSys();
		System.out.print("$>");
		String op = sc.next();
		while (!op.equalsIgnoreCase("exit")) {
			switch (op) {
			case "mkdir":
				System.out.println("$> isFile? true or false");
				System.out.print("$>");
				ms.mkDir(sc.next(), sc.nextBoolean());
				System.out.print("$>");
				op = sc.next();
				break;
			case "ls":
				ms.ls();
				System.out.print("$>");
				op = sc.next();
				break;
			case "pwd":
				String pw = cwd()+ms.pwd();
				System.out.println("$> /"+pw);
				System.out.println("$>");
				op = sc.next();
				break;
			case "rm":
				System.out.print("$>");
				ms.rm(sc.next());
				System.out.println("$>");
				op = sc.next();
				break;
			case "cd":
				String s = sc.next();
				if (!s.equalsIgnoreCase("..")) {
					mfs.push(ms);
					ms = ms.cd(s);
				} else {
					ms = mfs.pop();
				}
				System.out.print("$>");
				op = sc.next();
				break;
			default:
				System.out.println("$> Invalid");
				System.out.print("$>");
				op = sc.next();

			}
		}
	}

	public static void main(String[] args) {

		MyFileHandle mh = new MyFileHandle();
		System.out.println("started");
		mh.doOperations();
	}

}
