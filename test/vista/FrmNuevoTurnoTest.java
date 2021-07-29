/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JFrame;
import main.Main;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.finder.WindowFinder;
import org.assertj.swing.fixture.FrameFixture;
import static org.assertj.swing.launcher.ApplicationLauncher.application;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author francisco
 */
public class FrmNuevoTurnoTest {
    
    private FrameFixture window;
    Robot robot;
    
    public FrmNuevoTurnoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        // si no esta corriendo en el hilo especificado en el main entonces ocurre una violacion y se detiene el test. En caso contrario
        // intenta instalar el framework que va tomar control de la aplicacion y va a hacer el test
        FailOnThreadViolationRepaintManager.install();
    }
    
    @AfterClass
    public static void tearDownClass() {
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBotonGuardar method, of class FrmNuevoTurno.
     */
    @Test
    public void testNuevoTurno() {
        window.comboBox("ComboBoxEspecialidades").click().selectItem(4);
        window.comboBox("ComboBoxMecanicos").click().selectItem(1);
        window.comboBox("ComboBoxTitular").click().selectItem(1);
        window.comboBox("ComboBoxVehiculo").click().selectItem(1);
        window.comboBox("ComboBoxFecha").click().selectItem(1);
        window.comboBox("ComboBoxHora").click().selectItem(1);
        window.button("BotonGuardar").click();
    }
}
