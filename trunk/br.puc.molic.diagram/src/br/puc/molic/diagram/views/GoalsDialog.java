package br.puc.molic.diagram.views;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class GoalsDialog extends InputDialog{

    public GoalsDialog(Shell parentShell, String dialogTitle,
            String dialogMessage, String initialValue, IInputValidator validator) {
        super(parentShell, dialogTitle, dialogMessage, initialValue, validator);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void configureShell(Shell shell) {
        // TODO Auto-generated method stub
        super.configureShell(shell);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        TabFolder tabFolder = new TabFolder(parent, SWT.NONE);
        tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        
        TabItem item = new TabItem(tabFolder, SWT.NONE);
        item.setText("Widget");
        Composite composite = new Composite(tabFolder, SWT.NONE);
        composite.setLayout(new GridLayout());
        Tree tree = new Tree(composite, SWT.BORDER);
        item.setControl(composite);
        tree.setHeaderVisible(true);
        tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        TreeColumn column1 = new TreeColumn(tree, SWT.NONE);
        column1.setText("Standard");
        TreeColumn column2 = new TreeColumn(tree, SWT.NONE);
        column2.setText("Widget");
        TreeItem branch = new TreeItem(tree, SWT.NONE);
        branch.setText(new String [] {"Efficient", "Portable"});
        TreeItem leaf = new TreeItem(branch, SWT.NONE);
        leaf.setText(new String [] {"Cross", "Platform"});
        branch.setExpanded(true);
        branch = new TreeItem(tree, SWT.NONE);
        branch.setText(new String [] {"Native", "Controls"});
        leaf = new TreeItem(branch, SWT.NONE);
        leaf.setText(new String [] {"Cross", "Platform"});
        branch = new TreeItem(tree, SWT.NONE);
        branch.setText(new String [] {"Cross", "Platform"});
        column1.pack();
        column2.pack();

        item = new TabItem(tabFolder, SWT.NONE);
        item.setText("Toolkit");
        
        Button button = new Button(parent, SWT.CHECK);
        button.setText("Totally");
        button.setSelection(true);
        button.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
        
        button = new Button(parent, SWT.PUSH);
        button.setText("Awesome");
        button.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));

        
        return tabFolder;
        
    }

    @Override
    protected Button getOkButton() {
        // TODO Auto-generated method stub
        return super.getOkButton();
    }

}
