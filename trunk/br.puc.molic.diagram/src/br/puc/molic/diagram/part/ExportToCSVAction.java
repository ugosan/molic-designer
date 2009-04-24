package br.puc.molic.diagram.part;

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
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;

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

    public void init(IWorkbenchWindow window) {}

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
            
            String title = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getTitle();
            

            SaveDialog dlg = new SaveDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), title.replaceFirst(".molic_diagram", ""));
            String path = dlg.open();
            
            String header = "nodeAutoId;nodeId;nodeType;nodeContent \n";
            write(path+".nodes.csv", header+csvnodes);
            
            header = "utAutoId;utSourceNodeAutoId;utTargetNodeAutoId;utId;utType;utPresup;utPrecond;utPerloc;utContent \n";
            write(path+".utterances.csv", header + csvconnections);

           // Desktop.getDesktop().open(new File(path+".nodes.csv"));
            //Desktop.getDesktop().open(new File(path+".utterances.csv"));
            
            /*
             * Open a editor
             */
             
            /* IFileStore fileStore = EFS.getLocalFileSystem().getStore(fileToOpen.toURI());
            IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
         
            try {
                IDE.opopenEditorOnFileStore( page, fileStore );
            } catch ( PartInitException e ) {
                //Put your exception handler here if you wish to
            }*/

            
        }catch(Exception e) {
            e.printStackTrace();
           MolicDiagramEditorPlugin.getInstance().logError(e.getMessage());
        }
    }
    
    /**
     * Format "nodeAutoId";"nodeId";"nodeType";"nodeContent"
     * @return
     */
    private String generateNodes() {
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
               String label = ((UbiquitousAccessImpl)n.getElement()).getLabel();
        	   if(label==null) label = "NULL";
        	   csv += getCSVLineNode(id, "Ubiqutous"+i, "3", label);
           }else if (name.equals("SystemProcess")) {
               csv += getCSVLineNode(id, "SystemProcess"+i, "2", "NULL");
           }else if (name.equals("ClosingPoint")) {
               csv += getCSVLineNode(id, "ClosingPoint"+i, "5", "NULL");
           }
       
       
       }
       
       
       return csv;
    }
    /**
     * Format "\"utAutoId\";\"utSourceNodeAutoId\";\"utTargetNodeAutoId\";\"utId\";\"utType\";\"utPresup\";\"utPrecond\";\"utPerloc\";\"utContent\"";
     * @return
     */
    private String generateConnections() {        
        String csv = "";
        for(int i=0;i<connections.size();i++) {
            EdgeImpl e = (EdgeImpl) connections.get(i).getModel();
            String name = e.getElement().eClass().getName();
            
            NodeImpl source = (NodeImpl) e.getSource();
            NodeImpl target = (NodeImpl) e.getTarget();
            
            String source_id = source.getElement().eResource().getURIFragment(source.getElement());
            String target_id = source.getElement().eResource().getURIFragment(target.getElement());
                        
            String id = e.getElement().eResource().getURIFragment(e.getElement());
            String utType = "NULL";
            String pressup = "NULL";
            String precond = "NULL";
            String perloc = "NULL";
            String label = "NULL";
             
            /* parsing utId */
            String utId = "";
            if(name.equals("Utterance")) {
                utId = "Utterance"+i;
            }else if (name.equals("BRTUtterance")) {
                utId = "BRUtterance"+i;
            }

            
            /* parsing de utType e label */
            if(name.equals("Utterance")) {
               Utterance element = ((Utterance)e.getElement());
                
               if(element.getLabel() != null) {
                   if(element.getLabel().indexOf("u:")!=-1){
                       utType = "1";
                   }else {
                       utType = "2";
                   }
                   label = element.getLabel();
               }
               
            }else if (name.equals("BRTUtterance")) {
                BRTUtterance element = ((BRTUtterance)e.getElement());
                
                if(element.getLabel() != null) {
                    if(element.getLabel().indexOf("u:")!=-1){
                        utType = "3";
                    }else {
                        utType = "4";
                    }
                    label = element.getLabel();
                }              
            }
            
            /* parsing pressup: */           
            int idxpressup = label.indexOf("pressup:");
            int idxprecond = label.indexOf("precond:");
            int idxperloc = label.indexOf("perloc:");
            int idxud = label.indexOf("u:");
            if(idxud==-1) idxud = label.indexOf("d:");

            
            if(idxpressup>-1) {
  
                String sub1 = "NULL"; int sub1length = 999; 
                String sub2 = "NULL"; int sub2length = 999; 
                String sub3 = "NULL"; int sub3length = 999; 
                
                if(idxprecond>-1) { 
                    sub1 = label.substring(idxpressup, idxprecond);
                    sub1length = sub1.length();
                }
                if(idxud>-1) { 
                    sub2 = label.substring(idxpressup, idxud);
                    sub2length = sub2.length();
                }
                if(idxperloc>-1) { 
                    sub3 = label.substring(idxpressup, idxperloc);
                    sub3length = sub3.length();
                }
                
                if((sub1length<sub2length)&&(sub1length<sub3length)){
                    //sub1 menor                    
                    pressup = sub1;
                }else if((sub2length<sub1length)&&(sub2length<sub3length)){
                    //sub2 menor
                    pressup = sub2;
                }else if((sub3length<sub1length)&&(sub3length<sub2length)){
                    pressup = sub3;
                }

            }
                
            /* parsing precond: */    
            if(idxprecond>-1) {                
                String sub2 = "NULL"; int sub2length = 999; 
                String sub3 = "NULL"; int sub3length = 999; 
                if(idxud>-1) { 
                    sub2 = label.substring(idxprecond, idxud);
                    sub2length = sub2.length();
                }
                if(idxperloc>-1) { 
                    sub3 = label.substring(idxprecond, idxperloc);
                    sub3length = sub3.length();
                }

                if(sub2length<sub3length){
                    //sub2 menor
                    precond = sub2;
                }else {
                    precond = sub3;
                }
                
            }
            
            /* parsing label and perloc: */    
            String udlabel = "NULL";
            if(idxperloc>-1) {                
                perloc = label.substring(idxperloc, label.length());
                
                udlabel = label.substring(idxud, idxperloc);
            }else if(idxud>-1)
                udlabel = label.substring(idxud, label.length());

            String parsed = getCSVLineConnection(id,source_id,target_id,utId,utType,pressup,precond,perloc,udlabel).replaceAll("\r", "" );
            
            csv += parsed.replaceAll("\n", "" )+"\n";
            
        
        }
        return csv;
    }
    
    
    private String getCSVLineNode(String nodeAutoId, String nodeId, String nodeType, String nodeContent) {
        String content = nodeContent.replaceAll("\r", " <br> ");
        
        return "\""+nodeAutoId+"\";\""+nodeId+"\";\""+nodeType+"\";\""+content.replaceAll("\n", "")+"\"";   
    }
    
    private String getCSVLineConnection(String utAutoId, String utSourceNodeAutoId, String utTargetNodeAutoId, String utId, String utType, String utPresup, String utPrecond, String utPerloc, String utContent) {
 
        return "\""+utAutoId+"\";\""+utSourceNodeAutoId+"\";\""+utTargetNodeAutoId+"\";\""+utId+"\";\""+utType+"\";\""+utPresup+"\";\""+utPrecond+"\";\""+utPerloc+"\";\""+utContent+"\"";
    }
    
    /**
     * Writes content on path file
     * @param path path to file
     * @param content the content
     * @throws Exception
     */
    private void write(String path, String content) throws Exception{
        Writer output = null;

        File file = new File(path);
        
        output = new BufferedWriter(new FileWriter(file));
        output.write(content);
        output.close();            
    }
    
    
    public void selectionChanged(IAction action, ISelection selection) {}

    public void dispose() {}
}