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

    public GraphNode(GraphNode parent) {
        parent.children.add(this);
        indentationLevel = parent.getIndentationLevel() + 1;
        children = new ArrayList<>();
    }

    public void append(GraphNode child) {
        children.add(child);
        child.parent = this;
    }

    public void setText(String text) {
        this.text = text;
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

    public String toString() {
        return String.format("%s* %s", formatIndentation(), text);
    }

    public String printTree() {
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
