import java.util.ArrayList;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        ArrayList<Person> personArrayList= new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        Validation validation=new Validation();
        System.out.println("=======================Person Information===================");
        int option;
        while (true){
            System.out.println("1. Insert information ");
            System.out.println("2. Show information ");
            System.out.println("3. Remove person");
            System.out.println("4. Exit");
            System.out.print("Choose Option (1-4) : ");
            //option=scanner.nextInt();
            option = Integer.parseInt(validation.validationInput("[1-4]+"));
            switch (option){
                case 1 :
                    System.out.print("Enter Id: ");
                    int id=Integer.parseInt(validation.validationInput("[0-9]+")) ;
                    System.out.print("Enter age (18-60) :");
                    int age=Integer.parseInt(validation.validationInput("^(1[89]|[2-5][0-9]|60)$")) ;
                    System.out.print("Enter gender : ");
                    String gender=validation.validationInput("(?i)^[FM]$|^(male|female)$");
                    System.out.print("Enter name : ");
                    String name=validation.validationInput("[a-zA-Z]{2,10}$");
                    personArrayList.add(new Person(id,name,age,gender));

                    break;
                case 2:
                    int personNumber = 1;
                    for (Person person: personArrayList){
                        System.out.println("==============Show information Person" + personNumber + "==============");
                        System.out.println("Id = "+person.id);
                        System.out.println("Name = " +person.name);
                        System.out.println("Age = "+person.age);
                        System.out.println("Gender = "+person.gender);
                        personNumber++;
                    }
                    System.out.println("Press any key to continue!");
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Enter Id to remove : ");
                     id=scanner.nextInt();
                     scanner.nextLine();
                     int index = 0;
                     for (int i=0; i<personArrayList.size();i++) {
                         if(id== personArrayList.get(i).id) index=i;
                         
                     }
                    if (index != -1) {
                        // ID found, ask for confirmation
                        System.out.print("Are you sure you want to remove this item? (y/n): ");
                        String confirmation = scanner.nextLine().toLowerCase();
                        if (confirmation.equals("y")) {
                            personArrayList.remove(index);
                            System.out.println("Removed successfully..... ");
                        } else {
                            System.out.println("Removal canceled.");
                        }
                    } else {
                        System.out.println("ID not found. Unable to remove.");
                    }
                    break;
                case 4:
                    System.exit(0);

                    break;

            }

        }

    }
}
