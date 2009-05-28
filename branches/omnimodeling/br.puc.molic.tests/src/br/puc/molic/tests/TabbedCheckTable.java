package br.puc.molic.tests;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

import org.eclipse.jface.viewers.*;

public class TabbedCheckTable {

 public static void main(String[] args) {
  new TabbedCheckTable().run();
 }

 void run() {
  Display display = new Display();
  Shell shell = new Shell(display);
  shell.setLayout(new FillLayout());
  shell.setSize(600, 500);



  Table table = new Table(shell, SWT.CHECK | SWT.BORDER );
  table.setHeaderVisible(true);
  table.setLinesVisible(true);
  

  TableColumn col1 = new TableColumn(table, SWT.NONE);
  col1.setText("Highlight");
  TableColumn col2 = new TableColumn(table, SWT.NONE);
  col2.setText("Name");


  TableLayout layout = new TableLayout();
  layout.addColumnData(new ColumnWeightData(33));
  layout.addColumnData(new ColumnWeightData(57));
  table.setLayout(layout);

  final CheckboxTableViewer viewer = new CheckboxTableViewer(table);
  viewer.setContentProvider(new TestContentProvider());
  viewer.setLabelProvider(new TestLabelProvider());
  viewer.addSelectionChangedListener(new ISelectionChangedListener() {
   public void selectionChanged(SelectionChangedEvent event) {
    IStructuredSelection sel = (IStructuredSelection) event.getSelection();
    System.out.println(sel.size() + " items selected, " +
viewer.getCheckedElements().length + " items checked");
   }
  });
  viewer.setInput(new File("/"));



  shell.setVisible(true);
  while (!shell.isDisposed()) {
   if (!display.readAndDispatch()) {
    display.sleep();
   }
  }
 }

 class TestContentProvider implements IStructuredContentProvider {
  public Object[] getElements(Object input) {
   if (input instanceof File) {
    File dir = (File) input;
    String[] names = dir.list();
    if (names != null) {
     File[] files = new File[names.length];
     for (int i = 0; i < names.length; i++)
      files[i] = new File(dir, names[i]);
     return files;
    }
   }
   return new File[0];
  }
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
{
   // don't need to hang onto input for this example, so do nothing
  }
  public void dispose() {
  }
 }

 class TestLabelProvider extends LabelProvider implements
ITableLabelProvider {
  DateFormat dateFormat = DateFormat.getInstance();
  public String getColumnText(Object element, int columnIndex) {
   File file = (File) element;
   switch (columnIndex) {
    case 0:
     return file.getName();
    case 1:
     return file.isDirectory() ? "" : ((file.length() + 1023) / 1024) + "KB";
    default:
     return "";
   }
  }
  public Image getColumnImage(Object element, int columnIndex) {
   return null;
  }
 }
}
