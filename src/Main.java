import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class A {
	public int[] convert(int two[][]) {
		int a[] = new int[two.length * two.length];
		for (int i = 0, k = 0; i < two.length; i++) {
			for (int j = 0; j < two[i].length; j++) {
				a[k] = two[j][i] * k;
				k++;
			}
		}
		return a;
	}

	public int[][] convert(int one[]) {
		int size = (int) Math.sqrt(one.length);
		int b[][] = new int[size][size];
		for (int i = 0, k = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				b[j][i] = one[k] * k;
				k++;
			}
		}
		return b;
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int two[][] = null;
		int one[] = null;
		A arr = new A();
		int select;
		int n;
		System.out.println("1. 1D->2D");
		System.out.println("2. 2D->1D");
		System.out.println("Select option(1-2)");

		select = in.nextInt();
		if (select != 1 && select != 2) {
			System.out.println("I can't recognize this option.");
			return;
		}
		do {
			System.out.print("Side size(2-9): ");
			n = in.nextInt();
		} while (n < 2 || n > 9);
		System.out.println("Enter your numbers:");
		switch (select) {
		case 1:
			one = new int[n * n];
			for (int i = 0; i < n * n; i++) {
				one[i] = in.nextInt();
			}
			two = arr.convert(one);
			System.out.println("Two Dimensional Array:");
			try {
				FileWriter w = new FileWriter("output.txt");
				BufferedWriter b = new BufferedWriter(w);
				for (int i = 0; i < two.length; i++) {
					for (int j = 0; j < two[i].length; j++) {
						System.out.print(two[i][j] + " ");
					}
					System.out.println();
					b.write(Arrays.toString(two[i]));

				}
				b.flush();
				b.close();
			} catch (IOException e) {
				System.out.println("Error with output file.");
				System.out.println(e.getMessage());
			}
			break;
		case 2:
			two = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					two[i][j] = in.nextInt();
				}
			one = arr.convert(two);
			System.out.println("One Dimensional Array:");
			for (int i = 0; i < one.length; i++) {
				System.out.print(one[i] + " ");
			}
			try {
				FileWriter w = new FileWriter("output.txt");
				BufferedWriter b = new BufferedWriter(w);
				b.write(Arrays.toString(one));
				b.flush();
				b.close();

			} catch (IOException e) {
				System.out.println("Error with output file.");
				System.out.println(e.getMessage());
			}
			break;
		}
		in.close();
	}
}