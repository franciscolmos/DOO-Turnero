/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import main.Main;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.finder.WindowFinder;
import org.assertj.swing.fixture.FrameFixture;
import static org.assertj.swing.launcher.ApplicationLauncher.application;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author francisco
 */
public class FrmNuevoTItularTest {
    
    private FrameFixture window;
    Robot robot;
    
    public FrmNuevoTItularTest() {
    }
    @BeforeClass
    public static void setUpClass() {
        // si no esta corriendo en el hilo especificado en el main entonces ocurre una violacion y se detiene el test. En caso contrario
        // intenta instalar el framework que va tomar control de la aplicacion y va a hacer el test
        FailOnThreadViolationRepaintManager.install();
    }
    
    @Before
    public void setUp() {
        // obtengo el robot basico que me proporciona la herramienta
        robot = BasicRobot.robotWithCurrentAwtHierarchy();
        application(Main.class).start();
        GenericTypeMatcher<JFrame> matcherVistaHome = new GenericTypeMatcher<JFrame>(JFrame.class){
            @Override
            // buscamos la ventana que queremos levantar con el robot
            protected boolean isMatching(JFrame frame){
                // para eso buscamos por titulo de ventana, si existe y si se esta mostrando
                return frame.getTitle() != null && frame.getTitle().startsWith("VISTA HOME") && frame.isShowing();
            }
        };
        window = WindowFinder.findFrame(matcherVistaHome).using(robot);
        window.button("BotonNuevoTurno").click();
        GenericTypeMatcher<JFrame> matcherVistaNuevoTurno = new GenericTypeMatcher<JFrame>(JFrame.class){
            @Override
            // buscamos la ventana que queremos levantar con el robot
            protected boolean isMatching(JFrame frame){
                // para eso buscamos por titulo de ventana, si existe y si se esta mostrando
                return frame.getTitle() != null && frame.getTitle().startsWith("NUEVO TURNO") && frame.isShowing();
            }
        };
        window = WindowFinder.findFrame(matcherVistaNuevoTurno).using(robot);
        window.button("BotonNuevoTitular").click();
        GenericTypeMatcher<JFrame> matcherVistaNuevoTitular = new GenericTypeMatcher<JFrame>(JFrame.class){
            @Override
            // buscamos la ventana que queremos levantar con el robot
            protected boolean isMatching(JFrame frame){
                // para eso buscamos por titulo de ventana, si existe y si se esta mostrando
                return frame.getTitle() != null && frame.getTitle().startsWith("NUEVO TITULAR") && frame.isShowing();
            }
        };
        window = WindowFinder.findFrame(matcherVistaNuevoTitular).using(robot);
    }

    /**
     * Test of getBotonGuardar method, of class FrmNuevoTurno.
     */
    @Test
    public void testNuevoTurno() {
        robot.enterText("Nombre Prueba");
        robot.pressKey(KeyEvent.VK_TAB);
        robot.releaseKey(KeyEvent.VK_TAB);
        robot.enterText("Apellido Prueba");
        window.comboBox("comboBoxTipoDoc").selectItem(1);
        robot.pressKey(KeyEvent.VK_TAB);
        robot.releaseKey(KeyEvent.VK_TAB);
        robot.pressKey(KeyEvent.VK_TAB);
        robot.releaseKey(KeyEvent.VK_TAB);
        robot.enterText("38332303");
        robot.pressKey(KeyEvent.VK_TAB);
        robot.releaseKey(KeyEvent.VK_TAB);
        robot.enterText("3516196398");
        window.button("botonGuardar").click();
    }
}
