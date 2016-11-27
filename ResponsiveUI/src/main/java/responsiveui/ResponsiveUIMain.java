package responsiveui;

public class ResponsiveUIMain {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello ResponsiveUI!"); 
        // new UnresponsiveUI();
        ResponsiveUI ui = new ResponsiveUI();
        System.in.read();
        System.out.println(ui.d);
    }
}
