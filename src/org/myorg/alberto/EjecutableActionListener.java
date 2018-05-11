
package org.myorg.alberto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
       
    }
}
