package ru.gnd;

import ru.gnd.graph.GraphNode;

public class App
{
    public static void main(String[] args)
    {
        GraphNode node = new GraphNode();
        node.setText("Hello World!");
        GraphNode child = new GraphNode(node);
        child.setText("And you!");
        GraphNode childc = new GraphNode(child);
        childc.setText("Fuck YOU!");
        GraphNode child2 = new GraphNode(node);
        child2.setText("And you too!");
        GraphNode childc2 = new GraphNode(childc);
        childc2.setText("Hah!");
        System.out.println(node.printTree());
    }
}
