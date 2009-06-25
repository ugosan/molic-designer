package br.puc.molic.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import br.puc.molic.MolicPackage;
import br.puc.molic.diagram.edit.parts.BRTUtteranceLabelEditPart;

import br.puc.molic.diagram.edit.parts.SceneDialogueEditPart;
import br.puc.molic.diagram.edit.parts.SceneTopicEditPart;
import br.puc.molic.diagram.edit.parts.UbiquitousAccessLabelEditPart;
import br.puc.molic.diagram.edit.parts.UtteranceLabelEditPart;
import br.puc.molic.diagram.edit.parts.WrappingLabelEditPart;
import br.puc.molic.diagram.parsers.MessageFormatParser;
import br.puc.molic.diagram.part.MolicVisualIDRegistry;

/**
 * @generated
 */
public class MolicParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser sceneTopic_5004Parser;

	/**
	 * @generated
	 */
	private IParser getSceneTopic_5004Parser() {
		if (sceneTopic_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { MolicPackage.eINSTANCE
					.getScene_Topic() };
			MessageFormatParser parser = new MessageFormatParser(features);
			sceneTopic_5004Parser = parser;
		}
		return sceneTopic_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser sceneDialogue_5005Parser;

	/**
	 * @generated
	 */
	private IParser getSceneDialogue_5005Parser() {
		if (sceneDialogue_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { MolicPackage.eINSTANCE
					.getScene_Dialogue() };
			MessageFormatParser parser = new MessageFormatParser(features);
			sceneDialogue_5005Parser = parser;
		}
		return sceneDialogue_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser ubiquitousAccessLabel_5007Parser;

	/**
	 * @generated
	 */
	private IParser getUbiquitousAccessLabel_5007Parser() {
		if (ubiquitousAccessLabel_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { MolicPackage.eINSTANCE
					.getUbiquitousAccess_Label() };
			MessageFormatParser parser = new MessageFormatParser(features);
			ubiquitousAccessLabel_5007Parser = parser;
		}
		return ubiquitousAccessLabel_5007Parser;
	}

	/**
	 * @generated
	 */
	private IParser utteranceLabel_6001Parser;

	/**
	 * @generated
	 */
	private IParser getUtteranceLabel_6001Parser() {
		if (utteranceLabel_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { MolicPackage.eINSTANCE
					.getConnection_Label() };
			MessageFormatParser parser = new MessageFormatParser(features);
			utteranceLabel_6001Parser = parser;
		}
		return utteranceLabel_6001Parser;
	}

	/**
	 * @generated
	 */
	private IParser bRTUtteranceLabel_6002Parser;

	/**
	 * @generated
	 */
	private IParser getBRTUtteranceLabel_6002Parser() {
		if (bRTUtteranceLabel_6002Parser == null) {
			EAttribute[] features = new EAttribute[] { MolicPackage.eINSTANCE
					.getConnection_Label() };
			MessageFormatParser parser = new MessageFormatParser(features);
			bRTUtteranceLabel_6002Parser = parser;
		}
		return bRTUtteranceLabel_6002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case SceneTopicEditPart.VISUAL_ID:
			return getSceneTopic_5004Parser();
		case SceneDialogueEditPart.VISUAL_ID:
			return getSceneDialogue_5005Parser();
		case UbiquitousAccessLabelEditPart.VISUAL_ID:
			return getUbiquitousAccessLabel_5007Parser();
		case UtteranceLabelEditPart.VISUAL_ID:
			return getUtteranceLabel_6001Parser();
		case BRTUtteranceLabelEditPart.VISUAL_ID:
			return getBRTUtteranceLabel_6002Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(MolicVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(MolicVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (MolicElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}
}
