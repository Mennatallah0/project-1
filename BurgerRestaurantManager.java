
package burgerrestaurantmanager;
import java.util.Scanner;
public class BurgerRestaurantManager {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Welcome in our restaurant");
       System.out.println("Our food menu is");
       System.out.println(" 1.Normal burger \n 2.Healthy Burger \n 3.Deluxe Burger");
       System.out.println("What is your choice number ?");
       int ch = sc.nextInt();
       while(ch <1 || ch>3){
       System.out.println(" please enter the write number");
       ch = sc.nextInt();
       }
       switch(ch){
           case 1:
                System.out.println("Please choose what you want in");
                NormalBurger.content();
                System.out.println("Please entre \"0\"  if you finish");
                int a,b;
                a =sc.nextInt() ;
                while(a <1 || a>2){
                    System.out.println(" please enter the write number");
                    a = sc.nextInt();
                }
                b =sc.nextInt() ;
                while(b <1 || b>2){
                    System.out.println(" please enter the write number");
                    b = sc.nextInt();
                }
                int[] c = new int[4];
                for(int l = 0; l<4; l++){
                    c[l]=sc.nextInt();
                    if(c[l]==0)
                        break;
                    while(c[l] <1 || c[l]>4){
                    System.out.println(" please enter the write number");
                    c[l] = sc.nextInt();
                }
                    
                }                
                NormalBurger n= new NormalBurger(a,b,c);
                n.yourOrder();
                System.out.println("The total cost is : " + n.totalPrice() +" prise");
               break;            
               
           case 2:
                System.out.println("Please choose what you want in");
                HealthyBurger.content();
                System.out.println("Please entre \"0\"  if you finish");
                int d;
                d =sc.nextInt() ;
                while(d <1 || d>2){
                    System.out.println(" please enter the write number");
                    d = sc.nextInt();
                }
                int[] m = new int[4];
                for(int l = 0; l<2; l++){
                    m[l]=sc.nextInt();
                    if(m[l]==0)
                        break;
                    while(m[l] <1 || m[l]>4){
                    System.out.println(" please enter the write number");
                    m[l] = sc.nextInt();
                }
                    
                }                
                HealthyBurger l= new HealthyBurger(d,m);
                l.yourOrder();
                System.out.println("The total cost is " + l.totalPrice() +"prise");
               break; 
               
           case 3:                            
                                                                
                DeluxeBurger o= new DeluxeBurger();
                o.yourOrder();
                System.out.println("The total cost is " + o.totalPrice() +"prise");
               break;   
           

    }
    
}
}

class NormalBurger{
    private String name;
    private int typeOfMeat;
    private int typeOfRollBread;
    private double price;
    private int[] additions;
    
  
    public NormalBurger(int typeOfMeat, int typeOfRollBread, int[] additions) {
        this.name = "NormalBurger";
        this.typeOfMeat = typeOfMeat;
        this.typeOfRollBread = typeOfRollBread;
        this.additions = additions;
        this.price = 0;
    }
    public NormalBurger(int typeOfMeat, int typeOfRollBread) {        
        this.typeOfMeat = typeOfMeat;
        this.typeOfRollBread = typeOfRollBread;       
        this.price = 0;
    }
    public static void content(){
        System.out.println("TypeOfMeat \n 1.beef 20P  \n 2.chicken 15P");
        System.out.println("TypeOfRollBread \n 1.white bread 1.5P  \n 2.brown bread 1P");
        System.out.println("Additions \n 1.extra cheese 5P  \n 2.extra tomato 2P \n 3.chips 5P  \n 4.drink 7P");
    }  
    public void setName(String name) {
        this.name = name;
    }

    public void setAdditions(int[] additions) {
        this.additions = additions;
    }
    
    public void yourOrder(){
        System.out.print("Your order is : ");
        System.out.println(name);
        if(typeOfMeat == 1)
            System.out.println("TypeOfMeat : Beef  20P");
        else
            System.out.println("TypeOfMeat : Chicken  15P");
        if(typeOfRollBread == 1)
            System.out.println("TypeOfRollBread :white bread 1.5P");
        else
            System.out.println("TypeOfRollBread :brown bread 1P");
        
        for(int i=0; i<4;i++){
            if(additions[i]>0)
                if(additions[i]==1)
                    System.out.println("Additions :extra cheese 5P");
                else if(additions[i]==2)
                    System.out.println("Additions :extra tomato 2P");
                else if(additions[i]==3)
                    System.out.println("Additions :chips 5P");
                else if(additions[i]==4)
                    System.out.println("Additions :drink 7P");
        }  
    } 
    public double totalPrice() {
        if(typeOfMeat==1)
            price+=20;
        else if(typeOfMeat==2)
            price+=25;
        
        if(typeOfRollBread==1)
            price+=1.5;
        else if(typeOfRollBread==2)
            price+=1;
        
        for(int i=0; i<4;i++){
            if(additions[i]>0)
                if(additions[i]==1)
                    price+=5;
                else if(additions[i]==2)
                    price+=2;
                else if(additions[i]==3)
                    price+=5;
                else if(additions[i]==4)
                price+=7;
        }        
            
        return price;
    }
}

class HealthyBurger extends NormalBurger{    
    
    
    public HealthyBurger(int typeOfMeat, int[] additions) {
        super(typeOfMeat, 2, additions);
        super.setName("HealthyBurger");
    }
    
    public static void content(){
        System.out.println("TypeOfMeat \n 1.beef 20P  \n 2.chicken 15P");
        System.out.println("you hava ONLY two additions");
        System.out.println("Additions \n 1.extra cheese 5P  \n 2.extra tomato 2P \n 3.chips 5P  \n 4.drink 7P");
    } 
    
    
}

class DeluxeBurger extends  NormalBurger{
    
    int[] s = {3,4,0,0};
    
    public DeluxeBurger() {
        super(1, 1);
        super.setAdditions(s);
        super.setName("DeluxeBurger");
        
        
    }
   
         
 }