/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
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
import static org.junit.Assert.*;

/**
 *
 * @author francisco
 */
public class vistaHomeTest {
    
    private FrameFixture window;
    Robot robot;
    
    public vistaHomeTest() {
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
        GenericTypeMatcher<JFrame> matcher = new GenericTypeMatcher<JFrame>(JFrame.class){
            @Override
            // buscamos la ventana que queremos levantar con el robot
            protected boolean isMatching(JFrame frame){
                // para eso buscamos por titulo de ventana, si existe y si se esta mostrando
                return frame.getTitle() != null && frame.getTitle().startsWith("VISTA HOME") && frame.isShowing();
            }
        };
        window = WindowFinder.findFrame(matcher).using(robot);
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }

    /**
     * Test of getModeloTblTurnos method, of class vistaHome.
     */

    /**
     * Test of main method, of class vistaHome.
     */
    @Test
    public void testNuevoTurno() {
        // Se hace click en Nuuevo Turno
        window.button("BotonNuevoTurno").click();
        // Obtenemos la nueva ventana con titulo "NUEVO TURNO"
        GenericTypeMatcher<JFrame> matcher = new GenericTypeMatcher<JFrame>(JFrame.class){
            @Override
            // buscamos la ventana que queremos levantar con el robot
            protected boolean isMatching(JFrame frame){
                // para eso buscamos por titulo de ventana, si existe y si se esta mostrando
                return frame.getTitle() != null && frame.getTitle().startsWith("NUEVO TURNO") && frame.isShowing();
            }
        };
        window = WindowFinder.findFrame(matcher).using(robot);
        // se hace click en cancelar en esta ventana ya que no se quiere agrgar un nuevo turno sino mostrar el funcionamiento de la "VISTA HOME"
        window.button("BotonCancelar").click();
    }   
}
