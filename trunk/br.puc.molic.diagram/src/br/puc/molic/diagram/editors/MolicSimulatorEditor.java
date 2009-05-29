package br.puc.molic.diagram.editors;


import java.io.StringWriter;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;

/**
 * An example showing how to create a multi-page editor.
 * This example has 3 pages:
 * <ul>
 * <li>page 0 contains a nested text editor.
 * <li>page 1 allows you to change the font used in page 2
 * <li>page 2 shows the words in page 0 in sorted order
 * </ul>
 */
public class MolicSimulatorEditor extends MultiPageEditorPart implements IResourceChangeListener{

	/** The text editor used in page 0. */
	private TextEditor editor;

	/** The font chosen in page 1. */
	private Font font;

	/** The text widget used in page 2. */
	private StyledText text;
	
	 private FormToolkit toolkit;
	 private ScrolledForm form;

	
	/**
	 * Creates a multi-page editor example.
	 */
	public MolicSimulatorEditor() {
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}

	/**
	 * Creates page 1 of the multi-page editor,
	 * which allows you to change the font used in page 2.
	 */
	void createPage1() {
		toolkit = new FormToolkit(getContainer().getDisplay());
		form = toolkit.createScrolledForm(getContainer());
		form.setText("MoLIC Simulation");

		GridLayout layout = new GridLayout();
		form.getBody().setLayout(layout);
		final FormText formText = toolkit.createFormText(form.getBody(), true);

		final Hyperlink link = toolkit.createHyperlink(form.getBody(), "Click here.", SWT.WRAP);
		
		link.setData("a", System.currentTimeMillis()+"");
		link.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				 
				//System.out.println(form.getBody());				
				link.setEnabled(false);
				formText.setText(generate(formText, ""+link.getData("a")), true, false);
				form.reflow(true);
			}
		});

