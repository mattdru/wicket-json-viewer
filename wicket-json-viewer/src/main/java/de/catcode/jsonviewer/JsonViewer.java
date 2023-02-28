package de.catcode.jsonviewer;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class JsonViewer extends GenericPanel<String> {

	private final JsonViewerConfig config;

	public JsonViewer(final String id) {
		this(id, Model.of());
	}

	public JsonViewer(final String id, final IModel<String> model) {
		super(id, model);

		this.config = new JsonViewerConfig();
		
		final WebMarkupContainer jsonViewer = new WebMarkupContainer("jsonViewer");
		jsonViewer.add(new JsonViewerBehavior(jsonViewer, config, model));
		add(jsonViewer);
	}

	public JsonViewerConfig getConfig() {
		return config;
	}
}
