package tree;

/**
 * Visitor für InOrder-Traversierung eines Binärbaums. Reihenfolge: Links → Wurzel → Rechts
 *
 * @param <T> parametric type of the binary search tree elements
 */
public class InOrderVisitor<T extends Comparable<T>> implements TreeVisitor<T> {
    @Override
    public String visit(Empty<T> node) {
        return "";
    }

    @Override
    public String visit(Node<T> node) {
        String leftResult = node.leftChild().accept(this);
        String nodeData = node.data().toString();
        String rightResult = node.rightChild().accept(this);

        StringBuilder result = new StringBuilder();
        if (!leftResult.isEmpty()) result.append(leftResult);
        if (!nodeData.isEmpty()) {
            if (!result.isEmpty()) result.append(" ");
            result.append(nodeData);
        }
        if (!rightResult.isEmpty()) {
            if (!result.isEmpty()) result.append(" ");
            result.append(rightResult);
        }
        return result.toString();
    }
}
