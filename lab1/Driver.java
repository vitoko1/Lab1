package lab1;

public class Driver {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        Model model1= new Model("Victor", "Sandoval", 25, 175, true, false);

        Model model2= new Model("Jennifer", "Lopez", 40,  80);

        model1.printDetails();
        System.out.println("------------------");
        model2.displayModelDetails();
        System.out.println("------------------");
        model2.printDetails();
    }


}
