package com.oops.inmemory;
import java.util.HashMap;
import java.util.Map;

public class MyFileSys {

	String dirName;
	boolean isFile;
	String path = "/";
	Map<String, MyFileSys> subList = new HashMap<String, MyFileSys>();
	StringBuilder sb;
	MyFileSys mdd;

	MyFileSys() {

	}

	MyFileSys(String dirName, boolean isFile) {
		this.dirName = dirName;
		this.isFile = isFile;
		this.path = dirName;
		
	}

	public boolean mkDir(String dirName, boolean isFile) {
		if (subList.containsKey(dirName)) {
			System.out.println("Already Exsists");
			return false;
		} else {
			subList.put(dirName, new MyFileSys(dirName, isFile));
			return true;
		}
	}

	public MyFileSys cd(String dirName){
		if(subList.containsKey(dirName)){
			mdd=subList.get(dirName);
			return mdd;
		}else{
			System.out.println("Invalid");
			return null;
		}
	}

	public boolean rm(String dirName) {
		if (subList.containsKey(dirName)) {
			subList.remove(dirName);
			System.out.println("Deleted");
			System.gc();
			return true;
		} else {
			System.out.println("Not found");
			return false;
		}

	}

	public String pwd() {
		return path;
	}

	public void ls() {
		for (String s : subList.keySet()) {
			System.out.println(s);
		}
	}

}
