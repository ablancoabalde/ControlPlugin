package org.myorg.alberto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "org.myorg.alberto.EjecutableActionListener"
)
@ActionRegistration(
        iconBase = "org/myorg/alberto/17C.png",
        displayName = "#CTL_EjecutableActionListener"
)
@ActionReference(path = "Toolbars/File", position = 0)
@Messages("CTL_EjecutableActionListener=Ejecutable")

/**
 * El disparador de la clase
 */
public final class EjecutableActionListener extends AbstractAction implements ActionListener {

    String directorio;
    String dfichero;
    String fichero;
    String clase;
    String so;
    String nombre;
    String cmd;
/**
 * Ejecutar el metodo
 * @param e 
 */
    @Override
    @SuppressWarnings("empty-statement")
    public void actionPerformed(ActionEvent e) {
        /**
         * SO Extensión del ejecutable 
         * directorio donde va a guardar el programa
         * dfichero directorio donde está el fichero 
         * fichero nombre.jar 
         * clasenombre paquete.nombreMain 
         * Nombre del proyecto
         */
        so = JOptionPane.showInputDialog("Extension S.O");
        directorio = JOptionPane.showInputDialog("Directorio guardar");
        dfichero = JOptionPane.showInputDialog("Directorio fichero");
        fichero = JOptionPane.showInputDialog("Nombre fichero");
        clase = JOptionPane.showInputDialog("Clase");
        nombre = JOptionPane.showInputDialog("Nombre");

        try {

             cmd = "javapackager"+ " -deploy "+ " -native "+ so+ " -outdir "+
                directorio+ " -outfile "+ nombre+ " -srcdir "+ dfichero+ " -srcfiles "+ fichero+ " -appclass "+ clase+ " -name "+ nombre+ " -title "+ nombre;
            Runtime rt =Runtime.getRuntime();
            Process process = rt.exec(cmd);
            BufferedReader input= new BufferedReader(new InputStreamReader(process.getInputStream()));
            JOptionPane.showMessageDialog(null, "Exito");
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
           JOptionPane.showMessageDialog(null, "error"+cmd);

        }

    }
}
