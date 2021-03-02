package com.hcl.VirtualKey.FileMethods;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

import com.hcl.VirtualKey.Intro.WelcomeScreen;

public class AddDelSearch {

	WelcomeScreen ws = new WelcomeScreen();
	FileOperations fo = new FileOperations();

	public void askUser() {
		System.out.println("Please select from the following option: ");
		System.out.println("Enter 1 if you want to add file to existing directory list");
		System.out.println("Enter 2 if you want to delete file from existing directory list");
		System.out.println("Enter 3 if you want to search file from main directory");
		System.out.println("Enter 4 if you want to navigate back to main menu");
		// try {
		Scanner input = new Scanner(System.in);
		String x = "";
		x = input.nextLine();

		while ((!x.matches("\\d+"))) {
			System.out.println("Invalid entry. Please select from 1 to 4");
			x = input.nextLine();
		}

		int y = Integer.parseInt(x);
		while (!(y >= 1 && y <= 4)) {
			System.out.println("Invalid number. please select from 1 to 4");
			y = input.nextInt();
		}

		switch (y) {
		case 1:
			addFile();
			break;
		case 2:
			delFile();
			break;
		case 3:
			searchFile();
			break;

		case 4:
			ws.optionSelection();
		}
//		} catch (Exception ex) {
//
//		}

	}

	private void searchFile() {
		Scanner searchInput = new Scanner(System.in);
		boolean flag = false;

		try {
			Set<String> filesList = fo.sortFiles();
			System.out.println("Enter the file name you want to search: ");
			String sfile = searchInput.nextLine();
			for (String s : filesList) {
				if (s.equals(sfile)) {
					flag = true;
					System.out.println("File found");
				}
			}
			if (flag == false)
				System.out.println("File not found");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void delFile() {
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("Enter the file name you want to delete: ");
			String file = input.nextLine();
			File obj = new File(file);
			if (obj.delete()) {

				System.out.println("File deleted: " + obj.getName());
			} else {
				System.out.println("File don't exist");
			}
			askUser();
		} catch (Exception e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}

	}

	private void addFile() {
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("Enter the file name you want to add: ");
			String file = input.nextLine();
			File obj = new File(file);
			if (obj.createNewFile()) {

				System.out.println("File created: " + obj.getName());
			} else {
				System.out.println("File already exists.");
			}
			askUser();
		} catch (Exception e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}

}
