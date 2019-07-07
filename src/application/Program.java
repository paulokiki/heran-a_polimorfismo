package application;

//produto
import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> list = new ArrayList<>();
        System.out.print("Enter the number os products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product" + i + "# data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char fee = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.next();
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (fee == 'c') {
                list.add(new Product(name, price));

            } else if (fee == 'u') {
                System.out.print("Manufacture date: ");
                String date = sc.next();
                list.add(new UsedProduct(sdf.parse(date), name, price));
            } else if (fee == 'i') {
                System.out.print("Customs fee: ");
                double custom = sc.nextDouble();

                list.add(new ImportedProduct(custom, name, price));
            }
        }
        
        System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
        sc.close();
    }

}
