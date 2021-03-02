//welcome class
package com.hcl.VirtualKey.Intro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.hcl.VirtualKey.FileMethods.AddDelSearch;
import com.hcl.VirtualKey.FileMethods.FileOperations;

public class WelcomeScreen {

	public void optionSelection() {
		System.out.println("Welcome to Virtual Key Repository App");
		System.out.println("Your Web Developer: Bijaya Khanal");
		System.out.println("--------------------------");
		System.out.println("--------------------------");
		System.out.println("Here you can perform following operations: ");
		System.out.println(
				"1. Display files name in ascending order\n" + "2. Add/Delete/Search Files\n" + "3. Close Application");
		System.out.println("Please choose number according to it(from 1 to 3): ");

		selection();
	}

	private void selection() {
		FileOperations f1 = new FileOperations();
		AddDelSearch f2 = new AddDelSearch();
		Scanner input = new Scanner(System.in);

		String x = "";
		// try {
		x = input.nextLine();

		while ((!x.matches("\\d+"))) {
			System.out.println("Invalid entry. Please select from 1 to 3");
			x = input.nextLine();
		}

		int y = Integer.parseInt(x);
		while (!(y >= 1 && y <= 3)) {
			System.out.println("Invalid number. please select from 1 to 3");
			y = input.nextInt();

		}

		switch (y) {
		case 1:
			try {

				List<String> list = new ArrayList<String>(f1.sortFiles());
				Collections.sort(list);
				System.out.println("Here is the list of files in ascending order: ");
				System.out.println(list);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			f2.askUser();
		case 3:
			f1.closeApp();
		}
//		} catch (Exception ex) {
//			System.out.println("Invalid entry. Please enter the number from 1 to 3");
//			selection();
//		}

	}

}
