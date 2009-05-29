package br.puc.molic.tests;

/*
 * FormLayout example snippet: create a simple OK/CANCEL dialog using form layout
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class Snippet71 {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell (display);
	shell.pack ();
	shell.open ();
	Shell dialog = new Shell (shell, SWT.DIALOG_TRIM);
	
	Table table = new Table(dialog, SWT.CHECK | SWT.BORDER );
	table.setHeaderVisible(false);
	table.setLinesVisible(false);
		  
	CheckboxTableViewer viewer = new CheckboxTableViewer(table);
	    
	Button okButton = new Button (dialog, SWT.PUSH);
	okButton.setText ("&OK");
	Button cancelButton = new Button (dialog, SWT.PUSH);
	cancelButton.setText ("&Cancel");
	
	FormLayout form = new FormLayout ();
	form.marginWidth = form.marginHeight = 8;
	dialog.setLayout (form);
	FormData okData = new FormData ();
	okData.top = new FormAttachment (table, 8);
	okButton.setLayoutData (okData);
	FormData cancelData = new FormData ();
	cancelData.left = new FormAttachment (okButton, 8);
	cancelData.top = new FormAttachment (okButton, 0, SWT.TOP);
	cancelButton.setLayoutData (cancelData);
	
	dialog.setDefaultButton (okButton);
	dialog.pack ();
	dialog.open ();
	
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
} 

