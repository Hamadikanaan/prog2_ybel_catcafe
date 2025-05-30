package tree;

/**
 * Visitor für PostOrder-Traversierung eines Binärbaums. Reihenfolge: Links → Rechts → Wurzel
 *
 * @param <T> parametric type of the binary search tree elements
 */
public class PostOrderVisitor<T extends Comparable<T>> implements TreeVisitor<T> {

    @Override
    public String visit(Empty<T> node) {
        return "";
    }

    @Override
    public String visit(Node<T> node) {
        // PostOrder: Links → Rechts → Wurzel
        String leftResult = node.leftChild().accept(this);
        String rightResult = node.rightChild().accept(this);
        String nodeData = node.data().toString();

        StringBuilder result = new StringBuilder();
        if (!leftResult.isEmpty()) result.append(leftResult);
        if (!rightResult.isEmpty()) {
            if (!result.isEmpty()) result.append(" ");
            result.append(rightResult);
        }
        if (!nodeData.isEmpty()) {
            if (!result.isEmpty()) result.append(" ");
            result.append(nodeData);
        }
        return result.toString();
    }
}
