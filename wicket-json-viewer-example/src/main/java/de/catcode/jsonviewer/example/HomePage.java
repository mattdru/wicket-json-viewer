package de.catcode.jsonviewer.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import de.catcode.jsonviewer.JsonViewer;

public class HomePage extends WebPage {

	public HomePage(final PageParameters parameters) {
		super(parameters);

		final IModel<String> jsonData = Model.of("");
		try (
			final InputStream is = getClass().getClassLoader().getResourceAsStream("generated.json");
			final BufferedReader reader = new BufferedReader(new InputStreamReader(is))
		) {
			jsonData.setObject(reader.lines().collect(Collectors.joining()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		final JsonViewer jsonViewer = new JsonViewer("jsonViewer", jsonData);
		jsonViewer.getConfig().rootCollapsable(false);
		add(jsonViewer);
	}
}
