package ru.gnd;

import ru.gnd.graph.GraphNode;

public class App
{
    public static void main(String[] args)
    {
        GraphNode node = new GraphNode().setText("Hello!")
                .append(
                        new GraphNode().setText("How are you?")
                        .append(new GraphNode().setText("I'm fine!"))
                        .append(new GraphNode().setText("Oh, okay..."))
                ).append(
                        new GraphNode().setText("Why do u so angry?")
                        .append(new GraphNode().setText("Fuck off!"))
                );
        System.out.println(node.printTree());
    }
}
