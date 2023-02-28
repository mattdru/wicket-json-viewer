package de.catcode.jsonviewer;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

public class JsonViewerBehavior extends Behavior {

	private final WebMarkupContainer jsonViewer;
	private final IModel<String> jsonData;

	private final JsonViewerConfig config;

	public JsonViewerBehavior(final WebMarkupContainer jsonViewer, final JsonViewerConfig config, final IModel<String> jsonData) {
		this.jsonViewer = jsonViewer;
		this.config = config;
		this.jsonData = jsonData;
	}

	@Override
	public void renderHead(final Component component, final IHeaderResponse response) {
		super.renderHead(component, response);

		response.render(CssHeaderItem.forReference(JsonViewerCssResourceReference.INSTANCE));
		response.render(JavaScriptHeaderItem.forReference(JsonViewerJsResourceReference.INSTANCE));

		response.render(OnDomReadyHeaderItem.forScript("$('#" + jsonViewer.getMarkupId() + "').jsonViewer(" + jsonData.getObject() + ", " + config.toJson() + ");"));
	}
}
