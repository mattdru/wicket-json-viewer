package de.catcode.jsonviewer;

public class JsonViewerConfig {

	private boolean collapsed;
	private boolean rootCollapsable = true; // default
	private boolean withQuotes;
	private boolean withLinks = true; // default
	private boolean bigNumbers; // for the present unsupported. Needs additional libraries

	public JsonViewerConfig() {
	}

	public JsonViewerConfig collapsed(final boolean collapsed) {
		this.collapsed = collapsed;
		return this;
	}

	public JsonViewerConfig rootCollapsable(final boolean rootCollapsable) {
		this.rootCollapsable = rootCollapsable;
		return this;
	}

	public JsonViewerConfig withQuotes(final boolean withQuotes) {
		this.withQuotes = withQuotes;
		return this;
	}

	public JsonViewerConfig withLinks(final boolean withLinks) {
		this.withLinks = withLinks;
		return this;
	}

	public String toJson() {
		return """
			{"collapsed": %s, "rootCollapsable": %s, "withQuotes": %s, "withLinks": %s}
			""".formatted(collapsed, rootCollapsable, withQuotes, withLinks);
	}

	@Override
	public String toString() {
		return "JsonViewerConfig{" +
			"collapsed=" + collapsed +
			", rootCollapsable=" + rootCollapsable +
			", withQuotes=" + withQuotes +
			", withLinks=" + withLinks +
			", bigNumbers=" + bigNumbers +
			'}';
	}
}
