package de.catcode.jsonviewer;

import org.apache.wicket.request.resource.CssResourceReference;

public class JsonViewerCssResourceReference extends CssResourceReference {

	public static final JsonViewerCssResourceReference INSTANCE = new JsonViewerCssResourceReference();

	private JsonViewerCssResourceReference() {
		super(JsonViewerCssResourceReference.class, "res/jquery.json-viewer.css");
	}
}
