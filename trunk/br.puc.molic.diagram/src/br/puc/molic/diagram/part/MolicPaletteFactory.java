/*
 * Teste de nota de copyright do Molic
 */
package br.puc.molic.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import br.puc.molic.diagram.providers.MolicElementTypes;

/**
 * @generated
 */
public class MolicPaletteFactory {

	/**
	 * @generated 
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createDefault1Group());
	}

	/**
	 * Creates "Default" palette tool group
	 * @generated 
	 */
	private PaletteContainer createDefault1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Default1Group_title);
		paletteContainer.setId("createDefault1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Default1Group_desc);
		paletteContainer.add(createScene1CreationTool());
		paletteContainer.add(createOpeningPoint2CreationTool());
		paletteContainer.add(createClosingPoint3CreationTool());
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(createSystemProcess5CreationTool());
		paletteContainer.add(createUbiquitousAccess6CreationTool());
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(createUtterance8CreationTool());
		paletteContainer.add(createBreakdown9CreationTool());
		//paletteContainer.add(createSketch10CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createScene1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MolicElementTypes.Scene_2007);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Scene1CreationTool_title,
				Messages.Scene1CreationTool_desc, types);
		entry.setId("createScene1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MolicDiagramEditorPlugin
				.findImageDescriptor("/br.puc.molic/icons/scene_small.png")); //$NON-NLS-1$
		entry.setLargeIcon(MolicDiagramEditorPlugin
				.findImageDescriptor("/br.puc.molic/icons/scene_big.png")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated 
	 */
	private ToolEntry createOpeningPoint2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MolicElementTypes.OpeningPoint_2011);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.OpeningPoint2CreationTool_title,
				Messages.OpeningPoint2CreationTool_desc, types);
		entry.setId("createOpeningPoint2CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(MolicDiagramEditorPlugin
						.findImageDescriptor("/br.puc.molic/icons/openingpoint_small.png")); //$NON-NLS-1$
		entry
				.setLargeIcon(MolicDiagramEditorPlugin
						.findImageDescriptor("/br.puc.molic/icons/openingpoint_big.png")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClosingPoint3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MolicElementTypes.ClosingPoint_2012);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ClosingPoint3CreationTool_title,
				Messages.ClosingPoint3CreationTool_desc, types);
		entry.setId("createClosingPoint3CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(MolicDiagramEditorPlugin
						.findImageDescriptor("/br.puc.molic/icons/closingpoint_small.png")); //$NON-NLS-1$
		entry
				.setLargeIcon(MolicDiagramEditorPlugin
						.findImageDescriptor("/br.puc.molic/icons/closingpoint_big.png")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSystemProcess5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MolicElementTypes.SystemProcess_2008);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SystemProcess5CreationTool_title,
				Messages.SystemProcess5CreationTool_desc, types);
		entry.setId("createSystemProcess5CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(MolicDiagramEditorPlugin
						.findImageDescriptor("/br.puc.molic/icons/systemprocess_small.png")); //$NON-NLS-1$
		entry
				.setLargeIcon(MolicDiagramEditorPlugin
						.findImageDescriptor("/br.puc.molic/icons/systemprocess_big.png")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUbiquitousAccess6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MolicElementTypes.UbiquitousAccess_2010);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.UbiquitousAccess6CreationTool_title,
				Messages.UbiquitousAccess6CreationTool_desc, types);
		entry.setId("createUbiquitousAccess6CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(MolicDiagramEditorPlugin
						.findImageDescriptor("/br.puc.molic/icons/ubiquitous_small.png")); //$NON-NLS-1$
		entry.setLargeIcon(MolicDiagramEditorPlugin
				.findImageDescriptor("/br.puc.molic/icons/ubiquitous_big.png")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUtterance8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MolicElementTypes.Utterance_4001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Utterance8CreationTool_title,
				Messages.Utterance8CreationTool_desc, types);
		entry.setId("createUtterance8CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(MolicDiagramEditorPlugin
						.findImageDescriptor("/br.puc.molic/icons/utterance_small.png")); //$NON-NLS-1$
		entry.setLargeIcon(MolicDiagramEditorPlugin
				.findImageDescriptor("/br.puc.molic/icons/utterance_big.png")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBreakdown9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MolicElementTypes.BRTUtterance_4002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Breakdown9CreationTool_title,
				Messages.Breakdown9CreationTool_desc, types);
		entry.setId("createBreakdown9CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(MolicDiagramEditorPlugin
						.findImageDescriptor("/br.puc.molic/icons/utterance_small.png")); //$NON-NLS-1$
		entry.setLargeIcon(MolicDiagramEditorPlugin
				.findImageDescriptor("/br.puc.molic/icons/utterance_big.png")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSketch10CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(MolicElementTypes.Sketch_3001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Sketch10CreationTool_title,
				Messages.Sketch10CreationTool_desc, types);
		entry.setId("createSketch10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MolicElementTypes
				.getImageDescriptor(MolicElementTypes.Sketch_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private static class NodeToolEntry extends PaletteToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated NOT
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
			super(null, title, null);
			this.setDescription(description);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
