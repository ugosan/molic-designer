package br.puc.molic.diagram.views;

import java.awt.Color;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Random;

import javax.swing.filechooser.FileFilter;

import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.ui.properties.UndoablePropertySheetEntry;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.nebula.widgets.gallery.DefaultGalleryGroupRenderer;
import org.eclipse.nebula.widgets.gallery.DefaultGalleryItemRenderer;
import org.eclipse.nebula.widgets.gallery.Gallery;
import org.eclipse.nebula.widgets.gallery.GalleryItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheetEntry;
import org.eclipse.ui.views.properties.PropertySheetPage;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class GalleryView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "br.puc.molic.diagram.views.GalleryView";

	private Gallery gallery;	
	private Action action1;
	private Action action2;
	private Action doubleClickAction;

	
	/**
	 * The constructor.
	 */
	public GalleryView() {
	}

	
	@Override
	public Object getAdapter(Class type) {
		if (type == org.eclipse.ui.views.properties.IPropertySheetPage.class) {
			PropertySheetPage page = new PropertySheetPage();
			
			PropertySheetEntry root = new PropertySheetEntry();
			root.setPropertySourceProvider(new IPropertySourceProvider() {
				public IPropertySource getPropertySource(Object object) {
					
					System.out.println(object);
					return null;
					
				}
			});
			page.setRootEntry(root);
			return page;
		}

		return super.getAdapter(type);
	}
	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {

		
		
		
		gallery = new Gallery(parent, SWT.V_SCROLL | SWT.MULTI);
		// Renderers
		DefaultGalleryGroupRenderer gr = new DefaultGalleryGroupRenderer();
		gr.setMinMargin(2);

		gr.setItemWidth(160);
		
		gr.setAutoMargin(true);
		gallery.setGroupRenderer(gr);
				
		DefaultGalleryItemRenderer ir = new DefaultGalleryItemRenderer();
		gallery.setItemRenderer(ir);
		ir.setDropShadows(true);
		ir.setDropShadowsSize(6);
		
		int operations = DND.DROP_COPY;
		Transfer[] types = new Transfer[] { org.eclipse.swt.dnd.FileTransfer.getInstance() };

		final DragSource source = new DragSource(gallery, operations);
		source.setTransfer(types);
		source.addDragListener(new DragSourceListener() {

			@Override
			public void dragFinished(DragSourceEvent event) {
				System.out.println(event);
				
			}

			@Override
			public void dragSetData(DragSourceEvent event) {
				System.out.println(event);
			}

			@Override
			public void dragStart(DragSourceEvent event) {
				System.out.println(event);
			}} ); 
		
		
			File f = new File("/home/ugo/googlecode/molic_export/gallery");
			File[] files = f.listFiles();
		
			GalleryItem group = new GalleryItem(gallery, SWT.NONE);
			group.setText("Public Repository"); //$NON-NLS-1$
			group.setExpanded(true);
			
			
			for (int i = 0; i < files.length; i++) {
				if(files[i].isFile()){
				GalleryItem item = new GalleryItem(group, SWT.NONE);
				
				
				Image itemImage = new Image(parent.getDisplay(), files[i].getAbsolutePath());
				
				item.setImage(itemImage);
				
				item.setText(files[i].getName().substring(0, files[i].getName().indexOf("."))); //$NON-NLS-1$
				
				
				}
				
			}
		
			f = new File("/home/ugo/googlecode/molic_export/gallery/google");
			
			files = f.listFiles();
			
			GalleryItem group2 = new GalleryItem(gallery, SWT.NONE);
			group2.setText("My Sketches"); //$NON-NLS-1$
			group2.setExpanded(true);
			
			
			for (int i = 0; i < files.length; i++) {
				GalleryItem item = new GalleryItem(group2, SWT.NONE);
				
				
				Image itemImage = new Image(parent.getDisplay(), files[i].getAbsolutePath());
				
				item.setImage(itemImage);
				
				item.setText(files[i].getName().substring(0, files[i].getName().indexOf("."))); //$NON-NLS-1$
				
				item.addListener(SWT.DragDetect, new Listener() {

					public void handleEvent(Event e) {
						System.out.println("mousedown" + e);
					}

				});

				
			}




		
		// Create the help context id for the viewer's control
		//PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "br.puc.molic.diagram.viewer");
		makeActions();
		//hookContextMenu();
		//hookDoubleClickAction();
		contributeToActionBars();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				GalleryView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(gallery.getParent());
		gallery.getParent().setMenu(menu);
		//getSite().registerContextMenu(menuMgr, gallery);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		//drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		//drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		action1 = new Action() {
			public void run() {
				showMessage("Action 1 executed");
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		doubleClickAction = new Action() {
			public void run() {
				/*ISelection selection = gallery.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				showMessage("Double-click detected on "+obj.toString());
				*/
			}
		};
	}


	private void showMessage(String message) {
		MessageDialog.openInformation(
			gallery.getParent().getShell(),
			"Gallery",
			message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		gallery.setFocus();
	}
}