package org.myorg.alberto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
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
public final class EjecutableActionListener extends AbstractAction implements ActionListener {

    String directorio;
    String fichero;
    String clase;
    String so;
    String nombre;

    @Override
    @SuppressWarnings("empty-statement")
    public void actionPerformed(ActionEvent e) {
        directorio = JOptionPane.showInputDialog("Directorio");
        fichero = JOptionPane.showInputDialog("Fichero");
        clase = JOptionPane.showInputDialog("Clase");
        so = JOptionPane.showInputDialog("Extension S.O");
        nombre = JOptionPane.showInputDialog("Nombre");

        try {

            String[] cmd = {"javapackager", " -deploy", " -native", so, " -outdir",
                directorio, " -outfile", clase, " -srcdir", directorio, " -srcfiles", fichero, " -appclass", clase, " -name", nombre, " -title", nombre};

            Process process = Runtime.getRuntime().exec(cmd);
            InputStream inputstream = process.getInputStream();
            BufferedInputStream bufferedinputstream = new BufferedInputStream(inputstream);
            JOptionPane.showMessageDialog(null, "Exito");
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

    }
}
