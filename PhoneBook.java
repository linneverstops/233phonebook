/*
 * EECS233 HW1 PhoneBook
 * Tung Ho Lin
 */
import java.util.*;
import java.lang.StringBuilder;

public class PhoneBook<T> {
  
  private T personid;
  
  private long phoneno;
  
  private ArrayList<PhoneBook> records = new ArrayList<PhoneBook>();
  
  private Scanner scanner;
  
  private int size;
  
  public PhoneBook(){
  }
  
  /*public static void main(String args[]) {
    PhoneBook<Integer> pbssn = new PhoneBook<Integer>();
    PhoneBook<String> pbname = new PhoneBook<String>();
    Scanner sc = new Scanner(System.in);
    int pbsize = 0;
    for(int i=0;i<1;i++){
      System.out.println("Welcome! Please enter a number for the size of each phonebook.");
      try {
        pbsize = Integer.parseInt(sc.next());
      }
      catch (NumberFormatException e) {
        System.out.println("Please enter a number only!");
        i-=1;
      }
    }
    pbssn.setSize(pbsize);
    pbname.setSize(pbsize);
    for (int i=0; i<100; i++) {
      System.out.println("\nPlease select the number for: \n1: Add person by name. \n2: Add person by SSN. \n3: Proceed to find person.");
      String select = sc.next();
      if(select.equals("1")){
        if(pbname.checkFull() == false) {
          System.out.println("Please enter the first and last name separated by a space.");
          if(sc.hasNextInt() == false) {
            String name = sc.next() + " " + sc.next();
            System.out.println("Please enter the phone number with no spaces and dashes");
            long number = Long.parseLong(sc.next());
            pbname.addPerson(name, number);
          }
          else {
            System.out.println("Invalid inputs! Please check your inputs again!");
            sc.next();
          }
        }
      }
      else if(select.equals("2")){
        if(pbssn.checkFull() == false) {
          System.out.println("Please enter the SSN with no spaces and dashes.");
          if(sc.hasNextInt()) {
            String social = sc.next();
            Integer ssn = Integer.parseInt(social);
            System.out.println("Please enter the phone number with no spaces and dashes");
            long number = Long.parseLong(sc.next());
            pbssn.addPerson(ssn, number);
          }
          else {
            System.out.println("Invalid inputs! Please check your inputs again!");
            sc.next();
          }
        }
      }
      else if(select.equals("3")){
        break;
      }
      else 
        System.out.println("Invalid selection, please only enter '1' or '2' or '3'.");
    }
    for(int i=0;i<100;i++){
      System.out.println("\nPlease select the number for: \n1: Find person by name. \n2: Find person by SSN. \n3: Exit phonebook.");
      String select = sc.next();
      if(select.equals("1")){
        System.out.println("Please enter the first and last name, separated by a space.");
        if(sc.hasNextInt() == false) {
          String name = sc.next() + " " + sc.next();
          pbname.findPerson(name);
        }
        else {
          System.out.println("Invalid inputs! Please check your inputs again!");
          sc.next();
        }
      }
      else if(select.equals("2")){
        System.out.println("Please enter the SSN with no spaces and dashes.");
        if(sc.hasNextInt()) {
          Integer ssn = Integer.parseInt(sc.next());
          pbssn.findPerson(ssn);
        }
        else {
          System.out.println("Invalid inputs! Please check your inputs again!");
          sc.next();
        }
      }
      else if(select.equals("3")){
        System.out.println("Bye!");
        break;
      }
      else {
        System.out.println("Invalid selection, please only enter '1' or '2' or '3'.");
        i-=1;
      }
    }
  }*/
  
  public static void main(String[] args) throws java.lang.Exception {
    PhoneBook<Integer> pbssn = new PhoneBook<Integer>();
    PhoneBook<String> pbname = new PhoneBook<String>();
    String name = "John Doe";
    long number1 = 9098786543L;
    int ssn = 1357924680;
    long number2 = 8986765432L;
    pbssn.addPerson(ssn, number2);
    pbname.addPerson(name, number1);
    pbssn.findPerson(1357924680);
    pbname.findPerson("John Doe");
  }
  
  public T getPersonID() {
    return this.personid;
  }
  
  public void setPersonID(T personid) {
    this.personid = personid;
  }
  
  public long getPhoneNo() {
    return this.phoneno;
  }
  
  public void setPhoneNo(long phoneno) {
    this.phoneno = phoneno;
  }
  
  public void setSize(int size) {
    this.size = size;
  }
  
  public boolean checkFull() {
    if(records.size() >= this.size) {
      System.out.println("This phonebook is full! No more entry is allowed");
      return true;
  }
    else
      return false;
  }
  
  public void addPerson(T personid, long phoneno) {
    if(this.checkFull() == false) {
      PhoneBook<T> entry = new PhoneBook<T>();
      entry.setPersonID(personid);
      entry.setPhoneNo(phoneno);
      records.add(entry);
      System.out.println("Successfully added!");
    }
  }
  
  public void findPerson(T personid) {
    Iterator it = records.iterator();
    long number = 0L;
    int flag = -1;
    while(it.hasNext()){
      PhoneBook save = (PhoneBook)it.next();
      if(save.getPersonID().equals(personid)) {
        number = save.getPhoneNo();
        flag = 1; //indicate the search produces a result
      }
    }
    if (flag == 1)
      System.out.println("The phone number is: " + ((Long)number).toString());
    else
      System.out.println("Sorry! We didn't find a match. Please check your inputs again!");
  }
  
  public void deletePerson(T personid) {
    Iterator it = records.iterator();
    long number = 0L;
    int ctr = 0;  //counter
    int flag = -1;
    while(it.hasNext()){
      PhoneBook save = (PhoneBook)it.next();
      if(save.getPersonID().equals(personid)) {
        it.remove();
        flag = 1;
      }
      ctr++;
    }
    if (flag == 1) {
      System.out.println("Successfully deleted!");
    }
    else
      System.out.println("There are no matching records in the phonebook.");
  }
}
    
    