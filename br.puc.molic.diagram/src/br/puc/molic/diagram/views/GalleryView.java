package br.puc.molic.diagram.views;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.nebula.widgets.gallery.DefaultGalleryGroupRenderer;
import org.eclipse.nebula.widgets.gallery.DefaultGalleryItemRenderer;
import org.eclipse.nebula.widgets.gallery.Gallery;
import org.eclipse.nebula.widgets.gallery.GalleryItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheetEntry;
import org.eclipse.ui.views.properties.PropertySheetPage;

import br.puc.molic.util.RelativePath;


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
	private Action help;
	private Action open;
	private Action doubleClickAction;
	
	private Composite parent;
	/**
	 * The constructor.
	 */
	public GalleryView() {
	}


	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		this.parent = parent;

		gallery = new Gallery(parent, SWT.V_SCROLL );

		// Renderers
		DefaultGalleryGroupRenderer gr = new DefaultGalleryGroupRenderer();
		gr.setMinMargin(2);

		gr.setItemSize(160, 120);

		gr.setAutoMargin(true);
		gallery.setGroupRenderer(gr);

		DefaultGalleryItemRenderer ir = new DefaultGalleryItemRenderer();
		gallery.setItemRenderer(ir);
		ir.setDropShadows(true);
		ir.setDropShadowsSize(5);

		int operations = DND.DROP_COPY;
		Transfer[] types = new Transfer[] { LocalSelectionTransfer.getTransfer() };

		final DragSource source = new DragSource(gallery, operations);
		source.setTransfer(types);

		source.addDragListener(new DragSourceListener() {

			@Override
			public void dragFinished(DragSourceEvent event) {


			}

			@Override
			public void dragSetData(DragSourceEvent event) {
				ISelection selection = new StructuredSelection(gallery.getSelection()[0].getData());
				event.data = gallery.getSelection()[0].getData();
				LocalSelectionTransfer.getTransfer().setSelection(selection);

			}

			@Override
			public void dragStart(DragSourceEvent event) {
				//System.out.println("start"+event);

			}} ); 


		loadGallery();
		
		
		
		/* abrir arquivo de imagem
		gallery.addMouseListener(new MouseListener(){

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
				GalleryItem[] i = gallery.getSelection();
				
				
				Display display = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getDisplay();
				
				final Image image = new Image (display, ""+i[0].getData());
				
				GC gc = new GC (image);
				
				gc.fillRectangle (image.getBounds ());
				gc.dispose ();

				Shell shell = new Shell (display);
				shell.setLayout (new FillLayout ());
				Group group = new Group (shell, SWT.NONE);
				group.setLayout (new FillLayout ());
				group.setText ("a square");
				Canvas canvas = new Canvas (group, SWT.NONE);
				canvas.addPaintListener (new PaintListener () {
					public void paintControl (PaintEvent e) {
						e.gc.drawImage (image, 0, 0);
					}
				});

				shell.pack ();
				shell.open ();
				while (!shell.isDisposed ()) {
					if (!display.readAndDispatch ())
						display.sleep ();
				}
				image.dispose ();
				display.dispose ();


			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	*/


		// Create the help context id for the viewer's control
		//PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "br.puc.molic.diagram.viewer");
		makeActions();
		//hookContextMenu();
		//hookDoubleClickAction();
		contributeToActionBars();
	}

	
	private void loadGallery(){
		try{
			IWorkspaceRoot myWorkspaceRoot= ResourcesPlugin.getWorkspace().getRoot();
			File galleryconf = myWorkspaceRoot.getLocation().append("gallery.conf").toFile();

			if(!galleryconf.exists()) galleryconf.createNewFile();

			
			Properties p = new Properties();
			FileInputStream fis = new FileInputStream(galleryconf);
			p.load(fis);

			String prop = p.getProperty("dirs");

			if(prop!= null && !prop.trim().equals("")){
				
				gallery.removeAll();
				String[] dirs = prop.split(";");
				for(int d=0;d<dirs.length;d++){
					File f = new File(dirs[d]);
					File[] files = f.listFiles();
					GalleryItem group = new GalleryItem(gallery, SWT.NONE);
					//group.setText(RelativePath.getRelativePath(openedFile, f)); //$NON-NLS-1$
					group.setText(f.getAbsolutePath()); //$NON-NLS-1$
					group.setExpanded(true);

					for (int i = 0; i < files.length; i++) {
						if(files[i].isFile()){
							try{
							
							
							Image itemImage = new Image(parent.getDisplay(), files[i].getAbsolutePath());
							
							GalleryItem item = new GalleryItem(group, SWT.NONE);
							item.setImage(itemImage);
							item.setText(files[i].getName().substring(0, files[i].getName().indexOf("."))); //$NON-NLS-1$
							item.setData(files[i]);
							}catch(Exception ex){
								
							}
						}
					}
					
					
				}
			
			
			}
		}catch(Exception e){
			e.printStackTrace();
		}
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
		fillLocalToolBar(bars.getToolBarManager());
		fillLocalPullDown(bars.getMenuManager());
	}



	private void fillContextMenu(IMenuManager manager) {

		manager.add(open);
		manager.add(new Separator());
		manager.add(help);
		//drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		
	}

	private void fillLocalPullDown(IMenuManager manager) {
		//manager.add(newGoal);		
		manager.add(new Action(){

			@Override
			public String getText() {
				return "Small";
			}

			@Override
			public void run() {
				DefaultGalleryGroupRenderer gr = (DefaultGalleryGroupRenderer) gallery.getGroupRenderer();
				gr.setItemSize(80, 60);
			}
			
		});
		manager.add(new Action(){

			@Override
			public String getText() {
				return "Big";
			}

			@Override
			public void run() {
				DefaultGalleryGroupRenderer gr = (DefaultGalleryGroupRenderer) gallery.getGroupRenderer();
				gr.setItemSize(160, 120);
			}
			
		});
		manager.add(new Action(){

			@Override
			public String getText() {
				return "Huge";
			}

			@Override
			public void run() {
				DefaultGalleryGroupRenderer gr = (DefaultGalleryGroupRenderer) gallery.getGroupRenderer();
				
				gr.setItemSize(320, 240);
				gr.setFillIfSingleColumn(true);
				
			}
			
		});
		
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {

		manager.add(open);
		manager.add(new Separator());
		manager.add(help);
		//drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {

		open = new Action() {
			public void run() {
				try { 
				DirectoryDialog dialog = new DirectoryDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
				 
				 String folder = dialog.open();
				 if(folder != null){
					 
					IWorkspaceRoot myWorkspaceRoot= ResourcesPlugin.getWorkspace().getRoot();
					File galleryconf = myWorkspaceRoot.getLocation().append("gallery.conf").toFile();
					if(!galleryconf.exists()) galleryconf.createNewFile();
						
					Properties p = new Properties();
					FileInputStream fis = new FileInputStream(galleryconf);
					p.load(fis);
							
					String dirs = p.getProperty("dirs");					
					if(dirs == null) dirs = "";
					dirs += folder+";";
							
					p.setProperty("dirs", dirs);
					
					FileOutputStream fos = new FileOutputStream(galleryconf);
					p.store(fos, "Properties of MoLIC Designer's UI. Delete this file to restore to the original state");
					
					loadGallery();
					 
				 }
				 } catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
			}
		};
		open.setText("Open");
		open.setToolTipText("Open Image Folder");
		open.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJ_FOLDER));

		help = new Action() {
			public void run() {
				showMessage("This will have help content");

			}
		};
		help.setText("Help");
		help.setToolTipText("Help");
		help.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_LCL_LINKTO_HELP));

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