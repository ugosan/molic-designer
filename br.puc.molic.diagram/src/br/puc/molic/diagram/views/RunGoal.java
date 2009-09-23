package br.puc.molic.diagram.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.impl.EdgeImpl;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;

import br.puc.molic.Connection;
import br.puc.molic.Element;

public class RunGoal {

	ArrayList<Element> nodes = new ArrayList<Element>();
	ArrayList<Connection> connections = new ArrayList<Connection>();
	
	public void run(List<ShapeNodeEditPart> nodes, List<ConnectionNodeEditPart> connections) {

		//System.out.println(nodes);
		//System.out.println(connections);
		
		for(int i=0;i<nodes.size();i++){
			Element e = (Element)((NodeImpl)nodes.get(i).getModel()).basicGetElement();
			this.nodes.add(e);
		}
		
		for(int i=0;i<connections.size();i++){
			Connection e = (Connection)((EdgeImpl)connections.get(i).getModel()).basicGetElement();
			this.connections.add(e);			
		}	
		
		System.out.println(findTopMost());
	}
	

	private Element findTopMost(){
		Element topmost = null;
		for(int i=0;i<nodes.size();i++){
			Element e = nodes.get(i);
			for(int x=0;x<connections.size();x++){
				if(e == connections.get(x).getTarget()){
					topmost = connections.get(x).getSource();
				}				
			}
		}
		
		return topmost;
	}

}
