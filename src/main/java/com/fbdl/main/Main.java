package com.fbdl.main;

import java.io.File;
import java.util.Scanner;

/**
 * Directory deleter that goes recursively to every file/dirs in that directory
 * and deletes them accordingly
 * i.e: "D:\\userdata\\lampayan\\Desktop\\test"
 * Note: single backslash is also acceptable
 * @author lampayan
 *
 */

public class Main {

	public static void main(String[] args){
		System.out.println("FBDL dir deleter - input mode");
		
		Scanner reader = new Scanner(System.in);
		System.out.println("input the absolute path of directory to delete: ");
		String directoryPath = reader.nextLine();
		
		File index = new File(directoryPath);
		
		deleteEntry(index);
		
		System.out.println("END");
	}
	
	private static void deleteEntry(File file){
		
		if(file.isDirectory()){
			File[] fileEntries = file.listFiles(); 
			for(File item : fileEntries){
				deleteEntry(item);
			}
		}
		
		System.out.println("Deleting file: " + file.getName());

		if(!file.delete()){
			System.err.println("delete failed!");
		}
		
	}
	
}
