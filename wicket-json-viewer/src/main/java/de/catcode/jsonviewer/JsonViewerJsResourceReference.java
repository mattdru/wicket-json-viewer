package de.catcode.jsonviewer;

import org.apache.wicket.resource.JQueryPluginResourceReference;

public class JsonViewerJsResourceReference extends JQueryPluginResourceReference {

	public static final JsonViewerJsResourceReference INSTANCE = new JsonViewerJsResourceReference();

	private JsonViewerJsResourceReference() {
		super(JsonViewerJsResourceReference.class, "res/jquery.json-viewer.js");
	}
}
