package br.puc.molic.diagram.part;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.notation.impl.EdgeImpl;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import br.puc.molic.BRTUtterance;
import br.puc.molic.Utterance;
import br.puc.molic.diagram.SaveDialog;
import br.puc.molic.diagram.edit.parts.DiagramEditPart;
import br.puc.molic.impl.SceneImpl;
import br.puc.molic.impl.UbiquitousAccessImpl;

/**
 * 
 * 
 * @author ugo
 *
 */
public class ExportToCSVAction implements IWorkbenchWindowActionDelegate {


    List<EditPart> nodes;
    List<ConnectionEditPart> connections;

    public void init(IWorkbenchWindow window) {
        // TODO Auto-generated method stub

    }

    public void run(IAction action) {       
        MolicDiagramEditor editor = (MolicDiagramEditor)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        DiagramEditPart diagram = (DiagramEditPart) editor.getDiagramEditPart();
               
        nodes = (List<EditPart>)diagram.getChildren();
        connections = (List<ConnectionEditPart>)diagram.getConnections();
                       
        
        //EditPart p = (EditPart) diagram.getChildren().get(0);
        //p.setSelected(EditPart.SELECTED_PRIMARY);
        try {
        
            String csvnodes = generateNodes();
            String csvconnections = generateConnections();
            System.out.println(generateNodes());
            System.out.println(generateConnections());
            
            
            
            SaveDialog dlg = new SaveDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getTitle()+".txt");
            String path = dlg.open();
        
            write(path, csvnodes+csvconnections);

            Desktop.getDesktop().open(new File(path));
            
            /*IFileStore fileStore = EFS.getLocalFileSystem().getStore(fileToOpen.toURI());
            IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
         
            try {
                IDE.opopenEditorOnFileStore( page, fileStore );
            } catch ( PartInitException e ) {
                //Put your exception handler here if you wish to
            }*/

            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Format "nodeAutoId";"nodeId";"nodeType";"nodeContent"
     * @return
     */
    private String generateNodes() {
      // String csv = "\"nodeAutoId\";\"nodeId\";\"nodeType\";\"nodeContent\"";
       String csv = "";
       
       
       for(int i=0;i<nodes.size();i++) {
           NodeImpl n = (NodeImpl) nodes.get(i).getModel();
           String name = n.getElement().eClass().getName();
           csv += "\n";
           
                             
           String id = n.getElement().eResource().getURIFragment(n.getElement());
           
           if(name.equals("OpeningPoint")) {
               csv += getCSVLineNode(id, "OpeningPoint"+i, "4", "NULL");
               
           }else if (name.equals("Scene")) {
               csv += getCSVLineNode(id, ((SceneImpl)n.getElement()).getTopic(), "1", ((SceneImpl)n.getElement()).getDialogue());
           }else if (name.equals("UbiquitousAccess")) {
               csv += getCSVLineNode(id, "Ubiqutous"+i, "3", ((UbiquitousAccessImpl)n.getElement()).getLabel());
           }else if (name.equals("SystemProcess")) {
               csv += getCSVLineNode(id, "SystemProcess"+i, "2", "NULL");
           }else if (name.equals("ClosingPoint")) {
               csv += getCSVLineNode(id, "ClosingPoint"+i, "5", "NULL");
           }
       
       
       }
       
       
       return csv;
    }
    
    private String generateConnections() {
        //String csv = "\"utAutoId\";\"utSourceNodeAutoId\";\"utTargetNodeAutoId\";\"utId\";\"utType\";\"utPresup\";\"utPrecond\";\"utPerloc\";\"utContent\"";
        String csv = "";
        for(int i=0;i<connections.size();i++) {
            EdgeImpl e = (EdgeImpl) connections.get(i).getModel();
            String name = e.getElement().eClass().getName();
            csv += "\n";
            
            NodeImpl source = (NodeImpl) e.getSource();
            NodeImpl target = (NodeImpl) e.getTarget();
            
            String source_id = source.getElement().eResource().getURIFragment(source.getElement());
            String target_id = source.getElement().eResource().getURIFragment(target.getElement());
            
            
            
                              
            String id = e.getElement().eResource().getURIFragment(e.getElement());
            
            if(name.equals("Utterance")) {
               Utterance element = ((Utterance)e.getElement());
                csv += getCSVLineConnection(id,source_id,target_id,"Utterance"+i,"12",element.getLabel(),element.getLabel(),element.getLabel(),element.getLabel());
                
            }else if (name.equals("BRTUtterance")) {
                BRTUtterance element = ((BRTUtterance)e.getElement());
                csv += getCSVLineConnection(id,source_id,target_id,"BRUtterance"+i,"34",element.getLabel(),element.getLabel(),element.getLabel(),element.getLabel());
                
            }
        
        
        }
        return csv;
    }
    
    
    private String getCSVLineNode(String nodeAutoId, String nodeId, String nodeType, String nodeContent) {
        String content = nodeContent.replaceAll("\n", " -br- ");
        
        return "\""+nodeAutoId+"\";\""+nodeId+"\";\""+nodeType+"\";\""+content+"\"";
   
    }
    
    private String getCSVLineConnection(String utAutoId, String utSourceNodeAutoId, String utTargetNodeAutoId, String utId, String utType, String utPresup, String utPrecond, String utPerloc, String utContent) {

        return "\""+utAutoId+"\";\""+utSourceNodeAutoId+"\";\""+utTargetNodeAutoId+"\";\""+utId+"\";\""+utType.replaceAll("\n", "-br-")+"\";\""+utPresup.replaceAll("\n", "-br-")+"\";\""+utPrecond.replaceAll("\n", "-br-")+"\";\""+utPerloc.replaceAll("\n", "-br-")+"\";\""+utContent.replaceAll("\n", "-br-")+"\"";
        
   
    }
    
    
    private void write(String path, String content) throws Exception{
        Writer output = null;

        File file = new File(path);
        output = new BufferedWriter(new FileWriter(file));
        output.write(content);
        output.close();
    }
    
    

    public void selectionChanged(IAction action, ISelection selection) {
        

    }

    public void dispose() {
        // TODO Auto-generated method stub

    }
}