/*
		Section section = toolkit.createSection(form.getBody(), 
				  Section.DESCRIPTION|Section.TITLE_BAR|
				  Section.TWISTIE|Section.EXPANDED);
				 
				 section.addExpansionListener(new ExpansionAdapter() {
				  public void expansionStateChanged(ExpansionEvent e) {
				   form.reflow(true);
				  }
				 });
				 section.setText("Section title");
				 section.setDescription("This is the description that goes below the title");
				 Composite sectionClient = toolkit.createComposite(section);
				 sectionClient.setLayout(new GridLayout());
				 Button button = toolkit.createButton(sectionClient, "Radio 1", SWT.RADIO);
				 button = toolkit.createButton(sectionClient, "Radio 2", SWT.RADIO);
				 section.setClient(sectionClient);
		*/
				 
				 int index = addPage(form);
		setPageText(index, "Simulation");
	}
	/**
	 * Creates page 2 of the multi-page editor,
	 * which shows the sorted text.
	 */
	void createPage2() {
		Composite composite = new Composite(getContainer(), SWT.NONE);
		FillLayout layout = new FillLayout();
		composite.setLayout(layout);
		text = new StyledText(composite, SWT.H_SCROLL | SWT.V_SCROLL);
		text.setEditable(false);

		int index = addPage(composite);
		setPageText(index, "Detail");
	}
	
	private String generate(final FormText formText, String appended){
		StringBuffer buf = new StringBuffer();

		buf.append("<form>");
		 buf.append("<p>");
		 buf.append("Here is some plain text for the text to render; ");
		 buf.append("this text is at <a href=\"http://www.eclipse.org\" "+
		   "nowrap=\"true\">http://www.eclipse.org</a> web site.");
		 buf.append("</p>");
		 buf.append("<p>");
		 buf.append("<span color=\"header\" font=\"header\">"+
		   "This text is in header font and color.</span>");
		 buf.append("</p>");
		 buf.append("<p>This line will contain some <b>bold</b> and "+
		   "some <span font=\"code\">source</span> text. ");
		 buf.append("We can also add <img href=\"image\"/> an image. ");
		 buf.append("</p>");
		 buf.append("<li>A default (bulleted) list item.</li>");
		 buf.append("<li>Another bullet list item.</li>");
		 buf.append("<li style=\"text\" value=\"1.\">A list item with text.</li>");

		 buf.append("<li style=\"image\" value=\"image\">List item with "+
		    "an image bullet</li>");
		 buf.append("<li style=\"text\" bindent=\"20\" indent=\"40\" value=\"3.\">"+
		   "A list item with text.</li>");
		 buf.append("<li style=\"text\" bindent=\"20\" indent=\"40\" value=\"4.\">"+
		   "A list item with text.</li>");
		 buf.append("<p>     leading blanks;      more white \n\n new "+
		   "lines   <br/>  \n   more <b>   bb   </b>  white  . </p>");
		 buf.append("</form>");
		 final Hyperlink link = toolkit.createHyperlink(form.getBody(), System.currentTimeMillis()+"", SWT.WRAP);
			
			link.setData("a", System.currentTimeMillis()+"");
			link.addHyperlinkListener(new HyperlinkAdapter() {
				public void linkActivated(HyperlinkEvent e) {
					 
					//System.out.println(form.getBody());				
					link.setEnabled(false);
					formText.setText(generate(formText, ""+link.getData("a")), true, false);
					form.reflow(true);
				}
			});
		
		return buf.toString();
		
	}
	
	
	/**
	 * Creates the pages of the multi-page editor.
	 */
	protected void createPages() {

		createPage1();
		createPage2();
	}
	/**
	 * The <code>MultiPageEditorPart</code> implementation of this 
	 * <code>IWorkbenchPart</code> method disposes all nested editors.
	 * Subclasses may extend.
	 */
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}
	/**
	 * Saves the multi-page editor's document.
	 */
	public void doSave(IProgressMonitor monitor) {
		getEditor(0).doSave(monitor);
	}
	/**
	 * Saves the multi-page editor's document as another file.
	 * Also updates the text for page 0's tab, and updates this multi-page editor's input
	 * to correspond to the nested editor's.
	 */
	public void doSaveAs() {
		IEditorPart editor = getEditor(0);
		editor.doSaveAs();
		setPageText(0, editor.getTitle());
		setInput(editor.getEditorInput());
	}
	/* (non-Javadoc)
	 * Method declared on IEditorPart
	 */
	public void gotoMarker(IMarker marker) {
		setActivePage(0);
		IDE.gotoMarker(getEditor(0), marker);
	}
	/**
	 * The <code>MultiPageEditorExample</code> implementation of this method
	 * checks that the input is an instance of <code>IFileEditorInput</code>.
	 */
	public void init(IEditorSite site, IEditorInput editorInput)
		throws PartInitException {
		//if (!(editorInput instanceof IFileEditorInput))
		//	throw new PartInitException("Invalid Input: Must be IFileEditorInput");
		super.init(site, editorInput);
	}
	/* (non-Javadoc)
	 * Method declared on IEditorPart.
	 */
	public boolean isSaveAsAllowed() {
		return true;
	}
	/**
	 * Calculates the contents of page 2 when the it is activated.
	 */
	protected void pageChange(int newPageIndex) {
		super.pageChange(newPageIndex);
		if (newPageIndex == 2) {
			sortWords();
		}
	}
	/**
	 * Closes all project files on project close.
	 */
	public void resourceChanged(final IResourceChangeEvent event){
		if(event.getType() == IResourceChangeEvent.PRE_CLOSE){
			Display.getDefault().asyncExec(new Runnable(){
				public void run(){
					IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
					for (int i = 0; i<pages.length; i++){
						if(((FileEditorInput)editor.getEditorInput()).getFile().getProject().equals(event.getResource())){
							IEditorPart editorPart = pages[i].findEditor(editor.getEditorInput());
							pages[i].closeEditor(editorPart,true);
						}
					}
				}            
			});
		}
	}
	/**
	 * Sets the font related data to be applied to the text in page 2.
	 */
	void setFont() {
		FontDialog fontDialog = new FontDialog(getSite().getShell());
		fontDialog.setFontList(text.getFont().getFontData());
		FontData fontData = fontDialog.open();
		if (fontData != null) {
			if (font != null)
				font.dispose();
			font = new Font(text.getDisplay(), fontData);
			text.setFont(font);
		}
	}
	/**
	 * Sorts the words in page 0, and shows them in page 2.
	 */
	void sortWords() {

		String editorText =
			editor.getDocumentProvider().getDocument(editor.getEditorInput()).get();

		StringTokenizer tokenizer =
			new StringTokenizer(editorText, " \t\n\r\f!@#\u0024%^&*()-_=+`~[]{};:'\",.<>/?|\\");
		ArrayList editorWords = new ArrayList();
		while (tokenizer.hasMoreTokens()) {
			editorWords.add(tokenizer.nextToken());
		}

		Collections.sort(editorWords, Collator.getInstance());
		StringWriter displayText = new StringWriter();
		for (int i = 0; i < editorWords.size(); i++) {
			displayText.write(((String) editorWords.get(i)));
			displayText.write(System.getProperty("line.separator"));
		}
		text.setText(displayText.toString());
	}
}
