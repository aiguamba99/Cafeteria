
import controlador.MainController;
import vista.MainView;

public class Main {
    public static void main(String[] args) {
        MainView view = new MainView();
        new MainController(view);
    }
}