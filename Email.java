import java.util.Scanner;

public class Email {
    private final String email;

    public Email(String email) {
        this.email = email;
    }

   
    public String getFirstName() {
        int atIndex = email.indexOf('@');
        String local = (atIndex == -1) ? email : email.substring(0, atIndex);
        int dotIndex = local.indexOf('.');
        if (dotIndex == -1) {
            
            return local;
        }
        
        return local.substring(0, dotIndex);
    }

    
    public String getLastName() {
        int atIndex = email.indexOf('@');
        String local = (atIndex == -1) ? email : email.substring(0, atIndex);
        int dotIndex = local.indexOf('.');
        if (dotIndex == -1) {
   
            return "";
        }
        
        return local.substring(dotIndex + 1);
    }

  
    public String getFirstInitial() {
        String first = getFirstName();
        if (first == null || first.isEmpty()) {
            return "";
        }

        return first.substring(0, 1);
    }

    public String getUsername2() {
        String initial = getFirstInitial().toLowerCase();
        String last = getLastName().toLowerCase();
        if (initial.isEmpty()) {

            return last.isEmpty() ? "" : last;
        }
        if (last.isEmpty()) {
            return initial;
        }
        return initial + "_" + last;
    }


    public String getUsername1() {
        String first = getFirstName().toLowerCase();
        String last = getLastName().toLowerCase();
        if (last.isEmpty()) {
            return first;
        }
        String username1 = first + "_" + last;
        return username1;
    }

    public static void main(String[] args) {
        String inputEmail;
        if (args.length > 0 && args[0] != null && !args[0].trim().isEmpty()) {
            inputEmail = args[0].trim();
        } else {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Enter email (e.g., firstname.lastname@domain): ");
                inputEmail = scanner.nextLine().trim();
            }
        }
        Email e = new Email(inputEmail);


        String firstName = e.getFirstName();


        String firstInitial = firstName.isEmpty() ? "" : firstName.substring(0, 1);

        String lastName = e.getLastName();

       
        int randIndexFirst = firstName.isEmpty() ? 0 : (int) (Math.random() * firstName.length());
        int lastBound = Math.max(0, lastName.length() - 2);
        int randIndexLast = lastBound == 0 ? 0 : (int) (Math.random() * lastBound);

        String username1 = e.getUsername1();

 
        String username2;
        if (firstInitial.isEmpty()) {
            username2 = lastName.isEmpty() ? "" : lastName.toLowerCase();
        } else if (lastName.isEmpty()) {
            username2 = firstInitial.toLowerCase();
        } else {
            username2 = firstInitial.toLowerCase() + "_" + lastName.toLowerCase();
        }

 
        String username3;
        if (firstInitial.isEmpty()) {
 
            if (lastName.isEmpty()) {
                username3 = "";
            } else {
                username3 = lastName.substring(0, Math.min(3, lastName.length())).toLowerCase();
            }
        } else if (lastName.isEmpty()) {
            username3 = firstInitial.toLowerCase();
        } else {
            String lastSlice = lastName.substring(randIndexLast, Math.min(randIndexLast + 3, lastName.length()));
            username3 = firstInitial.toLowerCase() + "_" + lastSlice.toLowerCase();
        }

        System.out.println("First name: " + firstName);
        System.out.println("First initial: " + firstInitial);
        System.out.println("Last name: " + lastName);
        System.out.println("Username1: " + username1);
        System.out.println("Username2: " + username2);
        System.out.println("Username3: " + username3);
    }
}
