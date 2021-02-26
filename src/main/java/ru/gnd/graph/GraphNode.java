package ru.gnd.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    private static final int NO_INDENT = -1;

    private List<GraphNode> children;
    private GraphNode parent = this;
    private int indentationLevel = NO_INDENT;
    private String text = "";

    public GraphNode() {
        children = new ArrayList<>();
    }

    public GraphNode append(GraphNode child) {
        children.add(child);
        child.parent = this;
        child.indentationLevel = this.indentationLevel + 1;
        return this;
    }

    public GraphNode setText(String text) {
        this.text = text;
        return this;
    }

    public String getText() {
        return text;
    }

    private int getIndentationLevel() {
        return indentationLevel;
    }

    private String formatIndentation() {
        if (indentationLevel == NO_INDENT) return "";
        return "-".repeat(indentationLevel) + "|";
    }

    private GraphNode buildTree() {
        if (indentationLevel != NO_INDENT) return this;

        for (GraphNode child : children) {
            child.normalizeIndent();
        }
        return this;
    }

    private void normalizeIndent() {
        this.indentationLevel = parent.indentationLevel + 1;
        for (GraphNode child : children) {
            child.normalizeIndent();
        }
    }

    public String toString() {
        return String.format("%s* %s", formatIndentation(), text);
    }

    public String printTree() {
        buildTree();
        StringBuilder builder = new StringBuilder();
        builder.append(this + "\n");
        for (GraphNode child : children) {
            if (child.children.size() != 0) {
                builder.append(child.printTree());
            } else {
              builder.append(child + "\n");
            }
        }
        return builder.toString();
    }
}
