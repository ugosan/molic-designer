package br.puc.molic.diagram.edit.policies;

import java.util.List;

import org.eclipse.gef.editpolicies.ResizableEditPolicy;

public class MolicresizableEditPolicy extends ResizableEditPolicy{
	
	@Override
	protected List createSelectionHandles() {
	   
	        // return standard selection handles:
	        return super.createSelectionHandles();
	    
	} 
	

}
